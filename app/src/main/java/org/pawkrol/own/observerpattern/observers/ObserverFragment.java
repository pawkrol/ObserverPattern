package org.pawkrol.own.observerpattern.observers;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.pawkrol.own.observerpattern.R;
import org.pawkrol.own.observerpattern.subjects.Subject;

/**
 * Created by Pawel on 2016-04-28.
 */
public abstract class ObserverFragment extends Fragment {

    protected Subject prevActiveSubject;

    @Override
    public void onResume() {
        super.onResume();
        if (prevActiveSubject != null)
            update(prevActiveSubject);
    }

    public void update(Subject subject){
    }
}
