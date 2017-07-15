package be.jasper.controller;

import be.jasper.domain.klant.KlantService;
import be.jasper.errorhandler.KlantNietGevonden;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/klant")
@Transactional
public class KlantController {
    @Inject
    private KlantService klantService;

    @RequestMapping(method = POST)
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public void addKlant(@RequestBody KlantDTO klant){
        klantService.addKlant(klant);
    }

    @RequestMapping(method = GET)
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public List<KlantDTO> getKlanten(){
        return klantService.getKlantenDTO();
    }

    @RequestMapping(method = DELETE)
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public void deleteKlant(@RequestBody KlantDTO klantDTO) throws KlantNietGevonden{
        klantService.deleteKlant(klantDTO);
    }
}
