package be.jasper.domain.klant;

import be.jasper.controller.KlantDTO;
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

    @Test
    public void addKlant_MoetVerwijzenNaarKlantRepoAddKlantMethode() throws Exception {
        KlantDTO klantDTO = new KlantDTO(1, "Xan");
        Klant klant = new Klant("Xan");
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
