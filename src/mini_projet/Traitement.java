package mini_projet;
import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;



import java.util.Date;
import java.util.HashMap;


public class Traitement {
	
	Connection connection;
	
	public Traitement(Connection connect) {
        connection = connect;}
	
	
	public void AddHotel(String n,String ad)
	{
		String sql="insert into hotel(Nom,Adresse) values(?,?)";
		try {
		PreparedStatement pst=connection.prepareStatement(sql);
		pst.setString(1, n);
		
		pst.setString(2, ad);
		pst.execute();
		
	}
		catch(Exception exp) {
			System.out.println(exp);
		}
		
	}
	
	public List<String> liste_nom() {
		List<String> l=new ArrayList<>();
		String sql = "SELECT Nom FROM hotel";
        try {
            
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet res = pst.executeQuery();
            
            while (res.next()) {
                
               l.add(res.getString("Nom"));}
        } catch (Exception e) {
            System.err.println(e);
        }
        return l;
    }
	
	public List<String> liste_nom_record() {
		List<String> l=new ArrayList<>();
		String sql = "SELECT DISTINCT Nom_hotel FROM record";
        try {
            
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet res = pst.executeQuery();
            
            while (res.next()) {
                
               l.add(res.getString("Nom_hotel"));}
        } catch (Exception e) {
            System.err.println(e);
        }
        return l;
    }
	
	public boolean rechercher(String nom) {
		boolean l=false;
		String sql = "SELECT * FROM hotel where Nom = ?";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, nom);
            ResultSet res = pst.executeQuery();
            
            	l=res.next();
            
            
        } catch (Exception e) {
            System.err.println(e);
        }
        return l  ;
    }
	
	public HashMap<Date, Integer> data(String s,String c,String year) {
		HashMap<Date,Integer> l=new HashMap<>();
		String sql = "SELECT Time,"+c+" FROM record WHERE Nom_hotel = ? AND YEAR(Time) = ?";
        try {
            
            PreparedStatement pst = connection.prepareStatement(sql);
           
            //pst.setString(1,"sec");
    		pst.setString(1,s);
    		pst.setInt(2,Integer.parseInt(year));
            ResultSet res = pst.executeQuery();
            
            while (res.next()) {
            	Date d=new Date((res.getTimestamp(1)).getTime());
               int x=res.getInt(2);
               l.put(d, x);
               
                }
        } catch (Exception e) {
            System.err.println(e);
        }
        return l;
    }
	
	
	
	public void Addrecord(Date date,String nom,int x1,int x2,int x3,int x4,int x5,int x6,int x7)
	{
		String sql="insert into record(Time,Nom_hotel,Confort,Sécurité,Animation,Propreté,Service,Restauration,Prix) values(?,?,?,?,?,?,?,?,?)";
		try {
		PreparedStatement pst=connection.prepareStatement(sql);
		pst.setTimestamp(1, new java.sql.Timestamp(new Date().getTime()));
		pst.setString(2, nom);
		pst.setInt(3, x1);
		pst.setInt(4, x2);
		pst.setInt(5, x3);
		pst.setInt(6, x4);
		pst.setInt(7, x5);
		pst.setInt(8, x6);
		pst.setInt(9, x7);
		pst.execute();
		
	}
		catch(Exception exp) {
			System.out.println(exp);
		}
		
	}
	
	public List<String> get_years(){
		List<String> l=new ArrayList<>();
		String sql = "SELECT DISTINCT YEAR(Time) AS year FROM record ";
        try {
            
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet res = pst.executeQuery();
            
            while (res.next()) {
                
               l.add(res.getString("year"));}
        } catch (Exception e) {
            System.err.println(e);
        }
        return l;
		
	}
	public void DeleteHotel(String nom)
	{
		String sql="DELETE FROM hotel WHERE Nom = ? ";
		String sql1="DELETE FROM record WHERE Nom_hotel = ? ";
		try {
		PreparedStatement pst=connection.prepareStatement(sql);
		PreparedStatement pst1=connection.prepareStatement(sql1);
		pst.setString(1, nom);
		pst1.setString(1, nom);
		
		pst.execute();
		pst1.execute();
	}
		catch(Exception exp) {
			System.out.println(exp);
		}
		
	}
	
	 

	
	
}
