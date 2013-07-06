package fr.guimsbeber.buddyfit.bdd;

import java.util.ArrayList;
import java.util.List;

import fr.guimsbeber.buddyfit.objet.Exercice;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

public class ExerciceRepo extends Repository<Exercice>{
	
	private String[] mColumn = new String[]{
			BDD.EXERCICE_COLUMN_ID,
			BDD.EXERCICE_COLUMN_NAME,
			BDD.EXERCICE_COLUMN_DESCRIPTION,
			BDD.EXERCICE_COLUMN_ID_CATEGORY
	};

	public ExerciceRepo(Context ctx){
		mSQLOH = new BDD(ctx, null);
	}

	/**
	 * Récupération des la liste des Exercice
	 */
	@Override
	public List<Exercice> GetAll() {
		Cursor c = mBDD.query(BDD.TN_EXERCICE, mColumn , null, null, null, null, null);
		
		return ConvertCursorToListObject(c);
	}

	@Override
	public Exercice GetById(int id) {
		Cursor c = mBDD.query(BDD.TN_EXERCICE, mColumn , String.valueOf(id), null, null, null, null);
		
		return ConvertCursorToObject(c);
	}
	
	/**
	 * Enregistre un exercice
	 */
	@Override
	public void Save(Exercice entite) {
		ContentValues contentValues = new ContentValues();

		contentValues.put(BDD.EXERCICE_COLUMN_NAME, entite.getName());
		contentValues.put(BDD.EXERCICE_COLUMN_DESCRIPTION, entite.getDescription());
		contentValues.put(BDD.EXERCICE_COLUMN_ID_CATEGORY, entite.getIdSubcategory());
		
		mBDD.insert(BDD.TN_EXERCICE, null, contentValues);
	}

	/**
	 * Met à jour le exercice
	 */
	@Override
	public void Update(Exercice entite) {
		ContentValues contentValues = new ContentValues();

		contentValues.put(BDD.EXERCICE_COLUMN_NAME, entite.getName());
		contentValues.put(BDD.EXERCICE_COLUMN_DESCRIPTION, entite.getDescription());
		contentValues.put(BDD.EXERCICE_COLUMN_ID_CATEGORY, entite.getIdSubcategory());
		
		mBDD.update(BDD.TN_EXERCICE, contentValues, BDD.EXERCICE_COLUMN_ID + "=?", new String[]{String.valueOf(entite.getId())});
	}

	/**
	 * Supprimer un exercice
	 */
	@Override
	public void Delete(int id) {
		mBDD.delete(BDD.TN_EXERCICE, BDD.EXERCICE_COLUMN_ID + "=?", new String[]{String.valueOf(id)});
	}

	/**
	 * Converti un curseur en une liste de exercices
	 */
	@Override
	public List<Exercice> ConvertCursorToListObject(Cursor c) {
		List<Exercice> liste = new ArrayList<Exercice>();
		// Si la liste est vide
		if (c.getCount() == 0)
			return liste;
		// position sur le premeir item
		c.moveToFirst();
		// Pour chaque item
		do {
			Exercice exec = ConvertCursorToObject(c);
			liste.add(exec);
		} while (c.moveToNext());
		// Fermeture du curseur
		c.close();

		return liste;
	}

	/**
	 * Méthode utilisée par ConvertCursorToObject et ConvertCursorToListObject
	 */
	@Override
	public Exercice ConvertCursorToObject(Cursor c) {
		
		Exercice exec = new Exercice();
		
		exec.setId(c.getInt(BDD.EXERCICE_NUM_ID));
		exec.setName(c.getString(BDD.EXERCICE_NUM_NAME));
		exec.setDescription(c.getString(BDD.EXERCICE_NUM_DESCRIPTION));
		exec.setIdSubcategory(c.getInt(BDD.EXERCICE_NUM_ID_CATEGORY));
		
		return exec;
	}
	
	/**
	 * Converti un curseur en un exercice
	 */
	@Override
	public Exercice ConvertCursorToOneObject(Cursor c) {
		c.moveToFirst();
		
		Exercice exec = ConvertCursorToObject(c);
		
		c.close();
		return exec;
	}

}
