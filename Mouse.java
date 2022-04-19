import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mouse here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mouse extends Actor
{
    /**
     * Act - do whatever the Mouse wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage fon;
    public void updateImage(){
        fon=new GreenfootImage(Map.cof,Map.cof);
        setImage(fon);
    }
    int x;
    int y;
    int x1;
    int y1;
    Structures isClick;
    public Mouse(){
        updateImage();
    }
    public Structures getClickedObject(){
        MouseInfo mi=Greenfoot.getMouseInfo();
        if(mi!=null && mi.getButton()==1){
            isClick=(Structures)getOneIntersectingObject(Structures.class);
        }
        else{
            isClick=null;
        }
        return isClick;
    }
    public Structures getClickedObject2(){
        MouseInfo mi=Greenfoot.getMouseInfo();
        if(mi!=null && mi.getButton()==3){
            isClick=(Structures)getOneIntersectingObject(Structures.class);
        }
        else{
            isClick=null;
        }
        return isClick;
    }

    boolean start;

    static boolean mousePressed;

    MouseHelper myMouseHelper;
    public void act() 
    {
        if(!start){
            myMouseHelper = new MouseHelper();
            getWorld().addObject(myMouseHelper, 0 ,0);

            start = true;
        }

        MouseInfo mi = Greenfoot.getMouseInfo();

        if(mi != null) {
            myMouseHelper.setLocation(mi.getX(), mi.getY());

            if (Greenfoot.mousePressed(null) && !myMouseHelper.touchStructuresList()) {
                mousePressed = true;
            } else if (Greenfoot.mouseClicked(null)) {
                mousePressed = false;
            }

            x1 = Player.x + (mi.getX() - 500);
            y1 = Player.y + (mi.getY() - 300);
            x = (((Player.x + (mi.getX() - 500)) / 10) * 10);
            y = (((Player.y + (mi.getY() - 300)) / 10) * 10);
            setLocation(800 + ((x / 10) * Map.cof) + (Map.cof / 2)
                    , ((y / 10) * Map.cof) + (Map.cof / 2));
        }
    }    
}
