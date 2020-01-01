package fei.stuba.sk.Buttons;

import fei.stuba.sk.Listeners.AddListener;
import fei.stuba.sk.generate.Document;
import fei.stuba.sk.graphics.CanvasNet;
import fei.stuba.sk.graphics.Elements;
import fei.stuba.sk.graphics.Frames;
import fei.stuba.sk.zadanie.PetrisNet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;

public class PlaceButton implements ActionListener {
private CanvasNet canvasNet;
    private List<Elements> element;
    private Document dokum;
    private PetrisNet petrisNet = new PetrisNet();

    public PlaceButton(List<Elements> element,CanvasNet canvasNet, Document dokum) {
        this.canvasNet = canvasNet;
        this.element = element;
        this.canvasNet  = canvasNet;
        this.dokum = dokum;
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        canvasNet.removeMouseListeners();
        canvasNet.addMouseListener(new AddListener(element,canvasNet,dokum,petrisNet,"place"));
    }

    public void setCanvasNet(CanvasNet canvasNet) {
        this.canvasNet = canvasNet;
    }

    public void setElement(List<Elements> element) {
        this.element = element;
    }

    public void setDokum(Document dokum) {
        this.dokum = dokum;
    }

    public void setPetrisNet(PetrisNet petrisNet) {
        this.petrisNet = petrisNet;
    }
}
