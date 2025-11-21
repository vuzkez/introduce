package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Главный класс графического интерфейса для управления деталями
 * 
 * @author Ярик
 * @version 1.0
 */
public class DetailGUI extends JFrame {
    private DetailRepository repository;
    private JTable detailsTable;
    private DefaultTableModel tableModel;
    private JComboBox<String> detailTypeComboBox;
    private JComboBox<String> shapeComboBox;
    private JComboBox<String> materialComboBox;
    private JTextField weightField;
    private JTextField sizeField;

    public DetailGUI() {
        repository = new DetailRepository();
        initializeGUI();
        loadSampleData();
    }

    private void initializeGUI() {
        setTitle("Система управления деталями");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);

        // Создание основной панели
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Панель для формы ввода
        mainPanel.add(createInputPanel(), BorderLayout.NORTH);
        
        // Панель для таблицы
        mainPanel.add(createTablePanel(), BorderLayout.CENTER);
        
        // Панель для кнопок управления
        mainPanel.add(createControlPanel(), BorderLayout.SOUTH);

        add(mainPanel);
    }

    private JPanel createInputPanel() {
        JPanel inputPanel = new JPanel(new GridLayout(2, 5, 5, 5));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Добавить/Обновить деталь"));

        // Инициализация компонентов
        detailTypeComboBox = new JComboBox<>(new String[]{"MetalDetail", "PlasticDetail", "WoodenDetail", "GoldenDetail"});
        shapeComboBox = new JComboBox<>(new String[]{"Круг", "Квадрат", "Треугольник", "Прямоугольник", "Овал"});
        materialComboBox = new JComboBox<>(new String[]{"Металл", "Пластик", "Дерево", "Золото"});
        weightField = new JTextField();
        sizeField = new JTextField();

        // Добавление компонентов на панель
        inputPanel.add(new JLabel("Тип детали:"));
        inputPanel.add(new JLabel("Форма:"));
        inputPanel.add(new JLabel("Материал:"));
        inputPanel.add(new JLabel("Вес:"));
        inputPanel.add(new JLabel("Размер:"));

        inputPanel.add(detailTypeComboBox);
        inputPanel.add(shapeComboBox);
        inputPanel.add(materialComboBox);
        inputPanel.add(weightField);
        inputPanel.add(sizeField);

        return inputPanel;
    }

    private JPanel createTablePanel() {
        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBorder(BorderFactory.createTitledBorder("Список деталей"));

        // Создание модели таблицы
        String[] columnNames = {"№", "Тип", "Форма", "Материал", "Вес", "Размер"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Запрещаем редактирование ячеек
            }
        };

        detailsTable = new JTable(tableModel);
        detailsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(detailsTable);

        tablePanel.add(scrollPane, BorderLayout.CENTER);
        return tablePanel;
    }

    private JPanel createControlPanel() {
        JPanel controlPanel = new JPanel(new FlowLayout());

        JButton addButton = new JButton("Добавить деталь");
        JButton deleteButton = new JButton("Удалить выбранную деталь");
        JButton updateButton = new JButton("Заменить выбранную деталь");

        // Обработчики событий
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addDetail();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteDetail();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateSelectedDetail();
            }
        });

        controlPanel.add(addButton);
        controlPanel.add(deleteButton);
        controlPanel.add(updateButton);

        return controlPanel;
    }

    private void addDetail() {
        try {
            Detail detail = createDetailFromForm();
            if (detail != null) {
                repository.addDetail(detail);
                refreshTable();
                clearForm();
                JOptionPane.showMessageDialog(this, "Деталь успешно добавлена!", "Успех", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Ошибка при добавлении детали: " + ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteDetail() {
        int selectedRow = detailsTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Пожалуйста, выберите деталь для удаления", "Внимание", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, 
            "Вы уверены, что хотите удалить выбранную деталь?", 
            "Подтверждение удаления", 
            JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                Detail removedDetail = repository.removeDetail(selectedRow);
                refreshTable();
                JOptionPane.showMessageDialog(this, "Деталь удалена: " + removedDetail.getDetailType(), "Успех", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Ошибка при удалении детали: " + ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void updateSelectedDetail() {
        int selectedRow = detailsTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Пожалуйста, выберите деталь для замены", "Внимание", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            Detail newDetail = createDetailFromForm();
            if (newDetail != null) {
                Detail oldDetail = repository.updateDetail(selectedRow, newDetail);
                refreshTable();
                clearForm();
                JOptionPane.showMessageDialog(this, 
                    "Деталь успешно заменена!\nСтарая: " + oldDetail.getDetailType() + 
                    "\nНовая: " + newDetail.getDetailType(), 
                    "Успех", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Ошибка при замене детали: " + ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    private Detail createDetailFromForm() {
        try {
            String detailType = (String) detailTypeComboBox.getSelectedItem();
            String shapeName = (String) shapeComboBox.getSelectedItem();
            String materialName = (String) materialComboBox.getSelectedItem();
            double weight = Double.parseDouble(weightField.getText().trim());
            double size = Double.parseDouble(sizeField.getText().trim());

            if (weight <= 0 || size <= 0) {
                throw new IllegalArgumentException("Вес и размер должны быть положительными числами");
            }

            Shape shape = new Shape(shapeName);
            Material material = new Material(materialName);

            switch (detailType) {
                case "MetalDetail":
                    return new MetalDetail(shape, material, weight, size);
                case "PlasticDetail":
                    return new PlasticDetail(shape, material, weight, size);
                case "WoodenDetail":
                    return new WoodenDetail(shape, material, weight, size);
                case "GoldenDetail":
                    return new GoldenDetail(shape, material, weight, size);
                default:
                    throw new IllegalArgumentException("Неизвестный тип детали: " + detailType);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Вес и размер должны быть числами", "Ошибка ввода", JOptionPane.ERROR_MESSAGE);
            return null;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    private void refreshTable() {
        tableModel.setRowCount(0); // Очищаем таблицу

        for (int i = 0; i < repository.size(); i++) {
            Detail detail = repository.getDetail(i);
            Object[] rowData = {
                i + 1,
                detail.getDetailType(),
                detail.getShape().getType(),
                detail.getMaterial().getName(),
                detail.getWeight(),
                detail.getSize()
            };
            tableModel.addRow(rowData);
        }
    }

    private void clearForm() {
        weightField.setText("");
        sizeField.setText("");
        detailTypeComboBox.setSelectedIndex(0);
        shapeComboBox.setSelectedIndex(0);
        materialComboBox.setSelectedIndex(0);
    }

    private void loadSampleData() {
        // Загрузка тестовых данных
        try {
            Shape circle = new Shape("Круг");
            Shape square = new Shape("Квадрат");
            Material metal = new Material("Металл");
            Material plastic = new Material("Пластик");
            Material wood = new Material("Дерево");
            Material gold = new Material("Золото");

            repository.addDetail(new MetalDetail(circle, metal, 2.5, 5.0));
            repository.addDetail(new PlasticDetail(square, plastic, 1.2, 3.0));
            repository.addDetail(new WoodenDetail(new Shape("Треугольник"), wood, 0.8, 2.5));
            repository.addDetail(new GoldenDetail(new Shape("Круг"), gold, 0.5, 1.0));

            refreshTable();
        } catch (Exception ex) {
            System.err.println("Ошибка при загрузке тестовых данных: " + ex.getMessage());
        }
    }
}