package pw.whacka.androidbitcoincenter;

import java.util.Vector;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MarketStoreSQLite extends SQLiteOpenHelper

implements MarketStore {

	// Métodos de SQLiteOpenHelper

	public MarketStoreSQLite(Context context) {

		super(context, "puntuaciones", null, 1);

	}

	@Override
	public void onCreate(SQLiteDatabase db) {

		db.execSQL("CREATE TABLE puntuaciones (" +

		"_id INTEGER PRIMARY KEY AUTOINCREMENT, " +

		"puntos INTEGER, nombre TEXT, fecha LONG)");

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

		// En caso de una nueva versión habría que actualizar las tablas

	}

	// Métodos de MarketStore

	@Override
	public void saveStore(int puntos, String nombre, long fecha) {

		SQLiteDatabase db = getWritableDatabase();

		db.execSQL("INSERT INTO puntuaciones VALUES ( null, " +

		puntos + ", '" + nombre + "', " + fecha + ")");

	}

	@Override
	public Vector<String> showStore(int cantidad) {

		Vector<String> result = new Vector<String>();

		SQLiteDatabase db = getReadableDatabase();

		Cursor cursor = db.rawQuery("SELECT puntos, nombre FROM "
				+ "puntuaciones ORDER BY puntos DESC LIMIT " + cantidad, null);

		while (cursor.moveToNext()) {

			result.add(cursor.getInt(0) + " " + cursor.getString(1));

		}

		cursor.close();

		return result;

	}

}