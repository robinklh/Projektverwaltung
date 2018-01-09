package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Student einer Hochschule. Bearbeitet bei einem Ansprechpartner ein Projekt.
 */
@Entity
public class Student implements Serializable {

	private static final long serialVersionUID = -5523554653298279742L;

	@Column
	private String vorname;

	@Column
	private String nachname;

	@Id
	@Column
	private Integer matrikelnummer;

	@Column
	private String mail;

	@ManyToOne
	@JoinColumn(name = "projekt_id")
	private Projekt projekt;

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
		this.vorname = vorname;
		this.nachname = nachname;
		this.matrikelnummer = matrikelnummer;
	}

	// Setter Getter Vorname
	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		if (vorname == null || vorname.isEmpty()) {
			throw new IllegalArgumentException("Ungültiger Vorname");
		}
		this.vorname = vorname;
	}

	// Setter Getter Nachname
	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		if (nachname == null || nachname.isEmpty()) {
			throw new IllegalArgumentException("Ungültiger Nachname");
		}
		this.nachname = nachname;
	}

	// Setter Getter Matrikelnummer
	public Integer getMatrikelnummer() {
		return matrikelnummer;
	}

	public void setMatrikelnummer(int matrikelnummer) {
		if (matrikelnummer < 1) {
			throw new IllegalArgumentException("Ungültiger Student");
		}
		this.matrikelnummer = matrikelnummer;
	}

	// Setter Getter Mail
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		if (mail == null || mail.isEmpty()) {
			throw new IllegalArgumentException("Ungültige Mail");
		}
		this.mail = mail;
	}

	// Setter Getter Projekt
	public Projekt getProjekt() {
		return projekt;
	}

	public void setProjekt(Projekt projekt) {
		if (projekt == null) {
			throw new IllegalArgumentException("Ungültiges Projekt");
		}
		this.projekt = projekt;
	}

}