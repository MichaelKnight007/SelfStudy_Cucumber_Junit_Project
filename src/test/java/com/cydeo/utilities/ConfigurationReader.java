package com.cydeo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {


        // 1. Create properties object
        /*
        Make the properties object private so that it cannot be accessible
        Make it static so that it'll be created and loaded before everything else
         */
        private static Properties  properties = new Properties();

        static {



            try {

                // 2. Load the path into FileInputStream
                FileInputStream fileInputStream = new FileInputStream("configuration.properties");

                // 3. Load the file into properties object
                properties.load(fileInputStream);

                // Close the fileInputStream object to save space in the memory. Not mandatory.
                fileInputStream.close();

            } catch (IOException e) {
                System.out.println(" FILE NOT FOUND IN GIVEN PATH!!!");
                e.printStackTrace();
            }


        }


        // Create a method to use the object


    public static String getProperty(String keyword) {
        // 4. Get the value using key
            return properties.getProperty(keyword);
    }






}
