package com.example.poject_goedamresturant;

import java.util.ArrayList;
import java.util.List;

public class Event {
    private String story;
    private String choice1;
    private boolean c1_result;
    private String choice2;
    private boolean c2_result;
    private String choice3;
    private boolean c3_result;

    //이벤트 내용, 선택지, 선택지에 대한 결과에 대한 정보 담기
    public Event(String story, String choice1, boolean c1_result,
                 String choice2, boolean c2_result, String choice3, boolean c3_result) {
        this.story = story;
        this.choice1 = choice1;
        this.c1_result = c1_result;
        this.choice2 = choice2;
        this.c2_result = c2_result;
        this.choice3 = choice3;
        this.c3_result = c3_result;
    }
    //담긴 이벤트 호출 함수
    public String getStory() {
        return story;
    }
    //1번 선택지 호출 함수
    public String getChoice1() {
        return choice1;
    }
    //1번 선택지 결과 호출 함수
    public boolean getC1_Result() { return c1_result;}
    //2번 선택지 호출 함수
    public String getChoice2() {
        return choice2;
    }
    //2번 선택지 결과 호출 함수
    public boolean getC2_Result() { return c2_result; }
    //3번 선택지 호출 함수
    public String getChoice3() { return choice3; }
    //3번 선택지 결과 호출 함수
    public boolean getC3_Result() { return c3_result; }
    //이벤트를 담은 배열 생성
    private static final List<Event> eventData = new ArrayList<>();

    //이벤트 하드코딩
    static {
        eventData.add(new Event(
                "벨레인 숲의 아름답고 신비한 풍경에 시선이 사로잡혀 무작정 길을 걷다보니 주변에 사람이 없다. 길에 쳐진을 보아하니 정해진 경로는 맞는 거 같지만 아무래도 길을 잃은 것 같다.",
                "무작정 길을 따라 걷는다.", true,
                "다시 길을 잃을 걸 대비해서 나뭇가지에 밧줄을 묶는다.", true,
                "줄 너머에 사람이 보이는 거 같다. 넘어가자.", false
        ));
        eventData.add(new Event(
                "입구에서 멀어지자 어딘가에서 시선이 느껴진다. 무성한 숲 너머를 살펴보니 누군가 지켜보는 것 같다.",
                "호기심에 소리내서 불러본다.", false,
                "자세히 살펴보기 위해 다가간다.", false,
                "소름끼치는 시선을 무시하고 앞만 보고 걷는다.", true
        ));
        eventData.add(new Event(
                "어디선가 이상한 소리가 들리는 것 같다. 얼핏 들어보니 뱀이나 원숭이같은 야생동물이 아닌 굶주린 짐승의 울음소리 같아보인다.",
                "가던 길을 멈추고 가만히 서서 소리가 사라질 때까지 기다린다.", true,
                "동물의 소리를 잘 못 들은 건 아닌지 확인하기 위해 소리가 나는 쪽으로 접근한다.", false,
                "소리가 안 들리는 곳까지 빠르게 달려서 도망친다.", false
        ));
        eventData.add(new Event(
                "숲 속에 폭포가 있는 것을 보고 관광객 중 한 명이 단체사진을 찍자고 한다. 사진을 찍고나서 확인해보니 옆에 원숭이 무리가 같이 찍힌 것 같다.",
                "원숭이 무리만 없으면 잘 나왔으니 편집하라고 한다.", false,
                "사진을 지우는 게 좋겠다고 말한다.", true,
                "원숭이 무리를 더 가까이 보는 게 어떻냐고 물어본다.", false
        ));
        eventData.add(new Event(
                "조금 전까지만 해도 새소리가 들렸는데, 지금은 이상하리 만치 아무런 소리도 들리지 않는다. 심지어 바람에 나무가 흔들리는데도 바람소리가 전혀 들리지 않는다.",
                "신기함에 소리를 질러본다.", false,
                "조용한 분위기를 만끽하며 천천히 길을 걷는다.", false,
                "무서워서 소리가 나는 방향으로 뛴다.", true
        ));
        eventData.add(new Event(
                "저 멀리서 사람 모습이 보인다. 자세히 보니 한복을 입을 사람들이 우리 쪽으로 다가오고 있다. 옷차림을 보아하니 다른 관광객인 것처럼 보인다.",
                "어디에서 온 건지 말을 건네본다.", false,
                "모르는 사람이니 그냥 무시하고 걷는다.", true,
                "차림을 보아하니 한국인인 거 같으니 손 내밀어 인사한다.", false
        ));
    }
    //이벤트를 담은 배열 호출 함수
    public static List<Event> getEventData() {
        return eventData;
    }
}
