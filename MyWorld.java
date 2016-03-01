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
    //private String gameTitle[] = {"y" , "f" , "t", "f"};
    private int i;
    //private String gameTitle[]={"P","e","r","s","e","i","d","s"};
    //private String gameSubTitle[]={"R","e","m","i","x"};
    //private int letterX[]={89,140, 178,216,259,298,334,382};
    //private int letterY[]={ 81, 107, 77, 108, 81, 105, 80,105};
    //private int letterSX[]={394, 452,  516,  569,  603};
    //private int letterSY[]={ 452,  485,  456, 475,  446};
    

    /**
     * Constructor for objects of class SpaceWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        
        prepare ();
    }
    
    public ScoreBoard getScoreBoard()
    {
        return scoreboard;
    }
    
    private void prepare()
    {
        scoreboard = new ScoreBoard();
        addObject(scoreboard, 103, 51);
        q1 = new Q1();
        addObject(q1, 103, 51);        
        //addObject(gameTitle, 200, 500);
        
    }
    
    //public void addGameTitle()
    //{
        //for (i=0;i<gameTitle.length;i++) {
          //  Letter l = new Letter(gameTitle[i],letterX[i],letterY[i]); 
            //addObject(l, letterX[i],letterY[i]);
        //}
        //Greenfoot.delay(30);
        //for (i=0;i<gameSubTitle.length;i++) {
          //  Letter l = new Letter(gameSubTitle[i],letterSX[i],letterSY[i]); 
            //addObject(l, letterSX[i],letterSY[i]);
        //}
    //}
}
