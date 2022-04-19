import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    /*public static int yn1;
    public static int ys1;
    public static int xv1;
    public static int xe1;
    public static int z;*/
    public static Inventory i;
    public static Mouse mi;
    
    public static Builder b=new Builder();
    public static GreenfootImage myImage;
    GreenfootImage myImage1;
    public static GreenfootImage worldImage=new GreenfootImage(1000, 600);
    public static GreenfootImage connectionImage=new GreenfootImage(1000, 600);
    GreenfootImage fon=new GreenfootImage("fon.png");
    GreenfootImage fon1=new GreenfootImage("earth.png");
    GreenfootImage fon2=new GreenfootImage("earth2.png");
    GreenfootImage map;
    GreenfootImage coal=new GreenfootImage("coal.png");
    GreenfootImage iron=new GreenfootImage("iron.png");
    GreenfootImage lead=new GreenfootImage("lead.png");
    GreenfootImage mountain=new GreenfootImage("mountain.png");
    GreenfootImage sand=new GreenfootImage("sand.png");
    int spawnCoal;
    int spawnIron;
    int spawnLead;
    int spawnMountain;
    int x;
    int y;
    int x2;
    int y2;
    int addBaze;
    int i1;
    int i2;
    int waterX;
    int waterY;
    int radius;
    double radius1;
    public static boolean haveSelectedObject;
    static Structures st;
    public static int x1;
    public static int y1;
    public static int resTypes =4;
    public static int [][] myWorld;
    int g1;
    int dosh;
    int [][] glowing;
    int i3;
    //1 - fon
    //2 - coal
    //3 - iron
    //4 - mountain
    //5 - lead
    //6 - small water
    //7 - big water
    //8 - sand
    public static int blockx;
    public static Baza myBaza;

    public static int transmitterRot;
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1);
        x1=200;
        y1=120;
        Map.cof=200/x1;
        Map.cof=120/y1;
        myWorld=new int[x1][y1];
        map=new GreenfootImage(x1,y1);
        map.setColor(new Color(255,255,255,100));
        map.fill();
        //glowing=new int[x1][y1];
        waterX =Greenfoot.getRandomNumber(x1) * 10;
        waterY =Greenfoot.getRandomNumber(y1) * 10;
        radius=Greenfoot.getRandomNumber(30)+41;
        haveSelectedObject = false;

        setPaintOrder(Cell.class, StructuresList.class, Map.class, Builder.class, Structures.class, helpObject.class);
        summonWorld();
    } 
    public void summonWorld(){
        for(int i=0;i<x1;i++){
            for(int i1=0;i1<y1;i1++){
                myWorld[i][i1]=1;
                spawnCoal =Greenfoot.getRandomNumber(451);
                if(i-1>=0 && i1-1>=0 && myWorld[i-1][i1-1]==2){
                    spawnCoal +=50;
                }
                if(i1-1>=0 && myWorld[i][i1-1]==2){
                    spawnCoal +=50;
                }
                if(i-1>=0 && myWorld[i-1][i1]==2){
                    spawnCoal +=50;
                }
                if(i1-1>=0 && i+1<x1 && myWorld[i+1][i1-1]==2){
                    spawnCoal +=50;
                }
                if(spawnCoal >=450){
                    myWorld[i][i1]=2;
                }
                spawnIron =Greenfoot.getRandomNumber(501);
                if(i-1>=0 && i1-1>=0 && myWorld[i-1][i1-1]==3){
                    spawnIron +=100;
                }
                if(i1-1>=0 && myWorld[i][i1-1]==3){
                    spawnIron +=100;
                }
                if(i-1>=0 && myWorld[i-1][i1]==3){
                    spawnIron +=100;
                }
                if(i1-1>=0 && i+1<x1 && myWorld[i+1][i1-1]==3){
                    spawnIron +=100;
                }
                if(spawnIron >=500){
                    myWorld[i][i1]=3;
                }
                spawnLead =Greenfoot.getRandomNumber(501);
                if(i-1>=0 && i1-1>=0 && myWorld[i-1][i1-1]==5){
                    spawnLead +=100;
                }
                if(i1-1>=0 && myWorld[i][i1-1]==5){
                    spawnLead +=100;
                }
                if(i-1>=0 && myWorld[i-1][i1]==5){
                    spawnLead +=100;
                }
                if(i1-1>=0 && i+1<x1 && myWorld[i+1][i1-1]==5){
                    spawnLead +=100;
                }
                if(spawnLead >=500){
                    myWorld[i][i1]=5;
                }
                spawnMountain =Greenfoot.getRandomNumber(301);
                if(i-1>=0 && i1-1>=0 && myWorld[i-1][i1-1]==4){
                    spawnMountain +=70;
                }
                if(i1-1>=0 && myWorld[i][i1-1]==4){
                    spawnMountain +=70;
                }
                if(i-1>=0 && myWorld[i-1][i1]==4){
                    spawnMountain +=70;
                }
                if(i1-1>=0 && i+1<x1 && myWorld[i+1][i1-1]==4){
                    spawnMountain +=70;
                }
                /*if(i+1<x1 && myWorld[i+1][i1]==4){
                    spawnmountain+=70; 
                }
                if(i1+1<y1 && i+1<x1 && myWorld[i+1][i1+1]==4){
                    spawnmountain+=70; 
                }*/
                if(spawnMountain >=300){
                    myWorld[i][i1]=4;
                }
                radius1=Math.sqrt(Math.pow(Math.abs(waterX -((i*10)+5)),2)+Math.pow(Math.abs(waterY -((i1*10)+5)),2));
                if(myWorld[i][i1]!=4 && radius1<=radius+30){
                    myWorld[i][i1]=8;
                }
                if(radius1<=radius){
                    myWorld[i][i1]=6;
                }
                if(radius1<=radius/2){
                    myWorld[i][i1]=7;
                }
                if(i==0 || i1==0 || i==x1-1 || i1==y1-1){
                    myWorld[i][i1]=4;
                }
                /*if(i>=80 && i1>=40){
                    myWorld[i][i1]=4;
                }*/
            }
        }
        for(int i=0;i<x1;i++){
            for(int i1=0;i1<y1;i1++){
                if(myWorld[i][i1]!=4){
                    if(myWorld[i-1][i1]==4
                    && myWorld[i+1][i1]==4
                    && myWorld[i][i1-1]==4
                    && myWorld[i][i1+1]==4){
                        myWorld[i][i1]=4;
                    }
                }
            }
        }
        while(addBaze ==0){
            x2=Greenfoot.getRandomNumber(x1-4);
            y2=Greenfoot.getRandomNumber(y1-4);
            addBaze =1;
            for(int i=0;i<4;i++){
                for(int i1=0;i1<4;i1++){
                    if(myWorld[x2+i][y2+i1]==7 || myWorld[x2+i][y2+i1]==4){
                        addBaze =0;
                    }
                }
            }
        }
        x2=x2*10;
        y2=y2*10;
        /*for(int i=0;i<50;i++){
            for(int i1=0;i1<30;i1++){
                myWorld[i][i1]=1;
            }
        }
        i1=20;
        for(int i=0;i<50;i++){
            i2=i1;
            i1+=(Greenfoot.getRandomNumber(6)-3);
            if(i1<0){
                i1=0;
            }
            if(i1>=y1){
                i1=y1-1;
            }
            if(i2-i1!=0){
                for(int ix=0;ix<Math.abs(i2-i1);ix++){
                    if(i2-i1>0){
                        myWorld[i][i1+ix]=2;
                        try{
                            if(ix+1==Math.abs(i2-i1) && Greenfoot.getRandomNumber(2)==0){
                                myWorld[i][i1+ix-1]=-1;
                            }
                        }catch(Exception e){}
                    }
                    else if(i2-i1<0){
                        try{
                            if(ix+1==Math.abs(i2-i1) && Greenfoot.getRandomNumber(2)==0){
                                myWorld[i][i1+ix-1]=-1;
                            }
                        }catch(Exception e){}
                        myWorld[i][i1-ix]=2;
                    }
                }
            }
            else if(i2==i1){
                try{
                    if(Greenfoot.getRandomNumber(2)==0){
                        myWorld[i][i1-1]=-1;
                    }
                }catch(Exception e){}
                myWorld[i][i1]=2;
            }
            for(int iy=0;i1+iy<MyWorld.y1;iy++){
                myWorld[i][i1+iy]=2;
            }
        }
        addObject(new Player(), getWidth()/2, getHeight()/2);
        Player.y=(Greenfoot.getRandomNumber(y1/2)*20)+10;    
        Player.x=(Greenfoot.getRandomNumber(x1-1)*20)+10;
        while(myWorld[(Player.x/20)][(Player.y/20)]>=2){
            Player.y=(Greenfoot.getRandomNumber(y1/2)*20)+10;    
            Player.x=(Greenfoot.getRandomNumber(x1-1)*20)+10;
        }
        for(int i1=0;i1<getWidth()/20;i1++){
            for(int i=0;i<getHeight()/20;i++){
                addObject(new Block(i,i1),10+(i1*20),10+(i*20));
            }
        }*/
        updateImage();
        i=new Inventory();
        addObject(i,900,350);
        addObject(b, getWidth()/2,getHeight()/2);
        myBaza=new Baza(x2,y2);
        addObject(myBaza, 800+((x2*Map.cof)/10)+(2*Map.cof), ((y2*Map.cof)/10)+(2*Map.cof));
        addObject(new Player(x2+20,y2+20), x2+20, y2+20);
        addObject(new StructuresList(), getWidth()-100, getHeight()-100);
        mi=new Mouse();
        addObject(mi,0,0);
    }
    public void setNewImage(){
        worldImage.setColor(Color.BLACK);
        worldImage.fill();
        worldImage.drawImage(myImage, (getWidth()/2)-Player.x, (getHeight()/2)-Player.y);
        worldImage.drawImage(connectionImage, (getWidth()/2)-Player.x, (getHeight()/2)-Player.y);
        setBackground(worldImage);
        myImage=new GreenfootImage(myImage1);
        connectionImage = new GreenfootImage(x1*10, y1*10);
    }
    public void setGlowing(){
        /*for(int i=0;i<x1;i++){
            b1=0;
            for(int i1=0;i1<y1;i1++){
                if(glowing[i][i1]==-1){
                    b1=1;
                }
                else{
                    glowing[i][i1]=i1;
                }
                if(b1==1 && glowing[i][i1]!=-1){
                    glowing1[i][i1]=-2;
                }
            }
        }*/
        dosh=1;
        while(dosh==1){
            dosh=0;
            /*for(int i=0;i<x1;i++){
                for(int i1=0;i1<y1;i1++){
                    if(glowing[i][i1]==-1){
                        break;
                    }
                    else{
                        glowing[i][i1]=i1;
                    }
                }
            }*/
            for(int i=0;i<x1;i++){
                for(int i1=0;i1<y1;i1++){
                    if(glowing[i][i1]!=-1){
                        g1=255;
                        if(i-1>=0 && glowing[i-1][i1]>=0){
                            g1=glowing[i-1][i1]+1;
                        }
                        else if(i-1>=0 && glowing[i-1][i1]==-1 && g1>100){
                            g1=100;
                        }
                        if(i+1<x1 && glowing[i+1][i1]>=0 && glowing[i+1][i1]<g1){
                            g1=glowing[i+1][i1]+1;
                        }
                        else if(i+1<x1 && glowing[i+1][i1]==-1 && g1>100){
                            g1=100;
                        }
                        if(i1-1>=0 && glowing[i][i1-1]>=0 && glowing[i][i1-1]<g1){
                            g1=glowing[i][i1-1]+1;
                        }
                        else if(i1-1>=0 && glowing[i][i1-1]==-1 && g1>100){
                            g1=100;
                        }
                        if(i1+1<y1 && glowing[i][i1+1]>=0 && glowing[i][i1+1]<g1){
                            g1=glowing[i][i1+1]+1;
                        }
                        else if(i1+1<y1 && glowing[i][i1+1]==-1 && g1>100){
                            g1=100;
                        }
                        if(i1==0){
                            g1=0;
                        }
                        if(glowing[i][i1]!=g1){
                            glowing[i][i1]=g1;
                            dosh=1;
                        }
                    }
                }
            }
            for(int i=x1-1;i>=0;i--){
                for(int i1=y1-1;i1>=0;i1--){
                    if(glowing[i][i1]!=-1){
                        g1=255;
                        if(i-1>=0 && glowing[i-1][i1]>=0){
                            g1=glowing[i-1][i1]+1;
                        }
                        else if(i-1>=0 && glowing[i-1][i1]==-1 && g1>100){
                            g1=100;
                        }
                        if(i+1<x1 && glowing[i+1][i1]>=0 && glowing[i+1][i1]<g1){
                            g1=glowing[i+1][i1]+1;
                        }
                        else if(i+1<x1 && glowing[i+1][i1]==-1 && g1>100){
                            g1=100;
                        }
                        if(i1-1>=0 && glowing[i][i1-1]>=0 && glowing[i][i1-1]<g1){
                            g1=glowing[i][i1-1]+1;
                        }
                        else if(i1-1>=0 && glowing[i][i1-1]==-1 && g1>100){
                            g1=100;
                        }
                        if(i1+1<y1 && glowing[i][i1+1]>=0 && glowing[i][i1+1]<g1){
                            g1=glowing[i][i1+1]+1;
                        }
                        else if(i1+1<y1 && glowing[i][i1+1]==-1 && g1>100){
                            g1=100;
                        }
                        if(i1==0){
                            g1=0;
                        }
                        if(glowing[i][i1]!=g1){
                            glowing[i][i1]=g1;
                            dosh=1;
                        }
                    }
                }
            }
        }
    }
    public void setGlowing(int stx, int sty, int xsize, int ysize){
        /*for(int i=0;i<x1;i++){
            b1=0;
            for(int i1=0;i1<y1;i1++){
                if(glowing[i][i1]==-1){
                    b1=1;
                }
                else{
                    glowing[i][i1]=i1;
                }
                if(b1==1 && glowing[i][i1]!=-1){
                    glowing1[i][i1]=-2;
                }
            }
        }*/
        dosh=1;
        while(dosh==1){
            dosh=0;
            /*for(int i=0;i<x1;i++){
                for(int i1=0;i1<y1;i1++){
                    if(glowing[i][i1]==-1){
                        break;
                    }
                    else{
                        glowing[i][i1]=i1;
                    }
                }
            }*/
            for(int i=stx;i<stx+xsize;i++){
                for(int i1=sty;i1<sty+ysize;i1++){
                    if(glowing[i][i1]!=-1){
                        g1=255;
                        if(i-1>=0 && glowing[i-1][i1]>=0){
                            g1=glowing[i-1][i1]+1;
                        }
                        else if(i-1>=0 && glowing[i-1][i1]==-1 && g1>100){
                            g1=100;
                        }
                        if(i+1<x1 && glowing[i+1][i1]>=0 && glowing[i+1][i1]<g1){
                            g1=glowing[i+1][i1]+1;
                        }
                        else if(i+1<x1 && glowing[i+1][i1]==-1 && g1>100){
                            g1=100;
                        }
                        if(i1-1>=0 && glowing[i][i1-1]>=0 && glowing[i][i1-1]<g1){
                            g1=glowing[i][i1-1]+1;
                        }
                        else if(i1-1>=0 && glowing[i][i1-1]==-1 && g1>100){
                            g1=100;
                        }
                        if(i1+1<y1 && glowing[i][i1+1]>=0 && glowing[i][i1+1]<g1){
                            g1=glowing[i][i1+1]+1;
                        }
                        else if(i1+1<y1 && glowing[i][i1+1]==-1 && g1>100){
                            g1=100;
                        }
                        if(i1==0){
                            g1=0;
                        }
                        if(glowing[i][i1]!=g1){
                            glowing[i][i1]=g1;
                            dosh=1;
                        }
                    }
                }
            }
            for(int i=stx+xsize;i>=stx;i--){
                for(int i1=sty+ysize;i1>=sty;i1--){
                    if(glowing[i][i1]!=-1){
                        g1=255;
                        if(i-1>=0 && glowing[i-1][i1]>=0){
                            g1=glowing[i-1][i1]+1;
                        }
                        else if(i-1>=0 && glowing[i-1][i1]==-1 && g1>100){
                            g1=100;
                        }
                        if(i+1<x1 && glowing[i+1][i1]>=0 && glowing[i+1][i1]<g1){
                            g1=glowing[i+1][i1]+1;
                        }
                        else if(i+1<x1 && glowing[i+1][i1]==-1 && g1>100){
                            g1=100;
                        }
                        if(i1-1>=0 && glowing[i][i1-1]>=0 && glowing[i][i1-1]<g1){
                            g1=glowing[i][i1-1]+1;
                        }
                        else if(i1-1>=0 && glowing[i][i1-1]==-1 && g1>100){
                            g1=100;
                        }
                        if(i1+1<y1 && glowing[i][i1+1]>=0 && glowing[i][i1+1]<g1){
                            g1=glowing[i][i1+1]+1;
                        }
                        else if(i1+1<y1 && glowing[i][i1+1]==-1 && g1>100){
                            g1=100;
                        }
                        if(i1==0){
                            g1=0;
                        }
                        if(glowing[i][i1]!=g1){
                            glowing[i][i1]=g1;
                            dosh=1;
                        }
                    }
                }
            }
        }
    }
    int rot;
    int i4;
    int i5;
    public void updateImage(){
        myImage=new GreenfootImage(x1*10, y1*10);
        for(int i=0;i<x1;i++){
            for(int i1=0;i1<y1;i1++){
                if(myWorld[i][i1]==1){
                    myImage.drawImage(fon,(i*10),(i1*10));
                    i3=0;
                    i4=0;
                    i5=0;
                    rot=0;
                    if(i+1<x1){
                        if(i1-1>=0){
                            if(myWorld[i+1][i1-1]==2 || myWorld[i+1][i1-1]==3 || myWorld[i+1][i1-1]==5){
                                fon2=new GreenfootImage("earth5.png");
                                fon2.rotate(180);
                                //myImage.drawImage(fon2,(i*10)+5,(i1*10));
                                myImage.drawImage(fon2,(i*10),(i1*10));
                            }
                        }
                        if(i1+1<y1){
                            if(myWorld[i+1][i1+1]==2 || myWorld[i+1][i1+1]==3 || myWorld[i+1][i1+1]==5){
                                fon2=new GreenfootImage("earth5.png");
                                fon2.rotate(-90);
                                //myImage.drawImage(fon2,(i*10)+5,(i1*10)+5);
                                myImage.drawImage(fon2,(i*10),(i1*10));
                            }
                        }
                    }
                    if(i-1>=0){
                        if(i1-1>=0){
                            if(myWorld[i-1][i1-1]==2 || myWorld[i-1][i1-1]==3 || myWorld[i-1][i1-1]==5){
                                fon2=new GreenfootImage("earth5.png");
                                fon2.rotate(90);
                                //myImage.drawImage(fon2,(i*10),(i1*10));
                                myImage.drawImage(fon2,(i*10),(i1*10));
                            }
                        }
                        if(i1+1<y1){
                            if(myWorld[i-1][i1+1]==2 || myWorld[i-1][i1+1]==3 || myWorld[i-1][i1+1]==5){
                                fon2=new GreenfootImage("earth5.png");
                                //myImage.drawImage(fon2,(i*10),(i1*10)+5);
                                myImage.drawImage(fon2,(i*10),(i1*10));
                            }
                        }
                        if(myWorld[i-1][i1]==2 || myWorld[i-1][i1]==3 || myWorld[i-1][i1]==5){
                            i3++;
                            i4=1;
                            rot=180;
                            fon2=new GreenfootImage("earth2.png");
                            fon2.rotate(90);
                            myImage.drawImage(fon2,(i*10),(i1*10));
                        }
                    }
                    if(i1-1>=0){
                        if(myWorld[i][i1-1]==2 || myWorld[i][i1-1]==3 || myWorld[i][i1-1]==5){
                            i3++;
                            i5=1;
                            rot+=270;
                            fon2=new GreenfootImage("earth2.png");
                            fon2.rotate(180);
                            myImage.drawImage(fon2,(i*10),(i1*10));
                        }
                    }
                    if(i1+1<y1){
                        if(myWorld[i][i1+1]==2 || myWorld[i][i1+1]==3 || myWorld[i][i1+1]==5){
                            i3++;
                            if(i5==1){
                                i5=2;
                            }
                            rot+=90;
                            fon2=new GreenfootImage("earth2.png");
                            myImage.drawImage(fon2,(i*10),(i1*10));
                            //myImage.drawImage(fon2,(i*10),(i1*10)+5);
                        }
                    }
                    if(i+1<x1){
                        if(myWorld[i+1][i1]==2 || myWorld[i+1][i1]==3 || myWorld[i+1][i1]==5){
                            i3++;
                            if(i4==1){
                                i4=2;
                            }
                            rot=rot*2;
                            if(i1+1>=0){
                                if(myWorld[i][i1+1]==2 || myWorld[i][i1+1]==3 || myWorld[i][i1+1]==5){
                                    rot-=90;
                                }
                            }
                            fon2=new GreenfootImage("earth2.png");
                            fon2.rotate(-90);
                            //myImage.drawImage(fon2,(i*10)+5,(i1*10));
                            myImage.drawImage(fon2,(i*10),(i1*10));
                        }
                    }
                    if(i3==2){
                        fon2=new GreenfootImage("earth4.png");
                        rot=rot/i3;
                        rot=(rot/90)*90;
                        fon2.rotate(rot);
                        myImage.drawImage(fon2,(i*10),(i1*10));
                        if(i-1>=0){
                            if(i1-1>=0 && rot==0){
                                if(myWorld[i-1][i1-1]==2 || myWorld[i-1][i1-1]==3 || myWorld[i-1][i1-1]==5){
                                    fon2=new GreenfootImage("earth5.png");
                                    fon2.rotate(90);
                                    myImage.drawImage(fon2,(i*10),(i1*10));
                                }
                            }
                            if(i1+1<y1 && rot==270){
                                if(myWorld[i-1][i1+1]==2 || myWorld[i-1][i1+1]==3 || myWorld[i-1][i1+1]==5){
                                    fon2=new GreenfootImage("earth5.png");
                                    //myImage.drawImage(fon2,(i*10),(i1*10)+5);
                                    myImage.drawImage(fon2,(i*10),(i1*10));
                                }
                            }
                        }
                        if(i+1<x1){
                            if(i1-1>=0 && rot==90){
                                if(myWorld[i+1][i1-1]==2 || myWorld[i+1][i1-1]==3 || myWorld[i+1][i1-1]==5){
                                    fon2=new GreenfootImage("earth5.png");
                                    fon2.rotate(180);
                                    //myImage.drawImage(fon2,(i*10)+5,(i1*10));
                                    myImage.drawImage(fon2,(i*10),(i1*10));
                                }
                            }
                            if(i1+1<y1 && rot==180){
                                if(myWorld[i+1][i1+1]==2 || myWorld[i+1][i1+1]==3 || myWorld[i+1][i1+1]==5){
                                    fon2=new GreenfootImage("earth5.png");
                                    fon2.rotate(-90);
                                    //myImage.drawImage(fon2,(i*10)+5,(i1*10)+5);
                                    myImage.drawImage(fon2,(i*10),(i1*10));
                                }
                            }
                        }
                    }
                    if(i4==2 || i5==2){
                        myImage.drawImage(fon1,(i*10),(i1*10));
                    }
                }
                else if(myWorld[i][i1]==2){
                    myImage.drawImage(fon1,(i*10),(i1*10));
                    myImage.drawImage(coal,(i*10),(i1*10));
                    map.setColorAt(i,i1,new Color(0,0,0,255));
                }
                else if(myWorld[i][i1]==3){
                    myImage.drawImage(fon1,(i*10),(i1*10));
                    myImage.drawImage(iron,(i*10),(i1*10));
                    map.setColorAt(i,i1,new Color(200,100,100,255));
                }
                else if(myWorld[i][i1]==4){
                    //addObject(new Mountain((i*10)+5, (i1*10)+5),(i*10)+5,(i1*10)+5);
                    myImage.drawImage(mountain,(i*10),(i1*10));
                    map.setColorAt(i,i1,new Color(0,200,0,255));
                    addObject(new Mountain((i*10)+5,(i1*10)+5),(Map.cof/2)+800+i*Map.cof,(Map.cof/2)+i1*Map.cof);
                }
                else if(myWorld[i][i1]==5){
                    myImage.drawImage(fon1,(i*10),(i1*10));
                    myImage.drawImage(lead,(i*10),(i1*10));
                    map.setColorAt(i,i1,new Color(0,100,200,255));
                }
                else if(myWorld[i][i1]==6){
                    myImage.drawImage(fon,(i*10),(i1*10));
                    addObject(new Water((i*10)+5,(i1*10)+5),(Map.cof/2)+800+i*Map.cof,(Map.cof/2)+i1*Map.cof); 
                }
                else if(myWorld[i][i1]==7){
                    myImage.drawImage(fon,(i*10),(i1*10));
                    addObject(new Water2((i*10)+5,(i1*10)+5),(Map.cof/2)+800+i*Map.cof,(Map.cof/2)+i1*Map.cof); 
                }
                else if(myWorld[i][i1]==8){
                    myImage.drawImage(sand,(i*10),(i1*10));
                    map.setColorAt(i,i1,new Color(0,255,0,255));
                    i3=0;
                    i4=0;
                    i5=0;
                    rot=0;
                    if(i+1<x1){
                        if(i1-1>=0){
                            if(myWorld[i+1][i1-1]==2 || myWorld[i+1][i1-1]==3 || myWorld[i+1][i1-1]==5){
                                fon2=new GreenfootImage("earth5.png");
                                fon2.rotate(180);
                                //myImage.drawImage(fon2,(i*10)+5,(i1*10));
                                myImage.drawImage(fon2,(i*10),(i1*10));
                            }
                        }
                        if(i1+1<y1){
                            if(myWorld[i+1][i1+1]==2 || myWorld[i+1][i1+1]==3 || myWorld[i+1][i1+1]==5){
                                fon2=new GreenfootImage("earth5.png");
                                fon2.rotate(-90);
                                //myImage.drawImage(fon2,(i*10)+5,(i1*10)+5);
                                myImage.drawImage(fon2,(i*10),(i1*10));
                            }
                        }
                    }
                    if(i-1>=0){
                        if(i1-1>=0){
                            if(myWorld[i-1][i1-1]==2 || myWorld[i-1][i1-1]==3 || myWorld[i-1][i1-1]==5){
                                fon2=new GreenfootImage("earth5.png");
                                fon2.rotate(90);
                                //myImage.drawImage(fon2,(i*10),(i1*10));
                                myImage.drawImage(fon2,(i*10),(i1*10));
                            }
                        }
                        if(i1+1<y1){
                            if(myWorld[i-1][i1+1]==2 || myWorld[i-1][i1+1]==3 || myWorld[i-1][i1+1]==5){
                                fon2=new GreenfootImage("earth5.png");
                                //myImage.drawImage(fon2,(i*10),(i1*10)+5);
                                myImage.drawImage(fon2,(i*10),(i1*10));
                            }
                        }
                        if(myWorld[i-1][i1]==2 || myWorld[i-1][i1]==3 || myWorld[i-1][i1]==5){
                            i3++;
                            i4=1;
                            rot=180;
                            fon2=new GreenfootImage("earth2.png");
                            fon2.rotate(90);
                            myImage.drawImage(fon2,(i*10),(i1*10));
                        }
                    }
                    if(i1-1>=0){
                        if(myWorld[i][i1-1]==2 || myWorld[i][i1-1]==3 || myWorld[i][i1-1]==5){
                            i3++;
                            i5=1;
                            rot+=270;
                            fon2=new GreenfootImage("earth2.png");
                            fon2.rotate(180);
                            myImage.drawImage(fon2,(i*10),(i1*10));
                        }
                    }
                    if(i1+1<y1){
                        if(myWorld[i][i1+1]==2 || myWorld[i][i1+1]==3 || myWorld[i][i1+1]==5){
                            i3++;
                            if(i5==1){
                                i5=2;
                            }
                            rot+=90;
                            fon2=new GreenfootImage("earth2.png");
                            myImage.drawImage(fon2,(i*10),(i1*10));
                            //myImage.drawImage(fon2,(i*10),(i1*10)+5);
                        }
                    }
                    if(i+1<x1){
                        if(myWorld[i+1][i1]==2 || myWorld[i+1][i1]==3 || myWorld[i+1][i1]==5){
                            i3++;
                            if(i4==1){
                                i4=2;
                            }
                            rot=rot*2;
                            if(i1+1>=0){
                                if(myWorld[i][i1+1]==2 || myWorld[i][i1+1]==3 || myWorld[i][i1+1]==5){
                                    rot-=90;
                                }
                            }
                            fon2=new GreenfootImage("earth2.png");
                            fon2.rotate(-90);
                            //myImage.drawImage(fon2,(i*10)+5,(i1*10));
                            myImage.drawImage(fon2,(i*10),(i1*10));
                        }
                    }
                    if(i3==2){
                        fon2=new GreenfootImage("earth4.png");
                        rot=rot/i3;
                        rot=(rot/90)*90;
                        fon2.rotate(rot);
                        myImage.drawImage(fon2,(i*10),(i1*10));
                    }
                    if(i4==2 || i5==2){
                        myImage.drawImage(fon1,(i*10),(i1*10));
                    }
                }
                /*if(glowing[i][i1]>=0){
                    myImage.setColor(new Color(0,0,0,glowing[i][i1]));
                    myImage.fillRect((i*10),(i1*10),10,10);
                }*/
            }
        }
        blockx=fon.getWidth();
        myImage1=new GreenfootImage(myImage);
        Map map1=new Map(x1,y1,map);
        addObject(map1,0,0);
        setBackground(myImage);
    }
    public void act(){
        setNewImage();
        /*if(Greenfoot.mousePressed(null) && haveC==0){
            st=mi.getObj();
        }
        if(st!=null){
            i.updateImage(st);
        }
        else{
            i.setNullImage();
        }*/
        //z=1;
        /*if(x<getWidth()/20){
            if(y<getHeight()/20){
                for(int i=0;i<getHeight()/20;i++){
                    addObject(new Block(x,y,myWorld[x][y]),10+(x*20),10+(y*20));
                    y++;
                }
            }
            else{
                y=0;
                x++;
            }
        }*/
        /*yn1=Block.yn;
        ys1=Block.ys;
        xv1=Block.xv;
        xe1=Block.xe;
        if(Block.yn==12){
            try{
                for(int i=0;i<getWidth()/20;i++){
                    addObject(new Block(Block.mvxv+i,Block.mvyn-1,myWorld[Block.mvxv+i][Block.mvyn-1]),Block.xv+10+(i*20),2);
                } 
            }catch(Exception e){}
        }
        if(Block.ys==getHeight()-12){
            try{
                for(int i=0;i<getWidth()/20;i++){
                    addObject(new Block(Block.mvxv+i,Block.mvys+1,myWorld[Block.mvxv+i][Block.mvys+1]),Block.xv+10+(i*20),398);
                } 
            }catch(Exception e){}
        }
        if(Block.xv==12){
            try{
                for(int i=0;i<getHeight()/20;i++){
                    addObject(new Block(Block.mvxv-1,Block.mvyn+i,myWorld[Block.mvxv-1][Block.mvyn+i]),2,Block.yn+10+(i*20));
                } 
            }catch(Exception e){}
        }
        if(Block.xe==getWidth()-12){
            try{
            for(int i=0;i<getHeight()/20;i++){
                addObject(new Block(Block.mvxe+1,Block.mvyn+i,myWorld[Block.mvxe+1][Block.mvyn+i]),598,Block.yn+10+(i*20));
            } 
        }catch(Exception e){}
        }*/
    }
}
