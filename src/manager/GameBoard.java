package manager;
import figures.Figure;
import figures.Movement;
import figures.TypeFigure;
import java.util.Random;

public class GameBoard {

    public static final int ROW_BOARD_SIZE = 24;
    public static final int COL_BOARD_SIZE = 12;
    public static final int FIGURE_TYPES = 5;
    public static Figure activeFigure;
    public boolean board[][];

    public GameBoard() {
        this.board = new boolean[ROW_BOARD_SIZE][COL_BOARD_SIZE];
    }

    private void addNewFigure() {
        Random rand = new Random();
        int rowPosition = rand.nextInt(ROW_BOARD_SIZE);
        int figureType = rand.nextInt(FIGURE_TYPES);
        activeFigure = (Figure) Figure.getInstance(TypeFigure.getType(figureType), rowPosition, this);
        activeFigure.display();
    }

    public void moveFigure(Movement type) {
        if (activeFigure.validMove(type)) {
            activeFigure.clearConsole();
            activeFigure.move(type);
            activeFigure.moveDown();
            activeFigure.display();
        }
    }

    public void updateFigure() {
        clearConsole();
        for (int i = 0; i < ROW_BOARD_SIZE; i++) {
            System.out.print("*");
            for (int j = 0; j < COL_BOARD_SIZE; j++) {
                if (board[i][j]) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("            *");
        }
        for (int i = 0; i < ROW_BOARD_SIZE + 2; i++) {
            System.out.print("*");
        }

        System.out.println();
    }


    public static void clearConsole() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
    public void gameOver() {
        System.out.println("Game Over!");
        System.exit(0);
    }

    public void run() {
        addNewFigure();
        updateFigure();
        gameOver();
    }
        public void setFigure ( int rowCoordinates, int colCoordinates){
            if ((rowCoordinates >= 0) && (rowCoordinates < ROW_BOARD_SIZE)) {
                if ((colCoordinates >= 0) && (colCoordinates < COL_BOARD_SIZE)) {
                    this.board[rowCoordinates][colCoordinates] = true;
                }
            }
        }
    public void clearConsole(int clearRow, int clearCol) {
        if (clearRow >= 0 && clearRow < ROW_BOARD_SIZE && clearCol >= 0 && clearCol < COL_BOARD_SIZE) {
            this.board[clearRow][clearCol] = false;
        }
    }

    public boolean isConsoleClear(int x, int y, Figure thisFigure) {
        if (x < 0 || x > ROW_BOARD_SIZE - 1 || y < 0 || y > COL_BOARD_SIZE - 1) {
            return false;
        }
        return !board[x][y] || thisFigure.containFigure(x, y);
    }

}
