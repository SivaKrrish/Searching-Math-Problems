package com.journaldev.search;

import com.journaldev.search.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SearchController {

    private SearchService searchService;

    @Autowired(required=true)
    @Qualifier(value="searchService")
    public void setSearchService(SearchService ps){
        this.searchService = ps;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String searchMath(ModelMap model) {

        model.addAttribute("message", "Hello world!");
        return "search";
    }

    @RequestMapping(value = "/Search", method = RequestMethod.POST)
    public String search(ModelMap model, HttpServletRequest request) {

        String searchQuery = request.getParameter("search");
        Map<String,List<String>> dataMap = null;

        List<String> searchTokens = Arrays.asList(searchQuery.trim().split(","));

        if(searchQuery != null){
                if(searchTokens.size() == 1){
                    
                    String[] tokens = new String[1];
                    tokens[0] = searchQuery;

                    dataMap = this.searchService.getSearchResultsForSelectedTokens(tokens);
                    model.addAttribute("dataMap",dataMap);

                    return "searchResult";
                }else{

                    Map<String,Integer> countMap = this.searchService.getSearchCountsForTokens(searchTokens);
                    model.addAttribute("countMap",countMap);

                    return "searchToken";
                }
        }

        return "search";
    }

    @RequestMapping(value = "/searchSelectedTokens", method = RequestMethod.POST)
    public String searchSelectedTokens(ModelMap model, HttpServletRequest request) {

        String[] checkedTokens = request.getParameterValues("searchKeys");

        Map<String,List<String>> dataMap = null;

        if(checkedTokens.length == 0 || checkedTokens.equals(null)){

            return "search";

        }else{

            dataMap = this.searchService.getSearchResultsForSelectedTokens(checkedTokens);
            model.addAttribute("dataMap",dataMap);
            return "searchResult";
        }
    }

}
