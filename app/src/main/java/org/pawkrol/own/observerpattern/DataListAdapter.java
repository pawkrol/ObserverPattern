package org.pawkrol.own.observerpattern;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by Pawel on 2016-04-28.
 */
public class DataListAdapter extends ArrayAdapter<Float> {

    public DataListAdapter(Context context, int resource, List<Float> items){
        super(context, resource, items);
    }

}
