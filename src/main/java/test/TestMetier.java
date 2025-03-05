import java.util.List;

import dao.SmartphoneDaoImpl;
import metier.entities.Smartphone;

public class TestMetier {
    public static void main(String[] args) { 
   SmartphoneDaoImpl sm= new SmartphoneDaoImpl(); 
   Smartphone s= sm.save(new Smartphone("iphone 16",5000)); 
   System.out.println(s); 
    
    List<Smartphone> smarts =s.smartphoneParMC("iph"); 
    for (Smartphone s : smarts) 
     System.out.println(s); 
    
  }
}