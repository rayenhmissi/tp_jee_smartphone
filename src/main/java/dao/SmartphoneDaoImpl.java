package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import metier.entities.Smartphone;
import util.JPAutil;

public class SmartphoneDaoImpl implements ISmartphoneDao { 

    private EntityManager entityManager=JPAutil.getEntityManager ("TP5_JEE");

    @Override
    public Smartphone save (Smartphone s) { 
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(s); // Remplacer p par s
        tx.commit();
        return s;
    }


    @Override
    public Smartphone getSmartphone(Long id) {
        return entityManager.find(Smartphone.class, id); 
    }
    @Override
    public List<Smartphone> smartphonesParMC(String mc) {
        List<Smartphone> smartphones =entityManager.createQuery("select s from Smartphone s where s. :mc").setParameter("mc", "%"+mc+"%").getResultList()
        return smartphones;
    }

    @Override
    public Smartphone updateSmartphone (Smartphone s) { 
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.merge(s); // Remplacer p par s
        tx.commit();
        return s;
    }

    @Override
    public void deleteSmartphone (Long id) {
        Smartphone smartphone = entityManager.find(Smartphone.class, id); 
        entityManager.getTransaction().begin();
        entityManager.remove(smartphone);
        entityManager.getTransaction().commit();
    }
}