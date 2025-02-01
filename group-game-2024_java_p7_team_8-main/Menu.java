import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Menu extends World{
    Title title;
    Play play;
    GreenfootSound menuMusic;
    public Menu(){    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        getBackground().scale(600,400);
        this.setBackground("background.png");
        
        title = new Title();
        addObject(title, getWidth()/2, getHeight()/2 - title.getImage().getHeight()/2);
        play = new Play();
        addObject(play, getWidth()/2, getHeight()*4/5);
        
        menuMusic = new GreenfootSound("main_menu.mp3");
        menuMusic.play();
    }
    public void act(){
        if (Greenfoot.mouseClicked(play)){
            Instruction inst = new Instruction(menuMusic);
            Greenfoot.setWorld(inst);
        }
    }
}
