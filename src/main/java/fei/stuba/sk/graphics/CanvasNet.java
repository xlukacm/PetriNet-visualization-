package fei.stuba.sk.graphics;

import fei.stuba.sk.Listeners.AddListener;
import fei.stuba.sk.generate.*;
import fei.stuba.sk.zadanie.PetrisNet;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import java.util.List;

public class CanvasNet extends Canvas implements MouseListener{
    private List<Elements> element = new LinkedList<>();
    private Frames framik;
    private PetrisNet petrisNet;
    private Document dokum;
    private TransformNet traNet;
    private TransformGraphic graf;

    short id = 1;
    short x1;
    short x2;
    int count = 1;

    public CanvasNet(List<Elements> element) {
        this.element = element;
    }

    public CanvasNet(List<Elements> element, Document dokum, Frames framik) {
        petrisNet = new PetrisNet();
        this.element = element;
        this.framik = framik;
        this.dokum = dokum;
        addMouseListener(this);
    }

    public CanvasNet(List<Elements> element, Document dokum, Frames framik, TransformNet tranNet, TransformGraphic graf) {
        petrisNet = new PetrisNet();
        this.element = element;
        this.framik = framik;
        this.dokum = dokum;
        this.traNet = tranNet;
        this.graf = graf;
        addMouseListener(this);
    }

    public synchronized void removeMouseListeners() {
       MouseListener[]  mouseListeners = this.getMouseListeners();

       for(MouseListener mouse: mouseListeners)
           this.removeMouseListener(mouse);
    }

    @Override
    public void paint(Graphics g) {
        System.out.println(element);
        for (Elements elements : element) {
            elements.draw((Graphics2D) g);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
//
//        if(framik.button1.isSelected()) {
//            String pl = "place";
//            String newPl ="p";
//
//            for (Elements elements : element) {
//                if (elements.getId() == id) {
//                    id++;
//                }
//            }
//
//            System.out.println("vytvoril si place");
//            Place place = new Place();
//            place.setId(id);
//            place.setLabel(newPl+id);
//            place.setTokens((short) 0);
//            place.setX((short)e.getX());
//            place.setY((short)e.getY());
//            dokum.getPlace().add(place);
//
//            TransformNet tranNet = new TransformNet();
//            petrisNet = tranNet.transform(dokum);
//
//            TransformGraphic graf = new TransformGraphic();
//            element = graf.transform(petrisNet,dokum);
//
//            id=1;
//            repaint();
//        }
//
//        if(framik.button2.isSelected()) {
//            String tr = "transition";
//            String newPl ="T";
//            for (Elements elements : element) {
//                if (elements.getId() == id) {
//                    id++;
//                }
//            }
//                System.out.println("vytvoril si transition");
//
//                Transition transition = new Transition();
//                transition.setId(id);
//                transition.setLabel(newPl+id);
//                transition.setX((short)e.getX());
//                transition.setY((short)e.getY());
//                dokum.getTransition().add(transition);
//
//            TransformNet tranNet = new TransformNet();
//            petrisNet = tranNet.transform(dokum);
//
//            TransformGraphic graf = new TransformGraphic();
//            element = graf.transform(petrisNet,dokum);
////                TransformNet tranNet = new TransformNet();
////                petrisNet = traNet.transform(dokum);
////
////                TransformGraphic graf = new TransformGraphic();
////                element = graf.transforms(petrisNet,dokum,element );
//
//               id = 1;
//                repaint();
//            }
//
//
//
//        if(framik.button3.isSelected()) {
//            String tr = "arc";
//            for (Elements elements : element) {
//                if (elements.contains(e.getX(), e.getY())) {
//                    if (count != 2 && framik.button3.isSelected()) {
//                        x1=elements.getId();
//                        count++;
//                        break;
//                    }
//
//                    else if (count == 2 && framik.button3.isSelected()) {
//                        x2= elements.getId();
//
//                        Arc arc = new Arc();
//                        arc.setId(id);
//                        arc.setSourceId(x1);
//                        arc.setDestinationId(x2);
//                        arc.setType(ArcType.REGULAR);
//                        arc.setMultiplicity(1);
//                        dokum.getArc().add(arc);
//
//                        TransformNet tranNet = new TransformNet();
//                        petrisNet = tranNet.transform(dokum);
//
//                        TransformGraphic graf = new TransformGraphic();
//                        element = graf.transform(petrisNet,dokum);
//
//                        repaint();
//                        x1 = 0;
//                        x2 = 0;
//                        id++;
//                        count = 1;
//                        break;
//                    }
//                }
//            }
//        }
//
//            if (framik.button4.isSelected()) {
//                String rem = "removeArc";
//                Elements elementos = null;
//                for (Elements elements : element) {
//                    Transition tran = new Transition();
//
//                   // elementos = elements.clickOn(e, "removeArc");
//
//                    if (elements.contains(e.getX(), e.getY()) ) {
//                        if (elements.contains(e.getX(), e.getY()) && elements instanceof Transition2D) {
//                            dokum.removeTransition(elements.getId());
//
//                            TransformNet tranNet = new TransformNet();
//                            petrisNet = tranNet.transform(dokum);
//
//                            TransformGraphic graf = new TransformGraphic();
//                            element = graf.transform(petrisNet, dokum);
//
//                            repaint();
//                            break;
//                        } else if (elements.contains(e.getX(), e.getY()) && elements instanceof Place_2D) {
//
//                            dokum.removePlace(elements.getId());
//
//                            TransformNet tranNet = new TransformNet();
//                            petrisNet = tranNet.transform(dokum);
//
//                            TransformGraphic graf = new TransformGraphic();
//                            element = graf.transform(petrisNet, dokum);
//
//                            repaint();
//
//                            break;
//                        }
//                        //     else if (elements.contains(e.getX(), e.getY()) && elements instanceof Arc_2D) {
//
//
//                     else if (elements instanceof Arc_2D && elements.contains(e.getX(),e.getY()) ) {
//                           // elements.clickOn(e, "removeArc");
//                            dokum.removeArc(elements.getId());
//                            System.out.println("naok");
//
//                            TransformNet tranNet = new TransformNet();
//                            petrisNet = tranNet.transform(dokum);
//
//                            TransformGraphic graf = new TransformGraphic();
//                            element = graf.transform(petrisNet, dokum);
//
//                            repaint();
//                            break;
//
//                        }
//
//
//                    }
//                }
//            }
//        if (framik.button5.isSelected()) {
//            String norm = "normal";
//            for(Elements elements : element){
//                if(elements.contains(e.getX(),e.getY()) && elements instanceof Transition2D) {
//                    elements.clickOn(e,norm);
//                    repaint();
//                    break;
//                }
//                if(elements.contains(e.getX(),e.getY()) && elements instanceof Place_2D) {
//                    elements.clickOn(e,norm);
//                    repaint();
//                    break;
//                }
//            }
//        }
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

    public void mouseExited(MouseEvent e) {

    }

    public void setElement(List<Elements> element) {
        this.element = element;
    }

    public List<Elements> getElement() {
        return element;
    }

    public Frames getFramik() {
        return framik;
    }

    public PetrisNet getPetrisNet() {
        return petrisNet;
    }

    public Document getDokum() {
        return dokum;
    }
}
