package org.pawkrol.own.observerpattern.subjects;

import org.pawkrol.own.observerpattern.observers.ObserverFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pawel on 2016-04-28.
 */
public abstract class Subject {

    List<ObserverFragment> observers = new ArrayList<>();

    public void attach(ObserverFragment observerFragment){
        observers.add(observerFragment);
    }

    public void detach(ObserverFragment observerFragment){
        observers.remove(observerFragment);
    }

    public void notifyAllObservers(){
        for (ObserverFragment o: observers){
            o.update(this);
        }
    }
}
