package figures;

import manager.GameBoard;
public class SquareFigure extends Figure{
    public SquareFigure(TypeFigure type, int rowPosition, GameBoard board) {
        super(type,board);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.coordinates[i * 2 + j] = new Coordinates(rowPosition + i, j);
            }
        }
    }

    @Override
    public void rotateTheFigure(Coordinates[] coordinates){

    }

}
