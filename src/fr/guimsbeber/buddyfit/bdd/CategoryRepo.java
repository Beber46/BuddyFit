package fr.guimsbeber.buddyfit.bdd;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

public class CategoryRepo extends Repository<Category>{
	
	private String[] mColumn = new String[]{
			BDD.CATEGORY_COLUMN_ID,
			BDD.CATEGORY_COLUMN_NAME,
			BDD.CATEGORY_COLUMN_DESCRIPTION
	};

	public CategoryRepo(Context ctx){
		mSQLOH = new BDD(ctx, null);
	}

	/**
	 * Récupération des la liste des Category
	 */
	@Override
	public List<Category> GetAll() {
		Cursor c = mBDD.query(BDD.TN_CATEGORY, mColumn , null, null, null, null, null);
		
		return ConvertCursorToListObject(c);
	}

	@Override
	public Category GetById(int id) {
		Cursor c = mBDD.query(BDD.TN_CATEGORY, mColumn , String.valueOf(id), null, null, null, null);
		
		return ConvertCursorToObject(c);
	}
	
	/**
	 * Enregistre un category
	 */
	@Override
	public void Save(Category entite) {
		ContentValues contentValues = new ContentValues();

		contentValues.put(BDD.CATEGORY_COLUMN_NAME, entite.getName());
		contentValues.put(BDD.CATEGORY_COLUMN_DESCRIPTION, entite.getDescription());
		
		mBDD.insert(BDD.TN_CATEGORY, null, contentValues);
	}

	/**
	 * Met à jour le category
	 */
	@Override
	public void Update(Category entite) {
		ContentValues contentValues = new ContentValues();

		contentValues.put(BDD.CATEGORY_COLUMN_NAME, entite.getName());
		contentValues.put(BDD.CATEGORY_COLUMN_DESCRIPTION, entite.getDescription());
		
		mBDD.update(BDD.TN_CATEGORY, contentValues, BDD.CATEGORY_COLUMN_ID + "=?", new String[]{String.valueOf(entite.getId())});
	}

	/**
	 * Supprimer un category
	 */
	@Override
	public void Delete(int id) {
		mBDD.delete(BDD.TN_CATEGORY, BDD.CATEGORY_COLUMN_ID + "=?", new String[]{String.valueOf(id)});
	}

	/**
	 * Converti un curseur en une liste de categorys
	 */
	@Override
	public List<Category> ConvertCursorToListObject(Cursor c) {
		List<Category> liste = new ArrayList<Category>();
		// Si la liste est vide
		if (c.getCount() == 0)
			return liste;
		// position sur le premeir item
		c.moveToFirst();
		// Pour chaque item
		do {
			Category cat = ConvertCursorToObject(c);
			liste.add(cat);
		} while (c.moveToNext());
		// Fermeture du curseur
		c.close();

		return liste;
	}

	/**
	 * Méthode utilisée par ConvertCursorToObject et ConvertCursorToListObject
	 */
	@Override
	public Category ConvertCursorToObject(Cursor c) {
		
		Category cat = new Category();
		
		cat.setId(c.getInt(BDD.CATEGORY_NUM_ID));
		cat.setName(c.getString(BDD.CATEGORY_NUM_NAME));
		cat.setDescription(c.getString(BDD.CATEGORY_NUM_DESCRIPTION));
		
		return cat;
	}
	
	/**
	 * Converti un curseur en un category
	 */
	@Override
	public Category ConvertCursorToOneObject(Cursor c) {
		c.moveToFirst();
		
		Category cat = ConvertCursorToObject(c);
		
		c.close();
		return cat;
	}

}
