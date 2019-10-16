package com.example.medidorcorriente2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class IntroNext extends AppCompatActivity {
    ImageView uno;
    TextView dos;
    TextView tres;
    public static int contador = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_next);
        ActionBar bar = getSupportActionBar();
        if (getSupportActionBar() == null) {

        } else {
            getSupportActionBar().hide();
        }
        SharedPreferences preferences = getSharedPreferences("datosgenerales", Context.MODE_PRIVATE);
        boolean verificar=preferences.getBoolean("intro",false);

        if(verificar==true){
            Intent intent = new Intent(this, consumo.class);
            startActivity(intent);
            IntroNext.this.finish();
        }

    }

    public void btnclick(View view) {
        contador++;
        uno = findViewById(R.id.imagen101);
        dos = findViewById(R.id.titulo101);
        tres = findViewById(R.id.mensaje101);

        if (contador == 0) {

        } else if (contador == 1) {
            uno.setImageResource(R.mipmap.next2);
            dos.setText("Conectado a Internet");
            tres.setText("Consulta desde cualquier sitio toda la información " +
                    "de tu consumo eléctrico. Medidor Electrico vigila que todo vaya bien.");
        } else if (contador == 2) {
            uno.setImageResource(R.mipmap.next3);
            dos.setText("Actúa y ahorra");
            tres.setText("Descubre oportunidades de ahorro reales y optimiza el uso" +
                    " de electricidad en tu casa. Elige la tarifa eléctrica más adecuada a tu perfil.");
        } else {

            SharedPreferences preferences = getSharedPreferences("datosgenerales", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor=preferences.edit();
            editor.putBoolean("intro",true);
            editor.commit();


            IntroNext.this.finish();
            Intent intent = new Intent(this, consumo.class);
            startActivity(intent);
        }
    }
}
