package figures;
import manager.GameBoard;

public class HorizontalRectangle extends Figure {
    public HorizontalRectangle(TypeFigure type, int rowPosition, GameBoard board) {
        super(type, board);
        for (int i = 0; i < COORDINATES_NUMBER; i++) {
            this.coordinates[i] = new Coordinates(rowPosition + i, 0);
        }
    }
    @Override
    public void rotateTheFigure(Coordinates[] coordinates) {
        switch (rotation){
            case ANGLE_0:
                coordinates[0].rowCoordinate++;
                coordinates[0].colCoordinate++;
                coordinates[2].rowCoordinate--;
                coordinates[2].colCoordinate--;
                coordinates[3].rowCoordinate -= 2;
                coordinates[3].colCoordinate -= 2;
                break;
            case ANGLE_90:
                coordinates[0].rowCoordinate++;
                coordinates[0].colCoordinate--;
                coordinates[2].rowCoordinate--;
                coordinates[2].colCoordinate++;
                coordinates[3].rowCoordinate -= 2;
                coordinates[3].colCoordinate += 2;
                break;
            case ANGLE_180:
                coordinates[0].rowCoordinate--;
                coordinates[0].colCoordinate--;
                coordinates[2].rowCoordinate++;
                coordinates[2].colCoordinate++;
                coordinates[3].rowCoordinate += 2;
                coordinates[3].colCoordinate += 2;
                break;
            case ANGLE_270:
                coordinates[0].rowCoordinate--;
                coordinates[0].colCoordinate++;
                coordinates[2].rowCoordinate++;
                coordinates[2].colCoordinate--;
                coordinates[3].rowCoordinate += 2;
                coordinates[3].rowCoordinate -= 2;
                break;
        }

    }
}
