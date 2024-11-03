package org.example.ui;

import org.example.model.MenuItem;
import org.example.model.Order;
import org.example.model.OrderManager;
import org.example.ui.dialog.OrderDialog;
import org.example.ui.dialog.PaymentDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import org.example.ui.theme.TwoButton;
import org.example.ui.theme.TwoCategoryLabel;
import org.example.ui.theme.TwoLabel;
import org.example.ui.theme.TwoPanel;

public class MenuPanel {
    private JPanel menuPanel, itemListPanel, orderPanel, totalPanel;
    private JLabel totalLabel;
    private OrderManager orderManager = new OrderManager();
    private KioskManager kioskManager;

    public MenuPanel(KioskManager kioskManager) {
        this.kioskManager = kioskManager;
        menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));

        // 로고 패널 설정
        JPanel logoPanel = new JPanel();
        logoPanel.setBackground(Color.DARK_GRAY);
        JLabel logoLabel = new JLabel(new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource("images/util/logo4.jpg"))
                .getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)), SwingConstants.CENTER);
        logoPanel.add(logoLabel);

        // 카테고리와 홈 버튼 패널 설정
        JPanel categoryPanel = new JPanel(new BorderLayout());
        categoryPanel.setBackground(Color.DARK_GRAY);

        // 홈 이미지 설정 및 메인 화면으로 이동 기능
        JLabel homeLabel = new JLabel(new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource("images/util/home.png"))
                .getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
        homeLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        homeLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                kioskManager.showMainPanel(); // 메인 패널로 돌아가기
            }
        });
        categoryPanel.add(homeLabel, BorderLayout.WEST);

        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 35, 5));
        centerPanel.setBackground(Color.DARK_GRAY);
        centerPanel.add(createCategoryLabel("Coffee"));
        centerPanel.add(createCategoryLabel("Beverage"));
        centerPanel.add(createCategoryLabel("Dessert"));
        centerPanel.add(createCategoryLabel("Sandwich/Salad"));
        categoryPanel.add(centerPanel, BorderLayout.CENTER);

        // 주문 내역 패널 설정
        itemListPanel = new JPanel(new GridLayout(2, 3, 15, 15));
        itemListPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        orderPanel = new JPanel();
        orderPanel.setLayout(new BoxLayout(orderPanel, BoxLayout.Y_AXIS));
        orderPanel.setBackground(Color.GRAY);
        JScrollPane scrollPane = new JScrollPane(orderPanel);
        scrollPane.setPreferredSize(new Dimension(580, 200));

        // 총 금액 및 결제 버튼
        totalPanel = new JPanel(new BorderLayout());
        totalLabel = new TwoLabel("Total Price: ");
        TwoButton payButton = new TwoButton("Payment");
        payButton.addActionListener(e -> new PaymentDialog(kioskManager.getFrame(), orderManager, kioskManager));

        totalPanel.add(totalLabel, BorderLayout.WEST);
        totalPanel.add(payButton, BorderLayout.EAST);

        menuPanel.add(logoPanel);
        menuPanel.add(categoryPanel);
        menuPanel.add(itemListPanel);
        menuPanel.add(scrollPane);
        menuPanel.add(totalPanel);

        updateItems("coffee");
    }

    // 카테고리 레이블 생성 및 클릭 시 아이템 업데이트
    private JLabel createCategoryLabel(String text) {
        TwoCategoryLabel label = new TwoCategoryLabel(text);
        label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                updateItems(text.toLowerCase());
            }
        });
        return label;
    }

    // 카테고리별 아이템 정보 업데이트(이미지, 상품명, 가격)
    private void updateItems(String category) {
        itemListPanel.removeAll();

        MenuItem[] items;
        switch (category) {
            case "coffee":
                items = new MenuItem[]{
                        new MenuItem("Americano", 4500, "images/coffee/Ice Coffee.png"),
                        new MenuItem("White Mocha", 5400, "images/coffee/Ice White Mocha.png"),
                        new MenuItem("Cold Brew Tonic", 6000, "images/coffee/Cold Brew Tonic.png"),
                        new MenuItem("Nitro Cold Brew", 6300, "images/coffee/Nitro Cold Brew.png"),
                        new MenuItem("Tiramisu Latte", 5800, "images/coffee/Tiramisu Latte.png"),
                        new MenuItem("Caramel Macchiato", 5600, "images/coffee/Ice Caramel Macchiato.png"),
                };
                break;
            case "beverage":
                items = new MenuItem[]{
                        new MenuItem("Caramel Frappe", 5300, "images/beverage/Caramel Frappe.png"),
                        new MenuItem("Choco Shake", 5000, "images/beverage/Choco Shake.png"),
                        new MenuItem("Grapefruit Ade", 5500, "images/beverage/Grapefruit Ade.png"),
                        new MenuItem("Kiwi Banana Juice", 5500, "images/beverage/Kiwi Banana Juice.png"),
                        new MenuItem("Orange Ade", 5500, "images/beverage/Orange Ade.png"),
                        new MenuItem("Strawberry Latte", 5500, "images/beverage/Strawberry Latte.png"),
                };
                break;
            case "dessert":
                items = new MenuItem[]{
                        new MenuItem("Blanc Cheese Berry", 6000, "images/dessert/Blanc Cheese berry.png"),
                        new MenuItem("Pecan Tart", 6500, "images/dessert/Pecan Tart.png"),
                        new MenuItem("Cream Brulee", 6200, "images/dessert/Cream Brulee.png"),
                        new MenuItem("Berry Mousse", 6000, "images/dessert/Berry Mousse.png"),
                        new MenuItem("Chocolate Ganache", 5900, "images/dessert/Chocolate Ganache.png"),
                        new MenuItem("Tiramisu", 5600, "images/dessert/Tiramisu.png"),
                };
                break;
            case "sandwich/salad":
                items = new MenuItem[]{
                        new MenuItem("Bulgogi Bake", 6000, "images/sandwich/Bulgogi Bake.png"),
                        new MenuItem("Hot Chicken Bake", 6000, "images/sandwich/Hot Chicken Bake.png"),
                        new MenuItem("Carprese Sandwich", 5000, "images/sandwich/Carprese Sandwich.png"),
                        new MenuItem("Chicken Sandwich", 5000, "images/sandwich/Chicken Omelet Sandwich.png"),
                        new MenuItem("Carprese Salad", 6500, "images/sandwich/Carprese Salad.png"),
                        new MenuItem("Side Salad", 3500, "images/sandwich/Side Salad.png"),
                };
                break;
            default:
                items = new MenuItem[0];
        }

        // 아이템 패널 설정
        for (MenuItem item : items) {
            JPanel itemPanel = new JPanel(new BorderLayout());
            itemPanel.setBackground(Color.DARK_GRAY);

            JLabel imageLabel = new JLabel(new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource(item.getImagePath()))
                    .getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
            JLabel nameLabel = new JLabel(item.getName(), SwingConstants.CENTER);
            TwoLabel priceLabel = new TwoLabel(item.getPrice() + " won");
            priceLabel.setAlignmentX(SwingConstants.CENTER);

            JPanel textPanel = new JPanel();
            textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
            textPanel.setBackground(Color.WHITE);
            nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            priceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            textPanel.add(nameLabel);
            textPanel.add(priceLabel);

            itemPanel.add(imageLabel, BorderLayout.CENTER);
            itemPanel.add(textPanel, BorderLayout.SOUTH);

            itemPanel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    new OrderDialog(kioskManager.getFrame(), item, MenuPanel.this);
                }
            });
            itemListPanel.add(itemPanel);
        }
        itemListPanel.revalidate();
        itemListPanel.repaint();
    }

    // 주문 내역 패널 레이아웃 설정
    public void addOrder(Order order) {
        // 주문을 OrderManager에 추가
        orderManager.addOrder(order);

        // 사용자 정의 패널 TwoPanel 사용
        TwoPanel singleOrderPanel = new TwoPanel();
        singleOrderPanel.setLayout(new GridBagLayout());
        singleOrderPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        singleOrderPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // 가로는 최대 확장하고, 세로는 고정 크기로 설정
        singleOrderPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40)); // 가로는 최대, 세로는 고정

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 5, 0, 5); // 구성 요소 간의 간격 설정

        // 상품명 레이블 설정
        gbc.gridx = 0;
        gbc.weightx = 1.0;
        TwoLabel orderLabel = new TwoLabel(order.getMenuItem().getName());
        singleOrderPanel.add(orderLabel, gbc);

        // - 버튼 설정
        gbc.gridx = 1;
        gbc.weightx = 0;
        JButton minusButton = new JButton("-");
        styleButton(minusButton);
        singleOrderPanel.add(minusButton, gbc);

        // 수량 레이블 설정
        gbc.gridx = 2;
        JLabel quantityLabel = new JLabel(String.valueOf(order.getQuantity()));
        quantityLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        singleOrderPanel.add(quantityLabel, gbc);

        // + 버튼 설정
        gbc.gridx = 3;
        JButton plusButton = new JButton("+");
        styleButton(plusButton);
        singleOrderPanel.add(plusButton, gbc);

        // 가격 레이블 설정
        gbc.gridx = 4;
        TwoLabel priceLabel = new TwoLabel(order.getTotalPrice() + " Won ");
        priceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        priceLabel.setPreferredSize(new Dimension(100, 25));
        singleOrderPanel.add(priceLabel, gbc);

        // 삭제(x) 버튼 설정
        gbc.gridx = 5;
        JButton deleteButton = new JButton("x");
        styleButton(deleteButton);
        singleOrderPanel.add(deleteButton, gbc);

        // 버튼 이벤트 처리
        minusButton.addActionListener(e -> {
            if (order.getQuantity() > 1) {
                order.decreaseQuantity();
                quantityLabel.setText(String.valueOf(order.getQuantity()));
                priceLabel.setText(order.getTotalPrice() + " Won ");
                updateTotal();
            }
        });

        plusButton.addActionListener(e -> {
            order.increaseQuantity();
            quantityLabel.setText(String.valueOf(order.getQuantity()));
            priceLabel.setText(order.getTotalPrice() + " Won ");
            updateTotal();
        });

        deleteButton.addActionListener(e -> {
            orderPanel.remove(singleOrderPanel);
            orderPanel.revalidate();
            orderPanel.repaint();
            orderManager.removeOrder(order);
            updateTotal();
        });

        // orderPanel에 사용자 정의 패널 추가
        orderPanel.add(singleOrderPanel);
        orderPanel.setLayout(new BoxLayout(orderPanel, BoxLayout.Y_AXIS)); // 세로로 나열
        orderPanel.revalidate();
        orderPanel.repaint();
        updateTotal();
    }

    private void styleButton(JButton button) {
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 16));
    }

    private void updateTotal() {
        int total = orderManager.calculateTotal();
        totalLabel.setText("Total Price: " + total + " ₩");
    }

    public JPanel getPanel() {
        return menuPanel;
    }
}