
package persona;

/**
 *
 * @author valentino.landrini
 */
public class Citta {

    private Persona4[] abitanti;
    private String nome;
    private Persona4 sindaco;
    private String superficie;
    private Integer densitPopolazione;
    private Integer etaMedia;
    private Integer numeroOmonimi;

    public Citta() {
    }
    
    public Citta(Persona4[] abitanti, String nome, Persona4 sindaco, String superficie) {
        this.abitanti = abitanti;
        this.nome = nome;
        this.sindaco = sindaco;
        this.superficie = superficie;
    }

    public Persona4[] getAbitanti() {
        return abitanti;
    }

    public void setAbitanti(Persona4[] abitanti) {
        this.abitanti = abitanti;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Persona4 getSindaco() {
        return sindaco;
    }

    public void setSindaco(Persona4 sindaco) {
        this.sindaco = sindaco;
    }

    public String getSuperficie() {
        return superficie;
    }

    public void setSuperficie(String superficie) {
        this.superficie = superficie;
    }

    public Integer densitaPopolazione(){
       
        return 0;
  }
    public Integer etaMedia(){
    
    return 0;
    } 
    public Integer numeroOmonimi(){
    
    return 0;
    }
    public String infoc() {
        String infoc = "";

       infoc = "Nome Città         : " + this.nome
              +"Sindaco            : " + this.sindaco
              +"Densità popolazione: " + this.densitPopolazione
              +"età media          : " + this.etaMedia
              +"numero Omonimi     : " + this.numeroOmonimi;
        return infoc;
    }
    
    
}  
    
    
    

