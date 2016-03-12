import greenfoot.*;

/**
 * Write a description of class Q1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Question extends Actor
{
    /**
     * The constructor loads the appropriate image, and sets
     * the logic for whether or not the question is correct or not.
     * The true/false logic is read from the answers.txt file, and
     * those answers must match corresponding images that will be
     * named "q0.png", "q1.png", etc
     */
    Response option1;
    Response option2;
    private boolean clickable;
     public Question(){
        setImage("astromath.png");
        clickable=true;
    }
    public Question(int qNum, boolean isCorrect){
   
   String question="q"+qNum+".png";
   MyWorld m  = (MyWorld) getWorld();
   option1=m.getOption1();
   option2=m.getOption2(); 
    getWorld().showText("bla",100,100);
    setImage(question);
    clickable=false;
 
}
     /**
     * Act - do whatever the Q1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */    
    public void act() 
    {
        // Add your action code here.
        if (clickable){
            if(Greenfoot.mouseClicked(this)){
              setQuestion(0);
            }
        }
    }    
    public void setQuestion(int qNum){
        setImage("q"+qNum+".png");
        MyWorld m  = (MyWorld) getWorld();
        m.setAnswer(qNum);
        clickable=false;
    }
}
