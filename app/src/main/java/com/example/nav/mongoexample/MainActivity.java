package com.example.nav.mongoexample;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends ActionBarActivity implements MongoAdapter {

    // PUT YOUR API KEY HERE!
    private static final String API_KEY = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // Method to process the result returned from a Mongo.get() call
    public void processResult( String result )
    {
        // Toast the result
        Toast.makeText( this, result, Toast.LENGTH_LONG ).show();
    }

    // Method should return the name of the database you want to access
    public String dbName()
    {
        return ((EditText)findViewById( R.id.txt_db )).getText().toString();
    }

    // Method should return the API Key as shown at the bottom of the MongoLab user page
    public String apiKey()
    {
        return API_KEY;
    }

    // Callback method that tests the MongoLab REST api
    public void goMongo(View v) throws JSONException
    {
        String collection = ((EditText)findViewById( R.id.txt_coll )).getText().toString();

        // Passing null as the third parameter will return all documents in the collection
        Mongo.get( this, collection, null );
    }
}
