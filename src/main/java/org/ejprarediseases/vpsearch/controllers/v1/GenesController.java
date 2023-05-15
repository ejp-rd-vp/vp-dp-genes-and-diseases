package org.ejprarediseases.vpsearch.controllers.v1;

import org.ejprarediseases.vpsearch.services.GenesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.ejprarediseases.vpsearch.controllers.v1.ApiVersion.API_VERSION;

@RestController
@RequestMapping(API_VERSION + "/genes")
public class GenesController {

  GenesService genesService;

  public GenesController(GenesService genesService) {
    this.genesService = genesService;
  }

  @GetMapping("/{hgncId}/mapping")
  public ResponseEntity getMapping(@PathVariable String hgncId) {
    return new ResponseEntity<>(genesService.getGeneMapping(hgncId), HttpStatus.OK);
    }
}
