package org.ejprarediseases.vpsearch.models;


import lombok.Data;
import org.ejprarediseases.vpsearch.models.gene.Gene;
import java.util.Set;

@Data
public class SearchResult {
  private Set<Gene> genes;
    private Set<RareDisease> rareDiseases;
}
