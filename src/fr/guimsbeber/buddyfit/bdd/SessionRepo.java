package fr.guimsbeber.buddyfit.bdd;

import java.util.ArrayList;
import java.util.List;

import fr.guimsbeber.buddyfit.objet.Session;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

public class SessionRepo extends Repository<Session>{
	
	private String[] mColumn = new String[]{
			BDD.SESSION_COLUMN_ID,
			BDD.SESSION_COLUMN_NAME,
			BDD.SESSION_COLUMN_DESCRIPTION,
			BDD.SESSION_COLUMN_ID_PROGRAM
	};

	public SessionRepo(Context ctx){
		mSQLOH = new BDD(ctx, null);
	}

	/**
	 * Récupération des la liste des Session
	 */
	@Override
	public List<Session> GetAll() {
		Cursor c = mBDD.query(BDD.TN_SESSION, mColumn , null, null, null, null, null);
		
		return ConvertCursorToListObject(c);
	}

	@Override
	public Session GetById(int id) {
		Cursor c = mBDD.query(BDD.TN_SESSION, mColumn , String.valueOf(id), null, null, null, null);
		
		return ConvertCursorToObject(c);
	}
	
	/**
	 * Enregistre un subcategory
	 */
	@Override
	public void Save(Session entite) {
		ContentValues contentValues = new ContentValues();

		contentValues.put(BDD.SESSION_COLUMN_NAME, entite.getName());
		contentValues.put(BDD.SESSION_COLUMN_DESCRIPTION, entite.getDescription());
		contentValues.put(BDD.SESSION_COLUMN_ID_PROGRAM, entite.getIdProgram());
		
		mBDD.insert(BDD.TN_SESSION, null, contentValues);
	}

	/**
	 * Met à jour le subcategory
	 */
	@Override
	public void Update(Session entite) {
		ContentValues contentValues = new ContentValues();

		contentValues.put(BDD.SESSION_COLUMN_NAME, entite.getName());
		contentValues.put(BDD.SESSION_COLUMN_DESCRIPTION, entite.getDescription());
		contentValues.put(BDD.SESSION_COLUMN_ID_PROGRAM, entite.getIdProgram());
		
		mBDD.update(BDD.TN_SESSION, contentValues, BDD.SESSION_COLUMN_ID + "=?", new String[]{String.valueOf(entite.getId())});
	}

	/**
	 * Supprimer un subcategory
	 */
	@Override
	public void Delete(int id) {
		mBDD.delete(BDD.TN_SESSION, BDD.SESSION_COLUMN_ID + "=?", new String[]{String.valueOf(id)});
	}

	/**
	 * Converti un curseur en une liste de subcategorys
	 */
	@Override
	public List<Session> ConvertCursorToListObject(Cursor c) {
		List<Session> liste = new ArrayList<Session>();
		// Si la liste est vide
		if (c.getCount() == 0)
			return liste;
		// position sur le premeir item
		c.moveToFirst();
		// Pour chaque item
		do {
			Session sess = ConvertCursorToObject(c);
			liste.add(sess);
		} while (c.moveToNext());
		// Fermeture du curseur
		c.close();

		return liste;
	}

	/**
	 * Méthode utilisée par ConvertCursorToObject et ConvertCursorToListObject
	 */
	@Override
	public Session ConvertCursorToObject(Cursor c) {
		
		Session sess = new Session();
		
		sess.setId(c.getInt(BDD.SESSION_NUM_ID));
		sess.setName(c.getString(BDD.SESSION_NUM_NAME));
		sess.setDescription(c.getString(BDD.SESSION_NUM_DESCRIPTION));
		sess.setIdProgram(c.getInt(BDD.SESSION_NUM_ID_PROGRAM));
		
		return sess;
	}
	
	/**
	 * Converti un curseur en un subcategory
	 */
	@Override
	public Session ConvertCursorToOneObject(Cursor c) {
		c.moveToFirst();
		
		Session sess = ConvertCursorToObject(c);
		
		c.close();
		return sess;
	}

}