/*
 * odisee-client-java
 * odisee-client-java
 * Copyright (C) 2011-2013 art of coding UG, http://www.art-of-coding.eu
 * Copyright (C) 2005-2010 Informationssysteme Ralf Bensmann, http://www.bensmann.com
 *
 * Alle Rechte vorbehalten. Nutzung unterliegt Lizenzbedingungen.
 * All rights reserved. Use is subject to license terms.
 *
 * rbe, 16.05.13 09:01
 */

package eu.artofcoding.odisee.client;

import eu.artofcoding.beetlejuice.helper.StreamHelper;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class OdiseeClientTest {

    private static final String SERVICE_BASE_URL = "http://service3.odisee.de";

    private static final String GZIP_SERVICE_BASE_URL = "http://service3.odisee.de:81";

    @Test
    public void halloOdisee() throws IOException, OdiseeClientException {
        // Create Odisee client
        String url = String.format("%s/odisee/document/generate", SERVICE_BASE_URL);
        String odiseeUsername = "odisee";
        String odiseePassword = "odisee";
        OdiseeClient client = OdiseeClient.createClient(url, odiseeUsername, odiseePassword);
        // Set values
        client.createRequest("HalloOdisee");
        client.setArchive(false, true);
        client.setUserfield("Hallo", "Odisee");
        // Save request to disk
        Path path = Files.createTempFile(Paths.get("src/test/data"), "odisee_", ".xml");
        client.saveRequestTo(path);
        System.out.printf("Compressed XML request saved to %s%n", path.toString());
        // Send request
        byte[] document = client.process(false);
        File file = new File(path.getParent().toFile(), String.format("%s.pdf", path.getFileName()));
        StreamHelper.saveToFile(document, file);
        System.out.printf("Document saved to %s%n", file.toString());
        // Document generated?
        Assert.assertNotNull(document);
        Assert.assertTrue("Document size >= 100 bytes", document.length > 100);
    }

    @Test
    public void compressedHalloOdisee() throws IOException, OdiseeClientException {
        // Create Odisee client
        String url = String.format("%s/odisee/document/generate", GZIP_SERVICE_BASE_URL);
        String odiseeUsername = "odisee";
        String odiseePassword = "odisee";
        OdiseeClient client = OdiseeClient.createClient(url, odiseeUsername, odiseePassword);
        // Set values
        client.createRequest("HalloOdisee");
        client.setArchive(false, true);
        client.setUserfield("Hallo", "Odisee");
        // Save request to disk
        Path path = Files.createTempFile(Paths.get("src/test/data"), "odisee_", ".xml.gz");
        client.saveCompressedRequestTo(path);
        System.out.printf("Compressed XML request saved to %s%n", path.toString());
        // Send request
        byte[] document = client.process(true);
        File file = new File(path.getParent().toFile(), String.format("%s.pdf", path.getFileName()));
        StreamHelper.saveToFile(document, file);
        System.out.printf("Document saved to %s%n", file.toString());
        // Document generated?
        Assert.assertNotNull(document);
        Assert.assertTrue("Document size >= 100 bytes", document.length > 100);
    }

}
