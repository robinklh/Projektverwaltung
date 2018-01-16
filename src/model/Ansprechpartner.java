package model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Ansprechpartner für ein Projekt. Kann Dozent der Hochschule oder externer
 * Partner aus der Industrie sein.
 */
@Entity
public class Ansprechpartner
{

   @Id
   @GeneratedValue
   private Integer ansprechpartner_id;

   @Column
   private String nachname;

   @Column
   private String vorname;

   @Column
   private String mail;

   @ManyToOne(optional = true)
   @JoinColumn(name = "organisation_id")
   private Organisation organisation;

   @OneToMany(mappedBy = "ansprechpartner")
   private Collection<Projekt> projekte;

   @SuppressWarnings("unused")
   private Ansprechpartner()
   {
      // Hier gibt es nichts zu sehen
   }

   public Ansprechpartner(String vorname, String nachname, String contact)
   {
      if (nachname == null || nachname.isEmpty())
      {
         throw new IllegalArgumentException("Ungültiger Nachname.");
      }
      if (vorname == null || vorname.isEmpty())
      {
         throw new IllegalArgumentException("Ungültiger Vorname.");
      }

      this.mail = contact;
      this.vorname = vorname;
      this.nachname = nachname;
      this.projekte = new ArrayList<Projekt>();
   }

   // Setter Getter Name
   public String getNachname()
   {
      return nachname;
   }

   public void setNachname(String name)
   {
      if (name == null || name.isEmpty())
      {
         throw new IllegalArgumentException("Ungültiger name");
      }

      this.nachname = name;
   }

   // Setter Getter Organisation
   public Organisation getOrganisation()
   {
      return organisation;
   }

   public void setOrganisation(Organisation organisation)
   {
      if (organisation == null)
      {
         throw new IllegalArgumentException("Ungültige Organisation");
      }
      this.organisation = organisation;
   }

   // Setter Getter Projekt
   public Collection<Projekt> getProjekt()
   {
      return projekte;
   }

   public void addProjekt(Projekt projekt)
   {
      if (projekt == null || projekte.contains(projekt))
      {
         throw new IllegalArgumentException("Ungültiges Projekt");
      }
      this.projekte.add(projekt);
   }

   public void removeProjekt(Projekt projekt)
   {
      if (projekt == null || !projekte.contains(projekt))
      {
         throw new IllegalArgumentException("Ungültiges Projekt");
      }
      this.projekte.remove(projekt);
   }

   public String getVorname()
   {
      return vorname;
   }

   public void setVorname(String vorname)
   {
      if (vorname == null || vorname.isEmpty())
      {
         throw new IllegalArgumentException("Ungültiger Vorname");
      }
      this.vorname = vorname;
   }

   public String getContact()
   {
      return mail;
   }

   public void setContact(String contact)
   {
      if (contact == null || contact.isEmpty())
      {
         throw new IllegalArgumentException("Ungültiger Vorname");
      }
      this.mail = contact;
   }

}