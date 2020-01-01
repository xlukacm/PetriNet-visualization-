package fei.stuba.sk.zadanie;

public class ResetEdge extends Edge {

    public ResetEdge(Kind turnFrom, Kind turnTo) {

        super(turnFrom, turnTo);

        if (turnFrom instanceof Transition) {
            throw new RunResetTransitionException("Nejde spustit Reset hranu vychadzajucu z prechodu");
        }

    }

    @Override
    public void setTurnFrom(Kind turnFrom) {
        super.setTurnFrom(turnFrom);
    }

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
    public int getMultiply() {
        return 0;
    }

    @Override
    public String toString() {
        return " -r->> ";

                /* "ResetEdge{}" +
                "| ID from= " +  getTurnFrom().getID() +
                " Name from= " + getTurnFrom().getName() +
                "| ID to= " +  getTurnTo().getID() +
                " Name to= " + getTurnTo().getName() +
                '}';*/
    }

    //    @Override
//    public void setFromToken(int i) {
//        super.setFromToken(i * 0);
//    }
//
//    @Override
//    public int getFromToken() {
//        return super.getFromToken();
//    }
//
//    @Override
//    public void setToToken(int i) {
//        super.setToToken(1+i);
//    }
//
//    @Override
//    public int getToToken() {
//        return super.getToToken();
//    }
}
