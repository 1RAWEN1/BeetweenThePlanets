import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class WaterTransporter extends Transmitter
{
    GreenfootImage image = new GreenfootImage("waterTransporter.png");
    public WaterTransporter(int type1){
        type = type1;
        maxValueOfLiquid = 6;
        needRes.add(0);
        fon = new GreenfootImage("waterTransporter.png");
        cost.add(2);
        cost.add(1);
        cost.add(8);
        cost.add(1);

        updateStructureLocation();
    }

    public void act()
    {
        updateThisImage();
        doMainActions();
        //updateMyImage();// Add your action code here.
    }

    public void updateThisImage(){
        //if(type == 0 || type == 1 && !isBuilt()) {
            image.clear();
            image.setColor(new Color(195, 195, 195, 255));
            image.fill();
            image.setColor(new Color(0, 0, 255, (int)(80 * ((double)resNum[0] / maxValueOfLiquid))));
            image.fill();
            image.drawImage(fon, 0, 0);
            image.rotate(rot);
        //}
        draw(image);
    }
}
