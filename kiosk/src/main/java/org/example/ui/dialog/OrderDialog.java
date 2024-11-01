package org.example.ui.dialog;

import org.example.model.MenuItem;
import org.example.model.Order;
import org.example.ui.MenuPanel;

import javax.swing.*;
import java.awt.*;

public class OrderDialog extends JDialog {
    public OrderDialog(JFrame parent, MenuItem item, MenuPanel menuPanel) {
        super(parent, "주문하기", true);
        setLayout(new BorderLayout());

        JLabel itemLabel = new JLabel(item.getName() + " - " + item.getPrice() + "원", SwingConstants.CENTER);
        add(itemLabel, BorderLayout.NORTH);

        JPanel quantityPanel = new JPanel();
        quantityPanel.add(new JLabel("Quantity:"));
        SpinnerModel model = new SpinnerNumberModel(1, 1, 10, 1);
        JSpinner quantitySpinner = new JSpinner(model);
        quantityPanel.add(quantitySpinner);
        add(quantityPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton confirmButton = new JButton("Order");
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
