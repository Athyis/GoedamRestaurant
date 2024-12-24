package com.example.poject_goedamresturant;

import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class GameClear extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_clear);

        // gameclear시, 해당화면을 3초간 보여주고 앱 종료
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                finishAffinity();
                System.runFinalization();
                System.exit(0);
            }
        }, 3000);
    }
}