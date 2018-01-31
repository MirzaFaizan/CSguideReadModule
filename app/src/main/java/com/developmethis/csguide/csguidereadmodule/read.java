package com.developmethis.csguide.csguidereadmodule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.io.InputStream;
import java.util.List;

public class read extends AppCompatActivity {
    List<content> quesList;
    int qid=0;
    content currentC;
    TextView txtContent;
    Button butNext, butPrev;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        Bundle b = getIntent().getExtras();
        String quizid=b.getString("Contentid");
        //getting data from csv file
        InputStream inputStream = getResources().openRawResource(R.raw.content);
        CSVcontentReader csv = new CSVcontentReader(inputStream);
        quesList = csv.read(quizid);
        currentC=quesList.get(qid);
        txtContent=(TextView)findViewById(R.id.textcontent);
        setReadContentView();

        butNext = (Button)findViewById(R.id.nextbtn);
        butPrev = (Button)findViewById(R.id.prevbtn);
        //buttons logic


        //next button logic
        butNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(qid<quesList.size()){
                    qid++;
                    currentC=quesList.get(qid);
                    setReadContentView();
                }
                else{
                    //shift to other activity
                }
                if(qid>=1){
                    butPrev.setVisibility(View.VISIBLE);
                }
            }
        });

        //previous btn logic
        butPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qid--;
                currentC=quesList.get(qid);
                setReadContentView();
                if(qid<=0){
                    butPrev.setVisibility(View.INVISIBLE);
                }
            }
        });

    }

    public void setReadContentView(){
        txtContent.setText(currentC.getActualContent());
    }
}
