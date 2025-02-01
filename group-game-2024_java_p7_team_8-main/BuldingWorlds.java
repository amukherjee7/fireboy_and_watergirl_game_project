import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class BuldingWorlds extends World{
    public BuldingWorlds(){    
        super(600, 400, 1); 
    }
        public void horizWalls(int numWalls, int x, int y) {
        int dx = 0;
        for(int i=0; i<numWalls; i++) {
            Block b = new Block();
            addObject(b, x+dx, y);
            dx+=b.getImage().getWidth();
        }
    }
    public void verticWalls(int numWalls, int x, int y) {
        int dy = 0;
        for(int i=0; i<numWalls; i++) {
            RedBlock rb = new RedBlock();
            addObject(rb, x, y+dy);
            dy+=rb.getImage().getHeight();
        }
    }
    public void grid(int numWalls, int numRows, int x, int y) {
        int dy = 0;
        Block b = new Block();
        for(int i=0; i<numRows; i++) {
            horizWalls(numWalls, x, y+dy);
            dy+=b.getImage().getHeight();
        }
    }
    public void redPools(int numRedPools, int x, int y) {
        int dx = 0;
        for(int i=0; i<numRedPools; i++) {
            RedPool rp = new RedPool();
            addObject(rp, x+dx, y);
            dx+=rp.getImage().getWidth();
        }
    }
    public void bluePools(int numBluePools, int x, int y) {
        int dx = 0; 
        for(int i=0; i<numBluePools; i++) {
            BluePool bp = new BluePool();
            addObject(bp, x+dx, y);
            dx+=bp.getImage().getWidth();
        }
    }
    public void greenPools(int numGreenPools, int x, int y) {
        int dx = 0;
        for(int i=0; i<numGreenPools; i++) {
            GreenPool gp = new GreenPool();
            addObject(gp, x+dx, y);
            dx+=gp.getImage().getWidth();
        }
    }
}

