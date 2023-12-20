package mini_projet;

import java.awt.Component; 
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class Admin_interface extends JFrame {

	Connexion connexion = new Connexion();
    Connection connection = connexion.getConnect();
    Traitement trait = new Traitement(connection);
    
    JFrame principal=new JFrame();
    JPanel panal=new JPanel();
    
    JLabel L1=new JLabel("Veuillez Inserer le nom de l'hotel à rechercher: ");	
	JLabel L2=new JLabel("      Critère: ");
	JLabel L22=new JLabel("      Hotel: ");
	JLabel L10=new JLabel(" Nom_Hotel: ");
	JLabel L11=new JLabel(" Adresse_Hotel: ");
	JLabel L20=new JLabel(" Veuillez choisir l'hotel à supprimer: ");
	
	JTextField txt2=new JTextField(20);
	JTextField txt1= new JTextField(20);
	JTextField txt10= new JTextField(20);
	JTextField txt11= new JTextField(20);
	
	JButton b1=new JButton("Afficher");
	JButton b2=new JButton("Rechercher");
	JButton b3=new JButton("Supprimer");
	JButton b4=new JButton("Quitter");
	JButton aj=new JButton("Ajouter");
	JButton anl=new JButton("Annuler");
	
	List<String> list_Critere = List.of("Confort", "Sécurité", "Animation", "Propreté","Service","Restauration","Prix");
    JComboBox<String> Sp1=new JComboBox<String>(list_Critere.toArray(new String[0]));
    List<String> list_hotel=trait.liste_nom_record();
    JComboBox<String> Sp=new JComboBox<String>(list_hotel.toArray(new String[0]));
    
    List<String> list_hotel2=trait.liste_nom();
    JComboBox<String> Sp2=new JComboBox<String>(list_hotel2.toArray(new String[0]));
    JPanel pan=new JPanel(new GridLayout(3,2,50,50));
    JPanel pan1=new JPanel(new GridLayout(3,2,80,80));
    JPanel pan2=new JPanel(new GridLayout(3,2,80,80));
    JMenuBar bar = new JMenuBar();
	JMenu menu1 = new JMenu("Controle");
	JMenu menu2 = new JMenu("Visualisation");
	JMenuItem insert = new JMenuItem("Inserer");
    JMenuItem rech = new JMenuItem("Rechercher");
    JMenuItem supp = new JMenuItem("Supprimer");
    
    
    //Fonction pou assurer les transitions entres les menus
    private void afficherPanel(JPanel panel) {
        panal.removeAll();
        panal.add(panel);
        principal.revalidate();
        principal.repaint();
    }
	
    public Admin_interface() {
    	
    	
    //creation d'un jcombobox d'une maniere dynamique	
    for(String s:trait.get_years())
    	{JMenuItem x=new JMenuItem(s);
    	x.addActionListener(new vis());
    	menu2.add(x);}
    	
    	
    menu1.add(insert);
	menu1.add(rech);
	menu1.add(supp);
	bar.add(menu1);
	bar.add(menu2);
    
    principal.setJMenuBar(bar);
    principal.getContentPane().add(panal);
	principal.setSize(500,350);
	principal.setLocationRelativeTo(null);
	principal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	principal.setResizable(false);
	
	insert.addActionListener(new add());
	rech.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	
        	pan1.add(L1);
			pan1.add(txt1);
			pan1.add(b2);
			afficherPanel(pan1);
			b2.addActionListener(new ActionListener() {
		        @Override
		        public void actionPerformed(ActionEvent e) {
		        	String s=txt1.getText();
		        	
		        	if(trait.rechercher(s))
		        		JOptionPane.showMessageDialog(null,"Cet hotel existe dans la base");
		        	else
		        		JOptionPane.showMessageDialog(null,"Cet hotel n'existe pas dans la base");
		        }
		    });
        }
    });
	supp.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	
        	pan2.add(L20);
			pan2.add(Sp2);
			pan2.add(b3);
			afficherPanel(pan2);
			b3.addActionListener(new ActionListener() {
		        @Override
		        public void actionPerformed(ActionEvent e) {
		        	String s=(String)Sp2.getSelectedItem();
		        	trait.DeleteHotel(s);
		        	Sp2.removeItem(Sp2.getSelectedItem());
		        	JOptionPane.showMessageDialog(null,"opération réussie");
		        	
		        }
		    });
        }
    });
	principal.setVisible(true);
    }
	
	
	
	
	
	
	
	
	
	
    class vis implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String year=((Component) e.getSource()).toString();
			String x=year.substring(year.indexOf("text=")+5, year.indexOf("text")+9);
			JPanel pan3=new JPanel(new GridLayout(3,2,80,80));
			pan3.setBorder(new EmptyBorder(10, 10, 10, 10));
			pan3.add(L22);
			pan3.add(Sp);
			pan3.add(L2);
			pan3.add(Sp1);
			pan3.add(b1);
			pan3.add(b4);
	    	afficherPanel(pan3);
	    	pack();
	    	b1.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	String nom=(String)Sp.getSelectedItem();
	            	String c=(String)Sp1.getSelectedItem();
	            	HashMap<Date, Integer> l=trait.data(nom,c,x);
	    	    	new Graphic(l);
	            }
	        });
	    	b4.addActionListener(new ActionListener()
	        {public void actionPerformed (ActionEvent e)
	    	{ principal.dispose();
	       	 }
	    	});
	    	
	    
	    	
	    	
		}
	}
	
    class add implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			 
			 
	    	 pan.add(L10);
	    	 pan.add(txt10);
	    	 pan.add(L11);
	    	 pan.add(txt11);
	    	 pan.add(aj);
	    	 pan.add(anl);
	    	 afficherPanel(pan);
	    	
	         pack();
	         aj.addActionListener(new ActionListener()
		        {public void actionPerformed (ActionEvent e)
		    	{ String n = txt10.getText();
		    	 String p = txt11.getText();
		    	 trait.AddHotel(n, p);
		    	 Sp2.addItem(n);
		    	 JOptionPane.showMessageDialog(null,"opération réussie!!!");
		    	 txt10.setText("");
			    	txt11.setText("");
		    	
		       	 }
		    	});
	    	 anl.addActionListener(new ActionListener()
		        {public void actionPerformed (ActionEvent e)
		    	{ txt10.setText("");
		    	txt11.setText("");
		       	 }
		    	});
	        
	    	 
		}
	}
	public static void main(String[] args) {
		Admin_interface f=new Admin_interface();

	}
}
