import greenfoot.*;

import java.util.ArrayList;

public class helpObject extends Actor{
    Structures myStructure;

    int x;
    int y;

    ArrayList<Integer> additionalCoordsX = new ArrayList<>();
    ArrayList<Integer> additionalCoordsY = new ArrayList<>();
    ArrayList<Color> additionalColors = new ArrayList<>();

    ArrayList<Structures> structures=new ArrayList<>();
    public helpObject(Structures myStructure){
        this.myStructure = myStructure;
        setNullImage();
    }

    public void setNullImage(){
        GreenfootImage image = new GreenfootImage(1, 1);
        setImage(image);
    }
    public void act(){
    }

    public void add(Structures st){
        structures.add(st);
    }

    public void remove(Structures st){
        structures.remove(st);
    }

    int[] xPoints = new int[4];
    int[] yPoints = new int[4];
    int n;
    public void drawLines(GreenfootImage fon, Color c, int xLoc, int yLoc){
        if(yLoc > y + fon.getHeight() && xLoc < x
                || yLoc < y && xLoc > x + fon.getWidth()){
            MyWorld.connectionImage.setColor(c);
            MyWorld.connectionImage.drawLine(xLoc, yLoc,x,y);
            MyWorld.connectionImage.drawLine(xLoc, yLoc,x+fon.getWidth(),y+fon.getHeight());

            xPoints[0] = x;
            xPoints[2] = x + fon.getWidth();

            yPoints[0] = y;
            yPoints[2] = y + fon.getHeight();

            if(Math.pow(xLoc - (x + fon.getWidth()), 2) + Math.pow(yLoc - y, 2) < Math.pow(xLoc - x, 2) + Math.pow(yLoc - (y + fon.getHeight()), 2)){
                xPoints[1] = x + fon.getWidth();
                yPoints[1] = y;
            }
            else{
                xPoints[1] = x;
                yPoints[1] = y + fon.getHeight();
            }

            n = 4;
        }
        if(yLoc < y && xLoc < x
                || yLoc > y + fon.getHeight() && xLoc > x + fon.getWidth()){
            MyWorld.connectionImage.setColor(c);
            MyWorld.connectionImage.drawLine(xLoc, yLoc,x+fon.getWidth(),y);
            MyWorld.connectionImage.drawLine(xLoc, yLoc,x,y+fon.getHeight());

            xPoints[0] = x + fon.getWidth();
            xPoints[2] = x;

            yPoints[0] = y;
            yPoints[2] = y + fon.getHeight();

            if(Math.pow(xLoc - x, 2) + Math.pow(yLoc - y, 2) < Math.pow(xLoc - (x + fon.getWidth()), 2) + Math.pow(yLoc - (y + fon.getHeight()), 2)){
                xPoints[1] = x;
                yPoints[1] = y;
            }
            else{
                xPoints[1] = x + fon.getWidth();
                yPoints[1] = y + fon.getHeight();
            }

            n = 4;
        }
        //up
        if(yLoc<=y && xLoc>=x && xLoc<=x+fon.getWidth()){
            MyWorld.connectionImage.setColor(c);
            MyWorld.connectionImage.drawLine(xLoc, yLoc,x,y);
            MyWorld.connectionImage.drawLine(xLoc, yLoc,x+fon.getWidth(),y);

            xPoints[0] = x;
            xPoints[1] = x + fon.getWidth();

            yPoints[0] = y;
            yPoints[1] = y;

            n = 3;
        }
        //down
        if(yLoc>=y+fon.getHeight() && xLoc>=x && xLoc<=x+fon.getWidth()){
            MyWorld.connectionImage.setColor(c);
            MyWorld.connectionImage.drawLine(xLoc, yLoc,x,y+fon.getHeight());
            MyWorld.connectionImage.drawLine(xLoc, yLoc,x+fon.getWidth(),y+fon.getHeight());

            xPoints[0] = x;
            xPoints[1] = x + fon.getWidth();

            yPoints[0] = y + fon.getHeight();
            yPoints[1] = y + fon.getHeight();

            n = 3;
        }
        //left
        if(yLoc<=y+fon.getHeight() && yLoc>=y && xLoc<=x){
            MyWorld.connectionImage.setColor(c);
            MyWorld.connectionImage.drawLine(xLoc, yLoc,x,y);
            MyWorld.connectionImage.drawLine(xLoc, yLoc,x,y+fon.getHeight());

            xPoints[0] = x;
            xPoints[1] = x;

            yPoints[0] = y;
            yPoints[1] = y + fon.getHeight();

            n = 3;
        }
        //right
        if(yLoc<=y+fon.getHeight() && yLoc>=y && xLoc>=x+fon.getWidth()){
            MyWorld.connectionImage.setColor(c);
            MyWorld.connectionImage.drawLine(xLoc, yLoc,x+fon.getWidth(),y);
            MyWorld.connectionImage.drawLine(xLoc, yLoc,x+fon.getWidth(),y+fon.getHeight());

            xPoints[0] = x + fon.getWidth();
            xPoints[1] = x + fon.getWidth();

            yPoints[0] = y;
            yPoints[1] = y + fon.getHeight();

            n = 3;
        }

        xPoints[n - 1] = xLoc;
        yPoints[n - 1] = yLoc;

        MyWorld.connectionImage.drawRect(x - 1, y - 1, fon.getWidth() + 1, fon.getHeight() + 1);

        MyWorld.connectionImage.setColor(new Color(c.getRed(), c.getGreen(), c.getBlue(), 100));
        MyWorld.connectionImage.fillPolygon(xPoints, yPoints, n);
    }
    public void drawConnections(){
        for(int i=0;i<structures.size();i++){
            MyWorld.connectionImage.setColor(new Color(82, 80, 255, 255));
            structures.get(i).drawLines(structures.get(i).fon, new Color(82, 80, 255, 255), x + (myStructure.fon.getWidth() / 2), y + (myStructure.fon.getHeight() / 2));
            //MyWorld.myImage.drawLine((x+getImage().getWidth()*5),(y+getImage().getWidth()*5),(structures.get(i).x+structures.get(i).getImage().getWidth()*5),(structures.get(i).y+structures.get(i).getImage().getWidth()*5)+1);
        }
    }
    public void drawCircle(Color color, int radius, ArrayList<Structures> structures){
        /*circle.setColor(Color.BLACK);
        circle.drawOval(0,0,radius*2,radius*2);
        circle.drawOval(2,2,radius*2-4,radius*2-4);*/
        //fonwC.setColor(new Color(0,0,0,0));
        //fonwC.fillOval(getX()-radius+2,getY()-radius+2,(radius*2)-4,(radius*2)-4);
        MyWorld.connectionImage.setColor(color);
        MyWorld.connectionImage.drawOval((x+getImage().getWidth()*5)-radius,(y+getImage().getHeight()*5)-radius,radius*2,radius*2);
        MyWorld.connectionImage.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), 100));
        for(int i=0;i<structures.size();i++){
            structures.get(i).drawLines(structures.get(i).fon, color, x + (myStructure.fon.getWidth() / 2), y + (myStructure.fon.getHeight() / 2));
            //MyWorld.myImage.drawLine((x+getImage().getWidth()*5),(y+getImage().getWidth()*5),(structures.get(i).x+structures.get(i).getImage().getWidth()*5),(structures.get(i).y+structures.get(i).getImage().getWidth()*5)+1);
        }
    }
}
