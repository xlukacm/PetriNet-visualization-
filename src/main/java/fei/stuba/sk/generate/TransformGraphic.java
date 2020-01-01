package fei.stuba.sk.generate;

import fei.stuba.sk.graphics.Arc_2D;
import fei.stuba.sk.graphics.Elements;
import fei.stuba.sk.graphics.Place_2D;
import fei.stuba.sk.graphics.Transition2D;
import fei.stuba.sk.zadanie.PetrisNet;

import java.util.LinkedList;
import java.util.List;

//naplnenie elementov listu typu Element

public class TransformGraphic extends Transform <List<Elements>> {
   // private List<Elements> element;

    public List<Elements> transforms(PetrisNet net, Document document, List<Elements> element) {
        for(Arc arc:document.getArc()){
            if(arc.breakPoint==null){
                for(Place place: document.getPlace()){
                    for(Transition transition:document.getTransition()){
                        if(place.getId() == arc.getSourceId() && transition.getId() ==arc.getDestinationId()) {
                            element.add(new Arc_2D(place.getX(), place.getY(),transition.getX() ,transition.getY(),arc.getMultiplicity(), net, (short)arc.getId()));
                            System.out.print("");
                        }
                    }
                }
                for(Place place: document.getPlace()){
                    for(Transition transition:document.getTransition()){
                        if(place.getId() == arc.getDestinationId() && transition.getId() == arc.getSourceId()) {
                            element.add(new Arc_2D(transition.getX() ,transition.getY(),place.getX(), place.getY(),arc.getMultiplicity(),net,(short)arc.getId()));
                        }
                    }
                }
            }


            if(arc.breakPoint!= null) {
                for (Place place : document.getPlace()) {
                    for (Transition transition : document.getTransition()) {
                        if (place.getId() == arc.getSourceId() && transition.getId() == arc.getDestinationId()) {
                            element.add(new Arc_2D(place.getX(), place.getY(), transition.getX(), transition.getY(), arc.getBreakPoint(), arc.getMultiplicity(),(short)arc.getId()));
                            System.out.print("");
                        }
                    }
                }
                for(Place place: document.getPlace()){
                    for(Transition transition:document.getTransition()){
                        if(place.getId() == arc.getDestinationId() && transition.getId() == arc.getSourceId()) {
                            element.add(new Arc_2D(transition.getX() ,transition.getY(),place.getX(), place.getY(),arc.getBreakPoint(), arc.getMultiplicity(),(short)arc.getId()));
                        }
                    }
                }
            }

            for(Place place: document.getPlace()){
                fei.stuba.sk.graphics.Place_2D place_2D = new fei.stuba.sk.graphics.Place_2D(place.getX(),place.getY(),net.getPlace(place.getId()), net,place.getId());
                element.add(place_2D);
            }

            for(Transition trans:document.getTransition()){
                element.add( new Transition2D(trans.getX(),trans.getY(),net.getTransition(trans.getId()),net,trans.getId()));
            }
        }

        return element;
    }




    public List<Elements> transform(PetrisNet net, Document document) {

        List<Elements> element = new LinkedList<>();

        for(Arc arc:document.getArc()){
            if(arc.breakPoint==null){
                for(Place place: document.getPlace()){
                    for(Transition transition:document.getTransition()){
                        if(place.getId() == arc.getSourceId() && transition.getId() ==arc.getDestinationId()) {
                            element.add(new Arc_2D(place.getX(), place.getY(),transition.getX() ,transition.getY(),arc.getMultiplicity(), net, (short)arc.getId()));
                            System.out.print("");
                        }
                    }
                }
                for(Place place: document.getPlace()){
                    for(Transition transition:document.getTransition()){
                        if(place.getId() == arc.getDestinationId() && transition.getId() == arc.getSourceId()) {
                            element.add(new Arc_2D(transition.getX() ,transition.getY(),place.getX(), place.getY(),arc.getMultiplicity(),net,(short)arc.getId()));
                        }
                    }
                }
            }


            if(arc.breakPoint!= null) {
                for (Place place : document.getPlace()) {
                    for (Transition transition : document.getTransition()) {
                        if (place.getId() == arc.getSourceId() && transition.getId() == arc.getDestinationId()) {
                            element.add(new Arc_2D(place.getX(), place.getY(), transition.getX(), transition.getY(), arc.getBreakPoint(), arc.getMultiplicity(),(short)arc.getId()));
                            System.out.print("");
                        }
                    }
                }
                for(Place place: document.getPlace()){
                    for(Transition transition:document.getTransition()){
                        if(place.getId() == arc.getDestinationId() && transition.getId() == arc.getSourceId()) {
                            element.add(new Arc_2D(transition.getX() ,transition.getY(),place.getX(), place.getY(),arc.getBreakPoint(), arc.getMultiplicity(),(short)arc.getId()));
                        }
                    }
                }
            }

        for(Place place: document.getPlace()){
            fei.stuba.sk.graphics.Place_2D place_2D = new fei.stuba.sk.graphics.Place_2D(place.getX(),place.getY(),net.getPlace(place.getId()), net,place.getId());
            element.add(place_2D);
        }

        for(Transition trans:document.getTransition()){
           element.add( new Transition2D(trans.getX(),trans.getY(),net.getTransition(trans.getId()),net,trans.getId()));
            }
        }

       return element;
    }


    @Override
    public List<Elements> transform(Document document) {
        return null;
    }
}
