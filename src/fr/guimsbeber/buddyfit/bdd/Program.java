package fr.guimsbeber.buddyfit.bdd;

/**
 * Cette class va permettre d'accéder à tous les programmes présents dans la base
 * @author Bertrand
 *
 */
public class Program {
	private int id;
	private String name;
	private int begindate;
	private int enddate;
	private String description;
	private int id_user;
	
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
	public int getBegindate() {
		return begindate;
	}
	public void setBegindate(int begindate) {
		this.begindate = begindate;
	}
	public int getEnddate() {
		return enddate;
	}
	public void setEnddate(int enddate) {
		this.enddate = enddate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
}
