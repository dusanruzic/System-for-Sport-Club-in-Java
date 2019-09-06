/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Trener;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author duler
 */
public class ModelTabeleTreneri extends AbstractTableModel{
    ArrayList<Trener> listaTrenera = new ArrayList<>();
    String[] imenaKolona = {"Prezime", "Ime", "Plata"};

    public ModelTabeleTreneri() {
    }

    public ModelTabeleTreneri(ArrayList<Trener> listaTrenera) {
        this.listaTrenera = listaTrenera;
    }

    @Override
    public int getRowCount() {
        return listaTrenera.size();
    }

    @Override
    public int getColumnCount() {
        return imenaKolona.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Trener trener = (Trener) listaTrenera.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return trener.getPrezime();
            case 1:
                return trener.getIme();
            case 2:
                return trener.getPlata();
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

    public ArrayList<Trener> getListaTrenera() {
        return listaTrenera;
    }

    public void setListaTrenera(ArrayList<Trener> listaTrenera) {
        this.listaTrenera = listaTrenera;
    }

    public Trener getTrener(int rowIndex) {
        return (Trener) listaTrenera.get(rowIndex);
    }

    public void dodajTrenera(Trener t) {
        listaTrenera.add(t);
        fireTableDataChanged();
    }
}
