/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Tim;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import logika.Controler;
import domen.IGeneralEntity;

/**
 *
 * @author duler
 */
public class ModelTabeleTimovi extends AbstractTableModel{
    ArrayList<Tim> listaTimova = new ArrayList<>();
    String[] imenaKolona = {"Naziv tima", "Dobijene", "Izgubljene", "Neresene", "Trener"};

    public ModelTabeleTimovi() {
    }

    public ModelTabeleTimovi(ArrayList<Tim> listaTimova) {
        this.listaTimova = listaTimova;
    }

    @Override
    public int getRowCount() {
        return listaTimova.size();
    }

    @Override
    public int getColumnCount() {
        return imenaKolona.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Tim tim = (Tim) listaTimova.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return tim.getNazivTima();
            case 1:
                return tim.getBrojDobijenihUtakmica();
            case 2:
                return tim.getBrojIzgubljenihUtakmica();
            case 3:
                return tim.getBrojNeresenihUtakmica();
            case 4:
                return tim.getTrener();
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

    public ArrayList<Tim> getListaTimova() {
        return listaTimova;
    }

    public void setListaTimova(ArrayList<Tim> listaTimova) {
        this.listaTimova = listaTimova;
    }

    public Tim getTim(int rowIndex) {
        return (Tim) listaTimova.get(rowIndex);
    }
    
    public void dodajTim(Tim t){
        listaTimova.add(t);
        fireTableDataChanged();
    }
}
