package fr.guimsbeber.buddyfit.bdd;

import java.util.ArrayList;
import java.util.List;

import fr.guimsbeber.buddyfit.objet.User;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

public class UserRepo extends Repository<User>{
	
	private String[] mColumn = new String[]{
			BDD.USER_COLUMN_ID,
			BDD.USER_COLUMN_NAME,
			BDD.USER_COLUMN_FIRSTNAME,
			BDD.USER_COLUMN_MAIL,
			BDD.USER_COLUMN_SEX,
			BDD.USER_COLUMN_SIZE,
			BDD.USER_COLUMN_WEIGHT,
			BDD.USER_COLUMN_BIRTHDAY,
			BDD.USER_COLUMN_PASSWORD,
			BDD.USER_COLUMN_AVATAR
	};

	public UserRepo(Context ctx){
		mSQLOH = new BDD(ctx, null);
	}

	/**
	 * Récupération des la liste des User
	 */
	@Override
	public List<User> GetAll() {
		Cursor c = mBDD.query(BDD.TN_USER, mColumn , null, null, null, null, null);
		
		return ConvertCursorToListObject(c);
	}

	@Override
	public User GetById(int id) {
		Cursor c = mBDD.query(BDD.TN_USER, mColumn , String.valueOf(id), null, null, null, null);
		
		return ConvertCursorToObject(c);
	}
	
	/**
	 * Enregistre un user
	 */
	@Override
	public void Save(User entite) {
		ContentValues contentValues = new ContentValues();

		contentValues.put(BDD.USER_COLUMN_NAME, entite.getName());
		contentValues.put(BDD.USER_COLUMN_FIRSTNAME, entite.getFirstname());
		contentValues.put(BDD.USER_COLUMN_MAIL, entite.getMail());
		contentValues.put(BDD.USER_COLUMN_SEX, entite.getSex());
		contentValues.put(BDD.USER_COLUMN_SIZE, entite.getSize());
		contentValues.put(BDD.USER_COLUMN_WEIGHT, entite.getWeight());
		contentValues.put(BDD.USER_COLUMN_BIRTHDAY, entite.getBirthday());
		contentValues.put(BDD.USER_COLUMN_PASSWORD, entite.getPassword());
		contentValues.put(BDD.USER_COLUMN_AVATAR, entite.getAvatar());
		
		mBDD.insert(BDD.TN_USER, null, contentValues);
	}

	/**
	 * Met à jour le user
	 */
	@Override
	public void Update(User entite) {
		ContentValues contentValues = new ContentValues();

		contentValues.put(BDD.USER_COLUMN_NAME, entite.getName());
		contentValues.put(BDD.USER_COLUMN_FIRSTNAME, entite.getFirstname());
		contentValues.put(BDD.USER_COLUMN_MAIL, entite.getMail());
		contentValues.put(BDD.USER_COLUMN_SEX, entite.getSex());
		contentValues.put(BDD.USER_COLUMN_SIZE, entite.getSize());
		contentValues.put(BDD.USER_COLUMN_WEIGHT, entite.getWeight());
		contentValues.put(BDD.USER_COLUMN_BIRTHDAY, entite.getBirthday());
		contentValues.put(BDD.USER_COLUMN_PASSWORD, entite.getPassword());
		contentValues.put(BDD.USER_COLUMN_AVATAR, entite.getAvatar());
		
		mBDD.update(BDD.TN_USER, contentValues, BDD.USER_COLUMN_ID + "=?", new String[]{String.valueOf(entite.getId())});
	}

	/**
	 * Supprimer un user
	 */
	@Override
	public void Delete(int id) {
		mBDD.delete(BDD.TN_USER, BDD.USER_COLUMN_ID + "=?", new String[]{String.valueOf(id)});
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

	/**
	 * Méthode utilisée par ConvertCursorToObject et ConvertCursorToListObject
	 */
	@Override
	public User ConvertCursorToObject(Cursor c) {
		
		User usr = new User();
		
		usr.setId(c.getInt(BDD.USER_NUM_ID));
		usr.setName(c.getString(BDD.USER_NUM_NAME));
		usr.setFirstname(c.getString(BDD.USER_NUM_FIRSTNAME));
		usr.setMail(c.getString(BDD.USER_NUM_MAIL));
		usr.setSex(c.getInt(BDD.USER_NUM_SEX));
		usr.setSize(c.getFloat(BDD.USER_NUM_SIZE));
		usr.setWeight((c.getFloat(BDD.USER_NUM_WEIGHT)));
		usr.setBirthday(c.getInt(BDD.USER_NUM_BIRTHDAY));
		usr.setPassword(c.getString(BDD.USER_NUM_PASSWORD));
		usr.setAvatar(c.getString(BDD.USER_NUM_AVATAR));
		
		return usr;
	}
	
	/**
	 * Converti un curseur en un user
	 */
	@Override
	public User ConvertCursorToOneObject(Cursor c) {
		c.moveToFirst();
		
		User usr = ConvertCursorToObject(c);
		
		c.close();
		return usr;
	}

}
