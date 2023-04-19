package Persona;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import org.apache.commons.validator.EmailValidator;

/**
 * La classe persona indica alcune caratteristiche dell'essere umano
 *
 * @author giacomo.grattarola
 */
public class Persona6 {

    private Double altezza;
    private String cognome;
    private String dataDiNascita;
    private String nome;
    private Float peso;
    private String password;
    private String email;
    private static Integer numeroIstanze = 0;

    /**
     * Costruttore della classe persona senza i parametri per impostare i
     * parametri si possono usare i seguenti metodi:
     * {@link #setAltezza(Double altezza)} <br>
     * {@link #setCognome(String cognome)} <br> {@link #setNome(String nome)}
     * <br> {@link #setPeso(Float peso)} <br>
     * {@link #setDataDiNascita(String dataDiNascita)}
     */
    public Persona6() {
        numeroIstanze = numeroIstanze + 1;
    }

    /**
     *
     * @param altezza
     * @param cognome
     * @param dataDiNascita
     * @param nome
     * @param peso
     */
    public Persona6(Double altezza, String cognome, String dataDiNascita, String nome, Float peso, String password, String email) throws Exception {
        setDataDiNascita(dataDiNascita);
        setPeso(peso);
        setNome(nome);
        setCognome(cognome);
        setAltezza(altezza);
        setPassword(password);
        setEmail(email);
        numeroIstanze = numeroIstanze + 1;
    }

    public Persona6(Persona6 persona) throws Exception {
        this(persona.getAltezza(), persona.getCognome(), persona.getDataDiNascita(), persona.getNome(), persona.getPeso(), persona.getPassword(), persona.getEmail());
    }

    /**
     * restituisce l'altezza
     *
     * @return altezza
     */
    public Double getAltezza() {
        return altezza;
    }

    public static Integer getNumeroIstanze() {
        return numeroIstanze;
    }

    /**
     * imposta l'altezza della persona
     *
     * @param altezza
     */
    public void setAltezza(Double altezza) throws Exception {
        boolean v = true;
        if (calcolaEta() != null) {
            if (calcolaEta() < 10) {
                if (altezza < 0.5 || altezza > 1) {
                    v = false;
                    throw new Exception("deve essere compresp tra 0.5 e 1 metro se ha dieci anni");
                }
            }
            if (calcolaEta() >= 10) {
                if (altezza < 1.0 || altezza > 2.0) {
                    v = false;
                    throw new Exception("deve essere compreso tra 1 metro e 2 metri se ha più di dieci anni");
                }
            }

        }

        if (v == true) {
            this.altezza = altezza;
        } else {
            throw new Exception("l'attributo altezza non può essere null");

        }

    }

    /**
     * restituisce il cognome
     *
     * @return cognome
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * imposta il cognome della persona
     *
     * @param cognome
     */
    public void setCognome(String cognome) throws Exception {
        boolean v = true;
        if (cognome != null) {
            for (int i = 0; i < cognome.length(); i++) {
                if (i == 0) {
                    if (cognome.charAt(i) < 65 || cognome.charAt(i) > 90) {
                        v = false;
                        throw new Exception("La prima lettera deve essere maiuscola");
                    }
                }
                if (i != 0) {
                    if (cognome.charAt(i) < 97 || cognome.charAt(i) > 122) {
                        v = false;
                        throw new Exception("il nome deve essere composto da sole lettere");
                    }
                }
            }
        }
        if (v == true) {
            this.cognome = cognome;
        } else {
            throw new Exception("il cognome non deve essere NULL");
        }
    }

    /**
     * Restituisce la data di nascita della Persona
     *
     * @return dataDiNascita
     */
    public String getDataDiNascita() {
        return dataDiNascita;
    }

    /**
     * Imposta la data di nascita della Persona
     *
     * @param dataDiNascita Data di nascita
     */
    public Integer[] calcolaId() {
        ZoneId z = ZoneId.of("Europe/Rome");
        ZonedDateTime zdt = ZonedDateTime.now(z);
        Integer data[] = new Integer[3];
        data[0] = zdt.getDayOfMonth();
        data[1] = zdt.getMonthValue();
        data[2] = zdt.getYear();
        return data;
    }

    public void setDataDiNascita(String dataDiNascita) {
        Integer attuale[] = calcolaId();
        Boolean verifica = true;
        String[] splitted = dataDiNascita.split("/");
        int intero[] = new int[splitted.length];
        for (int i = 0; i < splitted.length; i++) {
            intero[i] = Integer.parseInt(splitted[i]);
        }
        for (int i = 0; i < splitted.length; i++) {
            if (i == 0) {
                if (32 < intero[i]) {
                    verifica = false;
                }
                if (intero[1] == 2 && intero[i] > 29) {
                    verifica = false;
                }
                if (intero[1] == 4 && intero[i] == 31 || intero[1] == 6 && intero[i] == 31 || intero[1] == 9 && intero[i] == 31 || intero[1] == 11 && intero[i] == 31) {
                    verifica = false;
                }
            }
            if (i == 1) {
                if (intero[i] > 12) {
                    verifica = false;
                }
            }
            if (i == 2) {
                if (intero[i] < 1000) {
                    verifica = false;
                }
            }

        }
        if (intero[0] > attuale[0] && intero[1] == attuale[1] && intero[2] == attuale[2]) {
            verifica = false;
        }
        if (intero[1] > attuale[1] && intero[2] == attuale[2]) {
            verifica = false;
        }
        if (intero[2] > attuale[2]) {
            verifica = false;
        }
        if (verifica == true) {
            this.dataDiNascita = dataDiNascita;
        }

    }

    public Integer calcolaEta() {
        Integer eta = null;
        Integer attuale[] = calcolaId();
        Boolean falso = true;
        if (dataDiNascita != null) {
            String[] splitted = dataDiNascita.split("/");
            int intero[] = new int[splitted.length];
            for (int i = 0; i < splitted.length; i++) {
                intero[i] = Integer.parseInt(splitted[i]);
            }
            if (intero[1] < attuale[1]) {
                falso = false;
            }
            if (intero[0] < attuale[0] && intero[1] <= attuale[1]) {
                falso = false;
            }
            if (falso == true) {
                eta = attuale[2] - intero[2] - 1;
            } else {
                eta = attuale[2] - intero[2];
            }
        }
        return eta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exception {
        boolean v = true;
        if (nome != null) {
            for (int i = 0; i < nome.length(); i++) {
                if (i == 0) {
                    if (nome.charAt(i) < 65 || nome.charAt(i) > 90) {
                        v = false;
                        throw new Exception("deve essere composto da sole lettere");
                    }
                }
                if (nome.charAt(i) == 32) {
                    if (nome.charAt(i + 1) < 65 || nome.charAt(i) > 90) {
                        v = false;
                        throw new Exception("dopo lo spazio ci va un carattere");
                    }
                }
            }
        }
        if (v == true) {
            this.nome = nome;
        } else {
            throw new Exception("il nome non deve essere NULL");
        }

    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        if (peso > 2 && peso < 100) {
            this.peso = peso;

        }

    }

    public boolean verificaOmonimia(Persona6 persona) {
        boolean v = true;
        if (!this.nome.equals(persona.getNome())) {
            v = false;
        }
        if (!this.cognome.equals(persona.getCognome())) {
            v = false;
        }
        return v;
    }

    public String info() {
        Integer eta = calcolaEta();

        String testo = "ciao";
        testo = (this.cognome != null ? "cognome       : " + this.cognome : "cognome       : ") + "\n"
                + (this.nome != null ? "nome          : " + this.nome : "nome          : ") + "\n"
                + (this.altezza != null ? "altezza       : " + this.altezza : "altezza       : ") + "\n"
                + (this.peso != null ? "peso          : " + this.peso : "peso          : ") + "\n"
                + (this.dataDiNascita != null ? "data nascita  : " + this.dataDiNascita : "data nascita  : ") + "\n"
                + (eta != null ? "eta           : " + eta : "eta           : ") + "\n";
        return testo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws Exception {
        int c = 0;
        int b = 0; //conta errori
        int d = 0;
        int e = 0;
        int f = 0;
        if (password != null) {
            for (int x = 0; x < password.length(); x++) {
                c++;
            }
            if (c < 8) {
                b++;
                throw new Exception("Inserire almeno 8 caratteri");
            }
            for (int i = 0; i < password.length(); i++) {
                if (password.charAt(i) > 47 && password.charAt(i) < 58) {
                    d++;
                }
            }
            if (d <= 0) {
                b++;
                throw new Exception("Inserire almeno un numero compreso tra 0 e 9");
            }
            for (int i = 0; i < password.length(); i++) {
                if (password.charAt(i) > 96 && password.charAt(i) < 123) {
                    e++;
                }
            }
            if (e <= 0) {
                b++;
                throw new Exception("Inserire almeno 1 carattere minuscolo");
            }
            for (int i = 0; i < password.length(); i++) {
                if (password.charAt(i) > 64 && password.charAt(i) < 91) {
                    f++;
                }
            }
            if (f <= 0) {
                b++;
                throw new Exception("Inserire almeno 1 carattere maiuscolo");
            }
            if (b == 0) {
                this.password = password;
            }

        }else{
            throw new Exception("DIVERSO DA NULL");
        }
    }

    public String getEmail() {
        return email;
    }

     public final void setEmail(String email) throws Exception {
        try {            
            if(EmailValidator.getInstance().isValid(email))
                this.email = email;
            else
                throw new Exception("Email non valida!");            
        } catch (NullPointerException e) {
            throw new Exception("L'attributo email non può essere nullo!");
        }
    }
}