package fei.stuba.sk.graphics;

import fei.stuba.sk.generate.Arc;
import fei.stuba.sk.generate.ArcType;
import fei.stuba.sk.generate.BreakPoint;
import fei.stuba.sk.zadanie.Edge;
import fei.stuba.sk.zadanie.PetrisNet;

import java.awt.*;

import java.awt.event.MouseEvent;
import java.awt.geom.*;
import java.util.List;

public class Arc_2D extends Elements {

    private Path2D path2D;
    private Line2D line2D;
    private ArcType arcType;
    private Edge arc;
    PetrisNet net = new PetrisNet();

    private List<BreakPoint> breakPointList;
    private short x3, y3;
    private int multiplicity;


    private final int length = 20;

    public Arc_2D(int x1, int y1, int x2, int y2, int multiplicity, PetrisNet net, short id) {
        super(x1, y1, x2, y2, id);
        this.net = net;
        this.line2D = new Line2D.Double(x1 + length, y1 + length, x2 + length, y2 + length);
        this.multiplicity = multiplicity;
    }


    public Arc_2D(int x11, int y11, int x22, int y22, java.util.List<BreakPoint> breakPointsList, int multiplicity, short id) {
        super(x11, y11, x22, y22, id);
        this.path2D = new Path2D.Double();
        this.line2D = new Line2D.Double(x11 + length, y11 + length, x22 + length, y22 + length);
        this.breakPointList = breakPointsList;
        this.multiplicity = multiplicity;

        if (breakPointsList != null) {
            path2D.moveTo(getX(), getY());
            for (BreakPoint breakPoint : breakPointsList) {
                path2D.lineTo(breakPoint.getX(), breakPoint.getY());
            }
        }
    }

    public void draw(Graphics2D graphics2D) {
        int x = (int) line2D.getX1() + length / 2;
        int y = (int) line2D.getY1() + length / 2;
        int x2 = (int) line2D.getX2() + length / 2;
        int y2 = (int) line2D.getY2() + length / 2;


        //graphics2D.setStroke(new BasicStroke(1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

        // graphics2D.draw(path2D);
        graphics2D.draw(line2D);

        ////////////////////////pre breakpointy rozrobene, ale stratil som s tym nervy///////////////////////////////////////


        //        int x3 = (int)breakPoint.getX();
        //      int y3 = (int)breakPoint.getY();

        //       path2D.moveTo(x3,y3);
        //     path2D.lineTo(x2,y2);
        //     path2D.closePath();

        //graphics2D.setStroke(new BasicStroke(1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        //  graphics2D.draw(line2D);

        //  graphics2D.draw(path2D);
        //line2D.setLine(x,y,x2,y2);

        // line2D.set
        double latitude1 = 1.0;
        double latitude2 = 0.0;

        double a = Math.sin(latitude1) * Math.cos(latitude2);
        double b = Math.cos(latitude1) * Math.sin(latitude2) - Math.sin(latitude1) * Math.cos(latitude2);
        double angle = Math.atan2(a, b);

        Polygon arrow = new Polygon();
        arrow.addPoint(x + length / 2, y);
        arrow.addPoint(x, y + length);
        arrow.addPoint(x + length, y + length);

        AffineTransform affineTransform = new AffineTransform();
        affineTransform.rotate(angle, x2, x2, y2);


        //   graphics2D.drawString(, x,y);
        //graphics2D.draw(arrow);

        // graphics2D.draw(affineTransform.rotate(angle,x2,x2,y2));
//        Math.abs(Math.max(source.getX(), target.getX()) - Math.min(source.getX(), target.getX())) + scaledOffset,
//                Math.abs(Math.max(source.getY(), target.getY()) - Math.min(source.getY(), target.getY())) + scaledOffset
    }

    @Override
    public boolean contains(int x, int y) {
        return false;
    }

    @Override
    public Elements clickOn(MouseEvent e, String buttonclicked) {
        if (e.getButton() == MouseEvent.BUTTON1 && buttonclicked == "remove" && line2D.intersects(e.getX(),e.getY(),5,5)) {
            System.out.println("klikol si na hranu");
      //      return this;
        } else if (e.getButton() == MouseEvent.BUTTON1 && buttonclicked == "removeArc" ) {
          //  for(Elements elements:element)
           // Elements elements = null;

          //  elements.setX(e.getX());
            System.out.println("zmazal si hranu ");
            return this;
        }
        return this;
    }
}
