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
        this.codice = generatoreCodice();
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
	if(nome != null) {
		return "\n" +"Articolo: " + codice + " - " + nome + "\nPrezzo: " + generatorePrezzoFinale() + " euro";
	}
	return null;
}
}
