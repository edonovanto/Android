package com.example.implicitintent;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edtPhone,edtMessageTo,edtMessageBody,edtLinkAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtPhone = findViewById(R.id.edtPhone);
        edtMessageTo = findViewById(R.id.edtMessageTo);
        edtMessageBody = findViewById(R.id.edtMessageBody);
        edtLinkAddress = findViewById(R.id.edtLinkAddress);

    }
    public void actionCall(View view){
        String phoneNumber = edtPhone.getText().toString();

        if(phoneNumber.isEmpty()){
            edtPhone.setError("Phone Number is Required");
            edtPhone.requestFocus();
            return;
        }

        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel : "+ phoneNumber));
        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
    }


    @SuppressLint("IntentReset")
    public void actionSendMessage(View view) {
        String messageBody = edtMessageBody.getText().toString();
        String messageTo = edtMessageTo.getText().toString();

        if(messageBody.isEmpty() || messageTo.isEmpty()){
            edtMessageTo.setError("Number is required");
            edtMessageBody.setError("Body is rrequired");
            edtMessageBody.requestFocus();
            return;
        }

        Intent sendMessage = new Intent(Intent.ACTION_SENDTO);
        sendMessage.setType("text/plain");
        sendMessage.setData(Uri.parse("sms: " + messageTo));
        sendMessage.putExtra("sms_body",messageBody);

        if (sendMessage.resolveActivity(getPackageManager()) != null){
            startActivity(sendMessage);
        }
    }

    public void actionLinkAddress(View view){
        String linkAddress = edtLinkAddress.getText().toString();

        if(linkAddress.isEmpty()){
            edtLinkAddress.setError("Link is required");
            edtLinkAddress.requestFocus();
            return;
        }

        Intent sendLink = new Intent(Intent.ACTION_VIEW);
        sendLink.setData(Uri.parse("http:" + linkAddress));

        if (sendLink.resolveActivity(getPackageManager()) != null){
            startActivity(sendLink);
        }
    }
}
