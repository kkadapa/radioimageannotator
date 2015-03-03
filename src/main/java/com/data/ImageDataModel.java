package com.data;


import java.util.List;
/**
 * Created by karthik on 1/28/15.
 */

    public class ImageDataModel {

    private int indexID;
    private List<Integer> imgPageIdList;
    private List<String> articleTitleList;
    private List<String> textDataList;
    private List<String> imgJPGList;


    public int getIndexID() {
        return indexID;
    }

    public void setIndexID(int indexID) {
        this.indexID = indexID;
    }

    public List<String> getImgJPGList() {
        return imgJPGList;
    }

    public void setImgJPGList(List<String> imgJPGList) {
        this.imgJPGList = imgJPGList;
    }

    public List<String> getTextDataList() {
        return textDataList;
    }

    public void setTextDataList(List<String> textDataList) {
        this.textDataList = textDataList;
    }

    public List<String> getArticleTitleList() {
        return articleTitleList;
    }

    public void setArticleTitleList(List<String> articleTitleList) {
        this.articleTitleList = articleTitleList;
    }

    public List<Integer> getImgPageIdList() {
        return imgPageIdList;
    }

    public void setImgPageIdList(List<Integer> imgPageIdList) {
        this.imgPageIdList = imgPageIdList;
    }

    }
