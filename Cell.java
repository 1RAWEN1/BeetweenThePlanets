import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cell here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cell extends Actor
{
    /**
     * Act - do whatever the Cell wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage myImage;
    StructuresList myStructureList;
    int type;
    int i3;
    public Cell(int type1, StructuresList myStructureList1){
        type=type1;
        myStructureList = myStructureList1;
        updateImage();
    }
    public void act() 
    {
        if(type > 0 && type <= 10 && Greenfoot.mousePressed(this)){
            i3=0;
            for(int i=0;i<5;i++){
                for(int i1=0;i1<3;i1++){
                    try{
                        myStructureList.cells[i][i1].type = 0;
                        myStructureList.cells[i][i1].type = myStructureList.foundStr[type - 1].get(i3);
                        i3++;
                    }catch(Exception e){
                        break;
                    }
                }
            }
        }
        if(Greenfoot.mousePressed(this) && type > 10){
            MyWorld.b.changeType(type);
            MyWorld.b.start = 1;
        }
        updateImage();// Add your action code here.
    }  
    public void updateImage(){
        myImage=new GreenfootImage(30, 30);
        myImage.clear();
        myImage.setColor(Color.BLACK);
        if(type!=0){
            myImage.drawRect(0,0,myImage.getWidth()-1, myImage.getHeight()-1);
            myImage.drawRect(1,1,myImage.getWidth()-3, myImage.getHeight()-3);
        }
        if(type==1){
            myImage=new GreenfootImage("buer.png");
        }
        else if(type==2){
            myImage=new GreenfootImage("gun.png");
        }
        else if(type==3){
            myImage=new GreenfootImage("transport.png");
        }
        else if(type==11){
            GreenfootImage fon=new GreenfootImage("dob1.png");
            GreenfootImage getter=new GreenfootImage("dob11.png");
            myImage.drawImage(fon, myImage.getWidth()/2-fon.getWidth()/2, myImage.getHeight()/2-fon.getHeight()/2);
            myImage.drawImage(getter, myImage.getWidth()/2-getter.getWidth()/2, myImage.getHeight()/2-getter.getHeight()/2);
        }
        else if(type==41){
            GreenfootImage fon=new GreenfootImage("transporter.png");
            fon.scale(20, 20);
            myImage.drawImage(fon, myImage.getWidth()/2-fon.getWidth()/2, myImage.getHeight()/2-fon.getHeight()/2);
        }
        else if(type==42){
            GreenfootImage fon=new GreenfootImage("crossroad.png");
            fon.scale(20, 20);
            myImage.drawImage(fon, myImage.getWidth()/2-fon.getWidth()/2, myImage.getHeight()/2-fon.getHeight()/2);
        }
        setImage(myImage);
    }
}
