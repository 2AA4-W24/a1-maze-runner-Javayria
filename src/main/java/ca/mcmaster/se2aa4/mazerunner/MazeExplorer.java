package ca.mcmaster.se2aa4.mazerunner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class MazeExplorer{
    private static final Logger logger = LogManager.getLogger();

    public PathFinder find;
    public PathCheck check;

    ///REASONING - wanted to implement the path verification/finding as different exploration modes!
    public MazeExplorer(Maze maze){
        this.find = new PathFinder(maze);
    }

    public MazeExplorer(Maze maze, String path){
        this.check = new PathCheck(maze, path);
    }

    public String startExploring(Maze maze, String path){
        if(path==null){
            logger.info(("PATH FINDER MODE ACTIVATED -----"));
            MazeExplorer explorer = new MazeExplorer(maze);
            return(explorer.find.explore());

        }
        else{
            logger.info("PATH VERIFIER MODE ACTIVATED -----");
            MazeExplorer explorer = new MazeExplorer(maze, FormatPath.processPath(path));
            logger.info(FormatPath.processPath(path));
            return(explorer.check.explore());
        }
    }
}
