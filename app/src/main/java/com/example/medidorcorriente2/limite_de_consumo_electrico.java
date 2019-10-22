package com.example.medidorcorriente2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.TextView;

public class limite_de_consumo_electrico extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_limite_de_consumo_electrico);

        SharedPreferences preferences = getSharedPreferences("datosgenerales", Context.MODE_PRIVATE);
        int limiteDiario = preferences.getInt("limiteDiario", 0);

        TextView Carga1 = findViewById(R.id.Cargar1);
        Carga1.setText(String.valueOf(limiteDiario)+" Cordobas");
        // SeekBar
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekbar1);
        seekBar.setMax(300);
        seekBar.setProgress(limiteDiario);


        seekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    //hace un llamado a la perilla cuando se arrastra
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        SharedPreferences preferences = getSharedPreferences("datosgenerales", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putInt("limiteDiario", progress);
                        editor.commit();
                        TextView Carga1 = findViewById(R.id.Cargar1);
                        Carga1.setText(String.valueOf(progress)+" Cordobas");
                    }

                    //hace un llamado  cuando se toca la perilla
                    public void onStartTrackingTouch(SeekBar seekBar) {
                    }

                    //hace un llamado  cuando se detiene la perilla
                    public void onStopTrackingTouch(SeekBar seekBar) {
                    }
                });

        int limiteMensual = preferences.getInt("limiteMensual", 0);
        TextView Carg2 = findViewById(R.id.Carga2);
        Carg2.setText(String.valueOf(limiteMensual)+" Cordobas");
        // SeekBar
        SeekBar seekBar2 = (SeekBar) findViewById(R.id.seekbar2);
        seekBar2.setMax(5000);
        seekBar2.setProgress(limiteMensual);

        seekBar2.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    //hace un llamado a la perilla cuando se arrastra
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        SharedPreferences preferences = getSharedPreferences("datosgenerales", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putInt("limiteMensual", progress);
                        editor.commit();

                        TextView Carga2 = findViewById(R.id.Carga2);
                        Carga2.setText(String.valueOf(progress)+" Cordobas");
                    }
                    //hace un llamado  cuando se toca la perilla
                    public void onStartTrackingTouch(SeekBar seekBar) {
                    }
                    //hace un llamado  cuando se detiene la perilla
                    public void onStopTrackingTouch(SeekBar seekBar) {
                    }
                });
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
                limite_de_consumo_electrico.this.finish();
                Intent intent4 = new Intent(limite_de_consumo_electrico.this, consumo.class);
                startActivity(intent4);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
