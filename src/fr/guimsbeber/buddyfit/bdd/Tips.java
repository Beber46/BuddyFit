package fr.guimsbeber.buddyfit.bdd;

/**
 * Cette class permet l'accès aux conseils d'un exercice
 * @author Bertrand
 *
 */
public class Tips {
	private int id;
	private String description;
	private int id_exercice;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getId_exercice() {
		return id_exercice;
	}
	public void setId_exercice(int id_exercice) {
		this.id_exercice = id_exercice;
	}
}
