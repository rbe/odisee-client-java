
package eu.artofcoding.odisee.client.jaxb;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the eu.artofcoding.odisee.client.jaxb package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ResultPlaceholder_QNAME = new QName("http://xml.odisee.de/server/request", "result-placeholder");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: eu.artofcoding.odisee.client.jaxb
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Template }
     */
    public Template createTemplate() {
        return new Template();
    }

    /**
     * Create an instance of {@link Autotext }
     */
    public Autotext createAutotext() {
        return new Autotext();
    }

    /**
     * Create an instance of {@link Bookmark }
     */
    public Bookmark createBookmark() {
        return new Bookmark();
    }

    /**
     * Create an instance of {@link Instructions }
     */
    public Instructions createInstructions() {
        return new Instructions();
    }

    /**
     * Create an instance of {@link Macro }
     */
    public Macro createMacro() {
        return new Macro();
    }

    /**
     * Create an instance of {@link Parameter }
     */
    public Parameter createParameter() {
        return new Parameter();
    }

    /**
     * Create an instance of {@link Userfield }
     */
    public Userfield createUserfield() {
        return new Userfield();
    }

    /**
     * Create an instance of {@link Table }
     */
    public Table createTable() {
        return new Table();
    }

    /**
     * Create an instance of {@link Odisee }
     */
    public Odisee createOdisee() {
        return new Odisee();
    }

    /**
     * Create an instance of {@link PostProcess }
     */
    public PostProcess createPostProcess() {
        return new PostProcess();
    }

    /**
     * Create an instance of {@link Action }
     */
    public Action createAction() {
        return new Action();
    }

    /**
     * Create an instance of {@link Input }
     */
    public Input createInput() {
        return new Input();
    }

    /**
     * Create an instance of {@link Request }
     */
    public Request createRequest() {
        return new Request();
    }

    /**
     * Create an instance of {@link Group }
     */
    public Group createGroup() {
        return new Group();
    }

    /**
     * Create an instance of {@link Archive }
     */
    public Archive createArchive() {
        return new Archive();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     */
    @XmlElementDecl(namespace = "http://xml.odisee.de/server/request", name = "result-placeholder")
    public JAXBElement<Object> createResultPlaceholder(Object value) {
        return new JAXBElement<Object>(_ResultPlaceholder_QNAME, Object.class, null, value);
    }

}
