package figures;
public enum Movement {
    LEFT, RIGHT,ROTATION;
    public static Movement getType(int i) {
        return values()[i];
    }
}
