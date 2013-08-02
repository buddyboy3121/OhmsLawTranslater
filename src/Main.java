
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Main extends JApplet{
	
	private JLabel text;
	private JTextField one, two;
	private JRadioButton checks[] = {new JRadioButton("Solve for volts."), new JRadioButton("Solve for Amps."), new JRadioButton("Solve for Ohm's.")};
	private JButton t;
	
	private double total = 0;
	private int selected = 0;

	//init
	public void init(){
		int i = 0;		

		setLayout(null);
		
		text = new JLabel("Ohm's law translater.");
		text.setBounds(0,0,200,25);
		add(text);
		
		ButtonGroup b = new ButtonGroup();
		
		for(JRadioButton x: checks){	
			b.add(x);
			x.setBounds(i, 25, 150,25);
			add(x);
			x.addActionListener(new Action());
			
			i+=150;
		}
		checks[1].setSelected(true);
		
		one = new JTextField("Volts");
		one.setBounds(0, 50, 150, 25);
		add(one);
		
		two = new JTextField("Ohm's");
		two.setBounds(265, 50, 150, 25);
		add(two);
		
		t = new JButton("Translate.");
		t.setBounds(0, 100, 415, 24);
		t.addActionListener(new Action());
		t.setRolloverEnabled(true);
		add(t);
		
	}
	
	private class Action implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			String vri = null;
			
			if(e.getSource()==t){
				
				  try{
				  aOne = Integer.parseInt(one.getText());
				  aTwo = Integer.parseInt(two.getText());
				  }catch(Exception exeption){
					  text.setText("Please enter numbers.");
					  
					  return;
				  }
					
				  if(selected==1){
					  total = aOne * aTwo;
				  }else if(selected==2){
					  total = aOne / aTwo;
				  }else if(selected==3){
					  total = aOne / aTwo;
				  }
				  
				  text.setText("Your awnser is: " + total);
				  
				  return;
				}
			
			if(checks[0].isSelected()){
				one.setText("Amps");
				two.setText("Ohm's");
				
				selected=1;
			}
			else if(checks[1].isSelected()){
				one.setText("Volts");
				two.setText("Ohm's");
				
				selected=2;
			}
			else if(checks[2].isSelected()){
				one.setText("Volts");
				two.setText("Amps");
				
				selected=3;
			}
			
			
		}
	}
	double aOne = 0;
	double aTwo = 0;
}
