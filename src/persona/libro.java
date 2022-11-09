package landrini;

/**
 *
 * @author Landrini Valentino
 */
public class libro {

    private String[] autori;
    private String casaEditrice;
    private final Float costo = 5.40f;
    private String titolo;
    private Integer nPagine;

    public libro() {

    }
/**
 * 
 * @param Autori
 * @param casaEditrice
 * @param titolo
 * @param nPagine 
 */
    public libro(String[] Autori, String casaEditrice, String titolo, int nPagine) {
        this.autori = Autori;
        this.casaEditrice = casaEditrice;
        this.titolo = titolo;
        this.nPagine = nPagine;
    }
    /**
    * restituisce 
    * @return autori
    */
    public String[] getAutori() {
        return autori;
    }
    /** 
    * 
    * @param Autori 
    */
    public void setAutori(String[] Autori) {
        this.autori = autori;
    }
    /**
     * 
     * @return casaEditrice 
     */
    public String getCasaEditrice() {
        return casaEditrice;
    }
    /**
     * 
     * @param casaEditrice 
     */
    public void setCasaEditrice(String casaEditrice) {
        this.casaEditrice = casaEditrice;
    }
    /**
     * 
     * @return costo
     */
    public float getCosto() {
        return costo;
    }
    /**
     * 
     * @return titolo
     */
    public String getLibro() {
        return titolo;
    }
    /**
     * 
     * @param Libro 
     */
    public void setLibro(String Libro) {
        this.titolo = titolo;
    }
    /**
     * 
     * @return nPagine 
     */
    public int getnPagine() {
        return nPagine;
    }
    /**
     * 
     * @param nPagine 
     */
    public void setnPagine(int nPagine) {
        this.nPagine = nPagine;
    }
    /**
     * 
     * @param titolo 
     */
    public final void setTitolo(String titolo) {
        Boolean valido = false;
        if (titolo != null) {
            char primo = titolo.charAt(0);
            int primoInt = (int) primo;
            for (int i = 65; i < 91; i++) {
                if (primoInt == i) {
                    this.titolo = titolo;
                }
            }
        }
    }
/**
 * 
 * @return info
 */
    public String gatinfo() {
            String autoriString = "";
            if(autori !=null){
            for(String autore : this.autori){
            autoriString += autore+ ", ";
            
            
            }
            }
            
        return "\n titolo" +(titolo !=null? this.titolo: "titolo")
               + "\n autore" +(autori !=null? this.autori: "")
               + "\n casa Editrice" + (casaEditrice !=null? this.casaEditrice: "casa editrice")
               + "\n pagine " + (nPagine !=null? this.nPagine :"pagine")
               + "\n costo " + (costo <5.40f? this.costo : "costo");
    }

}
