/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;



public class ErrorMessage 
{
    public ArrayList<String> errorMessage = new ArrayList<String>();
    
    public ErrorMessage()
    {
        //0
        errorMessage.add("Error, Invalid data type");
        //1
        errorMessage.add("Zoom out of authorized range");
        //2 
        errorMessage.add("Satellite disabled");
        //3 
        errorMessage.add("Satellite enabled");
        //4
        errorMessage.add("Rotation enabled");
        //5
        errorMessage.add("Rotation disabled");
    }
}
