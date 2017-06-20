package com.journaldev.search.service;

import com.journaldev.search.dao.SearchDAO;
import com.journaldev.search.model.Concept;
import com.journaldev.search.model.Problem;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SearchServiceImpl implements SearchService {

    private SearchDAO searchDAO;

    public void setSearchDAO(SearchDAO searchDAO) {
        this.searchDAO = searchDAO;
    }

    @Override
    public List<Problem> getSearchResultsForProblems(String searchQuery) {
        return this.searchDAO.getSearchResultsForProblems(searchQuery);
    }

    @Override
    public List<Concept> getSearchResultsForConcepts(String searchQuery) {
        return this.searchDAO.getSearchResultsForConcepts(searchQuery);
    }

    @Override
    public Map<String, Integer> getSearchCountsForTokens(List<String> searchTokens) {
        return this.searchDAO.getSearchCountsForTokens(searchTokens);
    }

    @Override
    public Map<String, List<String>> getSearchResultsForSelectedTokens(String[] checkedTokens) {
        return this.searchDAO.getSearchResultsForSelectedTokens(checkedTokens);
    }
}
