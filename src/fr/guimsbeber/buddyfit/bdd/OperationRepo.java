package fr.guimsbeber.buddyfit.bdd;

import java.util.ArrayList;
import java.util.List;

import fr.guimsbeber.buddyfit.objet.Operation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

public class OperationRepo extends Repository<Operation>{
	
	private String[] mColumn = new String[]{
			BDD.OPERATION_COLUMN_ID,
			BDD.OPERATION_COLUMN_NBSERIES,
			BDD.OPERATION_COLUMN_NBREPETITION,
			BDD.OPERATION_COLUMN_BURDEN,
			BDD.OPERATION_COLUMN_DATEOP,
			BDD.OPERATION_COLUMN_ID_EXERCICE
	};

	public OperationRepo(Context ctx){
		mSQLOH = new BDD(ctx, null);
	}

	/**
	 * Récupération des la liste des Operation
	 */
	@Override
	public List<Operation> GetAll() {
		Cursor c = mBDD.query(BDD.TN_OPERATION, mColumn , null, null, null, null, null);
		
		return ConvertCursorToListObject(c);
	}

	@Override
	public Operation GetById(int id) {
		Cursor c = mBDD.query(BDD.TN_OPERATION, mColumn , String.valueOf(id), null, null, null, null);
		
		return ConvertCursorToObject(c);
	}
	
	/**
	 * Enregistre un operation
	 */
	@Override
	public void Save(Operation entite) {
		ContentValues contentValues = new ContentValues();

		contentValues.put(BDD.OPERATION_COLUMN_NBSERIES, entite.getNbseries());
		contentValues.put(BDD.OPERATION_COLUMN_NBREPETITION, entite.getNbrepetition());
		contentValues.put(BDD.OPERATION_COLUMN_DATEOP, entite.getDateop());
		contentValues.put(BDD.OPERATION_COLUMN_BURDEN, entite.getBurden());
		contentValues.put(BDD.OPERATION_COLUMN_ID_EXERCICE, entite.getIdExercice());
		
		mBDD.insert(BDD.TN_OPERATION, null, contentValues);
	}

	/**
	 * Met à jour le operation
	 */
	@Override
	public void Update(Operation entite) {
		ContentValues contentValues = new ContentValues();

		contentValues.put(BDD.OPERATION_COLUMN_NBSERIES, entite.getNbseries());
		contentValues.put(BDD.OPERATION_COLUMN_NBREPETITION, entite.getNbrepetition());
		contentValues.put(BDD.OPERATION_COLUMN_DATEOP, entite.getDateop());
		contentValues.put(BDD.OPERATION_COLUMN_BURDEN, entite.getBurden());
		contentValues.put(BDD.OPERATION_COLUMN_ID_EXERCICE, entite.getIdExercice());
		
		mBDD.update(BDD.TN_OPERATION, contentValues, BDD.OPERATION_COLUMN_ID + "=?", new String[]{String.valueOf(entite.getId())});
	}

	/**
	 * Supprimer un operation
	 */
	@Override
	public void Delete(int id) {
		mBDD.delete(BDD.TN_OPERATION, BDD.OPERATION_COLUMN_ID + "=?", new String[]{String.valueOf(id)});
	}

	/**
	 * Converti un curseur en une liste de operations
	 */
	@Override
	public List<Operation> ConvertCursorToListObject(Cursor c) {
		List<Operation> liste = new ArrayList<Operation>();
		// Si la liste est vide
		if (c.getCount() == 0)
			return liste;
		// position sur le premeir item
		c.moveToFirst();
		// Pour chaque item
		do {
			Operation ope = ConvertCursorToObject(c);
			liste.add(ope);
		} while (c.moveToNext());
		// Fermeture du curseur
		c.close();

		return liste;
	}

	/**
	 * Méthode utilisée par ConvertCursorToObject et ConvertCursorToListObject
	 */
	@Override
	public Operation ConvertCursorToObject(Cursor c) {
		
		Operation ope = new Operation();
		
		ope.setId(c.getInt(BDD.OPERATION_NUM_ID));
		ope.setId(c.getInt(BDD.OPERATION_NUM_NBSERIES));
		ope.setId(c.getInt(BDD.OPERATION_NUM_NBREPETITION));
		ope.setId(c.getInt(BDD.OPERATION_NUM_BURDEN));
		ope.setId(c.getInt(BDD.OPERATION_NUM_DATEOP));
		ope.setId(c.getInt(BDD.OPERATION_NUM_ID_EXERCICE));
		
		return ope;
	}
	
	/**
	 * Converti un curseur en un operation
	 */
	@Override
	public Operation ConvertCursorToOneObject(Cursor c) {
		c.moveToFirst();
		
		Operation ope = ConvertCursorToObject(c);
		
		c.close();
		return ope;
	}

}
