package mini_projet;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



public class Test extends JFrame implements ActionListener {

	JLabel L1=new JLabel("**Bienvenu à cette Version d'essai** ");	
	JLabel L2=new JLabel("          Veuillez choisir l'interface à tester : ");
	
	JButton b1=new JButton("User");
	JButton b2=new JButton("Admin");
	JButton b3=new JButton("Quitter");
	
	JPanel pan=new JPanel();
	JPanel pan1=new JPanel();
	JPanel pan2=new JPanel();
	JPanel pan3=new JPanel();



public Test()  {
	
	L1.setFont(new Font("Tahoma", Font.BOLD ,20));
	L2.setFont(new Font("Tahoma", Font.BOLD , 15));
	
	pan1.setLayout(new GridLayout(2,1,10,10));
	pan1.add(L1);
	pan1.add(L2);
	
	pan2.setLayout(new GridLayout(1,2,10,10));
	pan2.setSize(100,100);
	pan2.add(b1);
	pan2.add(b2);
	 pan2.setBorder(new EmptyBorder(20, 20, 20, 20));
	pan3.add(b3);
	
	pan.setLayout(new BoxLayout(pan,BoxLayout.Y_AXIS));
	
	pan.add(pan1 );
	pan.add(Box.createVerticalGlue());
	pan.add(pan2);
	pan.add(Box.createVerticalStrut(80));
	
	pan.add(pan3);
	
	
	this.add(pan);
	setSize(400,300);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setResizable(false);
	
	

	b3.addActionListener(new ActionListener()
    {public void actionPerformed (ActionEvent e)
	{ dispose();
   	 }
	});

	b1.addActionListener(new ActionListener()
    {public void actionPerformed (ActionEvent e)
	{ new User_interface();
   	 }
	});

	b2.addActionListener(new ActionListener()
    {public void actionPerformed (ActionEvent e)
	{ new Admin_interface();
   	 }
	});
	setVisible(true);
	
	}


public static void main(String[] args) {
	Test f = new Test();

}


@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}}
