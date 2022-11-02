package landrini.MezzoDiTrasporto;

/**
 *
 * @author Landrini Valentino
 */
public class MezzoDiTrasporto {

    private float cavalli;
    private int cilindrata;
    private String colore;
    private String modello;
    private String marca;
    private float KW;

    
    public MezzoDiTrasporto(int cavalli, int cilindrata, String colore, String modello, String marca) {
        this.cavalli = cavalli;
        this.cilindrata = cilindrata;
        this.colore = colore;
        this.modello = modello;
        this.marca = marca;
        
    }
    
    

    public float getCavalli() {
        return cavalli;
    }

    public void setCavalli(int cavalli) {      
        if(this.cavalli < 0){
        this.cavalli = cavalli;
        
        }else{
        this.cavalli = 0; 
        }
       
    }

    public int getCilindrata() {
        return cilindrata;
    }

    public void setCilindrata(int cilindrata) {
        this.cilindrata = cilindrata;
    }

    public String getColore() {
        return colore;
    }

    public void setColore(String Colore) {
        this.colore = Colore;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public float getKW() {
        return KW;
    }

    public void setKW(float KW) {
        this.KW = KW;
    }

    public float CalcoloKW() {
        KW = (this.cavalli * 0.73f);
        

        return KW;
    }

    public String stampa() {

        String info;
        

        info = "cavalli = " + this.cavalli + "\n"
                + "cilindrata = " + this.cilindrata + "\n"
                + "colore = " + this.colore + "\n"
                + "modello = " + this.modello + "\n"
                + "marca = " + this.marca;
        

        return info;

    }

}
