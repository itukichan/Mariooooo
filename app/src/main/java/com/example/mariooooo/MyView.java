package com.example.mariooooo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

    class MyView extends View{
        private Paint paint;
        private final Bitmap brick_bmp;
        private final Bitmap player_bmp;

        public MyView(Context context, AttributeSet attrs) {
            super(context,attrs);
            paint = new Paint();
            brick_bmp = BitmapFactory.decodeResource(getResources(),R.drawable.brick);
            player_bmp = BitmapFactory.decodeResource(getResources(),R.drawable.mario);
        }

        public void showCanvas(boolean flg){
            invalidate();
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawBitmap(brick_bmp, 80, 200, paint);
            canvas.drawBitmap(brick_bmp, 150, 200, paint);
            canvas.drawBitmap(player_bmp,100,0,paint);
        }

    }

