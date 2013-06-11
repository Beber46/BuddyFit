package fr.guimsbeber.buddyfit.objet;

/**
 * Cette class permet l'accès aux liens entre une exercice et une session
 * @author Bertrand
 *
 */
public class SessionExercice {
	private int idSession;
	private int idExercice;
	private int position;
	private float timeout;
	
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
	public int getIdSession() {
		return idSession;
	}
	public void setIdSession(int idSession) {
		this.idSession = idSession;
	}
	public int getIdExercice() {
		return idExercice;
	}
	public void setIdExercice(int idExercice) {
		this.idExercice = idExercice;
	}
}
