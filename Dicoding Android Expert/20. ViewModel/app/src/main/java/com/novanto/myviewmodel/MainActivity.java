package com.novanto.myviewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    private WeatherAdapter adapter;
    private EditText edtCity;
    private ProgressBar progressBar;
    private Button btnCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtCity = findViewById(R.id.editCity);
        progressBar = findViewById(R.id.progressBar);
        btnCity = findViewById(R.id.btnCity);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new WeatherAdapter();
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);

        btnCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String city = edtCity.getText().toString();

                if (city.isEmpty()) return;

                showLoading(true);
                setWeather(city);
            }
        });
    }

    private void setWeather(final String cities) {
        final ArrayList<WeatherItems> listItems = new ArrayList<>();

        String apiKey = "a50d5ec182d19d27fde1a7a0a21f8e4a";
        String url = "https://api.openweathermap.org/data/2.5/group?id=" + cities + "&units=metric&appid=" + apiKey;

        AsyncHttpClient client = new AsyncHttpClient();

        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    //parsing json
                    String result = new String(responseBody);
                    JSONObject responseObject = new JSONObject(result);
                    JSONArray list = responseObject.getJSONArray("list");

                    for (int i = 0; i < list.length(); i++) {
                        JSONObject weather = list.getJSONObject(i);
                        WeatherItems weatherItems = new WeatherItems();
                        weatherItems.setId(weather.getInt("id"));
                        weatherItems.setName(weather.getString("name"));
                        weatherItems.setCurrentWeather(weather.getJSONArray("weather").getJSONObject(0).getString("main"));
                        weatherItems.setDescription(weather.getJSONArray("weather").getJSONObject(0).getString("description"));
                        double tempInKelvin = weather.getJSONObject("main").getDouble("temp");
                        double tempInCelsius = tempInKelvin - 273;
                        weatherItems.setTemperature(new DecimalFormat("##.##").format(tempInCelsius));
                        listItems.add(weatherItems);
                    }
                    //set data ke adapter
                    adapter.setData(listItems);
                    showLoading(false);
                } catch (Exception e) {
                    Log.d("Exception", e.getMessage());
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.d("onFailure", error.getMessage());
            }
        });


    }

    private void showLoading(Boolean state) {
        if (state) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }


}
