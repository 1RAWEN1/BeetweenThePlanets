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
    Structure isClick1;
    public Mouse(){
        updateImage();
    }

    public boolean MousePressed(Actor actor){
        return intersects(actor) && Greenfoot.mousePressed(null);
    }

    public Structure getClickedObject3(){
        MouseInfo mi=Greenfoot.getMouseInfo();
        if(mi!=null && mi.getButton()==1){
            isClick1=(Structure)getOneIntersectingObject(Structure.class);
        }
        else{
            isClick1=null;
        }
        return isClick1;
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

    static boolean mousePressed;

    int startMiX;
    int startMiY;
    int startMiX1;
    int startMiY1;

    int rot;
    public void act() 
    {
        MouseInfo mi = Greenfoot.getMouseInfo();

        if(mi != null) {
            x1 = Player.x + (mi.getX() - 500);
            y1 = Player.y + (mi.getY() - 300);
            x = (((Player.x + (mi.getX() - 500)) / 10) * 10);
            y = (((Player.y + (mi.getY() - 300)) / 10) * 10);

            if(mousePressed) {
                if (Math.abs(y - startMiY) > Math.abs(x - startMiX)) {
                    x = startMiX;
                } else {
                    y = startMiY;
                }

                if (Math.abs(y1 - startMiY1) > Math.abs(x1 - startMiX1)) {
                    x1 = startMiX1;
                } else {
                    y1 = startMiY1;
                }

                if(y1 != startMiY1 || x1 != startMiX1)
                rot = (int) (180 * Math.atan2(y1 - startMiY1, x1 - startMiX1) / Math.PI);
            }
            else{
                rot = -1;
            }

            x = Math.max(0, x);
            y = Math.max(0, y);
            x = Math.min(x, (MyWorld.x1 - 1) * 10);
            y = Math.min(y, (MyWorld.y1 - 1) * 10);

            if (Greenfoot.mousePressed(null) && !isTouching(StructuresList.class)) {
                mousePressed = true;

                startMiX = x;
                startMiY = y;

                startMiX1 = x1;
                startMiY1 = y1;
            } else if (Greenfoot.mouseClicked(null)) {
                mousePressed = false;
            }

            setLocation(mi.getX(), mi.getY());
            //setLocation(800 + ((x / 10) * Map.cof) + (Map.cof / 2)
            //        , ((y / 10) * Map.cof) + (Map.cof / 2));
        }
    }    
}
