package be.boutsman.skoolapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

/**
 * Created by Boutsman on 9/05/2015.
 */
public class DisplaySubtraction extends ActionBarActivity {
    private String url1 = "http://boutsman.be/AndroidApp/RESTInventaris.php?id=";
    private String urlString;
    private String amount;
    private EditText objectnr,aantal, result;
    private HandleJSON obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_subtraction);
        objectnr = (EditText)findViewById(R.id.editText1);
        aantal = (EditText)findViewById(R.id.editText2);
        result = (EditText)findViewById(R.id.editText3);
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
                return true;
            case R.id.action_search:
                Intent intent = new Intent(this, DisplayItem.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void subtractAmount(View view){
        String urlnr = objectnr.getText().toString();
        int hoeveel = Integer.parseInt(aantal.getText().toString());
        String finalUrl = url1 + urlnr;
        obj = new HandleJSON(finalUrl);
        obj.fetchJSON();

        while (obj.parsingComplete);
        int tempAantal = Integer.parseInt(obj.getAantal());
        int nieuwAantal = tempAantal - hoeveel;
        String tekstAantal = String.valueOf(nieuwAantal);

        String newUrl = url1 + urlnr + "&aantal=" + tekstAantal;

        HandleJSON feedback = new HandleJSON(newUrl);
        feedback.fetchJSON();

        while (feedback.parsingComplete)
        result.setText("Amount left= " + tekstAantal);
    }
}
