package bridi;

/**
 *
 * @author 75verifica19
 * @version 1.0.0
 */
public class Libro {
    private String[] autori;
    private String casaEditrice;
    private Double costo;
    private Integer numeroPagine;
    private String titolo;

    /**
     * Costruttore della classe vuoto<br>
     * Si possono impostare i parametri con:<br>
     * {@link #setAutori(java.lang.String[])}<br>
     * {@link #setCasaEditrice(java.lang.String)}<br>
     * {@link #setNumeroPagine(java.lang.Integer)}<br>
     * {@link #setTitolo(java.lang.String)}<br>
     */
    public Libro() {
        
    }
    
    /**
     * Costruttore della classe parametrizzato
     * 
     * @param autori Nomi degli autori
     * @param casaEditrice Nome della casa editrice
     * @param numeroPagine Numero di pagine
     * @param titolo Titolo
     */
    public Libro(String[] autori, String casaEditrice, Integer numeroPagine, String titolo) {
        this.setAutori(autori);
        this.setCasaEditrice(casaEditrice);
        this.setNumeroPagine(numeroPagine);
        this.setTitolo(titolo);
    }
    
    /**
     * Restituisce il vettore contenente i nomi degli autori
     * 
     * @return autori
     */
    public String[] getAutori() {
        return this.autori;
    }

    /**
     * Imposta il nome degli autori
     * 
     * @param autori Nomi degli autori
     */
    public final void setAutori(String[] autori) {
        int nSpazi = 0;
        if(autori != null) {
            for(String autore : autori) {
                String[] autoreNomeCognome = autore.split(" ");
                if(autoreNomeCognome.length == 2) {
                    nSpazi++;
                }
            }
            if(nSpazi == autori.length) {
                this.autori = autori;
                this.ordinaAutori();
            }
        }
    }

    /**
     * Restituisce il nome della casa editrice
     * 
     * @return casaEditrice
     */
    public String getCasaEditrice() {
        return this.casaEditrice;
    }

    /**
     * Imposta il nome della casa editrice
     * 
     * @param casaEditrice Nome della casa editrice
     */
    public final void setCasaEditrice(String casaEditrice) {
        String[] casaEditriceVett = casaEditrice.split(" ");
        if(casaEditriceVett.length == 1) {
            this.casaEditrice = casaEditrice;
        }
    }

    /**
     * Restituisce il costo del libro
     * 
     * @return costo
     */
    public Double getCosto() {
        return this.costo;
    }

    /**
     * Restituisce il numero di pagine del libro
     * 
     * @return numeroPagine
     */
    public Integer getNumeroPagine() {
        return this.numeroPagine;
    }

    /**
     * Imposta il numero di pagine
     * @param numeroPagine Numero di pagine
     */
    public final void setNumeroPagine(Integer numeroPagine) {
        if(numeroPagine%2==0) {
            this.numeroPagine = numeroPagine;
            this.calcolaCosto();
        }
    }

    /**
     * Restituisce il titolo del libro
     * 
     * @return titolo
     */
    public String getTitolo() {
        return this.titolo;
    }

    /**
     * Imposta il titolo del libro
     * 
     * @param titolo Titolo del libro
     */
    public final void setTitolo(String titolo) {
        if(titolo != null) {
            char primo = titolo.charAt(0);
            int primoInt = (int)(primo);
            for(int i=65; i<91; i++) {
                if(primoInt == i) {
                    this.titolo = titolo;
                }
            }
        }
    }
    
    /**
     * Calcola il costo del libro (5.40 + (numeroPagine * 0.01)
     */
    private void calcolaCosto() {
        this.costo = 5.40 + (this.numeroPagine * 0.01);
    }
    
    /**
     * Ritorna il numero di autori
     * 
     * @return numeroDiAutori
     */
    public Integer numeroDiAutori() {
        return this.autori.length;
    }
    
    /**
     * Ordina gli autori per ordine alfabetico (nome)
     */
    private void ordinaAutori() {
        for(int i=0; i<autori.length; i++) {
            boolean flag = false;
            for(int j=0; j<autori.length-1; j++) {
                if(autori[j].charAt(0) > autori[j+1].charAt(0)) {
                    String temp = autori[j];
                    autori[j] = autori[j+1];
                    autori[j+1] = temp;
                    flag = true;
                }
            }
            if(!flag) break;
        }
    }
    
    /**
     * Restituisce le informazioni generali sul libro
     * 
     * @return infoLibro
     */
    public String getInfo() {
        String autoriString = "";
        if(autori != null) {
            for(String autore : this.autori) {
                autoriString += autore+", ";
            }
        }
        return "\nTitolo:        "+(this.titolo!=null?this.titolo:"")+
               "\nCasa Editrice: "+(this.casaEditrice!=null?this.casaEditrice:"")+
               "\nAutori:        "+(this.autori!=null?autoriString:"")+
               "\nNumero pagine: "+(this.numeroPagine!=null?this.numeroPagine.toString():"")+
               "\nCosto:         "+(this.costo!=null?this.costo:"")+"\n";
    }
}
