package fei.stuba.sk.graphics;

import fei.stuba.sk.zadanie.PetrisNet;
import fei.stuba.sk.zadanie.Place;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;

public class Place_2D extends Elements {

    private Ellipse2D placeEli;
    private Place place;
    private short id;

    PetrisNet net = new PetrisNet();

    public Place_2D(int x, int y, Place place, PetrisNet net, short id) {
        super(x, y, id);
        this.net = net;
        this.id = place.getID();
        this.placeEli = new Ellipse2D.Float(x, y, 40, 40);
        this.place = place;

    }

    @Override
    public boolean contains(int x, int y) {
        return placeEli.contains(x, y);
    }

    @Override
    public void draw(Graphics2D graphics2D) {


        graphics2D.drawString(place.getName(), getX(), getY());

        graphics2D.setColor(Color.WHITE);
        graphics2D.fillOval((int) placeEli.getX(), (int) placeEli.getY(), (int) placeEli.getWidth(), (int) placeEli.getHeight());
        graphics2D.setColor(Color.BLACK);
        graphics2D.draw(placeEli);

        graphics2D.drawString(Integer.toString(place.getToken()), (int) placeEli.getX() + 16, (int) placeEli.getY() + 25);
        if (place.getToken() < 0) {
            graphics2D.setColor(Color.WHITE);
            graphics2D.fillOval((int) placeEli.getX(), (int) placeEli.getY(), (int) placeEli.getWidth(), (int) placeEli.getHeight());
            graphics2D.setColor(Color.BLACK);
            place.setToken(0);
            graphics2D.drawString(Integer.toString(place.getToken()), (int) placeEli.getX() + 16, (int) placeEli.getY() + 25);
        }
    }

    public short getId() {
        return id;
    }

    public int getToken() {
        return place.getToken();
    }

    public void setToken(int i) {
        place.setToken(i);
    }

    public Elements clickOn(MouseEvent e, String buttonclicked) {

        if (e.getButton() == MouseEvent.BUTTON1 && buttonclicked == "place"){
            System.out.println("pridavas place");
        }

        else if(e.getButton()==MouseEvent.BUTTON1 && buttonclicked == "remove"){
            return this;
        }

        else if (e.getButton() == MouseEvent.BUTTON1&& buttonclicked == "normal") {
            setToken(getToken() + 1);
            System.out.println("klikol si na place" + place.getID());
        }
        else if (e.getButton() == MouseEvent.BUTTON3 && getToken() > 0 ) {
            setToken(getToken() - 1);
            System.out.println("klikol si na place" + place.getID());
        }

        return this;
    }
}
