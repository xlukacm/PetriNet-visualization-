package fei.stuba.sk.zadanie;

import java.util.*;

public class PetrisNet {

    private Map<Short, Place> placeArr;

    private Map<Short, Transition> transitionArr;
    private List<fei.stuba.sk.zadanie.Edge> edgeArr;
    private List<Integer> tokenArr;

    public PetrisNet() {
        this.transitionArr = new HashMap<Short, Transition>();
        this.placeArr = new HashMap<Short, Place>();
        this.edgeArr = new LinkedList<>();
        this.tokenArr = new LinkedList<>();
    }

    public Map<Short, Place> getPlaceArr() {
        return placeArr;
    }

        public Map<Short, Transition> getTransitionArr() {
        return transitionArr;
    }

    public List<Edge> getEdgeArr() {
        return edgeArr;
    }

    public List<Integer> getTokenArr() {
        return tokenArr;
    }

    public void addPlace(short id, String name, int token) {
        try{placeArr.put(id, new Place(id, name, token));
            }
        catch(RunTokenExceptions e){
            System.out.println("Tokens cannot be negative");
        }
    }

    public void addTransition(short id, String name) {
        transitionArr.put(id, new Transition(id, name));
    }

    public void addTokens(int i){
        tokenArr.add(i);
    }
    public int getTokens(int i){
        return tokenArr.get(i);
    }


    public void addNormalEdge(Kind from, Kind to, int multiple) {
        try {
            edgeArr.add(new NormalEdge(from, to, multiple));
        }
        catch (RunEdgeCountException e) {

            System.out.println("Number cannot be negative");
        }
       catch (RunTransitionException e){
           System.out.println("Edge can't be from Place to Place or from Transition to Transition");
       }
        catch (RunTokenExceptions e){
            System.out.println("You can't take token if in place is Zero tokens");
        }
        catch (RunEdgeNullExceptions e){
          //  System.out.println("The edge has to come and go (none null");
        }
    }

    public void addResetEdge(Kind from, Kind to) {
        try {
            edgeArr.add(new ResetEdge(from, to));
        } catch (RunTransitionException e) {
            System.out.println("Reset edge can not have the first Transition");
        }
    }

    public Place getPlace(short id) {
        return placeArr.get(id);
    }

    public Transition getTransition(int id) {
        return transitionArr.get((short)id);
    }


    public void isRunTransitionException(short id) throws RunTransitionException {
       Transition transition = transitionArr.get(id);
        for (Edge edge : edgeArr) {
          //  if(edge.getTurnFrom() instanceof Place && edge.getTurnTo() == transition && edge.getTurnFrom() == transition && edge.getTurnTo() instanceof )
           if(edge.getTurnFrom() == null || edge.getTurnTo() == null){
                throw new RunTransitionException("Neda sa vytvorit hrana bez nicoho");
            }
        }
     }

    public void  isRunEdge_PlaceExceptions(short id) throws RunEdge_PlaceExceptions{
        Place place = placeArr.get(id);
        for (Edge edge : edgeArr) {
             if (place.getToken() < 0){
                throw new RunEdge_PlaceExceptions("Tokeni nemozu byt zaporne");
            }
        }
    }

    public void removeArc(short id){
        edgeArr.remove(id);
    }
//    public boolean removeTransition(short id) {
//        Transition transition = transitionArr.get(id);
//
//    }

    public boolean pressTransition(short id) {
            Transition transition = transitionArr.get(id);

            for (Edge edge : edgeArr) {
                if (edge.getTurnFrom() == transition && edge.getTurnTo() instanceof Place && edge instanceof NormalEdge) {
                    ((Place) edge.getTurnTo()).setToken(((Place) edge.getTurnTo()).getToken() + ((NormalEdge) edge).getMultiplicity());
                }
                else if (edge.getTurnFrom() instanceof Place && edge.getTurnTo() == transition &&  edge instanceof NormalEdge) {

                    if(((Place) edge.getTurnFrom()).getToken() >0 && ((NormalEdge) edge).getMultiplicity() <= ((Place) edge.getTurnFrom()).getToken()){
                    ((Place) edge.getTurnFrom()).setToken(((Place) edge.getTurnFrom()).getToken() - ((NormalEdge) edge).getMultiplicity());
                    }

                    else {
                        return false;
                    }
                }
               else if (edge.getTurnTo() == transition && edge.getTurnFrom() instanceof Place && edge instanceof ResetEdge) {
                    ((Place) edge.getTurnFrom()).setToken(0);
                    return true;
                }
            }
            return true;
        }

        public boolean isPress(short i){
            Transition transition = transitionArr.get(i);

            for (Edge edge : edgeArr) {
                if (edge.getTurnFrom() == transition && edge.getTurnTo() instanceof Place && edge instanceof NormalEdge) {
                }
                else if (edge.getTurnFrom() instanceof Place && edge.getTurnTo() == transition &&  edge instanceof NormalEdge) {
                    if(((Place) edge.getTurnFrom()).getToken() >0 && ((NormalEdge) edge).getMultiplicity() <= ((Place) edge.getTurnFrom()).getToken()){
                    }
                    else {
                        return false;
                    }
                }
                else if (edge.getTurnTo() == transition && edge.getTurnFrom() instanceof Place && edge instanceof ResetEdge) {
                    return true;
                }
            }
            return true;
        }


    public void printBeforePressTransition(){
        System.out.println();
        System.out.println("PetriNet before press transition" );
        System.out.println(placeArr);
        System.out.println(edgeArr);
        System.out.println(transitionArr);
        System.out.println("---------------------");
    //    System.out.println();
        System.out.println("PetriNet After press transition --> " );

    }
    public void printAfterPressTransition(){
        System.out.println();
        System.out.println("Changed values in Places: ");
        System.out.println(placeArr);
        System.out.println("Transitions in PetriNet");
        System.out.println(transitionArr);
    }

    @Override
    public String toString() {
        return  placeArr + "" +
                edgeArr + " "  +
                transitionArr;
    }

}
/*
    public List<Place> getPlaceArr() {
        return placeArr;
    }

    public List<Transition> getTransitionArr() {
        return transitionArr;
    }
*/

/*
    public void addTransition(short id, String name) {
        try{transitionArr.add(new Transition(id, name));
        }
        catch(RunTokenExceptions e){
            System.out.println("Tokens cannot be negative");
        }
    }

    public void addPlace(short id, String name, int token) {
        try{placeArr.add(new Place(id, name, token));
            }
        catch(RunTokenExceptions e){
            System.out.println("Tokens cannot be negative");
        }
    }
*/

//    public void pressTransition_resetEdge(long id) {
//        Transition transition = transitionArr.get(id);
//        for (Edge edge : edgeArr) {
//            if (edge.getTurnFrom() == transition) {
//                ((Place) edge.getTurnTo()).setToken(0);
//            } else if (edge.getTurnTo() == transition) {
//                ((Place) edge.getTurnFrom()).setToken(((Place) edge.getTurnFrom()).getToken() - ((NormalEdge) edge).getMultiplicity());
//            }
//        }
//    }

// public void inTransit(){
//    int i = 1;

//        for(int i = 1; i < 6; i++){
//           transitionArr[i] = new Transition(i,"T");
//        }
//   }

 /*
        //skusobna verzia na vypis vsetkeho
        int count = 0;
        Long count1 = -0L;
        //Map.Entry<Long,Place> tran; placeArr.entrySet();
        for(Map.Entry<Long,Place> entry1 : placeArr.entrySet()){
            if (transitionArr.get(count1) != null){
            System.out.print(entry1.getValue());
            System.out.print(edgeArr.get(count));
            System.out.print("  ");
            System.out.print(transitionArr.get(count1));
            count++;
            count1++;
            System.out.println();}
            else{
                System.out.print(transitionArr.get(count1));
                System.out.print(edgeArr.get(count));
                System.out.print(entry1.getValue());
                System.out.print("  ");
                count++;
                count1++;
                System.out.println();
            }
        }
        System.out.println("----------------------------");
        System.out.println();*/

//    public void inPlace(){
//
//        int i = 1;
//        for (Kind kind : placeArr) {
//            kind = new Place(i,"T",)
//        }
//
//        for(int i = 1; i < 8; i++){
//            placeArr[i] = new Place(i,"T",0);
//        }
//        placeArr[2].setToken(1);
//        placeArr[3].setToken(1);
//        placeArr[4].setToken(5);
//    }

//    public void prim() {
//        inPlace();
//        inTransit();
//        inEdge();
//        for (Transition transition : transitionArr) {
//            System.out.println(transition);
//        }
//    }

