package fr.guimsbeber.buddyfit.objet;

/**
 * Cette class permet d'accéder aux différentes catégories existant dans la BDD
 * @author Bertrand
 *
 */
public class Category {
	private int id;
	private String name;
	private String description;
	
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
}
