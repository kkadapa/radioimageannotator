package com.imageview;

import com.data.ImageDataModel;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.jersey.api.view.Viewable;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

/**
 * Radiology Case Reports Controller Class!
 *
 */
@Path("/hello")
public class App 
{
//    @GET
//    @Path("{name}")
//    public String sayHello(@PathParam("name") String name){
//        StringBuilder stringBuilder = new StringBuilder("This is karthik | Hello ");
//        stringBuilder.append(name).append("!");
//        getDataForDisplay();
//        return stringBuilder.toString();
//    }

    @GET
    @Path("/index")
    public Viewable index(
            @Context HttpServletRequest request,
            @Context HttpServletResponse response) throws Exception
    {
        request.setAttribute("key", "value");
        return new Viewable("/jsps/HelloWorld.html", null);
    }

    @POST
    @Path("/pagination")
    public String paginationCall(String incomingData) {

        String stringData = null;
        JsonObject jsonObject = (JsonObject)new JsonParser().parse(incomingData);

        System.out.println("curindex "+jsonObject.get("x"));
        System.out.println("next or prev is "+jsonObject.get("y"));

        ImageDataModel datModel = new ImageDataModel();

        //Next Value
        if(jsonObject.get("y").toString().equals(String.valueOf(1))){
            datModel = DataRetrieveHelper.getDataFromDatabase(Integer.valueOf(jsonObject.get("x").toString())+1);
        }
        //Prev Value
        if(jsonObject.get("y").toString().equals(String.valueOf(0))){
            datModel = DataRetrieveHelper.getDataFromDatabase(Integer.valueOf(jsonObject.get("x").toString())-1);
        }

        Gson gson = new Gson();
        stringData = gson.toJson(datModel);
        return stringData;
    }

    @GET
    @Path("/title")
    @Produces("application/json")
    public String getDataForDisplay() {

        String title = null;

        //First time login show first page index values
        int index = 1;
        ImageDataModel datModel = DataRetrieveHelper.getDataFromDatabase(index);

        Gson gson = new Gson();

        title = gson.toJson(datModel);

        System.out.println("App Json Data");
        return title;
    }
}
