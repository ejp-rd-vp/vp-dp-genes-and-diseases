package org.ejprarediseases.vpsearch.services;

import jakarta.transaction.Transactional;
import org.ejprarediseases.vpsearch.models.gene.GeneMapping;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class GenesService {

    @Transactional
    public GeneMapping getGeneMapping(String hgncId) {
        WebClient webClient = WebClient.create("http://155.133.131.171:8080/GENES/gendis/find?by=hgnc&input=" + hgncId);
        String response = webClient.get().retrieve().bodyToMono(String.class).block();
        List<String> orphaCodes = new ArrayList<>();
        try {
            Pattern p = Pattern.compile("Orphanet_(\\d*)");
            Matcher m = p.matcher(response);
            while (m.find()) {
                orphaCodes.add("Orphanet_" + m.group(1));
            }
        } catch (Exception e) {
            // TODO handle exception
//          orphaCodes = new ArrayList<>();
        }
        return new GeneMapping(hgncId, orphaCodes);
    }
}
