package com.example.tictactoegame.controll;

public class TicTacToyControll {

    private static TicTacToyControll instanse;

    private TicTacToyControll(){
    }

    public static synchronized TicTacToyControll getInstance(){
        if (instanse == null)
            instanse = new TicTacToyControll();
        return instanse;
    }

    private static TicTacToyControll model = TicTacToyMod.getInstanse();
    }




}
