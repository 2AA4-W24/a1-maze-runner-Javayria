package ca.mcmaster.se2aa4.mazerunner;

public interface ExploreMaze {

    void setStartPosition();
    //provide (or compute) the nextStep (for verification, this is just the next step in the path)
    String nextStep();

    boolean endExploration(); //all methods need to end for exploring a maze, 

    String formatPath(String path, boolean toFactorized);
    String exploreResult(); //output the result 

}













