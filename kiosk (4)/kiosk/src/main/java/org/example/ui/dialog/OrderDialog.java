package org.example.ui.dialog;

import org.example.model.MenuItem;
import org.example.model.Order;
import org.example.ui.MenuPanel;

import javax.swing.*;
import java.awt.*;
import org.example.ui.theme.TwoButton;
import org.example.ui.theme.TwoLabel;

public class OrderDialog extends JDialog {
    public OrderDialog(JFrame parent, MenuItem item, MenuPanel menuPanel) {
        super(parent, "PLACE ORDER", true);
        setLayout(new BorderLayout());

        // 상단에 상품명과 가격 표시
        JLabel itemLabel = new JLabel(item.getName() + " - " + item.getPrice() + " won", SwingConstants.CENTER);
        add(itemLabel, BorderLayout.NORTH);

        // 중앙에 수량 및 옵션 패널 배치
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // 수량 패널 설정
        JPanel quantityPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        quantityPanel.add(new TwoLabel("Quantity:"));
        SpinnerModel model = new SpinnerNumberModel(1, 1, 10, 1);
        JSpinner quantitySpinner = new JSpinner(model);
        quantitySpinner.setBorder(BorderFactory.createLineBorder(Color.GRAY, 3));
        quantitySpinner.setPreferredSize(new Dimension(50, 25));
        quantityPanel.add(quantitySpinner);

        // 옵션 패널 설정
        JPanel optionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        optionPanel.add(new TwoLabel("Option:"));
        JCheckBox optionHot = new JCheckBox("HOT");
        optionHot.setFont(new Font("Times New Roman", Font.BOLD, 13));
        optionPanel.add(optionHot);

        // 수량 및 옵션 패널을 중앙 패널에 추가
        centerPanel.add(quantityPanel);
        centerPanel.add(optionPanel);

        add(centerPanel, BorderLayout.CENTER);

        // 하단에 주문 버튼 추가
        JPanel buttonPanel = new JPanel();
        TwoButton confirmButton = new TwoButton("Order");
        confirmButton.addActionListener(e -> {
            int quantity = (int) quantitySpinner.getValue();
            menuPanel.addOrder(new Order(item, quantity));
            dispose();
        });
        buttonPanel.add(confirmButton);
        add(buttonPanel, BorderLayout.SOUTH);

        setSize(300, 200);
        setLocationRelativeTo(parent);
        setVisible(true);
    }
}
