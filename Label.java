import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * A Label class that allows you to display a textual value on screen.
 * 
 * The Label is an actor, so you will need to create it, and then add it to the world
 * in Greenfoot.  If you keep a reference to the Label then you can change the text it
 * displays.  
 *
 * @author Amjad Altadmri 
 * @version 1.1
 */
public class Label extends Actor
{
    int type;
    int typeres;
    GreenfootImage coal=new GreenfootImage("coal.png");
    GreenfootImage iron=new GreenfootImage("iron.png");
    GreenfootImage lead=new GreenfootImage("lead.png");
    GreenfootImage sand=new GreenfootImage("sand.png");
    
    private String value;
    private int fontSize;
    private Color lineColor = Color.BLACK;
    private Color fillColor = Color.WHITE;
    
    private static final Color transparent = new Color(0,0,0,0);

    /**
     * Create a new label, initialise it with the int value to be shown and the font size 
     */
    public Label(int value, int fontSize)
    {
        //this(Integer.toString(value), fontSize);
    }
    
    /**
     * Create a new label, initialise it with the needed text and the font size 
     */
    public Label(String value, int fontSize, int type1)
    {
        this.value = value;
        this.fontSize = fontSize;
        type=type1;
        updateImage();
    }

    /**
     * Sets the value  as text
     * 
     * @param value the text to be show
     */
    public void setValue(String value)
    {
        this.value = value;
        updateImage();
    }
    
    /**
     * Sets the value as integer
     * 
     * @param value the value to be show
     */
    public void setValue(int value)
    {
        this.value = Integer.toString(value);
        updateImage();
    }
    
    /**
     * Sets the line color of the text
     * 
     * @param lineColor the line color of the text
     */
    public void setLineColor(Color lineColor)
    {
        this.lineColor = lineColor;
        updateImage();
    }
    
    /**
     * Sets the fill color of the text
     * 
     * @param fillColor the fill color of the text
     */
    public void setFillColor(Color fillColor)
    {
        this.fillColor = fillColor;
        updateImage();
    }
    

    /**
     * Update the image on screen to show the current value.
     */
    private void updateImage()
    {
        GreenfootImage myImage=new GreenfootImage(value, fontSize, fillColor, transparent, lineColor);
        GreenfootImage myImage1=new GreenfootImage(value, fontSize, fillColor, transparent, lineColor);
        myImage.clear();
        if(myImage.getWidth()<myImage.getHeight()){
            myImage=new GreenfootImage(myImage.getHeight(), myImage.getHeight());
        }
        if(type==1){
            if(typeres==1){
                coal.scale(myImage.getHeight(), myImage.getHeight());
                myImage.drawImage(coal, myImage.getWidth()/2-coal.getWidth()/2, 0);
            }
            else if(typeres==2){
                iron.scale(myImage.getHeight(), myImage.getHeight());
                myImage.drawImage(iron, myImage.getWidth()/2-iron.getWidth()/2, 0);
            }
            else if(typeres==3){
                lead.scale(myImage.getHeight(), myImage.getHeight());
                myImage.drawImage(lead, myImage.getWidth()/2-lead.getWidth()/2, 0);
            }
            else if(typeres==4){
                sand.scale(myImage.getHeight(), myImage.getHeight());
                myImage.drawImage(sand, myImage.getWidth()/2-lead.getWidth()/2, 0);
            }
        }
        myImage.drawImage(myImage1,  myImage.getWidth()/2-myImage1.getWidth()/2, 0);
        setImage(myImage);
    }
}