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

       
        Persona4 p4 = new Persona4(1.80, "landrini", "19/8/2004", "valentino", 55f);
        Persona4 p5 = new Persona4(1.80, "landrini", "19/8/2004", "valentino", 55f);

        String info = p4.info();

        System.out.println("informazioni\n" + info);

        System.out.println("eta': " + p4.calcoloEta());   
        System.out.println("omonimia: " + p4.verificaOmonimia(p5));
        System.out.println("omonimia: " + Persona4.verificaOmonimia(p4, p5));

    }

}
