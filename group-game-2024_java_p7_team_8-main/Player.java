import greenfoot.*;
import java.util.List;

public class Player extends SmoothMover{
    Wall wall = new Wall();
    double g = 0.5;
    double dx;
    double dy;
    double maxDx = 4;
    double maxDy = -5;
    boolean isJumping = true; // just for wall detection
    boolean noAct = false;
    GreenfootSound jump = new GreenfootSound("jump.mp3");
    GreenfootSound scream = new GreenfootSound("scream.mp3");
    int screamCount = 0;
    GreenfootSound levelOver = new GreenfootSound("levelOver.mp3");
    int levelOverCount = 0;

    public void act(){
        int direction = getDirection();
        int wallLevel = getwallLevel(); 
        boolean onWall = (getExactY() >= wallLevel && getExactY() <= wallLevel + wall.getImage().getHeight());
        
        // position adjustment if at the world border
        if (getExactX() - getImage().getWidth()/2 <= 0){
            setLocation(getImage().getWidth()/2, getExactY());
        }
        if (getExactX() + getImage().getWidth()/2 >= getWorld().getWidth()){
            setLocation(getWorld().getWidth() - getImage().getWidth()/2, getExactY());
        }
        // check pool
        if (onPool()){
            // Scream and level over
            playScream();
            playLevelOver();
            // Replay Button
            ReplayButton r = new ReplayButton();
            getWorld().addObject(r, getWorld().getWidth()/2, getWorld().getHeight()/2 + r.getImage().getHeight()*3);
            // Restart
            if (Greenfoot.mouseClicked(r)){
                if(getLevelWorld() == 1){
                    Level1 l1 = new Level1();
                    Greenfoot.setWorld(l1);
                }else if(getLevelWorld() == 2){
                    Level2 l2 = new Level2();
                    Greenfoot.setWorld(l2); 
                }else if(getLevelWorld() == 3){
                    Level3 l3 = new Level3();
                    Greenfoot.setWorld(l3);
                }
            }  
            // Game Over Sign
            GameOver gameOver = new GameOver();
            getWorld().addObject(gameOver, getWorld().getWidth()/2, getWorld().getHeight()/2);
            noAct = true;
        }
        // if the game is not over
        if (!noAct){
            Actor elevator = getOneIntersectingObject(Elevator.class);
            if (isTouching(Elevator.class)){
                int feetLevel = getY() + getImage().getHeight()/2;
                int elevHeight = elevator.getImage().getHeight();
                // adjust if player feet is touching elevator
                if (direction == 0 && feetLevel <= elevator.getY() + elevHeight/2 && feetLevel >= elevator.getY() - elevHeight/2){
                    setLocation(getExactX(), elevator.getY() - elevHeight/2 - getImage().getHeight()/2);
                }
            }
            if (onWall) {
                // position && input adjustment if on wall
                if (direction == 3){ // jump
                    dy = maxDy;
                    isJumping = true;
                    playJump();
                } else {
                    dy = 0;
                    isJumping = false;
                    if (direction == 1 && isClear(1)){ // left
                        dx = -maxDx;
                    } else if (direction == 2 && isClear(2)){ // right
                        dx = maxDx;
                    } else {
                        dx = 0;
                    }
                }
                // move accordingly
                setLocation(getExactX() + dx, wallLevel + dy);
            } else { // all other situations
                // falling down
                isJumping = true;
                dy += g;
                setLocation(getExactX() + dx, getExactY() + dy);
                if (isClear(4) && !isJumping) {
                    setLocation(getExactX(), wallLevel);
                    Greenfoot.getKey();
                    isJumping = false;
                }
            }
        }
    }

    public int getLevelWorld(){
        int world = 0;
        Level1 leve1 = new Level1();
        Level2 leve2 = new Level2();
        Level3 leve3 = new Level3();
        if(getWorld() == leve1){
            world =  1;
        }else if(getWorld() == leve2){
            world = 2;
        }else if(getWorld() == leve3){
            world = 3;
        }else{
            world = 0;
        }
        return world;
    }

    public void playLevelOver() {
        if(levelOverCount == 0) {
            levelOver.play();
        }
        levelOverCount++;
    }

    public void playScream() {
        if(screamCount == 0) {
            scream.play();
        } 
        screamCount++;
    }

    public void playJump() {
        jump.play();
    }

    public boolean isClear(int direction){
        Actor rightWall = getOneObjectAtOffset(getImage().getWidth()/2 + (int) maxDx, 0, Wall.class);
        Actor leftWall = getOneObjectAtOffset(-getImage().getWidth()/2 - (int) maxDx, 0, Wall.class);
        Actor bottomWall = getOneObjectAtOffset(0, getImage().getHeight()/2 + (int) maxDy, Block.class);
        if (direction == 1){
            return leftWall == null;
        } else if (direction == 2){
            return rightWall == null;
        } else if (direction == 4){
            return bottomWall == null;
        }
        return false;
    }

    public int getwallLevel(){
        double safeY = getExactY();
        double check = 0.5;
        while (!isTouching(Wall.class)){
            setLocation(getExactX(), getExactY() + check);
        }
        Actor wall = getOneIntersectingObject(Wall.class);
        setLocation(getExactX(), safeY);
        return wall.getY() - getImage().getHeight()/2 - wall.getImage().getHeight()/2;
    }

    public int getDirection(){
        return 0;
    }

    public boolean checkDoor(){
        return false;
    }

    public boolean getIsJumping(){
        return isJumping;
    }

    public boolean onPool(){
        return false;
    }
} 