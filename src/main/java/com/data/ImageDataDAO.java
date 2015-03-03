package com.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by karthik on 1/28/15.
 */

public class ImageDataDAO {

    public static ImageDataModel getImageData(int index) {

        List<Integer> pageIDList = new ArrayList<Integer>();
        List<String> articleTitList = new ArrayList<String>();
        List<String> textDataList = new ArrayList<String>();
        int pageIndex = 0;

        try {

            ImageDataModel dataModel = new ImageDataModel();
            DatabaseHelper dbHelper = new DatabaseHelper();
            Connection connection = dbHelper.initConnectionPool();

            Statement statement = connection.createStatement();

            ResultSet result = statement
                    .executeQuery("select * from imageintegration.imagedata where imageintegration.imagedata.index = " + index);

            while (result.next()) {

                System.out.println("PageIndex is "+result.getInt("index"));
                pageIndex = result.getInt("index");

                pageIDList.add(result.getInt("pageid"));

                articleTitList.add(result.getString("articletitle"));

                textDataList.add(result.getString("textdata"));
            }

            dataModel.setIndexID(pageIndex);
            dataModel.setImgPageIdList(pageIDList);
            dataModel.setArticleTitleList(articleTitList);
            dataModel.setTextDataList(textDataList);
           // dbHelper.connectionPool.releaseConnection(connection);

            return dataModel;
        } catch (SQLException ex) {
            System.out.println("Exception at ImageDataDAO");
            ex.printStackTrace();
            return null;
        }
    }
}
