package com.example.configureddialog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Credits extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
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
}
