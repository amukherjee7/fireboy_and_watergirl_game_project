import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Instruction extends BuldingWorlds{
    Play play;
    InstructionTitle ITitle;
    Block b;
    RedBlock rb;
    GreenfootSound music;
    public Instruction(GreenfootSound music){    
        GreenfootImage background = new GreenfootImage(getWidth()/2, getHeight());
        background.setColor(Color.BLACK);
        background.fill();
        setBackground(background);
        //Brick Design
        b= new Block();
        rb = new RedBlock();
        horizWalls((getWidth()/b.getImage().getWidth())+b.getImage().getWidth(),0, 0);
        horizWalls((getWidth()/b.getImage().getWidth())+b.getImage().getWidth(),0, getHeight());
        verticWalls(getHeight()/rb.getImage().getHeight()+rb.getImage().getHeight(), 0, 0);
        verticWalls(getHeight()/rb.getImage().getHeight()+rb.getImage().getHeight(), getWidth(), 0);
        //Play Button
        play = new Play();
        addObject(play, getWidth()/2, getHeight()*2/4+getHeight()/3);
        //Instruction Title Image
        ITitle = new InstructionTitle();
        addObject(ITitle, getWidth()/2, ITitle.getImage().getHeight());
        //Instructions
        GreenfootImage instructions = new GreenfootImage(50,50);
        getBackground().setFont(new Font("Arial",17));
        getBackground().setColor(Color.WHITE);
        
        getBackground().drawString("Water Girls Keys:Right => D Left => A Up => W", rb.getImage().getWidth(), getHeight()/4);
        getBackground().drawString("Fire Boy Keys: Right => Right Arrow Left => Left Arrow Up => Up Arrow",rb.getImage().getWidth(), getHeight()/3);
        //Pool Instructions
        getBackground().drawString("FireBoy Must Avoid All Water Pools!",rb.getImage().getWidth(), getHeight()/2);
        getBackground().drawString("WaterGirl Must Avoid All Fire Pools!",rb.getImage().getWidth(), getHeight()/2+ getHeight()/16);
        getBackground().drawString("They Both Must Avoid The Green Pools!",rb.getImage().getWidth(), getHeight()/2+getHeight()/16+getHeight()/16);
        //Pools
        BluePool bp = new BluePool();
        RedPool rp = new RedPool();
        GreenPool gp = new GreenPool();
        addObject(bp,rb.getImage().getWidth()+bp.getImage().getWidth(), getHeight()/2+getHeight()/16+getHeight()/16+15);
        addObject(rp,rb.getImage().getWidth()+bp.getImage().getWidth()+bp.getImage().getWidth()*2, getHeight()/2+getHeight()/16+getHeight()/16+15);
        addObject(gp,rb.getImage().getWidth()+bp.getImage().getWidth()+bp.getImage().getWidth()*2+bp.getImage().getWidth()*2, getHeight()/2+getHeight()/16+getHeight()/16+15);
        //Gem Instructions
        getBackground().drawString("Get To Doors As Fast As Possible And Collect All Gems!",rb.getImage().getWidth(), getHeight()/2+getHeight()/8+getHeight()/8);
        //Gems 
        BlueGem bg = new BlueGem();
        RedGem rg = new RedGem();
        addObject(bg,getWidth()/2+getWidth()/3, getHeight()/2 +getHeight()/4-8);
        addObject(rg,getWidth()/2+getWidth()/4+rg.getImage().getWidth(), getHeight()/2 +getHeight()/4 - 8);
        this.music = music;
    }
    public Instruction(){
    }
    public void act(){
        if (Greenfoot.mouseClicked(play)){
            this.music.stop();
            Level1 lev1 = new Level1();
            Greenfoot.setWorld(lev1);
        }     
    }
}
