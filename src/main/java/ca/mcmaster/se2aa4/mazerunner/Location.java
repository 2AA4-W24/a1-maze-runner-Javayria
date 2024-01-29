package ca.mcmaster.se2aa4.mazerunner;

/*
 * Stores the (x, y) coordinates of a Cell in the Maze
 */

public class Location{

    private final int x;
    private final int y;

    /*
     * Constructor used within class to set coordinates
     * @param int x, int y
     */
    public Location(int x, int y){
        this.x = x;
        this.y = y;  
    }

     /*
     * Constructor used outside of class to avoid changing x and y directly
     * Assigns a copy of a Location object
     */
    public Location(Location location){
        this.x = location.x;
        this.y = location.y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
    
    public boolean equals(Location location){
        return((x==location.x) && (y==location.y));
    }
 
    /*
     * Gets neighouring cell Locations for each direction
     */
    protected Location getNorth(){
        return new Location(x-1, y);
    }

    protected Location getSouth(){
        return new Location(x+1, y);
    }

    protected Location getEast(){
        return new Location(x, y+1);
    }

    protected Location getWest(){
        return new Location(x, y-1);
    }

    @Override
    public String toString() {
        return "Location: (" +
         "x=" + x + 
            ", y= " + y + 
            ")";
    }

}
