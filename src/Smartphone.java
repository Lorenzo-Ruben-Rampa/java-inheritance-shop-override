import java.math.BigDecimal;
import java.util.Random;

public class Smartphone extends Prodotto {
    
    // Attributi
    protected String memoriaRam;
    protected BigDecimal codiceIMEI;

    // 1° Costruttore
    public Smartphone(int codice, String nome, String marca, BigDecimal prezzo, BigDecimal iva) {
        super(codice, nome, marca, prezzo, iva);
        this.memoriaRam = generatoreMemoriaRam();
        this.codiceIMEI = generatoreCodiceIMEI();
    }

    // metodi privati
    protected static String generatoreMemoriaRam() {
        int[] arrayMemoria = new int[] {2, 3, 4, 8, 12, 16};
        Random generator = new Random();
        int randomIndex = generator.nextInt(arrayMemoria.length);
        return arrayMemoria[randomIndex] + " GB";
    }

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
    public String getMemoriaRam() {
        return memoriaRam;
    }

    public void setMemoriaRam(String memoriaRam) {
        this.memoriaRam = memoriaRam;
    }

    public BigDecimal getCodiceIMEI() {
        return codiceIMEI;
    }

    public void setCodiceIMEI(BigDecimal codiceIMEI) {
        this.codiceIMEI = codiceIMEI;
    }

    @Override
    public String toString() {
	return super.toString() + "\nCodice IMEI: " + getCodiceIMEI() + "\nGiga: " + getMemoriaRam();
    }
}