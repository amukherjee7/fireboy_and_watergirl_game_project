import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Button extends Actor{
    public Boolean isPressed = false;
    public Button(){
        GreenfootImage button = new GreenfootImage(10, 5);
        button.setColor(greenfoot.Color.YELLOW);
        button.fill();
        setImage(button);
    }
    public void act(){
        if (isTouching(Player.class)){
            isPressed = true;
        } else {
            isPressed = false;
        }
    }
    public boolean returnIsPressed(){
        return isPressed;
    }
}
