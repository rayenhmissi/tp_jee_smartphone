package metier.entities; // Adjust the package as needed

import java.io.Serializable;
import java.util.List;

import metier.entities.Smartphone;
public class SmartphoneModele implements Serializable {
    private List<Smartphone> smarts;
    private String motCle;
    
    public SmartphoneModele() {
        super();
    }
    
    public String getMotCle() {
        return motCle;
    }
    
    public void setMotCle(String motCle) {
        this.motCle = motCle;
    }
    
    public List<Smartphone> getSmarts() {
        return smarts;
    }
    
    public void setSmarts(List<Smartphone> smarts) {
        this.smarts = smarts;
    }
}