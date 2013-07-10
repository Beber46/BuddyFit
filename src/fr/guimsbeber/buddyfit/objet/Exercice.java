package fr.guimsbeber.buddyfit.objet;

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
	private int idCategory;
	
	public Exercice(){
		
	}
	
	public Exercice(String name,String description,int idCategory){
		this.setId(id);
		this.setName(name);
		this.setDescription(description);
		this.setIdCategory(idCategory);
	}
	
	public Exercice(int id,String name,String description,int idCategory){
		this.setId(id);
		this.setName(name);
		this.setDescription(description);
		this.setIdCategory(idCategory);
	}
	
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
	public int getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(int idSubcategory) {
		this.idCategory = idSubcategory;
	}
	
}
