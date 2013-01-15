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

import eu.artofcoding.beetlejuice.xml.JAXBHelper;
import eu.artofcoding.beetlejuice.xml.XMLException;
import eu.artofcoding.odisee.client.jaxb.*;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;
import java.nio.file.Path;
import java.util.List;

public class OdiseeClient {

    private final ObjectFactory factory = new ObjectFactory();

    private String serviceURL;

    private String authKey;

    private OdiseeHttpHelper httpHelper;

    private Odisee odisee;

    private Request actualRequest;

    private OdiseeClient() {
        odisee = factory.createOdisee();
    }

    //<editor-fold desc="Odisee Client Factory">

    public static OdiseeClient createClient() {
        return createClient("localhost", "odisee", "odisee");
    }

    public static OdiseeClient createClient(String serviceURL) {
        OdiseeClient odiseeClient = new OdiseeClient();
        odiseeClient.serviceURL = serviceURL;
        return odiseeClient;
    }

    public static OdiseeClient createClient(String serviceURL, String authKey) {
        OdiseeClient odiseeClient = new OdiseeClient();
        odiseeClient.serviceURL = serviceURL;
        odiseeClient.authKey = authKey;
        return odiseeClient;
    }

    public static OdiseeClient createClient(String serviceURL, String username, String password) {
        OdiseeClient odiseeClient = new OdiseeClient();
        odiseeClient.serviceURL = serviceURL;
        odiseeClient.httpHelper = OdiseeHttpHelper.create(username, password);
        return odiseeClient;
    }

    //</editor-fold>

    private Instructions getInstructions(Request request) {
        List<Instructions> allInstructions = request.getInstructions();
        Instructions instructions;
        if (allInstructions.size() == 0) {
            instructions = new Instructions();
            request.getInstructions().add(instructions);
        }
        return allInstructions.get(allInstructions.size() - 1);
    }

    private List<Object> getInstructionsObject(Request request) {
        return getInstructions(request).getAutotextAndBookmarkAndMacro();
    }

    //<editor-fold desc="Odisee Client API">

    public OdiseeClient mergeDocumentAtEnd(Request request, Path path) {
        PostProcess postProcess = factory.createPostProcess();
        Action action = factory.createAction();
        action.setType("merge-with");
        action.setResultPlaceholder("");
        Input input = factory.createInput();
        input.setFilename(path.toString());
        action.setInput(input);
        postProcess.getAction().add(action);
        odisee.getPostProcess().add(postProcess);
        return this;
    }

    public OdiseeClient mergeDocumentAtEnd(Path path) {
        return mergeDocumentAtEnd(actualRequest, path);
    }

    public OdiseeClient executeMacro(Request request, String macroName, String location, String language, List<String> parameters) {
        Macro macro = factory.createMacro();
        macro.setName(macroName);
        macro.setLocation(location);
        macro.setLanguage(language);
        for (String p : parameters) {
            Parameter parameter = factory.createParameter();
            parameter.setValue(p);
            macro.getParameter().add(parameter);
        }
        getInstructionsObject(actualRequest).add(macro);
        return this;
    }

    public OdiseeClient executeMacro(String macroName, String location, String language, List<String> parameters) {
        return executeMacro(actualRequest, macroName, location, language, parameters);
    }

    public OdiseeClient executeBasicMacroInDocument(Request request, String macroName, List<String> parameters) {
        return executeMacro(request, macroName, "document", "Basic", parameters);
    }

    public OdiseeClient executeBasicMacroInDocument(String macroName, List<String> parameters) {
        return executeMacro(actualRequest, macroName, "document", "Basic", parameters);
    }

    public OdiseeClient executeBasicMacroInDocument(String macroName) {
        return executeMacro(actualRequest, macroName, "document", "Basic", null);
    }

    public OdiseeClient setTableCellValue(Request request, String tableName, String coordinate, String value) {
        Userfield userfieldTableCell = factory.createUserfield();
        userfieldTableCell.setName(String.format("%s!%s", tableName, coordinate));
        userfieldTableCell.setContent(value);
        getInstructionsObject(actualRequest).add(userfieldTableCell);
        return this;
    }

    public OdiseeClient setTableCellValue(String tableName, String coordinate, String value) {
        return setTableCellValue(actualRequest, tableName, coordinate, value);
    }

    public OdiseeClient setUserfield(Request request, String userfieldName, String value) {
        Userfield userfield = factory.createUserfield();
        userfield.setName(userfieldName);
        userfield.setContent(value);
        getInstructionsObject(actualRequest).add(userfield);
        return this;
    }

    public OdiseeClient setUserfield(String userfieldName, String value) {
        return setUserfield(actualRequest, userfieldName, value);
    }

    public OdiseeClient setArchive(Request request, boolean database, boolean files) {
        Archive archive = request.getArchive();
        if (null == archive) {
            request.setArchive(factory.createArchive());
        }
        request.getArchive().setDatabase(database);
        request.getArchive().setFiles(files);
        return this;
    }

    public OdiseeClient setArchive(boolean database, boolean filesystem) {
        return setArchive(actualRequest, database, filesystem);
    }

    public OdiseeClient setLatestTemplate(Request request, String template, String outputFormat) {
        Template requestTemplate = request.getTemplate();
        if (null == requestTemplate) {
            actualRequest.setTemplate(factory.createTemplate());
        }
        request.getTemplate().setName(template);
        request.getTemplate().setRevision("LATEST");
        request.getTemplate().setOutputFormat(outputFormat);
        return this;
    }

    public OdiseeClient setLatestTemplate(String template, String outputFormat) {
        return setLatestTemplate(actualRequest, template, outputFormat);
    }

    public OdiseeClient setLatestTemplate(String template) {
        return setLatestTemplate(template, "pdf");
    }

    public OdiseeClient createRequest() {
        actualRequest = factory.createRequest();
        odisee.getRequest().add(actualRequest);
        return this;
    }

    public OdiseeClient createRequest(String template, String outputFormat) {
        createRequest();
        setLatestTemplate(template, outputFormat);
        return this;
    }

    public OdiseeClient createRequest(String template) {
        return createRequest(template, "pdf");
    }

    public byte[] process() throws OdiseeClientException {
        byte[] result;
        try {
            Writer odiseeXml = new StringWriter();
            JAXBHelper.marshal(Odisee.class, odisee, odiseeXml);
            result = httpHelper.post(new URL(serviceURL), odiseeXml.toString());
        } catch (XMLException e) {
            throw new OdiseeClientException(e);
        } catch (IOException e) {
            throw new OdiseeClientException(e);
        }
        return result;
    }

    //</editor-fold>

}
