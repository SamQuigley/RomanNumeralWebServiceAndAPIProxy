/*
 * To change this license header, choose License Headers in Project Properties.
 /**
 *
 * @author Sam Quigley, 14474028
 * reference - computing support - web service and api support class
 * Repo - https://github.com/SamQuigley/WebServiceAndAPI
 */

package com.mycompany.OpenWeatherAPIProxy;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public class Client {
    
    private String baseURL = "localhost";
    private int port = 8080;

    private String buildURL(String relativePath) {
        return "http://"+baseURL+":"+port+relativePath;
    }

    public Client(String baseURL, int port){
        this.baseURL = baseURL;
        this.port = port;
    }
    
    public HttpResponse getRequest(String relativePath){
        try {

            String fullPath = buildURL(relativePath);
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet getRequest = new HttpGet(fullPath);
            getRequest.addHeader("accept", "application/json");
            HttpResponse response = httpClient.execute(getRequest);
            httpClient.getConnectionManager().shutdown();

            return response;
      } catch (IOException e) {
            e.printStackTrace();
      }
        return null;
    }
   
    public HttpResponse postRequest(String relativePath, Map<String, String> map){
        try {

            String fullPath = buildURL(relativePath);
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost getRequest = new HttpPost(fullPath);
            Gson gson = new Gson();
            String postEntity = gson.toJson(map);
            getRequest.setEntity(new StringEntity(postEntity));
            getRequest.addHeader("accept", "application/json");
            HttpResponse response = httpClient.execute(getRequest);
            httpClient.getConnectionManager().shutdown();
            return response;
      } catch (IOException e) {
            e.printStackTrace();
      }
        return null;
    }
           
    public void printResponse(HttpResponse response) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
        String output;
        System.out.println("Output from Server ....");
        while ((output = br.readLine()) != null) {
                System.out.println(output);
        }
    }

    public static void main(String[] args) throws IOException {
	  Client client = new Client("localhost", 8080);       
          // GET
          HttpResponse getResponseW = client.getRequest("/api/weather/{city}");
          client.printResponse(getResponseW);
           // GET
          HttpResponse getResponseF = client.getRequest("/api/forecast/{city}");
          client.printResponse(getResponseF);
          
    }
}
