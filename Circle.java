import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Circle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Circle extends Actor
{
    /**
     * Act - do whatever the Circle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage circle;
    int radius;
    Color color;
    ArrayList<Structures> structures=new ArrayList<Structures>();
    public Circle(int radius1, Color color1){
        radius=radius1;
        color=color1;
        setMyImage();
    }    
    public void act() 
    {
        // Add your action code here.
    }
    public void setMyImage(){
        circle=new GreenfootImage(1, 1);
        circle.clear();
        setImage(circle);
    }
    public void drawCircle(){
        circle=new GreenfootImage(radius*2, radius*2);
        circle.clear();
        /*circle.setColor(Color.BLACK);
        circle.drawOval(0,0,radius*2,radius*2);
        circle.drawOval(2,2,radius*2-4,radius*2-4);*/
        circle.setColor(color);
        circle.drawOval(1,1,radius*2-2,radius*2-2);
        circle.drawOval(0,0,radius*2,radius*2);
        for(int i=0;i<structures.size();i++){
            circle.drawLine(getX(),getY(),structures.get(i).getX(),structures.get(i).getY());
        }
        setImage(circle);
    }
}
