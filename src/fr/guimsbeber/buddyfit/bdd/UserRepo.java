package fr.guimsbeber.buddyfit.bdd;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;

public class UserRepo extends Repository<User>{

	public UserRepo(Context ctx){
		mSQLOH = new BDD(ctx, null);
	}

	@Override
	public List<User> GetAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Save(User entite) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Update(User entite) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Delete(int id) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Converti un curseur en une liste de users
	 */
	@Override
	public List<User> ConvertCursorToListObject(Cursor c) {
		List<User> liste = new ArrayList<User>();
		// Si la liste est vide
		if (c.getCount() == 0)
			return liste;
		// position sur le premeir item
		c.moveToFirst();
		// Pour chaque item
		do {
			User usr = ConvertCursorToObject(c);
			liste.add(usr);
		} while (c.moveToNext());
		// Fermeture du curseur
		c.close();

		return liste;
	}

	@Override
	public User ConvertCursorToObject(Cursor c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User ConvertCursorToOneObject(Cursor c) {
		// TODO Auto-generated method stub
		return null;
	}

}
