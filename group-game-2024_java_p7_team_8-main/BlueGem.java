import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class BlueGem extends Gem{
    GreenfootSound gem = new GreenfootSound("gem.mp3");
    int gemCount = 0;
    public void act() {
        if(isTouching(WaterGirl.class)) {
            playGem();
            getWorld().removeObject(this);
        }
    }
    
    public void playGem() {
        if(gemCount == 0) {
            gem.play();
        } 
        gemCount++;
    }
}
