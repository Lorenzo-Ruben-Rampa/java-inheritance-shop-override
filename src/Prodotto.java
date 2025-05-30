import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class Prodotto {
    private final int codice;
    private String nome;
    private String marca;
    private BigDecimal prezzo;
    private BigDecimal iva;

    // Costruttore della classe Prodotto
    public Prodotto(int codice, String nome, String marca, BigDecimal prezzo, BigDecimal iva) {
        this.codice = codice;
        this.nome = nome;
        this.marca = marca;
        this.prezzo = prezzo;
        this.iva = iva.setScale(2, RoundingMode.HALF_UP);
    }

    // 2° Costruttore (IVA di default)
    public Prodotto(int codice, String nome, String marca, BigDecimal prezzo) {
        this(codice, nome, marca, prezzo, new BigDecimal("0.22")); // IVA default 22%
    }

    // Metodi Privati

    protected static int generatoreCodice() {
        // Genera un codice univoco per il prodotto
        return new Random().nextInt(9999);
    }
    
    //     //metodo per generare prezzo base casuale
    // protected void generatorePrezzoBase() {
    //     Random rand = new Random();
    //     this.prezzo = new BigDecimal(rand.nextInt(100) + 1).setScale(2, RoundingMode.HALF_UP);
    // }

    // Metodi Pubblici

        public BigDecimal generatorePrezzoFinale() {
        if(prezzo != null && iva != null) {
            return prezzo.add(prezzo.multiply(iva)).setScale(2, RoundingMode.DOWN);
        }   
    return null;
    }

    // Metodo per calcolare il prezzo scontato generico
    public BigDecimal calcolaPrezzoScontato(boolean applicaScontoFedelta, BigDecimal percentualeSconto) {
        if (prezzo == null || iva == null) return null;
        
        BigDecimal prezzoBase = applicaScontoFedelta ? 
                            prezzo.subtract(prezzo.multiply(percentualeSconto)) : 
                            prezzo;
        
        return prezzoBase.add(prezzoBase.multiply(iva)).setScale(2, RoundingMode.DOWN);
    }

    // Metodo per calcolare il prezzo scontato del 2%
    public BigDecimal calcolaPrezzoFedelta() {
    return calcolaPrezzoScontato(true, new BigDecimal("0.02")); // Richiama il metodo generico
}

    // Getters e Setters
    public int getCodice() {
        return codice;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public BigDecimal getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }

    public BigDecimal getIva() {
        return iva;
    }

    public void setIva(BigDecimal iva) {
        this.iva = iva;
    }
    
    @Override
    public String toString() {
    return toString(false); // Default: mostra prezzo normale
    }
    public String toString(boolean haTesseraFidaty) {
        if(nome != null) {
            String baseString = "Articolo: " + codice + " - " + nome;
            if (haTesseraFidaty) {
                return baseString + "\nPrezzo Fedelta' (2%): " + calcolaPrezzoFedelta() + " euro";
            } else {
                return baseString + "\nPrezzo: " + prezzo.add(prezzo.multiply(iva)).setScale(2, RoundingMode.DOWN)+ " euro";
            }
        }
        return null;
    }
}