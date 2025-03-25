package Conversor;

import org.json.JSONObject;
import org.json.XML;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class XMLToJSONConverter {

    public static void XMLConversion() {
        try {
            // Read XML file
            File xmlFile = new File("src/main/resources/xmlexample.xml");
            StringBuilder xmlContent = new StringBuilder();
            BufferedReader reader = new BufferedReader(new FileReader(xmlFile));
            String line;
            while ((line = reader.readLine()) != null) {
                xmlContent.append(line);
            }
            reader.close();

            // Convert XML to JSON
            JSONObject jsonObject = XML.toJSONObject(xmlContent.toString());

            // Output the result as a JSON string
            System.out.println(jsonObject.toString(4)); // Pretty print with indentation of 4 spaces

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
