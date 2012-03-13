package nomime.soapserver;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.5.2
 * 2012-03-09T16:06:01.812-08:00
 * Generated source version: 2.5.2
 * 
 */
@WebService(targetNamespace = "http://soapserver.nomime/", name = "TestService")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface TestService {

    @WebMethod
    public void serviceMethod(
        @WebParam(partName = "inputParameters", name = "serviceMethodRequest", targetNamespace = "http://soapserver.nomime/")
        ServiceMethodRequest inputParameters,
        @WebParam(partName = "outputParameters", mode = WebParam.Mode.OUT, name = "serviceMethodResponse", targetNamespace = "http://soapserver.nomime/")
        javax.xml.ws.Holder<ServiceMethodResponse> outputParameters,
        @WebParam(partName = "attachment", mode = WebParam.Mode.OUT, name = "attachment", targetNamespace = "http://soapserver.nomime/")
        javax.xml.ws.Holder<byte[]> attachment
    );
}