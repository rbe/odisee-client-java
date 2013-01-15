
package eu.artofcoding.odisee.client.jaxb;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://xml.odisee.de/server/request}group" minOccurs="0"/>
 *         &lt;element ref="{http://xml.odisee.de/server/request}template"/>
 *         &lt;element ref="{http://xml.odisee.de/server/request}archive" minOccurs="0"/>
 *         &lt;element ref="{http://xml.odisee.de/server/request}instructions" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "group",
    "template",
    "archive",
    "instructions"
})
@XmlRootElement(name = "request")
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2013-01-10T06:15:21+01:00", comments = "JAXB RI v2.2.4-2")
public class Request {

    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2013-01-10T06:15:21+01:00", comments = "JAXB RI v2.2.4-2")
    protected Group group;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2013-01-10T06:15:21+01:00", comments = "JAXB RI v2.2.4-2")
    protected Template template;
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2013-01-10T06:15:21+01:00", comments = "JAXB RI v2.2.4-2")
    protected Archive archive;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2013-01-10T06:15:21+01:00", comments = "JAXB RI v2.2.4-2")
    protected List<Instructions> instructions;
    @XmlAttribute(name = "name", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2013-01-10T06:15:21+01:00", comments = "JAXB RI v2.2.4-2")
    protected String name;

    /**
     * Gets the value of the group property.
     * 
     * @return
     *     possible object is
     *     {@link Group }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2013-01-10T06:15:21+01:00", comments = "JAXB RI v2.2.4-2")
    public Group getGroup() {
        return group;
    }

    /**
     * Sets the value of the group property.
     * 
     * @param value
     *     allowed object is
     *     {@link Group }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2013-01-10T06:15:21+01:00", comments = "JAXB RI v2.2.4-2")
    public void setGroup(Group value) {
        this.group = value;
    }

    /**
     * Gets the value of the template property.
     * 
     * @return
     *     possible object is
     *     {@link Template }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2013-01-10T06:15:21+01:00", comments = "JAXB RI v2.2.4-2")
    public Template getTemplate() {
        return template;
    }

    /**
     * Sets the value of the template property.
     * 
     * @param value
     *     allowed object is
     *     {@link Template }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2013-01-10T06:15:21+01:00", comments = "JAXB RI v2.2.4-2")
    public void setTemplate(Template value) {
        this.template = value;
    }

    /**
     * Gets the value of the archive property.
     * 
     * @return
     *     possible object is
     *     {@link Archive }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2013-01-10T06:15:21+01:00", comments = "JAXB RI v2.2.4-2")
    public Archive getArchive() {
        return archive;
    }

    /**
     * Sets the value of the archive property.
     * 
     * @param value
     *     allowed object is
     *     {@link Archive }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2013-01-10T06:15:21+01:00", comments = "JAXB RI v2.2.4-2")
    public void setArchive(Archive value) {
        this.archive = value;
    }

    /**
     * Gets the value of the instructions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the instructions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInstructions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Instructions }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2013-01-10T06:15:21+01:00", comments = "JAXB RI v2.2.4-2")
    public List<Instructions> getInstructions() {
        if (instructions == null) {
            instructions = new ArrayList<Instructions>();
        }
        return this.instructions;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2013-01-10T06:15:21+01:00", comments = "JAXB RI v2.2.4-2")
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2013-01-10T06:15:21+01:00", comments = "JAXB RI v2.2.4-2")
    public void setName(String value) {
        this.name = value;
    }

}
