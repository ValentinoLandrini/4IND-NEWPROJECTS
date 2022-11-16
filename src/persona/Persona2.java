package persona;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * la classe Persona2 definisce alcune caratteristiche di un essere umano
 *
 * @author valentino.landrini
 * @version 0.2 05/10/2022
 */
public class Persona2 {

    private Double altezza;
    private String cognome;
    private String nome;
    private Float peso;
    private String dataDiNascita;
    private final ZoneId z = ZoneId.of("Europe/Rome");
    private final ZonedDateTime zdt = ZonedDateTime.now(z);
    private int current_day = zdt.getDayOfMonth();
    private int current_month = zdt.getMonthValue();
    private int current_year = zdt.getYear();

    /**
     * costruttore della classe persona senza parametri per impostare i
     * parametri si possono usare i seguenti metodi { @link #setAltezza (double altezza)
     * }
     * <br> { @link #setCognome (String cognome) }
     * <br> { @link #setNome (String nome) }
     * <br> { @link #setPeso (Float peso) }
     * <br> { @link #setDataDiNascita(String dataDiNascita) }
     *
     */
    public Persona2() {
    }

    /**
     *
     *
     *
     *
     * @param altezza
     * @param cognome
     * @param dataDiNascita
     * @param nome
     * @param peso
     */
    public Persona2(Double altezza, String cognome, String dataDiNascita, String nome, Float peso) {
        this.altezza = altezza;
        this.cognome = cognome;
        this.nome = nome;
        this.peso = peso;
        setDataDiNascita(dataDiNascita);
    }

    /**
     * restituisce l'altezza della persona
     *
     *
     * @return altezza
     */
    public Double getAltezza() {
        return altezza;
    }

    /**
     *
     * imposta l'altezza della persona
     *
     * @param altezza
     */
    public void setAltezza(Double altezza) {
        this.altezza = altezza;
    }

    /**
     *
     * Restituisce il cognome della persona
     *
     * @return cognome
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * Imposta il cognome della persona
     *
     *
     * @param cognome
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * Restituisce la data di nascita della persona
     *
     * @return datadinascita
     */
    public String getDataDiNascita() {
        return dataDiNascita;
    }

    /**
     * imposta la data di nascita di una persona
     *
     *
     * @param dataDiNascita
     */
    public void setDataDiNascita(String dataDiNascita) {

        String[] splitted = dataDiNascita.split("/");
        try {
            Boolean giusto = true;
            int gg = Integer.parseInt(splitted[0]);
            int mm = Integer.parseInt(splitted[1]);
            int aaaa = Integer.parseInt(splitted[2]);

            if (aaaa > current_year) {
                giusto = false;

            }
            switch (mm) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    if (gg < 1 || gg > 31) {
                        giusto = false;
                    }
                    break;

                case 4:
                case 6:
                case 9:
                case 11:
                    if (gg < 1 || gg > 30) {
                        giusto = false;
                    }
                    break;
                case 2:
                    if (!(aaaa % 400 == 0 || (aaaa % 4 == 0 && aaaa % 100 != 0))) {
                        if (gg < 1 || gg > 28) {
                            giusto = false;
                        }

                    }

            }
            if (giusto) {
                this.dataDiNascita = dataDiNascita;

            }

        } catch (NumberFormatException nfe) {
            System.out.println("Errore");

        }
    }

    /**
     * Restituisce il nome della persona
     *
     *
     * @return nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Imposta il nome della persona
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Restituisce il peso della persona
     *
     *
     * @return peso
     */
    public Float getPeso() {
        return peso;
    }

    /**
     * imposta il peso della persona
     *
     * @param peso
     */
    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public String calcoloEta() {
        boolean giusto = true;
        System.out.println(z);
        int eta = 0;
        int mese = 0;
        int giorni = 0;
        String anni = null;
        if (dataDiNascita == null) {
            giusto = false;
        }
        if (giusto) {
            String[] splitted = dataDiNascita.split("/");
            int gg = Integer.parseInt(splitted[0]);
            int mm = Integer.parseInt(splitted[1]);
            int aaaa = Integer.parseInt(splitted[2]);

            eta = current_year - aaaa;
            if (current_month < mm && current_day < gg) {
                eta -= 1;
            } else if (current_month < mm) {
                eta -= 1;
            }
            mese = current_month - mm;
            giorni = current_day - gg;
            System.out.println(mese);
            if (mm == 1 || mm == 3 || mm == 5 || mm == 7 || mm == 8 || mm == 10 || mm == 12) {
                if (giorni < 0) {
                    mese = mese - 1;
                }
                giorni = giorni + 31;

            }
            if (mm == 4 || mm == 6 || mm == 9 || mm == 11) {
                if (giorni < 0) {
                    mese = mese - 1;
                }
                giorni = giorni + 30;
            }
            if (mm == 8) {
                if (giorni < 0) {
                    mese = mese - 1;
                }
                giorni = giorni + 29;
            }

            anni = (eta + " anni " + mese + " mesi/e " + giorni + " e giorni/o");
        }
        return anni;

    }

    /**
     * restituisce le caratteristiche della persona
     *
     * @return riepilogo caratteristiche
     */
    public String info() {
        String info = "";

        info = "cognome          : " + this.cognome + "\n"
                + "nome             : " + this.nome + "\n"
                + "altezza          : " + this.altezza + "\n"
                + "peso             : " + this.peso + "\n"
                + "data di nascita  : " + this.dataDiNascita + "\n";

        return info;
    }

}
