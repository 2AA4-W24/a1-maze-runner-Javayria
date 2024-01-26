package ca.mcmaster.se2aa4.mazerunner;

public class Location{
    int x;
    int y;

    public Location(int x, int y){
        this.x = x;
        this.y = y;  
    }

    public Location getNorth(){
        return new Location(x-1, y);
    }

    public Location getSouth(){
        return new Location(x+1, y);
    }

    public Location getEast(){
        return new Location(x, y+1);
    }

    public Location getWest(){
        return new Location(x, y-1);
    }

    @Override
    public String toString() {
        return "Coordinates: (" +
         "x=" + x + 
            ", y= " + y + 
            ")";
    }

}
