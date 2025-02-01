import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Level3 extends BuldingWorlds {
    //grid size 
    public static final int gs = 24;
    FireBoy fb = new FireBoy();
    WaterGirl wg = new WaterGirl();
    GreenfootImage hud;
    GreenfootSound levelMusic;
    GreenfootSound nextLevel = new GreenfootSound("nextLevel.mp3");
    int nextLevelCount = 0;
    
    public Level3(GreenfootSound levelMusic){    
        // background
        GreenfootImage bg = new GreenfootImage(600, 480);
        Color color = Color.BLACK;
        bg.fillRect(0, 0, 600, 480);
        setBackground(bg);
        
        // hud
        Hud hud = new Hud();
        addObject(hud, hud.getImage().getWidth()/2, 8);

        // blocks and pools
        buildWall();

        //doors
        BlueDoor bd = new BlueDoor();
        addObject(bd, getWidth()-gs*2, getHeight()-gs*5/2-gs/2-bd.getImage().getHeight()/2);
        RedDoor rd = new RedDoor();
        addObject(rd, gs, getHeight()-gs*2-rd.getImage().getHeight()/2);

        // gems
        RedGem rg1 = new RedGem();
        addObject(rg1, gs, getHeight()-gs*13/2);
        RedGem rg2 = new RedGem();
        addObject(rg2, gs*12, getHeight()-gs*29/2);
        RedGem rg3 = new RedGem();
        addObject(rg3, getWidth()-gs*4, getHeight()-gs*7/2);
        
        BlueGem bg1 = new BlueGem();
        addObject(bg1, gs*5, getHeight()-gs*23/2);
        BlueGem bg2 = new BlueGem();
        addObject(bg2, gs*5/2, getHeight()-gs*5/2);

        // player
        addObject(fb, getWidth()-gs, getHeight() - gs*13);
        addObject(wg, gs*4, getHeight() - gs*15/2);

        // elevator
        Elevator elevator1 = new Elevator(getWidth()-gs*5, getHeight()-gs*7, getWidth()-gs*12, getHeight()-gs*8, 6);
        addObject(elevator1, gs*15, gs*8 + elevator1.getImage().getWidth()*3/4);
        
        this.levelMusic = levelMusic;
        this.levelMusic.play();
    }
    public Level3(){
    }
    public void act(){
        if(wg.checkDoor() && fb.checkDoor()){
            playNextLevel();
            GameCompleted GC = new GameCompleted();
            Greenfoot.setWorld(GC);
        }
    }
    
    public void playNextLevel() {
        if(nextLevelCount == 0) {
            nextLevel.play();
        }
        nextLevelCount++;
    }
    
    public void buildWall(){
        horizWalls(4, 0, getHeight()-gs/2);
        greenPools(23, gs*4, getHeight()-gs/2);
        
        horizWalls(4, 0, getHeight()-gs*3/2);
        
        horizWalls(3, getWidth()/3, getHeight()-gs*5/2);
        horizWalls(7, getWidth()-gs*6, getHeight()-gs*5/2);
        
        horizWalls(3, getWidth()/2, getHeight()-gs*7/2);
        
        redPools(3, 0, getHeight()-gs*11/2);
        horizWalls(7, gs*3, getHeight()-gs*11/2);
        horizWalls(2, gs*8, getHeight()-gs*13/2);
        
        horizWalls(4, getWidth()-gs*3, getHeight()-gs*13/2);
        redPools(4, getWidth()-gs*7, getHeight()-gs*13/2);
        
        horizWalls(3, getWidth()-gs*2, getHeight()-gs*15/2);
        horizWalls(4, gs*12, getHeight()-gs*15/2);

        
        horizWalls(3, getWidth()-gs*2, getHeight()-gs*17/2);
        horizWalls(3, getWidth()-gs*2, getHeight()-gs*19/2);
        horizWalls(7, gs*4, getHeight()-gs*21/2);
        
        horizWalls(1, gs*10, getHeight()-gs*23/2);
        horizWalls(4, getWidth()-gs*3, getHeight()-gs*23/2);

        bluePools(4, gs*7, getHeight()-gs*25/2);
        horizWalls(3, gs*11, getHeight()-gs*27/2);
    }
}
