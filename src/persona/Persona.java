package persona;

/**
 *
 * @author valentino.landrini
 */
public class Persona {

    public Double altezza;
    public String cognome;
    public String DataDiNascita;
    public String nome;
    public Float  peso;

    public Persona() {
    }

    public Persona(Double altezza, String cognome, String DataDiNascita, String nome, Float peso) {
        this.altezza = altezza;
        this.cognome = cognome;
        this.DataDiNascita = DataDiNascita;
        this.nome = nome;
        this.peso = peso;
    }

    public Double getAltezza() {
        return altezza;
    }

    public void setAltezza(Double altezza) {
        this.altezza = altezza;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getDataDiNascita() {
        return DataDiNascita;
    }

    public void setDataDiNascita(String DataDiNascita) {
        this.DataDiNascita = DataDiNascita;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }
    
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
