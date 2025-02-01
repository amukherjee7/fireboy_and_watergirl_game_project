import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Elevator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Elevator extends Wall{
    boolean initiate = true;
    int startY;
    int maxY;
    int speed = 1;
    int height;
    boolean goingDown = false;
        
    Button button1 = new Button();
    Button button2 = new Button();
    int bx1;
    int by1;
    int bx2;
    int by2;
    public Elevator(int x1, int y1, int x2, int y2, int gs){
        GreenfootImage elevator = new GreenfootImage(24, 390/40);
        elevator.setColor(greenfoot.Color.GRAY);
        elevator.fill();
        setImage(elevator);        
        bx1 = x1;
        by1 = y1;
        bx2 = x2;
        by2 = y2;
        height = gs;
    }
    public void act(){
        // just for getting the first Y position
        if (initiate){
            startY = getY();
            initiate = false;
            getWorld().addObject(button1, bx1, by1);
            getWorld().addObject(button2, bx2, by2);
        }
        // moving up and down
        maxY = startY - Level1.gs * height; // grid size * 2
        boolean buttonStatus1 = button1.returnIsPressed();
        boolean buttonStatus2 = button2.returnIsPressed();
        if (buttonStatus1 || buttonStatus2){
            if (getY() > maxY){ // can move up if lower than maxY
                setLocation(getX(), getY() - speed);
                goingDown = false;
            }
        }
        // if button not pressed and a player isn't below, goes down until startY
        if ((!buttonStatus1 && !buttonStatus2) && getY() < startY){ 
            if (isTouching(Player.class)){
                Actor player1 = getOneIntersectingObject(FireBoy.class);
                Actor player2 = getOneIntersectingObject(WaterGirl.class);
                // stop if player below
                if (player1 != null && player2 != null){ 
                    if (player1.getY() < getY() && player2.getY() < getY()){
                        // if both at top go down
                        setLocation(getX(), getY() + speed);
                    } else if ((player1.getY() - player1.getImage().getHeight()/2 > getY() + getImage().getHeight()/2 + speed - 1) && 
                        (player2.getY() - player2.getImage().getHeight()/2 > getY() + getImage().getHeight()/2 + speed - 1)){
                        // if both player are bottom go down until it touches their head
                        setLocation(getX(), getY() + speed);
                    }
                } else if (player1 != null & player2 == null){
                    // only player1 touching
                    if (player1.getY() < getY()){
                        setLocation(getX(), getY() + speed);
                    } else {
                        setLocation(getX(), player1.getY() - player1.getImage().getHeight()/2 - getImage().getHeight()/2);
                    }
                } else if (player1 == null && player2 != null){
                    // only player2 touching
                    if (player2.getY() < getY()){
                        setLocation(getX(), getY() + speed);
                    } else {
                        setLocation(getX(), player2.getY() - player2.getImage().getHeight()/2 - getImage().getHeight()/2);
                    }
                }
            } else {
                setLocation(getX(), getY() + speed);
            }
            goingDown = true;
        } else {
            goingDown = false;
        }
    }
    public boolean isGoingDown(){
        return goingDown;
    }
    public int getStartY(){
        return startY;
    }
    public int getMaxY(){
        return maxY;
    }
    public boolean atStart(){
        return getY() == startY;
    }
    public boolean atMax(){
        return getY() == maxY;
    }
}
