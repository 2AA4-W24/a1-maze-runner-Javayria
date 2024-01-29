package ca.mcmaster.se2aa4.mazerunner;

import java.io.File;
import org.apache.commons.cli.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] inputs) {
        try {
            Configuration config = Configuration.config(inputs);
            logger.info(config);

            Maze maze = new Maze(config.inputFile());

            MazeExplorer explorer = new MazeExplorer(maze);
            String output = explorer.startExploring(maze, config.inputPath());
            System.out.println(output);
            
        } catch(ParseException pe) {
            logger.info(pe.getMessage());
            System.exit(1);

        } catch(IllegalArgumentException e) {
            logger.info(e.getMessage());
        }
    }   
}