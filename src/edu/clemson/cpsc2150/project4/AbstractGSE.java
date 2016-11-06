package edu.clemson.cpsc2150.project4;

/**
 * Created by andrewmarionhunter on 11/2/16.
 */
public abstract class AbstractGSE<T> implements GenericSetExtended<T> {
    @Override
    public final void union(GenericSet<T> rhs) {
        GenericSet copiedThis = new GenericSet2();
        GenericSet copiedrhs = new GenericSet2();
        this.copy(copiedThis);


        GenericSet tempSet = new GenericSet2();
        while(rhs.size() > 0)
        {
            T temp = rhs.removeAny();
            copiedrhs.insert(temp);
            tempSet.insert(temp);
        }
        while(tempSet.size() > 0)
        {
            rhs.insert((T)tempSet.removeAny());
        }



        while(copiedThis.size() > 0)
        {
            T tempOrary = (T)copiedThis.removeAny();
            if(!this.contains(tempOrary)) {
                this.insert(tempOrary);
            }
        }
        while(copiedrhs.size() > 0) {
            T tempOrary = (T)copiedrhs.removeAny();
            if (!this.contains(tempOrary)) {
                this.insert(tempOrary);
            }
        }
    }
    @Override
    public final void intersect(GenericSet<T> rhs) {
/* insert code here */
    }
    @Override
    public final void difference(GenericSet<T> rhs) {
/* insert code here */
    }
    @Override
    public final void copy(GenericSet<T> set) {
/* insert code here */
    }
    @Override
    public final boolean equals(Object obj) {
/* insert code here */
    return true;
    }
    /**
     * This method returns a string representation of the set,
     * listing the elements in any order.
     * Example: { elem1, elem2, elem3, elem4 }
     */
    @Override
    public final String toString() {
/* insert code here */
    return "testing";
    }
}