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
public class Projekt {

	@Id
	@GeneratedValue
	private Integer projekt_id;

	@Column
	private String projektname;

	@Column
	private String projektskizze;

	@Column
	private String projektbeschreibung;

	@OneToMany
	private Collection<Student> studenten;

	@OneToOne
	@JoinColumn(name = "ansprechpartner_id")
	private Ansprechpartner ansprechpartner;

	public Projekt(String projektname, String projektskizze, String projektbeschreibung, Collection<Student> studenten,
			Ansprechpartner ansprechpartner) {
		if (projektname == null || projektname.equals("")) {
			throw new IllegalArgumentException("Ungültiger Projektname");
		}
		if (projektskizze == null || projektskizze.equals("")) {
			throw new IllegalArgumentException("Ungültige Projektskizze");
		}
		if (projektbeschreibung == null || projektbeschreibung.equals("")) {
			throw new IllegalArgumentException("Ungültige Projektbeschreibung");
		}
		if (studenten == null || studenten.size() > 3 || studenten.size() < 2) {
			throw new IllegalArgumentException("Ungültiger Student");
		}
		if (ansprechpartner == null) {
			throw new IllegalArgumentException("Ungültiger Ansprechpartner");
		}
		this.ansprechpartner = ansprechpartner;
		ansprechpartner.addProjekt(this);
		this.projektbeschreibung = projektbeschreibung;
		this.projektname = projektname;
		this.projektskizze = projektskizze;
		this.studenten = studenten;
	}

	public String getProjektname() {
		return projektname;
	}

	public void setProjektname(String projektname) {
		if (projektname == null || projektname.equals("")) {
			throw new IllegalArgumentException("Ungültiger Projektname");
		}
		this.projektname = projektname;
	}

	public String getProjektskizze() {
		return projektskizze;
	}

	public void setProjektskizze(String projektskizze) {
		if (projektskizze == null || projektskizze.equals("")) {
			throw new IllegalArgumentException("Ungültige Projektskizze");
		}
		this.projektskizze = projektskizze;
	}

	public String getProjektbeschreibung() {
		return projektbeschreibung;
	}

	public void setProjektbeschreibung(String projektbeschreibung) {
		if (projektbeschreibung == null || projektbeschreibung.equals("")) {
			throw new IllegalArgumentException("Ungültige Projektbeschreibung");
		}
		this.projektbeschreibung = projektbeschreibung;
	}

	public Collection<Student> getStudenten() {
		return studenten;
	}

	public void addStudent(Student student) {
		if (student == null || studenten.contains(student)) {
			throw new IllegalArgumentException("Ungültiger Student");
		}
		this.studenten.add(student);
	}

	public void removeStudent(Student student) {
		if (student == null || !studenten.contains(student)) {
			throw new IllegalArgumentException("Ungültiger Student");
		}
		this.studenten.remove(student);
	}

	public Ansprechpartner getAnsprechpartner() {
		return ansprechpartner;
	}

	public void setAnsprechpartner(Ansprechpartner ansprechpartner) {
		if (ansprechpartner == null) {
			throw new IllegalArgumentException("Ungültiger Ansprechpartner");
		}
		this.ansprechpartner = ansprechpartner;
	}

}