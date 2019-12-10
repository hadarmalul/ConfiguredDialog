package com.example.configureddialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * @author Hadar Malul
 * @since 30.11.19
 */


public class MainActivity extends AppCompatActivity {

    /**
     * adb is an alert dialog builder
     * ll is a linear layout component
     * colors is the dialog items array
     * color is the background colors array
     */

    AlertDialog.Builder adb;
    LinearLayout ll;
    String [] colors = {"Red", "Green", "Blue"};
    int [] color = {0,0,0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ll = (LinearLayout) findViewById(R.id.ll);
    }

    /**
     * this function creates the menu
     */

    public boolean onCreateOptionsMenu (Menu menu){

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * this function activates the menu
     */

    public boolean onOptionsItemSelected(MenuItem item){

        /**
         * the screen changes according to the chosen item
         */
        String st = item.getTitle().toString();
        if (st.equals("Credits")){
            Intent si = new Intent(this,Credits.class);
            startActivity(si);
        }
        if (st.equals("Buttons")){
            Intent si = new Intent(this,MainActivity.class);
            startActivity(si);
        }
        return true;
    }

    /**
     * the function starts when the button is clicked
     * setting features to the dialog
     */

    public void colors(View view) {

        adb = new AlertDialog.Builder(this);
        adb.setTitle("choose one color");
        adb.setCancelable(false);
        /**
         * changing background color according to the clicked item
         */
        adb.setItems(colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            color[which] = 255;
            ll.setBackgroundColor(Color.rgb(color[0],color[1],color[2]));
            color[which] = 0;
            }
        });

        adb.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog ad = adb.create();
        ad.show();

    }

    /**
     * the function starts when the button is clicked
     * setting features to the dialog
     */

    public void color(View view) {

        adb = new AlertDialog.Builder(this);
        adb.setTitle("click OK to change color");
        adb.setCancelable(false);
        adb.setMultiChoiceItems(colors, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if (isChecked)
                    color[which] = 255;
                else
                    if (color[which]==255)
                        color[which] = 0;
            }
        });
        /**
         * changing background color when the "ok"button is clicked
         */
        adb.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ll.setBackgroundColor(Color.rgb(color[0], color[1], color[2]));
                color[0] = 0;
                color[1] = 0;
                color[2] = 0;

            }
        });

        adb.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog ad = adb.create();
        ad.show();
    }

    /**
     * the function starts when the button is clicked
     * reset background
     */

    public void reset(View view) {

        ll.setBackgroundColor(Color.WHITE);
    }

    /**
     * the function starts when the button is clicked
     * setting features to the dialog
     */

    public void toast(View view) {

        adb = new AlertDialog.Builder(this);
        adb.setTitle("write something...");
        adb.setCancelable(false);
        final EditText et = new EditText(this);
        et.setHint("type text here");
        adb.setView(et);
        adb.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            /**
             * showing user's input as a toast
             */
            public void onClick(DialogInterface dialog, int which) {
                String st = et.getText().toString();
                Toast.makeText(MainActivity.this, st, Toast.LENGTH_LONG).show();
            }
        });

        adb.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog ad = adb.create();
        ad.show();
    }
}
