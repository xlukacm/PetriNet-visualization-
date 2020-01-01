package fei.stuba.sk.zadanie;

import java.util.HashSet;
import java.util.Set;

public class Transition extends Kind {


    public Transition(short ID, String name) {
        super(ID, name);
    }


    @Override
    public String toString() {
    return  this.getName() + this.getID() ;
    }

}
