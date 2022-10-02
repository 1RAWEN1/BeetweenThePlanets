import java.util.ArrayList;

public class EnergyGetter extends Structures{
    SimpleTimer timer = new SimpleTimer();

    ArrayList<Integer> needResToCreate = new ArrayList<>();
    int time;
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

            if(timer.millisElapsed() > time) {
                canCreate = true;
                for (int i = 0; i < needResToCreate.size(); i += 2) {
                    if (resNum[needResToCreate.get(i)] < needResToCreate.get(i + 1)) {
                        canCreate = false;
                        break;
                    }
                }

                if (canCreate) {
                    for (int i = 0; i < needResToCreate.size(); i += 2) {
                        resNum[needResToCreate.get(i)] -= needResToCreate.get(i + 1);
                    }
                    energy = energyICanCreate;
                }
                timer.mark();
            }
            else if(canCreate){
                energy = energyICanCreate;
            }
        }
    }
}
