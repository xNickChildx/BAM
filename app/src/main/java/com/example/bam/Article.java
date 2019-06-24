package com.example.bam;

import java.util.ArrayList;
import java.util.Arrays;

public class Article {
    String title;
    String url;
    ArrayList<String> hotTerms;
        public Article(){
            title="NOTSET";
            url="NOTSET";


        }
        void setTitle(String t){
            title=t;
        }
        void setUrl(String u){
            url=u;
        }
        void setHotTerms(String d){
            hotTerms=new ArrayList<String>();
            String[] arr1=d.split(" ");
            String[] arr2=title.split(" ");
            for(String s:arr1){
                if(s.length()>0 && Character.isUpperCase(s.charAt(0))&& !hotTerms.contains(s) && !s.equalsIgnoreCase("the"))hotTerms.add(s);
            }
            for(String s:arr2)
                if(s.length()>0 && Character.isUpperCase(s.charAt(0))&& !hotTerms.contains(s)&& !s.equalsIgnoreCase("the"))hotTerms.add(s);
        }
}
