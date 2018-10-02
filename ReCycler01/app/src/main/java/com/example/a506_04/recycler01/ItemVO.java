package com.example.a506_04.recycler01;


// RecyclerView에 표현할 데이터를 담은 VO 클래스
public class ItemVO {
    private String strName;

    // default 생성자
    public ItemVO() {
    }

    // 맴버변수 초기화 생성자
    public ItemVO(String strName) {
        this.strName = strName;
    }

    public String getStrName() {
        return strName;
    }

    public void setStrName(String strName) {
        this.strName = strName;
    }
}
