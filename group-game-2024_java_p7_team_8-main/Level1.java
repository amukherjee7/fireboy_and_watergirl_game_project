import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Level1 extends BuldingWorlds {
    //grid size 
    public static final int gs = 24;
    FireBoy fb = new FireBoy();
    WaterGirl wg = new WaterGirl();
    GreenfootImage hud;
    GreenfootSound levelMusic;
    GreenfootSound nextLevel = new GreenfootSound("nextLevel.mp3");
    int nextLevelCount = 0;

    public Level1(){    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        GreenfootImage bg = new GreenfootImage(600, 480);
        Color color = Color.BLACK;
        bg.fillRect(0, 0, 600, 480);
        setBackground(bg);
        
        Hud hud = new Hud();
        addObject(hud, hud.getImage().getWidth()/2, 8);

        //walls and platforms
        //horizWalls(26, 0, gs/2);
        buildWall();

        //pools
        redPools(1, 14*gs, getHeight()-gs/2);
        bluePools(1, 19*gs, getHeight()-gs/2);
        greenPools(1, 14*gs, getHeight()-4*gs);

        //doors
        BlueDoor bd = new BlueDoor();
        addObject(bd, getWidth()-gs, bd.getImage().getHeight()/2 + gs);
        RedDoor rd = new RedDoor();
        addObject(rd, getWidth()-gs-rd.getImage().getWidth(), rd.getImage().getHeight()/2 + gs);

        //gems
        RedGem rg = new RedGem();
        addObject(rg, 14*gs, getHeight()-(gs/2+gs));

        BlueGem blueG = new BlueGem();
        addObject(blueG, 19*gs, getHeight()-(gs+gs/2));

        //player
        addObject(fb, getWidth()/3, getHeight() - gs*13/2);
        addObject(wg, getWidth()/4, getHeight() - gs*13/2);

        //elevator
        Elevator elevator1 = new Elevator(gs*4, getHeight() - (11*gs)/2, 
                gs*5, getHeight() - (17*gs)/2, 3);
        addObject(elevator1, gs, getHeight() - (11*gs/2));

        Elevator elevator2 = new Elevator(getWidth() - gs*2, getHeight() - (9*gs) + gs/2, 
                getWidth() - gs*8, getHeight() - (12*gs) + gs/2, 3);
        addObject(elevator2, getWidth() - gs*4, getHeight() - (17*gs/2)); 

        Elevator elevator3 = new Elevator(gs*8, getHeight() - gs, getWidth() - gs*5, getHeight() - gs*4 - gs/2, 3);
        addObject (elevator3, getWidth()-gs*3, getHeight()-gs);
        
        Elevator elevator4 = new Elevator(gs*6, getHeight() - gs*13 + gs/2, getWidth() - gs*13, getHeight() - gs*15 + gs/2, 3);
        addObject(elevator4, gs*17/2, getHeight() - gs*12 + gs/2);
        
        levelMusic = new GreenfootSound("level_music.mp3");
        levelMusic.playLoop();
    }

    public void act(){
        if(wg.checkDoor() && fb.checkDoor()){
            playNextLevel();
            Level2 lev2 = new Level2(levelMusic);
            Greenfoot.setWorld(lev2);
        }
    }
    
    public void playNextLevel() {
        if(nextLevelCount == 0) {
            nextLevel.play();
        }
        nextLevelCount++;
    }

    public void buildWall(){
        horizWalls(14, 0, getHeight()-gs/2);
        horizWalls(4, 15*gs, getHeight()-gs/2);
        horizWalls(6, 20*gs, getHeight()-gs/2);
        horizWalls(2, 24*gs, getHeight()-gs*3/2); 
        horizWalls(5, 0, getHeight()-(3*gs/2));
        horizWalls(12, 10*gs, getHeight()-(4*gs));
        horizWalls(10, gs/2, getHeight()-(5*gs));
        horizWalls(26, 3*gs, getHeight()-8*gs);
        horizWalls(20, 0, getHeight()-11*gs);
        horizWalls(8, 0, getHeight()-12*gs);
        horizWalls(16, 10*gs, getHeight()-14*gs);
    }

}
