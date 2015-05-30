package be.boutsman.skoolapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DisplayDB extends ActionBarActivity {

    private String objectnr = "objectnr";
    private String naam = "naam";
    private String beschrijving = "beschrijving";
    private String type = "type";
    private String aantal = "aantal";
    private String prijs = "prijs";

    private String url2 = "http://boutsman.be/AndroidApp/RESTInventaris.php?db";
    private String urlDemo = "http://boutsman.be/AndroidApp/RESTInventaris.php?naam=test&beschrijving=test&type=test&aantal=10&prijs=22";
    private HandleJSON heleDB;
    private EditText textViewDb;
    private String[] jsonString;
    public JSONArray list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_db);
        textViewDb = (EditText) findViewById(R.id.textViewDb);

        String finalUrl = url2;
        heleDB = new HandleJSON(finalUrl);
        heleDB.fetchJSON();

        alleData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_display_second, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_refresh:
                alleData();
                return true;
            case R.id.action_search:
                Intent intent = new Intent(this, DisplayItem.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void alleData() {
        String finalUrl = url2;
        heleDB = new HandleJSON(finalUrl);
        heleDB.fetchJSON();

        while (heleDB.parsingComplete) ;
        list = heleDB.getList();
        jsonString = new String[list.length()];
        for (int i = 0; i < list.length(); i++) {
            JSONObject sys = null;
            try {
                sys = list.getJSONObject(i);
                objectnr = sys.getString("id");
                naam = sys.getString("naam");
                beschrijving = sys.getString("beschrijving");
                type = sys.getString("type");
                aantal = sys.getString("aantal");
                prijs = sys.getString("prijs");
                jsonString[i] = "Objectnr: " + objectnr + " \n Naam: " + naam + " \n Beschrijving: " + beschrijving + " \n Type: " + type + " \n Aantal: " + aantal + " \n Prijs: \u20ac" + prijs + " \n ";
            } catch (JSONException e) {
                e.printStackTrace();
            }


            StringBuilder builder = new StringBuilder();
            for (String s : jsonString){
                builder.append(s+"\n");
            }
            textViewDb.setText(builder.toString());
        }
    }
}