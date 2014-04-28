/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller.ExportGenerators;

import java.util.ArrayList;

/**
 *
 * @author Laura
 */
public class GenerateCsv {
    public static String generateCsvFile(ArrayList<String[]> temp_table)
    {
        //String output = "Email, Name\n";
        String output = ""; 
        String line =""; 
        for(int i=0; i<temp_table.get(0).length; i++){
            
                if(temp_table.get(0)[i] != null){
                    line += temp_table.get(0)[i] + ", "; 
                }
                 
        }
        line +="\n";
        output +=line; 
        for (int j = 1; j < temp_table.size(); j++) {
            line = ""; 
            //output += user.getEmail() + ", " + user.getName() + "\n";
            for(int i=0; i<temp_table.get(j).length; i++){
                if(temp_table.get(j)[i] != null){
                    line += temp_table.get(j)[i] + ", "; 
                }
            }
            
        line +="\n";
        output +=line; 
            
        }

        return output;
    }
}
