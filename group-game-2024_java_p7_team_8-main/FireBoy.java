import greenfoot.*; 

public class FireBoy extends Player {
    public boolean onPool(){
        boolean stat = false;
        double safeY = getExactY();
        setLocation(getExactX(), safeY + Level1.gs/2);
        if ((isTouching(BluePool.class) || isTouching(GreenPool.class)) && !isJumping){
            stat = true;
        }
        setLocation(getExactX(), safeY);
        return stat;
    }
    public int getDirection(){
        // 1 = left, 2 = right, 3 = up
        if (Greenfoot.isKeyDown("UP")){
            return 3;
        }
        if (Greenfoot.isKeyDown("LEFT")){
            return 1;
        }
        if (Greenfoot.isKeyDown("RIGHT")){
            return 2;
        }
        return 0;
    }
    public boolean checkDoor(){
        return isTouching(RedDoor.class);
    }
}
