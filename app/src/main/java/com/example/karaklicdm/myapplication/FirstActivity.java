package com.example.karaklicdm.myapplication;

import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

import adapters.DrawerAdapter;
import fragments.DetailFragment;
import fragments.MasterFragment;
import model.NavigationItem;

/**
 * Created by androiddevelopment on 27.10.17..
 */

public class FirstActivity extends AppCompatActivity implements MasterFragment.OnItemSelectedListener{
    //attributes for state of activity
    private boolean landscapeMode = false;
    private boolean masterShown = false;
    private boolean detailShown = false;

    //chosen itemin the list in master fragment
    private int itemId = 0;


    //attributes for navigation drawer
    private DrawerLayout drawerLayout;
    private ListView drawerList;
    private ActionBarDrawerToggle drawerToggle;
    private RelativeLayout drawerPane;
    private CharSequence drawerTitle;
    private ArrayList<NavigationItem> drawerItems = new ArrayList<NavigationItem>();


    private class DrawerItemClickListener implements ListView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if (position == 0){
                // FirstActivity is already shown
            }
        }
    }




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        //vracanje unazad na back dugme
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_drawer);
            actionBar.setHomeButtonEnabled(true);
            actionBar.show();
        }


        drawerItems.add(new NavigationItem(getString(R.string.drawer_home), getString(R.string.drawer_home_long), R.drawable.ic_product));

        drawerTitle = getTitle();
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        drawerList = (ListView) findViewById(R.id.navList);

        // Populates NavigtionDrawer with options
        drawerPane = (RelativeLayout) findViewById(R.id.drawerPane);
        DrawerAdapter adapter = new DrawerAdapter(this, drawerItems);

        // Sets a custom shadow that overlays the main content when NavigationDrawer opens
        drawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        drawerList.setOnItemClickListener(new DrawerItemClickListener());
        drawerList.setAdapter(adapter);

        drawerToggle = new ActionBarDrawerToggle(
                this,                           /* host Activity */
                drawerLayout,                   /* DrawerLayout object */
                toolbar,                        /* nav drawer image to replace 'Up' caret */
                R.string.drawer_open,           /* "open drawer" description for accessibility */
                R.string.drawer_close           /* "close drawer" description for accessibility */
        ) {
            public void onDrawerClosed(View view) {
                getSupportActionBar().setTitle(drawerTitle);
                invalidateOptionsMenu();        // Creates call to onPrepareOptionsMenu()
            }

            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle(drawerTitle);
                invalidateOptionsMenu();        // Creates call to onPrepareOptionsMenu()
            }
        };


        // If the activity is started for the first time create master fragment
        if (savedInstanceState == null){
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            MasterFragment masterFragment = new MasterFragment();
            ft.add(R.id.master_view,masterFragment,"Master_Fragment_1");
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();

        }

        // If the device is in the landscape mode and the detail fragment is null create detail fragment
        if(findViewById(R.id.detail_view) != null){
            landscapeMode = true;
            getFragmentManager().popBackStack();

            DetailFragment detailFragment = (DetailFragment)getFragmentManager().findFragmentById(R.id.detail_view);
            if (detailFragment == null){
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                detailFragment = new DetailFragment();
                ft.replace(R.id.detail_view,detailFragment,"DetailFragment1");
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();

                detailShown = true;
            }

        }


        masterShown = true;
        detailShown = false;
        itemId = 0;
    }

    @Override
    public void onItemSelected(int id) {
        itemId = id;

        // If the device is in the landscape mode updates detail fragment's content, about position.
        if (landscapeMode){
            DetailFragment detailFragment = (DetailFragment)getFragmentManager().findFragmentById(R.id.detail_view);
            detailFragment.updateContent(id);
        }else{

            //we have to exchange master fragment by detail fragment, because of portrait
            DetailFragment detailFragment = new DetailFragment();
            detailFragment.setContent(id);
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            //here we don't instanciate anew object of detail fragment,because we will lose information about position
            ft.replace(R.id.master_view,detailFragment,"DetailFragment2");
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.addToBackStack(null);
            ft.commit();

            masterShown = false;
            detailShown = true;

        }
    }

    // onBackPressed method is called when the activity has detected the user's press of the back key
    // (it has to be overrided because fragment's behavior has to be implemented manualy).


    @Override
    public void onBackPressed() {
        if (landscapeMode)
            finish();
        else if (masterShown)
            finish();
        else if (detailShown){
            getFragmentManager().popBackStack();
            MasterFragment masterFragment = new MasterFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            //in portrait mode we have only one framelayout,that is master_view
            ft.replace(R.id.master_view,masterFragment,"MasterFragement2");
            //transition between fragments
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();

            masterShown = true;
            detailShown = false;
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.create:
                Toast.makeText(this,"Action " + getString(R.string.fragment_master_create) + " executed.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.update:
                Toast.makeText(this,"Action " + getString(R.string.fragment_master_update) + " executed.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete:
                Toast.makeText(this,"Action " + getString(R.string.fragment_master_delete) + " executed.", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void setTitle(CharSequence title) {
        getSupportActionBar().setTitle(title);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();
    }

    // onConfigurationChanged method is called when the device configuration changes to pass configuration change to the drawer toggle
    @Override
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);

        // Pass any configuration change to the drawer toggle
        drawerToggle.onConfigurationChanged(configuration);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
