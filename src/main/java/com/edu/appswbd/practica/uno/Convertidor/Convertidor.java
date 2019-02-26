package com.edu.appswbd.practica.uno.Convertidor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.sun.org.apache.xerces.internal.impl.xs.XMLSchemaLoader;
import com.sun.org.apache.xerces.internal.util.XMLInputSourceAdaptor;
import com.sun.org.apache.xerces.internal.xni.parser.XMLParseException;
import jdk.internal.org.xml.sax.InputSource;
import jdk.internal.org.xml.sax.SAXException;
import jdk.nashorn.internal.parser.JSONParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.schema.JsonSchema;
import org.json.JSONObject;
import org.json.XML;
import org.w3c.dom.Document;

import java.io.IOException;

import javax.xml.XMLConstants;


public class Convertidor {


    //Metodo para convertir una clase a JSON
    //@Param clase  texto en formato clase para convertir
    //@returm clase convertida a JSON
    public String convertirClaseToJson(String clase){
    Object obj = clase;
    Gson gson = new Gson();
String ObJason="";

        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(obj);

            ObJason= gson.toJson(json);


            System.out.println("JSON = " + ObJason);


        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ObJason;
    }

    //Metodo para convertir un XML a JSON
    //@Param XML  texto en formato clase para convertir
    //@returm XML convertida a JSON
    public String convertirXmlToJson(String xml){
        int PRETTY_PRINT_INDENT_FACTOR = 4;

        String jsonPrettyPrintString="";



    JSONObject xmlJSONObj = XML.toJSONObject(xml);

    jsonPrettyPrintString = xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);







        return jsonPrettyPrintString;

    }
}
