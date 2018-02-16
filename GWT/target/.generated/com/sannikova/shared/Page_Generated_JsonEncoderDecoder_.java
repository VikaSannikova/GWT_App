package com.sannikova.shared;

public class Page_Generated_JsonEncoderDecoder_ extends org.fusesource.restygwt.client.AbstractJsonEncoderDecoder<com.sannikova.shared.Page> {
  
  public static final Page_Generated_JsonEncoderDecoder_ INSTANCE = new Page_Generated_JsonEncoderDecoder_();
  
  public com.google.gwt.json.client.JSONValue encode(com.sannikova.shared.Page value) {
    if( value==null ) {
      return getNullType();
    }
    com.google.gwt.json.client.JSONObject rc = new com.google.gwt.json.client.JSONObject();
    com.sannikova.shared.Page parseValue = (com.sannikova.shared.Page)value;
    isNotNullValuePut(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.toJSON(parseValue.getRows(), com.sannikova.shared.Record_Generated_JsonEncoderDecoder_.INSTANCE), rc, "rows");
    isNotNullValuePut(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.INT.encode(parseValue.getSize()), rc, "size");
    return rc;
  }
  
  public com.sannikova.shared.Page decode(com.google.gwt.json.client.JSONValue value) {
    if( value == null || value.isNull()!=null ) {
      return null;
    }
    com.google.gwt.json.client.JSONObject object = toObject(value);
    com.sannikova.shared.Page rc = new com.sannikova.shared.Page();
    rc.setRows(getValueToSet(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.toList(object.get("rows"), com.sannikova.shared.Record_Generated_JsonEncoderDecoder_.INSTANCE), null));
    rc.setSize(getValueToSet(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.INT.decode(object.get("size")), 0));
    return rc;
  }
  
}
