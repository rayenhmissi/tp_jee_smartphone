package metier.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SMARTPHONES")
public class Smartphone implements Serializable {

    @Id
    @Column(name = "ID_SMARTPHONE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "MODELE_SMARTPHONE")
    private String modele;

    @Column(name = "MARQUE")
    private String marque;

    @Column(name = "RAM")
    private int ram;

    @Column(name = "STOCKAGE")
    private int stockage;

    @Column(name = "PRIX")
    private double prix;

    public Smartphone() {
    }

    public Smartphone(String modele, String marque, int ram, int stockage, double prix) {
        this.modele = modele;
        this.marque = marque;
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

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
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