package fr.guimsbeber.buddyfit.objet;

public class Routine {
	
	private int id;
	private String name;
	private int time;
	private String description;
	private String idType;	

	public Routine(int id, String name, int time, String description,
			String idType) {
		super();
		this.id = id;
		this.name = name;
		this.time = time;
		this.description = description;
		this.idType = idType;
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
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIdType() {
		return idType;
	}
	public void setIdType(String idType) {
		this.idType = idType;
	}
	
	

}
