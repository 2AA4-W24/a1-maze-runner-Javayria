package ca.mcmaster.se2aa4.mazerunner;

/*
 * Set the exploration depending on input arguments
 */
public class MazeExplorer{

    public PathFinder find;
    public PathCheck check;

    /*
     * Creates a PathFinder object
     * @param Maze maze to traverse
     */
    public MazeExplorer(Maze maze){
        this.find = new PathFinder(maze);
    }

    /*
     * Creates a PathCheck object
     * @param Maze maze to traverse, String path to check
     */
    public MazeExplorer(Maze maze, String path){
        this.check = new PathCheck(maze, path);
    }

    /*
     * Decide which object to create and explore()
     */
    public String startExploring(Maze maze, String path){
        if(path==null){
            MazeExplorer explorer = new MazeExplorer(maze);
            return(explorer.find.explore());

        }
        else{
            MazeExplorer explorer = new MazeExplorer(maze, FormatPath.processPath(path));
            return(explorer.check.explore());
        }
    }
}
