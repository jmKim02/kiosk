package org.example.model;

public class MenuItem {
    private String name;
    private int price;
    private String imagePath; // 이미지 경로를 저장할 필드

    public MenuItem(String name, int price, String imagePath) {
        this.name = name;
        this.price = price;
        this.imagePath = imagePath; // 이미지 경로 초기화
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getImagePath() {
        return imagePath; // 이미지 경로를 반환하는 메소드 추가
    }

    @Override
    public String toString() {
        return name + " - " + price + "원";
    }
}