package Izgled;

import Servis.FinanceServis;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FinanceTracker {
    private JPanel glavniPanel;
    private JTable tabelaFinansija;
    private JTextField kafaTextField;
    private JTextField textField1;
    private JButton dodajTrošakButton;


    private FinanceServis servis = new FinanceServis();

    public FinanceTracker() {
        // pravim kolone za tabelu
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Stavka");
        model.addColumn("Iznos (KM)");

        // povezujem ovaj model sa tabelom iz dizajnera
        tabelaFinansija.setModel(model);

        // akcija kad kliknem na dugme "Dodaj Trosak"
        dodajTrošakButton.addActionListener(e -> {
            String naziv = kafaTextField.getText(); // uzimam sta sam kupio
            String pare = textField1.getText();    // uzimam kolko kosta

            // provjera da nije ostalo prazno
            if (naziv.isEmpty() || pare.isEmpty()) {
                JOptionPane.showMessageDialog(glavniPanel, "Moras upisat i sta i kolko!");
                return;
            }

            // ubacujem u tabelu to sto sam napiso da vidim odmah
            model.addRow(new Object[]{naziv, pare});


            servis.dodajTrosak(naziv, pare);

            // brise tekst iz polja
            kafaTextField.setText("");
            textField1.setText("");

            System.out.println("Dodano u listu i bazu: " + naziv + " " + pare + " KM");
        });
    }

    // ovo moram imati da bi prozor radio
    public JPanel getGlavniPanel() {
        return glavniPanel;
    }
}