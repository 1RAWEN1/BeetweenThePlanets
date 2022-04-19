import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Getter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Getter extends Structures
{
    /**
     * Act - do whatever the Getter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    Label speedLab=new Label("", 18, 1);
    GreenfootImage myImage1;
    GreenfootImage getter;
    int rot;

    int typeRes;

    int myx;
    int myy;

    int start;

    double speed;
    double speed1;

    int timer1;
    SimpleTimer timer = new SimpleTimer();
    SimpleTimer timer2 = new SimpleTimer();
    public void act() 
    {
        // Add your action code here.
    }
    public void doMainActions(){
        if(start==0){
            getWorld().addObject(speedLab, getX(), getY());
            speedLab.setFillColor(Color.BLACK);
            start=1;
        }
        if(type==0){
            updateStructureLocation();
            speedLab.setLocation(x-Player.x+500+fon.getWidth()
            , y-Player.y+300);
            myx=(getX()-800-1)/Map.cof;
            myy=(getY()-1)/Map.cof;
            if(myx<MyWorld.x1-2 && myx>0
            && myy<MyWorld.y1-2 && myy>0){
                if(MyWorld.myWorld[myx][myy]==2 
                || MyWorld.myWorld[myx+1][myy]==2 
                || MyWorld.myWorld[myx][myy+1]==2 
                || MyWorld.myWorld[myx+1][myy+1]==2){
                    typeRes =1;
                    speed=0;
                    if(MyWorld.myWorld[myx][myy]==2){
                        speed+=speed1;
                    }
                    if(MyWorld.myWorld[myx+1][myy]==2){
                        speed+=speed1;
                    }
                    if(MyWorld.myWorld[myx][myy+1]==2){
                        speed+=speed1;
                    }
                    if(MyWorld.myWorld[myx+1][myy+1]==2){
                        speed+=speed1;
                    }
                }
                else if(MyWorld.myWorld[myx][myy]==3 
                || MyWorld.myWorld[myx+1][myy]==3 
                || MyWorld.myWorld[myx][myy+1]==3 
                || MyWorld.myWorld[myx+1][myy+1]==3){
                    typeRes =2;
                    speed=0;
                    if(MyWorld.myWorld[myx][myy]==3){
                        speed+=speed1;
                    }
                    if(MyWorld.myWorld[myx+1][myy]==3){
                        speed+=speed1;
                    }
                    if(MyWorld.myWorld[myx][myy+1]==3){
                        speed+=speed1;
                    }
                    if(MyWorld.myWorld[myx+1][myy+1]==3){
                        speed+=speed1;
                    }
                }
                else if(MyWorld.myWorld[myx][myy]==5 
                || MyWorld.myWorld[myx+1][myy]==5 
                || MyWorld.myWorld[myx][myy+1]==5 
                || MyWorld.myWorld[myx+1][myy+1]==5){
                    typeRes =3;
                    speed=0;
                    if(MyWorld.myWorld[myx][myy]==5){
                        speed+=speed1;
                    }
                    if(MyWorld.myWorld[myx+1][myy]==5){
                        speed+=speed1;
                    }
                    if(MyWorld.myWorld[myx][myy+1]==5){
                        speed+=speed1;
                    }
                    if(MyWorld.myWorld[myx+1][myy+1]==5){
                        speed+=speed1;
                    }
                }
                else if(MyWorld.myWorld[myx][myy]==8 
                || MyWorld.myWorld[myx+1][myy]==8 
                || MyWorld.myWorld[myx][myy+1]==8
                || MyWorld.myWorld[myx+1][myy+1]==8){
                    typeRes =4;
                    speed=0;
                    if(MyWorld.myWorld[myx][myy]==8){
                        speed+=speed1;
                    }
                    if(MyWorld.myWorld[myx+1][myy]==8){
                        speed+=speed1;
                    }
                    if(MyWorld.myWorld[myx][myy+1]==8){
                        speed+=speed1;
                    }
                    if(MyWorld.myWorld[myx+1][myy+1]==8){
                        speed+=speed1;
                    }
                }
                else{
                    speed=0;
                    typeRes =0;
                }
            }
            else{
                speed=0;
                typeRes =0;
            }
            speedLab.typeres= typeRes;
            speedLab.setValue(""+speed);
            MouseInfo mi = Greenfoot.getMouseInfo();
            if(mi != null && mi.getButton() == 1 && Mouse.mousePressed && speed>0 && !isTouching(NatObstical.class) && !isTouching(Structures.class)){
                if(canBeBuild()){
                    x=MyWorld.mi.x;
                    y=MyWorld.mi.y;
                    timer1=(int)(1000/speed);
                    timer.mark();
                    getWorld().removeObject(speedLab);
                    type=1;
                }
            }
            else if(mi != null  && mi.getButton() == 3 || Greenfoot.isKeyDown("Escape")){
                getWorld().removeObject(speedLab);
            }
        }
        else if(type==1){
            isClick();

            checkStructures();

            if(timer.millisElapsed()>timer1 && resNum[typeRes]< maxResourсes){
                resNum[typeRes]++;
                timer.mark();
            }

            removeNullStructures();

            if(timer2.millisElapsed() > millisStep){
                transportRes(typeRes);

                timer2.mark();
            }
        }
    }
    public double getSpeed(){
        return speed;
    }
}
