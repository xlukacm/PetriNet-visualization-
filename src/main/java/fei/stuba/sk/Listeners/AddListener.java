package fei.stuba.sk.Listeners;

import fei.stuba.sk.generate.*;
import fei.stuba.sk.graphics.CanvasNet;
import fei.stuba.sk.graphics.Elements;
import fei.stuba.sk.graphics.Frames;
import fei.stuba.sk.zadanie.PetrisNet;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import java.util.List;

import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;

public class AddListener implements MouseListener {
    CanvasNet canvasNet;
    private List<Elements> element = new LinkedList<>();
    private Document dokum;
    private PetrisNet petrisNet;
    private String object;
    short id = 1;
    short x1;
    short x2;
    int count = 1;

    public AddListener(List<Elements> element,CanvasNet canvasNet, Document dokum, PetrisNet petrisNet, String object) {
        this.canvasNet = canvasNet;
        this.dokum = dokum;
        this.petrisNet = petrisNet;
        this.object = object;
        this.element = element;
        addMouseListener(this);
    }



    @Override
    public void mouseClicked(MouseEvent e) {

        if(object == "place") {
            String pl = "place";
            String newPl ="p";

            for (Elements elements : canvasNet.getElement()) {
                if (elements.getId() == id) {
                    id++;
                }
            }

            System.out.println("vytvoril si place");
            Place place = new Place();
            place.setId(id);
            place.setLabel(newPl+id);
            place.setTokens((short) 0);
            place.setX((short)e.getX());
            place.setY((short)e.getY());
            dokum.getPlace().add(place);

            TransformNet tranNet = new TransformNet();
            petrisNet = tranNet.transform(dokum);

            TransformGraphic graf = new TransformGraphic();
            element = graf.transform(petrisNet,dokum);

            id=1;
         canvasNet.repaint();
        }

        if(object == "transition") {
            String tr = "transition";
            String newPl ="T";
            for (Elements elements : element) {
                if (elements.getId() == id) {
                    id++;
                }
            }
            System.out.println("vytvoril si transition");

            Transition transition = new Transition();
            transition.setId(id);
            transition.setLabel(newPl+id);
            transition.setX((short)e.getX());
            transition.setY((short)e.getY());
            dokum.getTransition().add(transition);

            TransformNet tranNet = new TransformNet();
            petrisNet = tranNet.transform(dokum);

            TransformGraphic graf = new TransformGraphic();
            element = graf.transform(petrisNet,dokum);
//                TransformNet tranNet = new TransformNet();
//                petrisNet = traNet.transform(dokum);
//
//                TransformGraphic graf = new TransformGraphic();
//                element = graf.transforms(petrisNet,dokum,element );

            id = 1;
            canvasNet.repaint();
        }



        if(object == "arc") {
            String tr = "arc";
            for (Elements elements : canvasNet.getElement()) {
                if (elements.contains(e.getX(), e.getY())) {
                    if (count != 2 && object == "arc") {
                        x1=elements.getId();
                        count++;
                        break;
                    }

                    else if (count == 2 && object == "arc") {
                        x2= elements.getId();

                        Arc arc = new Arc();
                        arc.setId(id);
                        arc.setSourceId(x1);
                        arc.setDestinationId(x2);
                        arc.setType(ArcType.REGULAR);
                        arc.setMultiplicity(1);
                        dokum.getArc().add(arc);

                        TransformNet tranNet = new TransformNet();
                        petrisNet = tranNet.transform(dokum);

                        TransformGraphic graf = new TransformGraphic();
                        element = graf.transform(petrisNet,dokum);

                        canvasNet.repaint();
                        x1 = 0;
                        x2 = 0;
                        id++;
                        count = 1;
                        break;
                    }
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
