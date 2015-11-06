import java.math.BigDecimal;
import java.math.MathContext;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TempEngine {
    public static void convert (boolean isC,JTextField cField, JTextField fField, JFrame frame){
    	if(isC){
    		try {
				double c = parse(true,cField);
				fField.setText(convertCelsius(c)+ " °F");
			} catch (NumberFormatException e) {
    			System.out.println("number error");
    			JOptionPane.showMessageDialog(frame, "Please enter just a number, no letters.","Error",JOptionPane.WARNING_MESSAGE);
			} catch(StringIndexOutOfBoundsException e){
				System.out.println("index error");
    			double c = parse(false,cField);
    			fField.setText(convertCelsius(c)+ " °F");
    			cField.setText(cField.getText() + " °C");
    		}
    	}else{
    		try {
    			double c = parse(true,fField);
    			cField.setText(convertFahrenheit(c) + " °C");
    		} catch(NumberFormatException e) {
    			System.out.println("number error");
    			JOptionPane.showMessageDialog(frame, "Please enter just a number, no letters.","Error",JOptionPane.WARNING_MESSAGE);
    		} catch(StringIndexOutOfBoundsException e){
    			System.out.println("index error");
    			double c = parse(false,fField);
    			cField.setText(convertFahrenheit(c) + " °C");
    			fField.setText(fField.getText()+ " °F");
    		}
        }
    }
    
    private static double parse(boolean noError, JTextField field){
		if(noError){
			String text = field.getText();
			String toParse = text.substring(0,text.length() - 3);
			Double c = Double.parseDouble(toParse);
			return c;
		} else {
			String toParse = field.getText();
			Double c = Double.parseDouble(toParse);
			return c;
		}
    }
    
    public static String convertCelsius(double t){
    	double convertFigure = ((t*9)/5)+32;	//convert celsius to fahrenheit
    	convertFigure = toThreeSF(convertFigure);
    	return String.valueOf(convertFigure);
    }
    
    public static String convertFahrenheit(double t){
    	double convertFigure = ((t-32)*5)/9;
    	convertFigure = toThreeSF(convertFigure);
    	return String.valueOf(convertFigure);	//convert fahrenheit to celsius
    }
    
    private static double toThreeSF(double d){
       	BigDecimal bd = new BigDecimal(d);
    	bd = bd.round(new MathContext(3));
    	return bd.doubleValue();    	
    }
}
