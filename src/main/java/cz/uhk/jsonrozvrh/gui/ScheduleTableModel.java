package cz.uhk.jsonrozvrh.gui;

import cz.uhk.jsonrozvrh.model.Akce;
import cz.uhk.jsonrozvrh.model.RozvrhovaAkce;

import javax.swing.table.AbstractTableModel;

public class ScheduleTableModel extends AbstractTableModel {
    private final String[] columns = {"Zkratka", "Název", "Den", "Start", "Konec", "Učitel"};
    private Akce schedule = new Akce();

    public void setSchedule(Akce schedule) {
        this.schedule = schedule;
        fireTableDataChanged();
    }

    @Override public int getRowCount() {
        if(schedule.rozvrhovaAkce == null){
            return 0;}
            return schedule.rozvrhovaAkce.size();}
    @Override public int getColumnCount() { return columns.length; }
    @Override public String getColumnName(int column) { return columns[column]; }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        RozvrhovaAkce item = schedule.rozvrhovaAkce.get(rowIndex);
        String jmeno = "";
        if(item.ucitel == null){
            jmeno = "neni";
        }
        else {jmeno = item.ucitel.jmeno + " " + item.ucitel.prijmeni;}
        return switch (columnIndex) {
            case 0 -> item.predmet;
            case 1 -> item.nazev;
            case 2 -> item.den;
            case 3 -> item.hodinaSkutOd.value;
            case 4 -> item.hodinaSkutDo.value;
            case 5 -> jmeno;
            default -> "";
        };
    }
}
