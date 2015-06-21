
package eu.artofcoding.odisee.client.jaxb;

import javax.annotation.Generated;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for anonymous complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence maxOccurs="unbounded">
 *         &lt;element ref="{http://xml.odisee.de/server/request}autotext" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://xml.odisee.de/server/request}bookmark" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://xml.odisee.de/server/request}macro" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://xml.odisee.de/server/request}userfield" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://xml.odisee.de/server/request}table" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "autotextAndBookmarkAndMacro"
})
@XmlRootElement(name = "instructions")
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2013-01-10T06:15:21+01:00", comments = "JAXB RI v2.2.4-2")
public class Instructions {

    @XmlElements({
            @XmlElement(name = "autotext", type = Autotext.class),
            @XmlElement(name = "bookmark", type = Bookmark.class),
            @XmlElement(name = "macro", type = Macro.class),
            @XmlElement(name = "userfield", type = Userfield.class),
            @XmlElement(name = "table", type = Table.class)
    })
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2013-01-10T06:15:21+01:00", comments = "JAXB RI v2.2.4-2")
    protected List<Object> autotextAndBookmarkAndMacro;

    /**
     * Gets the value of the autotextAndBookmarkAndMacro property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the autotextAndBookmarkAndMacro property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAutotextAndBookmarkAndMacro().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link Autotext }
     * {@link Bookmark }
     * {@link Macro }
     * {@link Userfield }
     * {@link Table }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2013-01-10T06:15:21+01:00", comments = "JAXB RI v2.2.4-2")
    public List<Object> getAutotextAndBookmarkAndMacro() {
        if (autotextAndBookmarkAndMacro == null) {
            autotextAndBookmarkAndMacro = new ArrayList<Object>();
        }
        return this.autotextAndBookmarkAndMacro;
    }

}
