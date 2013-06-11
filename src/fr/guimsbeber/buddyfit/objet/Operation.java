package fr.guimsbeber.buddyfit.objet;

/**
 * Cette class permet d'accéder aux éléments propre à un exercice
 * (par exemple au fait qu'un utilisateur execute aujourd'hui un exercice
 * particulier)
 * @author Bertrand
 *
 */
public class Operation {
	private int id;
	private int nbseries;
	private int nbrepetition;
	private float burden;//charge
	private int dateop;
	private int idExercice;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNbseries() {
		return nbseries;
	}
	public void setNbseries(int nbseries) {
		this.nbseries = nbseries;
	}
	public int getNbrepetition() {
		return nbrepetition;
	}
	public void setNbrepetition(int nbrepetition) {
		this.nbrepetition = nbrepetition;
	}
	public float getBurden() {
		return burden;
	}
	public void setBurden(float burden) {
		this.burden = burden;
	}
	public int getDateop() {
		return dateop;
	}
	public void setDateop(int dateop) {
		this.dateop = dateop;
	}
	public int getIdExercice() {
		return idExercice;
	}
	public void setIdExercice(int idExercice) {
		this.idExercice = idExercice;
	}
}
