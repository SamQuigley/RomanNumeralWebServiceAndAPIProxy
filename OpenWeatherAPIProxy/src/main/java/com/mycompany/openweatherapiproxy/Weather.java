/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.openweatherapiproxy;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import com.google.gson.Gson;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.Client;
/**
 *
 * @author samq2
 */

@Path("/weather")
public class Weather {

    @GET
    @Path("{city}")
    public String  GetWeather(@PathParam("city") String city){
            
        
        String getURL = "http://api.openweathermap.org/data/2.5/weather?q="+city+"&APPID=d2f18a0d89c3553cc8c0adf70fac6f18";
        
        Client client = Client.create();
        WebResource target = client.resource(getURL);
        ClientResponse response = target.get(ClientResponse.class);
        
       String output = response.getEntity(String.class);
       return output;
    }

}
