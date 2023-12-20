package mini_projet;

import java.awt.BorderLayout; 
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.util.List;
import java.util.Date;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class User_interface extends JFrame implements ActionListener,KeyListener,FocusListener {
	Connexion connexion = new Connexion();
    Connection connection = connexion.getConnect();
    Traitement trait = new Traitement(connection);
    
    

	JLabel L1=new JLabel("                                       Bienvenue à cette enquête ");	
	JLabel L2=new JLabel("      Confort: ");
	JLabel L3=new JLabel("      Sécurité: ");
	JLabel L4=new JLabel("      Animation: ");
	JLabel L5=new JLabel("      Propreté: ");
	JLabel L6=new JLabel("      Service: ");
	JLabel L7=new JLabel("      Restauration: ");
	JLabel L8=new JLabel("      Prix: ");
	JLabel L9=new JLabel(" Hotel: ");
	JLabel L10=new JLabel(" Nom_Hotel: ");
	JLabel L11=new JLabel(" Adresse_Hotel: ");
	
	JTextField txt2=new JTextField("commenter ici ...");
	JTextField txt3= new JTextField("commenter ici ...");
	JTextField txt4= new JTextField("commenter ici ...");
	JTextField txt5=new JTextField("commenter ici ...");
	JTextField txt6= new JTextField("commenter ici ...");
	JTextField txt7= new JTextField("commenter ici ...");
	JTextField txt8= new JTextField("commenter ici ...");
	JTextField txt10= new JTextField(20);
	JTextField txt11= new JTextField(20);
	
	JLabel vide1=new JLabel("       ");
	JLabel vide2=new JLabel("       ");
	JLabel vide3=new JLabel("       ");
	JLabel vide4=new JLabel("       ");
	JLabel vide5=new JLabel("       ");
	JLabel vide6=new JLabel("       ");
	JLabel vide7=new JLabel("       ");
	JLabel vide8=new JLabel("       ");
	
	List<String> list_hotel=trait.liste_nom();
     JComboBox<String> Sp=new JComboBox<String>(list_hotel.toArray(new String[0]));
		
	//List.of("Hôtel Étoile d'Or","Grand Palace Hôtel","Oasis Resort & Spa","Horizon Heights Inn","Charme Suites","Riviera Retreat");
	
	
	JButton b1=new JButton("Add");
	JButton b2=new JButton("Soumettre");
	JButton b3= new JButton("Annuler");
	JButton aj=new JButton("Ajouter");
	JButton anl=new JButton("Annuler");
	
	JSlider S2 = new JSlider(JSlider.HORIZONTAL, 0, 5, 2);
	JSlider S3 = new JSlider(JSlider.HORIZONTAL, 0, 5, 2);
	JSlider S4 = new JSlider(JSlider.HORIZONTAL, 0, 5, 2);
	JSlider S5 = new JSlider(JSlider.HORIZONTAL, 0, 5, 2);
	JSlider S6 = new JSlider(JSlider.HORIZONTAL, 0, 5, 2);
	JSlider S7 = new JSlider(JSlider.HORIZONTAL, 0, 5, 2);
	JSlider S8 = new JSlider(JSlider.HORIZONTAL, 0, 5, 2);
	
	JSlider[] list={S2,S3,S4,S5,S6,S7,S8};
	JLabel[] list1= {L2,L3,L4,L5,L6,L7,L8};
	JTextField[] list2= {txt2,txt3,txt4,txt5,txt6,txt7,txt8};
	JLabel[]list3= {vide1,vide2,vide3,vide4,vide5,vide6,vide7,vide8};
	
	JPanel dial=new JPanel();
	 JDialog dg=new JDialog();
	
	JPanel principal=new JPanel();
	JPanel pan1=new JPanel();
	JPanel pan2=new JPanel(new BorderLayout(10,20));
	public User_interface() {
		
       
		pan1.setLayout(new GridLayout(15,2,10,10));
        for (int i=0;i<7;i++) {
            list[i].setMajorTickSpacing(1);
            list[i].setPaintTicks(true);
            list[i].setPaintLabels(true);
            list[i].setPaintTrack(true);
            pan1.add(list1[i]);
            pan1.add(list[i]);
            pan1.add(list3[i]);
            pan1.add(list2[i]);}
        pan1.add(b2);
        pan1.add(b3);
        
       
        pan2.add(L1,BorderLayout.NORTH);  
		pan2.add(Sp,BorderLayout.CENTER);
		pan2.add(L9,BorderLayout.WEST);
		pan2.add(b1,BorderLayout.EAST);
		
		
        
		principal.setLayout(new BoxLayout(principal,BoxLayout.Y_AXIS));
		principal.setSize(100,100);
		principal.add(pan2);
		principal.add(Box.createVerticalStrut(30));
		principal.add(pan1);
		
		
		JScrollPane span2=new JScrollPane(principal);
		this.add(span2);
		this.setSize(500,400);
		this.setLocationRelativeTo(null);
    	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	this.setResizable(false);
		
		//pack();
    	b1.addActionListener(new add());
    	b2.addActionListener(new add_record());
    	for(JTextField txt:list2) {
    	txt.addKeyListener(new undo());
    	txt.addFocusListener(new focus());}
    	
    	b3.addActionListener(new ActionListener()
        {public void actionPerformed (ActionEvent e)
    	{ dispose();
       	 }
    	});
		setVisible(true);
		
		
		
		
	}
	
	
	
	
	 class add implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				
		    	 JPanel x=new JPanel(new GridLayout(3,2,10,10));
		    	 x.add(L10);
		    	 x.add(txt10);
		    	 x.add(L11);
		    	 x.add(txt11);
		    	 x.add(aj);
		    	 x.add(anl);
		    	 dg.add(x);
		    	 dg.setSize(300, 200);
		         dg.setLocationRelativeTo(null);
		         pack();
		         aj.addActionListener(new ActionListener()
			        {public void actionPerformed (ActionEvent e)
			    	{ String n = txt10.getText();
			    	 String p = txt11.getText();
			    	 trait.AddHotel(n, p);
			    	 Sp.addItem(n);
			    	 JOptionPane.showMessageDialog(null,"opération réussie!!!");
			    	 dg.dispose();
			       	 }
			    	});
		    	 anl.addActionListener(new ActionListener()
			        {public void actionPerformed (ActionEvent e)
			    	{ dg.dispose();
			       	 }
			    	});
		         dg.setVisible(true);
		    	 
			}
		}
	
	 class add_record implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
		    	 trait.Addrecord(new Date(),(String)Sp.getSelectedItem(),S2.getValue(), S3.getValue(),S4.getValue(),S5.getValue(),S6.getValue(),S7.getValue(),S8.getValue());
		    	 JOptionPane.showMessageDialog(null,"Merci pour votre contribution!!!");
			}
		}
	 class undo implements KeyListener{

		@Override
		 public void keyTyped(KeyEvent e) {
           
        }

		@Override
		public void keyPressed(KeyEvent e) {
			 if (e.getKeyCode() == KeyEvent.VK_Z)   {
			 Component source = (Component) e.getSource();
             if (source instanceof JTextField) {
                 ((JTextField) source).setText("");
             }
	            }
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
	 
	 }
	 class focus implements FocusListener{
		 @Override
         public void focusGained(FocusEvent e) {
			 Component source = (Component) e.getSource();
             if (((JTextField) source).getText().equals("commenter ici ...")) {
            	 ((JTextField) source).setText("");
             }
         }

         @Override
         public void focusLost(FocusEvent e) {
        	 Component source = (Component) e.getSource();
        	 if (((JTextField) source).getText().isEmpty()) {
            	 ((JTextField) source).setText("commenter ici ...");
             }
	 }}
	
	 
	 
	
	 
	 
	public static void main(String[] args) {
		User_interface f=new User_interface();

	}









	









	




















	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}}
