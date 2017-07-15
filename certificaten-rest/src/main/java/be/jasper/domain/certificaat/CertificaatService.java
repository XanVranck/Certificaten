package be.jasper.domain.certificaat;

import be.jasper.controller.CertificaatIdDTO;
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
        certificaat.setCertificaatNummer(certificaatIdDTO.getCertificaatNummer());
        certificaat.setCertificaatDatum(certificaatIdDTO.getCertificaatDatum());
        certificaat.setSpecifiekTonnage(certificaatIdDTO.getSpecifiekTonnage());
    }

    private Certificaat findCertificaatById(int certificaatId) {
        return certificaatRepository.findCertificaatById(certificaatId);
    }
}
