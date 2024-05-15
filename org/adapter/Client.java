package org.adapter;

public class Client {
    public static void main(String[] args) {
        Xml xml = new Xml("<name>kartik</name>");

        Json json = new XmlToJsonAdapter(xml);
        System.out.println(json.getJsonString());
    }
}
