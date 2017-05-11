package be.jasper.controller;

import be.jasper.domain.certificaat.Certificaat;
import be.jasper.domain.certificaat.CertificaatService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Controller
@RequestMapping("/certificaat")
@Transactional
public class CertificaatController {
    @Inject
    private CertificaatService certificaatService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public void addCertificaat(@RequestParam (value = "certificaatNummer") String certificaatNummer,
                               @RequestParam (value = "certificaatDatum") String certificaatDatum,
                               @RequestParam (value = "specifiekTonnage") int specifiekTonnage,
                               @RequestParam (value = "orderID") int orderID){
        CertificaatDTO certificaat = new CertificaatDTO(certificaatNummer, certificaatDatum, specifiekTonnage, orderID);
        certificaatService.addCertificaat(certificaat);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Certificaat> getCertificaten(){
        return certificaatService.getCertificates();
    }


}
