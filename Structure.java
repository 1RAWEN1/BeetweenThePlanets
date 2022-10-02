import greenfoot.*;

import java.util.ArrayList;

public class Structure extends Actor {
    boolean canBreak = true;
    int x;
    int y;
    int transparency;
    private GreenfootImage myImage;
    private GreenfootImage image;
    GreenfootImage fon;
    ArrayList<Integer> cost=new ArrayList<>();
    private int proc;
    int building;
    int building1=1;
    boolean selectStructure;
    private boolean startbuilding;

    int energy;
    int needEnergy;
    int energyICanCreate;
    int type;
    int hp;
    int fullHp;
    boolean addStructure;
    boolean haveEnergy;

    public void wasteResources(){
        for(int i=0;i<cost.size();i+=2) {
            MyWorld.myBaza.resNum[cost.get(i)] += ((int)(cost.get(i+1) * (double)startBuildingValue / building1) - (int)(cost.get(i+1) * (double)building / building1));
        }
    }

    public boolean canBeBuild(){
        startbuilding=true;

        for(int i=0;i<cost.size();i+=2){
            if(MyWorld.myBaza.resNum[cost.get(i)]>=cost.get(i+1)){
                building1+=cost.get(i+1);
            }
            else{
                startbuilding=false;
                break;
            }
        }

        return startbuilding;
    }

    public void Del(){
        /*for(int i=0;i<cost.size();i+=2){
            if(MyWorld.myBaza.resNum[cost.get(i)]>=cost.get(i+1)){
                MyWorld.myBaza.resNum[cost.get(i)]+=cost.get(i+1);
            }
        }*/
        /*if(MyWorld.st==this){
            MyWorld.st=null;
        }*/

        MyWorld.deleteStructure = true;
    }

    public boolean isBuilt(){
        return building == building1;
    }

    int lastX;
    int lastY;
    public void updateStructureLocation(){
        lastX = x;
        lastY = y;

        x = MyWorld.mi.x + (getImage().getWidth() / 2);
        y = MyWorld.mi.y + (getImage().getHeight() / 2);

        updateLocation();
        //setLocation(MyWorld.mi.getX()+(((fon.getWidth()/10)/2)*Map.cof),MyWorld.mi.getY()+(((fon.getHeight()/10)/2)*Map.cof));

        /*if(getX() <= getWorld().getWidth() - 200){
            setLocation(getWorld().getWidth() - 200, getY());
        }
        if(getY() >= 120){
            setLocation(getX(), 119);
        }*/
    }

    public boolean changeLocation(){
        return lastX != x || lastY != y;
    }

    double radius1;

    int radius;
    public void isClick(){
        /*if(MyWorld.mi.getClickedObject()==this && MyWorld.selectedStructure == null && type == 1 && isBuilt()){
            MyWorld.selectedStructure = this;
        }
        else if(Greenfoot.mousePressed(null) && MyWorld.selectedStructure == this){
            MouseInfo mi=Greenfoot.getMouseInfo();
            if(mi!=null){
                radius1=Math.sqrt(Math.pow(Math.abs((x-Player.x+500)-mi.getX()), 2)+Math.pow(Math.abs((y-Player.y)+300-mi.getY()), 2));
            }
            else{
                radius1 = 0;
            }
            if(radius1>radius && MyWorld.mi.getClickedObject() == null || radius1>radius && MyWorld.mi.getClickedObject() != this || Greenfoot.isKeyDown("Escape")){
                MyWorld.selectedStructure = null;

                MyWorld.i.setNullImage();
            }
        }*/
    }

    public void deleteStructure(){
        if(canBreak)
            type = 2;
    }

    //helpObject helper;
    boolean start = false;
    public void draw(GreenfootImage fon1){
        /*if(!selectStructure) {
            drawConnections();
        }*/
        /*if(!start){
            //helper = new helpObject(this);
            //getWorld().addObject(helper, getX(), getY());
            start = true;
        }*/

        /*if(MyWorld.mi.getClickedObject2()==this){
            deleteStructure();
        }*/

        myImage = new GreenfootImage(fon1);
        if(type==0){
            placeAnimation(fon1);
        }
        else if(type==1){
            stand(fon1);
        }
        else if(type==2){
            delete(fon1);
        }

        updateLocation();
    }

    public void updateMyImage(){
        image=new GreenfootImage(((fon.getWidth()*Map.cof)/10),((fon.getHeight()*Map.cof)/10));
        image.setColor(new Color(244, 189, 0 , 255));
        image.fill();
        setImage(image);
    }

    public void stand(GreenfootImage fon1){
        if(!isBuilt()){
            buildingAnimation(fon1);
        }
        else{
            updateImage(fon1);
        }
    }

    public int getDistanceToPlayer(){
        return (int)Math.sqrt(Math.pow(Player.x - x, 2) + Math.pow(Player.y - y, 2));
    }

    public void buildingAnimation(GreenfootImage fon1){
        startBuildingValue = building;
        if(!Player.isBusy && getDistanceToPlayer() < 1000) {
            building++;

            if (startBuildingValue != building) {
                drawLines(myImage, new Color(244, 189, 0, 255), Player.x, Player.y);

                wasteResources();

                Player.isBusy = true;

                if(building == building1){
                    MyWorld.addStructure = true;
                }
            }
            if(Math.abs(x - Player.x) - (myImage.getWidth() / 2) < getWorld().getWidth() / 2 && Math.abs(y - Player.y) - (myImage.getHeight() / 2) < getWorld().getHeight() / 2) {
                proc = (int) (fon1.getWidth() * ((double) (building) / building1));
                if (proc <= 0) {
                    proc = 1;
                }

                GreenfootImage newImage = new GreenfootImage(proc, proc);

                newImage.drawImage(fon1, newImage.getWidth() / 2 - fon1.getWidth() / 2, newImage.getHeight() / 2 - fon1.getHeight() / 2);
                newImage.setColor(new Color(244, 189, 0, 255));
                newImage.drawRect(0, 0, newImage.getWidth() - 1, newImage.getHeight() - 1);

                myImage.clear();
                myImage.drawImage(newImage, (fon1.getWidth() / 2) - (proc / 2), (fon1.getHeight() / 2) - (proc / 2));

                if (isTouching(NatObstical.class) && type == 0 || isTouching(Structures.class) && type == 0) {
                    myImage.setColor(new Color(255, 0, 0, 100));
                    myImage.fillRect(0, 0, myImage.getWidth(), myImage.getHeight());
                }

                //MyWorld.myImage.drawImage(myImage, x, y);
                setImage(myImage);
                //setNullImage=1;
            }
        /*else if(getObjectsInRange(500, Player.class).size()==0 && setNullImage==1){
            setMyImage();
            setNullImage=0;
        }*/
        }
    }

    int startBuildingValue;
    public void delete(GreenfootImage fon1){
        startBuildingValue = building;
        if(building>0 && !Player.isBusy && getDistanceToPlayer() < 1000){
            building--;

            if(startBuildingValue != building)
                drawLines(myImage, Color.RED, Player.x, Player.y);

            wasteResources();

            Player.isBusy = true;
        }

        deleteAnimation(fon1);

        if(building==0){
            Del();
            getWorld().removeObject(this);

            /*if(MyWorld.selectedStructure == this){
                MyWorld.selectedStructure = null;
            }*/
        }
    }

    public void deleteAnimation(GreenfootImage fon1){
        if(Math.abs(x - Player.x) - (myImage.getWidth() / 2) < getWorld().getWidth() / 2 && Math.abs(y - Player.y) - (myImage.getHeight() / 2) < getWorld().getHeight() / 2){
            if(building > 0) {
                proc = (int) (fon1.getWidth() * ((double) (building) / building1));
                if (proc <= 0) {
                    proc = 1;
                }

                GreenfootImage image = new GreenfootImage(proc, proc);

                image.drawImage(fon1, image.getWidth() / 2 - fon1.getWidth() / 2, image.getHeight() / 2 - fon1.getHeight() / 2);
                image.setColor(Color.RED);
                image.drawRect(0, 0, image.getWidth() - 1, image.getHeight() - 1);

                myImage.clear();
                myImage.drawImage(image, (fon1.getWidth() / 2) - (proc / 2), (fon1.getHeight() / 2) - (proc / 2));
            }
            //MyWorld.myImage.drawImage(myImage, x, y);
            setImage(myImage);
        }
    }

    public void placeAnimation(GreenfootImage fon1){
        if(Math.abs(x - Player.x) - (myImage.getWidth() / 2) < getWorld().getWidth() / 2 && Math.abs(y - Player.y) - (myImage.getHeight() / 2) < getWorld().getHeight() / 2){
            myImage.clear();
            myImage.drawImage(fon1,0,0);
            if(isTouching(NatObstical.class) && type==0 || isTouching(Structures.class) && type==0){
                myImage.setColor(new Color(255, 0, 0, 100));
                myImage.fillRect(0,0,myImage.getWidth(),myImage.getHeight());
            }
            myImage.setTransparency(transparency);
            //MyWorld.myImage.drawImage(myImage,x, y);
            setImage(myImage);
        }
    }

    public void updateImage(GreenfootImage fon1){
        if(Math.abs(x - Player.x) - (myImage.getWidth() / 2) < getWorld().getWidth() / 2 && Math.abs(y - Player.y) - (myImage.getHeight() / 2) < getWorld().getHeight() / 2){
            //MyWorld.myImage.drawImage(myImage, x, y);
            setImage(fon1);
        }
        //System.out.println((int)Math.sqrt(Math.pow((Math.abs(x - Player.x) - (myImage.getWidth() / 2)), 2) +
        //        Math.pow((Math.abs(y - Player.y) - (myImage.getHeight() / 2)), 2)));
    }
    /*public void updateLocation(){
        if(Player.setLoc){
            setLocation(x-Player.x+500, y-Player.y+300);
        }
    }*/

    public void updateLocation(){
        if(getWorld() != null)
            setLocation((getWorld().getWidth() / 2) + x - Player.x, (getWorld().getHeight() / 2) + y - Player.y);
    }

    public void setMyImage(){
        getWorld().setBackground(MyWorld.worldImage);
    }

    int[] xPoints = new int[4];
    int[] yPoints = new int[4];
    int n;
    public void drawLines(GreenfootImage fon, Color c, int xLoc, int yLoc){
        x -= getImage().getWidth() / 2;
        y -= getImage().getHeight() / 2;

        MyWorld.connectionImage.setColor(c);

        if(yLoc > y + fon.getHeight() && xLoc < x
                || yLoc < y && xLoc > x + fon.getWidth()){
            MyWorld.connectionImage.drawLine(xLoc, yLoc,x,y);
            MyWorld.connectionImage.drawLine(xLoc, yLoc,x+fon.getWidth(),y+fon.getHeight());

            xPoints[0] = x;
            xPoints[2] = x + fon.getWidth();

            yPoints[0] = y;
            yPoints[2] = y + fon.getHeight();

            if(Math.pow(xLoc - (x + fon.getWidth()), 2) + Math.pow(yLoc - y, 2) < Math.pow(xLoc - x, 2) + Math.pow(yLoc - (y + fon.getHeight()), 2)){
                xPoints[1] = x + fon.getWidth();
                yPoints[1] = y;
            }
            else{
                xPoints[1] = x;
                yPoints[1] = y + fon.getHeight();
            }

            n = 4;
        }
        if(yLoc < y && xLoc < x
                || yLoc > y + fon.getHeight() && xLoc > x + fon.getWidth()){
            MyWorld.connectionImage.drawLine(xLoc, yLoc,x+fon.getWidth(),y);
            MyWorld.connectionImage.drawLine(xLoc, yLoc,x,y+fon.getHeight());

            xPoints[0] = x + fon.getWidth();
            xPoints[2] = x;

            yPoints[0] = y;
            yPoints[2] = y + fon.getHeight();

            if(Math.pow(xLoc - x, 2) + Math.pow(yLoc - y, 2) < Math.pow(xLoc - (x + fon.getWidth()), 2) + Math.pow(yLoc - (y + fon.getHeight()), 2)){
                xPoints[1] = x;
                yPoints[1] = y;
            }
            else{
                xPoints[1] = x + fon.getWidth();
                yPoints[1] = y + fon.getHeight();
            }

            n = 4;
        }
        //up
        if(yLoc<=y && xLoc>=x && xLoc<=x+fon.getWidth()){
            MyWorld.connectionImage.drawLine(xLoc, yLoc,x,y);
            MyWorld.connectionImage.drawLine(xLoc, yLoc,x+fon.getWidth(),y);

            xPoints[0] = x;
            xPoints[1] = x + fon.getWidth();

            yPoints[0] = y;
            yPoints[1] = y;

            n = 3;
        }
        //down
        if(yLoc>=y+fon.getHeight() && xLoc>=x && xLoc<=x+fon.getWidth()){
            MyWorld.connectionImage.drawLine(xLoc, yLoc,x,y+fon.getHeight());
            MyWorld.connectionImage.drawLine(xLoc, yLoc,x+fon.getWidth(),y+fon.getHeight());

            xPoints[0] = x;
            xPoints[1] = x + fon.getWidth();

            yPoints[0] = y + fon.getHeight();
            yPoints[1] = y + fon.getHeight();

            n = 3;
        }
        //left
        if(yLoc<=y+fon.getHeight() && yLoc>=y && xLoc<=x){
            MyWorld.connectionImage.drawLine(xLoc, yLoc,x,y);
            MyWorld.connectionImage.drawLine(xLoc, yLoc,x,y+fon.getHeight());

            xPoints[0] = x;
            xPoints[1] = x;

            yPoints[0] = y;
            yPoints[1] = y + fon.getHeight();

            n = 3;
        }
        //right
        if(yLoc<=y+fon.getHeight() && yLoc>=y && xLoc>=x+fon.getWidth()){
            MyWorld.connectionImage.drawLine(xLoc, yLoc,x+fon.getWidth(),y);
            MyWorld.connectionImage.drawLine(xLoc, yLoc,x+fon.getWidth(),y+fon.getHeight());

            xPoints[0] = x + fon.getWidth();
            xPoints[1] = x + fon.getWidth();

            yPoints[0] = y;
            yPoints[1] = y + fon.getHeight();

            n = 3;
        }

        if(n - 1 > 0) {
            xPoints[n - 1] = xLoc;
            yPoints[n - 1] = yLoc;
        }

        MyWorld.connectionImage.drawRect(x - 1, y - 1, fon.getWidth() + 1, fon.getHeight() + 1);

        MyWorld.connectionImage.setColor(new Color(c.getRed(), c.getGreen(), c.getBlue(), 100));
        MyWorld.connectionImage.fillPolygon(xPoints, yPoints, n);

        x += getImage().getWidth() / 2;
        y += getImage().getHeight() / 2;
    }

    public void drawResConnections(ArrayList<Structure> structures){
        for (Structure structure : structures) {
            MyWorld.connectionImage.setColor(new Color(82, 80, 255, 255));
            structure.drawLines(structure.fon, new Color(82, 80, 255, 255), x + (fon.getWidth() / 2), y + (fon.getHeight() / 2));
            //MyWorld.myImage.drawLine((x+getImage().getWidth()*5),(y+getImage().getWidth()*5),(structures.get(i).x+structures.get(i).getImage().getWidth()*5),(structures.get(i).y+structures.get(i).getImage().getWidth()*5)+1);
        }
    }

    public void drawConnections(ArrayList<Structure> strList){
        for (Structure value : strList) {
            MyWorld.connectionImage.setColor(new Color(244, 189, 0, 255));
            MyWorld.connectionImage.drawLine(x, y, value.x, value.y);
            //value.drawLines(value.fon, new Color(82, 80, 255, 255), x + (fon.getWidth() / 2), y + (fon.getHeight() / 2));
            //MyWorld.myImage.drawLine((x+getImage().getWidth()*5),(y+getImage().getWidth()*5),(structures.get(i).x+structures.get(i).getImage().getWidth()*5),(structures.get(i).y+structures.get(i).getImage().getWidth()*5)+1);
        }
    }

    public void drawConnections1(ArrayList<Node> strList){
        for (Node node : strList) {
            MyWorld.connectionImage.setColor(new Color(244, 189, 0, 255));
            MyWorld.connectionImage.drawLine(x, y, node.x, node.y);
            //node.drawLines(node.fon, new Color(82, 80, 255, 255), x + (fon.getWidth() / 2), y + (fon.getHeight() / 2));
            //MyWorld.myImage.drawLine((x+getImage().getWidth()*5),(y+getImage().getWidth()*5),(structures.get(i).x+structures.get(i).getImage().getWidth()*5),(structures.get(i).y+structures.get(i).getImage().getWidth()*5)+1);
        }
    }

    public void drawCircle(Color color, int radius, ArrayList<Structures> structures){
        /*circle.setColor(Color.BLACK);
        circle.drawOval(0,0,radius*2,radius*2);
        circle.drawOval(2,2,radius*2-4,radius*2-4);*/
        //fonwC.setColor(new Color(0,0,0,0));
        //fonwC.fillOval(getX()-radius+2,getY()-radius+2,(radius*2)-4,(radius*2)-4);
        if(radius > 0) {
            MyWorld.connectionImage.setColor(color);
            MyWorld.connectionImage.drawOval(x - radius, y - radius, radius * 2, radius * 2);
            MyWorld.connectionImage.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), 100));
            for (Structures structure : structures) {
                structure.drawLines(structure.fon, color, x, y);
                //MyWorld.myImage.drawLine((x+getImage().getWidth()*5),(y+getImage().getWidth()*5),(structures.get(i).x+structures.get(i).getImage().getWidth()*5),(structures.get(i).y+structures.get(i).getImage().getWidth()*5)+1);
            }
        }
    }
}
