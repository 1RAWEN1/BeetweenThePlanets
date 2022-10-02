import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.util.ArrayList;

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
    GreenfootImage myImage1;
    GreenfootImage getter;
    int rot;

    int typeRes;

    int start;

    double speed;
    double speed1;
    ArrayList<Integer> canBreakRes = new ArrayList<>();
    ArrayList<Integer> Res = new ArrayList<>();
    int maxValueOfRes;

    double boost;
    int timer1;
    SimpleTimer timer = new SimpleTimer();
    SimpleTimer timer2 = new SimpleTimer();

    double fullSpeed;
    public void doMainActions(){
        if(start==0){
            getWorld().addObject(helperLab, getX(), getY());
            helperLab.setFillColor(Color.BLACK);
            start=1;
        }
        if(type==0){
            updateStructureLocation();

            if(changeLocation()) {
                Res.clear();
                for (Resource res : getIntersectingObjects(Resource.class)) {
                    boolean canBreakThisRes = false;
                    for (Integer resType : canBreakRes) {
                        if (res.getType() == resType) {
                            canBreakThisRes = true;
                            break;
                        }
                    }
                    if (canBreakThisRes) {
                        for (int i1 = 0; i1 < Res.size(); i1 += 2) {
                            if (Res.get(i1) == res.getType()) {
                                Res.set(i1 + 1, Res.get(i1 + 1) + 1);
                                break;
                            } else if (i1 + 2 == Res.size()) {
                                Res.add(res.getType());
                                Res.add(1);
                                break;
                            }
                        }
                        if (Res.size() == 0) {
                            Res.add(res.getType());
                            Res.add(1);
                        }
                    }
                }

                maxValueOfRes = 0;
                typeRes = -1;
                for (int i2 = 1; i2 < Res.size(); i2 += 2) {
                    if (Res.get(i2) > maxValueOfRes) {
                        maxValueOfRes = Res.get(i2);
                        typeRes = Res.get(i2 - 1);
                    }
                }

                speed = speed1 * maxValueOfRes;
            }
            /*myx=(getX()-800-1)/Map.cof;
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
            }*/
            helperLab.typeres= typeRes;
            helperLab.setValue(""+speed);
            MouseInfo mi = Greenfoot.getMouseInfo();
            if(mi != null && mi.getButton() == 1 && Mouse.mousePressed && speed>0 && !isTouching(NatObstical.class) && !isTouching(Structures.class)){
                if(canBeBuild()){
                    timer1=(int)(1000/speed);
                    timer.mark();
                    type=1;
                }
            }
        }
        else if(type==1 && isBuilt()){
            isClick();

            if(MyWorld.selectedStructure == this){
                updateLabelLocation();

                helperLab.typeres= typeRes;
                helperLab.setValue("" + fullSpeed);
            }
            else if(helperLab.typeres != -1){
                helperLab.typeres = -1;
                helperLab.setValue("");
            }

            checkStructures();

            removeNullStructures();

            if(typeRes != 0) {
                if(resNum[0] > 0){
                    boost = 1.3;
                }
                else{
                    boost = 1;
                }

                fullSpeed = speed * boost;

                if (timer.millisElapsed() > timer1 / boost && resNum[typeRes] < maxResourсes) {
                    resNum[typeRes]++;
                    if(resNum[0] > 0){
                        resNum[0]--;
                    }
                    timer.mark();
                }

                if (timer2.millisElapsed() > millisStep) {
                    transportRes(typeRes);

                    timer2.mark();
                }
            }
            else {
                fullSpeed = speed;

                if (timer.millisElapsed() > timer1 && resNum[typeRes] < maxValueOfLiquid) {
                    resNum[typeRes]++;
                    timer.mark();
                }

                transportRes(typeRes);
            }
        }
    }
    public double getSpeed(){
        return speed;
    }
}
