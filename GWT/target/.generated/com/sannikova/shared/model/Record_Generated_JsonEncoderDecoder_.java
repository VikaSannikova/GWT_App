package com.sannikova.shared.model;

public class Record_Generated_JsonEncoderDecoder_ extends org.fusesource.restygwt.client.AbstractJsonEncoderDecoder<com.sannikova.shared.model.Record> {
  
  public static final Record_Generated_JsonEncoderDecoder_ INSTANCE = new Record_Generated_JsonEncoderDecoder_();
  
  public com.google.gwt.json.client.JSONValue encode(com.sannikova.shared.model.Record value) {
    if( value==null ) {
      return getNullType();
    }
    com.google.gwt.json.client.JSONObject rc = new com.google.gwt.json.client.JSONObject();
    com.sannikova.shared.model.Record parseValue = (com.sannikova.shared.model.Record)value;
    isNotNullValuePut(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.STRING.encode(parseValue.getTimestamp()), rc, "timestamp");
    isNotNullValuePut(com.sannikova.shared.model.Book_Generated_JsonEncoderDecoder_.INSTANCE.encode(parseValue.getBook()), rc, "book");
    return rc;
  }
  
  public com.sannikova.shared.model.Record decode(com.google.gwt.json.client.JSONValue value) {
    if( value == null || value.isNull()!=null ) {
      return null;
    }
    com.google.gwt.json.client.JSONObject object = toObject(value);
    com.sannikova.shared.model.Record rc = new com.sannikova.shared.model.Record();
    rc.setTimestamp(getValueToSet(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.STRING.decode(object.get("timestamp")), null));
    rc.setBook(getValueToSet(com.sannikova.shared.model.Book_Generated_JsonEncoderDecoder_.INSTANCE.decode(object.get("book")), null));
    return rc;
  }
  
}
