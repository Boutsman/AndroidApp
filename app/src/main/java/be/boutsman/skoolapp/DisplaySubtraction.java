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
    private String url1Part1 = "http://boutsman.be/AndroidApp/RESTInventaris.php?id=";
    private String url1Part2 = "&aantal=";
    private String urlDemo = "http://boutsman.be/AndroidApp/RESTInventaris.php?naam=test&beschrijving=test&type=test&aantal=10&prijs=22";
    private String urlString;
    private EditText objectnr,aantal;
    private HandleJSON heleDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_subtraction);

        Button executeBtn = (Button)findViewById(R.id.button1);
        executeBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                doInBackground();
            }
        });
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

    protected void doInBackground() {
        HttpClient httpClient = new DefaultHttpClient();
        HttpContext localContext = new BasicHttpContext();
        HttpGet httpGet = new HttpGet(urlDemo);
        try {
            httpClient.execute(httpGet, localContext);
        } catch (Exception e) {
        }
    }

    public void subtractAmount(View view){
        HttpClient httpClient = new DefaultHttpClient();

        //Prepare a request object
        HttpGet httpget = new HttpGet(urlDemo);

        //Execute the request
        HttpResponse response;
        try{
            httpClient.execute(httpget);
        }
        catch (Exception e) {}
    }
}
