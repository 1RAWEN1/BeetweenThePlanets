import greenfoot.*;

public class Crossroad1 extends Crossroad{
    public Crossroad1(int type1){
        type = type1;
        radius = 0;
        millisStep = 500;
        for(int i = 0; i < MyWorld.resTypes; i++){
            needRes.add(i);
        }
        fon = new GreenfootImage("crossroad.png");
        cost.add(2);
        cost.add(2);
    }

    public void act()
    {
        doMainActions();
        updateThisImage();
        updateMyImage();// Add your action code here.
    }

    public void updateThisImage(){
        draw(fon);
    }
}
