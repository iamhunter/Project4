package edu.clemson.cpsc2150.project4;


import java.util.ArrayList;

/**
 * Created by andrewmarionhunter on 11/2/16.
 */
public class GenericSet2<T> extends AbstractGSE<T> {

    ArrayList<T> myContents;

    GenericSet2()
    {
        myContents=new ArrayList<T>();

    }

    @Override
    public void insert(T element) {
        myContents.add(element);
    }

    @Override
    public boolean contains(T element) {
        return myContents.contains(element);
    }

    @Override
    public void remove(T element) {
        myContents.remove(element);

    }

    @Override
    public T removeAny() {
        return myContents.remove(0);
    }

    @Override
    public int size() {
        return myContents.size();
    }

    @Override
    public int maxSize() {
        return myContents.size();
    }

    @Override
    public void clear() {
        myContents.clear();

    }
/*
This class uses an ArrayList implementation, such
that the unique elements of the set are stored in any order
in an instance of java.util.ArrayList
invariant for all e: T, Occurs_Ct(e, list) <= 1;
correspondence conceptual this = Entries(list);
*/
}
