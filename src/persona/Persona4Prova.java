package persona;

/**
 *
 * @author valentino.landrini
 */
public class Persona4Prova {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Persona6[] arr = new Persona6[5];
        
       
        Persona4 p4 = new Persona4(1.80, "landrini", "19/8/2004", "valentino", 55f);
        Persona4 p6 = new Persona6(1.80, "landrini", "19/8/2004", "valentino", 55f);
        Persona4[] abitanti = null;
        Citta c1 = new Citta(abitanti, "Trento", p6,"129738");

        String info = p4.info();
        String infoc = c1.infoc;

        System.out.println("informazioni\n" + info);
        System.out.println("informazioni città\n" + infoc);
        System.out.println("eta': " + p4.calcoloEta());   
        System.out.println("omonimia: " + p6.verificaOmonimia(p4));
        System.out.println("omonimia: " + Persona6.verificaOmonimia(p4, p4));

    }

}
