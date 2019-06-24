package com.example.bam;

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Site {
    ArrayList<Article> links;
    public Site(final String s){
        links= new ArrayList<>();
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try  {
                    System.out.println("Starting PArser!!!!");
                    XmlPullParser reader= Xml.newPullParser();
                    InputStream stream= ((new URL(s)).openConnection()).getInputStream();
                    System.out.println("CONNECTION OPENED");
                    reader.setInput(stream,null);
                    int eventType=0;
                    Article i=null;
                    while(eventType!=XmlPullParser.END_DOCUMENT){
                        if(eventType==XmlPullParser.START_TAG){
                            String words=reader.getName();

                            if(words.equalsIgnoreCase("item")){
                              if (i!=null){
                                links.add(i);}
                                i=new Article();

                            }
                            else if(i!=null){

                                if(words.equalsIgnoreCase("title")){i.setTitle(reader.nextText().trim());}
                                else if(words.equalsIgnoreCase("description")){i.setHotTerms(reader.nextText().trim());}
                                else if (words.equalsIgnoreCase("link")){i.setUrl(reader.nextText());}

                            }





                        }

                        eventType=reader.next();



                    }
                    if(i!=null) {
                        System.out.println("ADDONG LAST "+ i.title);
                        links.add(i);
                    }
                    System.out.println("        Printing Items gathered from:   "+ s);
                    System.out.println("        WITH SIZE :  "+links.size());
                    for(Article p:links){
                       System.out.println(p.title + "   "+p.url + "   "+ p.hotTerms);
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("DONE FUCKING SHITS");

    }

}
