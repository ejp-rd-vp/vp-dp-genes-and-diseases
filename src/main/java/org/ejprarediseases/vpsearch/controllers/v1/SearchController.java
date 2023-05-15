package org.ejprarediseases.vpsearch.controllers.v1;

import org.ejprarediseases.vpsearch.models.SearchResult;import org.ejprarediseases.vpsearch.services.SearchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.ejprarediseases.vpsearch.controllers.v1.ApiVersion.API_VERSION;

@RestController
@RequestMapping(API_VERSION + "/autocomplete")
public class SearchController {

    final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping()
    public ResponseEntity executeSearch(
            @RequestParam("query") String query,
            @RequestParam int page,
            @RequestParam int size) {
        SearchResult searchResult = searchService.getSearchResults(query, page, size);
        return new ResponseEntity<>(searchResult, HttpStatus.OK);
    }
}
