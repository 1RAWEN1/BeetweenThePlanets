import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class StructuresList here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StructuresList extends Actor
{
    /**
     * Act - do whatever the StructuresList wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    Cell cell;
    Cell cells[][]=new Cell [5][5];
    int cellsType[][]={
        {0, 0, 0, 1, 2},
        {0, 0, 0, 3, 4},
        {0, 0, 0, 5, 6},
        {0, 0, 0, 7, 8},
        {0, 0, 0, 9, 10},
    };
    int x;
    int y;
    int start;
    ArrayList<Integer> foundStr[]=new ArrayList[10];
    public StructuresList(){
        for(int i=0;i<10;i++){
            foundStr[i]=new ArrayList<>();
        }
        setMyImage();
    }
    public void act() 
    {
        if(start==0){
            haveStr();
            addCells();
            start=1;
        }
        // Add your action code here.
    }  
    public void haveStr(){
        for(int i1=0; Player.myStructures.size()>i1;i1++){
            foundStr[(Player.myStructures.get(i1) - 10)/15].add(Player.myStructures.get(i1));
        }
    }
    public void setMyImage(){
        GreenfootImage myImage=new GreenfootImage(200, 200);
        myImage.setColor(Color.WHITE);
        myImage.fill();
        myImage.setColor(new Color(120, 120, 120, 255));
        //myImage.setColor(new Color(244, 189,0 , 255));
        myImage.drawRect(0,0,myImage.getWidth()-1, myImage.getHeight()-1);
        myImage.drawRect(1,1,myImage.getWidth()-3, myImage.getHeight()-3);
        myImage.drawLine(119,2,119, myImage.getHeight()-3);
        myImage.drawLine(120,2,120, myImage.getHeight()-3);
        setImage(myImage);
    }
    public void addCells(){
        x=20;
        y=20;
        while(y<200){
            cell=new Cell(cellsType[y/40][x/40], this);
            getWorld().addObject(cell, getX()-(100-x), getY()-(100-y));
            cells[y/40][x/40]=cell;
            x+=40;
            if(x>=200){
                y+=40;
                x=20;
            }
        }
    }
}
