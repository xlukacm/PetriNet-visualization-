package fei.stuba.sk.zadanie;

public abstract class Kind {
    private  short ID;
    private final String Name;
    //private int Token;

    public Kind(short ID, String name) {
        this.ID = ID;
        Name = name;
    }

    public short getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public void getId (){

    }
   /* @Override
    public String toString() {
        return "Kind{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                '}';
    }*/
//    public void setToken(int token) {
//        Token = token;
//    }
//
//    public int getToken() {
//        return Token;
//    }
}
