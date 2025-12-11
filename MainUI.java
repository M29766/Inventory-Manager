import javax.swing.*;
import java.awt.*;

public class MainUI {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();

        // --- UI SETUP ---
        JFrame frame = new JFrame("Inventory Management System");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(6, 2, 10, 10)); // 6 Rows

        // Components
        JLabel barLabel = new JLabel("  Barcode (Scan here):");
        JTextField barField = new JTextField();

        JLabel nameLabel = new JLabel("  Product Name:");
        JTextField nameField = new JTextField();

        JLabel priceLabel = new JLabel("  Price:");
        JTextField priceField = new JTextField();

        JLabel stockLabel = new JLabel("  Stock Quantity:");
        JTextField stockField = new JTextField();

        // Buttons
        JButton findButton = new JButton("🔍 Find Product");
        JButton addButton = new JButton("➕ Add New Product");
        JButton updateButton = new JButton("🔄 Update Stock");
        JButton deleteButton = new JButton("❌ Delete Product");

        // Add to Frame
        frame.add(barLabel);
        frame.add(barField);
        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(priceLabel);
        frame.add(priceField);
        frame.add(stockLabel);
        frame.add(stockField);
        frame.add(findButton);
        frame.add(addButton);
        frame.add(updateButton);
        frame.add(deleteButton);

        // --- BUTTON LOGIC ---

        // 1. FIND
        findButton.addActionListener(e -> {
            String code = barField.getText();
            if (code.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please enter a barcode!");
                return;
            }
            Product p = manager.getProductByBarcode(code);
            if (p != null) {
                nameField.setText(p.getName());
                priceField.setText(String.valueOf(p.getPrice()));
                stockField.setText(String.valueOf(p.getStock()));
                JOptionPane.showMessageDialog(frame, "✅ Product Found!");
            } else {
                JOptionPane.showMessageDialog(frame, "❌ Product Not Found!");
                // Clear fields if not found
                nameField.setText("");
                priceField.setText("");
                stockField.setText("");
            }
        });

        // 2. ADD (With Error Checking)
        addButton.addActionListener(e -> {
            if (nameField.getText().isEmpty() || barField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "⚠️ Name and Barcode are required!");
                return;
            }
            try {
                String name = nameField.getText();
                String barcode = barField.getText();
                double price = Double.parseDouble(priceField.getText());
                int stock = Integer.parseInt(stockField.getText());

                if (price < 0 || stock < 0) {
                    JOptionPane.showMessageDialog(frame, "⚠️ Price/Stock cannot be negative!");
                    return;
                }

                if (manager.addProduct(name, barcode, price, stock)) {
                    JOptionPane.showMessageDialog(frame, "✅ Product Added Successfully!");
                    // Clear fields
                    nameField.setText("");
                    barField.setText("");
                    priceField.setText("");
                    stockField.setText("");
                } else {
                    JOptionPane.showMessageDialog(frame, "❌ Error: Barcode might already exist!");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "❌ Error: Price and Stock must be valid numbers!");
            }
        });

        // 3. UPDATE STOCK
        updateButton.addActionListener(e -> {
            String barcode = barField.getText();
            if (barcode.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please enter a barcode to update!");
                return;
            }
            try {
                int newStock = Integer.parseInt(stockField.getText());
                if (manager.updateStock(barcode, newStock)) {
                    JOptionPane.showMessageDialog(frame, "✅ Stock Updated!");
                } else {
                    JOptionPane.showMessageDialog(frame, "❌ Update Failed. Check Barcode.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "❌ Please enter a valid number for stock.");
            }
        });

        // 4. DELETE
        deleteButton.addActionListener(e -> {
            String barcode = barField.getText();
            if (barcode.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Enter Barcode to delete!");
                return;
            }
            int confirm = JOptionPane.showConfirmDialog(frame, "Are you sure you want to delete this product?");
            if (confirm == JOptionPane.YES_OPTION) {
                if (manager.deleteProduct(barcode)) {
                    JOptionPane.showMessageDialog(frame, "🗑️ Product Deleted!");
                    nameField.setText("");
                    barField.setText("");
                    priceField.setText("");
                    stockField.setText("");
                } else {
                    JOptionPane.showMessageDialog(frame, "❌ Delete Failed. Product not found.");
                }
            }
        });

        // Display
        frame.setVisible(true);
    }
}
