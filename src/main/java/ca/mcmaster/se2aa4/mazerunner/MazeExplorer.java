package ca.mcmaster.se2aa4.mazerunner;

public class MazeExplorer{

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
            MazeExplorer explorer = new MazeExplorer(maze);
            return(explorer.find.explore());

        }
        else{
            MazeExplorer explorer = new MazeExplorer(maze, FormatPath.processPath(path));
            return(explorer.check.explore());
        }
    }
}
