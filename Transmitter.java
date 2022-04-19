import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Transmitter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Transmitter extends Structures
{
    /**
     * Act - do whatever the Transmitter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    SimpleTimer timer = new SimpleTimer();

    GreenfootImage arrow = new GreenfootImage("arrow.png");
    public void doMainActions(){
        if(type==0){
            /*MouseInfo mi=Greenfoot.getMouseInfo();
            if(mi!=null){
                x=(((Player.x+(mi.getX()-500))/10)*10);
                y=(((Player.y+(mi.getY()-300))/10)*10);
                 setLocation(800+((x/10)*Map.cof)+(Map.cof/2)+((fon.getWidth()/10)/2)
                , ((y/10)*Map.cof)+(Map.cof/2)+((fon.getHeight()/10)/2));
            }*/
            updateStructureLocation();
            /*if(mi!=null){
                setLocation((((mi.getX()+5)/10)*10)-5-Player.x%10, (((mi.getY()+5)/10)*10)-5-Player.y%10);
            }*/
            rot = MyWorld.transmitterRot;

            if(Greenfoot.isKeyDown("up")){
                rot = 270;
                MyWorld.transmitterRot = rot;
            }
            else if(Greenfoot.isKeyDown("right")){
                rot = 0;
                MyWorld.transmitterRot = rot;
            }
            else if(Greenfoot.isKeyDown("down")){
                rot = 90;
                MyWorld.transmitterRot = rot;
            }
            else if(Greenfoot.isKeyDown("left")){
                rot = 180;
                MyWorld.transmitterRot = rot;
            }

            arrow = new GreenfootImage("arrow.png");
            arrow.rotate(rot);
            MyWorld.myImage.drawImage(arrow, x  + ((int)Math.cos(Math.toRadians(rot)) * 10), y + ((int)Math.sin(Math.toRadians(rot)) * 10));

            if(Mouse.mousePressed && !isTouching(NatObstical.class) && !isTouching(Structures.class)){
                if(canBeBuild()){
                    x=MyWorld.mi.x;
                    y=MyWorld.mi.y;
                    type=1;
                }
            }
        }
        else if(type==1){
            isClick();

            checkStructures(rot);

            removeNullStructures();

            if(timer.millisElapsed() > millisStep){
                for(int i2 = 0; i2 < MyWorld.resTypes; i2++){
                    transportRes(i2);

                    timer.mark();
                }
            }
        }
    }
    public void act() 
    {
        // Add your action code here.
    }    
}
