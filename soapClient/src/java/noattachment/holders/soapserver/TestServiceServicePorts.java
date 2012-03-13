package noattachment.holders.soapserver;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.4.2
 * 2012-03-13T16:12:41.763-05:00
 * Generated source version: 2.4.2
 * 
 */
@WebServiceClient(name = "TestServiceServicePorts", 
                  wsdlLocation = "http://localhost:8083/soapServerHoldersNoAttachment/services/test?wsdl",
                  targetNamespace = "http://soapserver.holders.noattachment/") 
public class TestServiceServicePorts extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://soapserver.holders.noattachment/", "TestServiceServicePorts");
    public final static QName TestServicePort = new QName("http://soapserver.holders.noattachment/", "TestServicePort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8083/soapServerHoldersNoAttachment/services/test?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(TestServiceServicePorts.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://localhost:8083/soapServerHoldersNoAttachment/services/test?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public TestServiceServicePorts(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public TestServiceServicePorts(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public TestServiceServicePorts() {
        super(WSDL_LOCATION, SERVICE);
    }
    

    /**
     *
     * @return
     *     returns TestService
     */
    @WebEndpoint(name = "TestServicePort")
    public TestService getTestServicePort() {
        return super.getPort(TestServicePort, TestService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns TestService
     */
    @WebEndpoint(name = "TestServicePort")
    public TestService getTestServicePort(WebServiceFeature... features) {
        return super.getPort(TestServicePort, TestService.class, features);
    }

}
