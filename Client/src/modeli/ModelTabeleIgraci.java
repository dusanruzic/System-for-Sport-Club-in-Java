/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Igrac;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import logika.Controler;
import domen.IGeneralEntity;

/**
 *
 * @author duler
 */
public class ModelTabeleIgraci extends AbstractTableModel {

    ArrayList<Igrac> listaIgraca = new ArrayList<>();
    String[] imenaKolona = {"Prezime", "Ime", "Tim", "Pozicija"};

    public ModelTabeleIgraci() {
    }

    public ModelTabeleIgraci(ArrayList<Igrac> listaIgraca) {
        this.listaIgraca = listaIgraca;
    }

    @Override
    public int getRowCount() {
        return listaIgraca.size();
    }

    @Override
    public int getColumnCount() {
        return imenaKolona.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Igrac igrac = (Igrac) listaIgraca.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return igrac.getPrezime();
            case 1:
                return igrac.getIme();
            case 2:
                return igrac.getTim();
            case 3:
                return igrac.getPozicija();
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

    public void obrisiRed(int red) {
        Controler.getInstanca().izbrisiIgraca((Igrac) listaIgraca.get(red));
        listaIgraca.remove(red);
        fireTableDataChanged();
    }

    public ArrayList<Igrac> getListaIgraca() {
        return listaIgraca;
    }

    public void setListaIgraca(ArrayList<Igrac> listaIgraca) {
        this.listaIgraca = listaIgraca;
    }

    public Igrac getIgrac(int rowIndex) {
        return (Igrac) listaIgraca.get(rowIndex);
    }
    
    public void dodajIgraca(Igrac i) {
        listaIgraca.add(i);
        fireTableDataChanged();
    }

}
