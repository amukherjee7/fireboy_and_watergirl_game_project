import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Level2 extends BuldingWorlds {
    //grid size 
    public static final int gs = 24;
    FireBoy fb = new FireBoy();
    WaterGirl wg = new WaterGirl();
    GreenfootImage hud;
    GreenfootSound levelMusic;
    GreenfootSound nextLevel = new GreenfootSound("nextLevel.mp3");
    int nextLevelCount = 0;
    int val = 0;
    
    public Level2(GreenfootSound levelMusic){    
        GreenfootImage bg = new GreenfootImage(600, 480);
        Color color = Color.BLACK;
        bg.fillRect(0, 0, 600, 480);
        setBackground(bg);
        
        Hud hud = new Hud();
        addObject(hud, hud.getImage().getWidth()/2, 8);

        Block b = new Block();
        buildWall();

        //pools
        redPools(5, 6*gs, getHeight()-gs/2);
        bluePools(5, 6*gs, getHeight()-3*gs);
        redPools(5, 14*gs,getHeight()-gs/2);
        bluePools(5, 14*gs, getHeight()-3*gs);
        greenPools(3, gs*15, getHeight()-gs*9);

        //doors
        BlueDoor bd = new BlueDoor();
        addObject(bd, gs, bd.getImage().getHeight()/2 + gs);
        RedDoor rd = new RedDoor();
        addObject(rd, 2*gs, rd.getImage().getHeight()/2 + gs);

        // gems
        addGem();
        
        //player
        addObject(fb, gs, getHeight() - gs*2);
        addObject(wg, 6*gs, getHeight() - gs*5 + gs/2);

        //elevators
        Elevator elevator1 = new Elevator(getWidth() - gs*8, getHeight() - gs*4 + gs/2, 
                getWidth() - gs*3, getHeight() - gs*6, 5);
        addObject(elevator1, getWidth() - gs, getHeight() - gs);

        Elevator elevator2 = new Elevator(gs*5, getHeight()-gs*6, 
                                gs*6, getHeight()-19*gs/2, 3);
        addObject(elevator2, gs*2, getHeight()-6*gs);
        
        Elevator elevator3 = new Elevator(gs*20, getHeight()-gs*10+gs/2, 
                                gs*19, getHeight()-gs*15+gs/2, 5);
        addObject(elevator3, gs*23, getHeight()-19*gs/2);
        
        this.levelMusic = levelMusic;
        this.levelMusic.play();
    }
    public Level2(){
    }
    public void act(){
        if(wg.checkDoor() == true && fb.checkDoor() == true){
            playNextLevel();
            Level3 lev3 = new Level3(this.levelMusic);
            Greenfoot.setWorld(lev3);
        }
    }
    
    public void playNextLevel() {
        if(nextLevelCount == 0) {
            nextLevel.play();
        }
        nextLevelCount++;
    }
    
    public void addGem(){
        RedGem rg = new RedGem();
        addObject(rg, 15*gs, getHeight()-3*gs/2);
        RedGem rg1 = new RedGem();
        addObject(rg1, 17*gs, getHeight()-3*gs/2);
        RedGem rg2 = new RedGem();
        addObject(rg2, 7*gs, getHeight()-3*gs/2);
        RedGem rg3 = new RedGem();
        addObject(rg3, 9*gs, getHeight()-3*gs/2);
        RedGem rg4 = new RedGem();
        addObject(rg4, 7*gs, getHeight()-7*gs);
        RedGem rg5 = new RedGem();
        addObject(rg5, 11*gs, getHeight()-11*gs);
        
        BlueGem bGem = new BlueGem();
        addObject(bGem, 15*gs, getHeight()-4*gs);
        BlueGem bGem1 = new BlueGem();
        addObject(bGem1, 17*gs, getHeight()-4*gs);
        BlueGem bGem2 = new BlueGem();
        addObject(bGem2, 7*gs, getHeight()-4*gs);
        BlueGem bGem3 = new BlueGem();
        addObject(bGem3, 9*gs, getHeight()-4*gs);
        BlueGem bGem4 = new BlueGem();
        addObject(bGem4, 11*gs, getHeight()-7*gs);
        BlueGem bGem5 = new BlueGem();
        addObject(bGem5, 13*gs, getHeight()-11*gs);
    }
    
    public void buildWall(){
        horizWalls(26, 0, getHeight()-gs/2);
        horizWalls(23, 0, getHeight()-11*gs/2);
        horizWalls(6, gs*4, getHeight()-gs*9);
        horizWalls(5, gs*10, getHeight()-gs*9);
        horizWalls(5, gs*10, getHeight()-10*gs);
        horizWalls(8, gs*18, getHeight()-gs*9);
        //horizWalls(4, gs*22, getHeight()-gs*10);
        //horizWalls(3, gs*23, getHeight()-gs*11);
        horizWalls(10, gs*12, getHeight()-gs*14);
        //horizWalls(4, gs*16, getHeight()-13*gs);
        //horizWalls(3, gs*19, getHeight()-12*gs);
        horizWalls(9, 0, getHeight()-14*gs);
    }

}
