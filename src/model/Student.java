package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Student einer Hochschule. Bearbeitet bei einem Ansprechpartner ein Projekt.
 */
@Entity
<<<<<<< HEAD
public class Student implements Serializable
{

   private static final long serialVersionUID = -5523554653298279742L;

   private SimpleIntegerProperty matrikelnummer;

   private SimpleStringProperty vorname;

   private SimpleStringProperty nachname;

   private SimpleStringProperty mail;

   private Projekt projekt;

   private Student()
   {
      // Hier gibt es nichts zusehn.
   }

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

   public Student(String vorname, String nachname, int matrikelnummer,
         String mail)
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
      this.mail = new SimpleStringProperty(mail);
   }

   // Setter Getter Vorname
   @Column
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
   @Column
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
   @Id
   @Column
   public Integer getMatrikelnummer()
   {
      return matrikelnummer.getValue();
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
   @Column(nullable = true)
   public String getMail()
   {
      return mail.get();
   }

   public void setMail(String mail)
   {
      if (mail == null)
      {
         mail = "";
      }
      this.mail = new SimpleStringProperty(mail);
   }

   // Setter Getter Projekt

   @ManyToOne
   @JoinColumn(name = "projekt_id", nullable = true)
   public Projekt getProjekt()
   {
      return projekt;
   }

   public void setProjekt(Projekt projekt)
   {

      this.projekt = projekt;
   }
=======
public class Student implements Serializable {

	private static final long serialVersionUID = -5523554653298279742L;

	private SimpleIntegerProperty matrikelnummer;

	private SimpleStringProperty vorname;

	private SimpleStringProperty nachname;

	private SimpleStringProperty mail;

	private Projekt projekt;

	private Student() {
		// Hier gibt es nichts zusehn.
	}

	public Student(String vorname, String nachname, int matrikelnummer) {
		super();
		if (vorname == null || vorname.isEmpty()) {
			throw new IllegalArgumentException("Ungültiger Vorname");
		}
		if (nachname == null || nachname.isEmpty()) {
			throw new IllegalArgumentException("Ungültiger Nachname");
		}
		if (matrikelnummer < 1) {
			throw new IllegalArgumentException("Üngültige Matrikelnummer");
		}
		this.vorname = new SimpleStringProperty(vorname);
		this.nachname = new SimpleStringProperty(nachname);
		this.matrikelnummer = new SimpleIntegerProperty(matrikelnummer);
	}

	// Setter Getter Vorname
	@Column
	public String getVorname() {
		return vorname.get();
	}

	public void setVorname(String vorname) {
		if (vorname == null || vorname.isEmpty()) {
			throw new IllegalArgumentException("Ungültiger Vorname");
		}
		this.vorname = new SimpleStringProperty(vorname);
	}

	// Setter Getter Matrikelnummer
	@Id
	@Column
	public Integer getMatrikelnummer() {
		return matrikelnummer.getValue();
	}

	public void setMatrikelnummer(int matrikelnummer) {
		if (matrikelnummer < 1) {
			throw new IllegalArgumentException("Ungültiger Student");
		}
		this.matrikelnummer = new SimpleIntegerProperty(matrikelnummer);
	}

	// Setter Getter Nachname
	@Column
	public String getNachname() {
		return nachname.get();
	}

	public void setNachname(String nachname) {
		if (nachname == null || nachname.isEmpty()) {
			throw new IllegalArgumentException("Ungültiger Nachname");
		}
		this.nachname = new SimpleStringProperty(nachname);
	}

	// Setter Getter Mail
	@Column
	public String getMail() {
		return mail.get();
	}

	public void setMail(String mail) {
		if (mail == null) {
			mail = "";
		}
		this.mail = new SimpleStringProperty(mail);
	}

	// Setter Getter Projekt

	@ManyToOne(optional = true)
	@JoinColumn(name = "projekt_id", nullable = true)
	public Projekt getProjekt() {
		return projekt;
	}

	public void setProjekt(Projekt projekt) {
		this.projekt = projekt;
	}
>>>>>>> 3a6391f0fbac6c04746ed696c1e9664299fe2e03

}