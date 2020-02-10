package figures;

public enum TypeFigure {
    SQUARE,HORIZONTAL_RECTANGLE, L_SHAPE_FIGURE,Z_SHAPE_FIGURE, T_SHAPE_FIGURE;

    public static TypeFigure getType(int i) {
        return values()[i];
    }
}
