package fr.guimsbeber.buddyfit.bdd;

/**
 * Cette class permet l'accès aux liens entre une exercice et une session
 * @author Bertrand
 *
 */
public class SessionExercice {
	private int id_session;
	private int id_exercice;
	private int position;
	private float timeout;
	
	public int getId_session() {
		return id_session;
	}
	public void setId_session(int id_session) {
		this.id_session = id_session;
	}
	public int getId_exercice() {
		return id_exercice;
	}
	public void setId_exercice(int id_exercice) {
		this.id_exercice = id_exercice;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public float getTimeout() {
		return timeout;
	}
	public void setTimeout(float timeout) {
		this.timeout = timeout;
	}
}
