package com.example.mariooooo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.util.TypedValue;
import android.view.Gravity;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import android.widget.ImageView;
import android.graphics.*;
import android.widget.LinearLayout;

import android.widget.RelativeLayout;
import android.widget.TextView;



public class GameActivity extends AppCompatActivity{

    private ImageView player;
    private Button jump;  //追々ジャンプ実装する。とりあえず横移動
    private float PlayerX = 0;
    private float PlayerY = 1200;
    private volatile boolean idou = false;


    //テスト用インスタンス
    private MyView myView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // レイアウトの設定
        //RelativeLayout relativeLayout = new RelativeLayout(this);
        // 垂直方向
        //relativeLayout.setRotation(LinearLayout.VERTICAL);
        // linearLayoutをContentViewにセット
        setContentView(new Surface_View(getApplicationContext()));




    }


    }