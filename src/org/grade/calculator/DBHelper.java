package org.grade.calculator;  

import android.content.Context;  
import android.database.Cursor;  
import android.database.sqlite.SQLiteDatabase;  
import android.database.sqlite.SQLiteOpenHelper;  

public class DBHelper extends SQLiteOpenHelper {  

	// Define the version and database file name  
	private static final String DB_NAME = "gradecalc.db";  
	private static final int DB_VERSION = 1;  

	// Use a static class to defined the data structure  
	// This will come in very handy if you using Agile   
	// As your development model  
	private static class ClassTable {  
		private static final String NAME = "classTable";  
		private static final String COL_NAME = "name";  
	}  
	private static class GradeCatsTable {  
		private static final String NAME = "gradeCats";  
		private static final String COL_NAME = "name";  
		private static final String COL_CLASS = "className";
		private static final String COL_CATVALUE = "catValue";  

	}  
	private static class AssignmentsTable {  
		private static final String NAME = "assign";  
		private static final String COL_NAME = "name";  
		private static final String COL_CLASS = "className";  
		private static final String COL_GRADE = "gradeCat";
		private static final String COL_PTS = "points";
		private static final String COL_PTSTOTAL = "pointsTotal";
	}  

	private static SQLiteDatabase db;  

	// Constructor to simplify Business logic access to the repository   
	public DBHelper(Context context) {  

		super(context, DB_NAME, null, DB_VERSION);  
		// Android will look for the database defined by DB_NAME  
		// And if not found will invoke your onCreate method  
		this.db = this.getWritableDatabase();  

	}  

	@Override  
	public void onCreate(SQLiteDatabase db) {  

		// Android has created the database identified by DB_NAME  
		// The new database is passed to you vai the db arg  
		// Now it is up to you to create the Schema.  
		// This schema creates a very simple user table, in order  
		// Store user login credentials  
		db.execSQL("CREATE TABLE "+ClassTable.NAME+" ("+ClassTable.COL_NAME+ " TEXT PRIMARY KEY , "+ ")");

		db.execSQL("CREATE TABLE " + GradeCatsTable.NAME + " (" +
				GradeCatsTable.COL_NAME + "TEXT NOT NULL, " + 
				GradeCatsTable.COL_CATVALUE + "INTEGER NOT NULL, " + 
				GradeCatsTable.COL_CLASS + "TEXT NOT NULL, " +
				"PRIMARY KEY(" + GradeCatsTable.COL_NAME + ", " + GradeCatsTable.COL_CLASS + "))");

		db.execSQL("CREATE TABLE " + AssignmentsTable.NAME + " (" +
				AssignmentsTable.COL_NAME + "TEXT NOT NULL, "+
				AssignmentsTable.COL_CLASS + "TEXT NOT NULL, " +
				AssignmentsTable.COL_PTS + "INTEGER NOT NULL," +
				AssignmentsTable.COL_PTSTOTAL + "INTEGER NOT NULL," + 
				"PRIMARY KEY(" + AssignmentsTable.COL_NAME + ", " +AssignmentsTable.COL_CLASS + "))");

	}  


	public String[] getUserCredentials() throws Exception{  

		String[] creds;  
		Cursor cursor;  

		creds = new String[3];  

		/*  cursor = this.db.query(UserTable.NAME, new String[] {  
                UserTable.COL_USERNAME, UserTable.COL_PASSWORD},   
                                null, null, null, null, null);  

        if (cursor.moveToFirst()) {  

            creds[0] = cursor.getString(0);  
            creds[1] = cursor.getString(1);  
            creds[2] = cursor.getString(2);  
            cursor.close();  

        } else {  

            throw new Exception("No User Credentials Found");  

        }  
		 */
		return creds;  

	}  

	@Override  
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {  
		// Later when you change the DB_VERSION   
		// This code will be invoked to bring your database  
		// Upto the correct specification  
	}  
}  