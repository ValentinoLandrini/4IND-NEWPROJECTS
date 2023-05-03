package persona8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author giacomo.grattarola
 */
public class Studente2 extends Persona8 {

    public final String SCUOLA = "I.T.T Buonarroti";
    private Integer classe;
    private Boolean isRipetente;
    private ArrayList<Float> voti;

    public Studente2() {
        super();
    }

    public Studente2(Double altezza, String cognome, String nome, Float peso, String dataDiNascita, String password, String email, Integer classe, Boolean isRipetente) throws Exception {
        super(altezza, cognome, nome, peso, dataDiNascita, password, email);
        this.setClasse(classe);
        this.setIsRipetente(isRipetente);

    }

    public Integer getClasse() {
        return classe;
    }

    public void setClasse(Integer classe) throws Exception {
        if (classe != null) {
            if (classe > 0 && classe < 6) {
                this.classe = classe;
            } else {
                throw new Exception("la classe deve essere compresa tra 1 e 5");
            }
        } else {
            throw new Exception("deve essere diversi da null");
        }
    }

    public Boolean getIsRipetente() {
        return isRipetente;
    }

    public void setIsRipetente(Boolean isRipetente) throws Exception {
        if (isRipetente != null) {
            this.isRipetente = isRipetente;
        } else {
            throw new Exception("deve essere diversi da null");
        }

    }

    public ArrayList<Float> getVoti() {
        return  (ArrayList<Float>) voti.clone();
    }

    public void setVoti(ArrayList<Float> voti) throws Exception {

        if (voti != null) {
            for (int i = 0; i < voti.size(); i++) {
                if (voti.get(i) != null && voti.get(i) >= 3 && voti.get(i) <= 10) {
                    if (voti.get(i) % 0.25 == 0) {

                    } else {
                        throw new Exception("Deve essere divisibile per 0,25");
                    }
                } else {
                    throw new Exception("Il voto deve essere compreso tra 3 e 10");
                }
            }

           this.voti=(ArrayList<Float>) voti.clone() ;

        } else {
            throw new Exception("deve essere diversi da null");
        }

    }

    public void aggiungiVoto(Float voto) {
        voti.add(voto);
        this.voti = this.voti=(ArrayList<Float>) voti.clone();
    }

    public void rimuoviVoto(Integer posizione) {
       voti.remove(posizione);

        this.voti = this.voti=(ArrayList<Float>) voti.clone();
    }
    public void rimuoviUltimoVoto() {
       voti.remove(voti.size()-1);

        this.voti = this.voti=(ArrayList<Float>) voti.clone();
    }
    public void ordinaVotoCrescente() {
        ArrayList<Float> f=(ArrayList<Float>) voti.clone();

        Collections.sort(f);
        this.voti=f;

    }
    public void ordinaVotoDecrescente() {
        ArrayList<Float> f=(ArrayList<Float>) voti.clone();
        Collections.sort(f, Collections.reverseOrder());
        this.voti=f;
    }

    public Boolean promuovi() throws Exception {
        Boolean b = false;
        if (classe != 5) {
            classe++;
            b = true;
            isRipetente=false;
        } else {
            throw new Exception("� gi� in 5");
        }
        return b;
    }

    public Boolean promuovi(Integer numeroClassi) throws Exception {
        Boolean b = false;
        if (numeroClassi != null) {
            if (classe + numeroClassi != 5) {
                classe += numeroClassi;
                b = true;
                isRipetente=false;
            } else {
                throw new Exception("� gi� in 5");
            }

        }

        return b;
    }

    public Float votoMinore() {
        Float b = 11f;
        for (int i = 0; i < voti.size(); i++) {
            if (voti.get(i) < b) {
                b = voti.get(i);
            }

        }
        return b;
    }

    public Float votoMaggiore() {
        Float b = 0f;
        for (int i = 0; i < voti.size(); i++) {
            if (voti.get(i) > b) {
                b = voti.get(i);
            }

        }
        return b;
    }

    public Float mediaVoti() {
        Float f = 0f;

        for (int i = 0; i < voti.size(); i++) {
            f += voti.get(i);

        }
        f = f / voti.size();

        return f;
    }

    @Override

    public String toString(){
        try {
            String s = super.info() + "La calsse � " + classe + "/n"
                    + ((isRipetente == true) ? "� un ripetente" : "non � un ripetente") + "/n";
            for (int i = 0; i < voti.size(); i++) {
                s = s + "voto " + voti.get(i) + "/n";
               
            }
            return s;
        } catch (Exception ex) {
            Logger.getLogger(Studente2.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
}

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @param args the command line arguments
     */
}