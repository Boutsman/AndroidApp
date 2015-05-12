package be.boutsman.skoolapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * Created by Boutsman on 9/05/2015.
 */
public class DisplayFourthAct extends ActionBarActivity {
    private String url1Part1 = "http://boutsman.be/AndroidApp/RESTInventaris..php?id=";
    private String url1Part2 = "&aantal=";
    private String urlString;
    private EditText objectnr,aantal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_fourth);
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
                Intent intent = new Intent(this, DisplayThirdAct.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void subtractAmount(int amount){
        /*
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet get = new HttpGet("https://apis.live.net/v5.0/me/albums?access_token=" + AccessToken); // For example
        HttpResponse response = httpClient.execute(get);
        */

        objectnr = (EditText)findViewById(R.id.editText1);
        aantal = (EditText)findViewById(R.id.editText2);
        urlString = url1Part1 + objectnr + url1Part2 + aantal;
    }
}
