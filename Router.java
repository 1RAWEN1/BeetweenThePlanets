public class Router extends Structures{
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
                    type=1;
                }
            }
        }
        else if(type==1 && isBuilt()){
            isClick();

            checkStructures();

            removeNullStructures();

            if(timer.millisElapsed() > millisStep){
                for(Integer i2 : needRes){
                    transportRes(i2);
                }

                timer.mark();
            }
        }
    }
}
