import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class GameOver extends Actor{
    public GameOver(){

    }
    public void act(){
        if (Greenfoot.mouseClicked(this)){
            Menu menu = new Menu();
            Greenfoot.setWorld(menu);
        }
    }
}
