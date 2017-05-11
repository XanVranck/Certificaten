package be.jasper.domain.certificaat;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Matchers.refEq;
import static org.mockito.Mockito.verify;

public class CertificaatServiceTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private CertificaatService certificaatService;

    @Mock
    private CertificaatRepository certificaatRepository;

    @Test
    public void addCustomer() throws Exception {
        Certificaat certificaat=new Certificaat("50", "1",50000);
        certificaatRepository.addCertificate(certificaat);
        verify(certificaatRepository).addCertificate(refEq(certificaat));
    }


    @Test
    public void getCustomers() throws Exception{
        certificaatService.getCertificates();
        verify(certificaatRepository).getCertificats();
    }
}
