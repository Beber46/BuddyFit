package fr.guimsbeber.buddyfit.bdd;

/**
 * Cette class permet d'accéder aux sessions des différents programmes
 * @author Bertrand
 *
 */
public class Session {
	private int id;
	private String name;
	private String description;
	private int idProgram;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getIdProgram() {
		return idProgram;
	}
	public void setIdProgram(int idProgram) {
		this.idProgram = idProgram;
	}
}
