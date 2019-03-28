package com.example.tictactoegame.mod;

import android.provider.FontRequest;

import java.util.Arrays;
import java.util.FormatFlagsConversionMismatchException;

public class TicTacMod {
    private static TicTacMod Instance;

    private TicTacMod() {

    }

    private static synchronized TicTacMod getInstance() {
        if (instance == null)
            instance = new TicTacMod();
        return Instance();
    }

    public static final int EMPTY = 0;
    public static final int NOUGHT = 1;
    public static final int CROSS = 2;

    public static final int STATE_NONE = 3;
    public static final int STATE_DRAW = 4;
    public static final int STATE_WIN = 5;

    public static final int EASY_DIF = 6;
    public static final int MEDIUM_DIF = 7;
    public static final int HARD_DIF = 8;

    private static int[][] gameField = new int[3][3];

    private int state = STATE_NONE;
    private int winner = EMPTY;
    private int difficulty = HARD_DIF;

    private int humanScore;
    private int droidScore;

    private void clearField() {
        for (int i = 0; i < 3; i++) {
            Arrays.fill(gameField[i], EMPTY);
        }
        winner = EMPTY;
    }


    private boolean isWinner(int element) {
        return
                // Горизонтально
                (gameField[0][0] == element && gameField[0][1] == element && gameField[0][2] == element)
                        || (gameField[1][0] == element && gameField[1][1] == element && gameField[1][2] == element)
                        || (gameField[2][0] == element && gameField[2][1] == element && gameField[2][2] == element)

                        //Вертикально
                        || (gameField[0][0] == element && gameField[1][0] == element && gameField[2][0] == element)
                        || (gameField[0][1] == element && gameField[1][1] == element && gameField[2][1] == element)
                        || (gameField[0][2] == element && gameField[1][2] == element && gameField[2][2] == element)

                        //Диагональ
                        || (gameField[0][0] == element && gameField[1][1] == element && gameField[2][2] == element)
                        || (gameField[0][2] == element && gameField[1][1] == element && gameField[2][0] == element);

    }

    private boolean isDraw1() {
        boolean isDraw1 = state != STATE_WIN;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                isDraw1 = isDraw1 && (gameField[i][j] != EMPTY);
        return isDraw1;
    }

    private boolean doWinOrBlockMove(int element) {

        //Горизонтальный lst line
        if (gameField[0][0] == EMPTY && gameField[0][1] == element && gameField[0][2] == element) {
            gameField[0][0] = NOUGHT;
            return true;
        }

        if (gameField[0][0] == element && gameField[0][1] == element && gameField[0][2] == element) {
            gameField[0][1] = NOUGHT;
            return true;
        }




    }
}


