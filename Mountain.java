import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mountain here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mountain extends NatObstical
{
    /**
     * Act - do whatever the Mountain wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage fon;
    int x;
    int y;
    public Mountain(int x, int y){
        this.x=x;
        this.y=y;
        GreenfootImage image=new GreenfootImage(Map.cof,Map.cof);
        image.setColor(new Color(0, 200, 0, 150));
        image.fill();
        setImage(image);
    }
    public void act() 
    {
        // Add your action code here.
    }    
}
