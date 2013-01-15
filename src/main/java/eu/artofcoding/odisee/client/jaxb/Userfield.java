
package eu.artofcoding.odisee.client.jaxb;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="post-macro" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "content"
})
@XmlRootElement(name = "userfield")
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2013-01-10T06:15:21+01:00", comments = "JAXB RI v2.2.4-2")
public class Userfield {

    @XmlValue
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2013-01-10T06:15:21+01:00", comments = "JAXB RI v2.2.4-2")
    protected String content;
    @XmlAttribute(name = "name", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2013-01-10T06:15:21+01:00", comments = "JAXB RI v2.2.4-2")
    protected String name;
    @XmlAttribute(name = "post-macro")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2013-01-10T06:15:21+01:00", comments = "JAXB RI v2.2.4-2")
    protected String postMacro;

    /**
     * Gets the value of the content property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2013-01-10T06:15:21+01:00", comments = "JAXB RI v2.2.4-2")
    public String getContent() {
        return content;
    }

    /**
     * Sets the value of the content property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2013-01-10T06:15:21+01:00", comments = "JAXB RI v2.2.4-2")
    public void setContent(String value) {
        this.content = value;
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

    /**
     * Gets the value of the postMacro property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2013-01-10T06:15:21+01:00", comments = "JAXB RI v2.2.4-2")
    public String getPostMacro() {
        return postMacro;
    }

    /**
     * Sets the value of the postMacro property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2013-01-10T06:15:21+01:00", comments = "JAXB RI v2.2.4-2")
    public void setPostMacro(String value) {
        this.postMacro = value;
    }

}
