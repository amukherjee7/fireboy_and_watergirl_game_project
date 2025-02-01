import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class GameCompleted extends World{
    public GameCompleted(){    
        super(600, 400, 1); 
        //Background
        GreenfootImage background = new GreenfootImage(getWidth()/2, getHeight());
        background.setColor(Color.BLACK);
        background.fill();
        setBackground(background);
        //You Win
        YouWon yw = new YouWon();
        addObject(yw,getWidth()/2,getHeight()/2);
    }
}
