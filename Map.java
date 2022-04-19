import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Map here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Map extends Actor
{
    /**
     * Act - do whatever the Map wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int xsize;
    int ysize;
    int plx;
    int ply;
    int start;
    GreenfootImage map;
    GreenfootImage map1;
    public static int cof;
    public Map(int x, int y,GreenfootImage map2){
        xsize=x;
        ysize=y;
        map=new GreenfootImage(map2);
        map.scale(200,120);
        updateImage();
    }
    public void updateImage(){
        plx=Player.x/10;
        ply=Player.y/10;
        if(plx==map.getWidth()){
            plx--;
        }
        if(ply==map.getHeight()){
            ply--;
        }
        map1=new GreenfootImage(map);
        map1.setColor(Color.RED);
        map1.fillRect(plx*cof,ply*cof,cof,cof);
        setImage(map1);
    }
    public void act() 
    {
        if(start==0){
            setLocation(getWorld().getWidth()-map.getWidth()/2,map.getHeight()/2);
            start=1;
        }
        updateImage();
        // Add your action code here.
    }    
}
