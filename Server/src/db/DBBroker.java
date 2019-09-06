/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import com.mysql.jdbc.Connection;
import domen.Igrac;
import domen.Menadzer;
import domen.Pozicija;
import domen.Profil;
import domen.Sport;
import domen.StatistikaIgracaSaUtakmice;
import domen.Tim;
import domen.Trener;
import helper.DBHelper;
import helper.Konstante;
import java.io.IOException;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import domen.IGeneralEntity;

/**
 *
 * @author duler
 */
public class DBBroker {

    java.sql.Connection konekcija;
    DBHelper dbHelper;
    static DBBroker instance;

    private DBBroker() {
        try {
            dbHelper = new DBHelper();
            String url = dbHelper.vratiVrednost(Konstante.URL);
            String user = dbHelper.vratiVrednost(Konstante.USER);
            String pass = dbHelper.vratiVrednost(Konstante.PASS);

            konekcija = DriverManager.getConnection(url, user, pass);
            konekcija.setAutoCommit(false);

            System.out.println("Uspostavljena veza sa bazom...");
        } catch (IOException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static DBBroker getInstance() {
        if (instance == null) {
            instance = new DBBroker();
        }
        return instance;
    }

    public void otvoriKonekciju() {
//        try {
//            String url = dbHelper.vratiVrednost(Konstante.URL);
//            String user = dbHelper.vratiVrednost(Konstante.USER);
//            String pass = dbHelper.vratiVrednost(Konstante.PASS);
//
//            konekcija = DriverManager.getConnection(url, user, pass);
//            konekcija.setAutoCommit(false);
//        } catch (SQLException ex) {
//            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    public void startTransaction() throws SQLException {
        //JAKO BITNA LINIJA, MOZE I DA SE PREMESTI NEGDE DRUGDE!!!
        otvoriKonekciju();
        konekcija.setAutoCommit(false);
    }

    public void zatvoriKonekciju() {
//        try {
//            konekcija.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    public void commitTransaction() {
        try {
            konekcija.commit();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void rollbackTransaction() {
        try {
            konekcija.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<IGeneralEntity> vratiPodUslovom(IGeneralEntity odo) {
        ArrayList<IGeneralEntity> lista = new ArrayList<>();
        try {

            System.out.println("pre upita");
            String upit = "select " + odo.poveziTabele() + " where " + odo.vratiUslovPretrage();

            System.out.println("posle upita");
            System.out.println(upit);
            Statement st = konekcija.createStatement();

            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                IGeneralEntity od = null;
                try {
                    od = odo.vratiObjekat(rs);
                } catch (Exception ex) {
                    Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
                }
                lista.add(od);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

//    public IGeneralEntity sacuvaj(IGeneralEntity entity) throws SQLException {
//        try {
//
//            System.out.println("Pre upita!!!! greska u samom upitu");
//            String upit = "INSERT INTO " + entity.vratiImeTabele() + " (" + entity.vratiImenaKolona() + ")" + " VALUES (" + entity.vratiVrednostiKolona() + ")";
//            System.out.println(upit);
//            Statement st = konekcija.createStatement();
//            st.executeUpdate(upit);
//            st.close();
//            konekcija.commit();
//            return entity;
//        } catch (SQLException ex) {
//            if (konekcija != null) {
//                konekcija.rollback();
//            }
//            throw ex;
//
//        }
//    }
    public IGeneralEntity kreiraj(IGeneralEntity entity) throws SQLException {
        try {

            System.out.println("Pre upita!!!! greska u samom upitu");
            String upit = "INSERT INTO " + entity.vratiImeTabele() + " (" + entity.vratiImenaKolonaZaCreate() + ")" + " VALUES (" + entity.vratiVrednostiKolonaZaCreate() + ")";
            System.out.println(upit);
            Statement st = konekcija.createStatement();
            st.executeUpdate(upit);
            st.close();
            //konekcija.commit();
            return entity;
        } catch (SQLException ex) {
            if (konekcija != null) {
                konekcija.rollback();
            }
            throw ex;

        }
    }

    public ArrayList<IGeneralEntity> vratiSve(IGeneralEntity odo) {
        ArrayList<IGeneralEntity> lista = new ArrayList<>();
        try {

            String upit = "select " + odo.poveziTabele();
            Statement st = konekcija.createStatement();

            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                IGeneralEntity od = null;
                try {
                    od = odo.vratiObjekat(rs);
                } catch (Exception ex) {
                    Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
                }
                lista.add(od);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public void izbrisi(IGeneralEntity entity) throws SQLException {
        try {
            String upit = "delete from " + entity.vratiImeTabele() + " where " + entity.vratiUslovZaBrisanje();
            System.out.println(upit);
            Statement st = konekcija.createStatement();

            int rs = st.executeUpdate(upit);
            if (rs > 0) {
                konekcija.commit();
            } else {
                konekcija.rollback();
            }

            st.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }
    }

//    public IGeneralEntity vratiJednog(IGeneralEntity entity) throws Exception {
//
//        System.out.println("pre upita");
//        String upit = "SELECT * FROM " + entity.vratiImeTabele() + " WHERE " + entity.vratiUslovZaBrisanje();
//
//        System.out.println("posle upita");
//        System.out.println(upit);
//        Statement statement = konekcija.createStatement();
//        ResultSet rs = statement.executeQuery(upit);
//
//        System.out.println("cak smo stigli i do ovde");
//        IGeneralEntity ent = entity.vratiObjekatPriOdustani(rs);
//
//        System.out.println("Ali do ovde nismo");
//        return ent;
//    }
    public void update(IGeneralEntity entity) throws Exception {
        try {
            System.out.println("Pre upita");
            System.out.println(entity.vratiImeTabele());
            System.out.println(entity.vratiVrednostiKolona());
            System.out.println(entity.vratiUslovZaUpdate());
            String upit = "UPDATE " + entity.vratiImeTabele() + " SET " + entity.vratiVrednostiKolonaZaUpdate() + " WHERE " + entity.vratiUslovZaUpdate();
            System.out.println(upit);
            Statement statement = konekcija.createStatement();
            statement.executeUpdate(upit);
            statement.close();
            konekcija.commit();

        } catch (SQLException ex) {
            if (konekcija != null) {
                konekcija.rollback();
            }
            throw ex;
        }
    }

    public Object poslednji(IGeneralEntity entity) throws Exception {
        Object o = null;

        String upit = "SELECT MAX(" + entity.vratiAtributZaPoslednji() + ") FROM " + entity.vratiImeTabele();
        System.out.println(upit);
        Statement statement = konekcija.createStatement();
        ResultSet rs = statement.executeQuery(upit);

        o = entity.vratiPoslednji(rs);

        return o;

    }

}
