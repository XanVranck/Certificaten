package be.jasper.domain.klant;

import be.jasper.controller.KlantDTO;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class KlantServiceTest {
    @InjectMocks
    private KlantService klantService = new KlantService();

    @Mock
    private KlantRepository klantRepositoryMock;

    @Mock
    private KlantFactory klantFactory;

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    private KlantDTO klantDTO;
    private Klant klant;

    @Before
    public void setUp() throws Exception {
        klantDTO = new KlantDTO(1, "Xan");
        klant = new Klant("Xan");
    }

    @Test
    public void addKlant_MoetVerwijzenNaarKlantRepoAddKlantMethode() throws Exception {
        when(klantFactory.createKlant(klantDTO)).thenReturn(klant);

        klantService.addKlant(klantDTO);

        verify(klantRepositoryMock).addKlant(klant);
    }

    @Test
    public void getKlanten_MoetVerwijzenNaarKlantRepoGetKlantenMethode() throws Exception {
        klantService.getKlanten();

        verify(klantRepositoryMock).getKlanten();
    }

    @Test
    public void getKlantByNaam_MoetVerwijzenNaarKlantRepoGetKlantByNaamMethode() throws Exception {
        klantService.findKlantByNaam("Xan");

        verify(klantRepositoryMock).findKlantByNaam("Xan");
    }
}
