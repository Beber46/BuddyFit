package fr.guimsbeber.buddyfit.objet;

/**
 * Cette class permet d'acc�der aux diff�rentes cat�gories existant dans la BDD
 * @author Bertrand
 *
 */
public class Category {
	private int id;
	private String name;
	private String description;
	
	public Category(){
		
	}
	
	public Category(int id, String name, String desscription){
		this.setId(id);
		this.setName(name);
		this.setDescription(desscription);
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
