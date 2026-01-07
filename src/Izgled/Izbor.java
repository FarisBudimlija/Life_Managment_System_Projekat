package Izgled;

import javax.swing.*;

public class Izbor {

    private JPanel GlavniPanel;
    private JButton dugmeProfil;
    private JButton dugmeFinansije;
    private JButton dugmeTrackeri;

    public Izbor() {
        // Akcija za FinanceApp dugme
        dugmeFinansije.addActionListener(e -> {
            JOptionPane.showMessageDialog(GlavniPanel, "Otvaram FinanceApp...");
            // prelaz na GlavniMeni
        });
    }

    // Ova metoda je ključna da bi Main mogao prikazati prozor
    public JPanel getGlavniPanel() {
        return GlavniPanel;
    }
}