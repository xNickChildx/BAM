package com.example.bam;

import java.util.ArrayList;

public class Topic {
    ArrayList<Article> articles;
    ArrayList<String> title;
    public Topic(Article a){
        articles=new ArrayList<Article>();
        articles.add(a);

        title=new ArrayList<>();
        setTitle();

    }
    void add(Article c){
        articles.add(c);
        setTitle();
    }
    void setTitle(){
        if(articles.size()==1){
            title=articles.get(0).hotTerms;
            return;
        }
        else {
            for(int i=0;i<articles.size();i++){
                for(String word:title)
                for(String word2: articles.get(i).hotTerms){

                }
            }
        }
    }
}
