package fei.stuba.sk.graphics;

import fei.stuba.sk.zadanie.PetrisNet;
import fei.stuba.sk.zadanie.Transition;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

public class Transition2D extends Elements {
    PetrisNet net = new PetrisNet();

    private Rectangle2D rectangle2D;
    private Transition transition;
    private short id;

    public Transition2D(int x, int y, Transition transition, PetrisNet net, short id) {
        super(x, y, id );
        this.net = net;
        this.transition = transition;
        this.id = transition.getID();
        this.rectangle2D = new Rectangle2D.Float(x,y,40,40);
    }

    public boolean contains(int x, int y){
        return rectangle2D.contains(x,y);
    }

    @Override
    public void draw(Graphics2D graphics) {
        graphics.draw(rectangle2D);

        int x = (int)rectangle2D.getBounds().getCenterX()-50;
        int y = (int)rectangle2D.getY()+50;

        graphics.setColor(Color.WHITE);
        graphics.fillRect((int) rectangle2D.getX(),(int)rectangle2D.getY(),(int)rectangle2D.getWidth(),(int)rectangle2D.getHeight());
        graphics.setColor(Color.black);
        graphics.drawString(transition.getName(),x,y);
        graphics.draw(rectangle2D);

            if(net.isPress(transition.getID())){
                graphics.setColor(Color.GREEN);
                graphics.fillRect((int) rectangle2D.getX(),(int)rectangle2D.getY(),(int)rectangle2D.getWidth(),(int)rectangle2D.getHeight());
                graphics.setColor(Color.black);
            }
            else {
                graphics.setColor(Color.RED);
                graphics.fillRect((int) rectangle2D.getX(),(int)rectangle2D.getY(),(int)rectangle2D.getWidth(),(int)rectangle2D.getHeight());
                graphics.setColor(Color.black);
            }
    }

    public short getId() {
        return id;
    }

    public Elements clickOn(MouseEvent e, String buttonclicked){

        if(e.getButton() == MouseEvent.BUTTON1 && buttonclicked == "normal"){
            net.pressTransition(transition.getID());
            System.out.println("klikol si na transition" + transition.getID());

        }
        else if (e.getButton() == MouseEvent.BUTTON1 && buttonclicked == "remove"){
            return this;
        }
        return this;
    }
}

//nastavit click on na Elements a returneme retuurn this a v canvase vratit adresu elementu