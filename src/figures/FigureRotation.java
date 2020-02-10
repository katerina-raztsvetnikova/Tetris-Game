package figures;

public enum FigureRotation {
    ANGLE_0, ANGLE_90, ANGLE_180, ANGLE_270;

    public static FigureRotation getType(int i) {
        return values()[i];
    }

}
