package be.jasper.domain.certificaat;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by xanv on 11/05/2017.
 */
public class CertificaatTest {
    private Certificaat certificaat;

    @Before
    public void setUp() throws Exception {
        certificaat = new CertificaatTestBuilder().build();
    }

    @Test
    public void testCertificaatGetters() throws Exception {
        Assertions.assertThat(certificaat.getCertificaatDatum()).isEqualTo("17/08/1992");
        Assertions.assertThat(certificaat.getCertificaatNummer()).isEqualTo("205");
        Assertions.assertThat(certificaat.getSpecifiekTonnage()).isEqualTo(250);

    }
}