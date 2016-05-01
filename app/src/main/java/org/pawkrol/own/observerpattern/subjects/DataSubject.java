package org.pawkrol.own.observerpattern.subjects;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pawel on 2016-04-28.
 */
public class DataSubject extends Subject {
    private List<Float> values = new ArrayList<>();

    public void addValue(float value){
        values.add(value);
        notifyAllObservers();
    }

    public List<Float> getValues(){
        return values;
    }
}
