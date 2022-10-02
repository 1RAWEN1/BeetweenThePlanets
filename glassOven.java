import greenfoot.*;

public class glassOven extends Plant{
    public glassOven(int type1){
        type = type1;
        millisStep = 500;
        maxResourсes = 10;
        fon = new GreenfootImage("dob1.png");
        cost.add(2);
        cost.add(20);
        cost.add(3);
        cost.add(20);

        timer1 = 2000;
        typeRes = 8;
        needResToCreate.add(4);
        needResToCreate.add(2);

        needRes.add(4);

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
