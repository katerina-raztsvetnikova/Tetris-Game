package figures;
import manager.GameBoard;
public class ZShapeFigure extends Figure {
    public ZShapeFigure(TypeFigure type, int rowPosition, GameBoard board) {
        super(type, board);
        this.coordinates[0] = new Coordinates(rowPosition, 2);
        this.coordinates[1] = new Coordinates(rowPosition, 1);
        this.coordinates[2] = new Coordinates(rowPosition + 1, 1);
        this.coordinates[3] = new Coordinates(rowPosition + 1, 0);
    }

    @Override
    public void rotateTheFigure(Coordinates[] coordinates) {
        switch (rotation) {
            case ANGLE_0:
                coordinates[0].rowCoordinate++;
                coordinates[0].colCoordinate--;
                coordinates[2].rowCoordinate--;
                coordinates[2].colCoordinate--;
                coordinates[3].rowCoordinate -= 2;
                coordinates[3].colCoordinate -= 2;
                break;
            case ANGLE_90:
                coordinates[0].rowCoordinate--;
                coordinates[0].colCoordinate--;
                coordinates[2].rowCoordinate--;
                coordinates[2].colCoordinate++;
                coordinates[3].rowCoordinate -= 2;
                coordinates[3].colCoordinate += 2;
                break;
            case ANGLE_180:
                coordinates[0].rowCoordinate--;
                coordinates[0].colCoordinate++;
                coordinates[2].rowCoordinate++;
                coordinates[2].colCoordinate++;
                coordinates[3].rowCoordinate += 2;
                coordinates[3].colCoordinate += 2;
                break;
            case ANGLE_270:
                coordinates[0].rowCoordinate++;
                coordinates[0].colCoordinate++;
                coordinates[2].rowCoordinate++;
                coordinates[2].colCoordinate--;
                coordinates[3].rowCoordinate += 2;
                coordinates[3].rowCoordinate -= 2;
                break;
        }
    }



}
