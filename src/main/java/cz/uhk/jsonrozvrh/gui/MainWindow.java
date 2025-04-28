package cz.uhk.jsonrozvrh.gui;

import cz.uhk.jsonrozvrh.model.Akce;
import cz.uhk.jsonrozvrh.model.RozvrhovaAkce;
import cz.uhk.jsonrozvrh.network.StagDataLoader;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainWindow extends JFrame {
    private JComboBox<String> buildingCombo, roomCombo;
    private JButton loadButton;
    private JTable table;
    private ScheduleTableModel tableModel = new ScheduleTableModel();
    private Map<String, List<String>> roomMap;

    public MainWindow() {
        super("JSON Rozvrh");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);

        initToolbar();

        table = new JTable(tableModel);
        table.setAutoCreateRowSorter(true);

        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    private void initToolbar() {
        JPanel panel = new JPanel();

        buildingCombo = new JComboBox<>();
        roomCombo = new JComboBox<>();
        for(int i=1; i<=32; i++){
            roomCombo.addItem("J" + i);
        }

        buildingCombo.addItem("J");
        loadButton = new JButton("Načíst rozvrh");
        loadButton.addActionListener(e -> loadSchedule());

        panel.add(new JLabel("Budova:"));
        panel.add(buildingCombo);
        panel.add(new JLabel("Místnost:"));
        panel.add(roomCombo);
        panel.add(loadButton);

        add(panel, BorderLayout.NORTH);

        buildingCombo.setSelectedIndex(0);
    }

    private void loadSchedule() {
        String budova = (String) buildingCombo.getSelectedItem();
        String mistnost = (String) roomCombo.getSelectedItem();
        if (budova != null && mistnost != null) {
            Akce data = StagDataLoader.loadSchedule(budova, mistnost);
            setRozvrh(data);
            tableModel.setSchedule(data);
        }
    }
    public void setRozvrh(Akce r) {
        if (r.rozvrhovaAkce != null) {
            ArrayList<RozvrhovaAkce> vybraneAkce = new java.util.ArrayList<>();
            for (RozvrhovaAkce akce : r.rozvrhovaAkce) {
                if ("Cv".equals(akce.typAkceZkr) || "Př".equals(akce.typAkceZkr)) {
                    vybraneAkce.add(akce);
                }
            }
            r.rozvrhovaAkce = vybraneAkce;
        }
    }
}
