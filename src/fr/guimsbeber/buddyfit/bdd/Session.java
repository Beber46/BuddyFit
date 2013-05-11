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
	private int id_program;
	
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
	public int getId_program() {
		return id_program;
	}
	public void setId_program(int id_program) {
		this.id_program = id_program;
	}
}
