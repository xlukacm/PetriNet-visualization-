package fei.stuba.sk.zadanie;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

public class NormalEdge extends Edge {

    private int multiplicity;

    public NormalEdge(Kind turnFrom, Kind turnTo, int multiplicity) {
        super(turnFrom, turnTo);

        this.multiplicity = multiplicity;
        if (multiplicity < 1){
           throw new RunEdgeCountException("Tokeny nemozu mat zaporne");
        }
        else if(turnFrom instanceof Place && ((Place) turnFrom).getToken() < 0){
            throw new RunEdgeCountException("Nemoze vziat token ak tam nie je ziadny");
        }
        else if (turnFrom instanceof Place && turnTo instanceof Place){
            throw new RunTransitionException("Nemoze byt z miesta do miesta");
        }
        else if (turnFrom instanceof Transition && turnTo instanceof Transition){
            throw new RunTransitionException("Nemoze byt z prechodu do prechodu");
        }
    }

    public void setMultiplicity(int multiplicity) {
        this.multiplicity = multiplicity;
    }

    public int getMultiplicity() {
        return multiplicity;
    }

    @Override
    public int getMultiply() {
        return getMultiplicity();
    }

    public NormalEdge(Kind turnFrom, Kind turnTo) {
        super(turnFrom, turnTo);
    }

    @Override
    public void setTurnFrom(Kind turnFrom) {
        super.setTurnFrom(turnFrom);
    }

    //    @Override
//   public void setTurnFrom(Kind turnFrom, int i) {
//        if(turnFrom instanceof Place){
//            super.setTurnFrom(((Place) turnFrom).getToken(i)); // turnFrom.setTurnfromToken()
//        }
//       else
//       super.setTurnFrom(turnFrom, 0);
//   }


//    @Override
//    public void setTurnFrom(Kind turnFrom, int i) {
//        super.setTurnFrom(turnFrom, i);
//    }

    @Override
    public void setTurnTo(Kind turnTo) {
        super.setTurnTo(turnTo);
    }

    @Override
    public Kind getTurnFrom() {
        return super.getTurnFrom();
    }

    @Override
    public Kind getTurnTo() {
        return super.getTurnTo();
    }

    @Override
    public String toString() {
        return  " --" + getMultiplicity() + "-> " ;

                /*"NormalEdge{" +
                " multiplicity= " + multiplicity +
                "| ID from= " +  getTurnFrom().getID() +
                " Name from= " + getTurnFrom().getName() +
                "| ID to= " +  getTurnTo().getID() +
                " Name to= " + getTurnTo().getName() +
                '}';*/
    }
    //    public void setMultiplicity(int multiplicity) {
//        this.multiplicity = multiplicity;
//    }
//
//    public int getMultiplicity() {
//        return multiplicity;
//    }
//
//    @Override
//    public void setFromToken(int i) {
//        super.setFromToken(i - multiplicity); // tu je setFromToken(0) len ju nechce ukazat, kukni na abstract Edge
//    }
//
//    @Override
//    public int getFromToken() {
//        return super.getFromToken();
//    }
//
//    @Override
//    public void setToToken(int i) {
//        super.setToToken(multiplicity + i);
//    }
//
//    @Override
//    public int getToToken() {
//        return super.getToToken();
//    }
}
