package fr.guimsbeber.buddyfit.bdd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class BDD  extends SQLiteOpenHelper{
	
	//Version de la base de donnees
	private static final int DATABASE_VERSION = 1;
	
	//Nom de la base
	private static final String BASE_NAME = "buddyfit.db";
	
	/**
	 * Partie de la creation de la table user
	 */
	public static final String TN_USER = "User";//TN = Table Name

	public static final String USER_COLUMN_ID = "ID";
	public static final int USER_NUM_ID = 0;
	public static final String USER_COLUMN_NAME = "NAME";
	public static final int USER_NUM_NAME = 1;
	public static final String USER_COLUMN_FIRSTNAME = "FIRSTNAME";
	public static final int USER_NUM_FIRSTNAME = 2;
	public static final String USER_COLUMN_MAIL = "MAIL";
	public static final int USER_NUM_MAIL = 3;
	public static final String USER_COLUMN_BIRTHDAY = "BIRTHDAY";
	public static final int USER_NUM_BIRTHDAY = 4;
	public static final String USER_COLUMN_WEIGHT = "WEIGHT";
	public static final int USER_NUM_WEIGHT = 5;
	public static final String USER_COLUMN_SIZE = "SIZE";
	public static final int USER_NUM_SIZE = 6;
	public static final String USER_COLUMN_SEX = "SEX";
	public static final int USER_NUM_SEX = 7;
	public static final String USER_COLUMN_PASSWORD = "PASSWORD";
	public static final int USER_NUM_PASSWORD = 8;
	public static final String USER_COLUMN_AVATAR = "AVATAR";
	public static final int USER_NUM_AVATAR = 9;
	
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
			+USER_COLUMN_AVATAR+" TEXT); ";
	/**
	 * Partie de la creation de la table Program
	 */
	public static final String TN_PROGRAM = "Program";//TN = Table Name
	
	public static final String PROGRAM_COLUMN_ID = "ID";
	public static final int PROGRAM_NUM_ID = 0;
	public static final String PROGRAM_COLUMN_NAME = "NAME";
	public static final int PROGRAM_NUM_NAME = 1;
	public static final String PROGRAM_COLUMN_BEGINDATE = "BEGINDATE";
	public static final int PROGRAM_NUM_BEGINDATE = 2;
	public static final String PROGRAM_COLUMN_ENDDATE = "ENDDATE";
	public static final int PROGRAM_NUM_ENDDATE = 3;
	public static final String PROGRAM_COLUMN_DESCRIPTION = "DESCRIPTION";
	public static final int PROGRAM_NUM_DESCRIPTION = 4;
	public static final String PROGRAM_COLUMN_ID_USER = "ID_USER";
	public static final int PROGRAM_NUM_ID_USER = 5;
	
	private static final String REQUETE_CREATION_PROGRAM = "CREATE TABLE "+TN_PROGRAM+" " +
			"("+PROGRAM_COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
			+PROGRAM_COLUMN_NAME+" TEXT NOT NULL, "
			+PROGRAM_COLUMN_BEGINDATE+" INTEGER NOT NULL, "
			+PROGRAM_COLUMN_ENDDATE+" INTEGER NOT NULL, "
			+PROGRAM_COLUMN_DESCRIPTION+" TEXT NOT NULL, "
			+PROGRAM_COLUMN_ID_USER+" INTEGER NOT NULL); ";
	
	/**
	 * Partie de la creation de la table session
	 */
	public static final String TN_SESSION = "Session";//TN = Table Name
	
	public static final String SESSION_COLUMN_ID = "ID";
	public static final int SESSION_NUM_ID = 0;
	public static final String SESSION_COLUMN_NAME = "NAME";
	public static final int SESSION_NUM_NAME = 1;
	public static final String SESSION_COLUMN_DESCRIPTION = "DESCRIPTION";
	public static final int SESSION_NUM_DESCRIPTION = 2;
	public static final String SESSION_COLUMN_ID_PROGRAM = "ID_PROGRAM";
	public static final int SESSION_NUM_ID_PROGRAM = 3;
	
	private static final String REQUETE_CREATION_SESSION = "CREATE TABLE "+TN_SESSION+" " +
			"("+SESSION_COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
			+SESSION_COLUMN_NAME+" TEXT NOT NULL, "
			+SESSION_COLUMN_DESCRIPTION+" TEXT NOT NULL," +
			SESSION_COLUMN_ID_PROGRAM+" INTEGER NOT NULL); ";
	
	/**
	 * Partie de la creation de la table category
	 */
	public static final String TN_CATEGORY = "Category";//TN = Table Name

	public static final String CATEGORY_COLUMN_ID = "ID";
	public static final int CATEGORY_NUM_ID = 0;
	public static final String CATEGORY_COLUMN_NAME = "NAME";
	public static final int CATEGORY_NUM_NAME = 1;
	public static final String CATEGORY_COLUMN_DESCRIPTION = "DESCRIPTION";
	public static final int CATEGORY_NUM_DESCRIPTION = 2;
	
	private static final String REQUETE_CREATION_CATEGORY = "CREATE TABLE "+TN_CATEGORY+" " +
			"("+CATEGORY_COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
			+CATEGORY_COLUMN_NAME+" TEXT NOT NULL, "
			+CATEGORY_COLUMN_DESCRIPTION+" TEXT NOT NULL); ";
	
//	/**
//	 * Partie de la creation de la table Subcategory
//	 */
//	public static final String TN_SUBCATEGORY = "SubCategory";//TN = Table Name
//	
//	public static final String SUBCATEGORY_COLUMN_ID = "ID";
//	public static final int SUBCATEGORY_NUM_ID = 0;
//	public static final String SUBCATEGORY_COLUMN_NAME = "NAME";
//	public static final int SUBCATEGORY_NUM_NAME = 1;
//	public static final String SUBCATEGORY_COLUMN_DESCRIPTION = "DESCRIPTION";
//	public static final int SUBCATEGORY_NUM_DESCRIPTION = 2;
//	public static final String SUBCATEGORY_COLUMN_ID_CATEGORY = "ID_CATEGORY";
//	public static final int SUBCATEGORY_NUM_ID_CATEGORY = 3;
//	
//	private static final String REQUETE_CREATION_SUBCATEGORY = "CREATE TABLE "+TN_SUBCATEGORY+" " +
//			"("+SUBCATEGORY_COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
//			+SUBCATEGORY_COLUMN_NAME+" TEXT NOT NULL, "
//			+SUBCATEGORY_COLUMN_DESCRIPTION+" TEXT NOT NULL," +
//			SUBCATEGORY_COLUMN_ID_CATEGORY+" INTEGER NOT NULL); ";
	
	/**
	 * Partie de la creation de la table Exercice
	 */
	public static final String TN_EXERCICE = "Exercice";//TN = Table Name
	
	public static final String EXERCICE_COLUMN_ID = "ID";
	public static final int EXERCICE_NUM_ID = 0;
	public static final String EXERCICE_COLUMN_NAME = "NAME";
	public static final int EXERCICE_NUM_NAME = 1;
	public static final String EXERCICE_COLUMN_DESCRIPTION = "DESCRIPTION";
	public static final int EXERCICE_NUM_DESCRIPTION = 2;
//	public static final String EXERCICE_COLUMN_ID_SUBCATEGORY = "ID_SUBCATEGORY";
	public static final String EXERCICE_COLUMN_ID_CATEGORY = "ID_CATEGORY";
	public static final int EXERCICE_NUM_ID_CATEGORY = 3;
	public static final String EXERCICE_COLUMN_PICTURE = "ID_PICTURE";
	public static final int EXERCICE_NUM_ID_PICTURE = 4;
	
	private static final String REQUETE_CREATION_EXERCICE = "CREATE TABLE "+TN_EXERCICE+" " +
			"("+EXERCICE_COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
			+EXERCICE_COLUMN_NAME+" TEXT NOT NULL, "
			+EXERCICE_COLUMN_DESCRIPTION+" TEXT NOT NULL," +
			EXERCICE_COLUMN_ID_CATEGORY+" INTEGER NOT NULL," +
			EXERCICE_COLUMN_PICTURE+" TEXT); ";
	
	/**
	 * Partie de la creation de la table operation
	 */
	public static final String TN_OPERATION = "Operation";//TN = Table Name
	
	public static final String OPERATION_COLUMN_ID = "ID";
	public static final int OPERATION_NUM_ID = 0;
	public static final String OPERATION_COLUMN_NBSERIES = "NBSERIES";
	public static final int OPERATION_NUM_NBSERIES = 1;
	public static final String OPERATION_COLUMN_NBREPETITION = "NBREPETITION";
	public static final int OPERATION_NUM_NBREPETITION = 2;
	public static final String OPERATION_COLUMN_BURDEN = "BURDEN";//charge
	public static final int OPERATION_NUM_BURDEN = 3;
	public static final String OPERATION_COLUMN_DATEOP = "DATEOP";
	public static final int OPERATION_NUM_DATEOP = 4;
	public static final String OPERATION_COLUMN_ID_EXERCICE = "ID_EXERCICE";
	public static final int OPERATION_NUM_ID_EXERCICE = 5;
	
	private static final String REQUETE_CREATION_OPERATION = "CREATE TABLE "+TN_OPERATION+" " +
			"("+OPERATION_COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
			+OPERATION_COLUMN_NBSERIES+" INTEGER NOT NULL, "
			+OPERATION_COLUMN_NBREPETITION+" INTEGER NOT NULL," +
			OPERATION_COLUMN_BURDEN+" REAL," +
			OPERATION_COLUMN_DATEOP+" INTEGER NOT NULL," +
			OPERATION_COLUMN_ID_EXERCICE+" INTEGER NOT NULL); ";
	
	/**
	 * Partie de la creation de la table SessionExercice
	 */
	public static final String TN_SESSIONEXERCICE = "SessionExercice";
	
	public static final String SESSIONEXERCICE_COLUMN_ID_SESSION = "ID_SESSION";
	public static final int SESSIONEXERCICE_NUM_ID_SESSION = 0;
	public static final String SESSIONEXERCICE_COLUMN_ID_EXERCICE = "ID_EXERCICE";
	public static final int SESSIONEXERCICE_NUM_ID_EXERCICE = 1;
	public static final String SESSIONEXERCICE_COLUMN_POSITION = "POSITION";
	public static final int SESSIONEXERCICE_NUM_POSITION = 2;
	public static final String SESSIONEXERCICE_COLUMN_TIMEOUT = "TIMEOUT";//charge
	public static final int SESSIONEXERCICE_NUM_TIMEOUT = 3;
	
	private static final String REQUETE_CREATION_SESSIONEXERCICE = "CREATE TABLE "+TN_SESSIONEXERCICE+" " +
			"("+SESSIONEXERCICE_COLUMN_ID_SESSION+" INTEGER NOT NULL, "
			+SESSIONEXERCICE_COLUMN_ID_EXERCICE+" INTEGER NOT NULL, "
			+SESSIONEXERCICE_COLUMN_POSITION+" INTEGER NOT NULL," +
			SESSIONEXERCICE_COLUMN_TIMEOUT+" REAL);";
	
	/**
	 * Partie de la creatin de la table Tips
	 */
	public static final String TN_TIPS = "Tips";
	
	public static final String TIPS_COLUMN_ID = "ID";
	public static final int TIPS_NUM_ID = 0;
	public static final String TIPS_COLUMN_DESCRIPTION = "DESCRIPTION";
	public static final int TIPS_NUM_DESCRIPTION = 1;
	public static final String TIPS_COLUMN_ID_EXERCICE = "ID_EXERCICE";
	public static final int TIPS_NUM_ID_EXERCICE = 2;
	
	private static final String REQUETE_CREATION_TIPS = "CREATE TABLE "+TN_TIPS+" " +
			"("+TIPS_COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
			+TIPS_COLUMN_DESCRIPTION+" TEXT NOT NULL, "
			+TIPS_COLUMN_ID_EXERCICE+" INTEGER NOT NULL);";
	
	/**
	 * Constructeur provenant de l'heritage
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
		
		//Creation de la table user
		db.execSQL(REQUETE_CREATION_USER);
		
		//Creation de la table program
		db.execSQL(REQUETE_CREATION_PROGRAM);
		
		//Creation de la table session
		db.execSQL(REQUETE_CREATION_SESSION);
		
		//Creation de la table category
		db.execSQL(REQUETE_CREATION_CATEGORY);
		
		//CReation de la table subcategory
//		db.execSQL(REQUETE_CREATION_SUBCATEGORY);
		
		//Creation de la table exercice
		db.execSQL(REQUETE_CREATION_EXERCICE);
		
		//Creatin de la table operation
		db.execSQL(REQUETE_CREATION_OPERATION);
		
		//Creation de la table sessionexercice
		db.execSQL(REQUETE_CREATION_SESSIONEXERCICE);
		
		//Création de la table tips
		db.execSQL(REQUETE_CREATION_TIPS);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Lorsque l'on change le numero de version de la base on supprime la
	    // table puis on la recree
	    if (newVersion > DATABASE_VERSION) {
	        db.execSQL("DROP TABLE " + TN_USER + ";");
	        db.execSQL("DROP TABLE " + TN_PROGRAM + ";");
	        db.execSQL("DROP TABLE " + TN_SESSION + ";");
	        db.execSQL("DROP TABLE " + TN_CATEGORY + ";");
//	        db.execSQL("DROP TABLE " + TN_SUBCATEGORY + ";");
	        db.execSQL("DROP TABLE " + TN_EXERCICE + ";");
	        db.execSQL("DROP TABLE " + TN_OPERATION + ";");
	        db.execSQL("DROP TABLE " + TN_SESSIONEXERCICE+ ";");
	        db.execSQL("DROP TABLE " + TN_TIPS+ ";");
	        onCreate(db);
	    }
	}

}
