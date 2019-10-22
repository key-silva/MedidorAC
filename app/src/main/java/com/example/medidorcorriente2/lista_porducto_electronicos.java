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
import android.widget.TextView;
import android.widget.Toast;

public class lista_porducto_electronicos extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_porducto_electronicos);

        ListView listItemView;
        listView = (ListView) findViewById(R.id.listacategoria);
        String[] listItemsValue = new String[]{"Grandes electrodomésticos", "Pequeños electrodomésticos",
                "Equipoa informáticos y telecomunicaciones",
                "Aparatos de alumbrado", "Herramientas eléctricas y eléctronicas",
                "Juguetes y equipos deportivos y de tiempo libre",
                "Aparatos médicos",
                "Intrumentos de medida y control",
                "Maquina expendedoras"};
//         Array of Strings for ListView Title
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, listItemsValue);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Numero="+position, Toast.LENGTH_SHORT).show();
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
                lista_porducto_electronicos.this.finish();
                Intent intent4 = new Intent(lista_porducto_electronicos.this, consumo.class);
                startActivity(intent4);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
