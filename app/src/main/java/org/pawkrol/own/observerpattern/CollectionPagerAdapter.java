package org.pawkrol.own.observerpattern;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import org.pawkrol.own.observerpattern.observers.ObserverFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pawel on 2016-04-28.
 */
public class CollectionPagerAdapter extends FragmentStatePagerAdapter {

    private List<ObserverFragment> fragments;

    public CollectionPagerAdapter(FragmentManager fm) {
        super(fm);

        fragments = new ArrayList<>();
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    public void addFramgentList(List<ObserverFragment> list){
        fragments.addAll(list);
    }

    public void addFragment(ObserverFragment fragment){
        fragments.add(fragment);
    }

    public boolean removeFragment(ObserverFragment fragment){
        return fragments.remove(fragment);
    }
}