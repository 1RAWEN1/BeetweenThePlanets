import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Baza here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Baza extends Structures
{
    /**
     * Act - do whatever the Baza wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int start;
    public Baza(int x1, int y1){
        x=x1;
        y=y1;
        type=1;
        resNum[2]=200;
        maxResourсes =9000;
        needRes.add(2);
        needRes.add(3);
        canBreak = false;
        fon=new GreenfootImage("Baza.png");
    }
    public void act() 
    {
        if(start==0){
            //getWorld().addObject(myIn, getX(), getY()-30);
            start=1;
        }
        isClick();
        draw(fon);
        updateMyImage();// Add your action code here.
    }
}
