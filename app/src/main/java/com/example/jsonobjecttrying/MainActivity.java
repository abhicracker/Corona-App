package com.example.jsonobjecttrying;


import android.os.AsyncTask;
import android.os.Bundle;

import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.jsonobjecttrying.POJO.CountriesData;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private String TAG = MainActivity.class.getSimpleName();
    private ListView lv;

    ArrayList<HashMap<String, String>> contactList;

    ArrayList<String>  countryNames = new ArrayList<>();
    ArrayList<CountriesData> countriesData = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactList = new ArrayList<>();
        lv = (ListView) findViewById(R.id.list);

        countryNames.clear();
        countryNames.add("US");
        countryNames.add("IN");

        new GetContacts().execute();
    }

    private class GetContacts extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(MainActivity.this,"Json Data is downloading",Toast.LENGTH_LONG).show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();
            // Making a request to url and getting response
            String url = "https://www.covidvisualizer.com/api";
            String jsonStr = sh.makeServiceCall(url);

            Log.e(TAG, "Response from url: " + jsonStr);
            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // Getting JSON Array node
                    JSONObject countries= jsonObj.getJSONObject("countries");

                    // looping through All Contacts

                    for (int i = 0 ; i < countryNames.size() ; i ++){
                        JSONObject jsonObject = countries.getJSONObject(countryNames.get(i));
                        String name = jsonObject.getString("name");
                        String flag = jsonObject.getString("flag");
                        int reports = jsonObject.getInt("reports");
                        int cases = jsonObject.getInt("cases");
                        int deaths = jsonObject.getInt("deaths");
                        int recovered = jsonObject.getInt("recovered");
                        int lat = jsonObject.getInt("lat");
                        int lng = jsonObject.getInt("lng");
                        int deltaCases = jsonObject.getInt("deltaCases");
                        int deltaDeaths = jsonObject.getInt("deltaDeaths");


                        CountriesData data = new CountriesData(name,flag,reports,cases,deaths,recovered,lat,lng,deltaCases,deltaDeaths);
                        countriesData.add(data);
                        Log.d(TAG,"Country data --  "+countriesData.get(i).getName());
                    }




                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG).show();
                        }
                    });

                }

            } else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG).show();
                    }
                });
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            ListAdapter adapter = new SimpleAdapter(MainActivity.this, contactList,
                    R.layout.list_item, new String[]{ "email","mobile"},
                    new int[]{R.id.email, R.id.mobile});
            lv.setAdapter(adapter);

        }
    }
}
