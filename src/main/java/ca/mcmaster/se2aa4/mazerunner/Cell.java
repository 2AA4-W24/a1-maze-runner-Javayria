package ca.mcmaster.se2aa4.mazerunner;

public enum Cell {
    WALL('#'), PASS(' '), START('S'), END('E');

    private final char cellType;

    Cell(char cellType) {
        this.cellType = cellType;
    }

    @Override
    public String toString() { return "" + cellType; }    
}
