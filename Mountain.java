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
    int x;
    int y;
    public Mountain(int x, int y){
        this.x=x;
        this.y=y;
        setImage("mountain.png");
    }

    public void updateLocation(){
        setLocation((getWorld().getWidth() / 2) + x - Player.x, (getWorld().getHeight() / 2) + y - Player.y);
    }
    public void act() 
    {
        updateLocation();// Add your action code here.
    }    
}
