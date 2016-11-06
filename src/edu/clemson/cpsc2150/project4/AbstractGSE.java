package edu.clemson.cpsc2150.project4;

/**
 * Created by andrewmarionhunter on 11/2/16.
 */
public abstract class AbstractGSE<T> implements GenericSetExtended<T> {
    @Override
    public final void union(GenericSet<T> rhs) {
        GenericSet copiedThis = new GenericSet1(100);
        GenericSet copiedrhs = new GenericSet2();
        this.copy(copiedThis);


        StringSet tempSet = new StringSet1(100);
        while(rhs.sizeOfSet() > 0)
        {
            String temp = rhs.removeAny();
            copiedrhs.insert(temp);
            tempSet.insert(temp);
        }
        while(tempSet.sizeOfSet() > 0)
        {
            rhs.insert(tempSet.removeAny());
        }



        while(copiedThis.sizeOfSet() > 0)
        {
            String tempOrary = copiedThis.removeAny();
            if(!result.contains(tempOrary)) {
                result.insert(tempOrary);
            }
        }
        while(copiedrhs.sizeOfSet() > 0) {
            String tempOrary = copiedrhs.removeAny();
            if (!result.contains(tempOrary)) {
                result.insert(tempOrary);
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