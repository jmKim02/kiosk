package org.example.model;

public class Order {
    private MenuItem menuItem;
    private int quantity;

    public Order(MenuItem menuItem, int quantity) {
        this.menuItem = menuItem;
        this.quantity = quantity;
    }

    // 수량 증가
    public void increaseQuantity() {
        quantity++;
    }

    // 수량 감소
    public void decreaseQuantity() {
        if (quantity > 1) quantity--;
    }

    // 총 가격 계산 (단가 * 수량)
    public int getTotalPrice() {
        return menuItem.getPrice() * quantity;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return menuItem.getName() + " ";
    }
}
