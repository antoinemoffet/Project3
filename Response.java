
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Option2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Response extends Actor
{
    /**
     * Act - do whatever the Option2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private boolean isCorrect;
    public Response(){
    }
    public Response(boolean trueFalse, boolean correctAns){
        if (trueFalse==true){
            setImage("True.PNG");
        }
        else {
            setImage("False.PNG");
        }
        
        isCorrect=correctAns;
    }
    public void setOption(boolean isCorrect){
        this.isCorrect=isCorrect;
    }
    public void setTrueFalse(boolean logic){
        if (logic==true){
            setImage("true.png");
        }
        else{
            setImage("false.png");
        }
    }
    public void act() 
    {
        // Add your action code here.
        if (Greenfoot.mouseClicked(this)){
            MyWorld m  = (MyWorld) getWorld();
            m.nextQuestion();
        }
 
    }    
}
