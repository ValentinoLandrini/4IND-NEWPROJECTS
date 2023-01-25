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
    String infoc;

    public Citta() {
    }

    public Citta(Persona4[] abitanti, String nome, Persona4 sindaco, String superficie) {
        setAbitanti(abitanti);
        setNome(nome);
        setSindaco(sindaco);
        setSuperficie(superficie);
    }

    public Persona4[] getAbitanti() {
        Persona4 arrayCopy[];
        arrayCopy = abitanti.clone();

        return arrayCopy;
    }

    public void setAbitanti(Persona4[] abitanti) {
        Boolean f = false;
        if (abitanti != null) {
            for (int i = 0; i < abitanti.length; i++) {
                if (abitanti[i] == null) {
                    f = false;
                }
            }
        }
        if(f == true ){
        Persona4 arrayCopy[];
        
        
        
        }
        
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

    public Integer densitaPopolazione() {

        return 0;
    }

    public Integer etaMedia() {

        return 0;
    }

    public Integer numeroOmonimi() {

        return 0;
    }

    public String infoc() {
        String infoc = "";

        infoc = "Nome Città         : " + this.nome
                + "Sindaco            : " + this.sindaco
                + "Densità popolazione: " + this.densitPopolazione
                + "età media          : " + this.etaMedia
                + "numero Omonimi     : " + this.numeroOmonimi;
        return infoc;
    }

}
