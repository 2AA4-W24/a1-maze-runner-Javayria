package ca.mcmaster.se2aa4.mazerunner;

public enum Direction {
    NORTH{
        @Override
        protected Direction yourRight(){
            return EAST;
        }

        @Override
        protected Direction yourLeft(){
            return WEST;
        }

        @Override
        protected Direction oppositeDirection(){
            return SOUTH;
        }
    },

    EAST{
        @Override
        protected Direction yourRight(){
            return SOUTH;
        }
        @Override
        protected Direction yourLeft(){
            return NORTH;
        }

        @Override
        protected Direction oppositeDirection(){
            return WEST;
        }
    },

    SOUTH{
        @Override
        protected Direction yourRight(){
            return WEST;
        }

        @Override
        protected Direction yourLeft(){
            return EAST;
        }

        @Override
        protected Direction oppositeDirection(){
            return NORTH;
        }
    },

    WEST{
        @Override
        protected Direction yourRight(){
            return NORTH;
        }

        @Override
        protected Direction yourLeft(){
            return SOUTH;
        }

        @Override
        protected Direction oppositeDirection(){
            return EAST;
        }
    };

    protected abstract Direction yourRight();
    protected abstract Direction yourLeft();
    protected abstract Direction oppositeDirection();
}





