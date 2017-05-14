package be.jasper.controller;

import be.jasper.domain.klant.Klant;
import be.jasper.domain.klant.KlantService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
@RequestMapping("/klant")
@Transactional
public class KlantController {
    @Inject
    private KlantService klantService;

//    @RequestMapping(method = POST)
//        @CrossOrigin(origins = "http://localhost:4200")
//    @ResponseBody
//    public void addKlant(@RequestParam(value="naam") String naam,
//                         @RequestParam(value="straat") String straat,
//                         @RequestParam (value="nummer") String nummer,
//                         @RequestParam (value="postCode") String postCode,
//                         @RequestParam (value="stad") String stad){
//        Adres adres = new Adres(straat, nummer, postCode, stad);
//        Klant klant = new Klant(naam, adres);
//        klantService.addKlant(klant);
//    }

    @RequestMapping(method = POST)
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public void addKlant(@RequestBody Klant klant){
        klantService.addKlant(klant);
    }

    @RequestMapping(method = GET)
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public List<Klant> getKlanten(){
        return klantService.getKlanten();
    }
}
