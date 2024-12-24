package com.example.poject_goedamresturant;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameMain extends AppCompatActivity {
    TextView storyTextView;
    Button choiceBtn1,choiceBtn2,choiceBtn3,rule;
    ImageView mental1,mental2;
    private List<Event> events;
    private List<Event> remainEvents;
    private int currentEventIndex;
    Integer chance = 2;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_main);

        rule = findViewById(R.id.rule);
        storyTextView = findViewById(R.id.storyTextView);
        choiceBtn1 = findViewById(R.id.choiceBtn1);
        choiceBtn2 = findViewById(R.id.choiceBtn2);
        choiceBtn3 = findViewById(R.id.choiceBtn3);
        mental1 = findViewById(R.id.mental1);
        mental2 = findViewById(R.id.mental2);


        //Evnet.java에서 이벤트들 호출 및 저장
        events = Event.getEventData();
        remainEvents = new ArrayList<>(events);

        //이벤트 실행
        loadNextEvent();


        //  규칙버튼 클릭시 RuleBook을 호출
        rule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rulebook = new Intent(getApplicationContext(), RuleBook.class);
                startActivity(rulebook);
            }
        });

        //랜덤 이벤트로부터 선택지 받기
        choiceBtn1.setOnClickListener(v -> Choice(1));
        choiceBtn2.setOnClickListener(v -> Choice(2));
        choiceBtn3.setOnClickListener(v -> Choice(3));
    }

    //이벤트 가져오기
    private void loadNextEvent() {
        if (remainEvents.isEmpty()) {
            // 모든 이벤트 클리어시 GameClear.java로 이동
            Intent game_clear = new Intent(getApplicationContext(), GameClear.class);
            startActivity(game_clear);
            finish();
        } else {
            // 랜덤으로 남은 이벤트 중 하나 선택
            currentEventIndex = getRandomEventIndex();
            if (currentEventIndex != -1) {
                Event event = remainEvents.get(currentEventIndex);
                storyTextView.setText(event.getStory());
                choiceBtn1.setText(event.getChoice1());
                choiceBtn2.setText(event.getChoice2());
                choiceBtn3.setText(event.getChoice3());
            }
        }
    }

    // 이벤트 선택 처리
    private void Choice(int choiceNumber) {
        Event event = remainEvents.get(currentEventIndex);
        boolean result;

        //선택지에 대한 정답 반환
        switch (choiceNumber) {
            case 1:
                result = event.getC1_Result();
                break;
            case 2:
                result = event.getC2_Result();
                break;
            case 3:
                result = event.getC3_Result();
                break;
            default:
                return;
        }

        // 결과에 따라 행동 처리
        if (result) {
            // 성공시 다음 이벤트 로드
            remainEvents.remove(currentEventIndex);
            loadNextEvent();
        } else { //실패시 기회 차감 후, 다음 이벤트 로드
            chance--;
            if (chance == 1) {
                mental2.setVisibility(View.INVISIBLE);
            } else if (chance == 0){ // 모든 기회 소진 시, Gameover.jav로 이동
                Intent game_over = new Intent(getApplicationContext(), GameOver.class);
                startActivity(game_over);
                finish();
            }
            remainEvents.remove(currentEventIndex);
            loadNextEvent();
        }
    }

    // 랜덤 이벤트 인덱스 생성
    private int getRandomEventIndex() {
        if (!remainEvents.isEmpty()) {
            Random random = new Random();
            return random.nextInt(remainEvents.size());
        }
        return -1;
    }
}