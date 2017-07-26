package uk.co.alexander.barmymarvel;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import uk.co.alexander.barmymarvel.view.ComicList;

/**
 * Our main activity that holds the fragments
 */

public class MainActivity extends AppCompatActivity {

    private ComicList mComicList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(uk.co.alexander.barmymarvel.R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(uk.co.alexander.barmymarvel.R.id.toolbar);
        setSupportActionBar(toolbar);
        // Only need to inflate the Fragment the first time we're run
        if (savedInstanceState == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            mComicList = new ComicList();
            transaction.add(uk.co.alexander.barmymarvel.R.id.fragmentHolder, new ComicList());
            transaction.commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(uk.co.alexander.barmymarvel.R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == uk.co.alexander.barmymarvel.R.id.action_set_budget) {
            // Show dialog to get budget

            // Then filter
            mComicList.filterOnPrice(0.00);
            return true;
        } else if (id == uk.co.alexander.barmymarvel.R.id.action_clear_budget) {
            mComicList.clearFilter();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
