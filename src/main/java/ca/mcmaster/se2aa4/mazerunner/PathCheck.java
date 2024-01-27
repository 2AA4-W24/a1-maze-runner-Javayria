package ca.mcmaster.se2aa4.mazerunner;

public class PathCheck{
    //IMPLEMENT AS INHERITANCE CLASS OF MAZESOLVER AND HAVE INTERFACE TO DECIDE WHICH TO DO
    String Path;
    public PathCheck(Maze theMaze, String inputPath){
    }
    
    public void result(){
        boolean correctPath = false;
        if(correctPath){
            System.out.println("correct path");
        }
        else{
            System.out.println("incorrect path");
        }
    }
}


