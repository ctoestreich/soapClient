package soapclient

import javax.xml.ws.Holder
import mime.soapserver.ServiceMethodRequest

class ClientController {

    mime.soapserver.TestService demoMimeClient
    nomime.soapserver.TestService demoNoMimeClient
    noholders.soapserver.TestService demoNoHoldersClient
    noattachment.holders.soapserver.TestService demoHoldersNoAttachmentClient

    def index = {
        def context = [:]
        switch(params.type) {
            case 'noHolders':
                println "Using No-Holders Server"
                noholders.soapserver.ServiceMethodRequest myServiceMethodRequest = new noholders.soapserver.ServiceMethodRequest()
                myServiceMethodRequest.setIntA(5)
                noholders.soapserver.ServiceMethodResponse myServiceMethodResponse = demoNoHoldersClient.serviceMethod(myServiceMethodRequest)
                context = [soapResult: myServiceMethodResponse.getResponse(), attachment: myServiceMethodResponse.getAttachment()]
                break
            case 'holdersNoAttachment':
                println "Using Holders-No-Attachment Server"
                Holder<noattachment.holders.soapserver.ServiceResponse> myServiceResponseHolder = new Holder<noattachment.holders.soapserver.ServiceResponse>()
                Holder<byte[]> myAttachmentHolder = new Holder<byte[]>()
                demoHoldersNoAttachmentClient.serviceMethod(3, myServiceResponseHolder, myAttachmentHolder)
                context = [soapResult: myServiceResponseHolder.value, attachment: myAttachmentHolder.value]
                break
            case 'noMIME':
                println "Using No-MIME Server"
                nomime.soapserver.ServiceMethodRequest myServiceMethodRequest = new nomime.soapserver.ServiceMethodRequest()
                myServiceMethodRequest.setIntA(6)
                Holder<nomime.soapserver.ServiceMethodResponse> myServiceMethodResponseHolder = new Holder<nomime.soapserver.ServiceMethodResponse>()
                Holder<byte[]> myAttachmentHolder = new Holder<byte[]>()
                demoNoMimeClient.serviceMethod(myServiceMethodRequest, myServiceMethodResponseHolder, myAttachmentHolder)
                context = [soapResult: myServiceMethodResponseHolder.value, attachment: myAttachmentHolder.value]
                break
            case 'MIME':
                println "Using MIME Server"
                mime.soapserver.ServiceMethodRequest _serviceMethod_inputParameters = new ServiceMethodRequest(intA: 10);
                javax.xml.ws.Holder<mime.soapserver.ServiceMethodResponse> _serviceMethod_outputParameters = new javax.xml.ws.Holder<mime.soapserver.ServiceMethodResponse>();
                javax.xml.ws.Holder<byte[]> _serviceMethod_attachment = new javax.xml.ws.Holder<byte[]>();
                demoMimeClient.serviceMethod(_serviceMethod_inputParameters, _serviceMethod_outputParameters, _serviceMethod_attachment)
                context = [soapResult:_serviceMethod_outputParameters.value.getResponse(), attachment:_serviceMethod_attachment.value]
                break
            default:
                break
        }

        return context
    }
}
