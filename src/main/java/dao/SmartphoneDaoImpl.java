package dao;
import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.util.ArrayList; 
import java.util.List; 
import metier.entities.Smartphone;
public class SmartphoneDaoImpl  implements ISmartphoneDao {
	 @Override 
	 public Smartphone save(Smartphone s) { 
	   Connection conn=SingletonConnection.getConnection(); 
	   try { 
		    PreparedStatement ps= conn.prepareStatement("INSERT INTO 
		 smartphone(modele,prix) VALUES(?,?)"); 
		    ps.setString(1, s.getModele()); 
		 ps.setDouble(2, s.getPrix()); 
		 ps.executeUpdate(); 
		 PreparedStatement ps2= conn.prepareStatement("SELECT MAX(id) as MAX_ID FROM smartphone"); 
		 ResultSet rs =ps2.executeQuery(); 
		if (rs.next()) { 
		s.setId(rs.getLong("MAX_ID")); 
		} 
		ps.close(); 
		ps2.close();
		}catch (SQLException e) { 
		    e.printStackTrace(); 
		    } 
		    return s; 
	 }
	 @Override
	 public List<Smartphone> smartsParMC(String mc) { 
	     List<Smartphone> smarts= new ArrayList<Smartphone>(); 
	     Connection conn=SingletonConnection.getConnection(); 
	     try { 
	     PreparedStatement ps= conn.prepareStatement("select * from smartphone where modele LIKE ?"); 
	     ps.setString(1, "%"+mc+"%"); 
	     ResultSet rs = ps.executeQuery(); 
	     while (rs.next()) { 
	     Smartphone s= new Smartphone(); 
	     s.setId(rs.getLong("id")); 
	     s.setModele(rs.getString("modele")); 
	     s.setPrix(rs.getDouble("prix")); 
	     smarts.add(s);      
	     } 
	     } catch (SQLException e) { 
	     e.printStackTrace(); 
	     } 
	     return smarts; 
	     } 
	 @Override 
	 public Smartphone getSmartphone(Long id) { 
	 Connection conn=SingletonConnection.getConnection(); 
	 Smartphone s= new Smartphone(); 
	 try { 
	     PreparedStatement ps= conn.prepareStatement("select * from 
	     smartphone where id = ?"); 
	     ps.setLong(1, id); 
	     ResultSet rs = ps.executeQuery(); 
	     if  (rs.next()) { 
	     s.setId(rs.getLong("id")); 
	     s.setMarque(rs.getString("marque")); 
	     s.setModele(rs.getString("modele")); 
	     s.setRam(rs.getString("ram")); 
	     s.setStockage(rs.getString("stockage")); 
	     s.setPrix(rs.getDouble("prix")); 
	     } } catch (SQLException e) { 
	         e.printStackTrace(); 
	         } 
	     } 
	         return s; 
	     }
import java.sql.Connection;

@Override 
public SMartphone updateSmartphone(SMartphone s) {
    Connection conn=SingletonConnection.getConnection(); 
    try { 
        PreparedStatement ps= conn.prepareStatement("UPDATE smartphone 
     SET modele=?,prix=? WHERE id=?"); 
        ps.setString(1, s.getModele()); 
        ps.setDouble(2, s.getPrix()); 
        ps.setLong(3, s.getId()); 
        ps.executeUpdate(); 
        ps.close(); 
           
       } catch (SQLException e) { 
         
        e.printStackTrace(); 
       } 
       return p; 
}
@Override 
 public void deleteSmartphone(Long id) { 
   Connection conn=SingletonConnection.getConnection(); 
        try { 
   PreparedStatement ps= conn.prepareStatement("DELETE FROM 
smartphone WHERE id = ?"); 
   ps.setLong(1, id); 
   ps.executeUpdate(); 
   ps.close(); 
  } catch (SQLException e) { 
    
   e.printStackTrace(); 
  } 
}
