package model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import javafx.beans.property.SimpleStringProperty;

/**
 * Ein Projekt das im Rahmen des Studiums von Studenten durchgeführt wird.
 */
@Entity

public class Projekt
{

   private Integer projekt_id;

   private SimpleStringProperty projektname;

   private String projektskizze;

   private String projektbeschreibung;

   private Collection<Student> studenten;

   private Ansprechpartner ansprechpartner;

   private String status;

   private String Anmerkung;

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
      this.projektname = new SimpleStringProperty(projektname);
      this.projektskizze = projektskizze;
      this.studenten = studenten;
      this.status = "bearbeitung";
   }

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
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
      return projektname.get();
   }

   public void setProjektname(String projektname)
   {
      if (projektname == null || projektname.equals(""))
      {
         throw new IllegalArgumentException("Ungültiger Projektname");
      }
      this.projektname = new SimpleStringProperty(projektname);
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

   /**
    * Getter for property status.
    * 
    * @return Returns the status.
    */
   @Column
   public String getStatus()
   {
      return status;
   }

   /**
    * Setter for property status.
    *
    * @param status
    *           The status to set.
    */
   public void setStatus(String status)
   {
      this.status = status;
   }

   @Override
   public String toString()
   {
      return this.getProjektname();
   }

   /**
    * Getter for property anmerkung.
    * 
    * @return Returns the anmerkung.
    */
   @Column
   public String getAnmerkung()
   {
      return Anmerkung;
   }

   /**
    * Setter for property anmerkung.
    *
    * @param anmerkung
    *           The anmerkung to set.
    */
   public void setAnmerkung(String anmerkung)
   {
      Anmerkung = anmerkung;
   }
}