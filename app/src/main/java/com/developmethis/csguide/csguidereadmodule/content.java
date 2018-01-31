package com.developmethis.csguide.csguidereadmodule;

/**
 * Created by Faizan Ejaz on 1/31/2018.
 */

public class content {

    private String contentID;
    private String actualContent;

    public content(){
        contentID="";
        actualContent="";
    }

    public content(String id, String contentt){
        this.contentID=id;
        this.actualContent=contentt;
    }

    public String getContentID() {
        return contentID;
    }

    public void setContentID(String contentID) {
        this.contentID = contentID;
    }

    public String getActualContent() {
        return actualContent;
    }

    public void setActualContent(String actualContent) {
        this.actualContent = actualContent;
    }


}
