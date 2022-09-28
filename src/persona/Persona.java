package persona;

/**
 * la classe Persona definisce alcune caratteristiche di un essere umano 
 * @author valentino.landrini
 * @version 0.1 28/09/2022 
 */
public class Persona {

    public Double altezza;
    public String cognome;
    public String DataDiNascita;
    public String nome;
    public Float  peso;
    /**
    * costruttore della classe persona senza parametri 
    * per impostare i parametri si possono usare i seguenti metodi  
    * { @link #setAltezza (double altezza) }            <br>
    * { @link #setCognome (String cognome) }            <br>
    * { @link #setNome (String nome) }                  <br>
    * { @link #setPeso (Float peso) }                   <br>
    * { @link #setDataDiNascita(String datadinascita) } 
    */
    public Persona() {
    }
    /**
     * 
     * 
     * 
     * 
     * @param altezza 
     * @param cognome
     * @param DataDiNascita
     * @param nome
     * @param peso 
     */
    public Persona(Double altezza, String cognome, String DataDiNascita, String nome, Float peso) {
        this.altezza = altezza;
        this.cognome = cognome;
        this.DataDiNascita = DataDiNascita;
        this.nome = nome;
        this.peso = peso;
    }
    /**
     *  restituisce l'altezza della persona 
     * 
     * 
     * @return altezza 
     */

    public Double getAltezza() {
        return altezza;
    }
    /**
    * 
    *  imposta l'altezza della persona 
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
        return DataDiNascita;
    }
    
        /**
         * imposta la data di nascita di una persona 
         * 
         * 
         * @param DataDiNascita 
         */

    public void setDataDiNascita(String DataDiNascita) {
        this.DataDiNascita = DataDiNascita;
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
    
    public String info(){
        String info = "";
        
        info = "cognome          : "  +  this.cognome + "\n"
              +"nome             : "  +  this.nome + "\n"
              +"altezza          : "  +  this.DataDiNascita +"\n"
              +"peso             : "  +  this.peso + "\n"
              +"data di nascita  : "  +  this.DataDiNascita + "\n";
                
                
    
        
        
        return info;
    }
    
    
}
