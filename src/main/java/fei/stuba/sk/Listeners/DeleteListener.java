package fei.stuba.sk.Listeners;

import fei.stuba.sk.generate.Document;
import fei.stuba.sk.generate.TransformGraphic;
import fei.stuba.sk.generate.TransformNet;
import fei.stuba.sk.generate.Transition;
import fei.stuba.sk.graphics.*;
import fei.stuba.sk.zadanie.PetrisNet;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DeleteListener  implements MouseListener {
    CanvasNet canvasNet;
    private Document dokum;
    private PetrisNet petrisNet;

    public DeleteListener(CanvasNet canvasNet, Document dokum) {
        this.canvasNet = canvasNet;
        this.dokum = dokum;
        petrisNet = new PetrisNet();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        String rem = "removeArc";
        Elements elementos = null;
        for (Elements elements : canvasNet.getElement()) {
            Transition tran = new Transition();

            // elementos = elements.clickOn(e, "removeArc");

            if (elements.contains(e.getX(), e.getY()) ) {
                if (elements.contains(e.getX(), e.getY()) && elements instanceof Transition2D) {
                    dokum.removeTransition(elements.getId());

                    TransformNet tranNet = new TransformNet();
                    petrisNet = tranNet.transform(dokum);

                    TransformGraphic graf = new TransformGraphic();
                //    canvasNet.getElement() = graf.transform(petrisNet, dokum);

                  //  repaint();
                    break;
                } else if (elements.contains(e.getX(), e.getY()) && elements instanceof Place_2D) {

                    dokum.removePlace(elements.getId());

                    TransformNet tranNet = new TransformNet();
                    petrisNet = tranNet.transform(dokum);

                    TransformGraphic graf = new TransformGraphic();
            //       element = graf.transform(petrisNet, dokum);

              //      repaint();

                    break;
                }
                //     else if (elements.contains(e.getX(), e.getY()) && elements instanceof Arc_2D) {


                else if (elements instanceof Arc_2D && elements.contains(e.getX(),e.getY()) ) {
                    // elements.clickOn(e, "removeArc");
                    dokum.removeArc(elements.getId());
                    System.out.println("naok");

                    TransformNet tranNet = new TransformNet();
                    petrisNet = tranNet.transform(dokum);

                    TransformGraphic graf = new TransformGraphic();
                 //   element = graf.transform(petrisNet, dokum);

             //       repaint();
                    break;

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