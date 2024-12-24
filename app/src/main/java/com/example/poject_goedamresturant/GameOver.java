package com.example.poject_goedamresturant;

import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class GameOver extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameover);

        // gameover시, 해당화면을 3초간 보여주고 앱 종료
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 액티비티 종료
                finishAffinity();
                System.runFinalization();
                System.exit(0);
            }
        }, 3000);
    }
}