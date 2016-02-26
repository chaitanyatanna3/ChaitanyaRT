package com.example.chaitanya.chaitanyart;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

public class ImplicitRT extends AppCompatActivity {

    Button BTN_White, BTN_Email, BTN_Name;
    EditText Name, Email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.implicitintent1);

        clickButton();
    }

    public void clickButton() {

        //38.8976805,-77.0387238

        Name = (EditText) findViewById(R.id.et_name);
        Email = (EditText) findViewById(R.id.et_email);

        BTN_White = (Button) findViewById(R.id.btn_geo);
        BTN_White.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_geo = new Intent(Intent.ACTION_VIEW);
                intent_geo.setData(Uri.parse("geo:38.8976805,-77.0387238"));
                startActivity(intent_geo);
            }
        });

        BTN_Email = (Button) findViewById(R.id.btn_email);
        BTN_Email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String to = Email.getText().toString();
                Intent intent_email = new Intent(Intent.ACTION_SEND);
                intent_email.putExtra(Intent.EXTRA_EMAIL, new String[] {to});
                intent_email.putExtra(Intent.EXTRA_SUBJECT, "Hello");
                intent_email.putExtra(Intent.EXTRA_TEXT, "Hi. How are you?");
                intent_email.setType("message/rfc822");
                startActivity(intent_email);
            }
        });

        BTN_Name = (Button) findViewById(R.id.btn_name);
        BTN_Name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = Name.getText().toString();
                Intent intent_text = new Intent(Intent.ACTION_SEND);
                intent_text.putExtra(Intent.EXTRA_TEXT, text);
                intent_text.setType("message/plain");
                startActivity(intent_text);
            }
        });

    }
}
