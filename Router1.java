import greenfoot.*;

public class Router1 extends Router{
    public Router1(int type1){
        type = type1;
        radius = 0;
        millisStep = 500;
        for(int i = 0; i < MyWorld.resTypes; i++){
            needRes.add(i + 1);
        }
        fon = new GreenfootImage("transmitter.png");
        cost.add(2);
        cost.add(3);

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
