package be.jasper.domain.certificaat;

import be.jasper.controller.CertificaatIdDTO;
import be.jasper.errorhandler.CertificaatNietGevonden;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class CertificaatService {

    @Inject
    private CertificaatRepository certificaatRepository;

    public CertificaatService() {
    }

    public void updateOrder(CertificaatIdDTO certificaatIdDTO) {
        Certificaat certificaat = findCertificaatById(certificaatIdDTO.getCertificaatId());
        try{
        certificaat.setCertificaatNummer(certificaatIdDTO.getCertificaatNummer());
        certificaat.setCertificaatDatum(certificaatIdDTO.getCertificaatDatum());
        certificaat.setSpecifiekTonnage(certificaatIdDTO.getSpecifiekTonnage());
        }catch (NullPointerException e){
            throw new CertificaatNietGevonden(certificaatIdDTO.getCertificaatId());
        }
    }

    public Certificaat findCertificaatById(int certificaatId) {
            return certificaatRepository.findCertificaatById(certificaatId);
    }
}
