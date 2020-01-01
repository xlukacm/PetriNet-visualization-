package fei.stuba.sk.Listeners;

import fei.stuba.sk.graphics.CanvasNet;
import fei.stuba.sk.graphics.Elements;
import fei.stuba.sk.graphics.Place_2D;
import fei.stuba.sk.graphics.Transition2D;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class RunListener  implements MouseListener {
    CanvasNet canvasNet;

    public RunListener(CanvasNet canvasNet) {
        this.canvasNet = canvasNet;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        String norm = "normal";
        for(Elements elements : canvasNet.getElement()){
            if(elements.contains(e.getX(),e.getY()) && elements instanceof Transition2D) {
                elements.clickOn(e,norm);
               // repaint();
                break;
            }
//            if(elements.contains(e.getX(),e.getY()) && elements instanceof Place_2D) {
//                elements.clickOn(e,norm);
//             //   repaint();
//                break;
//            }
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