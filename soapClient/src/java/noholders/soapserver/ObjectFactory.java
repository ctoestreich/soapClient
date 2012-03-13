
package noholders.soapserver;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the noholders.soapserver package. 
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

    private final static QName _ServiceMethodRequest_QNAME = new QName("http://soapserver.noholders/", "serviceMethodRequest");
    private final static QName _ServiceMethodResponse_QNAME = new QName("http://soapserver.noholders/", "serviceMethodResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: noholders.soapserver
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ServiceMethodRequest }
     * 
     */
    public ServiceMethodRequest createServiceMethodRequest() {
        return new ServiceMethodRequest();
    }

    /**
     * Create an instance of {@link ServiceMethodResponse }
     * 
     */
    public ServiceMethodResponse createServiceMethodResponse() {
        return new ServiceMethodResponse();
    }

    /**
     * Create an instance of {@link ServiceResponse }
     * 
     */
    public ServiceResponse createServiceResponse() {
        return new ServiceResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceMethodRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapserver.noholders/", name = "serviceMethodRequest")
    public JAXBElement<ServiceMethodRequest> createServiceMethodRequest(ServiceMethodRequest value) {
        return new JAXBElement<ServiceMethodRequest>(_ServiceMethodRequest_QNAME, ServiceMethodRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceMethodResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapserver.noholders/", name = "serviceMethodResponse")
    public JAXBElement<ServiceMethodResponse> createServiceMethodResponse(ServiceMethodResponse value) {
        return new JAXBElement<ServiceMethodResponse>(_ServiceMethodResponse_QNAME, ServiceMethodResponse.class, null, value);
    }

}
