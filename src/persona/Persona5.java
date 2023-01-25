package persona;
 import java.time.ZoneId;
 import java.time.ZonedDateTime;
 import java.util.Objects;
 
 
 public class Persona5 {
     
     private Double altezza;
     private String cognome;
     private String dataDiNascita;
     private String nome;
     private Float  peso;
     
     private final ZoneId z = ZoneId.of("Europe/Rome");
     private final ZonedDateTime zdt = ZonedDateTime.now(z);
     
     private Integer giornoAttuale;
     private Integer meseAttuale;
     private Integer annoAttuale;
     
     private Integer giornoDiNascita;
     private Integer meseDiNascita;
     private Integer annoDiNascita;
     
     private static int numeroIstanze;
 
     /**
      * Costruttore della classe Persona senza parametri. Per impostare i
      * parametri si possono usare i seguenti metodi:
      * {@link #setAltezza(Double altezza)} <br>
      * {@link #setCognome(String cognome)} <br> {@link #setNome(String nome)}
      * <br> {@link #setPeso(Float peso)} <br>
      * {@link #setDataDiNascita(String dataDiNascita)}  
      */
     public Persona5() {
         Persona5.numeroIstanze++;
     }
     
     /**
      * Costruttore della classe parametrizzato
      *  
      * @param altezza Altezza
      * @param cognome Cognome
      * @param dataDiNascita Data di Nascita
      * @param nome Nome
      * @param peso Peso
      * @throws Exception
      */
     public Persona5(Double altezza, String cognome, String dataDiNascita, String nome, Float peso) throws Exception {
         this();
        
             this.setCognome(cognome);
             this.setDataDiNascita(dataDiNascita);
             this.setAltezza(altezza);
             this.setNome(nome);
             this.setPeso(peso);
        
     }
     
     public Persona5(Persona5 persona) {
         this();
         this.nome = persona.nome;
         this.cognome = persona.cognome;
         this.dataDiNascita = persona.dataDiNascita;
         this.altezza = persona.altezza;
         this.peso = persona.peso;
         this.getDataDiNascitaAsInteger(this.dataDiNascita);
     }
 
     
     public Double getAltezza() {
         return this.altezza;
     }
     
     /**
      * Imposta l'altezza della persona
      *  
      * @param altezza Altezza
      * @throws Exception
      */
     final public void setAltezza(Double altezza) throws Exception {
         if(altezza != null && this.dataDiNascita != null) {
             if(this.calcoloEta() <= 10) {
                 if(altezza >= 50 && altezza <= 100) {
                     this.altezza = altezza;
                 }
             }
             else if(altezza >= 100 && altezza <= 200) {
                 this.altezza = altezza;
             }
         }
         else {
             throw new Exception("Altezza e data di nascita non possono essere null");
         }
     }
 
     /**
      * Restituisce il cognome della persona
      *  
      * @return cognome
      */
     public String getCognome() {
         return this.cognome;
     }
 
     /**
      * Imposta il cognome della persona
      *  
      * @param cognome Cognome
      * @throws Exception
      */
     final public void setCognome(String cognome) throws Exception {
         Boolean isLower = false;
         
         if(cognome.substring(1).matches("[a-zàòèéùì]*"))
             isLower = true;
         
         if(Character.isUpperCase(cognome.charAt(0)) && isLower) {
             this.cognome = cognome;
         }
         else {
             throw new Exception("Cognome invalido!");
         }
     }
 
     /**
      * Restituisce il nome della persona
      *  
      * @return nome
      */
     public String getNome() {
         return this.nome;
     }
 
     /**
      * Imposta il nome della persona
      *  
      * @param nome Nome
      * @throws Exception
      */
     final public void setNome(String nome) throws Exception {
         if(nome != null) {
             Boolean is_lowercase = true, first_uppercase = true;
             String[] splitted = nome.split(" ");
             for (String splitted1 : splitted) {
                 char prima = splitted1.charAt(0);
                 if(!Character.isUpperCase(prima)) {
                     first_uppercase = false;
                     break;
                 }
                 String resto = splitted1.substring(1);
                 for(int j=0; j<resto.length(); j++) {
                     if(resto.charAt(j) >= 'a' && resto.charAt(j) <= 'z') {
                         is_lowercase = true;
                     }
                     else {
                         is_lowercase = false;
                         break;
                     }
                 }
                 if(!is_lowercase){
                     break;
                 }
             }
             
 
             if(first_uppercase && is_lowercase) {
                 this.nome = nome;
             }
             else {
                 throw new Exception("Invalid name");
             }
         }
         
     }
 
     /**
      * Restituisce il peso della persona
      *  
      * @return peso
      */
     public Float getPeso() {
         return this.peso;
     }
 
     /**
      * Imposta il peso della persona
      *  
      * @param peso Peso
      * @throws Exception
      */
     final public void setPeso(Float peso) throws Exception {
         if(peso > 0) {
             this.peso = peso;
         }
         else {
             throw new Exception("Invalid peso ");
         }
     }
     
     
     public String getDataDiNascita() {
         return this.dataDiNascita;
     }
 
   
     final public void setDataDiNascita(String dataDiNascita) throws Exception {
         boolean valid;
         
         aggiornaDataAttuale();
         
         valid = getDataDiNascitaAsInteger(dataDiNascita);
         
         if(valid){
 
             if(Objects.equals(annoDiNascita, annoAttuale)){
                 if(Objects.equals(meseDiNascita, meseAttuale)){
                     if(giornoDiNascita > giornoAttuale)
                         valid = false;
                 }
                 else if(meseDiNascita > meseAttuale){
                     valid = false;
                 }
             }
 
         }
         else{
             giornoDiNascita = 0;
             meseDiNascita = 0;
             annoDiNascita = 0;
         }  
 
         boolean bisestile = (
             annoDiNascita > 1584 && (
                 (annoDiNascita % 400 == 0) ||  
                 (annoDiNascita %4 == 0 && annoDiNascita % 100 != 0)
             )
         );
 
         if(annoDiNascita > annoAttuale) {
             valid = false;
         }
         else if(meseDiNascita < 1 || meseDiNascita > 12) {
             valid = false;
         }
         switch(meseDiNascita){
             case 1:
             case 3:
             case 5:
             case 7:
             case 8:
             case 10:
             case 12:
                 if(giornoDiNascita < 1 || giornoDiNascita > 31) {
                     valid = false;
                 }
                 break;
 
             case 4:
             case 6:
             case 9:
             case 11:
                 if(giornoDiNascita < 1 || giornoDiNascita > 30) {
                     valid = false;
                 }
                 break;
 
             case 2:
                 if(bisestile) {
                     if(giornoDiNascita < 1 || giornoDiNascita > 29) {
                         valid = false;
                     }
                 }
                 else {
                     if(giornoDiNascita < 1 || giornoDiNascita > 28) {
                         valid = false;
                     }
                 }  
             }
         
         if(valid) {
             this.dataDiNascita = dataDiNascita;
         }
         else {
             throw new Exception("Invalid date format!");
         }
     }
     
     /**
      * Restituisce il numero di istanze create
      *  
      * @return numeroIstanze
      */
     public static int getNumeroIstanze() {
         return Persona5.numeroIstanze;
     }
     
     /**
      * Restituisce l'età in anni calcolata dalla data di nascita
      *  
      * @return eta
      */
     public Integer calcoloEta() {
         int eta;
         
         aggiornaDataAttuale();
         
         if(dataDiNascita != null){
             eta = annoAttuale - annoDiNascita;
             if(meseAttuale < meseDiNascita && giornoAttuale < giornoDiNascita) {
                 eta -= 1;
             }
             else if(meseAttuale < meseDiNascita) {
                 eta -= 1;
             }
         }
         else
             return null;
         
         return eta;
     }
     
     /**
      * Aggiorna la data attuale
      *  
      */
     private void aggiornaDataAttuale() {
         this.giornoAttuale = zdt.getDayOfMonth();
         this.meseAttuale = zdt.getMonthValue();
         this.annoAttuale = zdt.getYear();
     }
     
     /**
      * Estrae dalla stringa dataDiNascita: giorno mese e anno in Integer
      *  
      * @param dataDiNascita Data di nascita
      * @return parsed
      */
     private Boolean getDataDiNascitaAsInteger(String dataDiNascita) {
         if(dataDiNascita != null) {
             String[] splitted = dataDiNascita.split("/");
             if(splitted.length == 3) {
                 giornoDiNascita = Integer.parseInt(splitted[0]);
                 meseDiNascita = Integer.parseInt(splitted[1]);
                 annoDiNascita = Integer.parseInt(splitted[2]);
                 return true;
             }
         }
         return false;
     }
     
     
     public Boolean verificaOmonimia(Persona5 persona) throws NullPointerException {
         if(persona != null) {
             if(this.nome.equals(persona.nome))
                 if(this.cognome.equals(persona.cognome))
                     return true;
             return false;
         }
         throw new NullPointerException("persona can't be null");
     }
     
   
     public String info() {
         
         String info;
         
         info = "Cognome         : "+(this.cognome       != null ? this.cognome             : "")+"\n"
              + "Nome            : "+(this.nome          != null ? this.nome                : "")+"\n"
              + "Altezza         : "+(this.altezza       != null ? this.altezza.toString()  : "")+"\n"
              + "Peso            : "+(this.peso          != null ? this.peso.toString()     : "")+"\n"
              + "Data di nascita : "+(this.dataDiNascita != null ? this.dataDiNascita       : "")+"\n"
              + "Età             : "+(this.calcoloEta()  != null ? this.calcoloEta()        : "")+"\n"
              + "Numero istanze  : "+Persona5.numeroIstanze                                      +"\n";
         
         return info;
     }
     
 }   
