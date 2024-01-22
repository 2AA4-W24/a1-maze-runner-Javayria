package ca.mcmaster.se2aa4.mazerunner;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

import org.apache.commons.cli.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        try {
            Configuration config = config(args);
            logger.info(config);
            Maze theMaze = new Maze(config.inputFile()); //generates the maze object
            String path = null;
            theMaze.printMaze();

            if(config.inputPath==null){
                MazeSolver theSolver = new MazeSolver(theMaze); //chooses a method to solve the maze
                path = theSolver.solve();
                System.out.println(path);
            } 
            else{
                PathCheck theCheck = new PathCheck(theMaze, config.inputPath());
                theCheck.result();
            }
            
        } catch(ParseException pe) {
            System.err.println(pe.getMessage());
            System.exit(1);
        }
    }

    //configuration method for command line arguments
    private static Configuration config(String[] args) throws ParseException {
        Options options = new Options();
        options.addOption("i", true, "must specify filepath (.txt) for maze");
        options.addOption("p", true, "activate path sequence check for maze");
        CommandLineParser parser = new DefaultParser();  // Parse the command line arguments
        
        CommandLine cmd = parser.parse(options, args);
        String inputFile = null;
        String inputPath = null;
        if(cmd.hasOption("i")) { //validate that the -i flag is present in command
            inputFile = cmd.getOptionValue("i");
            if(cmd.hasOption("p")) { //check if -p flag is present 
                inputPath = cmd.getOptionValue("p");
            }
        }
        return new Configuration(inputFile, inputPath);        
    }

    private static boolean validPathFormat(String inputPath){
        boolean valid=true;
        for (int i = 0 ; i < inputPath.length() ; i++) {
            char c = inputPath.charAt(i);
            if (!Character.isDigit(c)){
                if ((c != 'F') && (c != 'R') && (c != 'L')){
                    valid = false;
                }
            }
        }
        return valid;
    }

    //data class
    private record Configuration(String inputFile, String inputPath) {
        public Configuration {
            File tmp = new File(inputFile);
            if(!tmp.exists()) {
                throw new IllegalArgumentException("Given file does not exist.");
            } 
            
            //take the path_sequence input from user and verify if it is provided in a valid format
            if (inputPath != null){
                if(!validPathFormat(inputPath)){
                    throw new IllegalArgumentException("Path is not provided in a valid form.");
                }
            }  
        }
    }    
}