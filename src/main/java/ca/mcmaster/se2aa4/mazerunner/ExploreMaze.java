package ca.mcmaster.se2aa4.mazerunner;

public interface ExploreMaze {

    Position setStartPosition();
    //provide (or compute) the nextStep (for verification, this is just the next step in the path)
    String nextStep();

   // boolean canMoveForward() throws IndexOutOfBoundsException;
    boolean reachedExit();
    
    String formatPath(String path, boolean toFactorized);
    String exploreResult(); //output the result 

}













