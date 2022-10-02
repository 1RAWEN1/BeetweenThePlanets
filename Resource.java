import greenfoot.*;

public class Resource extends Actor{

    int type;
    public Resource(int type, int x, int y){
        this.x = x;
        this.y = y;

        if(type == 2){
            setImage("coal.png");
            type = 1;
        }
        else if(type == 3){
            setImage("iron.png");
            type = 2;
        }
        else if(type == 5){
            setImage("lead.png");
            type = 3;
        }
        else if(type == 6){
            updateImage();
            type = 0;
        }
        else if(type == 8){
            setImage("sand.png");
            type = 4;
        }
        else if(type == 9){
            setImage("silica.png");
            type = 6;
        }

        this.type = type;
    }

    GreenfootImage myImage;
    int col;
    int x1;
    int y1;
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
    }

    int x;
    int y;

    public void updateLocation(){
        setLocation((getWorld().getWidth() / 2) + x - Player.x, (getWorld().getHeight() / 2) + y - Player.y);
    }

    public int getType(){
        return type;
    }
    public void act()
    {
        if(type == 0){
            updateImage();
        }
        updateLocation();// Add your action code here.
    }
}
