package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    // create Options object
    Options options = new Options();
    // add an -i flag
    options.addOption("i", false, "provided maze");

    public static void main(String[] args) {
        logger.info("** Starting Maze Runner");
        try {
            // Parse the command line arguments//
            CommandLineParser parser = new DefaultParser();
            CommandLine commandline = parser.parse(options, args);
 
            logger.info("**** Reading the maze from file " + args[i]);
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            String line;
            while ((line = reader.readLine()) != null) {
                for (int idx = 0; idx < line.length(); idx++) {
                    if (line.charAt(idx) == '#') {
                        System.out.print("WALL ");
                    } else if (line.charAt(idx) == ' ') {
                        System.out.print("PASS ");
                    }
                }
                System.out.print(System.lineSeparator());
            }
        } catch(Exception e) {
            logger.error("/!\\ An error has occured /!\\");
        }
        logger.info("**** Computing path");
        logger.info("PATH NOT COMPUTED");
        logger.info("** End of MazeRunner");
    }
}
