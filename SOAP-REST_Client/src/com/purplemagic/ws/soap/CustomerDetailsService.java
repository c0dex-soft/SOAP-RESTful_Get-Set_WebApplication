package com.purplemagic.ws.soap;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.1.10
 * 2017-04-05T17:08:10.336+02:00
 * Generated source version: 3.1.10
 * 
 */
@WebServiceClient(name = "CustomerDetailsService", 
                  wsdlLocation = "file:/D:/Valera%20Documents/Programiranje/MyWorkspace/ServerDB_SOAP-REST/src/main/webapp/WEB-INF/wsdl/CustomerDetails.wsdl",
                  targetNamespace = "http://soap.ws.purplemagic.com/") 
public class CustomerDetailsService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://soap.ws.purplemagic.com/", "CustomerDetailsService");
    public final static QName CustomerDetailsPort = new QName("http://soap.ws.purplemagic.com/", "CustomerDetailsPort");
    static {
        URL url = null;
        try {
            url = new URL("file:/D:/Valera%20Documents/Programiranje/MyWorkspace/ServerDB_SOAP-REST/src/main/webapp/WEB-INF/wsdl/CustomerDetails.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(CustomerDetailsService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "file:/D:/Valera%20Documents/Programiranje/MyWorkspace/ServerDB_SOAP-REST/src/main/webapp/WEB-INF/wsdl/CustomerDetails.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public CustomerDetailsService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public CustomerDetailsService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CustomerDetailsService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public CustomerDetailsService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public CustomerDetailsService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public CustomerDetailsService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns CustomerDetailsPortType
     */
    @WebEndpoint(name = "CustomerDetailsPort")
    public CustomerDetailsPortType getCustomerDetailsPort() {
        return super.getPort(CustomerDetailsPort, CustomerDetailsPortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CustomerDetailsPortType
     */
    @WebEndpoint(name = "CustomerDetailsPort")
    public CustomerDetailsPortType getCustomerDetailsPort(WebServiceFeature... features) {
        return super.getPort(CustomerDetailsPort, CustomerDetailsPortType.class, features);
    }

}
