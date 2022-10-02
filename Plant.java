import java.util.ArrayList;

public class Plant extends Structures{
    SimpleTimer timer = new SimpleTimer();

    int timer1;
    SimpleTimer timer2 = new SimpleTimer();
    int typeRes;

    ArrayList<Integer> needResToCreate = new ArrayList<>();
    public void doMainActions(){
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

            if(haveEnergy) {
                canCreate = true;
                for (int i = 0; i < needResToCreate.size(); i += 2) {
                    if (resNum[needResToCreate.get(i)] < needResToCreate.get(i + 1)) {
                        canCreate = false;
                        break;
                    }
                }

                if (timer2.millisElapsed() > timer1 && resNum[typeRes] < maxResourсes && canCreate) {
                    resNum[typeRes]++;
                    for (int i = 0; i < needResToCreate.size(); i += 2) {
                        resNum[needResToCreate.get(i)] -= needResToCreate.get(i + 1);
                    }
                    timer2.mark();
                }

                if (timer.millisElapsed() > millisStep) {
                    transportRes(typeRes);

                    timer.mark();
                }

                haveEnergy = false;
            }
        }
    }
}
