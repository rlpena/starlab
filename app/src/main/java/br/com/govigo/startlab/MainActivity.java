package br.com.govigo.startlab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import android.support.design.widget.Snackbar;
import android.support.design.widget.FloatingActionButton;

import android.support.v7.widget.Toolbar;
import android.support.v7.app.AppCompatActivity;

import android.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "GVG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.drawable.ic_action_startlab);

        MainPlaceHolderFragment fragment = new MainPlaceHolderFragment();
        FragmentTransaction transation = getFragmentManager().beginTransaction();
        transation.add(R.id.container, fragment,TAG);
        transation.commit();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
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

        if (id == R.id.action_about) {
            Intent intent = new Intent (this, AboutActivity.class);
            intent.putExtra("Message", "You are welcome!!"); // Pass parameters to new display
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
