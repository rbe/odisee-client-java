/*
 * odisee-client-java
 * odisee-client-java
 * Copyright (C) 2011-2013 art of coding UG, http://www.art-of-coding.eu
 * Copyright (C) 2005-2010 Informationssysteme Ralf Bensmann, http://www.bensmann.com
 *
 * Alle Rechte vorbehalten. Nutzung unterliegt Lizenzbedingungen.
 * All rights reserved. Use is subject to license terms.
 *
 * rbe, 14.01.13 12:36
 */

package eu.artofcoding.odisee.client;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.*;
import java.util.zip.GZIPOutputStream;

public class OdiseeHttpHelper {

    private static final int BUF_SIZE = 128 * 1024;

    private String username;

    private String password;

    private OdiseeHttpHelper(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static OdiseeHttpHelper create(String username, String password) {
        return new OdiseeHttpHelper(username, password);
    }

    public byte[] post(URL url, String body) throws IOException {
        HttpURLConnection connection = getHttpURLConnection(url);
        connection.setRequestProperty("Content-Length", String.valueOf(body.length()));
        connection.setRequestProperty("Content-Type", "text/xml");
        // Write request
        OutputStreamWriter streamWriter = new OutputStreamWriter(connection.getOutputStream());
        streamWriter.write(body);
        streamWriter.flush();
        // Read response
        InputStream is = connection.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buf = new byte[BUF_SIZE];
        int len;
        while ((len = is.read(buf)) != -1) {
            baos.write(buf, 0, len);
        }
        streamWriter.close();
        connection.disconnect();
        return baos.toByteArray();
    }

    public byte[] postCompressed(URL url, String body) throws IOException {
        HttpURLConnection connection = getHttpURLConnection(url);
        connection.setRequestProperty("Content-Type", "application/x-gzip");
        connection.setRequestProperty("Content-Encoding", "gzip");
        // Write request
        GZIPOutputStream gzipOutputStream = new GZIPOutputStream(connection.getOutputStream());
        OutputStreamWriter streamWriter = new OutputStreamWriter(gzipOutputStream);
        streamWriter.write(body);
        streamWriter.flush();
        // Read response
        InputStream is = connection.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buf = new byte[BUF_SIZE];
        int len;
        while ((len = is.read(buf)) != -1) {
            baos.write(buf, 0, len);
        }
        streamWriter.close();
        connection.disconnect();
        return baos.toByteArray();
    }

    private HttpURLConnection getHttpURLConnection(URL url) throws IOException {
        // First set the default cookie manager.
        CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));
        System.setProperty("http.maxRedirects", "3");
        // URL connection
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        // Authentication
        Authenticator.setDefault(new UserPassAuthenticator(username, password));
        // Request
        connection.setRequestMethod("POST");
        connection.setDoInput(true);
        connection.setDoOutput(true);
        connection.setUseCaches(false);
        connection.setRequestProperty("User-Agent", "Odisee/Java Client");
        //connection.setRequestProperty("Accept", "text/html, *; q=.2, */*; q=.2");
        return connection;
    }

    private static class UserPassAuthenticator extends Authenticator {

        String user;

        String pass;

        public UserPassAuthenticator(String user, String pass) {
            this.user = user;
            this.pass = pass;
        }

        /**
         * This method is called when a password-protected URL is accessed.
         */
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(user, pass.toCharArray());
        }
    }

}
