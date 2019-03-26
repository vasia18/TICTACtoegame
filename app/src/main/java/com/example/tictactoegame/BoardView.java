package com.example.tictactoegame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class BoardView<ELT_STROKE_WIDTH> extends View {
    private static final int LINE_THICK = 5;
    private static final int ELT_MARGIN = 20;
    private static final int ELT_STROKE_WIDTH = 15;
    private int width, height, eltw, elth;
    private Paint gridPaint, oPaint, xPaint;
    private GameEngine gameEngine;
    private MainActivity activity;


    public BoardView(Context context) {
        super(context);
    )


    public BoardView(Context context, @androidx.annotation.Nullable AttributeSet attrs) {
            super(context, attrs);

            gridPaint = new Paint();
            oPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            oPaint.setColor(Color.RED);
            oPaint.setStyle(Paint.Style.STROKE);
            oPaint.setStrokeWidth(ELT_STROKE_WIDTH);
            xPaint = new Paint(oPaint);
            xPaint.setColor(Color.BLUE);
        }

        public void setMainActivity (MainActivity a);
        activity = a;
    }

    public void setGameEngine(GameEngine g) {
        gameEngine = g;
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        height = View.MeasureSpec.getSize(heightMeasureSpec);
        width = View.MeasureSpec.getSize(widthMeasureSpec);
        elth = (width - LINE_THICK) / 3;
        elth = (height - LINE_THICK) / 3;

        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        drawGrid(canvas);
        drawBoard(canvas, gameEngine);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (!gameEngine.isEnded() && event.getAction()) ==MotionEvent.ACTION_DOWN){
            int x = (int) (event.getX() / eltw);
            int y = (int) (event.getY() / elth);
            char win = gameEngine.play(x, y);
            invalidate();

            if (win != ' ') {
                activity.gameEnded(win);
            } else {
                //computer plays ....
                win = gameEngine.computer();
                invalidate();

                if (win != ' ') {
                    activity.gameEnded(win);

                }
            }
        }
        return super.onTouchEvent(event);
    }

    private void drawBoard(Canvas canvas) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                drawElt(canvas, gameEngine.elt(i, j), i, j);
            }
        }
    }

    private void drawGrid(Canvas canvas) {
        for (i = 0; i < 2; i++) {

            //Вертикальная линия
            float left = altw * (i + 1);
            float right = left + LINE_THICK;
            float top = 0;
            float botton = height;

            canvas.drawRect(left, top, right, botton, gridPaint);

            //Горизонтальнвя линия
            float left2 = 0;
            float right2 = width;
            float top2 = elth * (i + 1);
            float botton2 = top2 + LINE_THICK;

            canvas.drawRect(left2, top2, right2, botton2, gridPaint);

        }
    }

    private void drawElt(Canvas canvas, char c, int x, int y) {
        if (c == '0') {
            float cx = (eltw * x) + eltw / 2;
            float cy = (elth * y) + elth / 2;

            canvas.drawCircle(cx, cy, Math.min(eltw, elth) / 2 - ELT_MARGIN * 2, oPaint);
        } else if (c == 'x') {
            float startX = (eltw * x) + ELT_MARGIN;
            float startY = (elth * y) + ELT_MARGIN;
            float endX = startX + eltw - ELT_MARGIN * 2;
            float endY = startY + elth - ELT_MARGIN;

            canvas.drawLine(startX, startY, endX, endY, xPaint);


            float startX2 = (eltw *x) + ELT_MARGIN;
            float startY2 = (elth *y) + ELT_MARGIN;
            float endx2 = 


        }
    }
}