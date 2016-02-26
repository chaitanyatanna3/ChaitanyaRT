package com.example.chaitanya.chaitanyart;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    Button BTN_GO, BTN_BACK, BTN_FORWARD;
    EditText enterUrl;
    private WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        BTN_GO = (Button) findViewById(R.id.btn_go);
        BTN_BACK = (Button) findViewById(R.id.btn_back);
        BTN_FORWARD = (Button) findViewById(R.id.btn_forward);
        enterUrl = (EditText) findViewById(R.id.et_enterurl);
        webView = (WebView) findViewById(R.id.webview);
        webView.setWebViewClient(new MyBrowser());
        BTN_GO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = enterUrl.getText().toString();
                webView.getSettings().setLoadsImagesAutomatically(true);
                webView.getSettings().setJavaScriptEnabled(true);
                webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                webView.loadUrl(url);
            }
        });
        BTN_BACK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (webView.canGoBack()) {
                    webView.goBack();
                }
            }
        });
        BTN_FORWARD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (webView.canGoForward()) {
                    webView.goForward();
                }
            }
        });
    }

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
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

        switch (id) {
            case R.id.menu_gallery:
                Intent intent_gallery = new Intent(MainActivity.this, GalleryRT.class);
                startActivity(intent_gallery);
                //Toast.makeText(MainActivity.this, "Gallery", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_seek:
                Intent intent_seek = new Intent(MainActivity.this, ChaitanyaSeek.class);
                startActivity(intent_seek);
                //Toast.makeText(MainActivity.this, "Seek", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_implicit:
                Intent intent_implicit = new Intent(MainActivity.this, ImplicitRT.class);
                startActivity(intent_implicit);
                //Toast.makeText(MainActivity.this, "Implicit", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_media:
                Intent intent_media = new Intent(MainActivity.this, MediaRT.class);
                startActivity(intent_media);
                //Toast.makeText(MainActivity.this, "Media", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_context:
                Intent intent = new Intent(MainActivity.this, ContextRT.class);
                startActivity(intent);
                //Toast.makeText(MainActivity.this, "Context", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_toast:
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
                alertDialog.setTitle("Where do you want your Toast Message?");
                alertDialog.setView(R.layout.toast_layout);
                alertDialog.show();
                //Toast.makeText(MainActivity.this, "Toast", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void goToTopLeft(View view) {
        Toast toast = Toast.makeText(MainActivity.this, "Top Left Selected.", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP | Gravity.LEFT, 0, 0);
        toast.show();
    }
    public void goToTopRight(View view) {
        Toast toast1 = Toast.makeText(MainActivity.this, "Top Right Selected.", Toast.LENGTH_SHORT);
        toast1.setGravity(Gravity.TOP | Gravity.RIGHT, 0, 0);
        toast1.show();
    }
    public void goToBottomLeft(View view) {
        Toast toast2 = Toast.makeText(MainActivity.this, "Bottom Left Selected.", Toast.LENGTH_SHORT);
        toast2.setGravity(Gravity.BOTTOM | Gravity.LEFT, 0, 0);
        toast2.show();
    }
    public void goToBottomRight(View view) {
        Toast toast3 = Toast.makeText(MainActivity.this, "Bottom Right Selected.", Toast.LENGTH_SHORT);
        toast3.setGravity(Gravity.BOTTOM | Gravity.RIGHT, 0, 0);
        toast3.show();
    }
}
