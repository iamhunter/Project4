package edu.clemson.cpsc2150.project4;

import com.sun.tools.javac.jvm.Gen;
import sun.net.www.content.text.Generic;

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


        while(copiedrhs.size() > 0) {
            T tempOrary = (T)copiedrhs.removeAny();
            if (!this.contains(tempOrary)) {
                this.insert(tempOrary);
            }
        }
    }
    @Override
    public final void intersect(GenericSet<T> rhs) {
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
        while(this.size() > 0)
        {
            this.removeAny();
        }

        while(copiedThis.size() > 0)
        {
            T tempOrary = (T)copiedThis.removeAny();
            if(copiedrhs.contains(tempOrary))
            {
                this.insert(tempOrary);
            }
        }
    }
    @Override
    public final void difference(GenericSet<T> rhs) {
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

        while(this.size() > 0)
        {
            this.removeAny();
        }

        while(copiedThis.size() > 0)
        {
            T tempOrary = (T)copiedThis.removeAny();
            if(!copiedrhs.contains(tempOrary))
            {
                this.insert(tempOrary);
            }
        }
    }
    @Override
    public final void copy(GenericSet<T> set) {
        GenericSet tempSet = new GenericSet1(100);
        while(this.size() > 0)
        {
            T temp = this.removeAny();
            set.insert(temp);
            tempSet.insert(temp);
        }
        while(tempSet.size() > 0)
        {
            this.insert((T)tempSet.removeAny());
        }
    }
    @Override
    public final boolean equals(Object obj) {
        boolean equalsFlag = false;
        if (obj != null && obj instanceof GenericSet) {
            GenericSet set = (GenericSet) obj;
            if (this.size() == set.size()) {
                equalsFlag = true;

                Object[] tmpArr = new Object[this.size()];

                int i = 0;
                while (this.size() > 0) {
                    tmpArr[i] = this.removeAny();
                    if (!set.contains(tmpArr[i])) {
                        equalsFlag = false;
                    }
                    ++i;
                }

                for (i = 0; i < tmpArr.length; ++i) {
                    this.insert((T)tmpArr[i]);
                }
            }
        }
        return equalsFlag;
    }
    /**
     * This method returns a string representation of the set,
     * listing the elements in any order.
     * Example: { elem1, elem2, elem3, elem4 }
     */
    @Override
    public final String toString() {
/* insert code here */
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");

        Object[] tmpArr = new Object[this.size()];
        int i = 0;
        while (this.size() > 0) {
            tmpArr[i] = this.removeAny();
            sb.append(String.format("\"%s\"", tmpArr[i]));
            if (this.size() > 0) {
                sb.append(", ");
            }
            ++i;
        }
        for(i = 0; i < tmpArr.length; ++i) {
            this.insert((T)tmpArr[i]);
        }
        sb.append(" }");
        return sb.toString();
    }
}