
package eu.artofcoding.odisee.client.jaxb;

import javax.annotation.Generated;
import javax.xml.bind.annotation.*;


/**
 * <p>Java class for anonymous complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="group" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="bookmark" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="atend" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "autotext")
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2013-01-10T06:15:21+01:00", comments = "JAXB RI v2.2.4-2")
public class Autotext {

    @XmlAttribute(name = "group", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2013-01-10T06:15:21+01:00", comments = "JAXB RI v2.2.4-2")
    protected String group;

    @XmlAttribute(name = "name", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2013-01-10T06:15:21+01:00", comments = "JAXB RI v2.2.4-2")
    protected String name;

    @XmlAttribute(name = "bookmark")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2013-01-10T06:15:21+01:00", comments = "JAXB RI v2.2.4-2")
    protected String bookmark;

    @XmlAttribute(name = "atend")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2013-01-10T06:15:21+01:00", comments = "JAXB RI v2.2.4-2")
    protected Boolean atend;

    /**
     * Gets the value of the group property.
     *
     * @return possible object is
     *         {@link String }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2013-01-10T06:15:21+01:00", comments = "JAXB RI v2.2.4-2")
    public String getGroup() {
        return group;
    }

    /**
     * Sets the value of the group property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2013-01-10T06:15:21+01:00", comments = "JAXB RI v2.2.4-2")
    public void setGroup(String value) {
        this.group = value;
    }

    /**
     * Gets the value of the name property.
     *
     * @return possible object is
     *         {@link String }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2013-01-10T06:15:21+01:00", comments = "JAXB RI v2.2.4-2")
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2013-01-10T06:15:21+01:00", comments = "JAXB RI v2.2.4-2")
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the bookmark property.
     *
     * @return possible object is
     *         {@link String }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2013-01-10T06:15:21+01:00", comments = "JAXB RI v2.2.4-2")
    public String getBookmark() {
        return bookmark;
    }

    /**
     * Sets the value of the bookmark property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2013-01-10T06:15:21+01:00", comments = "JAXB RI v2.2.4-2")
    public void setBookmark(String value) {
        this.bookmark = value;
    }

    /**
     * Gets the value of the atend property.
     *
     * @return possible object is
     *         {@link Boolean }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2013-01-10T06:15:21+01:00", comments = "JAXB RI v2.2.4-2")
    public Boolean isAtend() {
        return atend;
    }

    /**
     * Sets the value of the atend property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2013-01-10T06:15:21+01:00", comments = "JAXB RI v2.2.4-2")
    public void setAtend(Boolean value) {
        this.atend = value;
    }

}
