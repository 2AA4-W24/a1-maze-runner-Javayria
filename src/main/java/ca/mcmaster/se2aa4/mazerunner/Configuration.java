package ca.mcmaster.se2aa4.mazerunner;

import java.io.File;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;

public record Configuration(String inputFile, String inputPath) {
    
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

      public static Configuration config(String[] args) throws ParseException {
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
        else{
            throw new IllegalArgumentException("Must enter -i flag: Exploration DENIED");
        }
        return new Configuration(inputFile, inputPath);        
    }

    
    //finalized check for PathFormat
    private boolean validPathFormat(String inputPath){
        boolean valid=true;
        for (int i = 0 ; i < inputPath.length() ; i++) {
            char c = inputPath.charAt(i);
            if (!Character.isDigit(c)){
                if ((c != 'F') && (c != 'R') && (c != 'L') && (c != ' ')){
                    valid = false;
                }
            }
        } 
        return valid;
    }

} 

