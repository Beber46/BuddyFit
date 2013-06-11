package fr.guimsbeber.buddyfit.objet;

/**
 * Cette class permet de créer des sous-catégories
 * @author Bertrand
 *
 */
public class SubCategory {
	private int id;
	private String name;
	private String description;
	private int idCategory;
	
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
	public int getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}
}
