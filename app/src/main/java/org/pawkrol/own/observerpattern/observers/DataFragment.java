package org.pawkrol.own.observerpattern.observers;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.pawkrol.own.observerpattern.DataListAdapter;
import org.pawkrol.own.observerpattern.R;
import org.pawkrol.own.observerpattern.subjects.DataSubject;
import org.pawkrol.own.observerpattern.subjects.Subject;

/**
 * Created by Pawel on 2016-04-28.
 */
public class DataFragment extends ObserverFragment {

    private ListView listView;
    private DataListAdapter dataListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.data_fragment, container, false);
        if (view == null){
            return null;
        }

        listView = (ListView) view.findViewById(R.id.listView);

        return view;
    }

    @Override
    public void update(Subject subject) {
        if (getView() == null) return;

        prevActiveSubject = subject;

        if (subject instanceof DataSubject) {
            dataListAdapter =
                    new DataListAdapter(getActivity(), R.layout.list_element,
                                            ((DataSubject) subject).getValues());
            listView.setAdapter(dataListAdapter);
        }
    }
}
