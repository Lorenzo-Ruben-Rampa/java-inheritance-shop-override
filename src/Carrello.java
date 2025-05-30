import java.math.BigDecimal;
import java.util.Scanner;

public class Carrello {
    public static void main(String[] args) {
        Prodotto [] products = new Prodotto[1];
        Scanner input = new Scanner(System.in);

        // Aggiungi la domanda per la tessera fedeltà
        System.out.println("\nIl cliente ha la tessera Fidaty? (true/false): ");
        boolean haTesseraFidaty = input.nextBoolean();
        input.nextLine(); // Consuma il newline

        for (int i = 0; i < products.length; i++) {
            System.out.println("Inserisci il codice del prodotto: ");
            int codice = input.nextInt();
            input.nextLine();
            System.out.println("Inserisci il nome del prodotto: ");
            String nome = input.nextLine();
            System.out.println("Inserisci la marca del prodotto: ");
            String marca = input.nextLine();
            System.out.println("Inserisci il prezzo del prodotto: ");
            BigDecimal prezzo = input.nextBigDecimal();
            input.nextLine();

        System.out.println("Indicare la tipologia di prodotto da inserire nel carrello (Smartphone, Televisore, Cuffie): ");
        String productCategoryString =  input.nextLine();
        System.out.println(productCategoryString);

        switch (productCategoryString.toLowerCase()) {
            case "tv":
                System.out.println("Inserisci le dimensioni del televisore in pollici: ");
                int dimensioni = input.nextInt();
                System.out.println("Il televisore è Smart TV? (true/false): ");
                boolean isSmartTV = input.nextBoolean();
                Televisore tv = new Televisore(codice, nome, marca, prezzo, new BigDecimal("0.22"), dimensioni, isSmartTV);
                input.nextLine();
                products[i] = tv;
                break;

            case "smartphone":
                System.out.println("Inserisci la memoria RAM del telefono (es. 4 GB): ");
                int memoriaRam = input.nextInt();
                input.nextLine(); 
                Smartphone smartphone = new Smartphone(codice, nome, marca, prezzo, new BigDecimal("0.22"), memoriaRam);
                products[i] = smartphone;
                break;
     
            case "cuffie":
                System.out.println("Inserisci il colore delle cuffie: ");
                String colore = input.nextLine();
                System.out.println("Le cuffie sono wireless? (true/false): ");
                boolean isWireless = input.nextBoolean();
                Cuffie cuffie = new Cuffie(codice, nome, marca, prezzo, new BigDecimal("0.22"), colore, isWireless);
                input.nextLine();
                products[i] = cuffie;
                break;
            }
        // System.out.println("Prodotto inserito: " + .toString());
        System.out.println("---------------------------");
        }
        input.close();

        System.out.println("Ecco il tuo Carrello: ");

        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                    if (haTesseraFidaty) {
                        // Se ha la tessera, mostra il prezzo scontato
                        System.out.println(products[i].toString()); // toString() già mostra entrambi i prezzi
                        // Oppure in alternativa:
                        System.out.println("Prezzo scontato (2%): " +  products[i].calcolaPrezzoScontato(true, new BigDecimal("0.02")) + " euro");
                    } else {
                        // Se non ha la tessera, mostra solo il prezzo normale
                        System.out.println(products[i].toString());
                    }
            }
        }
    }
}