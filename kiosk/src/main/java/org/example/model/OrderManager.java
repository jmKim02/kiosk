package org.example.model;

import java.util.ArrayList;

public class OrderManager {
    private ArrayList<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void removeOrder(Order order) {
        orders.remove(order);
    }

    // 전체 주문 총 금액 계산
    public int calculateTotal() {
        int total = 0;
        for (Order order : orders) {
            total += order.getTotalPrice();
        }
        return total;
    }

    // 전체 주문 목록 반환
    public ArrayList<Order> getOrders() {
        return orders;
    }

    // 전체 주문 초기화 (결제 완료 후)
    public void clearOrders() {
        orders.clear();
    }
}