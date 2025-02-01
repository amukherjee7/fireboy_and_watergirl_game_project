import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hud here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hud extends Actor{
    GreenfootImage hud;
    
    int collectedGem = 0;
    int gemNum = 0;
    boolean start = true;
    
    public Hud(){
        hud = new GreenfootImage(300, 16);
        hud.setColor(Color.BLACK);
        hud.fill();
        setImage(hud);
        Font font = new Font(16);
        getImage().setFont(font);
        getImage().setColor(Color.WHITE);
        getImage().drawString("Gems: " + collectedGem + "/" + gemNum, 0, 16);
    }
    public void act(){
        if (start){
            gemNum = getWorld().getObjects(Gem.class).size();
            start = false;
        }
        collectedGem = gemNum - getWorld().getObjects(Gem.class).size();
        // getImage().drawString("Gems: " + collectedGem + "/" + gemNum, 0, 0);
        updateImage();
    }
    public void updateImage(){
        hud.setColor(Color.BLACK);
        hud.fill();
        setImage(hud);
        Font font = new Font(16);
        getImage().setFont(font);
        getImage().setColor(Color.WHITE);
        getImage().drawString("Gems: " + collectedGem + "/" + gemNum, 0, 16);
    }
}
