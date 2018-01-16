package model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Eine Organisation die einen Ansprechpartner für Projekte beschäftigt. Kann
 * eine Hochschule oder ein Unternehmen aus der Industrie sein.
 */
@Entity
public class Organisation {

	@Id
	@GeneratedValue
	private Integer organisation_id;

	@OneToMany(mappedBy = "organisation")
	private Collection<Ansprechpartner> mitglieder;

	@Column
	private String name;

	@SuppressWarnings("unused")
	private Organisation() {
		// Hier gibt es nichts zu sehen.
	}

	public Organisation(String name) {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("Ungültiger Organisationsname.");
		}
		this.name = name;
		this.mitglieder = new ArrayList<>();
	}

	public Collection<Ansprechpartner> getMitglieder() {
		return mitglieder;
	}

	public void addMitglieder(Ansprechpartner mitglied) {
		if (mitglied == null || mitglieder.contains(mitglied)) {
			throw new IllegalArgumentException("Ungültige Mitgliederliste.");
		}
		this.mitglieder.add(mitglied);
	}

	public void removeMitglieder(Ansprechpartner mitglied) {
		if (mitglied == null || !mitglieder.contains(mitglied)) {
			throw new IllegalArgumentException("Ungültige Mitgliederliste.");
		}
		this.mitglieder.remove(mitglied);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("Ungültiger Organisationsname.");
		}
		this.name = name;
	}

}