package com.infobox.hasnat.to_dolist;

import java.util.Date;

/**
 * Created by hasnat on 2/27/18.
 */

public class DataTemp {

    //Define variables
    private int idTemp;
    private String titleTemp;
    private String detailsTemp;
    private Date dateTemp;


    //Constructor
    public DataTemp(String titleTemp, String detailsTemp, Date dateTemp) {
        this.titleTemp = titleTemp;
        this.detailsTemp = detailsTemp;
        this.dateTemp = dateTemp;
    }

    //Getter and Setter

    public int getIdTemp() {
        return idTemp;
    }

    public void setIdTemp(int idTemp) {
        this.idTemp = idTemp;
    }

    public String getTitleTemp() {
        return titleTemp;
    }

    public void setTitleTemp(String titleTemp) {
        this.titleTemp = titleTemp;
    }

    public String getDetailsTemp() {
        return detailsTemp;
    }

    public void setDetailsTemp(String detailsTemp) {
        this.detailsTemp = detailsTemp;
    }

    public Date getDateTemp() {
        return dateTemp;
    }

    public void setDateTemp(Date dateTemp) {
        this.dateTemp = dateTemp;
    }
}
