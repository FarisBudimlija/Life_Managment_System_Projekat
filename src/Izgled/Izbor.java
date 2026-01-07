package Izgled;

import javax.swing.*;

public class Izbor {

    private JPanel GlavniPanel;
    private JButton dugmeProfil;
    private JButton dugmeFinansije;
    private JButton dugmeTrackeri;

    public Izbor() {
        // 1. Akcija za dugme Profil
        dugmeProfil.addActionListener(e -> {
            JFrame frameProfil = new JFrame("Uređivanje Profila");
            UrediProfil forma = new UrediProfil(); // Poziva tvoju novu klasu

            frameProfil.setContentPane(forma.getGlavniPanel());
            frameProfil.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Zatvara samo taj prozor
            frameProfil.pack();
            frameProfil.setLocationRelativeTo(null); // Centrira na ekranu
            frameProfil.setVisible(true);
        });

        // 2. Akcija za FinanceApp dugme
        dugmeFinansije.addActionListener(e -> {
            // pravim prozor za glavni meni
            JFrame frameMeni = new JFrame("Life Management System - Main Menu");
            GlavniMeni meni = new GlavniMeni();

            frameMeni.setContentPane(meni.getGlavniPanel()); // ubacujem panel iz klase
            frameMeni.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // gasi sve kad izadjem
            frameMeni.setSize(800, 500); // velicina ko na slici sto sam poslo
            frameMeni.setLocationRelativeTo(null);
            frameMeni.setVisible(true);

            // gasim onaj mali prozor izbora
            SwingUtilities.getWindowAncestor(GlavniPanel).dispose();
        });

        // 3. Akcija za Trackere
        dugmeTrackeri.addActionListener(e -> {
            JOptionPane.showMessageDialog(GlavniPanel, "Trackeri su u fazi izrade.");
        });
    }

    // Ova metoda je ključna da bi Main mogao prikazati prozor
    public JPanel getGlavniPanel() {
        return GlavniPanel;
    }
}