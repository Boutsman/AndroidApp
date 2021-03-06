package be.boutsman.skoolapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {
    public final static String EXTRA_MESSAGE = "be.boutsman.SkoolApp.MESSAGE";

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

    public void sendMessage(View view){
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void secondActivity(View view){
        Intent intent = new Intent(this, DisplayDB.class);
        startActivity(intent);
    }

    public void thirdActivity(View view){
        Intent intent = new Intent(this, DisplayItem.class);
        startActivity(intent);
    }

    public void fourthActivity(View view){
        Intent intent = new Intent(this, DisplaySubtraction.class);
        startActivity(intent);
    }

    public void fifthActivity(View view){
        Intent intent = new Intent(this, EditItem.class);
        startActivity(intent);
    }

    public void sixthActivity(View view){
        Intent intent = new Intent(this, AddItem.class);
        startActivity(intent);
    }
}
