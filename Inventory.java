import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Inventory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Inventory extends Actor
{
    /**
     * Act - do whatever the Inventory wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private String value;
    private int fontSize=18;
    private Color lineColor = Color.BLACK;
    private Color fillColor = Color.BLACK;
    
    int x=2;
    int typeres;
    private static final Color transparent = new Color(0,0,0,0);
    GreenfootImage myImage;
    GreenfootImage myImage2=new GreenfootImage(10, 10);
    GreenfootImage myImage3=new GreenfootImage(10, 10);
    GreenfootImage coal=new GreenfootImage("coal.png");
    GreenfootImage iron=new GreenfootImage("iron.png");
    GreenfootImage lead=new GreenfootImage("lead.png");
    GreenfootImage sand=new GreenfootImage("sand.png");
    public Inventory(){
        setNullImage();
    }
    public void updateImage(Structures st){
        myImage=new GreenfootImage(x,fontSize+5);
        myImage.clear();
        x=2;
        for(int i = 0; i<MyWorld.resTypes +1; i++){
            if(st.resNum[i]!=0){
                value=""+st.resNum[i];
                myImage2=new GreenfootImage(value, fontSize, fillColor, transparent, lineColor);
                GreenfootImage myImage1=new GreenfootImage(myImage2);
                myImage2.clear();
                if(myImage2.getWidth()<myImage2.getHeight()){
                    myImage2=new GreenfootImage(myImage2.getHeight(), myImage2.getHeight());
                }
                typeres=i;
                if(typeres==1){
                    coal.scale(myImage2.getHeight(), myImage2.getHeight());
                    myImage2.drawImage(coal, myImage2.getWidth()/2-coal.getWidth()/2, 0);
                }
                else if(typeres==2){
                    iron.scale(myImage2.getHeight(), myImage2.getHeight());
                    myImage2.drawImage(iron, myImage2.getWidth()/2-iron.getWidth()/2, 0);
                }
                else if(typeres==3){
                    lead.scale(myImage2.getHeight(), myImage2.getHeight());
                    myImage2.drawImage(lead, myImage2.getWidth()/2-lead.getWidth()/2, 0);
                }
                else if(typeres==4){
                    sand.scale(myImage2.getHeight(), myImage2.getHeight());
                    myImage2.drawImage(sand, myImage2.getWidth()/2-sand.getWidth()/2, 0);
                }
                myImage2.drawImage(myImage1, myImage2.getWidth()/2-myImage1.getWidth()/2, 0);
                myImage3=new GreenfootImage(myImage2.getWidth()+4, myImage2.getHeight()+4);
                myImage3.clear();
                myImage3.setColor(Color.WHITE);
                myImage3.fill();
                myImage3.setColor(new Color(244, 189, 0 , 255));
                myImage3.drawRect(0,0,myImage3.getWidth()-1, myImage3.getHeight()-1);
                myImage3.drawRect(1,1,myImage3.getWidth()-3, myImage3.getHeight()-3);
                myImage3.drawImage(myImage2,2,2);
                myImage.drawImage(myImage3,x,0);
                x+=myImage3.getWidth();
            }
        }
        setImage(myImage);
        setLocation(getX(),400-myImage.getHeight()/2);
    }
    public void setNullImage(){
        myImage=new GreenfootImage(1,1);
        myImage.clear();
        setImage(myImage);
    }
    public void act() 
    {
        // Add your action code here.
    }    
}
