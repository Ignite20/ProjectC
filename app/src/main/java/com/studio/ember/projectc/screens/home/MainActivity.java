package com.studio.ember.projectc.screens.home;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;


import com.studio.ember.projectc.R;
import com.studio.ember.projectc.screens.recipes.RecipeFragment;
import com.studio.ember.projectc.utils.Navigator;

public class MainActivity extends AppCompatActivity implements RecipeFragment.OnFragmentInteractionListener{

    RecipeFragment recipeFragment;
    Toolbar mActionBarToolbar;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    changeActionBarTitle("Home");
                    return true;
                case R.id.navigation_recipes:


                    Navigator.goToRecipes(MainActivity.this, recipeFragment, R.id.flContainer);
                    changeActionBarTitle("Recipes");

                    return true;
                case R.id.navigation_profile:
                    changeActionBarTitle("Profile");
                    return true;
            }
            return false;
        }
    };

    void changeActionBarTitle(String title){

        //getSupportActionBar().setTitle(title);
        mActionBarToolbar.setTitle(title);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        mActionBarToolbar = findViewById(R.id.action_bar_toolbar);
        changeActionBarTitle("Home");
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    protected void onStart() {
        super.onStart();
        setSupportActionBar(mActionBarToolbar);

        if(recipeFragment == null) recipeFragment = RecipeFragment.newInstance();

        Navigator.goToRecipes(MainActivity.this, recipeFragment, R.id.flContainer);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}