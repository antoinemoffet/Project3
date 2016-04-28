import greenfoot.*;
import java.io.*;

import java.util.ArrayList;
/**
 * Write a description of class SpaceWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private Question question;
    public Response option1=new Response();
    public Response option2=new Response();
    private int i; 
    private String fileName = "answers.txt";
    public ArrayList<String> answers;
    public int maxLines;//=4;

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
    
    /**
     * Instantiates memory for the objects and displays, in the world, with respect 
     * to the coordinates
     */
    private void prepare()
    {
        try {
          answers = loadFile(fileName);
          maxLines=answers.size();
        }
        catch (IOException ioe){
            System.out.println("error");
        }
        

        
        question = new Question();
        addObject(question, 400, 225);  
        
        option1.setTrueFalse(true);
        addObject(option1, 250, 425);
        option2.setTrueFalse(false);;
        addObject(option2, 600, 425); 
        i=1;
 
    }
    private ArrayList<String> loadFile(String filename) throws IOException {
        ArrayList<String> lines = new ArrayList<String>();
        
        // Allow loading from JAR files
        
        // "filename" has to reference a file in the project directory used to
        // create the jar file.
        
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream is = classLoader.getResourceAsStream(filename);
        if (is == null) {
            throw new IOException("No such file: " + filename);
        }
        BufferedReader reader = new BufferedReader(
                                new InputStreamReader(is));
        String line = reader.readLine();
        while (line != null) {
            
            // Note that we are ignoring lines that start with "#". This way we
            // can add comments to our data file.
            if (!line.equals("") && !line.startsWith("#")) {
                lines.add(line);
            }
            line = reader.readLine();
        }
        reader.close();
        return lines;
    }
    public Response getOption1(){
        return option1;
    }
    public Response getOption2(){
        return option2;
    }
    public void setAnswer(int aNum){
        boolean ans=Boolean.parseBoolean(answers.get(aNum));
        if (ans==true){
            option1.setOption(true);
            option2.setOption(false);
        }
        else {
            option1.setOption(false);
            option2.setOption(true);           
        }
    }
    public void nextQuestion(){
        question.setQuestion(i);
        setAnswer(i);
        i++;
    }
}
