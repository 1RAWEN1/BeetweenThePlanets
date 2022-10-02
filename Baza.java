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
        resNum[2]=700;
        resNum[1]=700;
        resNum[3]=700;
        resNum[4]=700;
        resNum[5]=700;
        resNum[6]=700;
        resNum[7]=700;
        resNum[8]=700;
        maxResourсes =9000;
        needRes.add(2);
        needRes.add(3);
        needRes.add(5);
        needRes.add(7);
        needRes.add(8);
        canBreak = false;

        canCreate = true;

        fon=new GreenfootImage("Baza.png");

        cost.add(2);
        cost.add(500);

        energyICanCreate = 150;

        //building1 = 500;
    }
    public void act() 
    {
        if(start==0){
            //getWorld().addObject(myIn, getX(), getY()-30);
            start=1;
        }
        isClick();

        energy = energyICanCreate;

        draw(fon);
        //updateMyImage();// Add your action code here.
    }
}
