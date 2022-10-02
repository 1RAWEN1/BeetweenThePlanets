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
            else if(type==43){
                myst=new Router1(0);
            }
            else if(type==56){
                myst=new GraphiteFactory(0);
            }
            else if(type==57){
                myst=new SiliconFactory(0);
            }
            else if(type==58){
                myst=new glassOven(0);
            }
            else if(type==71){
                myst=new Node1(0);
            }
            else if(type==73){
                myst=new EnergyGetter1(0);
            }
            else if(type==86){
                myst=new waterPump1(0);
            }
            else if(type==87){
                myst=new WaterTransporter(0);
            }
            else if(type==88){
                myst=new WaterCrossroad(0);
            }
            else if(type==89){
                myst=new WaterRouter(0);
            }
            getWorld().addObject(myst,getX(),getY());
            start=0;
        }
        if(myst!=null && myst.getWorld() != null){
            MyWorld.i.drawStructureCost();

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
            MyWorld.i.setNullImage();
        }
    }

    public void changeType(int type){
        this.type = type;

        if(myst != null)
        myst.deleteStructure();
    }
}
