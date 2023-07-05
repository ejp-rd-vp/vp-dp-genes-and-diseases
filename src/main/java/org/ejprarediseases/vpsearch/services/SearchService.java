package org.ejprarediseases.vpsearch.services;

import jakarta.transaction.Transactional;
import org.ejprarediseases.vpsearch.models.gene.Gene;
import org.ejprarediseases.vpsearch.models.RareDisease;
import org.ejprarediseases.vpsearch.models.SearchResult;
import org.ejprarediseases.vpsearch.repositories.GeneRepository;
import org.ejprarediseases.vpsearch.repositories.RareDiseaseRepository;import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class SearchService {

    final GeneRepository geneRepository;
    final RareDiseaseRepository diseaseRepository;

    public SearchService(GeneRepository geneRepository, RareDiseaseRepository diseaseRepository) {
        this.geneRepository = geneRepository;
        this.diseaseRepository = diseaseRepository;
    }
    @Transactional
    public SearchResult getSearchResults(String query, int page, int size) {
        SearchResult searchResult = new SearchResult();
        searchResult.setGenes(getGenesSearchResults(query, page, size));
        searchResult.setRareDiseases(getDiseasesSearchResults(query, page, size));
        return searchResult;
    }

    @Transactional
    private Set<Gene> getGenesSearchResults(String query, int page, int size) {
        Set<Gene> genes = new HashSet<>();
        genes.addAll(geneRepository.findByHgncIdEqualsIgnoreCase(query, PageRequest.of(0, 1)));
        genes.addAll(geneRepository.findByOmimIdEqualsIgnoreCase(query, PageRequest.of(0, 1)));
        genes.addAll(geneRepository.findBySymbolEqualsIgnoreCase(query, PageRequest.of(0, 1)));
        if (genes.size() < 1) {
            if (query.matches("[0-9]+")) {
                genes.addAll(
                        geneRepository.findByHgncIdIgnoreCaseContaining(query, PageRequest.of(page, size)));
                genes.addAll(geneRepository.findByOmimIdIgnoreCaseContaining(query, PageRequest.of(page, size)));
            } else {
                genes.addAll(geneRepository.findByAliasNamesIgnoreCaseContaining(query, PageRequest.of(page, size)));
                genes.addAll(geneRepository.findByAliasSymbolsIgnoreCaseContaining(query, PageRequest.of(page, size)));
                genes.addAll(geneRepository.findByNameIgnoreCaseContaining(query, PageRequest.of(page, size)));
                genes.addAll(geneRepository.findByPreviousSymbolsIgnoreCaseContaining(query, PageRequest.of(page, size)));
                genes.addAll(geneRepository.findBySymbolIgnoreCaseContaining(query, PageRequest.of(page, size)));
            }
        }
        return genes;
    }
    @Transactional
    private Set<RareDisease> getDiseasesSearchResults(String query, int page, int size) {
        Set<RareDisease> rareDiseases = new HashSet<>();
        rareDiseases.addAll(diseaseRepository.findByOrphaCodeEqualsIgnoreCase(query, PageRequest.of(0, 1)));
        if (rareDiseases.size() < 1) {
            if (query.matches("[0-9]+")) {
                rareDiseases.addAll(diseaseRepository.findByOrphaCodeContainingIgnoreCase(query, PageRequest.of(page, size)));
            } else {
                rareDiseases.addAll(diseaseRepository.findByNameContainingIgnoreCase(query, PageRequest.of(page, size)));
                rareDiseases.addAll(diseaseRepository.findBySynonymsContainingIgnoreCase(query, PageRequest.of(page, size)));
            }
            rareDiseases.addAll(diseaseRepository.findByCodesContainingIgnoreCase(query, PageRequest.of(page, size)));
        }
        return rareDiseases;
    }
}
