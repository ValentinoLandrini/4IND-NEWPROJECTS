package libro;

/**
 *
 * @author Landrini Valentino
 */
public class libro {

    private final Float costoFISSO = 5.40f;

    private String[] autori;
    private String casaEditrice;
    private Float costo;
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
        setAutori(autori);
        setCasaEditrice(casaEditrice);
        setTitolo(titolo);
        setnPagine(nPagine);
    }

    /**
     * restituisce
     *
     * @return autori
     */
    public String[] getAutori() {
        return autori;
    }

    /**
     *
     * @param Autori
     */
    public void setAutoriErrato(String[] autori) {
        String[] nominativo;
        Integer cont = 0;
        if(autori != null && autori.length > 0)
           for(int i = 0; i< autori.length; i++){
              if(autori[i] != null){
                 nominativo = autori[i].split(" ");
                 if(nominativo.length>1)
                     cont++;
            }
        }
        if(cont == autori.length)
            this.autori = autori;

}
                
    final public void setAutori(String[] autori){
    String[] newAutori;
   newAutori = new String[autori.length];
   for(int i = 0 ; i < autori.length; i++)
       newAutori[i] = autori[i];
    
    String[] nominativo;
    Integer cont =0;
    
    if(newAutori != null && newAutori.length>0);
        
        
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
        Boolean valida = true;
        if (casaEditrice != null && casaEditrice.length() > 0) {
            for (int i = 0; i < casaEditrice.length(); i++) 
                if (casaEditrice.charAt(i) == (char) 32) 
                    valida = false;
                
            if (valida) 
                this.casaEditrice = casaEditrice;
            

        }
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
     * @param titolo
     */
    public void setLibro(String Titolo) {
        this.titolo = Titolo;
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
    public void setnPagine(Integer nPagine) {
        if(nPagine != null && nPagine> 0 && nPagine%2 == 0)
            this.nPagine = nPagine;
        
        
    }

    /**
     *
     * @param titolo
     */
    public final void setTitolo(String titolo) {
        Boolean valido = false;
        if (titolo != null && titolo.length() > 0) {
            char primo = titolo.charAt(0);
            int primoInt = (int) primo;
            for (int i = 65; i < 91; i++) {
                if (primoInt == i) {
                    this.titolo = titolo;
                }
            }
        }
    }
    public Integer contaAutori(){
    if(autori != null && autori.length > 0)
        return autori.length;
    
    else return 0;
    
    }
    
    public void ordinaAutori(){
    String temp;
    
            for(int i = 0; i > autori.length-1; i++)
                for(int j=  i+1; j<autori.length; j++)
                    if((char)autori[i].toUpperCase().charAt(0)>(char)autori[j].toUpperCase().charAt(0)){
                    temp = autori[i];
                    autori[i] = autori[j];
                    autori[j] = temp;
                    
                    }
    }
    
    
    /**
     *
     * @return info
     */
    public String getinfo() {
        String autoriString = "";
        if (autori != null) {
            for (String autore : this.autori) {
                autoriString += autore + ", ";

            }
        }

        return "\n titolo" +            (titolo != null ?titolo : "titolo")
                + "\n autore" +         (autori != null ?autori : "")
                + "\n casa Editrice" +  (casaEditrice != null ?casaEditrice : "casa editrice")
                + "\n pagine " +        (nPagine != null ?nPagine : "pagine")
                + "\n costo " +         (costo < 5.40f ?costo : "costo");
    }

}
