package com.example.xmlexample;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class XMLService {

    Document  document;
    LocalDate today = LocalDate.now();

    String daytime= LocalTime.now().toString();
    String day = LocalDate.now().getDayOfWeek().toString();
    Currency currency;

    public List<Currency> parseCurrency() {


        String url = "https://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml";
        try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            document = db.parse(new URL(url).openStream());
        }catch(Exception e){
            e.printStackTrace();
        }
        NodeList list = document.getElementsByTagName("Cube");
        Node nodeTime = list.item(1);
        Element time = (Element) nodeTime;
        List<Currency> currencies = new ArrayList<>();
        if(time.getAttribute("time").equals(today.toString())){
            for(int i = 2; i < list.getLength();i++){
                Node node = list.item(i);
                Element element = (Element) node;
                currency = new Currency(today.toString(), "EUR", element.getAttribute("currency"), Double.parseDouble(element.getAttribute("rate")) );
                currencies.add(currency);
            }
        }
        return (currencies);
    }
}
