import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class MainFrame extends JFrame{
	
	private JTextField cField;
	private JTextField fField;
	private JButton convertButton;
	private JCheckBox isC;
	
	public MainFrame(){
		super("Temp Converter");

		setLayout(new GridBagLayout());
		
		cField = new JTextField("0 °C",10);
		fField = new JTextField("33.8 °F",10);
		JLabel cLabel = new JLabel("Celsius");
		JLabel fLabel = new JLabel("Fahrenheit");
		JLabel isCLabel = new JLabel("Is C?");
		
		isC = new JCheckBox();
		convertButton = new JButton("Convert");
		convertButton.setPreferredSize(new Dimension(80,39));
		convertButton.addActionListener(ae -> {convert();});
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.insets = new Insets(3,3,3,3);;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(cLabel, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		add(cField, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;		
		add(fLabel, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;		
		add(fField, gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 0;
		gbc.gridheight = 2;
		gbc.gridwidth = 2;
		add(convertButton, gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 2;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		add(isC, gbc);
		
		gbc.gridx = 4;
		gbc.gridy = 2;
		add(isCLabel, gbc);			
		
		//setSize(500,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
	private void convert(){
		if(isC.isSelected()){
			TempEngine.convertCelsius(parse());
		}else{
			TempEngine.convertFahrenheit(parse());
		}
	}
	
	private double parse(){
		
	}
	
}