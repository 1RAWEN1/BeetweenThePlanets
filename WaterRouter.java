import greenfoot.*;

public class WaterRouter extends Router{
    GreenfootImage image = new GreenfootImage("waterRouter.png");
    public WaterRouter(int type1){
        type = type1;
        maxValueOfLiquid = 1;
        needRes.add(0);
        fon = new GreenfootImage("waterRouter.png");
        cost.add(2);
        cost.add(3);
        cost.add(8);
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
        image.clear();
        image.setColor(new Color(195, 195, 195, 255));
        image.fill();
        image.setColor(new Color(0, 0, 255, (int)(80 * ((double)resNum[0] / maxValueOfLiquid))));
        image.fill();
        image.drawImage(fon, 0, 0);
        draw(image);
    }
}
