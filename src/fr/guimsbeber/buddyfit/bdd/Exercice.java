package fr.guimsbeber.buddyfit.bdd;

/**
 * Cette class permet d'accéder aux exercices
 * @author Bertrand
 *
 */
public class Exercice {
	private int id;
	private String name;
	private String picture;
	private String description;
	private int id_subcategory;
	
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
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getId_subcategory() {
		return id_subcategory;
	}
	public void setId_subcategory(int id_subcategory) {
		this.id_subcategory = id_subcategory;
	}
	
}
