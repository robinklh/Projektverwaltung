package application;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Eine Organisation die einen Ansprechpartner für Projekte beschäftigt. Kann
 * eine Hochschule oder ein Unternehmen aus der Industrie sein.
 */
public class Organisation
{
   private Collection<Ansprechpartner> mitglieder;

   private String name;

   public Organisation(String name)
   {
      if (name == null || name.isEmpty())
      {
         throw new IllegalArgumentException("Ungültiger Organisationsname.");
      }
      this.name = name;
      this.mitglieder = new ArrayList<>();
   }

   public Collection<Ansprechpartner> getMitglieder()
   {
      return mitglieder;
   }

   public void addMitglieder(Ansprechpartner mitglied)
   {
      if (mitglied == null || mitglieder.contains(mitglied))
      {
         throw new IllegalArgumentException("Ungültige Mitgliederliste.");
      }
      this.mitglieder.add(mitglied);
   }

   public void removeMitglieder(Ansprechpartner mitglied)
   {
      if (mitglied == null || !mitglieder.contains(mitglied))
      {
         throw new IllegalArgumentException("Ungültige Mitgliederliste.");
      }
      this.mitglieder.remove(mitglied);
   }

   public String getName()
   {
      return name;
   }

   public void setName(String name)
   {
      if (name == null || name.isEmpty())
      {
         throw new IllegalArgumentException("Ungültiger Organisationsname.");
      }
      this.name = name;
   }

}