package com.sannikova.client;

public class Library_Generated_RestServiceProxy_ implements com.sannikova.client.Library, org.fusesource.restygwt.client.RestServiceProxy {
  private org.fusesource.restygwt.client.Resource resource = null;
  
  public void setResource(org.fusesource.restygwt.client.Resource resource) {
    this.resource = resource;
  }
  public org.fusesource.restygwt.client.Resource getResource() {
    if (this.resource == null) {
      String serviceRoot = org.fusesource.restygwt.client.Defaults.getServiceRoot();
      this.resource = new org.fusesource.restygwt.client.Resource(serviceRoot).resolve("/rest/library");
    }
    return this.resource;
  }
  private org.fusesource.restygwt.client.Dispatcher dispatcher = null;
  
  public void setDispatcher(org.fusesource.restygwt.client.Dispatcher dispatcher) {
    this.dispatcher = dispatcher;
  }
  
  public org.fusesource.restygwt.client.Dispatcher getDispatcher() {
    return this.dispatcher;
  }
  public void addBook(com.sannikova.shared.model.Book newBook, int page, org.fusesource.restygwt.client.MethodCallback<com.sannikova.shared.model.Page> callback) {
    final com.sannikova.shared.model.Book final_newBook = newBook;
    final int final_page = page;
    final org.fusesource.restygwt.client.Method __method =
    getResource()
    .resolve("/add/"+(""+page== null? null : com.google.gwt.http.client.URL.encodePathSegment(""+page))+"")
    .post();
    __method.setDispatcher(this.dispatcher);
    __method.header(org.fusesource.restygwt.client.Resource.HEADER_ACCEPT, "application/json");
    __method.header(org.fusesource.restygwt.client.Resource.HEADER_CONTENT_TYPE, "application/json");
    __method.json(com.sannikova.shared.model.Book_Generated_JsonEncoderDecoder_.INSTANCE.encode(newBook));
    try {
      __method.send(new org.fusesource.restygwt.client.AbstractRequestCallback<com.sannikova.shared.model.Page>(__method, callback) {
        protected com.sannikova.shared.model.Page parseResult() throws Exception {
          try {
            return com.sannikova.shared.model.Page_Generated_JsonEncoderDecoder_.INSTANCE.decode(com.google.gwt.json.client.JSONParser.parse(__method.getResponse().getText()));
          } catch (Throwable __e) {
            throw new org.fusesource.restygwt.client.ResponseFormatException("Response was NOT a valid JSON document", __e);
          }
        }
      });
    } catch (com.google.gwt.http.client.RequestException __e) {
      callback.onFailure(__method,__e);
    }
  }
  public void getPage(int page, org.fusesource.restygwt.client.MethodCallback<com.sannikova.shared.model.Page> callback) {
    final int final_page = page;
    final org.fusesource.restygwt.client.Method __method =
    getResource()
    .resolve("/"+(""+page== null? null : com.google.gwt.http.client.URL.encodePathSegment(""+page))+"")
    .post();
    __method.setDispatcher(this.dispatcher);
    __method.header(org.fusesource.restygwt.client.Resource.HEADER_ACCEPT, "application/json");
    try {
      __method.send(new org.fusesource.restygwt.client.AbstractRequestCallback<com.sannikova.shared.model.Page>(__method, callback) {
        protected com.sannikova.shared.model.Page parseResult() throws Exception {
          try {
            return com.sannikova.shared.model.Page_Generated_JsonEncoderDecoder_.INSTANCE.decode(com.google.gwt.json.client.JSONParser.parse(__method.getResponse().getText()));
          } catch (Throwable __e) {
            throw new org.fusesource.restygwt.client.ResponseFormatException("Response was NOT a valid JSON document", __e);
          }
        }
      });
    } catch (com.google.gwt.http.client.RequestException __e) {
      callback.onFailure(__method,__e);
    }
  }
  public void removeBook(java.lang.Integer id, int page, org.fusesource.restygwt.client.MethodCallback<com.sannikova.shared.model.Page> callback) {
    final java.lang.Integer final_id = id;
    final int final_page = page;
    final org.fusesource.restygwt.client.Method __method =
    getResource()
    .resolve("/remove/"+(""+page== null? null : com.google.gwt.http.client.URL.encodePathSegment(""+page))+"")
    .post();
    __method.setDispatcher(this.dispatcher);
    __method.header(org.fusesource.restygwt.client.Resource.HEADER_ACCEPT, "application/json");
    __method.header(org.fusesource.restygwt.client.Resource.HEADER_CONTENT_TYPE, "application/json");
    __method.json(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.INT.encode(id));
    try {
      __method.send(new org.fusesource.restygwt.client.AbstractRequestCallback<com.sannikova.shared.model.Page>(__method, callback) {
        protected com.sannikova.shared.model.Page parseResult() throws Exception {
          try {
            return com.sannikova.shared.model.Page_Generated_JsonEncoderDecoder_.INSTANCE.decode(com.google.gwt.json.client.JSONParser.parse(__method.getResponse().getText()));
          } catch (Throwable __e) {
            throw new org.fusesource.restygwt.client.ResponseFormatException("Response was NOT a valid JSON document", __e);
          }
        }
      });
    } catch (com.google.gwt.http.client.RequestException __e) {
      callback.onFailure(__method,__e);
    }
  }
}
