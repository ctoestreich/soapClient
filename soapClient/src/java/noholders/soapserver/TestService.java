package noholders.soapserver;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.5.2
 * 2012-03-09T16:06:05.428-08:00
 * Generated source version: 2.5.2
 * 
 */
@WebService(targetNamespace = "http://soapserver.noholders/", name = "TestService")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface TestService {

    @WebResult(name = "serviceMethodResponse", targetNamespace = "http://soapserver.noholders/", partName = "outputParameters")
    @WebMethod
    public ServiceMethodResponse serviceMethod(
        @WebParam(partName = "inputParameters", name = "serviceMethodRequest", targetNamespace = "http://soapserver.noholders/")
        ServiceMethodRequest inputParameters
    );
}