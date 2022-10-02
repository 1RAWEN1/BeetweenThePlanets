import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Getter1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class waterPump1 extends Getter
{
    /**
     * Act - do whatever the Getter1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public waterPump1(int type1){
        maxValueOfLiquid = 10;
        type = type1;
        speed1 = 1.5;
        radius = 0;
        fon = new GreenfootImage("Gen2.png");
        cost.add(2);
        cost.add(20);

        canBreakRes.add(0);

        updateStructureLocation();
    }
    public void act()
    {
        updateThisImage();
        doMainActions();
        //updateMyImage();// Add your action code here.
    }
    public void updateThisImage(){
        draw(fon);
    }
}
