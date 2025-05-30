import java.math.BigDecimal;
import java.util.Random;

public class Smartphone extends Prodotto {
    
    // Attributi
    protected int memoriaRam;
    protected BigDecimal codiceIMEI;

    // 1° Costruttore
    public Smartphone(int codice, String nome, String marca, BigDecimal prezzo, BigDecimal iva, int memoriaRam) {
        super(codice, nome, marca, prezzo, iva);
        this.memoriaRam = memoriaRam;
        this.codiceIMEI = generatoreCodiceIMEI();
    }

    // metodi privati
    // protected static String generatoreMemoriaRam() {
    //     int[] arrayMemoria = new int[] {2, 3, 4, 8, 12, 16};
    //     Random generator = new Random();
    //     int randomIndex = generator.nextInt(arrayMemoria.length);
    //     return arrayMemoria[randomIndex] + " GB";
    // }

    private BigDecimal generatoreCodiceIMEI() {
    Random rand = new Random();
    // Inizia con 35 (prime due cifre fisse) e genera 13 cifre casuali
    long codice = 35;  // Inizia con 35
    
    // Genera le restanti 13 cifre
    for (int i = 0; i < 13; i++) {
        codice = codice * 10 + rand.nextInt(10);
    }
    return BigDecimal.valueOf(codice);
}

    // Metodi pubblici
    // Getters e Setters
    public int getMemoriaRam() {
        return memoriaRam;
    }

    public void setMemoriaRam(int memoriaRam) {
        this.memoriaRam = memoriaRam;
    }

    public BigDecimal getCodiceIMEI() {
        return codiceIMEI;
    }

    public void setCodiceIMEI(BigDecimal codiceIMEI) {
        this.codiceIMEI = codiceIMEI;
    }

    // OVERRIDE
    @Override
    public BigDecimal calcolaPrezzoFedelta() {
        // Determina la percentuale di sconto in base alla memoria
        BigDecimal percentualeSconto = (memoriaRam < 32) ? new BigDecimal("0.05") : new BigDecimal("0.02");
            return calcolaPrezzoScontato(true, percentualeSconto);
    }

    @Override
    public String toString() {
    String base = super.toString(true);
        String scontoInfo = (memoriaRam < 32) ? "(5%)" : "(2%)";
        return base.replace("(2%)", scontoInfo) + 
               "\nCodice IMEI: " + codiceIMEI + 
               "\nRAM: " + memoriaRam + " GB" +
               "\nTipo sconto applicato: " + scontoInfo;
    }
}