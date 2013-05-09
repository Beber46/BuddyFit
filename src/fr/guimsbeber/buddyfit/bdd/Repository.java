package fr.guimsbeber.buddyfit.bdd;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public abstract class Repository implements IRepository<Object>{
	//BDD
	protected SQLiteDatabase mBDD;
	protected SQLiteOpenHelper mSQLOH;
	
	public Repository() {
		
	}
	
	public void Open(){
		mBDD = mSQLOH.getWritableDatabase();
	}
	
	public void Close(){
		mBDD.close();
	}
}
