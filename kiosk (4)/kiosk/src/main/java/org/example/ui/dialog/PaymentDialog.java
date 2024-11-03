package org.example.ui.dialog;

import org.example.model.Order;
import org.example.model.OrderManager;
import org.example.ui.KioskManager;
import org.example.ui.theme.TwoButton;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class PaymentDialog extends JDialog {
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public PaymentDialog(JFrame parent, OrderManager orderManager, KioskManager kioskManager) {
        super(parent, "Receipt", true);
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // 헤더 정보 설정
        StringBuilder headerInfo = new StringBuilder();
        headerInfo.append("\t\t\tRECEIPT\n")
                .append("[Store Name] A Twosome Place\n")
                .append("[Address] 123 Gwangjin-gu, Seoul\n")
                .append("[Phone] 02-123-4567\n")
                .append("[Date] ").append(dateFormat.format(Calendar.getInstance().getTime()))
                .append("\n")
                .append("========================================================\n")
                .append("   Item                   Unit Price   Qty       Amount\n")
                .append("--------------------------------------------------------\n");

        // 주문 내역
        StringBuilder orderDetails = new StringBuilder();
        int totalAmount = 0;

        for (Order order : orderManager.getOrders()) {
            String itemName = order.getMenuItem().getName();
            int unitPrice = order.getMenuItem().getPrice();
            int quantity = order.getQuantity();
            int amount = order.getTotalPrice();

            totalAmount += amount;

            // 각 주문 항목을 정렬된 열로 추가
            orderDetails.append(String.format(" %-20s %12d %6d %12d\n", itemName, unitPrice, quantity, amount));
        }

        // 총액과 부가세 계산 및 표시
        int vat = (int) (totalAmount * 0.1);
        int subtotal = totalAmount - vat;

        // "Amount" 열에 맞춰진 총액 정보 추가
        StringBuilder footerInfo = new StringBuilder();
        footerInfo.append("--------------------------------------------------------\n")
                .append(String.format(" Subtotal:%31s %12d\n", "", subtotal))
                .append(String.format(" VAT:%36s %12d\n", "", vat))
                .append("--------------------------------------------------------\n")
                .append(String.format(" Total Amount:%27s %12d\n", "", totalAmount))
                .append("========================================================\n")
                .append("Payment Method: Cash\n")
                .append("Authorization No: 12345678\n")
                .append("Payment Date: ").append(dateFormat.format(Calendar.getInstance().getTime()));

        // 헤더, 주문 내역, 총액 정보 조합하여 표시
        String receiptText = headerInfo.toString() + orderDetails.toString() + footerInfo.toString();

        // 영수증 텍스트 영역 설정
        JTextArea receiptTextArea = new JTextArea(receiptText);
        receiptTextArea.setFont(new Font("Monospaced", Font.BOLD, 13));
        receiptTextArea.setEditable(false);
        receiptTextArea.setBackground(Color.WHITE);
        receiptTextArea.setLineWrap(true);
        receiptTextArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(receiptTextArea);
        scrollPane.setPreferredSize(new Dimension(535, 500));
        add(scrollPane, BorderLayout.CENTER);

        // 닫기 버튼 설정
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        TwoButton closeButton = new TwoButton("Close");
        closeButton.addActionListener(e -> {
            orderManager.clearOrders(); // 주문 내역 초기화
            kioskManager.showMainPanel(); // 메인 패널로 돌아가기
            dispose(); // 다이얼로그 닫기
        });
        buttonPanel.add(closeButton);
        add(buttonPanel, BorderLayout.SOUTH);

        setSize(500, 620);
        setLocationRelativeTo(parent);
        setVisible(true);
    }
}
