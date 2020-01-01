package fei.stuba.sk.generate;

import fei.stuba.sk.zadanie.Edge;
import fei.stuba.sk.zadanie.PetrisNet;

import java.util.List;

public class Export  extends Transform<PetrisNet>{
    PetrisNet petrisNet = new PetrisNet();
    TransformNet net = new TransformNet();
    private fei.stuba.sk.zadanie.Transition tran;

    public Document tranDokum (PetrisNet petrisNet){
        this.petrisNet = petrisNet;
        Document dokum = new Document();
        dokum.getTransition();
        dokum.getArc();
        dokum.getPlace();
    //    List<Transition> tran = this.petrisNet.getTransitionArr();
//        for(petrisNet.getTransitionArr() )
 //       dokum.setTransition(net.transform(petrisNet.getTransitionArr().forEach((short)petrisNet.getTransitionArr().size(), tran)));
//        dokum.setPlace();
//        dokum.setArc();
        return dokum;
    }
//
    @Override
    public PetrisNet transform(Document document) {
        return null;
    }
}
