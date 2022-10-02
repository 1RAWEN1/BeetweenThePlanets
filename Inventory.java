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

    Label label = new Label("", 22, 0);

    int x=0;
    int y;

    int xSize = 1;
    int ySize;

    int typeres;
    private static final Color transparent = new Color(0,0,0,0);
    GreenfootImage myImage;
    GreenfootImage myImage2=new GreenfootImage(10, 10);
    GreenfootImage myImage3=new GreenfootImage(10, 10);
    GreenfootImage water=new GreenfootImage("water1.png");
    GreenfootImage coal=new GreenfootImage("coal.png");
    GreenfootImage iron=new GreenfootImage("iron.png");
    GreenfootImage lead=new GreenfootImage("lead.png");
    GreenfootImage sand=new GreenfootImage("sand.png");
    GreenfootImage graphite=new GreenfootImage("Graf.png");
    GreenfootImage silica=new GreenfootImage("silica.png");
    GreenfootImage si=new GreenfootImage("silicon.png");
    GreenfootImage glass=new GreenfootImage(1, 1);

    int startY;
    public Inventory(){
        setNullImage();
    }
    public void updateImage(Structures st){
        myImage=new GreenfootImage(200,ySize + (ySize > 0 ? 0 : 1));
        myImage.clear();

        fillBackground(myImage);

        startY = 0;
        x=2;

        myImage.setColor(Color.BLACK);
        myImage.drawRect(2, 2, getImage().getWidth() - 5, 13);

        myImage.setColor(new Color(255, 162, 100, 255));
        myImage.fillRect(3, 3, getImage().getWidth() - 6, 12);
        myImage.setColor(Color.RED);
        myImage.fillRect(3, 3, (int)(((double)st.hp / st.fullHp) * (getImage().getWidth() - 6)), 12);
        startY += 14;

        label.setFillColor(new Color(244, 189, 0, 255));
        if(st.needEnergy == -1){
            label.setValue("Energy: " + st.energy);
            myImage.drawImage(label.getImage(), 2, startY);
            startY += label.getImage().getHeight();
        }
        else if(st.needEnergy > 0){
            label.setValue("Have energy: " + st.haveEnergy);
            myImage.drawImage(label.getImage(), 2, startY);
            startY += label.getImage().getHeight();
        }
        else if(st.energyICanCreate > 0){
            label.setValue("Energy: " + (st.canCreate ? st.energyICanCreate : 0));
            myImage.drawImage(label.getImage(), 2, startY);
            startY += label.getImage().getHeight();
        }

        if(!st.canCreate){
            drawNeedRes(st);
        }

        y=startY;
        xSize = 1;
        ySize = y;
        boolean countSize = false;
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
                if(typeres==0){
                    drawResource(water, myImage2);
                }
                else if(typeres==1){
                    drawResource(coal, myImage2);
                }
                else if(typeres==2){
                    drawResource(iron, myImage2);
                }
                else if(typeres==3){
                    drawResource(lead, myImage2);
                }
                else if(typeres==4){
                    drawResource(sand, myImage2);
                }
                else if(typeres==5){
                    drawResource(graphite, myImage2);
                }
                else if(typeres==6){
                    drawResource(silica, myImage2);
                }
                else if(typeres==7){
                    drawResource(si, myImage2);
                }
                else if(typeres==8){
                    drawResource(glass, myImage2);
                }
                myImage2.drawImage(myImage1, myImage2.getWidth()/2-myImage1.getWidth()/2, 0);
                myImage3=new GreenfootImage(myImage2.getWidth()+4, myImage2.getHeight()+4);
                myImage3.clear();
                myImage3.setColor(Color.WHITE);
                myImage3.fill();
                myImage3.setColor(Color.BLACK);
                myImage3.drawRect(0,0,myImage3.getWidth()-1, myImage3.getHeight()-1);
                myImage3.drawRect(1,1,myImage3.getWidth()-3, myImage3.getHeight()-3);
                myImage3.drawImage(myImage2,2,2);
                myImage.drawImage(myImage3,x,y);
                x+=myImage3.getWidth();

                xSize = Math.max(xSize, x);
                ySize = Math.max(ySize, y);

                if(x > 200 - fontSize - 2){
                    x = 2;
                    y += myImage3.getHeight();
                }

                countSize = true;
            }
        }
        if(countSize){
            ySize += fontSize + 5;
        }
        setImage(myImage);
        setLocation(getX(),400 - (myImage.getHeight() / 2) - (myImage.getHeight() % 2));
    }

    int x1;
    int y1;
    public void drawNeedRes(Structures st){
        boolean drawNeedRedImage = false;
        GreenfootImage myImage1=new GreenfootImage(200, fontSize + 6 + y1);

        x1 = 0;
        y1 = 0;
        for(int i2 = 0; i2<st.needRes.size(); i2++){
            if(st.resNum[st.needRes.get(i2)] <= 0) {
                myImage2 = new GreenfootImage(fontSize + 2, fontSize + 2);
                myImage2.setColor(Color.WHITE);
                myImage2.fill();

                typeres = st.needRes.get(i2);
                if (typeres == 0) {
                    drawResource(water, myImage2);
                } else if (typeres == 1) {
                    drawResource(coal, myImage2);
                } else if (typeres == 2) {
                    drawResource(iron, myImage2);
                } else if (typeres == 3) {
                    drawResource(lead, myImage2);
                } else if (typeres == 4) {
                    drawResource(sand, myImage2);
                } else if (typeres == 5) {
                    drawResource(graphite, myImage2);
                } else if (typeres == 6) {
                    drawResource(silica, myImage2);
                } else if (typeres == 7) {
                    drawResource(si, myImage2);
                } else if (typeres == 8) {
                    drawResource(glass, myImage2);
                }

                GreenfootImage image3 = new GreenfootImage(myImage2.getWidth() + 4, myImage2.getHeight() + 4);
                image3.drawImage(myImage2, 2, 2);
                drawBackground(image3);

                image3.setColor(Color.RED);
                image3.drawLine(2, 2, image3.getWidth() - 3, image3.getHeight() - 3);

                myImage1.drawImage(image3, x1, y1);

                x1 += image3.getWidth();
                if(x1 > 200 - fontSize - 2) {
                    x1 = 0;
                    y1 += image3.getHeight();
                }

                drawNeedRedImage = true;
            }
        }
        if(drawNeedRedImage) {
            myImage.drawImage(myImage1, 2, startY);
            startY += myImage1.getHeight();
        }
    }

    public void drawResource(GreenfootImage image, GreenfootImage image2){
        image.scale(image2.getHeight(), image2.getHeight());
        image2.drawImage(image, image2.getWidth()/2-image.getWidth()/2, 0);
    }
    public void setNullImage(){
        myImage=new GreenfootImage(1,1);
        myImage.clear();
        setImage(myImage);
    }

    public void drawStructureCost(){
        Structures st = MyWorld.b.myst;
        myImage=new GreenfootImage(200, y + (y > 0 ? 0 : 1));
        myImage.clear();

        fillBackground(myImage);

        x = 2;
        y = 2;
        for(int i = 0; i<st.cost.size(); i+=2){
            value = MyWorld.myBaza.resNum[st.cost.get(i)] + "/" + st.cost.get(i + 1);
            if(MyWorld.myBaza.resNum[st.cost.get(i)] < st.cost.get(i + 1)){
                fillColor = Color.RED;
            }
            else{
                fillColor = Color.BLACK;
            }
            myImage2=new GreenfootImage(value, fontSize, fillColor, transparent, lineColor);
            GreenfootImage myImage1=new GreenfootImage(myImage2);
            myImage2.clear();
            if(myImage2.getWidth()<myImage2.getHeight()){
                myImage2=new GreenfootImage(myImage2.getHeight(), myImage2.getHeight());
            }
            myImage2.drawImage(myImage1, myImage2.getWidth()/2-myImage1.getWidth()/2, 0);
            myImage3=new GreenfootImage(myImage2.getHeight(), myImage2.getHeight());
            myImage3.clear();
            myImage3.setColor(Color.WHITE);
            myImage3.fill();

            typeres=st.cost.get(i);
            if(typeres==0){
                drawResource(water, myImage3);
            }
            else if(typeres==1){
                drawResource(coal, myImage3);
            }
            else if(typeres==2){
                drawResource(iron, myImage3);
            }
            else if(typeres==3){
                drawResource(lead, myImage3);
            }
            else if(typeres==4){
                drawResource(sand, myImage3);
            }
            else if(typeres==5){
                drawResource(graphite, myImage3);
            }
            else if(typeres==6){
                drawResource(silica, myImage3);
            }
            else if(typeres==7){
                drawResource(si, myImage3);
            }
            else if(typeres==8){
                drawResource(glass, myImage3);
            }

            //myImage3.setColor(new Color(244, 189, 0 , 255));
            myImage3.setColor(Color.BLACK);
            myImage3.drawRect(0,0,myImage3.getWidth()-1, myImage3.getHeight()-1);
            myImage3.drawRect(1,1,myImage3.getWidth()-3, myImage3.getHeight()-3);
            //myImage3.drawImage(myImage2,2,2);
            myImage.drawImage(myImage3,x, y);
            myImage.drawImage(myImage2, myImage3.getWidth() + 4, y);

            y += myImage3.getHeight() + (i + 2 == st.cost.size() ? 0 : 1);
        }
        setImage(myImage);
        setLocation(getX(),400 - (myImage.getHeight() / 2) - (myImage.getHeight() % 2));
    }

    public void fillBackground(GreenfootImage image){
        image.setColor(Color.WHITE);
        image.fill();
        image.setColor(new Color(120, 120, 120, 255));
        image.drawRect(0,0, image.getWidth() - 1, image.getHeight() + 1);
        image.drawRect(1,1, image.getWidth() - 3, image.getHeight() + 1);
    }

    public void drawBackground(GreenfootImage image){
        image.setColor(Color.BLACK);
        image.drawRect(0,0, image.getWidth() - 1, image.getHeight() - 1);
        image.drawRect(1,1, image.getWidth() - 3, image.getHeight() - 3);
    }

    public void act() 
    {
        // Add your action code here.
    }    
}
