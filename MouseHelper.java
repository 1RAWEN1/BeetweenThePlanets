import greenfoot.*;

public class MouseHelper extends Actor{

    public MouseHelper(){
        updateImage();
    }
    public void updateImage(){
        GreenfootImage image = new GreenfootImage(1, 1);
        setImage(image);
    }

    public boolean touchStructuresList(){
        return isTouching(StructuresList.class);
    }

    public void act(){

    }
}
