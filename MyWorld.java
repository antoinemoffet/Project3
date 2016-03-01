import greenfoot.*;

/**
 * Write a description of class SpaceWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private ScoreBoard scoreboard;
    private Q1 q1;
    private Option1 option1;
    private Option2 option2;
    //private String gameTitle[] = {"y" , "f" , "t", "f"};
    private int i;

    /**
     * Constructor for objects of class SpaceWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        
        /**
         * Makes the objects under the prepare method to already become visible in
         * the world. 
         */        
        prepare();
    }
    
    public ScoreBoard getScoreBoard()
    {
        return scoreboard;
    }
    
    /**
     * Instantiates memory for the objects and displays, in the world, with respect 
     * to the coordinates
     */
    private void prepare()
    {
        scoreboard = new ScoreBoard();
        addObject(scoreboard, 103, 51);
        q1 = new Q1();
        addObject(q1, 400, 200);
        option1 = new Option1();
        addObject(option1, 200, 300);
        option2 = new Option2();
        addObject(option2, 550, 300);  
        //addObject(gameTitle, 200, 500);
        
    }
    
}
