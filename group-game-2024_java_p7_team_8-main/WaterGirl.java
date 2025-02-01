import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class WaterGirl extends Player{
    public boolean onPool(){
        boolean stat = false;
        double safeY = getExactY();
        setLocation(getExactX(), safeY + Level1.gs/2);
        if ((isTouching(RedPool.class) || isTouching(GreenPool.class)) && !isJumping){
            stat = true;
        }
        setLocation(getExactX(), safeY);
        return stat;
    }
    public int getDirection(){
        // 1 = left, 2 = right, 3 = up
        if (Greenfoot.isKeyDown("W")){
            return 3;
        }
        if (Greenfoot.isKeyDown("A")){
            return 1;
        }
        if (Greenfoot.isKeyDown("D")){
            return 2;
        }
        return 0;
    }
    public boolean checkDoor(){
        return isTouching(BlueDoor.class);
    }
}
