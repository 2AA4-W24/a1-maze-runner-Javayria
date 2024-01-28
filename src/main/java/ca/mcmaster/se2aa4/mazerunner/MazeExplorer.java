package ca.mcmaster.se2aa4.mazerunner;

public class MazeExplorer{
    protected PathFinder find;
    protected PathCheck check;

    ///REASONING - wanted to implement the path verification/finding as different exploration modes!
    public MazeExplorer(Maze maze){
        this.find = new PathFinder(maze);
    }

    public MazeExplorer(Maze maze, String path){
        this.check = new PathCheck(maze, path);
    }

    public String startExploring(Maze maze, String path){
        if(path==null){
            System.out.println("PATH FINDER MODE ACTIVATED -----");
            MazeExplorer explorer = new MazeExplorer(maze);
            return(explorer.find.RightHandRule());

        }
        else{
            System.out.println("PATH VERIFIER MODE ACTIVATED -----");
            MazeExplorer explorer = new MazeExplorer(maze, FormatPath.deCompact(path));
            return(explorer.check.verifyPath());
        }
    }

   
}
