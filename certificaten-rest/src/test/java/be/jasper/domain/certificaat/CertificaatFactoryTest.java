package be.jasper.domain.certificaat;

import be.jasper.controller.CertificaatDTO;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CertificaatFactoryTest {
    public static final String CERTIFICAAT_NUMBER = "3153";
    public static final String CERTIFICAAT_DATUM = "17/08/1992";
    public static int SPECIFIEK_TONNAGE = 200000;
    public static final int ORDER_ID = 2;

    @Test
    public void creatCertificaat() throws Exception{
        CertificaatDTO certificaatDTO = new CertificaatDTO(ORDER_ID, CERTIFICAAT_NUMBER, CERTIFICAAT_DATUM, SPECIFIEK_TONNAGE);
        Certificaat certificaat = new CertificaatFactory().createCertificaat(certificaatDTO);

        assertThat(certificaat).isEqualToComparingFieldByField(new Certificaat(CERTIFICAAT_NUMBER, CERTIFICAAT_DATUM,SPECIFIEK_TONNAGE));
    }
}
