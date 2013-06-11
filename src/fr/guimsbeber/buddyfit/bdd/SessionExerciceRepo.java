package fr.guimsbeber.buddyfit.bdd;

import java.util.ArrayList;
import java.util.List;

import fr.guimsbeber.buddyfit.objet.SessionExercice;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

public class SessionExerciceRepo extends Repository<SessionExercice>{
	
	
	private String[] mColumn = new String[]{
			BDD.SESSIONEXERCICE_COLUMN_ID_EXERCICE,
			BDD.SESSIONEXERCICE_COLUMN_ID_SESSION,
			BDD.SESSIONEXERCICE_COLUMN_POSITION,
			BDD.SESSIONEXERCICE_COLUMN_TIMEOUT
	};

	public SessionExerciceRepo(Context ctx){
		mSQLOH = new BDD(ctx, null);
	}

	/**
	 * Récupération des la liste des SessionExercice
	 */
	@Override
	public List<SessionExercice> GetAll() {
		Cursor c = mBDD.query(BDD.TN_SESSIONEXERCICE, mColumn , null, null, null, null, null);
		
		return ConvertCursorToListObject(c);
	}

	@Override
	public SessionExercice GetById(int id) {
		Cursor c = mBDD.query(BDD.TN_SESSIONEXERCICE, mColumn , String.valueOf(id), null, null, null, null);
		
		return ConvertCursorToObject(c);
	}
	
	/**
	 * Enregistre un sessionexercice
	 */
	@Override
	public void Save(SessionExercice entite) {
		ContentValues contentValues = new ContentValues();

		contentValues.put(BDD.SESSIONEXERCICE_COLUMN_ID_EXERCICE, entite.getIdExercice());
		contentValues.put(BDD.SESSIONEXERCICE_COLUMN_ID_SESSION, entite.getIdSession());
		contentValues.put(BDD.SESSIONEXERCICE_COLUMN_POSITION, entite.getPosition());
		contentValues.put(BDD.SESSIONEXERCICE_COLUMN_TIMEOUT, entite.getTimeout());
		
		mBDD.insert(BDD.TN_SESSIONEXERCICE, null, contentValues);
	}

	/**
	 * Met à jour le sessionexercice
	 */
	@Override
	public void Update(SessionExercice entite) {
		ContentValues contentValues = new ContentValues();

		contentValues.put(BDD.SESSIONEXERCICE_COLUMN_ID_EXERCICE, entite.getIdExercice());
		contentValues.put(BDD.SESSIONEXERCICE_COLUMN_ID_SESSION, entite.getIdSession());
		contentValues.put(BDD.SESSIONEXERCICE_COLUMN_POSITION, entite.getPosition());
		contentValues.put(BDD.SESSIONEXERCICE_COLUMN_TIMEOUT, entite.getTimeout());
		
		mBDD.update(BDD.TN_SESSIONEXERCICE, contentValues, BDD.SESSIONEXERCICE_COLUMN_ID_EXERCICE + "=?"+BDD.SESSIONEXERCICE_COLUMN_ID_SESSION + "=?", 
				new String[]{String.valueOf(entite.getIdExercice()),String.valueOf(entite.getIdExercice())});
	}

	/**
	 * 
	 */
	@Override
	public void Delete(int id) {
		Log.d("SessionExerciceRepo","aucun delete pour session exercice voir deleteExSes");
	}
	
	public void DeleteSessionExe(int idE,int idS) {
		mBDD.delete(BDD.TN_SUBCATEGORY, BDD.SESSIONEXERCICE_COLUMN_ID_EXERCICE + "=?"+BDD.SESSIONEXERCICE_COLUMN_ID_SESSION + "=?", 
				new String[]{String.valueOf(idE),String.valueOf(idS)});
	}

	/**
	 * Converti un curseur en une liste de sessionexercices
	 */
	@Override
	public List<SessionExercice> ConvertCursorToListObject(Cursor c) {
		List<SessionExercice> liste = new ArrayList<SessionExercice>();
		// Si la liste est vide
		if (c.getCount() == 0)
			return liste;
		// position sur le premeir item
		c.moveToFirst();
		// Pour chaque item
		do {
			SessionExercice sesexe = ConvertCursorToObject(c);
			liste.add(sesexe);
		} while (c.moveToNext());
		// Fermeture du curseur
		c.close();

		return liste;
	}

	/**
	 * Méthode utilisée par ConvertCursorToObject et ConvertCursorToListObject
	 */
	@Override
	public SessionExercice ConvertCursorToObject(Cursor c) {
		
		SessionExercice sesexe = new SessionExercice();
		
		sesexe.setIdExercice(c.getInt(BDD.SESSIONEXERCICE_NUM_ID_EXERCICE));
		sesexe.setIdSession(c.getInt(BDD.SESSIONEXERCICE_NUM_ID_SESSION));
		sesexe.setPosition(c.getInt(BDD.SESSIONEXERCICE_NUM_POSITION));
		sesexe.setTimeout(c.getFloat(BDD.SESSIONEXERCICE_NUM_TIMEOUT));
		
		return sesexe;
	}
	
	/**
	 * Converti un curseur en un sessionexercice
	 */
	@Override
	public SessionExercice ConvertCursorToOneObject(Cursor c) {
		c.moveToFirst();
		
		SessionExercice sesexe = ConvertCursorToObject(c);
		
		c.close();
		return sesexe;
	}

}