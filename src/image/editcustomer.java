package image;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class editcustomer
{  
    static void modifyFile(String filePath, String oldString, String newString)
    {
        File fileToBeModified = new File("Test.txt");
        System.out.println("enter your old password: ");
        String oldContent = "";
         
        BufferedReader reader = null;
         
        FileWriter writer = null;
         
        try
        {
            reader = new BufferedReader(new FileReader(fileToBeModified));
             
            //Reading all the lines of input text file into oldContent
             
            String line = reader.readLine();
             int i=1;
            while (line != null)
            {
            	if(i==3)
            		break;
                oldContent = oldContent + line + System.lineSeparator();
               
                 
                line = reader.readLine();
                i++;
            }
             
            //Replacing oldString with newString in the oldContent
             
            String newContent = oldContent.replaceAll(oldString, newString);
             
            //Rewriting the input text file with newContent
             
            writer = new FileWriter(fileToBeModified);
             
            writer.write(newContent);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                //Closing the resources
                 
                reader.close();
                 
                writer.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
     
    public static void main(String[] args)
    {
        Scanner num = new Scanner(System.in);
        System.out.println("Enter the the String  ");
        String a = num.nextLine();
        System.out.println("New String: ");
        String b = num.nextLine();
        modifyFile("Test.txt", a,b);
         
        System.out.println("done");
    }
}
