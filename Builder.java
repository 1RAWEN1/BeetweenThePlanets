import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Builder here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Builder extends Actor
{
    /**
     * Act - do whatever the Builder wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    Structures myst;
    GreenfootImage myImage=new GreenfootImage(1,1);
    int start;
    int tr=200;
    int type;

    public Builder(){
        setImage(myImage);
    }
    public void act() 
    {
        if(start==1){
            if(type==11){
                myst=new Getter1(0);
            }
            else if(type==41){
                myst=new Transmitter1(0);
            }
            else if(type==42){
                myst=new Crossroad1(0);
            }
            getWorld().addObject(myst,getX(),getY());
            start=0;
        }
        if(myst!=null && myst.getWorld() != null){
            myst.transparency=tr;
            setLocation(myst.getX(), myst.getY());
        }

        if(myst != null && type != 0 && myst.type == 1){
            start = 1;
        }

        if(myst != null && Greenfoot.isKeyDown("Escape")){
            type = 0;
            start = 0;

            myst.deleteStructure();
        }
    }

    public void changeType(int type){
        this.type = type;

        if(myst != null)
        myst.deleteStructure();
    }
}
