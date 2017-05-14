package be.jasper.domain.klant;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.verify;

public class KlantServiceTest {
    @InjectMocks
    private KlantService klantService = new KlantService();

    @Mock
    private KlantRepository klantRepositoryMock;

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Test
    public void addKlant_MoetVerwijzenNaarKlantRepoAddKlantMethode() throws Exception {
        Klant klant = new Klant("Xan", "Schoolstraat", "78", "1745", "Opwijk");

        klantService.addKlant(klant);

        verify(klantRepositoryMock).addKlant(klant);
    }

    @Test
    public void getKlanten_MoetVerwijzenNaarKlantRepoGetKlantenMethode() throws Exception {
        klantService.getKlanten();

        verify(klantRepositoryMock).getKlanten();

    }
}
