package fr.guimsbeber.buddyfit.bdd;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

public class SubCategoryRepo extends Repository<SubCategory>{
	
	private String[] mColumn = new String[]{
			BDD.SUBCATEGORY_COLUMN_ID,
			BDD.SUBCATEGORY_COLUMN_NAME,
			BDD.SUBCATEGORY_COLUMN_DESCRIPTION,
			BDD.SUBCATEGORY_COLUMN_ID_CATEGORY
	};

	public SubCategoryRepo(Context ctx){
		mSQLOH = new BDD(ctx, null);
	}

	/**
	 * Récupération des la liste des SubCategory
	 */
	@Override
	public List<SubCategory> GetAll() {
		Cursor c = mBDD.query(BDD.TN_SUBCATEGORY, mColumn , null, null, null, null, null);
		
		return ConvertCursorToListObject(c);
	}

	@Override
	public SubCategory GetById(int id) {
		Cursor c = mBDD.query(BDD.TN_SUBCATEGORY, mColumn , String.valueOf(id), null, null, null, null);
		
		return ConvertCursorToObject(c);
	}
	
	/**
	 * Enregistre un subcategory
	 */
	@Override
	public void Save(SubCategory entite) {
		ContentValues contentValues = new ContentValues();

		contentValues.put(BDD.SUBCATEGORY_COLUMN_NAME, entite.getName());
		contentValues.put(BDD.SUBCATEGORY_COLUMN_DESCRIPTION, entite.getDescription());
		contentValues.put(BDD.SUBCATEGORY_COLUMN_ID_CATEGORY, entite.getIdCategory());
		
		mBDD.insert(BDD.TN_SUBCATEGORY, null, contentValues);
	}

	/**
	 * Met à jour le subcategory
	 */
	@Override
	public void Update(SubCategory entite) {
		ContentValues contentValues = new ContentValues();

		contentValues.put(BDD.SUBCATEGORY_COLUMN_NAME, entite.getName());
		contentValues.put(BDD.SUBCATEGORY_COLUMN_DESCRIPTION, entite.getDescription());
		contentValues.put(BDD.SUBCATEGORY_COLUMN_ID_CATEGORY, entite.getIdCategory());
		
		mBDD.update(BDD.TN_SUBCATEGORY, contentValues, BDD.SUBCATEGORY_COLUMN_ID + "=?", new String[]{String.valueOf(entite.getId())});
	}

	/**
	 * Supprimer un subcategory
	 */
	@Override
	public void Delete(int id) {
		mBDD.delete(BDD.TN_SUBCATEGORY, BDD.SUBCATEGORY_COLUMN_ID + "=?", new String[]{String.valueOf(id)});
	}

	/**
	 * Converti un curseur en une liste de subcategorys
	 */
	@Override
	public List<SubCategory> ConvertCursorToListObject(Cursor c) {
		List<SubCategory> liste = new ArrayList<SubCategory>();
		// Si la liste est vide
		if (c.getCount() == 0)
			return liste;
		// position sur le premeir item
		c.moveToFirst();
		// Pour chaque item
		do {
			SubCategory subcat = ConvertCursorToObject(c);
			liste.add(subcat);
		} while (c.moveToNext());
		// Fermeture du curseur
		c.close();

		return liste;
	}

	/**
	 * Méthode utilisée par ConvertCursorToObject et ConvertCursorToListObject
	 */
	@Override
	public SubCategory ConvertCursorToObject(Cursor c) {
		
		SubCategory subcat = new SubCategory();
		
		subcat.setId(c.getInt(BDD.SUBCATEGORY_NUM_ID));
		subcat.setName(c.getString(BDD.SUBCATEGORY_NUM_NAME));
		subcat.setDescription(c.getString(BDD.SUBCATEGORY_NUM_DESCRIPTION));
		subcat.setIdCategory(c.getInt(BDD.SUBCATEGORY_NUM_ID_CATEGORY));
		
		return subcat;
	}
	
	/**
	 * Converti un curseur en un subcategory
	 */
	@Override
	public SubCategory ConvertCursorToOneObject(Cursor c) {
		c.moveToFirst();
		
		SubCategory subcat = ConvertCursorToObject(c);
		
		c.close();
		return subcat;
	}

}