package com.example.medidorcorriente2;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class scanner extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    private ZXingScannerView msZXingScannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);

        ActionBar bar = getSupportActionBar();
        if (getSupportActionBar() == null) {

        } else {
            getSupportActionBar().hide();
        }

        //habilitando en navbar automaticamente
        msZXingScannerView = new ZXingScannerView(this);
        setContentView(msZXingScannerView);
        msZXingScannerView.setResultHandler(this);
        msZXingScannerView.startCamera();

    }

    @Override
    public void handleResult(final Result result) {
        final SharedPreferences preferences = getSharedPreferences("datosgenerales", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor=preferences.edit();
        final Context context = this;
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

        // set title
        alertDialogBuilder.setTitle("Respuesta");
        alertDialogBuilder.setIcon(R.mipmap.scanner);

        // set dialog message
        alertDialogBuilder
                .setMessage("Respuestas del identificador= "+result)
                .setCancelable(false)
                .setPositiveButton(R.string.yes,new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // if this button is clicked, close
                        // current activity
                        String res=result.getText();
                        editor.putString("idmedidor",res);
                        Intent intent = new Intent(scanner.this, IntroNext.class);
                        startActivity(intent);
                        scanner.this.finish();
                    }
                })
                .setNegativeButton(R.string.no,new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // if this button is clicked, just close
                        // the dialog box and do nothing
                        editor.putString("idmedidor","");
                        scanner.this.finish();
                        Intent intent = new Intent(scanner.this, MainActivity.class);
                        startActivity(intent);
                        dialog.cancel();
                    }
                });
        editor.commit();
        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();
        // show it
        alertDialog.show();
    }

}
