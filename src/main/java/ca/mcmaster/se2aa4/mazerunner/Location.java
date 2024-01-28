package ca.mcmaster.se2aa4.mazerunner;

public class Location{
    private final int x;
    private final int y;

    public Location(int x, int y){
        this.x = x;
        this.y = y;  
    }

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
