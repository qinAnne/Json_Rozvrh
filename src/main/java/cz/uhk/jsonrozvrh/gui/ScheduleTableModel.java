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
        if(schedule.getRozvrhovaAkce() == null){
            return 0;}
            return schedule.getRozvrhovaAkce().size();}
    @Override public int getColumnCount() { return columns.length; }
    @Override public String getColumnName(int column) { return columns[column]; }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        RozvrhovaAkce item = schedule.getRozvrhovaAkce().get(rowIndex);
        String ucitel = item.getVsichniUciteleJmenaTituly() + " " + item.getVsichniUcitelePrijmeni();
        if(ucitel.equals(" ")){
            ucitel = "neni";
        }
        return switch (columnIndex) {
            case 0 -> item.getPredmet();
            case 1 -> item.getNazev();
            case 2 -> item.getDen();
            case 3 -> item.getHodinaSkutOd().getValue();
            case 4 -> item.getHodinaSkutDo().getValue();
            case 5 -> ucitel;
            default -> "";
        };
    }
}
