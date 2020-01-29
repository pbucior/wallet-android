package eu.bucior.wallet.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import eu.bucior.wallet.model.Operation;
import eu.bucior.wallet.util.Util;


public class DatabaseHandler extends SQLiteOpenHelper {

    public DatabaseHandler(Context context) {
        super(context, Util.DATABASE_NAME, null, Util.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_OPERATIONS_TABLE =
                String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY,%s INTEGER,%s TEXT,%s REAL,%s TEXT,%s TEXT)",
                        Util.TABLE_NAME, Util.KEY_ID, Util.KEY_DATE_ADDED, Util.KEY_DATE_OPERATION, Util.KEY_AMOUNT, Util.KEY_DESCRIPTION, Util.KEY_POSTING_KEY);
        db.execSQL(CREATE_OPERATIONS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + Util.TABLE_NAME);

        onCreate(db);
    }

    public void addOperation(Operation operation) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Util.KEY_DATE_ADDED, operation.getDateAdded());
        values.put(Util.KEY_DATE_OPERATION, operation.getDateOperation());
        values.put(Util.KEY_AMOUNT, operation.getAmount());
        values.put(Util.KEY_DESCRIPTION, operation.getDescription());
        values.put(Util.KEY_POSTING_KEY, operation.getPostingKey());

        db.insert(Util.TABLE_NAME, null, values);

        db.close();
    }
}
