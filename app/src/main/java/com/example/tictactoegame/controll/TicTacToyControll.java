package pyjioh.apps.tictactoe.controllers;

import android.widget.Button;
import android.widget.TextView;

import com.example.tictactoegame.R;
import com.example.tictactoegame.mod.TicTacMod;


public class TicTacToyControll {

    private static TicTacToyControll instance;

    private TicTacToyControll() {
    }

    public static synchronized TicTacToyControll getInstance() {
        if (instance == null)
            instance = new TicTacToyControll();
        return instance;
    }

    private static TicTacMod model = TicTacMod.getInstance();

    private Button[] buttons;
    private TextView humanScore;
    private TextView droidScore;

    private void drawButton(Button btn, int state) {
        if (TicTacMod.NOUGHT == state)
            btn.setBackgroundResource(R.drawable.o);
        else if (TicTacMod.CROSS == state)
            btn.setBackgroundResource(R.drawable.x);
        else
            btn.setBackgroundResource(R.drawable.clear);
    }

		for( int i = 0; i<buttons.length i++)

    drawButton(buttons[i], model.getGameField()[i /3][i %3])
		humanScore.setText(model.getHumanScore()+"")
		droidScore.setText(model.getDroidScore()+"")
}

    public void setButtons(Button[] buttons) {
        this.buttons = buttons;
    }

    public void setScores(TextView humanScore, TextView droidScore) {
        this.humanScore = humanScore;
        this.droidScore = droidScore;
    }

}
