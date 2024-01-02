package com.example.mariooooo;

public class scroll extends Thread{

    Surface_View SV;

    public scroll(Surface_View SV,int scroll_Num){
        this.SV = SV;
    }

    //横遷移用スレッド 一定時間ごとにdraw()メソッドを呼び出す
    @Override
    public void run() {
        try {
            while(true) {
                Thread.sleep(300);
                SV.setScroll_Num(SV.getScroll_Num() + 1); //時間経過とともに変数をプラスして横にスクロールする。
                System.out.println(SV.getScroll_Num());
                SV.draw();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
