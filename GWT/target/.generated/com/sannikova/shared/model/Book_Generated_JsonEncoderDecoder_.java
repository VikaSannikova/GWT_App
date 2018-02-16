package com.sannikova.shared.model;

public class Book_Generated_JsonEncoderDecoder_ extends org.fusesource.restygwt.client.AbstractJsonEncoderDecoder<com.sannikova.shared.model.Book> {
  
  public static final Book_Generated_JsonEncoderDecoder_ INSTANCE = new Book_Generated_JsonEncoderDecoder_();
  
  public com.google.gwt.json.client.JSONValue encode(com.sannikova.shared.model.Book value) {
    if( value==null ) {
      return getNullType();
    }
    com.google.gwt.json.client.JSONObject rc = new com.google.gwt.json.client.JSONObject();
    com.sannikova.shared.model.Book parseValue = (com.sannikova.shared.model.Book)value;
    isNotNullValuePut(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.INT.encode(parseValue.getId()), rc, "id");
    isNotNullValuePut(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.STRING.encode(parseValue.getAuthor()), rc, "author");
    isNotNullValuePut(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.STRING.encode(parseValue.getTitle()), rc, "title");
    isNotNullValuePut(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.STRING.encode(parseValue.getPages()), rc, "pages");
    isNotNullValuePut(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.STRING.encode(parseValue.getYear()), rc, "year");
    return rc;
  }
  
  public com.sannikova.shared.model.Book decode(com.google.gwt.json.client.JSONValue value) {
    if( value == null || value.isNull()!=null ) {
      return null;
    }
    com.google.gwt.json.client.JSONObject object = toObject(value);
    com.sannikova.shared.model.Book rc = new com.sannikova.shared.model.Book();
    rc.setId(getValueToSet(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.INT.decode(object.get("id")), null));
    rc.setAuthor(getValueToSet(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.STRING.decode(object.get("author")), null));
    rc.setTitle(getValueToSet(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.STRING.decode(object.get("title")), null));
    rc.setPages(getValueToSet(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.STRING.decode(object.get("pages")), null));
    rc.setYear(getValueToSet(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.STRING.decode(object.get("year")), null));
    return rc;
  }
  
}
