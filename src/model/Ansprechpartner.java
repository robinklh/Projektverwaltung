package application;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Ansprechpartner für ein Projekt. Kann Dozent der Hochschule oder externer
 * Partner aus der Industrie sein.
 */
public class Ansprechpartner
{
   private String nachname;

   private String vorname;

   private Organisation organisation;

   private Collection<Projekt> projekte;

   public Ansprechpartner(String vorname, String nachname,
         Organisation organisation)
   {
      if (nachname == null || nachname.isEmpty())
      {
         throw new IllegalArgumentException("Ungültiger Nachname.");
      }
      if (vorname == null || vorname.isEmpty())
      {
         throw new IllegalArgumentException("Ungültiger Vorname.");
      }
      if (organisation == null)
      {
         throw new IllegalArgumentException("Ungültige Organisation.");
      }
      this.vorname = vorname;
      this.nachname = nachname;
      this.organisation = organisation;
      this.organisation.addMitglieder(this);
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

}