package com.lrest.server.utils;

import com.google.gson.JsonObject;
import okhttp3.OkHttpClient;

import javax.net.ssl.*;
import javax.servlet.http.HttpServletRequest;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Calendar;
import java.util.UUID;


public class UtilBase {

    public static String genUUID() {
        return UUID.randomUUID().toString().replaceAll("\\-", "");
    }


    public static String getJsonAsString(JsonObject json, String name) {
        String ret = json.get(name) == null ? null : json.get(name).getAsString();
        return ret;
    }

    public static int getJsonAsInt(JsonObject json, String name) {
        return json.get(name) == null ? -1 : json.get(name).getAsInt();
    }
    public static byte getJsonAsByte(JsonObject json, String name) {
        return json.get(name) == null ? -1 : json.get(name).getAsByte();
    }

}
