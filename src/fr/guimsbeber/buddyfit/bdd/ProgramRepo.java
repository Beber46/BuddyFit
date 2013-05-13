package fr.guimsbeber.buddyfit.bdd;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

public class ProgramRepo extends Repository<Program>{
	
	private String[] mColumn = new String[]{
			BDD.PROGRAM_COLUMN_ID,
			BDD.PROGRAM_COLUMN_NAME,
			BDD.PROGRAM_COLUMN_DESCRIPTION,
			BDD.PROGRAM_COLUMN_BEGINDATE,
			BDD.PROGRAM_COLUMN_ENDDATE,
			BDD.PROGRAM_COLUMN_ID_USER
	};

	public ProgramRepo(Context ctx){
		mSQLOH = new BDD(ctx, null);
	}

	/**
	 * Récupération des la liste des Program
	 */
	@Override
	public List<Program> GetAll() {
		Cursor c = mBDD.query(BDD.TN_PROGRAM, mColumn , null, null, null, null, null);
		
		return ConvertCursorToListObject(c);
	}

	@Override
	public Program GetById(int id) {
		Cursor c = mBDD.query(BDD.TN_PROGRAM, mColumn , String.valueOf(id), null, null, null, null);
		
		return ConvertCursorToObject(c);
	}
	
	/**
	 * Enregistre un program
	 */
	@Override
	public void Save(Program entite) {
		ContentValues contentValues = new ContentValues();

		contentValues.put(BDD.PROGRAM_COLUMN_NAME, entite.getName());
		contentValues.put(BDD.PROGRAM_COLUMN_DESCRIPTION, entite.getDescription());
		contentValues.put(BDD.PROGRAM_COLUMN_BEGINDATE, entite.getBegindate());
		contentValues.put(BDD.PROGRAM_COLUMN_ENDDATE, entite.getEnddate());
		contentValues.put(BDD.PROGRAM_COLUMN_ID_USER, entite.getIdUser());
		
		mBDD.insert(BDD.TN_PROGRAM, null, contentValues);
	}

	/**
	 * Met à jour le program
	 */
	@Override
	public void Update(Program entite) {
		ContentValues contentValues = new ContentValues();

		contentValues.put(BDD.PROGRAM_COLUMN_NAME, entite.getName());
		contentValues.put(BDD.PROGRAM_COLUMN_DESCRIPTION, entite.getDescription());
		contentValues.put(BDD.PROGRAM_COLUMN_BEGINDATE, entite.getBegindate());
		contentValues.put(BDD.PROGRAM_COLUMN_ENDDATE, entite.getEnddate());
		contentValues.put(BDD.PROGRAM_COLUMN_ID_USER, entite.getIdUser());
		
		mBDD.update(BDD.TN_PROGRAM, contentValues, BDD.PROGRAM_COLUMN_ID + "=?", new String[]{String.valueOf(entite.getId())});
	}

	/**
	 * Supprimer un program
	 */
	@Override
	public void Delete(int id) {
		mBDD.delete(BDD.TN_PROGRAM, BDD.PROGRAM_COLUMN_ID + "=?", new String[]{String.valueOf(id)});
	}

	/**
	 * Converti un curseur en une liste de programs
	 */
	@Override
	public List<Program> ConvertCursorToListObject(Cursor c) {
		List<Program> liste = new ArrayList<Program>();
		// Si la liste est vide
		if (c.getCount() == 0)
			return liste;
		// position sur le premeir item
		c.moveToFirst();
		// Pour chaque item
		do {
			Program prog = ConvertCursorToObject(c);
			liste.add(prog);
		} while (c.moveToNext());
		// Fermeture du curseur
		c.close();

		return liste;
	}

	/**
	 * Méthode utilisée par ConvertCursorToObject et ConvertCursorToListObject
	 */
	@Override
	public Program ConvertCursorToObject(Cursor c) {
		
		Program prog = new Program();
		
		prog.setId(c.getInt(BDD.PROGRAM_NUM_ID));
		prog.setName(c.getString(BDD.PROGRAM_NUM_NAME));
		prog.setDescription(c.getString(BDD.PROGRAM_NUM_DESCRIPTION));
		prog.setBegindate(c.getInt(BDD.PROGRAM_NUM_BEGINDATE));
		prog.setEnddate(c.getInt(BDD.PROGRAM_NUM_ENDDATE));
		prog.setIdUser(c.getInt(BDD.PROGRAM_NUM_ID_USER));
		
		return prog;
	}
	
	/**
	 * Converti un curseur en un program
	 */
	@Override
	public Program ConvertCursorToOneObject(Cursor c) {
		c.moveToFirst();
		
		Program prog = ConvertCursorToObject(c);
		
		c.close();
		return prog;
	}

}
