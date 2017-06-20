package com.journaldev.search.service;

import com.journaldev.search.model.Concept;
import com.journaldev.search.model.Problem;

import java.util.List;
import java.util.Map;

public interface SearchService {


    List<Problem> getSearchResultsForProblems(String searchQuery);
    List<Concept> getSearchResultsForConcepts(String searchQuery);

    Map<String,Integer> getSearchCountsForTokens(List<String> searchTokens);

    Map<String,List<String>> getSearchResultsForSelectedTokens(String[] checkedTokens);

}
