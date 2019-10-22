package com.example.medidorcorriente2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    public static String var_user;
    public static String var_pass;
    EditText user;
    EditText pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar bar = getSupportActionBar();
        if (getSupportActionBar() == null) {
        } else {
            getSupportActionBar().hide();
        }

        SharedPreferences preferences = getSharedPreferences("datosgenerales", Context.MODE_PRIVATE);
        String idmedidor = preferences.getString("idmedidor", "0");

        if (idmedidor.equals("0") || idmedidor.equals("")) {

        } else {
            Intent intent = new Intent(MainActivity.this, IntroNext.class);
            startActivity(intent);
            MainActivity.this.finish();
        }
    }
    public void Clickbtn(View view) {
        user = findViewById(R.id.textusuario);
        String valor_uno = user.getText().toString();

        pass = findViewById(R.id.textpass);
        String valor_dos = pass.getText().toString();

        if (valor_uno.equals("")) {
            user.setError("Ingresar Usuario");
        } else if (valor_dos.equals("")) {
            pass.setError("Ingresar Contraseña");
        } else {
            var_user = valor_uno;
            var_pass = valor_dos;
          ejecutarServices("http://192.168.43.207/ingresar.php");
        }
    }
    private void ejecutarServices(String url) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("no")) {
                    Toast.makeText(getApplicationContext(), "Usuario y Contraseña? No valido", Toast.LENGTH_SHORT).show();
                } else {
                    db(response);
                    MainActivity.this.finish();
                    Intent intent = new Intent(MainActivity.this, IntroNext.class);
                    startActivity(intent);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "No Internet", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametross = new HashMap<String, String>();
                parametross.put("user", var_user.toString());
                parametross.put("pass", var_pass.toString());
                return parametross;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
    public void scanner(View view) {
        MainActivity.this.finish();
        Intent intent = new Intent(this, scanner.class);
        startActivity(intent);
    }

    public void db(String valor) {
        SharedPreferences preferences = getSharedPreferences("datosgenerales", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("idmedidor", valor);
        editor.commit();
    }

}
