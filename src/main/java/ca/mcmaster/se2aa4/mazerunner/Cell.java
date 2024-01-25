package ca.mcmaster.se2aa4.mazerunner;

public enum Cell {
    WALL('#'), PASS(' ');

    private final char cellType;

    Cell(char cellType) {
        this.cellType = cellType;
    }
}
