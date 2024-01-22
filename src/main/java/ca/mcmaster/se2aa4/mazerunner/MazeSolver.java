package ca.mcmaster.se2aa4.mazerunner;

public class MazeSolver {
    private final Maze maze;
    private String direction;
    private Position current;
    private Position exit;
    

    public MazeSolver(Maze theMaze){
        this.maze = theMaze;
        this.current = theMaze.enter;
    }

    public char stepForward(){
        if(direction.equals("N")){
            current.y--;
        }
        else if{direction.equals("S"){
            current.y++;
            
        }

        }


    }

    public String solve(){
        String result = "doesn't have one...yet";
        return result;
    }
}
