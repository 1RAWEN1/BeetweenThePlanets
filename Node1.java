import greenfoot.*;

public class Node1 extends Node{
    public Node1(int type1){
        type = type1;
        radius = 200;
        fon = new GreenfootImage("En.png");
        cost.add(2);
        cost.add(20);
        cost.add(3);
        cost.add(20);

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

