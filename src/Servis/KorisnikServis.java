package Servis;

import Database.Konekcija;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;

public class KorisnikServis {

    // tabela u bazi u kojoj stoje ljudi
    private MongoCollection<Document> korisnici;

    public KorisnikServis() {
        // spaja sa bazom
        // konekcija uzima bazu i dobijamo korisnike
        this.korisnici = Konekcija.uzmiBazu().getCollection("korisnici");
    }

    // Metoda za reg
    public boolean registracija(String ime, String lozinka) {
        // Prvo projeri da li vec postoji taj korisnik u bazi
        Document nadjen = korisnici.find(Filters.eq("username", ime)).first();

        if (nadjen != null) {
            // Ako smo ga ima znaci da je ime zauzeto
            return false;
        }

        // Ako nije zauzet napravi novi dokumnt i upiši podatke
        Document novi = new Document("username", ime)
                .append("password", lozinka);

        korisnici.insertOne(novi); // Ubacivanje u bazu
        return true;
    }

    // login metoda
    public boolean login(String ime, String lozinka) {
        // Tražimo korinika po imenu
        Document korisnik = korisnici.find(Filters.eq("username", ime)).first();

        if (korisnik != null) {
            // Ako postoji provjer da li je lozinka ista
            String passIzBaze = korisnik.getString("password");
            if (passIzBaze.equals(lozinka)) {
                return true; // Sve OK
            }
        }


        return false;
    }
}