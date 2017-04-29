
package com.purplemagic.ws.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.purplemagic.ws.generated package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Customer_QNAME = new QName("http://generated.ws.purplemagic.com/", "customer");
    private final static QName _GetCustomerRequest_QNAME = new QName("http://generated.ws.purplemagic.com/", "getCustomerRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.purplemagic.ws.generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Customer }
     * 
     */
    public Customer createCustomer() {
        return new Customer();
    }

    /**
     * Create an instance of {@link GetCustomerRequest }
     * 
     */
    public GetCustomerRequest createGetCustomerRequest() {
        return new GetCustomerRequest();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Customer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.ws.purplemagic.com/", name = "customer")
    public JAXBElement<Customer> createCustomer(Customer value) {
        return new JAXBElement<Customer>(_Customer_QNAME, Customer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCustomerRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.ws.purplemagic.com/", name = "getCustomerRequest")
    public JAXBElement<GetCustomerRequest> createGetCustomerRequest(GetCustomerRequest value) {
        return new JAXBElement<GetCustomerRequest>(_GetCustomerRequest_QNAME, GetCustomerRequest.class, null, value);
    }

}
