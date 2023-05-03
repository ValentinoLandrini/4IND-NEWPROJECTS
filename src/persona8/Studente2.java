package persona8;

import java.util.*;
import java.util.ArrayList;
/**
 *
 * @author valentino.landrini
 */
public class Studente2 extends Persona8 {

    public static String SCUOLA = "I.T.T Buonarroti";
    private Integer classe;
    private Boolean isRipetente;
     ArrayList <Float> voti;

    public Studente2() {
        super();
    }

    public Studente2(Integer Classe, Boolean isRipetente, ArrayList<Float> voti, Double altezza, String cognome, String nome, Float peso, String dataDiNascita, String password, String email) throws Exception {
        super(altezza, cognome, nome, peso, dataDiNascita, password, email);
        this.classe = Classe;
        this.isRipetente = isRipetente;
        this.voti = voti;
    }

    public static String getSCUOLA() {
        return SCUOLA;
    }

    public Integer getClasse() {
        return this.classe;
    }

    public void setClasse(Integer classe) throws Exception {
        if (classe != null && classe < 0 && classe > 6) {
            throw new Exception("la classe non puo essere vuota, minore di 0 o maggiore di 5");

        }
        this.classe = classe;
    }

    public Boolean getIsRipetente() {
        return isRipetente;
    }

    public void setIsRipetente(Boolean isRipetente) throws Exception {
        if (isRipetente != null) {
            this.isRipetente = isRipetente;

        } else {
            throw new Exception("l'attributo isRipetente non puo essere nullo.");

        }

    }

    public Float[] getVoti() {
        voti.get(0);
            
    }

    public void setVoti(Float voti[]) throws Exception {
        if (voti != null) {
            for (Float v : voti) {
                if (v != null && v > 3 && v < 10) {
                } else {
                    throw new Exception("il voto non puo essere nullo, maggiore di 10 o minore di 3");
                }
            }
            this.voti = voti;
        } else {
            throw new Exception("l'attributo voti non puo essere nullo.");
        }

    }

    public void aggiungVoto(Float voto) throws Exception {
        if (voto != null) {
            if (voto < 3 && voto > 10) {
                Float[] voto1 = new Float[voti.size() + 1];
                for (int i = 0; i < voti.size(); i++) {
                    voti.set(i, voti.get(i));

                }
                voto1[voto1.length - 1] = voto;
            } else {
                throw new Exception("il voto deve essere compreso tra 3 e 10");
            }
        } else {
            throw new Exception("voto non puo essere nullo");
        }
    }

    public void rimuoviUltimoVoto() {
        if (voti != null) {
           
            
        }
    }

    public void rimuoviVoto(Integer posizione) throws Exception {
        if (voti != null) {

            if (posizione != null && posizione > -1 && posizione < voti.size()) {

                Float[] voto1 = new Float[voti.size() - 1];
                for (int i = 0; i < voti.size(); i++) {
                    if (posizione == i) {
                        i++;
                    } else {
                        voti.set(i, voti.get(i));
                    }
                }
            } else {
                throw new Exception("la posizione non puo essere ne null ne maggiore di voti.length ne minore di -1");

            }
        } else {
            throw new Exception("voti non puo essere null");

        }
    }

    public Boolean promuovi() throws Exception {
        if (mediaVoti() > 6f) {

            classe = classe + 1;
            if (classe > 5) {
                throw new Exception("BRAVO HAI SUPERATO LA QUINTA");
            }
            return true;

        } else {
            return false;

        }
    }

    public Boolean promuovi(Integer numeroClassi) throws Exception {
        if (mediaVoti() > 6f) {

            classe = classe + numeroClassi;
            if (classe > 5) {
                throw new Exception("BRAVO HAI SUPERATO LA QUINTA");
            }
            return true;

        } else {
            return false;

        }

    }

    private Float votoMinore() {
        Float min = 10f;
        if (voti != null) {

            for (Float v : voti) {
                if (v < min) {
                    min = v;

                }

            }

        }
        return min;
    }

    private Float votoMaggiore() {
        Float max = 0f;
        if (voti != null) {

            for (Float v : voti) {
                if (v > max) {
                    max = v;

                }

            }

        }
        return max;
    }

    private Float mediaVoti() {
        Float media = 0f;
        for (int i = 0; i < voti.size(); i++) {
            media = media + voti.get(i);
        }
        return media / voti.size();
    }

    public String info() throws Exception {
        String stringa = super.info();
        stringa += "la classe e'        : " + classe + "\n";
        stringa += "e' ripetente        : " + isRipetente + "\n";
        stringa += "il voto minore e'   : " + votoMinore() + "\n";
        stringa += "il voto maggiore e' : " + votoMaggiore() + "\n";
        stringa += "la media dei voti e': " + mediaVoti() + "\n";
        return stringa;
    }

}