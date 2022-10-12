package persona;

/**
 * la classe Persona2 definisce alcune caratteristiche di un essere umano
 *
 * @author valentino.landrini
 * @version 0.2 05/10/2022
 */
public class Persona2 {

    public Double altezza;
    public String cognome;
    public String nome;
    public Float peso;
    private String dataDiNascita;

    /**
     * costruttore della classe persona senza parametri per impostare i
     *         parametri si possono usare i seguenti metodi 
     *                   { @link #setAltezza (double altezza) }
     *              <br> { @link #setCognome (String cognome) }            
     *              <br> { @link #setNome (String nome) }
     *              <br> { @link #setPeso (Float peso) }                   
     *              <br> { @link #setDataDiNascita(String dataDiNascita) }
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

            if (aaaa < 1900 || aaaa > 2022) {
                giusto = false;
                System.out.println("Errore");
            }
            
            
            
            
            
            
            
            
          /*  if (gg < 1 || gg > 31) {
                giusto = false;
                System.out.println("Errore");
            }
            if (mm < 1 || mm > 12) {
                giusto = false;
                System.out.println("Errore");
            }
            if (mm == 1 || mm == 3 || mm == 5 || mm == 7 || mm == 8 || mm == 10 || mm == 12) {
                if (gg < 1 || gg > 31) {
                    giusto = false;
                    System.out.println("Errore");
                }
            }
                if (mm == 4 || mm == 6 || mm == 9 || mm == 11) {
                    if (gg < 1 || gg > 30) {
                        giusto = false;
                        System.out.println("Errore");
                    }
                    if (mm == 2) {
                        if (gg < 1 || gg > 29) {
                            giusto = false;
                            System.out.println("Errore");
                        }
                    }

                }*/
            
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
