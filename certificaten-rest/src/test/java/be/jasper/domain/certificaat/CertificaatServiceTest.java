package be.jasper.domain.certificaat;

import be.jasper.domain.order.OrderRepository;
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

    @Mock
    private OrderRepository orderRepositoryMock;

    @Mock
    private CertificaatFactory certificaatFactory;

    @Test
    public void getCertificaten() throws Exception{
        certificaatService.getCertificaten();
        verify(certificaatRepositoryMock).getCertificaten();
    }
}
