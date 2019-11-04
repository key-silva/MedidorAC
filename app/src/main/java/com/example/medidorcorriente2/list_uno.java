package com.example.medidorcorriente2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class list_uno extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String data = getIntent().getExtras().getString("posicion", "0");
        setContentView(R.layout.activity_list_uno); ListView listItemView;
        listView = (ListView) findViewById(R.id.unolist);

        final String[] listItemsValue;

        switch (data) {
            case "0":
                listItemsValue = new String[]{"Neveras 10-12   130 kwh", "Lavadora   300 kwh", "Secadora 2000 kwh"
                        , "Aspiradora   150 kwh", "Secadora de Ropa   2500 kwh","Aire acondicionado   2800 kwh","Equipo de Sonido   80 kwh"};
                //         Array of Strings for ListView Title
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1, android.R.id.text1, listItemsValue);
                listView.setAdapter(adapter);
                break;
                case "1":
                listItemsValue = new String[]{"Secadora de Cabello   2000 kwh","Plancha   1500 kwh",
                        "Microondas   640 kwh","Licuadora   600 kwh","Cafetera Eléctrica   900 kwh",
                        "Planca de Cabello   6 kwh"};
                //         Array of Strings for ListView Title
                ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1, android.R.id.text1, listItemsValue);
                listView.setAdapter(adapter2);
                break;
                case "2":
                listItemsValue = new String[]{"Computador   12 kwh","Disco duro multimedia 130kwh",
                        "PC   35kwh","Tevisor LCD   9kwh" ,"Impresora   69kwh" ,"Televisor RSA   52kwh" };
                //         Array of Strings for ListView Title
                ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1, android.R.id.text1, listItemsValue);
                listView.setAdapter(adapter3);
                break;
        }


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
                list_uno.this.finish();
                Intent intent4 = new Intent(list_uno.this, lista_porducto_electronicos.class);
                startActivity(intent4);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
