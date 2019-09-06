/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Igrac;
import domen.StatistikaIgracaSaUtakmice;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import domen.IGeneralEntity;

/**
 *
 * @author duler
 */
public class ModelTabeleStatistika extends AbstractTableModel {

    ArrayList<StatistikaIgracaSaUtakmice> listaStatistika;
    String[] imenaKolona = {"Protivnik","Ishod meca", "Sutevi", "Golovi", "Zuti kartoni", "Ocena"};

    public ModelTabeleStatistika() {
        listaStatistika = new ArrayList<>();
    }
    
     public ModelTabeleStatistika(ArrayList<StatistikaIgracaSaUtakmice> listaStatistika) {
        this.listaStatistika = listaStatistika;
    }

    @Override
    public int getRowCount() {
        return listaStatistika.size();
    }

    @Override
    public int getColumnCount() {
        return imenaKolona.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StatistikaIgracaSaUtakmice stat = (StatistikaIgracaSaUtakmice) listaStatistika.get(rowIndex);
        
        System.out.println("Stat:" + stat);
                System.out.println("Utakmica: " + stat.getUtakmica());

        System.out.println("Broj primljenih: " + stat.getUtakmica().getBrojDatihGolova());
        switch (columnIndex) {
            case 0:
                return stat.getUtakmica().getNazivProtivnika();
            case 1:
                int brojPrimljenih = stat.getUtakmica().getBrojPrimljenihGolova();
                int brojDatih = stat.getUtakmica().getBrojDatihGolova();
                String rez = "";
                if(brojPrimljenih == brojDatih){
                    rez = "Nereseno  " + brojPrimljenih + ":" + brojDatih;
                }
                if(brojPrimljenih > brojDatih){
                    rez = "Poraz  " + brojDatih + ":" + brojPrimljenih;
                }
                if(brojPrimljenih < brojDatih){
                    rez = "Pobeda  " + brojDatih + ":" + brojPrimljenih;
                }
                return rez;
                
            case 2:
                return stat.getBrojSuteva();
            case 3:
                return stat.getBrojGolova();
            case 4:
                return stat.getBrojZutihKartona();
            case 5:
                return stat.getOcena();
            default:
                return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        return imenaKolona[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public void dodajStatistiku(StatistikaIgracaSaUtakmice stat) {
        listaStatistika.add(stat);
        fireTableDataChanged();
    }

    public void izbrisiStatistiku(int rowIndex) {
        listaStatistika.remove(rowIndex);
        fireTableDataChanged();
    }
    
        public ArrayList<StatistikaIgracaSaUtakmice> vratiStatistikaIgracaSaUtakmices() {
        return listaStatistika;
    }
        
    public void isprazniModelStatistika(){
        listaStatistika = new ArrayList<>();
        fireTableDataChanged();
    }

}
