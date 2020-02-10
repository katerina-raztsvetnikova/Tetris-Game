package figures;

public interface Figures {
  public void display();
  public void clearConsole();
  public void move(Movement type);
  public void moveDown();
  public boolean validMove(Movement type);
  public boolean canMove();
  public boolean containFigure(int i, int j);
}
