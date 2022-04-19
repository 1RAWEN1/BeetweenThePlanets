public class Crossroad extends Structures{
    SimpleTimer timer = new SimpleTimer();

    boolean start;
    public void doMainActions(){
        if(!start){
            mainMax = 1;
            needRot = true;
            start = true;
        }
        if(type==0){
            updateStructureLocation();

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

            structures.clear();

            checkStructures(giveResFromRot);

            if(timer.millisElapsed() > millisStep){
                for(int i2 = 0; i2 < MyWorld.resTypes; i2++){
                    transportRes(i2);

                    timer.mark();
                }
            }
        }
    }
}
