package org.adapter;

public class XmlToJsonAdapter extends Json{
    Xml xml_;

    XmlToJsonAdapter(Xml xml)
    {
        this.xml_ = xml;
    }

    @Override
    public String getJsonString()
    {
        // convert xml to json
        return "{'name':'kartik'}";

    }

}
