package soapclient
import javax.xml.ws.Holder

class ClientController {

  mime.soapserver.TestService demoMimeClient
  nomime.soapserver.TestService demoNoMimeClient
  noholders.soapserver.TestService demoNoHoldersClient
  noattachment.holders.soapserver.TestService demoHoldersNoAttachmentClient

  def index = {
    def context = [:]
    switch (params.type) {
      case 'noHolders':
        println "Using No-Holders Server"
        noholders.soapserver.ServiceMethodRequest myServiceMethodRequest = new noholders.soapserver.ServiceMethodRequest()
        myServiceMethodRequest.setIntA(5)
        noholders.soapserver.ServiceMethodResponse myServiceMethodResponse = demoNoHoldersClient.serviceMethod(myServiceMethodRequest)
        context = [soapResult:myServiceMethodResponse.getResponse(), attachment:myServiceMethodResponse.getAttachment()]
        break
      case 'holdersNoAttachment':
        println "Using Holders-No-Attachment Server"
        Holder<noattachment.holders.soapserver.ServiceResponse> myServiceResponseHolder = new Holder<noattachment.holders.soapserver.ServiceResponse>()
        Holder<byte[]> myAttachmentHolder = new Holder<byte[]>()
        demoHoldersNoAttachmentClient.serviceMethod(3, myServiceResponseHolder, myAttachmentHolder)
        context = [soapResult:myServiceResponseHolder.value, attachment:myAttachmentHolder.value]
        break
      case 'noMIME':
        println "Using No-MIME Server"
        nomime.soapserver.ServiceMethodRequest myServiceMethodRequest = new nomime.soapserver.ServiceMethodRequest()
        myServiceMethodRequest.setIntA(6)
        Holder<nomime.soapserver.ServiceMethodResponse> myServiceMethodResponseHolder = new Holder<nomime.soapserver.ServiceMethodResponse>()
        Holder<byte[]> myAttachmentHolder = new Holder<byte[]>()
        demoNoMimeClient.serviceMethod(myServiceMethodRequest, myServiceMethodResponseHolder, myAttachmentHolder)
        context = [soapResult:myServiceMethodResponseHolder.value, attachment:myAttachmentHolder.value]
        break
      case 'MIME':
        println "Using MIME Server"
        mime.soapserver.ServiceMethodRequest myServiceMethodRequest = new mime.soapserver.ServiceMethodRequest()
        myServiceMethodRequest.setIntA(7)
        Holder<mime.soapserver.ServiceMethodResponse> myServiceMethodResponseHolder = new Holder<mime.soapserver.ServiceMethodResponse>()
        Holder<byte[]> myAttachmentHolder = new Holder<byte[]>()
        demoMimeClient.serviceMethod(myServiceMethodRequest, myServiceMethodResponseHolder, myAttachmentHolder)
        context = [soapResult:myServiceMethodResponseHolder.value.getResponse(), attachment:myAttachmentHolder.value]
        break
      default:
        break
    }
    
    return context
  }
}
