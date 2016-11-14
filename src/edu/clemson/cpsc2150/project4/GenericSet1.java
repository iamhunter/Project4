package edu.clemson.cpsc2150.project4;

/**
 * Created by andrewmarionhunter on 11/2/16.
 */
public class GenericSet1<T> extends AbstractGSE<T> {
    /*
    This class uses a standard array implementation, such that
    the unique elements of the set are stored in any order
    in the array.
    invariant 0 <= next <= contents.length
    and for all i and j between 0 and next,
    if i != j then contents[i] != contents[j]
    correspondence maxSize = contents.length;
    correspondence conceptual this = Union {contents(i)}
    for i = 1 to next
    */
    private int myNext;
    private T[] myContents;

    GenericSet1(int length)
    {
        myContents = (T[])new Object[length];
    }

    @Override
    public void insert(T element) {
        myContents[myNext++] = element;
    }

    @Override
    public boolean contains(T element) {
        for (int i = 0; i < myNext; ++i) {
            if (myContents[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void remove(T element) {
        boolean foundFlag = false;
        for (int i = 0; i < myNext; ++i) {
            if (myContents[i].equals(element)) {
                foundFlag = true;
                --myNext;
            }

            if (foundFlag) {
                myContents[i] = myContents[i + 1];
            }
        }
    }

    @Override
    public T removeAny() {
        T tmp = myContents[0];
        --myNext;
        for (int i = 0; i < myNext; ++i) {
            myContents[i] = myContents[i + 1];
        }
        return tmp;

    }

    @Override
    public int size() {
        return myNext;
    }

    @Override
    public int maxSize() {
        return myContents.length;
    }

    @Override
    public void clear() {
        myNext = 0;
    }
}