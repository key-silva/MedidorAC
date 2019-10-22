package com.example.medidorcorriente2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class Graficas_vistas extends AppCompatActivity {
    private WebView mWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graficas_vistas);

        mWebView = (WebView) findViewById(R.id.grafica1);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mWebView.loadUrl("http://192.168.43.207/arduino/grafica_barra.php");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_regresar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemregresar:
                Graficas_vistas.this.finish();
                Intent intent4 = new Intent(Graficas_vistas.this, consumo.class);
                startActivity(intent4);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
