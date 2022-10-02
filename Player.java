import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public static ArrayList<Integer> myStructures=new ArrayList<Integer>();
    int animation;
    int mx;
    int my;
    int mx1;
    int mx2;
    int my1;
    int my2;
    int rst;
    double g;
    int mspg=2;
    boolean ist;
    int xspeed;
    int yspeed;
    int xspeed1;
    int yspeed1;
    public static int x1;
    public static int y1;
    public static int x;
    public static int y;
    public static boolean setLoc;
    int sx;
    int sy;
    int start;
    int keysdown;
    int rotspeed=10;
    int r;
    int r1;
    double c;
    int animationTimer=10;
    Square sq;
    Block b;
    Structures st;

    static boolean isBusy = false;
    public Player(int x, int y){
        setRotation(270);
        r1=getRotation();
        myStructures.clear();
        myStructures.add(11);
        myStructures.add(41);
        myStructures.add(42);
        myStructures.add(43);
        myStructures.add(56);
        myStructures.add(57);
        myStructures.add(58);
        myStructures.add(71);
        myStructures.add(73);
        myStructures.add(86);
        myStructures.add(87);
        myStructures.add(88);
        myStructures.add(89);
        Player.x = x;
        Player.y = y;
        /*GreenfootImage image=new GreenfootImage(20,20);
        image.setColor(new Color(255, 100, 0, 255));
        image.fillOval(0,0,20,20);
        setImage(image);*/
        /*int a=getImage().getWidth()/2;
        int b=getImage().getHeight()/2;
        c=Math.sqrt(a*a+b*b);
        double cos=Math.acos(a/c);
        r1=(int)(Math.toDegrees(cos));*/
        //sq=new Square(a*2, b*2);
    }
    public void addNewPl(){
        Player pl=new Player(x,y);
        pl.r1=r1;
        getWorld().addObject(pl, getX(),getY());
        pl.setRotation(getRotation());
        getWorld().removeObject(this);
    }
    public void isStr(){
        for(int i=0;i<getObjectsInRange(1000, Structures.class).size();i++){
            st=getObjectsInRange(1000, Structures.class).get(i);
            if(st.building<st.building1 && st.type==1){
                st.building++;
                break;
            }
        }
    }
    public void act() 
    {
        isBusy = false;
        /*if(start==0){
            getWorld().addObject(sq, getX(), getY());
            start=1;
        }*/
        //yspeed=0;
        //xspeed=0;
        r=getRotation();
        if(xspeed>5){
            xspeed=5; 
        }
        else if(xspeed<-5){
            xspeed=-5; 
        }
        if(yspeed>5){
            yspeed=5; 
        }
        else if(yspeed<-5){
            yspeed=-5; 
        }
        if(xspeed>0){
            xspeed--;
        }
        else if(xspeed<0){
            xspeed++;
        }
        if(yspeed>0){
            yspeed--;
        }
        else if(yspeed<0){
            yspeed++;
        }
        x1=getX();
        y1=getY();
        sx=x;
        sy=y;
        //if(isTouchBlock()==false){
        keysdown=0;
        if(Greenfoot.isKeyDown("W")){
            yspeed-=5;
            //g=0;
            r1=270;
            keysdown++;
        }
        if(Greenfoot.isKeyDown("S")){
            yspeed+=5;
            if(keysdown>0){
                r1+=90;
            }
            else{
                r1=90;
            }
            keysdown++;
        }
        if(Greenfoot.isKeyDown("A")){
            xspeed-=5;
            if(keysdown>0){
                r1+=180;
            }
            else{
                r1=180;
            }
            keysdown++;
        }
        if(Greenfoot.isKeyDown("D")){
            xspeed+=5;
            if(keysdown>0 && Greenfoot.isKeyDown("S")){
                r1+=0;
            }
            else if(keysdown>0 && Greenfoot.isKeyDown("W")){
                r1+=360;
            }
            else{
                r1=0;
            }
            keysdown++;
        }
        if(keysdown>0){
            r1=r1/keysdown;
        }
        if(r1>r){
            if(r1-r<=180){
                if(r1-r>=rotspeed){
                    r+=rotspeed;
                }
                else if(r1-r<rotspeed){
                    r+=r1-r;
                }
            }
            else if(r1-r>180){
                r-=rotspeed;
            }
        }
        else if(r1<r){
            if(r-r1<=180){
                if(r-r1>=rotspeed){
                    r-=rotspeed;
                }
                else if(r-r1<rotspeed){
                    r-=r-r1;
                }
            }
            else if(r-r1>180){
                r+=rotspeed;
            }
        }
        setRotation(r);
        //}
        x=x+xspeed;
        if(x<0){
            x=0;
        }
        else if(x>MyWorld.x1*10){
            x=MyWorld.x1*10;
        }
        /*if(isTouching(Block.class) && xspeed!=0){
            if(isTouchBlock()){
                while(isTouchBlock()){
                    tObsX();
                }
                if(yspeed<0){
                    y-=yspeed;
                }
                if(yspeed>0){
                    y-=yspeed;
                }
                if(xspeed<0){
                    x-=xspeed;
                }
                if(xspeed>0){
                    x-=xspeed;
                }
            }
        }*/
        y=y+yspeed;
        if(y<0){
            y=0;
        }
        else if(y>MyWorld.y1*10){
            y=MyWorld.y1*10;
        }
        setLocation(500,300);
        setLoc = sy != y || sx != x;
        if(start==0){
            setLoc=true;
            start=1;
        }
        //isStr();
        /*if(isTouching(Block.class)){
            if(isTouchBlock()){
                while(isTouchBlock()){
                    tObsY();
                }
                if(yspeed<0){
                    y-=yspeed;
                }
                if(yspeed>0){
                    y-=yspeed;
                }
                if(xspeed<0){
                    x-=xspeed;
                }
                if(xspeed>0){
                    x-=xspeed;
                }
            }
        }*/
        //sq.setLocation(getX(), getY());
        //upSquare();
        //fall();
        //setLocation(sx,sy);
        /*if(x+xspeed>(MyWorld.x1-1)*20 && xspeed>0){
            xspeed=(MyWorld.x1-1)*20-x;
        }
        if(x+xspeed<0 && xspeed<0){
            xspeed=-x;
        }
        if(y+yspeed>(MyWorld.y1-1)*20 && yspeed>0){
            yspeed=(MyWorld.y1-1)*20-y;
        }
        if(y+yspeed<0 && yspeed<0){
            yspeed=-y;
        }
        if(xspeed!=0){
            x=x+xspeed;
        }
        if(yspeed!=0){
            y=y+yspeed;
        }
        if((Player.x-getWorld().getWidth()/2)/20<0){
            setLocation(x,getY());
        }
        if(((Player.x-getWorld().getWidth()/2)/20)+(getWorld().getWidth()/20)>=MyWorld.x1){
            setLocation((x%getWorld().getWidth())+(getWorld().getWidth()/2),getY());
        }
        if((Player.y-getWorld().getHeight()/2)/20<0){
            setLocation(getX(),y);
        }
        if(((Player.y-getWorld().getHeight()/2)/20)+(getWorld().getHeight()/20)>=MyWorld.y1){
            setLocation(getX(),(y%getWorld().getHeight())+(getWorld().getHeight()/2));
        }*/
        /*if(Greenfoot.isKeyDown("W") && MyWorld.yn1!=12 && getY()==getWorld().getHeight()/2){
            movey=2;
        }
        else if(Greenfoot.isKeyDown("W") && MyWorld.yn1==12 && MyWorld.ys1!=getWorld().getHeight()-12 && Block.mvyn==0){
            setLocation(getX(), getY()-2);
        }
        else if(Greenfoot.isKeyDown("W") && MyWorld.yn1!=12){
            setLocation(getX(), getY()-2);
            if(MyWorld.ys1==getWorld().getHeight()-12 && getY()<getWorld().getHeight()/2){
                setLocation(getX(), getWorld().getHeight()/2);
            }
        }
        if(Greenfoot.isKeyDown("S") && MyWorld.ys1!=getWorld().getHeight()-12 && getY()==getWorld().getHeight()/2){
            movey=-2;
        }
        else if(Greenfoot.isKeyDown("S") && MyWorld.ys1==getWorld().getHeight()-12 && MyWorld.yn1!=12 && Block.mvys==MyWorld.y1-1){
            setLocation(getX(), getY()+2);
        }
        else if(Greenfoot.isKeyDown("S") && MyWorld.ys1!=getWorld().getHeight()-12){
            setLocation(getX(), getY()+2);
            if(MyWorld.yn1==12 && getY()>getWorld().getHeight()/2){
                setLocation(getX(), getWorld().getHeight()/2);
            }
        }
        if(Greenfoot.isKeyDown("A") && MyWorld.xv1!=12 && getX()==getWorld().getWidth()/2){
            movex+=2;
        }
        else if(Greenfoot.isKeyDown("A") && MyWorld.xv1==12 && Block.mvxv==0){
            setLocation(getX()-2, getY());
        }
        else if(Greenfoot.isKeyDown("A") && MyWorld.xv1!=12){
            setLocation(getX()-2, getY());
            if(MyWorld.xv1==getWorld().getWidth()-12 && getX()<getWorld().getWidth()/2){
                setLocation(getWorld().getWidth()/2, getY());
            }
        }
        if(Greenfoot.isKeyDown("D") && MyWorld.xe1!=getWorld().getWidth()-12 && getX()==getWorld().getWidth()/2){
            movex+=-2;
        }
        else if(Greenfoot.isKeyDown("D") && MyWorld.xe1==getWorld().getWidth()-12 && Block.mvxe==MyWorld.x1-1){
            setLocation(getX()+2, getY());
        }
        else if(Greenfoot.isKeyDown("D") && MyWorld.xe1!=getWorld().getWidth()-12){
            setLocation(getX()+2, getY());
            if(MyWorld.xv1==12 && getX()>getWorld().getWidth()/2){
                setLocation(getWorld().getWidth()/2, getY());
            }
        }*/
        animation++;
        animation();
    }  
    public boolean isTouchBlock(){
        ist=false;
        for(int i=0;i<getIntersectingObjects(Block.class).size();i++){
            if(getIntersectingObjects(Block.class).get(i).type>=2){
                b=getIntersectingObjects(Block.class).get(i);
                ist=true;
            }
        }
        return ist;
    }
    public void animation(){
        if(animation==animationTimer){
            setImage("Player2.png");
        }
        else if(animation==animationTimer*2){
            animation=0;
            setImage("Player1.png");
        }
    }
    /*public void upSquare(){
        sq.setWH(ygx2-ygx1, ygy2-ygy1);
        //x+=sq.getMX();
        //y+=sq.getMY();
    }*/
    public void fall(){
        if(isTouchBlock()==false){
            setLocation(getX(),getY()+1);
            if((int)(g)<mspg && isTouchBlock()==false){
                g+=0.1;
            }
            else if(isTouchBlock()){
                g=0;
            }
            setLocation(getX(),getY()-1);
            yspeed+=(int)(g);
        }
    }
    public void moveX(int speed1){
        setLocation(getX()+speed1, getY());
        if(speed1!=0){
            xspeed1=speed1;
        }
        /*if(isTouching(Block.class) && speed1!=0){
            if(isTouchBlock()){
                while(isTouchBlock()){
                    tObsX();
                }
            }
        }*/
    }
    public void tObsX(){
        mx=getX()-b.getX();
        /*mx1=Math.abs(mx)-(b.getImage().getWidth()/2);
        mx2=Math.abs(mx)-(getImage().getWidth()/2);
        my1=Math.abs(my)-(b.getImage().getHeight()/2);
        my2=Math.abs(my)-(getImage().getHeight()/2);
        System.out.println(yspeed+" "+my+" "+(my1+my2));
        if(mx<0){
            mx=-(Math.abs(mx)-(mx1+mx2));
        }
        else{
            mx=Math.abs(mx)-(mx1+mx2);
        }
        if(my<0){
            my=-(Math.abs(my)-(my1+my2));
        }
        else{
            my=Math.abs(my)-(my1+my2);
        }*/
        if(xspeed1>=0){
            mx=-(((getImage().getWidth()/2)+(b.getImage().getWidth()/2))-Math.abs(mx));
        }
        else{
            mx=(((getImage().getWidth()/2)+(b.getImage().getWidth()/2))-Math.abs(mx));
        }
        if(Math.abs(mx)>Math.abs(xspeed1)+1){
            mx=0;
        }
        //System.out.println(mx+" "+my);
        /*if(Math.abs(mx)<Math.abs(my) && xspeed!=0){
            my=0;
        }
        else if(Math.abs(mx)>Math.abs(my) && yspeed!=0){
            mx=0;
        }*/
        if(mx<0 && xspeed1<0 || mx>0 && xspeed1>0){
            mx=-mx;
        }
        x+=mx;
        setLocation(getX()+mx,getY());
    }
    public void moveY(int speed1){
        setLocation(getX(), getY()+speed1);
        if(speed1!=0){
            yspeed1=speed1;
        }
        /*if(isTouching(Block.class) && speed1!=0){
            if(isTouchBlock()){
                while(isTouchBlock()){
                    tObsY();
                }
            }
        }*/
    }
    public void tObsY(){
        my=getY()-b.getY();
        /*mx1=Math.abs(mx)-(b.getImage().getWidth()/2);
        mx2=Math.abs(mx)-(getImage().getWidth()/2);
        my1=Math.abs(my)-(b.getImage().getHeight()/2);
        my2=Math.abs(my)-(getImage().getHeight()/2);
        System.out.println(yspeed+" "+my+" "+(my1+my2));
        if(mx<0){
            mx=-(Math.abs(mx)-(mx1+mx2));
        }
        else{
            mx=Math.abs(mx)-(mx1+mx2);
        }
        if(my<0){
            my=-(Math.abs(my)-(my1+my2));
        }
        else{
            my=Math.abs(my)-(my1+my2);
        }*/
        if(yspeed1>=0){
            my=-(((getImage().getHeight()/2)+(b.getImage().getHeight()/2))-Math.abs(my));
        }
        else{
            my=(((getImage().getHeight()/2)+(b.getImage().getHeight()/2))-Math.abs(my));
        }
        if(Math.abs(my)>Math.abs(yspeed1)+1 && yspeed1!=0){
            my=0;
        }
        //System.out.println(mx+" "+my);
        /*if(Math.abs(mx)<Math.abs(my) && xspeed!=0){
            my=0;
        }
        else if(Math.abs(mx)>Math.abs(my) && yspeed!=0){
            mx=0;
        }*/
        if(my<0 && yspeed1<0 || my>0 && yspeed1>0){
            my=-my;
        }
        y+=my;
        setLocation(getX(),getY()+my);
    }
}
