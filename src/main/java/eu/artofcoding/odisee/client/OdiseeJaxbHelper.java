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

import eu.artofcoding.beetlejuice.xml.XMLException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class OdiseeJaxbHelper {

    @SuppressWarnings({"unchecked"})
    public static <T> T unmarshal(Class<T> clazz, File file) throws XMLException {
        T odisee;
        try {
            // create a JAXBContext capable of handling classes generated into package
            JAXBContext jaxbContext = JAXBContext.newInstance(clazz.getPackage().getName());
            // create an Unmarshaller
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            // unmarshal an instance document into a tree of Java content
            // objects composed of classes from the package.
            odisee = (T) unmarshaller.unmarshal(new FileInputStream(file));
        } catch (JAXBException e) {
            throw new XMLException(e);
        } catch (IOException e) {
            throw new XMLException(e);
        }
        return odisee;
    }

    public static <T> void marshal(Class<T> clazz, T objectToMarshal, Writer writer) throws XMLException {
        try {
            // create a JAXBContext capable of handling classes generated into package
            JAXBContext jaxbContext = JAXBContext.newInstance(clazz.getPackage().getName());
            // create a Marshaller and do marshal
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(objectToMarshal, writer);
            writer.flush();
        } catch (JAXBException e) {
            throw new XMLException(e);
        } catch (IOException e) {
            throw new XMLException(e);
        }
    }

    public static <T> void marshal(Class<T> clazz, T objectToMarshal, OutputStream stream) throws XMLException {
        try {
            // create a JAXBContext capable of handling classes generated into package
            JAXBContext jaxbContext = JAXBContext.newInstance(clazz.getPackage().getName());
            // create a Marshaller and do marshal
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(objectToMarshal, stream);
        } catch (JAXBException e) {
            throw new XMLException(e);
        }
    }

    public static <T> void marshal(Class<T> clazz, T objectToMarshal, File file) throws XMLException {
        try {
            // create a JAXBContext capable of handling classes generated into package
            JAXBContext jaxbContext = JAXBContext.newInstance(clazz.getPackage().getName());
            // create a Marshaller and do marshal
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(objectToMarshal, new FileOutputStream(file));
        } catch (JAXBException e) {
            throw new XMLException(e);
        } catch (FileNotFoundException e) {
            throw new XMLException(e);
        }
    }

}
