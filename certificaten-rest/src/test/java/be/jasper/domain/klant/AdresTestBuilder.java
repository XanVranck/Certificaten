package be.jasper.domain.klant;

/**
 * Created by xanv on 9/05/2017.
 */
public class AdresTestBuilder {
    private String straat, nummer, postCode, stad;

    public AdresTestBuilder() {
        straat = "Schoolstraat";
        nummer = "78";
        postCode = "1745";
        stad = "Opwijk";
    }

    private static AdresTestBuilder builder() {
        return new AdresTestBuilder();
    }

    public AdresTestBuilder withStraat(String straat) {
        this.straat = straat;
        return this;
    }

    public AdresTestBuilder withNummer(String nummer) {
        this.nummer = nummer;
        return this;
    }

    public AdresTestBuilder withPostCode(String postCode) {
        this.postCode = postCode;
        return this;
    }

    public AdresTestBuilder withStad(String stad) {
        this.stad = stad;
        return this;
    }

    public Adres build() {
        return new Adres(straat, nummer, postCode, stad);
    }
}
