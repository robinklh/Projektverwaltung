package model;

/**
 * Student einer Hochschule. Bearbeitet bei einem Ansprechpartner ein Projekt.
 */

public class Student
{
   private String vorname;

   private String nachname;

   private int matrikelnummer;

   private String mail;

   private Projekt projekt;

   public Student(String vorname, String nachname, int matrikelnummer)
   {
      if (vorname == null || vorname.isEmpty())
      {
         throw new IllegalArgumentException("Ung�ltiger Vorname");
      }
      if (nachname == null || nachname.isEmpty())
      {
         throw new IllegalArgumentException("Ung�ltiger Nachname");
      }
      if (matrikelnummer < 1)
      {
         throw new IllegalArgumentException("�ng�ltige Matrikelnummer");
      }
      this.vorname = vorname;
      this.nachname = nachname;
      this.matrikelnummer = matrikelnummer;
   }

   // Setter Getter Vorname
   public String getVorname()
   {
      return vorname;
   }

   public void setVorname(String vorname)
   {
      if (vorname == null || vorname.isEmpty())
      {
         throw new IllegalArgumentException("Ung�ltiger Vorname");
      }
      this.vorname = vorname;
   }

   // Setter Getter Nachname
   public String getNachname()
   {
      return nachname;
   }

   public void setNachname(String nachname)
   {
      if (nachname == null || nachname.isEmpty())
      {
         throw new IllegalArgumentException("Ung�ltiger Nachname");
      }
      this.nachname = nachname;
   }

   // Setter Getter Matrikelnummer
   public int getMatrikelnummer()
   {
      return matrikelnummer;
   }

   public void setMatrikelnummer(int matrikelnummer)
   {
      if (matrikelnummer < 1)
      {
         throw new IllegalArgumentException("Ung�ltiger Student");
      }
      this.matrikelnummer = matrikelnummer;
   }

   // Setter Getter Mail
   public String getMail()
   {
      return mail;
   }

   public void setMail(String mail)
   {
      if (mail == null || mail.isEmpty())
      {
         throw new IllegalArgumentException("Ung�ltige Mail");
      }
      this.mail = mail;
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
         throw new IllegalArgumentException("Ung�ltiges Projekt");
      }
      this.projekt = projekt;
   }

}