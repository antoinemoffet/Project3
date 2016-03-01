
import greenfoot.*; // (World, Actor, GreenfootImage, and Greenfoot)
import java.awt.Color;
import java.awt.Font;
import java.util.Calendar;

/**
 * The ScoreBoard is used to display results on the screen. 
 * It can display sometext and several numbers.
 * 
 * @author M Kolling
 * Versio 1.0
 */
public class ScoreBoard extends Actor
{
    // Variables that are declared as "static final" are constants.  Their
    // value is set once, then never changed.
    public static final float FONT_SIZE = 24.0f;
    public static final int WIDTH = 200;
    public static final int HEIGHT = 100;
    public static final int MAXSCORE = 15; // If we get here, stop the game, set the title to "GAME OVER" and prefix to "You Won"
    public static final int MINSCORE = -1; // If we get here, stop the game, set the title to "GAME OVER" and prefix to "You Won"
    private String title="New Game";
    private String prefix="Score: ";
    private int score;
    /**
     * Create a score board with an initial value of 0. Also, set the vaiable score to 0
     * We will use this when updating the score, and to test agains MAXSCORE to determine
     * if the game is over.
     */
    public ScoreBoard()
    {
        this(0);
        score=0;
    }
    
    /**
     * Create a scoreboard with an initial score of "score"
     */
    public ScoreBoard(int score)
    {
        makeImage(title, prefix, score);
    }

    /**
     * Create a score board for any message.
     */
    public ScoreBoard(String txt)
    {
        setTitle(txt);
    }

    /**
     * Write anything on the board
     */
    public void setTitle(String txt)
    {
        title=txt;
        makeImage(title, prefix, score);
    }
    
    public void setPrefix(String p)
    {
        // Creates the titke, prefix, and score in the world
        prefix=p;
        makeImage(title, prefix, score);
    }
    
    /**
     * Make the score board image.
     */
    private void makeImage(String title, String prefix, int score)
    {
        GreenfootImage image = new GreenfootImage(WIDTH, HEIGHT);   
        image.setColor(new Color(0, 0, 0, 160)); 
        image.fillRect(0, 0, WIDTH, HEIGHT);  
        image.setColor(new Color(255, 255, 255, 100));
        image.fillRect(5, 5, WIDTH-10, HEIGHT-10);
        Font font = image.getFont();
        font = font.deriveFont(FONT_SIZE);
        image.setFont(font);
        image.setColor(Color.WHITE);
        image.drawString(title, 30, 30);
        image.drawString(prefix + score, 30, 60);
        setImage(image);
    }
    
    /**
     * Public methods can be called from other objects if they have
     * a reference to the object. See the code inside the Instructions object that
     * tests for keyboard input. Which tests manipulate the instructions object, and
     * manipulates this object.
     */
    public void setScore(  int s )
    {
        // Creates the titke, prefix, and score in the world
        score=s;
        makeImage(title, prefix, score);
    }
    
    public void setInvisible()
    {
        getImage().setTransparency(0); // Creates the image of the ScoreBoard object in the world
    }

    public void setVisible()
    {
        getImage().setTransparency(255); // Sets the transerancy of the ScoreBoard class to 225
    }
    
    public int getScore()
    {
        return score; // Getting the score object
    }
    
    public void act()
    {
        /*
         * The scoreboard object can manage state of the game by checking
         * various variables and conditions.
         */
        // If the y keyboard is pressed, then the "yea.wav" file is played
        if (Greenfoot.isKeyDown("y"))
        {
            Greenfoot.playSound("yea.wav");
        }
        
        // If the object did not win or lose, then the "Running" word will be shown
        if (score>1 && title != "Running")
        {
            setTitle("Running");
        }
        
        /*
         * If the maximum number of gold is caught, then the "Game Over" and "You Won" words will be shown, 
         * and the "applause.mp3" sound will be played 
         */
        if (score>=MAXSCORE)
        {
            setTitle("Game Over");
            setPrefix("You Won");
            Greenfoot.playSound("applause.mp3");
            Greenfoot.stop();
        }
        
        /*
         * If the score goes below the minimum number of gold  caught, then the "Game Over" and "You Lose"
         * words will be shown, and the "gameover.mp3" sound will be played 
         */
        if (score<=MINSCORE)
        {
            setTitle("Game Over");
            setPrefix("You Lose: ");
            Greenfoot.playSound("gameover.wav");
            Greenfoot.stop();
        }
        
    }
}
