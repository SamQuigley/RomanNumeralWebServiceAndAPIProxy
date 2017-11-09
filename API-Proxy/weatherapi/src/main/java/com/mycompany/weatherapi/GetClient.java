/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.weatherapi;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 *
 * @author Matimek
 */
public class GetClient {
    public static void main(String[] args){
        try{

            String apiKey = "0b78371d138986d5217864bf2166b826";
            String city = "Dublin";
            
            String getUrl = "http://api.openweathermap.org/data/2.5/weather"; 
                    
            Client client = Client.create();
            WebResource target = client.resource(getUrl);

            ClientResponse response = target
                    .queryParam("q", city).queryParam("appid",apiKey)                    
                    .get(ClientResponse.class);
            String output = response.getEntity(String.class);
            System.out.println(output);
            
        } catch (Exception e){
            e.printStackTrace();
        }
        
    }
    
}
