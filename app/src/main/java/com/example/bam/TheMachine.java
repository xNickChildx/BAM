package com.example.bam;

import android.widget.LinearLayout;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


public class TheMachine {
    Site ESPN;
    Site CBS;
    Site YAHOO;
    Site FOX;
    ArrayList<Site> sites;
    ArrayList<Topic>topics;
        public TheMachine(String topic){
        if (topic=="sports"){
            ESPN= new Site("https://www.espn.com/espn/rss/news");
            CBS= new Site("https://rss.cbssports.com/rss/headlines/");
            YAHOO=new Site("https://sports.yahoo.com/mlb/teams/bos/rss/?shangrila=1");
            FOX=new Site("https://api.foxsports.com/v1/rss?partnerKey=zBaFxRyGKCfxBagJG9b8pqLyndmvo7UU");
            System.out.println("DONE MAKING SITES, STARTING TO COMPARE");
            sites=new ArrayList<>(Arrays.asList(ESPN,CBS,YAHOO,FOX));

            compare();

            System.out.println("DONE");
        }
        }
   public void compare(){
            topics=new ArrayList<>();
            Topic temp;

       topics.add(new Topic(sites.get(0).links.get(0)));
            for(int s=0;s<sites.size();s++){
                    for(Article a:sites.get(s).links) {
                        boolean isIn=false;
                     for( int i=0;i<topics.size();i++){

                          for( int n=0;n<topics.get(i).articles.size();n++) {
                              Article a2 = topics.get(i).articles.get(n);
                              int count = 0;
                              ArrayList words = new ArrayList<String>();

                              for (String term : a.hotTerms) {

                                  for (String term2 : a2.hotTerms) {
                                      if (term.equalsIgnoreCase(term2)) {
                                          words.add(term);
                                          count++;
                                      }
                                  }
                              }
                                if(!a.equals(a2) && !topics.get(i).articles.contains(a)) {
                                    if (count >= 2) {
                                        System.out.println("MATCH: " + i + " , " + n + "  " + a.title + "AND  " + a2.title);
                                        System.out.println(words + "   " + a.hotTerms + "    " + a2.hotTerms);
                                        topics.get(i).add(a);
                                        isIn = true;
                                    }
                                }


                          }
                        }
                     if(!isIn){
                         System.out.println("ADDING "+ a.title + "      " +topics.size());
                                 topics.add(new Topic(a));
                     }

                    }
            }
   }


}
