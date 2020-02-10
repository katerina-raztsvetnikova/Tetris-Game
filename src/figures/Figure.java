package figures;
import manager.GameBoard;

public abstract class Figure implements Figures {
    public TypeFigure type;
    public GameBoard board;
    public Coordinates[] coordinates;
    public FigureRotation rotation;
    public static final int COORDINATES_NUMBER = 4;

    public Figure(TypeFigure type, GameBoard board) {
        this.type = type;
        this.board = board;
        this.coordinates = new Coordinates[COORDINATES_NUMBER];
        this.rotation = FigureRotation.ANGLE_0;
    }

    public static Figures getInstance(TypeFigure thisType, int rowPos, GameBoard board) {
        switch (thisType) {
            case HORIZONTAL_RECTANGLE:
                return new HorizontalRectangle(thisType, rowPos, board);
            case SQUARE:
                return new SquareFigure(thisType, rowPos, board);
            case T_SHAPE_FIGURE:
                return new TShapeFigure(thisType, rowPos, board);
            case Z_SHAPE_FIGURE:
                return new ZShapeFigure(thisType, rowPos, board);
            case L_SHAPE_FIGURE:
                return new LShapeFigure(thisType, rowPos, board);
        }
        return null;
    }

    @Override
    public void display() {
        for (int i = 0; i < coordinates.length; i++) {
            this.board.setFigure(coordinates[i].rowCoordinate, coordinates[i].colCoordinate);
        }
    }
    @Override
    public boolean validMove(Movement type) {
        return canMove(type);
    }

    @Override
    public void clearConsole() {
        for (int i = 0; i < coordinates.length; i++) {
            this.board.clearConsole(coordinates[i].rowCoordinate, coordinates[i].colCoordinate);
        }
    }
    @Override
    public void move(Movement type) {
        switch (type) {
            case LEFT:
                moveLeft(coordinates);
                break;
            case RIGHT:
                moveRight(coordinates);
                break;
            case ROTATION:
                rotateTheFigure(coordinates);
                int posture = this.rotation.ordinal();
                posture++;
                if (posture > 3) {
                    posture = 0;
                }
                this.rotation = FigureRotation.getType(posture);
                break;
        }
    }
    private void moveLeft(Coordinates[] coordinates) {
        for (int i = 0; i < coordinates.length; i++) {
            coordinates[i].rowCoordinate--;
        }
    }
    private void moveRight(Coordinates[] coordinates) {
        for (int i = 0; i < coordinates.length; i++) {
            coordinates[i].rowCoordinate++;
        }
    }
    public void moveDown() {
        for (int i = 0; i < coordinates.length; i++) {
            coordinates[i].colCoordinate++;
        }
    }
    @Override
    public boolean canMove() {
        if (canMove(Movement.LEFT) || canMove(Movement.RIGHT) || canMove(Movement.ROTATION)){
            return true;
        }
        return false;
    }

    public boolean canMove(Movement type) {
        Coordinates[] coordinates = new Coordinates[COORDINATES_NUMBER];
        for (int i = 0; i < coordinates.length; i++) {
            coordinates[i] = new Coordinates(coordinates[i].rowCoordinate, coordinates[i].colCoordinate);
        }
        switch (type) {
            case LEFT:
                moveLeft(coordinates);
                break;
            case RIGHT:
                moveRight(coordinates);
                break;
            case ROTATION:
                rotateTheFigure(coordinates);
                break;
        }
        for (int i = 0; i < coordinates.length; i++) {
            if (!this.board.isConsoleClear(coordinates[i].rowCoordinate, coordinates[i].colCoordinate + 1, this)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean containFigure(int x, int y) {
        for (int i = 0; i < coordinates.length; i++) {
            if (coordinates[i].rowCoordinate == x && coordinates[i].colCoordinate == y) {
                return true;
            }
        }
        return false;
    }

    protected abstract void rotateTheFigure(Coordinates[] coordinates);

}
