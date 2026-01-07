package Izgled;

import javax.swing.*;

public class GlavniMeni {

    private JPanel glavniPanel;

    // dugmad koju sam nacrtao
    private JButton btnAccount;
    private JButton btnMeal;
    private JButton btnFinance;
    private JButton btnStudy;
    private JButton btnHabit;
    private JButton btnSleep;

    public GlavniMeni() {
        // akcija za dugme account details otvaram onaj prozor za uredi profil
        btnAccount.addActionListener(e -> {
            JFrame frame = new JFrame("Uredi Profil");
            UrediProfil uredi = new UrediProfil(); // pozivam moju klasu za profil
            frame.setContentPane(uredi.getGlavniPanel());
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // ugasi samo taj prozor
            frame.pack();
            frame.setLocationRelativeTo(null); // baci prozor na centar
            frame.setVisible(true);
        });

        // ostala dugmad zasad samo bacaju poruku
        btnFinance.addActionListener(e -> {
            JOptionPane.showMessageDialog(glavniPanel, "Ovo jos trebam napravit...");
        });

        btnSleep.addActionListener(e -> {
            JOptionPane.showMessageDialog(glavniPanel, "Tracker za spavanje...");
        });
    }

    // metoda da main moze povuc panel i pokazat ga
    public JPanel getGlavniPanel() {
        return glavniPanel;
    }
}