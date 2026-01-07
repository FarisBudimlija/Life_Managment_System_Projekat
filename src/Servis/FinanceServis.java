package Servis;

import Database.Konekcija;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;

public class FinanceServis {
    private MongoCollection<Document> finansije;

    public FinanceServis() {
        // spajam se na novu kolekciju koja se zove "finansije"
        this.finansije = Konekcija.uzmiBazu().getCollection("finansije");
    }

    // Metoda da spasi trosak u bazu
    public void dodajTrosak(String stavka, String iznos) {
        Document noviTrosak = new Document("opis", stavka)
                .append("cijena", iznos)
                .append("datum", new java.util.Date().toString()); // da znamo kad smo potrosili

        finansije.insertOne(noviTrosak);
        System.out.println("Spremljeno u bazu: " + stavka);
    }
}