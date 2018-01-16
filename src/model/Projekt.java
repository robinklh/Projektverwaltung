package model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * Ein Projekt das im Rahmen des Studiums von Studenten durchgeführt wird.
 */
@Entity

public class Projekt
{

   private Integer projekt_id;

   private String projektname;

   private String projektskizze;

   private String projektbeschreibung;

   private Collection<Student> studenten;

   private Ansprechpartner ansprechpartner;

   @SuppressWarnings("unused")
   private Projekt()
   {
      // Hier gibt es nichts zusehn.
   }

   public Projekt(String projektname, String projektskizze,
         String projektbeschreibung, Collection<Student> studenten,
         Ansprechpartner ansprechpartner)
   {
      if (projektname == null || projektname.equals(""))
      {
         throw new IllegalArgumentException("Ungültiger Projektname");
      }
      if (projektskizze == null || projektskizze.equals(""))
      {
         throw new IllegalArgumentException("Ungültige Projektskizze");
      }
      if (projektbeschreibung == null || projektbeschreibung.equals(""))
      {
         throw new IllegalArgumentException("Ungültige Projektbeschreibung");
      }
      if (studenten == null || studenten.size() > 3 || studenten.size() < 2)
      {
         throw new IllegalArgumentException("Ungültiger Student");
      }
      if (ansprechpartner == null)
      {
         throw new IllegalArgumentException("Ungültiger Ansprechpartner");
      }
      this.ansprechpartner = ansprechpartner;
      ansprechpartner.addProjekt(this);
      this.projektbeschreibung = projektbeschreibung;
      this.projektname = projektname;
      this.projektskizze = projektskizze;
      this.studenten = studenten;
   }

   @Id
   @GeneratedValue
   public Integer getProjekt_id()
   {
      return projekt_id;
   }

   public void setProjekt_id(Integer projekt_id)
   {
      this.projekt_id = projekt_id;
   }

   @Column
   public String getProjektname()
   {
      return projektname;
   }

   public void setProjektname(String projektname)
   {
      if (projektname == null || projektname.equals(""))
      {
         throw new IllegalArgumentException("Ungültiger Projektname");
      }
      this.projektname = projektname;
   }

   @Column
   public String getProjektskizze()
   {
      return projektskizze;
   }

   public void setProjektskizze(String projektskizze)
   {
      if (projektskizze == null || projektskizze.equals(""))
      {
         throw new IllegalArgumentException("Ungültige Projektskizze");
      }
      this.projektskizze = projektskizze;
   }

   @Column
   public String getProjektbeschreibung()
   {
      return projektbeschreibung;
   }

   public void setProjektbeschreibung(String projektbeschreibung)
   {
      this.projektbeschreibung = projektbeschreibung;
   }

   @OneToMany(mappedBy = "projekt")
   public Collection<Student> getStudenten()
   {
      return studenten;
   }

   public void setStudenten(Collection<Student> studenten)
   {
      this.studenten = studenten;
   }

   public void addStudent(Student student)
   {
      if (student == null || studenten.contains(student))
      {
         throw new IllegalArgumentException("Ungültiger Student");
      }
      this.studenten.add(student);
   }

   public void removeStudent(Student student)
   {
      if (student == null || !studenten.contains(student))
      {
         throw new IllegalArgumentException("Ungültiger Student");
      }
      this.studenten.remove(student);
   }

   @OneToOne
   @JoinColumn(name = "ansprechpartner_id", nullable = true)
   public Ansprechpartner getAnsprechpartner()
   {
      return ansprechpartner;
   }

   public void setAnsprechpartner(Ansprechpartner ansprechpartner)
   {
      if (ansprechpartner == null)
      {
         throw new IllegalArgumentException("Ungültiger Ansprechpartner");
      }
      this.ansprechpartner = ansprechpartner;
   }

}