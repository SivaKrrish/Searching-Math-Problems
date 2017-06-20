package com.journaldev.search.dao;

import com.journaldev.search.model.Concept;
import com.journaldev.search.model.Problem;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class SearchDAOImpl implements  SearchDAO{

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public List<Problem> getSearchResultsForProblems(String searchQuery) {

        Session session = this.sessionFactory.openSession();
        Query query = session.createQuery("from Problem p where p.content like :searchQuery ");
        query.setParameter("searchQuery", "%" + searchQuery + "%");
        List<Problem> problemList = query.list();

        return problemList;
    }

    @Override
    public List<Concept> getSearchResultsForConcepts(String searchQuery) {

        Session session = this.sessionFactory.openSession();
        Query query = session.createQuery("from Concept c where c.content like :searchQuery ");
        query.setParameter("searchQuery", "%" + searchQuery + "%");
        List<Concept> conceptList = query.list();

        return conceptList;
    }

    @Override
    public Map<String, Integer> getSearchCountsForTokens(List<String> searchTokens) {

        Session session = this.sessionFactory.openSession();
        Map<String,Integer> countMap = new HashMap<String, Integer>();
        Integer problemCount = 0;
        Integer conceptCount = 0;

        for(String s : searchTokens){

            problemCount = getSearchResultsForProblems(s.trim()).size();
            conceptCount = getSearchResultsForConcepts(s.trim()).size();
            countMap.put(s.trim(),(problemCount + conceptCount));

        }

        return countMap;

    }

    @Override
    public Map<String, List<String>> getSearchResultsForSelectedTokens(String[] checkedTokens) {

        List<String> problemStringList = null;
        List<String> conceptStringList = null;
        List<String> categoryList = null;
        List<Problem> problemList = null;
        List<Concept> conceptList = null;
        Map<String,List<String>> listMap = new HashMap<String, List<String>>();

        for(String s : checkedTokens){

            problemStringList = getProblemDataByToken(s);
            conceptStringList = getConceptDataByToken(s);

            // merging two lists.

            problemStringList.addAll(conceptStringList);
            listMap.put(s,problemStringList);
        }

       return listMap;

    }


    private List<String> getProblemDataByToken(String token){

        Session session = this.sessionFactory.openSession();
        Query query = session.createQuery("SELECT p.content\n" +
                "FROM Problem p \n" +
                "WHERE p.content LIKE :token \n");
        query.setParameter("token", "%" + token + "%");

        List<String> problemList = query.list();

        return problemList;
    }

    private List<String> getConceptDataByToken(String token){

        Session session = this.sessionFactory.openSession();
        Query query = session.createQuery("SELECT c.content\n" +
                "FROM Concept c \n" +
                "WHERE c.content LIKE :token \n");
        query.setParameter("token", "%" + token + "%");

        List<String> problemList = query.list();

        return problemList;
    }
}
