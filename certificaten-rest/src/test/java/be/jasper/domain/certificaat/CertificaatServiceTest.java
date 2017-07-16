package be.jasper.domain.certificaat;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.verify;

public class CertificaatServiceTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private CertificaatService certificaatService;

    @Mock
    private CertificaatRepository certificaatRepositoryMock;

    @Test
    public void findOrderById_MoetVerwijzenNaarRepo(){
        certificaatService.findCertificaatById(1);

        verify(certificaatRepositoryMock).findCertificaatById(1);
    }
}