package fei.stuba.sk.generate;
import fei.stuba.sk.zadanie.Kind;
import fei.stuba.sk.zadanie.PetrisNet;
import fei.stuba.sk.generate.ArcType;

import javax.xml.transform.Source;
import java.util.*;

public class TransformNet extends Transform<PetrisNet> {


    @Override
    public PetrisNet transform(Document document) {
        PetrisNet net = new PetrisNet();


        for(Place place: document.getPlace()){
            fei.stuba.sk.zadanie.Place placeZ= new fei.stuba.sk.zadanie.Place(
                    place.getId(),
                    place.getLabel(),
                    place.getTokens()
            );
            net.addPlace(placeZ.getID(),placeZ.getName(),placeZ.getToken());
        }
        for(fei.stuba.sk.generate.Transition transition: document.getTransition()){
            fei.stuba.sk.zadanie.Transition tran = new fei.stuba.sk.zadanie.Transition(
                    transition.getId(),
                    transition.label
            );
            net.addTransition(tran.getID(),tran.getName());
        }

        for(Arc arc: document.getArc()){
            fei.stuba.sk.zadanie.Kind source = null;
            fei.stuba.sk.zadanie.Kind destination = null;


            for(fei.stuba.sk.zadanie.Place p1: net.getPlaceArr().values() ){
                if( p1.getID() == arc.getSourceId()){
                    source=p1;
                }
                if(p1.getID() == arc.getDestinationId()){
                    destination=p1;
                }
            }
            for (fei.stuba.sk.zadanie.Transition t1: net.getTransitionArr().values()){
                if(t1.getID() == arc.getSourceId()){
                    source = t1;
                }
                if(t1.getID()==arc.getDestinationId()){
                    destination=t1;
                }
            }

            if(arc.type == ArcType.REGULAR){
                net.addNormalEdge(source,destination,arc.getMultiplicity());

            }
            if(arc.type == ArcType.RESET){
                net.addResetEdge(source,destination);
            }
        }

    return net;
    }



}
