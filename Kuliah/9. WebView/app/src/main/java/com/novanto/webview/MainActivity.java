package com.novanto.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final WebView webView = findViewById(R.id.webView);
        EditText editText = findViewById(R.id.edtURL);
        Button browse = findViewById(R.id.btnBrowse);

//        final String url = editText.getText().toString().trim();
        final String url = "https://google.com";

        browse.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(url.isEmpty()){
                    Toast.makeText(MainActivity.this,"URL Kosong", Toast.LENGTH_LONG).show();
                }
                else {
                    webView.loadUrl(url);
                    webView.setWebViewClient(new MainActivity.WebViewClient());
                }
            }
        });
    }

    public class WebViewClient extends android.webkit.WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url){
            return false;
        }
        @Override
        public void onPageFinished(WebView view, String url){

        }
    }
}
