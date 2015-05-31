package be.boutsman.skoolapp;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Boutsman on 31/05/2015.
 */
public class EditItem extends ActionBarActivity {

    private String url1 = "http://boutsman.be/AndroidApp/RESTInventaris.php?id=";
    private String urlTest = "http://boutsman.be/AndroidApp/RESTInventaris.php?id=49&naam=test&beschrijving=test&type=test&aantal=1&prijs=2";
    private EditText objectnr,naam,beschrijving,type,aantal,prijs, result;
    private HandleJSON obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_edititem);
        objectnr = (EditText)findViewById(R.id.editText1);
        naam = (EditText)findViewById(R.id.editText2);
        beschrijving = (EditText)findViewById(R.id.editText3);
        type = (EditText)findViewById(R.id.editText4);
        aantal = (EditText)findViewById(R.id.editText5);
        prijs = (EditText)findViewById(R.id.editText6);
        result = (EditText)findViewById(R.id.editText7);
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

    public void getData(View view){
        String url = objectnr.getText().toString();
        String finalUrl = url1 + url;
        obj = new HandleJSON(finalUrl);
        obj.fetchJSON();

        while (obj.parsingComplete);
        naam.setText(obj.getNaam());
        beschrijving.setText(obj.getBeschrijving());
        type.setText(obj.getType());
        aantal.setText(obj.getAantal());
        prijs.setText(obj.getPrijs());
        result.setText("Record fetched");
    }

    public void addRecord(View view){
        String urlobjectnr = objectnr.getText().toString();
        String urlnaam = naam.getText().toString();
        String urlbeschrijving = beschrijving.getText().toString();
        String urltype = type.getText().toString();
        String urlaantal = aantal.getText().toString();
        String urlprijs = prijs.getText().toString();
        String newUrl = url1 + urlobjectnr + "&naam=" + urlnaam + "&beschrijving=" + urlbeschrijving + "&type=" + urltype + "&aantal=" + urlaantal + "&prijs=" + urlprijs;

        HandleJSON feedback = new HandleJSON(newUrl);
        feedback.fetchJSON();
        result.setText("Record updated");
    }
}