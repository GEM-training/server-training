package com.gem.nhom1.config;

import org.hibernate.SessionFactory;
import org.hibernate.search.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ContextRefreshedListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private SessionFactory sessionFactory;

    public void onApplicationEvent(ContextRefreshedEvent event) {
        try {
            Search.getFullTextSession(sessionFactory.openSession())
                    .createIndexer().startAndWait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("refreshed");
    }
}