package com.example.mariooooo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import map.Map01;

public class Surface_View  extends SurfaceView implements SurfaceHolder.Callback{
    Map01 map01;    //Mapクラスの参照保持変数
    Paint paint;    //Color保持用
    SurfaceHolder holder;  //ディスプレイ編集・監視用インターフェース
    int[][] mapArray; //表示マップ保持用
    Bitmap brick;
    int scroll_Num = 0; //表示マップ横位置保持



    //画面変更時の処理
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height){}

    //画面破棄時の処理
    @Override
    public void surfaceDestroyed(SurfaceHolder holder){}

    //画面作成時の処理
    @Override
    public void surfaceCreated(SurfaceHolder holder){

        //Mapクラスのインスタンス生成　
        //画面幅,画面高さを取得 コンストラクタの処理の後なら取得可能
        map01 = new Map01(super.getWidth(), super.getHeight());
        mapArray = map01.getMap01(); //map配列取得
        paint = new Paint();
        paint.setColor(Color.BLUE);
        brick = BitmapFactory.decodeResource(getResources(),R.drawable.brick);

        //runすれっど
        Thread t1 = new scroll(this,scroll_Num);
        t1.start();

        draw(); //描画用自クラスメソッド

    }

    //コンストラクタ
    public Surface_View(Context context){
        super(context);
        //この処理でsurfaceCreatedメソッドが動きます
        holder = super.getHolder();
        holder.addCallback(this);
    }

    //画面にタッチすると動くメソッド
    @Override
    public boolean onTouchEvent(MotionEvent event){
        float touchX = event.getX(); //タッチ位置取得
        //画面に指を置いたタイミングで条件分岐処理
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN :
                //タッチ位置が画面の右側ならxxをインクリメント
                if(touchX > super.getWidth() / 2){
                    scroll_Num++;
                }else{ //それ以外はデクリメント
                    scroll_Num--;
                }
                break;
        }
        draw(); //画面再描画
        return true;
    }


//描画用メソッド
    public void draw() {
        Canvas canvas = holder.lockCanvas(); //画面をロックして
        canvas.drawRect(0, 0, super.getWidth(), super.getHeight(), paint);

        //描画ドット数繰り返す

        try {
            for (int y = 0; y < map01.getYlen(); y++) {
                for (int x = 0; x < map01.getXlen()-scroll_Num; x++) {

                    switch (mapArray[y][x + scroll_Num]) {
                        case 1:     //配列の値が1の場合は
                            float drawX = x * 79;  //描画開始位置のX座標を設定
                            float drawY = y * 79;  //描画開始位置のY座標を設定
                            canvas.drawBitmap(brick, drawX, drawY, paint);
                            // canvas.drawRect(drawX,drawY,drawX + map01.getDotX(), drawY + map01.getDotY(),paint);
                            break;
                    }
                }
            }
        }catch(ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            System.out.println("マップの端");
        }
        holder.unlockCanvasAndPost(canvas); //画面に変更反映
    }


    public int getScroll_Num() {
        return scroll_Num;
    }
    public void setScroll_Num(int num){
       this.scroll_Num = num;
    }
}
