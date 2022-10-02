import greenfoot.*;

public class GraphiteFactory extends Plant{
    public GraphiteFactory(int type1){
        type = type1;
        radius = 0;
        millisStep = 500;
        maxResourсes = 10;
        fon = new GreenfootImage("Press.png");
        cost.add(2);
        cost.add(20);
        cost.add(3);
        cost.add(20);

        timer1 = 2000;
        typeRes = 5;
        needResToCreate.add(1);
        needResToCreate.add(2);

        needRes.add(1);

        needEnergy = 30;

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
