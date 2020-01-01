package fei.stuba.sk.graphics;

import java.awt.*;
import java.awt.event.MouseEvent;

public abstract class Elements {
    private int x,y;
    private int x1,y1;
    private short id;

    private int Width = 30;

    public Elements(int x, int y, int x1, int y1, short id){
        this.x = x;
        this.y = y;
        this.x1 = x1;
        this.y1 = y1;
        this.id = id;
    }

    public Elements(int x, int y, short id) {
        this.x = x;
        this.y = y;
        this.id=id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public short getId() {
        return id;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public abstract void draw(Graphics2D graphics2D);

    public abstract boolean contains(int x, int y);

    public abstract Elements clickOn(MouseEvent e, String buttonclicked);

}
