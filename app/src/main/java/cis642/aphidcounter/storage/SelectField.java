package cis642.aphidcounter.storage;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import cis642.aphidcounter.R;
import cis642.aphidcounter.entity.Field;
import cis642.aphidcounter.storage.DatabaseOpenHelper;


/**
 * Created by JacobLPruitt on 10/26/2014.
 */
public class SelectField extends ListActivity {
   //get saved file from android device
    //show list of Fields from saved file
    public ArrayList<Field> listOfFields;

    private DatabaseOpenHelper mDbHelper;
    private SimpleCursorAdapter mAdapter;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_field_layout);

        mDbHelper = new DatabaseOpenHelper(this);

        Intent myIntent = getIntent();

        Cursor c = getAllFields();
        mAdapter = new SimpleCursorAdapter(this, R.layout.list_layout, c, DatabaseOpenHelper.columns, new int[] {R.id._id, R.id.fieldName,R.id.cropName},0);
        setListAdapter(mAdapter);

    }

    private Cursor getAllFields(){
        return mDbHelper.getWritableDatabase().query(DatabaseOpenHelper.TABLE_NAME,DatabaseOpenHelper.columns,null,new String[] {},null,null,null);
    }
}
