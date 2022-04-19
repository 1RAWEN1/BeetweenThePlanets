import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Transmitter1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Transmitter1 extends Transmitter
{
    /**
     * Act - do whatever the Transmitter1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Transmitter1(int type1){
        type = type1;
        mainMax = 3;
        radius = 0;
        millisStep = 1000;
        for(int i = 0; i < MyWorld.resTypes; i++){
            needRes.add(i);
        }
        fon = new GreenfootImage("transporter.png");
        cost.add(2);
        cost.add(1);
    }

    public void act() 
    {
        doMainActions();
        updateThisImage();
        updateMyImage();// Add your action code here.
    }

    public void updateThisImage(){
        if(type == 0) {
            fon = new GreenfootImage("transporter.png");
            fon.rotate(rot);
        }
        draw(fon);
    }
}
