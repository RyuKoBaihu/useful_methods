package Conversor;

import org.json.JSONObject;
import org.json.XML;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

public class CreateFileJSONfromXMLConverter {

    public static void FileJSONfromXMLConverter() {
        try {
            File xmlFile = new File("src/main/resources/xmlexample.xml");
            StringBuilder xmlContent = new StringBuilder();
            BufferedReader reader = new BufferedReader(new FileReader(xmlFile));
            String line;
            while ((line = reader.readLine()) != null) {
                xmlContent.append(line);
            }
            reader.close();


            JSONObject jsonObject = XML.toJSONObject(xmlContent.toString());


            String jsonFilePath = "src/main/resources/convertedToJSON.json"; // Caminho do arquivo JSON
            try (FileWriter file = new FileWriter(jsonFilePath)) {
                file.write(jsonObject.toString(4));  // 4 espaços de indentação para formatação
                System.out.println("XML converted to JSON: " + jsonFilePath);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
