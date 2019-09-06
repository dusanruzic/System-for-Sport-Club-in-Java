/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author duler
 */
public interface IGeneralEntity extends Serializable{
    
    public String vratiImeTabele();
    public String vratiImenaKolona();
    public String vratiVrednostiKolona();
    public String vratiVrednostiKolonaZaCreate();
    public String vratiImenaKolonaZaCreate();
    public String vratiVrednostiKolonaZaUpdate();
    public String vratiUslovZaUpdate();
    public String vratiUslovZaBrisanje();
    public String vratiUslovPretrage();
    public String vratiAtributZaPoslednji();
    public String poveziTabele();
    public IGeneralEntity vratiObjekat(ResultSet rs) throws Exception;
    public IGeneralEntity vratiObjekatPriOdustani(ResultSet rs) throws Exception;
    public ArrayList<IGeneralEntity> vratiListu(ResultSet resultSet)throws Exception;

    public Object vratiPoslednji(ResultSet rs) throws Exception;

    

    
}
