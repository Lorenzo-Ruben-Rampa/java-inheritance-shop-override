import java.math.BigDecimal;

public class Televisore extends Prodotto {

    // Attributi
    protected int dimensioni;
    protected boolean IssmartTV;

    // 1° Costruttore
    public Televisore(int codice, String nome, String marca, BigDecimal prezzo, BigDecimal iva, int dimensioni, Boolean issmartTV) {
        super(codice, nome, marca, prezzo, iva);
        this.dimensioni = dimensioni;
        this.IssmartTV = issmartTV;
    }

    // Getters e Setters
    public int getDimensioni() {
        return dimensioni;
    }

    public void setDimensioni(int dimensioni) {
        this.dimensioni = dimensioni;
    }

    public boolean isIssmartTV() {
        return IssmartTV;
    }

    public void setIssmartTV(boolean issmartTV) {
        this.IssmartTV = issmartTV;
    }
    
// OVERRIDE
    @Override
    public BigDecimal calcolaPrezzoFedelta() {
        // Determina la percentuale di sconto in base alla memoria
        BigDecimal percentualeSconto = !IssmartTV ? new BigDecimal("0.10") : new BigDecimal("0.02");
            return calcolaPrezzoScontato(true, percentualeSconto);
    }

    @Override
    public String toString() {
        String base = super.toString(true); 
        // Sostituisce "(2%)" con "(10%)" se è una Smart TV, altrimenti mantiene "(2%)"
        String scontoInfo = !IssmartTV ? "(10%)" : "(2%)";
            return base.replace("(2%)", scontoInfo) + "\nDimensioni: " + getDimensioni() + " pollici\nSmart TV: " + 
            (isIssmartTV() ? "Disponibile" : "Non disponibile") + "\nTipo sconto applicato: " + scontoInfo;
    }
}