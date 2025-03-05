package metier.entities;
import java.io.Serializable;
public class Smartphone implements Serializable{
    private Long id; 
    private String marque; 
    private String modele; 
    private int ram; 
    private int stockage; 
    private double prix; 
     
    public Smartphone() { 
     super(); 
    } 
    public Smartphone(Long id, String marque, String modele, int ram, int stockage, double prix) {
        this.id = id;
        this.marque = marque;
        this.modele = modele;
        this.ram = ram;
        this.stockage = stockage;
        this.prix = prix;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getMarque() {
        return marque;
    }
    public void setMarque(String marque) {
        this.marque = marque;
    }
    public String getModele() {
        return modele;
    }
    public void setModele(String modele) {
        this.modele = modele;
    }
    public int getRam() {
        return ram;
    }
    public void setRam(int ram) {
        this.ram = ram;
    }
    public int getStockage() {
        return stockage;
    }
    public void setStockage(int stockage) {
        this.stockage = stockage;
    }
    public double getPrix() {
        return prix;
    }
    public void setPrix(double prix) {
        this.prix = prix;
    }
}
