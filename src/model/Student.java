package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Student einer Hochschule. Bearbeitet bei einem Ansprechpartner ein Projekt.
 */

public class Student
{
   private SimpleStringProperty vorname;

   private SimpleStringProperty nachname;

   private SimpleIntegerProperty matrikelnummer;

   private SimpleStringProperty mail;

   private Projekt projekt;

   public Student(String vorname, String nachname, int matrikelnummer)
   {
      super();
      if (vorname == null || vorname.isEmpty())
      {
         throw new IllegalArgumentException("Ungültiger Vorname");
      }
      if (nachname == null || nachname.isEmpty())
      {
         throw new IllegalArgumentException("Ungültiger Nachname");
      }
      if (matrikelnummer < 1)
      {
         throw new IllegalArgumentException("Üngültige Matrikelnummer");
      }
      this.vorname = new SimpleStringProperty(vorname);
      this.nachname = new SimpleStringProperty(nachname);
      this.matrikelnummer = new SimpleIntegerProperty(matrikelnummer);
   }

   // Setter Getter Vorname
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

   // Setter Getter Nachname
   public String getNachname()
   {
      return nachname.get();
   }

   public void setNachname(String nachname)
   {
      if (nachname == null || nachname.isEmpty())
      {
         throw new IllegalArgumentException("Ungültiger Nachname");
      }
      this.nachname = new SimpleStringProperty(nachname);
   }

   // Setter Getter Matrikelnummer
   public Integer getMatrikelnummer()
   {
      return matrikelnummer.intValue();
   }

   public void setMatrikelnummer(int matrikelnummer)
   {
      if (matrikelnummer < 1)
      {
         throw new IllegalArgumentException("Ungültiger Student");
      }
      this.matrikelnummer = new SimpleIntegerProperty(matrikelnummer);
   }

   // Setter Getter Mail
   public String getMail()
   {
      return mail.get();
   }

   public void setMail(String mail)
   {
      if (mail == null || mail.isEmpty())
      {
         throw new IllegalArgumentException("Ungültige Mail");
      }
      this.mail = new SimpleStringProperty(mail);
   }

   // Setter Getter Projekt
   public Projekt getProjekt()
   {
      return projekt;
   }

   public void setProjekt(Projekt projekt)
   {
      if (projekt == null)
      {
         throw new IllegalArgumentException("Ungültiges Projekt");
      }
      this.projekt = projekt;
   }

}