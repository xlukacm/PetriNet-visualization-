package fei.stuba.sk.zadanie;

public class Place extends Kind {
    //private Transition transitionBefore;
    //private Transition transitionAfter;

    //private  final String Name;
    //private final long ID;
    private int token;

    public Place(short ID, String name, int token) {
        super(ID, name);
        this.token = token;
        if (token < 0){
            throw new RunTokenExceptions("Tokeny nemozu mat zaporne");
        }
    }

    public int getToken() {
        return token;
    }

    public void setToken(int token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return /*"|Place " + this.getID() + ":" +*/
                "" + this.getName() + this.getID() +
                " t{" + token + "}";
    }
}
//    @Override
//    public String toString() {
//        return "Place|" +
//                "ID = " + this.getID() +
//                " name = " + this.getName() +
//                " token = " + token +
//                '|';
//    }
