package be.boutsman.skoolapp;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import android.annotation.SuppressLint;

public class HandleJSON {
    public JSONArray list;
    public JSONObject JSONObj;
    private String objectnr = "objectnr";
    private String naam = "naam";
    private String beschrijving = "beschrijving";
    private String type = "type";
    private String aantal = "aantal";
    private String prijs = "prijs";
    private String queryString = "queryString";
    private String urlString = null;

    public volatile boolean parsingComplete = true;
    public HandleJSON(String url){ this.urlString = url; }

    public String getObjectNr(){ return objectnr; }
    public String getNaam(){ return naam; }
    public String getBeschrijving(){ return beschrijving; }
    public String getType(){ return type; }
    public String getAantal(){ return aantal; }
    public String getPrijs(){ return prijs; }
    public String getQueryString(){ return queryString;}
    public JSONArray getList(){ return list; }
    public JSONObject getJSONObj(){ return JSONObj; }

    @SuppressLint("NewApi")
    public void readAndParseJSON(String in) {
        try {
            list  = new JSONArray(in);

            for(int i=0;i<list.length();i++) {
                JSONObject sys = list.getJSONObject(i);
                objectnr = sys.getString("id");
                naam = sys.getString("naam");
                beschrijving = sys.getString("beschrijving");
                type = sys.getString("type");
                aantal = sys.getString("aantal");
                prijs = sys.getString("prijs");
            }

            parsingComplete = false;

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @SuppressLint("NewApi")
    public void readAndParseJSONAfterAddItem(String in) {
        try {
            JSONObj  = new JSONObject(in);
            //queryString = "ok";//JSONObj.getString("queryString");

            parsingComplete = false;

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void fetchJSON(){
        Thread thread = new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    URL url = new URL(urlString);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setReadTimeout(10000 /* milliseconds */);
                    conn.setConnectTimeout(15000 /* milliseconds */);
                    conn.setRequestMethod("GET");
                    conn.setDoInput(true);
                    // Starts the query
                    conn.connect();
                    InputStream stream = conn.getInputStream();

                    String data = convertStreamToString(stream);

                    readAndParseJSON(data);
                    stream.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
    }

    public void fetchJSONaddItem(){
        Thread thread = new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    URL url = new URL(urlString);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setReadTimeout(10000 /* milliseconds */);
                    conn.setConnectTimeout(15000 /* milliseconds */);
                    conn.setRequestMethod("GET");
                    conn.setDoInput(true);
                    // Starts the query
                    conn.connect();
                    InputStream stream = conn.getInputStream();

                    String data = convertStreamToString(stream);

                    readAndParseJSONAfterAddItem(data);
                    stream.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
    }

    static String convertStreamToString(java.io.InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
}
