package persona8;

import data.Data;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Persona8 {

    Double altezza;
    String cognome;
    String nome;
    Float peso;
    String dataDiNascita;
    String password;
    private String email;

    public static int numeroIstanze;

    public Persona8() {
        numeroIstanze++;
    }

    /**
     * @param altezza
     * @param cognome
     * @param nome
     * @param peso
     * @param dataDiNascita
     * @param password
     * @param email
     * 
     * @throws Exception
     */
    public Persona8(Double altezza, String cognome, String nome, Float peso, String dataDiNascita, String password, String email) throws Exception {
        this();
        this.setAltezza(altezza);
        this.setCognome(cognome);
        this.setNome(nome);
        this.setPeso(peso);
        this.setDataDiNascita(dataDiNascita);
        this.setPassword(password);
        this.setEmail(email);
    }

    public Persona8(Persona8 persona) {
        this.altezza = persona.altezza;
        this.cognome = persona.cognome;
        this.nome = persona.nome;
        this.peso = persona.peso;
        this.dataDiNascita = persona.dataDiNascita;
        this.password = persona.password;
    }

    public Double getAltezza() {
        return this.altezza;
    }

    /**
     * @throws Exception
     */
    final public void setAltezza(Double altezza) throws Exception {
        if (altezza != null) {
            if (altezza > 0) {
                this.altezza = altezza;
            } else {
                throw new Exception("L'attributo altezza deve essere un numero reale positivo!");
            }
        } else {
            throw new NullPointerException("L'attributo altezza non può essere nullo!");
        }
    }

    public String getCognome() {
        return this.cognome;
    }

    /**
     * @throws Exception
     */
    final public void setCognome(String cognome) throws Exception {
        boolean maiuscolo = false;
        try {
            if (cognome.equals("")) {
                throw new Exception("L'attributo cognome non può essere vuoto!");
            }

            if (cognome.matches("[A-Z](.*)")) {
                this.cognome = cognome;
            } else {
                throw new Exception("LA MAIUSCOLA");
            }
        } catch (NullPointerException e) {
            throw new Exception("L'attributo cognome non può essere nullo!");
        }
    }

    public String getNome() {
        return this.nome;
    }

    /**
     * @throws Exception
     */
    final public void setNome(String nome) throws Exception {
        boolean maiuscolo = false;
        try {
            if (!nome.equals("")) {
                this.nome = nome;
            } else {
                throw new Exception("L'attributo nome non può essere vuoto!");
            }
            if (nome.matches("[A-Z](.*)")) {
                maiuscolo = true;
            }
            if (maiuscolo == true) {
                this.nome = nome;

            } else {

                throw new Exception("LA MAIUSCOLA");
            }
        } catch (NullPointerException e) {
            throw new Exception("L'attributo nome non può essere nullo!");
        }
    }

    public Float getPeso() {
        return this.peso;
    }

    /**
     * @throws Exception
     */
    final public void setPeso(Float peso) throws Exception {
        try {
            if (peso > 0) {
                this.peso = peso;
            } else {
                throw new Exception("L'attributo peso deve essere un numero reale positivo!");
            }
        } catch (NullPointerException e) {
            throw new Exception("L'attributo peso non può essere nullo!");
        }
    }

    public String getDataDiNascita() {
        return this.dataDiNascita;
    }

    /**
     * @throws Exception
     */
    final public void setDataDiNascita(String dataDiNascita) throws Exception {
        Data localDate = new Data(dataDiNascita);

        LocalDate dataOdierna = LocalDate.now();

        if (localDate.getData().compareTo(dataOdierna.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))) < 0) {
            throw new Exception("La data di nascita non può essere maggiore di quella attuale!");
        }

        this.dataDiNascita = dataDiNascita;

    }

    public static int getNumeroIstanze() {
        return numeroIstanze;
    }

    public Integer calcolaEta() {
        Integer annoAttuale, meseAttuale, giornoAttuale;

        GregorianCalendar dataOdierna = new GregorianCalendar();

        annoAttuale = dataOdierna.get(Calendar.YEAR);
        meseAttuale = dataOdierna.get(Calendar.MONTH) + 1;
        giornoAttuale = dataOdierna.get(Calendar.DAY_OF_MONTH);

        String annoDiNascitaString, meseDiNascitaString, giornoDiNascitaString;
        Integer annoDiNascita, meseDiNascita, giornoDiNascita, eta;

        giornoDiNascitaString = dataDiNascita.substring(0, 2);
        meseDiNascitaString = dataDiNascita.substring(3, 5);
        annoDiNascitaString = dataDiNascita.substring(6, 10);

        giornoDiNascita = Integer.parseInt(giornoDiNascitaString);
        meseDiNascita = Integer.parseInt(meseDiNascitaString);
        annoDiNascita = Integer.parseInt(annoDiNascitaString);

        if (meseAttuale > meseDiNascita || (Objects.equals(meseAttuale, meseDiNascita) && giornoAttuale >= giornoDiNascita)) {
            eta = annoAttuale - annoDiNascita;
        } else {
            eta = annoAttuale - annoDiNascita - 1;
        }

        return eta;
    }

    public String getPassword() {
        return password;
    }

    public final void setPassword(String password) throws Exception {
        boolean numero = false;
        boolean minuscolo = false;
        boolean maiuscolo = false;
        if (password != null) {
            if (password.matches("(.*)[[:word:]](.*)")) {

                minuscolo = true;
                maiuscolo = true;
                numero = true;

            }

        }
        if (minuscolo == true && maiuscolo == true && numero == true) {
            this.password = password;
        } else {
            throw new Exception("La password deve avere 8 caratteri uno di essi deve essere maiuscolo uno minuscolo e uno un numero");
        }

    }

    public String getEmail() {
        return email;
    }

    public final void setEmail(String email) throws Exception {

        String[] splitted = email.split("@");
        for (String splitted1 : splitted) {
            if (splitted1.substring(1).matches("(.*)[a-zA-Z0-9](.*)") && splitted1.substring(1).matches("(.*).(.*)")) {
                this.email = email;

            } else {
                throw new Exception("l'email deve avere il formato: aaaa@bbbb.cccc");
            }

        }
    }

    /**
     * @throws Exception
     */
    public String info() throws Exception {
        String info = null;

        if (cognome != null && nome != null && altezza != null && peso != null && dataDiNascita != null) {
            info = "Cognome        : " + cognome + "\n"
                    + "Nome           : " + nome + "\n"
                    + "Altezza        : " + altezza + "\n"
                    + "Peso           : " + peso + "\n"
                    + "Data di nascita: " + dataDiNascita + "\n"
                    + "Età            : " + calcolaEta() + "\n"
                    + "N. Istanze     : " + numeroIstanze + "\n";

            return info;
        } else {
            throw new Exception("Uno o più attributi sono nulli!");
        }
    }

    /**
     * @throws Exception
     */
    public Boolean verficaOmonimia(Persona8 persona) throws Exception {
        Boolean verifica = false;

        if (this.cognome != null && this.nome != null && persona.cognome != null && persona.nome != null) {
            if (this.cognome.equals(persona.cognome) && this.nome.equals(persona.nome)) {
                verifica = true;
            }

            return verifica;
        } else {
            throw new Exception("Verificare che gli attributi cognome e nome non siano nulli!");
        }
    }
}

// -----------------------------------------------------------------------------
class MyException extends Exception {

    public MyException(String message) {
        super(message);
    }
}

/* 
    Per utilizzare l'eccezione personalizzata è sufficiente sostituire:
    throw new Exception("...");
    con:
    throw new MyException("...");
 */
