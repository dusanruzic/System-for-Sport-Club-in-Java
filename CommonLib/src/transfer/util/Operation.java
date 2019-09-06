/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer.util;

/**
 *
 * @author Milena
 */
public interface Operation {

    public static int OPERATION_PRIJAVI_SE = 1;
    //public static int OPERATION_VRATI_LISTU_MENADZERA=2;
    public static int OPERATION_VRATI_LISTU_TIMOVA = 3;
    public static int OPERATION_VRATI_LISTU_SPORTOVA = 4;
    public static int OPERATION_VRATI_LISTU_TRENERA_DATOG_SPORTA = 5;
    public static int OPERATION_VRATI_LISTU_POZICIJA_DATOG_SPORTA = 6;
    public static int OPERATION_PRONADJI_IGRACE = 7;
    public static int OPERATION_ZAPAMTI_TIM = 8;
    public static int OPERATION_ZAPAMTI_PROFIL = 9;
    public static int OPERATION_ZAPAMTI_TRENERA = 10;
    public static int OPERATION_ZAPAMTI_IGRACA = 11;
    public static int OPERATION_ZAPAMTI_STATISTIKE = 12;
    public static int OPERATION_VRATI_TIMOVE_DATOG_TRENERA = 13;
    public static int OPERATION_VRATI_UTAKMICE_DATOG_TIMA = 14;
    public static int OPERATION_AZURIRAJ_TIM = 15;
    public static int OPERATION_AZURIRAJ_TRENERA = 16;
    public static int OPERATION_AZURIRAJ_IGRACA = 17;
    public static int OPERATION_ZAPAMTI_IGRACA_U_TIM = 18;
    public static int OPERATION_PRONADJI_STATISTIKE = 19;
    
    public static int OPERATION_POSLEDNI_TIM = 20;
    public static int OPERATION_KREIRAJ_TIM = 21;
    public static int OPERATION_PRONADJI_TIM = 22;
    public static int OPERATION_OBRISI_TIM = 23;
    
    public static int OPERATION_VRATI_LISTU_TRENERA = 24;
    
    public static int OPERATION_POSLEDNJI_TRENER = 25;
    public static int OPERATION_KREIRAJ_TRENERA = 26;
    public static int OPERATION_OBRISI_TRENERA = 27;
    
    public static int OPERATION_POSLEDNJI_IGRAC = 28;
    public static int OPERATION_KREIRAJ_IGRACA = 29;
    public static int OPERATION_OBRISI_IGRACA = 30;
    
    public static int OPERATION_VRATI_UTAKMICE_DATOG_TRENERA = 31;
    public static int OPERATION_VRATI_ODABRANE_UTAKMICE_DATOG_TRENERA = 32;
    
    public static int OPERATION_LOGOUT = 33;
    
    public static int OPERATION_SERVER_UGASEN = 34;
     

}
