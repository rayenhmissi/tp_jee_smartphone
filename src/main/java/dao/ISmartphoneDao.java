package dao;
import java.util.List;
import metier.entities.Smartphone;
public interface ISmartphoneDao {
 public Smartphone save(Smartphone s); 
public List<Smartphone> smartsParMC(String mc); 
public  Smartphone getSmartphone(Long id); 
public Smartphone updateSmartphone(Smartphone s); 
public void deleteSmartphone(Long id);     
}