/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.numeralconverter;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/converter")
public class ConverterService {

    @GET
    @Path("/ServiceWelcome")
    public Response Welcome(@PathParam("ServiceWelcome") String hello) {
        String output = hello + " welcome to our roman numeral conversion service";
        return Response.status(200).entity(output).build();
    }

    @GET
    @Path("/romanNumeral")
    public Response convertToRoman(@PathParam("romanNumeral") int num) {
        NumberToRoman romanConverter = new NumberToRoman();
        String romanNumeral = romanConverter.toRoman(num);
        String converterOutput = num + " Converted to Roman Numerals is -> " + romanNumeral;
        return Response.status(200).entity(converterOutput).build();
    }
    
    
    /*
    Roman to number get request will go here
    */
    
    
    

}
