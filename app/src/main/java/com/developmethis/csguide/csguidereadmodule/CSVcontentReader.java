package com.developmethis.csguide.csguidereadmodule;

/**
 * Created by Faizan Ejaz on 1/31/2018.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CSVcontentReader {
    private InputStream inputStream;

    public CSVcontentReader(InputStream is) {
        this.inputStream = is;
    }

    public ArrayList<content> read(String contentid) {
        ArrayList<content> resultList = new ArrayList<content>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        try {
            String csvLine;
            while((csvLine = reader.readLine()) != null) {
                String[] tokens = csvLine.split(",");
                content c = new content();
                c.setContentID(tokens[0]);
                c.setActualContent(tokens[1]);
                resultList.add(c);


            }
        } catch(IOException ex) {
            throw new RuntimeException("Error in reading CSV file:" + ex);
        } finally {
            try{
                inputStream.close();
            } catch(IOException e) {
                throw new RuntimeException("Error while closing input stream: " + e);
            }
        }
        for (int i = 0; i<resultList.size();i++){
            if(resultList.get(i).getContentID().equals(contentid))
            {}
            else{
                resultList.remove(i);
            }
        }
        return resultList;
    }
}