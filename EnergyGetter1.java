import greenfoot.*;

public class EnergyGetter1 extends EnergyGetter{
    public EnergyGetter1(int type1){
        type = type1;
        radius = 0;
        millisStep = 500;
        maxResourсes = 10;
        fon = new GreenfootImage("Gen3.png");
        cost.add(2);
        cost.add(20);
        cost.add(3);
        cost.add(20);

        time = 1000;
        needResToCreate.add(1);
        needResToCreate.add(1);

        needRes.add(1);

        energyICanCreate = 60;

        updateStructureLocation();
    }

    public void act()
    {
        updateThisImage();
        doMainActions();
        //updateMyImage();// Add your action code here.
    }

    public void updateThisImage(){
        draw(fon);
    }
}
