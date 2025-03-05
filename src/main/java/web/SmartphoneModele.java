package web;
import java.util.ArrayList;
import java.util.List;

import metier.Smartphone;

public class SmartphoneModele {
    private String motCle; 
 List<Smartphone> smarts = new ArrayList<>();
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
