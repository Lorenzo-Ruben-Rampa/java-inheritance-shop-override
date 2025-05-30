import java.math.BigDecimal;

public class Cuffie extends Prodotto  { 

    // Attributi
    protected String colore;
    protected boolean isWireless;

    // 1° Costruttore
    public Cuffie(int codice, String nome, String marca, BigDecimal prezzo, BigDecimal iva, String colore, boolean isWireless) {
        super(codice, nome, marca, prezzo, iva);
        this.colore = colore;
        this.isWireless = isWireless;
    }

    //Getters e Setters
    public String getColore() {
        return colore;
    }

    public void setColore(String colore) {
        this.colore = colore;
    }

    public boolean isWireless() {
        return isWireless;
    }

    public void setIsWireless(boolean isWireless) {
    this.isWireless = isWireless;
    }

// OVERRIDE
    @Override
    public BigDecimal calcolaPrezzoFedelta() {
        // Determina la percentuale di sconto in base alla memoria
        BigDecimal percentualeSconto = !isWireless ? new BigDecimal("0.07") : new BigDecimal("0.02");
            return calcolaPrezzoScontato(true, percentualeSconto);
    }

    @Override
    public String toString() {
        String base = super.toString(true);
        String scontoInfo = !isWireless ? "(7%)" : "(2%)";
            return base.replace("(2%)", scontoInfo) + "\nColore: " + getColore() + "\nWireless: " + 
            (isWireless() ? "Disponibile" : "Non disponibile" + "\nTipo sconto applicato: " + scontoInfo);
    }
}