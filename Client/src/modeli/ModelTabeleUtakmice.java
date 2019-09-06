/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Utakmica;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author duler
 */
public class ModelTabeleUtakmice extends AbstractTableModel{

    ArrayList<Utakmica> listaUtakmica = new ArrayList<>();
    String[] imenaKolona = {"Naziv utakmice", "Datum", "Broj datih golova", "Broj primljenih golova"};

    public ModelTabeleUtakmice() {
    }

    public ModelTabeleUtakmice(ArrayList<Utakmica> listaUtakmica) {
        this.listaUtakmica = listaUtakmica;
    }

    @Override
    public int getRowCount() {
        return listaUtakmica.size();
    }

    @Override
    public int getColumnCount() {
        return imenaKolona.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Utakmica tim = (Utakmica) listaUtakmica.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return tim.toString();
            case 1:
                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                return sdf.format(tim.getDatumUtakmice());
            case 2:
                return tim.getBrojDatihGolova();
            case 3:
                return tim.getBrojPrimljenihGolova();
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

    public ArrayList<Utakmica> getListaUtakmica() {
        return listaUtakmica;
    }

    public void setListaUktamica(ArrayList<Utakmica> listaUtakmica) {
        this.listaUtakmica = listaUtakmica;
    }

    public Utakmica getUtakmica(int rowIndex) {
        return (Utakmica) listaUtakmica.get(rowIndex);
    }
    
    
}
