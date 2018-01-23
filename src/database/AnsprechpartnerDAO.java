package database;

import java.util.List;

import javax.persistence.EntityManager;

import model.Ansprechpartner;

public class AnsprechpartnerDAO
{
   private EntityManager em;

   /**
    * gets the instance of the entitymanager needed.
    */
   public AnsprechpartnerDAO()
   {
      em = EntityManagerSingleton.getInstance();
   }

   public List<Ansprechpartner> findallAnsprechpartner()
   {

      return em.createQuery("select a from Ansprechpartner a",
            Ansprechpartner.class).getResultList();
   }

}
