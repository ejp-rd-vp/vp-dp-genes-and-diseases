package org.ejprarediseases.vpsearch.models.gene;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GeneMapping {
    private String hgncId;
    private String orphaCode;

}
