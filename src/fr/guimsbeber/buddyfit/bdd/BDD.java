package fr.guimsbeber.buddyfit.bdd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class BDD  extends SQLiteOpenHelper{
	
	//Version de la base de données
	private static final int DATABASE_VERSION = 1;
	
	//Nom de la base
	private static final String BASE_NAME = "buddyfit.db";
	
	/**
	 * Partie de la création de la table user
	 */
	public static final String TN_USER = "User";//TN = Table Name

	public static final String USER_COLUMN_ID = "ID";
	public static final String USER_COLUMN_NAME = "NAME";
	public static final String USER_COLUMN_FIRSTNAME = "FIRSTNAME";
	public static final String USER_COLUMN_MAIL = "MAIL";
	public static final String USER_COLUMN_BIRTHDAY = "BIRTHDAY";
	public static final String USER_COLUMN_WEIGHT = "WEIGHT";
	public static final String USER_COLUMN_SIZE = "SIZE";
	public static final String USER_COLUMN_SEX = "SEX";
	public static final String USER_COLUMN_PASSWORD = "PASSWORD";
	public static final String USER_COLUMN_AVATAR = "AVATAR";
	
	private static final String REQUETE_CREATION_USER = "CREATE TABLE "+TN_USER+" " +
			"("+USER_COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
			+USER_COLUMN_NAME+" TEXT, "
			+USER_COLUMN_FIRSTNAME+" TEXT, "
			+USER_COLUMN_MAIL+" TEXT NOT NULL, "
			+USER_COLUMN_BIRTHDAY+" INTEGER, "
			+USER_COLUMN_WEIGHT+" REAL, "
			+USER_COLUMN_SIZE+" REAL, "
			+USER_COLUMN_SEX+" BLOB, "
			+USER_COLUMN_PASSWORD+" TEXT NOT NULL, "
			+USER_COLUMN_AVATAR+" TEXT, ";
	/**
	 * Constructeur provenant de l'héritage
	 * @param context
	 * @param name
	 * @param factory
	 * @param version
	 */
	public BDD(Context context,CursorFactory factory) {
		super(context, BASE_NAME, factory, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		
		//Création de la table user
		db.execSQL(REQUETE_CREATION_USER);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Lorsque l'on change le numéro de version de la base on supprime la
	    // table puis on la recrée
	    if (newVersion > DATABASE_VERSION) {
	        db.execSQL("DROP TABLE " + TN_USER + ";");
	        onCreate(db);
	    }
	}

}
