import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Square here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Square extends Actor
{
    /**
     * Act - do whatever the Square wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    double c;
    int ygx;
    int ygy;
    int ygx1;
    int ygy1;
    int ygx2;
    int ygy2;
    int rst;
    int r1;
    int x1;
    int x2;
    int y1;
    int y2;
    int x;
    int y;
    Block b;
    int mx;
    int my;
    boolean ist;
    public Square(int x, int y){
        GreenfootImage image=new GreenfootImage(x,y);
        image.drawRect(0,0,x-1,y-1);
        setImage(image);
    }
    public void updateImage(Actor ob){
        rst=getRotation();
        int a=ob.getImage().getWidth()/2;
        int b=ob.getImage().getHeight()/2;
        c=Math.sqrt(a*a+b*b);
        double cos=Math.acos(a/c);
        r1=(int)(Math.toDegrees(cos));
        for(int i=0;i<4;i++){
            if(i==0){
                turn(r1);
                ygx=getX()+(int)(c*Math.cos(Math.toRadians(getRotation())));
                ygy=getY()+(int)(c*Math.sin(Math.toRadians(getRotation())));
                ygx1=ygx;
                ygy1=ygy;
                ygx2=ygx;
                ygy2=ygy;
                setRotation(rst);
            }
            else if(i==1){
                turn(-r1);
                ygx=getX()+(int)(c*Math.cos(Math.toRadians(getRotation())));
                ygy=getY()+(int)(c*Math.sin(Math.toRadians(getRotation())));
                if(ygx<ygx1){
                    ygx1=ygx;
                }
                if(ygx>ygx2){
                    ygx2=ygx;
                }
                if(ygy<ygy1){
                    ygy1=ygy;
                }
                if(ygy>ygy2){
                    ygy2=ygy;
                }
                setRotation(rst);
            }
            else if(i==2){
                turn((180-r1));
                ygx=getX()+(int)(c*Math.cos(Math.toRadians(getRotation())));
                ygy=getY()+(int)(c*Math.sin(Math.toRadians(getRotation())));
                if(ygx<ygx1){
                    ygx1=ygx;
                }
                if(ygx>ygx2){
                    ygx2=ygx;
                }
                if(ygy<ygy1){
                    ygy1=ygy;
                }
                if(ygy>ygy2){
                    ygy2=ygy;
                }
                setRotation(rst);
            }
            else if(i==3){
                turn(-(180-r1));
                ygx=getX()+(int)(c*Math.cos(Math.toRadians(getRotation())));
                ygy=getY()+(int)(c*Math.sin(Math.toRadians(getRotation())));
                if(ygx<ygx1){
                    ygx1=ygx;
                }
                if(ygx>ygx2){
                    ygx2=ygx;
                }
                if(ygy<ygy1){
                    ygy1=ygy;
                }
                if(ygy>ygy2){
                    ygy2=ygy;
                }
                setRotation(rst);
            }
        }
        setWH(ygx2-ygx1, ygy2-ygy1);
    }
    public void setWH(int x1, int y1){
        GreenfootImage image=new GreenfootImage(x1,y1);
        setImage(image);
    }
    public boolean isTouchBlock(){
        ist=false;
        b=null;
        for(int i=0;i<getIntersectingObjects(Block.class).size();i++){
            if(getIntersectingObjects(Block.class).get(i).type>=2){
                b=getIntersectingObjects(Block.class).get(i);
                ist=true;
            }
        }
        return ist;
    }
    public int getMX(int xspeed1){
        mx=0;
        if(isTouchBlock()){
            mx=getX()-b.getX();
            if(xspeed1>=0){
                mx=-(((getImage().getWidth()/2)+(b.getImage().getWidth()/2))-Math.abs(mx));
            }
            else{
                mx=(((getImage().getWidth()/2)+(b.getImage().getWidth()/2))-Math.abs(mx));
            }
            if(Math.abs(mx)>Math.abs(xspeed1)+1){
                mx=0;
            }
            if(mx<0 && xspeed1<0 || mx>0 && xspeed1>0){
                mx=-mx;
            }
        }
        return mx;
    }
    public int getMY(int yspeed1){
        my=0;
        my=getY()-b.getY();
        if(yspeed1>=0){
            my=-(((getImage().getHeight()/2)+(b.getImage().getHeight()/2))-Math.abs(my));
        }
        else{
            my=(((getImage().getHeight()/2)+(b.getImage().getHeight()/2))-Math.abs(my));
        }
        if(Math.abs(my)>Math.abs(yspeed1)+1 && yspeed1!=0){
            my=0;
        }
        if(my<0 && yspeed1<0 || my>0 && yspeed1>0){
            my=-my;
        }
        return my;
    }
    public void act() 
    {
        // Add your action code here.
    }    
}
