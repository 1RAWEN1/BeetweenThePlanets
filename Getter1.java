import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Getter1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Getter1 extends Getter
{
    /**
     * Act - do whatever the Getter1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Getter1(int type1){
        type = type1;
        maxResourсes = 10;
        speed1 = 0.15;
        radius = 0;
        millisStep = 500;
        fon = new GreenfootImage("dob1.png");
        getter = new GreenfootImage("dob11.png");
        myImage1 = new GreenfootImage("dob1.png");
        cost.add(2);
        cost.add(20);
    }
    public void act() 
    {
        doMainActions();
        updateThisImage();
        updateMyImage();// Add your action code here.
    }  
    public void updateThisImage(){
        if(resNum[typeRes]< maxResourсes){
            rot+=2;
        }
        if(rot==360){
            rot=0;
        }
        getter.clear();
        myImage1.clear();
        getter=new GreenfootImage("dob11.png");
        myImage1.drawImage(fon, 0, 0);
        getter.rotate(rot);
        myImage1.drawImage(getter, 0, 0);
        if(getSpeed()==0){
            myImage1.setColor(new Color(255, 0, 0, 100));
            myImage1.fillRect(0,0,myImage1.getWidth(),myImage1.getHeight());
        }
        draw(myImage1);
    }
}
