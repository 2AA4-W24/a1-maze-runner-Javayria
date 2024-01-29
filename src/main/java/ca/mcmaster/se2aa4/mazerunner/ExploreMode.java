package ca.mcmaster.se2aa4.mazerunner;

/*common abstract methods provided by ExploreMode */
public interface ExploreMode {

    /*set instance variables of explorer
     * @param theMaze to traverse
    */
    void setUp(Maze theMaze);

    /*return the exploration result
     * @return String, which can be path or verificationResult
     */
    String explore() throws IllegalArgumentException;  
}
