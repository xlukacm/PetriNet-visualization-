package fei.stuba.sk.zadanie;

public abstract class Edge {
    private Kind turnFrom;
    private Kind turnTo;

    public Edge(Kind turnFrom, Kind turnTo) {
        this.turnFrom = turnFrom;
        this.turnTo = turnTo;
        if(turnFrom == null || turnTo == null){
            throw new RunEdgeNullExceptions("Hrana musi od niekal vychadzat a vchadzat");
        }
    }

    public void setTurnFrom(Kind turnFrom) {
        this.turnFrom = turnFrom;
    }

    //    public void setTurnFrom(Kind turnFrom, int i) {
//        if(turnFrom instanceof Place){
//           this.turnFrom.setToken(i);
//        }
//        else
//            super.setTurnFrom(turnFrom);
//    }

    public void setTurnTo(Kind turnTo) {
        this.turnTo = turnTo;
    }

    public Kind getTurnFrom() {
        return turnFrom;
    }

    public Kind getTurnTo() {
        return turnTo;
    }

    public abstract int getMultiply();

    @Override
    public String toString() {
        return "Edge{" +
                "turnFrom=" + turnFrom +
                ", turnTo=" + turnTo +
                '}';
    }
}
