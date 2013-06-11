package fr.guimsbeber.buddyfit.objet;

/**
 * Cette class permet l'accès aux conseils d'un exercice
 * @author Bertrand
 *
 */
public class Tips {
	private int id;
	private String description;
	private int idExercice;
	
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
	public int getIdExercice() {
		return idExercice;
	}
	public void setIdExercice(int idExercice) {
		this.idExercice = idExercice;
	}
}
