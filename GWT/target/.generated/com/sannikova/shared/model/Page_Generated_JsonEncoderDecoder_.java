package com.sannikova.shared.model;

public class Page_Generated_JsonEncoderDecoder_ extends org.fusesource.restygwt.client.AbstractJsonEncoderDecoder<com.sannikova.shared.model.Page> {
  
  public static final Page_Generated_JsonEncoderDecoder_ INSTANCE = new Page_Generated_JsonEncoderDecoder_();
  
  public com.google.gwt.json.client.JSONValue encode(com.sannikova.shared.model.Page value) {
    if( value==null ) {
      return getNullType();
    }
    com.google.gwt.json.client.JSONObject rc = new com.google.gwt.json.client.JSONObject();
    com.sannikova.shared.model.Page parseValue = (com.sannikova.shared.model.Page)value;
    isNotNullValuePut(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.toJSON(parseValue.getRows(), com.sannikova.shared.model.Record_Generated_JsonEncoderDecoder_.INSTANCE), rc, "rows");
    isNotNullValuePut(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.INT.encode(parseValue.getSize()), rc, "size");
    return rc;
  }
  
  public com.sannikova.shared.model.Page decode(com.google.gwt.json.client.JSONValue value) {
    if( value == null || value.isNull()!=null ) {
      return null;
    }
    com.google.gwt.json.client.JSONObject object = toObject(value);
    com.sannikova.shared.model.Page rc = new com.sannikova.shared.model.Page();
    rc.setRows(getValueToSet(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.toList(object.get("rows"), com.sannikova.shared.model.Record_Generated_JsonEncoderDecoder_.INSTANCE), null));
    rc.setSize(getValueToSet(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.INT.decode(object.get("size")), 0));
    return rc;
  }
  
}
