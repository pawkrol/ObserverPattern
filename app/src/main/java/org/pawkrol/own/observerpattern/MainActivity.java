package org.pawkrol.own.observerpattern;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import org.pawkrol.own.observerpattern.observers.BarGraphFragment;
import org.pawkrol.own.observerpattern.observers.DataFragment;
import org.pawkrol.own.observerpattern.observers.LinearGraphFragment;
import org.pawkrol.own.observerpattern.subjects.DataSubject;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private CollectionPagerAdapter collectionPagerAdapter;
    private DataSubject dataSubject;
    private ViewPager pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        dataSubject = new DataSubject();

        collectionPagerAdapter = new CollectionPagerAdapter(getSupportFragmentManager());
        initFragments();

        pagerAdapter = (ViewPager) findViewById(R.id.pager);
        if (pagerAdapter != null) {
            pagerAdapter.setAdapter(collectionPagerAdapter);
        }

        FloatingActionButton addDataButton = (FloatingActionButton) findViewById(R.id.addDataButton);
        if (addDataButton != null) {
            addDataButton.setOnClickListener(new View.OnClickListener() {

                 @Override
                 public void onClick(View v) {
                     dataSubject.addValue(new Random().nextFloat()*10);
                 }

             });
        }
    }

    private void initFragments(){
        DataFragment dataFragment = new DataFragment();
        LinearGraphFragment linearGraphFragment = new LinearGraphFragment();
        BarGraphFragment barGraphFragment = new BarGraphFragment();

        dataSubject.attach(dataFragment);
        dataSubject.attach(linearGraphFragment);
        dataSubject.attach(barGraphFragment);

        collectionPagerAdapter.addFragment(dataFragment);
        collectionPagerAdapter.addFragment(linearGraphFragment);
        collectionPagerAdapter.addFragment(barGraphFragment);
    }

}
