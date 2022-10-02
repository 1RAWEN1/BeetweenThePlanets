import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Water here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Water extends Actor
{
    /**
     * Act - do whatever the Water wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage myImage;
    int col;
    int x1;
    int y1;
    int x;
    int y;
    int start;
    public Water(int x, int y){
        updateImage();
        this.x=x;
        this.y=y;
    }
    public void updateImage(){
        myImage=new GreenfootImage(10, 10);
        myImage.drawImage(new GreenfootImage("fon.png"),0,0);
        myImage.setColor(new Color(0, 0, 255, 80));
        myImage.fillRect(0,0,myImage.getWidth(),myImage.getHeight());
        col=Greenfoot.getRandomNumber(3);
        myImage.setColor(new Color(255, 255, 255, 100));
        for(int i=0;i<col;i++){
            x1=Greenfoot.getRandomNumber(10);
            y1=Greenfoot.getRandomNumber(10);
            myImage.fillRect(x1, y1, 1, 1);
        }
        setImage(myImage);
        //MyWorld.myImage.drawImage(myImage,(x-myImage.getWidth()/2),(y-myImage.getHeight()/2));
    }

    public void updateLocation(){
        setLocation((getWorld().getWidth() / 2) + x - Player.x, (getWorld().getHeight() / 2) + y - Player.y);
    }

    public void act() 
    {
        if(start==0){
            GreenfootImage image=new GreenfootImage(Map.cof,Map.cof);
            image.setColor(new Color(0, 0, 255, 80));
            image.fill();
            setImage(image);
            start=1;
        }
        updateLocation();
        updateImage();// Add your action code here.
    }       
}
