package com.google.mvc.dao;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Map;

public interface TbSearchDao {
    public String newsApi(String search);
    public String get(String apiUrl, Map<String, String> requestHeaders);
    public HttpURLConnection connect(String apiUrl);
    public String readBody(InputStream body);


}
