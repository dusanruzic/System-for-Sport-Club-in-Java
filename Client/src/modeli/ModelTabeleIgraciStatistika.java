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
import logika.Controler;

/**
 *
 * @author duler
 */
public class ModelTabeleIgraciStatistika extends AbstractTableModel{
    ArrayList<StatistikaIgracaSaUtakmice> listaStatistika;
    String[] imenaKolona = {"Prezime", "Ime", "Prosecna ocena", "Plata"};

    public ModelTabeleIgraciStatistika() {
        listaStatistika = new ArrayList<>();
    }

    public ModelTabeleIgraciStatistika(ArrayList<StatistikaIgracaSaUtakmice> listaStatistika) {
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
        switch (columnIndex) {
            case 0:
                return stat.getIgrac().getPrezime();
            case 1:
                return stat.getIgrac().getIme();
            
            case 2:
                return stat.getOcena();
            case 3:
                return stat.getIgrac().getPlata();
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

    
}
