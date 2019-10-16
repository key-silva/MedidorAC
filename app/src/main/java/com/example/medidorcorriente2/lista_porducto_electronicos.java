package com.example.medidorcorriente2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class lista_porducto_electronicos extends AppCompatActivity {
    //    ListView listItemView;
    ListView simpleList;
    String[] listItemsValue = new String[]{"Grandes electrodomésticos", "Pequeños electrodomésticos",
            "Equipoa informáticos y telecomunicaciones",
            "Aparatos de alumbrado", "Herramientas eléctricas y eléctronicas",
            "Juguetes y equipos deportivos y de tiempo libre",
            "Aparatos médicos",
            "Intrumentos de medida y control",
            "Maquina expendedoras"};
    // Array of Strings for ListView Title
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_porducto_electronicos);

        simpleList = (ListView)findViewById(R.id.listacategoria);
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.activity_lista_porducto_electronicos, R.id.textView, listItemsValue);
        simpleList.setAdapter(arrayAdapter);

        simpleList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
