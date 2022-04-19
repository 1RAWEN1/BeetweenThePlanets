import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Block here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Block extends Actor
{
    /**
     * Act - do whatever the Block wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    /*public static int mvyn;
    public static int mvys;
    public static int mvxv;
    public static int mvxe;
    public static int yn;
    public static int ys;
    public static int xv;
    public static int xe;*/
    int xpos;
    int ypos;
    int xpos1;
    int ypos1;
    int x;
    int y;
    int type;
    int xposm;
    int yposm;
    int myxpos;
    int myypos;
    int myxpos1;
    int myypos1;
    int myxpos2;
    int myypos2;
    int r;
    int r1;
    int cansee;
    GreenfootImage image;
    public Block(int x1, int y1, int type1){
        xpos=x1;
        ypos=y1;
        type=type1;
        updateImage();
    }
    public void updateImage(){
        myxpos1=myxpos-1;
        myypos1=myypos-1;
        myxpos2=myxpos+1;
        myypos2=myypos+1;
        if(myxpos1<0){
            myxpos1=0;
        }
        if(myxpos2>MyWorld.x1-1){
            myxpos2=MyWorld.x1-1;
        }
        if(myypos1<0){
            myypos1=0;
        }
        if(myypos2>MyWorld.y1-1){
            myypos2=MyWorld.y1-1;
        }
        r=getRotation();
        turnTowards(Player.x1, Player.y1);
        r1=getRotation();
        setRotation(r);
        cansee=0;
        if(MyWorld.myWorld[myxpos1][myypos]<2 
        || MyWorld.myWorld[myxpos2][myypos]<2
        || MyWorld.myWorld[myxpos][myypos1]<2
        || MyWorld.myWorld[myxpos][myypos2]<2/*r1<=225 && r1>135*/){
            cansee=1;
        }
        /*if(MyWorld.myWorld[myxpos2][myypos]!=2 && r1<=45 || MyWorld.myWorld[myxpos2][myypos]!=2 && r1>315){
            cansee=1;
        }
        if(MyWorld.myWorld[myxpos][myypos1]!=2 && r1>225 && r1<=315){
            cansee=1;
        }
        if(MyWorld.myWorld[myxpos][myypos2]!=2 && r1>45 && r1<=135){
            cansee=1;
        }*/
        if(cansee==1){
            if(type==1){
                image=new GreenfootImage(20,20);
                image.setColor(new Color(0, 0, 150, 150));
                image.fillRect(0,0,20,20);
                setImage(image);
            }
            else if(type==2){
                image=new GreenfootImage(20,20);
                image.setColor(new Color(200, 150, 0, 255));
                image.fillRect(0,0,20,20);
                setImage(image);
            }
            else if(type==-1){
                image=new GreenfootImage(20,20);
                image.setColor(new Color(200, 0, 100, 255));
                image.fillRect(0,0,20,20);
                setImage(image);
            }
        }
        else if(cansee==0){
            image=new GreenfootImage(20,20);
            image.setColor(new Color(0, 0, 0, 230));
            image.fillRect(0,0,20,20);
            setImage(image);
        }
    }
    public void act() 
    {
        /*if(MyWorld.z==1){
            yn=getWorld().getHeight();
            ys=0;
            xv=getWorld().getWidth();
            xe=0;
            MyWorld.z=0;
        }*/
        //setLocation(getX()+Player.movex, getY()+Player.movey);
        x=getX();
        y=getY();
        try{
            if((Player.x-getWorld().getWidth()/2)/20>=0 && ((Player.x-getWorld().getWidth()/2)/20)+(getWorld().getWidth()/20)<MyWorld.x1){
                setLocationX();
            }
            else if((Player.x-getWorld().getWidth()/2)/20<0){
                setXMaks(0);
            }
            else if(((Player.x-getWorld().getWidth()/2)/20)+(getWorld().getWidth()/20)>=MyWorld.x1){
                setXMaks(1);
            }
            if((Player.y-getWorld().getHeight()/2)/20>=0 && ((Player.y-getWorld().getHeight()/2)/20)+(getWorld().getHeight()/20)<MyWorld.y1){
                setLocationY();
            }
            else if((Player.y-getWorld().getHeight()/2)/20<0){
                setYMaks(0);
            }
            else if(((Player.y-getWorld().getHeight()/2)/20)+(getWorld().getHeight()/20)>=MyWorld.y1){
                setYMaks(1);
            }
            myxpos=xpos1;
            myypos=ypos1;
            updateImage();
        }catch(Exception e){System.out.println(e);}
        fall();
        /*if(y-image.getHeight()/2<yn){
            yn=y-image.getHeight()/2; 
            mvyn=ypos;
        }
        if(y+image.getHeight()/2>ys){
            ys=y+image.getHeight()/2; 
            mvys=ypos;
        }
        if(x-image.getWidth()/2<xv){
            xv=x-image.getWidth()/2; 
            mvxv=xpos;
        }
        if(x+image.getWidth()/2>xe){
            xe=x+image.getWidth()/2;   
            mvxe=xpos;
        }
        if(isAtEdge()){
            getWorld().removeObject(this);
        }// Add your action code here.*/
    }   
    public void setXMaks(int i){
        yposm=((Player.y-(getWorld().getHeight()/2))/20);
        if(yposm<0){
            yposm=0;
        }
        else if((Player.y+(getWorld().getHeight()/2))/20>MyWorld.y1-1){
            yposm=((MyWorld.y1-1)-(getWorld().getHeight()/20));
        }
        if(i==0){
            type=MyWorld.myWorld[xpos][yposm+ypos];
            xpos1=xpos;
            setLocation((xpos*20)+10,getY());
        }
        else if(i==1){
            type=MyWorld.myWorld[(MyWorld.x1)-1-(getWorld().getWidth()/20-xpos)][yposm+ypos];
            xpos1=(MyWorld.x1)-1-(getWorld().getWidth()/20-xpos);
            setLocation((xpos*20)+10,getY());
        }
    }
    public void setYMaks(int i1){
        xposm=(Player.x-(getWorld().getWidth()/2))/20;
        if(xposm<0){
            xposm=0;
        }
        else if((Player.x+(getWorld().getWidth()/2))/20>MyWorld.x1-1){
            xposm=((MyWorld.x1-1)-(getWorld().getWidth()/20));
        }
        if(i1==0){
            type=MyWorld.myWorld[xposm+xpos][ypos];
            ypos1=ypos;
            setLocation(getX(),(ypos*20)+10);
        }
        else if(i1==1){
            type=MyWorld.myWorld[xposm+xpos][(MyWorld.y1)-1-(getWorld().getHeight()/20-ypos)];
            ypos1=(MyWorld.y1)-1-(getWorld().getHeight()/20-ypos);
            setLocation(getX(),(ypos*20)+10);
        }
    }
    public void setLocationX(){
        type=MyWorld.myWorld[((Player.x-(getWorld().getWidth()/2))/20)+xpos][ypos1];
        xpos1=((Player.x-(getWorld().getWidth()/2))/20)+xpos;
        setLocation(-(Player.x-(getWorld().getWidth()/2))%20+(xpos*20)+10,getY());
    }
    public void setLocationY(){
        type=MyWorld.myWorld[xpos1][((Player.y-(getWorld().getHeight()/2))/20)+ypos];
        ypos1=((Player.y-(getWorld().getHeight()/2))/20)+ypos;
        setLocation(getX(),-(Player.y-(getWorld().getHeight()/2))%20+(ypos*20)+10);
    }
    public void fall(){
        myxpos1=myxpos-1;
        myypos1=myypos-1;
        myxpos2=myxpos+1;
        myypos2=myypos+1;
        if(myxpos1<0){
            myxpos1=0;
        }
        if(myxpos2>MyWorld.x1-1){
            myxpos2=MyWorld.x1-1;
        }
        if(myypos1<0){
            myypos1=0;
        }
        if(myypos2>MyWorld.y1-1){
            myypos2=MyWorld.y1-1;
        }
        if(type==2 
        && MyWorld.myWorld[myxpos][myypos1]<2 
        && MyWorld.myWorld[myxpos][myypos2]<2 
        && MyWorld.myWorld[myxpos2][myypos]<2
        && MyWorld.myWorld[myxpos2][myypos]<2){
            MyWorld.myWorld[myxpos][myypos]=1;
            MyWorld.myWorld[myxpos][myypos2]=type;
        }
    }
}
