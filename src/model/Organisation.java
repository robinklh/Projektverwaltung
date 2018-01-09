package model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Eine Organisation die einen Ansprechpartner f�r Projekte besch�ftigt. Kann
 * eine Hochschule oder ein Unternehmen aus der Industrie sein.
 */
@Entity
public class Organisation {

	@Id
	@GeneratedValue
	private Integer organisation_id;

	@OneToMany
	private Collection<Ansprechpartner> mitglieder;

	@Column
	private String name;

	public Organisation(String name) {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("Ung�ltiger Organisationsname.");
		}
		this.name = name;
		this.mitglieder = new ArrayList<>();
	}

	public Collection<Ansprechpartner> getMitglieder() {
		return mitglieder;
	}

	public void addMitglieder(Ansprechpartner mitglied) {
		if (mitglied == null || mitglieder.contains(mitglied)) {
			throw new IllegalArgumentException("Ung�ltige Mitgliederliste.");
		}
		this.mitglieder.add(mitglied);
	}

	public void removeMitglieder(Ansprechpartner mitglied) {
		if (mitglied == null || !mitglieder.contains(mitglied)) {
			throw new IllegalArgumentException("Ung�ltige Mitgliederliste.");
		}
		this.mitglieder.remove(mitglied);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("Ung�ltiger Organisationsname.");
		}
		this.name = name;
	}

}