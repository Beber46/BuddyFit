package fr.guimsbeber.buddyfit.bdd;

import java.util.ArrayList;
import java.util.List;

import fr.guimsbeber.buddyfit.objet.Tips;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

public class TipsRepo extends Repository<Tips>{
	
	private String[] mColumn = new String[]{
			BDD.TIPS_COLUMN_ID,
			BDD.TIPS_COLUMN_DESCRIPTION,
			BDD.TIPS_COLUMN_ID_EXERCICE
	};

	public TipsRepo(Context ctx){
		mSQLOH = new BDD(ctx, null);
	}

	/**
	 * Récupération des la liste des Tips
	 */
	@Override
	public List<Tips> GetAll() {
		Cursor c = mBDD.query(BDD.TN_TIPS, mColumn , null, null, null, null, null);
		
		return ConvertCursorToListObject(c);
	}

	@Override
	public Tips GetById(int id) {
		Cursor c = mBDD.query(BDD.TN_TIPS, mColumn , String.valueOf(id), null, null, null, null);
		
		return ConvertCursorToObject(c);
	}
	
	/**
	 * Enregistre un tips
	 */
	@Override
	public void Save(Tips entite) {
		ContentValues contentValues = new ContentValues();

		contentValues.put(BDD.TIPS_COLUMN_DESCRIPTION, entite.getDescription());
		contentValues.put(BDD.TIPS_COLUMN_ID_EXERCICE, entite.getIdExercice());
		
		mBDD.insert(BDD.TN_TIPS, null, contentValues);
	}

	/**
	 * Met à jour le tips
	 */
	@Override
	public void Update(Tips entite) {
		ContentValues contentValues = new ContentValues();

		contentValues.put(BDD.TIPS_COLUMN_DESCRIPTION, entite.getDescription());
		contentValues.put(BDD.TIPS_COLUMN_ID_EXERCICE, entite.getIdExercice());
		
		mBDD.update(BDD.TN_TIPS, contentValues, BDD.TIPS_COLUMN_ID + "=?", new String[]{String.valueOf(entite.getId())});
	}

	/**
	 * Supprimer un tips
	 */
	@Override
	public void Delete(int id) {
		mBDD.delete(BDD.TN_TIPS, BDD.TIPS_COLUMN_ID + "=?", new String[]{String.valueOf(id)});
	}

	/**
	 * Converti un curseur en une liste de tipss
	 */
	@Override
	public List<Tips> ConvertCursorToListObject(Cursor c) {
		List<Tips> liste = new ArrayList<Tips>();
		// Si la liste est vide
		if (c.getCount() == 0)
			return liste;
		// position sur le premeir item
		c.moveToFirst();
		// Pour chaque item
		do {
			Tips tips = ConvertCursorToObject(c);
			liste.add(tips);
		} while (c.moveToNext());
		// Fermeture du curseur
		c.close();

		return liste;
	}

	/**
	 * Méthode utilisée par ConvertCursorToObject et ConvertCursorToListObject
	 */
	@Override
	public Tips ConvertCursorToObject(Cursor c) {
		
		Tips tips = new Tips();

		tips.setId(c.getInt(BDD.TIPS_NUM_ID));
		tips.setDescription(c.getString(BDD.TIPS_NUM_DESCRIPTION));
		tips.setIdExercice(c.getInt(BDD.TIPS_NUM_ID_EXERCICE));
		
		return tips;
	}
	
	/**
	 * Converti un curseur en un tips
	 */
	@Override
	public Tips ConvertCursorToOneObject(Cursor c) {
		c.moveToFirst();
		
		Tips tips = ConvertCursorToObject(c);
		
		c.close();
		return tips;
	}

}
