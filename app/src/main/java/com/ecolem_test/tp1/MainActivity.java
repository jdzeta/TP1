package com.ecolem_test.tp1;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Button btnEn = (Button) findViewById(R.id.act_main_btn_en);
        btnEn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                String msg = langBtnClick("EN");
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
            }
        });
        final Button btnFr = (Button) findViewById(R.id.act_main_btn_fr);
        btnFr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                String msg = langBtnClick("FR");
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
            }
        });


        Toast.makeText(getApplicationContext(), "Démarrage...", Toast.LENGTH_SHORT).show();
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.sortir){
            askExitConfirmation();
        }

        return super.onOptionsItemSelected(item);
    }

    private void askExitConfirmation(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.act_main_menu_quit_msg).setTitle(R.string.act_main_menu_quit_title);

        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                Log.d("DEBUG : ", "Ok button");
                finish();
                System.exit(0);
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d("DEBUG : ", "Cancel button");
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private String langBtnClick(String lang){
        String ret;
        switch (lang){
            case "EN":
                ret = "Hello";
                break;

            case "FR":
                ret = "Bonjour";
                break;

            default:
                ret = "";
                break;
        }

        return ret;
    }
}
