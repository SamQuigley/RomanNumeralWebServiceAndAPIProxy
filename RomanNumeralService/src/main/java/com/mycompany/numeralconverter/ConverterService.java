/**
 *
 * @author Sam Quigley, 14474028
 * Repo - https://github.com/SamQuigley/WebServiceAndAPI
 */
package com.mycompany.numeralconverter;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

//sets the path after localhost:8080/api
@Path("/converter")
public class ConverterService {
    
    //get request to RomanToNumber.java
    //if the user adds /arabic/{number} it will call this funcation and pass the number as a parameter 
    @GET   
    @Path("/arabic/{romanNumeral}")
    public Response convertToArabic(@PathParam("romanNumeral") String roman){
        RomanToNumber romanConverter = new RomanToNumber(); //insatnce of class
        int arabicNumeral = romanConverter.romanToNumber(roman); // pass in paramter and store it in a variable
        String converterOutput = roman + " Converted to Aarabic Numerals is -> " + arabicNumeral; // output result to user
        return Response.status(200).entity(converterOutput).build(); // send HTTP 200 OK STAT US
    }
    
    @GET
    @Path("/roman/{arabicNumeral}")
    public Response convertToRoman(@PathParam("arabicNumeral") int num) {
        NumberToRoman romanConverter = new NumberToRoman();
        String romanNumeral = romanConverter.NumberToRoman(num);
        String converterOutput = num + " Converted to Roman Numerals is -> " + romanNumeral;
        return Response.status(200).entity(converterOutput).build();
    }
    
    
   
    
    
   
    

}
