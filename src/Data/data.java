package Data;

import java.time.DayOfWeek;
import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class data {
    private String data;
    private Integer giorno;
    private Integer mese;
    private Integer anno;
    
    public data() {
        LocalDate oggi = LocalDate.now();
        this.giorno = oggi.getDayOfMonth();
        this.mese = oggi.getMonthValue();
        this.anno = oggi.getYear();
        this.data = oggi.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
    
    public data(String data) {
        setdata(data);
    }
    
    public data(Integer giorno, Integer mese, Integer anno) {
        setGiorno(giorno);
        setMese(mese);
        setAnno(anno);
        this.data = giorno + "/" + mese + "/" + anno;
    }
    
    public data(data data) {
        this.giorno = data.giorno;
        this.mese = data.mese;
        this.anno = data.anno;
        this.data = data.data;
    }
    
    public String getData() {
        return data;
    }
    
    public void setdata(String data) {
        String[] parti = data.split("/");
        setGiorno(Integer.parseInt(parti[0]));
        setMese(Integer.parseInt(parti[1]));
        setAnno(Integer.parseInt(parti[2]));
        this.data = data;
    }
    
    public Integer getGiorno() {
        return giorno;
    }
    
    public void setGiorno(Integer giorno) {
        if (giorno < 1 || giorno > 31) {
            throw new IllegalArgumentException("Giorno non valido");
        }
        this.giorno = giorno;
        this.data = giorno + "/" + mese + "/" + anno;
    }
    
    public Integer getMese() {
        return mese;
    }
    
    public void setMese(Integer mese) {
        if (mese < 1 || mese > 12) {
            throw new IllegalArgumentException("Mese non valido");
        }
        this.mese = mese;
        this.data = giorno + "/" + mese + "/" + anno;
    }
    
    public Integer getAnno() {
        return anno;
    }
    
    public void setAnno(Integer anno) {
        if (anno < 1900 || anno > 2100) {
            throw new IllegalArgumentException("Anno non valido");
        }
        this.anno = anno;
        this.data = giorno + "/" + mese + "/" + anno;
    }
    
    public String giornoDellaSettimana() {
        LocalDate localDate = LocalDate.of(anno, mese, giorno);
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        return dayOfWeek.toString();
    }
    
    
   public int differenzaInSettimane(data dataAntecedente, data dataSuccessiva) {
    long diffInDays = differenzaInGiorni(dataAntecedente, dataSuccessiva);
    int diffInWeeks = (int) diffInDays / 7;
    return diffInWeeks;
}

public int differenzaInMesi(data dataAntecedente, data dataSuccessiva) {
    int diffInYears = differenzaInAnni(dataAntecedente, dataSuccessiva);
    int months1 = dataAntecedente.getMese();
    int months2 = dataSuccessiva.getMese();
    int diffInMonths = months2 - months1 + 12 * diffInYears;
    return diffInMonths;
}

public int differenzaInAnni(data dataAntecedente, data dataSuccessiva) {
    int years1 = dataAntecedente.getAnno();
    int years2 = dataSuccessiva.getAnno();
    int diffInYears = years2 - years1;
    return diffInYears;
}

public String differenzaInGiorniMesiAnni(data dataAntecedente, data dataSuccessiva) {
    int diffInYears = differenzaInAnni(dataAntecedente, dataSuccessiva);
    int diffInMonths = differenzaInMesi(dataAntecedente, dataSuccessiva);
    long diffInDays = differenzaInGiorni(dataAntecedente, dataSuccessiva);

    String result = diffInDays + " giorni";
    if (diffInMonths > 0) {
        result = diffInMonths + " mesi, " + result;
    }
    if (diffInYears > 0) {
        result = diffInYears + " anni, " + result;
    }
    return result;
}
    @Override
    public String toString() {
        String d;
        
        d=giornoDellaSettimana()+" ";
        switch (mese) {
                    case 1:
                        d=d+" gennaio";
                        break;
                    case 2:
                        d=d+" febbraio";
                        break;
                    case 3:
                        d=d+" marzo";
                        break;
                    case 4:
                        d=d+" aprile";
                        break;
                    case 5:
                        d=d+" maggio";
                        break;
                    case 6:
                        d=d+" giugno";
                        break;
                    case 7:
                        d=d+" luglio";
                        break;
                    case 8:
                        d=d+" agosto";
                        break;
                    case 9:
                        d=d+" settembre";
                        break;
                    case 10:
                        d=d+" ottobre";
                        break;
                    case 11:
                        d=d+" novembre";
                        break;
                    case 12:
                        d=d+" dicembre";
                        break;
        }
        d=d+anno;
        
        return d; 
}

    private long differenzaInGiorni(data dataAntecedente, data dataSuccessiva) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}