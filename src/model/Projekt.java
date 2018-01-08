package application;

import java.util.Collection;

/**
 * Ein Projekt das im Rahmen des Studiums von Studenten durchgef�hrt wird.
 */
public class Projekt
{

   private String projektname;

   private String projektskizze;

   private String projektbeschreibung;

   private Collection<Student> studenten;

   private Ansprechpartner ansprechpartner;

   public Projekt(String projektname, String projektskizze,
         String projektbeschreibung, Collection<Student> studenten,
         Ansprechpartner ansprechpartner)
   {
      if (projektname == null || projektname.equals(""))
      {
         throw new IllegalArgumentException("Ung�ltiger Projektname");
      }
      if (projektskizze == null || projektskizze.equals(""))
      {
         throw new IllegalArgumentException("Ung�ltige Projektskizze");
      }
      if (projektbeschreibung == null || projektbeschreibung.equals(""))
      {
         throw new IllegalArgumentException("Ung�ltige Projektbeschreibung");
      }
      if (studenten == null || studenten.size() > 3 || studenten.size() < 2)
      {
         throw new IllegalArgumentException("Ung�ltiger Student");
      }
      if (ansprechpartner == null)
      {
         throw new IllegalArgumentException("Ung�ltiger Ansprechpartner");
      }
      this.ansprechpartner = ansprechpartner;
      ansprechpartner.addProjekt(this);
      this.projektbeschreibung = projektbeschreibung;
      this.projektname = projektname;
      this.projektskizze = projektskizze;
      this.studenten = studenten;
   }

   public String getProjektname()
   {
      return projektname;
   }

   public void setProjektname(String projektname)
   {
      if (projektname == null || projektname.equals(""))
      {
         throw new IllegalArgumentException("Ung�ltiger Projektname");
      }
      this.projektname = projektname;
   }

   public String getProjektskizze()
   {
      return projektskizze;
   }

   public void setProjektskizze(String projektskizze)
   {
      if (projektskizze == null || projektskizze.equals(""))
      {
         throw new IllegalArgumentException("Ung�ltige Projektskizze");
      }
      this.projektskizze = projektskizze;
   }

   public String getProjektbeschreibung()
   {
      return projektbeschreibung;
   }

   public void setProjektbeschreibung(String projektbeschreibung)
   {
      if (projektbeschreibung == null || projektbeschreibung.equals(""))
      {
         throw new IllegalArgumentException("Ung�ltige Projektbeschreibung");
      }
      this.projektbeschreibung = projektbeschreibung;
   }

   public Collection<Student> getStudenten()
   {
      return studenten;
   }

   public void addStudent(Student student)
   {
      if (student == null || studenten.contains(student))
      {
         throw new IllegalArgumentException("Ung�ltiger Student");
      }
      this.studenten.add(student);
   }

   public void removeStudent(Student student)
   {
      if (student == null || !studenten.contains(student))
      {
         throw new IllegalArgumentException("Ung�ltiger Student");
      }
      this.studenten.remove(student);
   }

   public Ansprechpartner getAnsprechpartner()
   {
      return ansprechpartner;
   }

   public void setAnsprechpartner(Ansprechpartner ansprechpartner)
   {
      if (ansprechpartner == null)
      {
         throw new IllegalArgumentException("Ung�ltiger Ansprechpartner");
      }
      this.ansprechpartner = ansprechpartner;
   }

}