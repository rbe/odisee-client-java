# Odisee(R) Client/Java

## Working with a single request

    :::java
    // Create Odisee client with service URL and authentication
    OdiseeClient odisee = OdiseeClient.createClient("http://service.odisee.de", "username", "password");
    // Create a new request for template HalloOdisee
    // By default, the last call to createRequest is remembered by the client
    odisee.createRequest("HalloOdisee");
    // Set value for userfield "hallo"
    odisee.setUserfield("hallo", "Odisee");
    // Set value in table "Tabelle1" cell "A4"
    odisee.setTableCellValue("Tabelle1", "A4", "value in a table cell");
    // Generate document, PDF by default
    byte[] document = odisee.process();

## Working with multiple requests

    :::java
    // Create Odisee client with service URL and authentication
    OdiseeClient odisee = OdiseeClient.createClient("http://service.odisee.de", "username", "password");
    // First request
    // Create a new request for template HalloOdisee
    Request odiseeRequest = odisee.createRequest("HalloOdisee");
    // Set value for userfield 'hallo'
    odisee.setUserfield(request, "hallo", "Odisee");
    // Set value in table "Tabelle1" cell "A4"
    odisee.setTableCellValue(request, "Tabelle1", "A4", "value in a table cell");
    // Second request
    // Create a new request for template HalloOdisee
    Request odiseeRequest = odisee.createRequest("HalloOdisee");
    // Set value for userfield 'hallo'
    odisee.setUserfield(request, "hallo", "Odisee, again");
    // Set value in table "Tabelle1" cell "A4"
    odisee.setTableCellValue(request, "Tabelle1", "A4", "Another value in a table cell");
    // Generate document, PDF by default
    byte[] document = odisee.process();

## Using the fluent API

    :::java
    // Create Odisee client with service URL and authentication
    OdiseeClient odisee = OdiseeClient.createClient("http://service.odisee.de", "username", "password");
    // Create a new request for template HalloOdisee
    // By default, the last call to createRequest is remembered by the client
    odisee.createRequest("HalloOdisee");
    byte[] document = client.setUserfield("Customer", "Acme Inc.").
                             setUserfield("Salutation", "Mr.").
                             setUserfield("Firstname", "John").
                             setUserfield("Lasstname", "Doe").
                             setUserfield("Street", "5678 Miller Ave").
                             setUserfield("Zipcode", "12345").
                             setUserfield("City", "Berlin").
                             setUserfield("Subject", "This is a letter").
                             process();
