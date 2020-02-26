package com.novanto.myloopj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {
    private TextView tvQuote, tvAuthor;
    private ProgressBar progressBar;
    private static final String TAG = MainActivity.class.getSimpleName();
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progressBar);

        lv = findViewById(R.id.listQuotes);
        getRandomQuote();

        Button btnAllQuote = findViewById(R.id.btnAllQuotes);
        btnAllQuote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ListQuotesActivity.class));
            }
        });
    }

    private void getRandomQuote() {
        progressBar.setVisibility(View.VISIBLE);
        AsyncHttpClient client = new AsyncHttpClient();
         String url = "https://programming-quotes-api.herokuapp.com/quotes/page/1";

         client.get(url, new AsyncHttpResponseHandler() {
             @Override
             public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                 progressBar.setVisibility(View.INVISIBLE);

                 ArrayList<String> listQuote = new ArrayList<>();

                 String result = new String(responseBody);

                 Log.d(TAG,result);

                 try{
                     JSONArray jsonArray = new JSONArray(result);

                     for(int i = 0;i<jsonArray.length();i++){
                        JSONObject jsonObject = new JSONObject(result);
                        String quotes = jsonObject.getString("en");
                        String author = jsonObject.getString("author");

                        listQuote.add("\n" + quotes + "\n" + author);
                     }
                     ArrayAdapter adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, listQuote);
                     listView.setAdapter(adapter);

                 } catch (JSONException e) {
                     e.printStackTrace();
                 }


             }

             @Override
             public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                 progressBar.setVisibility(View.INVISIBLE);

                 String errorMessage;
                 switch (statusCode) {
                     case 401:
                         errorMessage = statusCode + " : Bad Request";
                         break;
                     case 403:
                         errorMessage = statusCode + " : Forbidden";
                         break;
                     case 404:
                         errorMessage = statusCode + " : Not Found";
                         break;
                     default:
                         errorMessage =  statusCode + " : " + error.getMessage();
                         break;
                 }
                 Toast.makeText(MainActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
             }
         });
    }
}
