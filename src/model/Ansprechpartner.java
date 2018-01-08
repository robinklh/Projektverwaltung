package model;

import java.util.ArrayList;
import java.util.Collection;

import javafx.beans.property.SimpleStringProperty;

/**
 * Ansprechpartner für ein Projekt. Kann Dozent der Hochschule oder externer
 * Partner aus der Industrie sein.
 */
public class Ansprechpartner
{
   private SimpleStringProperty nachname;

   private SimpleStringProperty vorname;

   private SimpleStringProperty contact;

   private Organisation organisation;

   private Collection<Projekt> projekte;

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

      this.contact = new SimpleStringProperty(contact);
      this.vorname = new SimpleStringProperty(vorname);
      this.nachname = new SimpleStringProperty(nachname);
      this.projekte = new ArrayList<Projekt>();
   }

   // Setter Getter Name
   public String getNachname()
   {
      return nachname.get();
   }

   public void setNachname(String name)
   {
      if (name == null || name.isEmpty())
      {
         throw new IllegalArgumentException("Ungültiger name");
      }
      this.nachname = new SimpleStringProperty(name);
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
      return vorname.get();
   }

   public void setVorname(String vorname)
   {
      if (vorname == null || vorname.isEmpty())
      {
         throw new IllegalArgumentException("Ungültiger Vorname");
      }
      this.vorname = new SimpleStringProperty(vorname);
   }

   public String getContact()
   {
      return contact.get();
   }

   public void setContact(String contact)
   {
      if (contact == null || contact.isEmpty())
      {
         throw new IllegalArgumentException("Ungültiger Vorname");
      }
      this.contact = new SimpleStringProperty(contact);
   }

}