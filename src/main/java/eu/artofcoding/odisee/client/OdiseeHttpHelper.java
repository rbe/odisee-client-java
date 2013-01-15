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
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.URL;

public class OdiseeHttpHelper {

    private static final int BUF_SIZE = 128 * 1024;

    private String username;

    private String password;

    private static class UserPassAuthenticator extends Authenticator {

        String user;
        String pass;

        public UserPassAuthenticator(String user, String pass) {
            this.user = user;
            this.pass = pass;
        }

        // This method is called when a password-protected URL is accessed
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(user, pass.toCharArray());
        }
    }

    public static OdiseeHttpHelper create(String username, String password) {
        return new OdiseeHttpHelper(username, password);
    }

    private OdiseeHttpHelper(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public byte[] post(URL url, String body) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        // Authentication
        Authenticator.setDefault(new UserPassAuthenticator(username, password));
        // Request
        connection.setRequestMethod("POST");
        connection.setDoInput(true);
        connection.setDoOutput(true);
        connection.setUseCaches(false);
        // Content
        connection.setRequestProperty("Content-Type", "text/xml");
        connection.setRequestProperty("Content-Length", String.valueOf(body.length()));
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

}
