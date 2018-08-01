package com.example.kmj.webtoon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    TextView maintext;
    String URL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        maintext=findViewById(R.id.main_text);
        Thread thread=new Thread(){

            @Override
            public void run() {
                try {
                    Document page =Jsoup.connect("https://comic.naver.com/webtoon/weekday.nhn").get();
                    for (int i=0; i<page.getElementsByClass("col_inner").size(); i++){
                        for(int j=0; j<page.getElementsByClass("col_inner").get(i).getElementsByClass("thumb").size(); j++){

                            Log.e(page.getElementsByClass("col_inner").get(i).getElementsByClass("thumb").get(j).getElementsByTag("img").get(0).attr("title"),page.getElementsByClass("col_inner").get(i).getElementsByClass("thumb").get(j).getElementsByTag("img").get(0).attr("src"));
                        }
                        Log.e(String.valueOf(i),String.valueOf(i));

                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }
}
