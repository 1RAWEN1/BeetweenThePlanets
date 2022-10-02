import greenfoot.*;

public class WaterCrossroad extends Crossroad{
    GreenfootImage image = new GreenfootImage("waterCrossroad.png");
    public WaterCrossroad(int type1){
        type = type1;
        maxValueOfLiquid = 1;
        needRes.add(0);
        fon = new GreenfootImage("waterCrossroad.png");
        cost.add(2);
        cost.add(2);
        cost.add(8);
        cost.add(2);

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
