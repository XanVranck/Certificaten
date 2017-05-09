package be.jasper.domain.klant;

/**
 * Created by xanv on 9/05/2017.
 */
public class Adres {
    private String straat, nummer, postCode, stad;

    public Adres(String straat, String nummer, String postCode, String stad) {
        this.straat = straat;
        this.nummer = nummer;
        this.postCode = postCode;
        this.stad = stad;
    }

    public String getStraat() {
        return straat;
    }

    public String getNummer() {
        return nummer;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getStad() {
        return stad;
    }
}
