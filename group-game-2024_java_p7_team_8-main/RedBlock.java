import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
 class RedBlock extends Wall{
    public void act(){
        getImage().scale(30,30);
        setImage(getImage());
    }    
}
