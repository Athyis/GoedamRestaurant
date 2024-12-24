package com.example.poject_goedamresturant;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button tchange_btn,gamestart_btn;
    ImageView blur_title;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tchange_btn = findViewById(R.id.tchange_btn);
        gamestart_btn = findViewById(R.id.gamestart_btn);
        blur_title = findViewById(R.id.blur_title);

        // 시작화면에 '인육먹기'버튼 클릭시 title,게임시작 버튼로 변환
        tchange_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                blur_title.setVisibility(View.INVISIBLE);
                gamestart_btn.setVisibility(View.VISIBLE);
                tchange_btn.setVisibility(View.GONE);
            }
        });

        // '게임시작' 버튼 클릭시, 게임화면(GameMain)으로 이동
        gamestart_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent game_main = new Intent(getApplicationContext(), GameMain.class);
                startActivity(game_main);
                finish();
            }
         });
    }
}