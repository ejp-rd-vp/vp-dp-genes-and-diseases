package org.ejprarediseases.vpsearch.services;

import jakarta.transaction.Transactional;
import org.ejprarediseases.vpsearch.models.gene.GeneMapping;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class GenesService {

    @Transactional
    public GeneMapping getGeneMapping(String hgncId) {
        WebClient webClient = WebClient.create("http://155.133.131.171:8080/GENES/gendis/find?by=hgnc&input=" + hgncId);
        String response = webClient.get().retrieve().bodyToMono(String.class).block();
        String orphaCode;
        try {
            orphaCode = response.substring(
                    response.indexOf("Orphanet_") + 9,
                    response.indexOf("\",\"label\":"));
    } catch (Exception e) {
      orphaCode = null;
    }
    return new GeneMapping(hgncId, orphaCode);
    }
}
