Start up the 4 SOAP servers, each has a Readme.txt with the command needed to start up the server.

Run the application us usual using:
> grails run-app

Go to: http://localhost:8080/soapClient/client/index

There are 4 example SOAP servers available.  The 2 that use attachments produce the following error:
1 Still uses holders but not an attachment and it works successfully.
The last one does not use holders or attachments and is just for another point of reference.

The simple SOAP request/response fails with:
2012-03-09 10:42:20,114 [http-8080-1] ERROR client.WebServiceClientFactoryImpl  - Index: 3, Size: 3
2012-03-09 10:42:20,131 [http-8080-1] ERROR errors.GrailsExceptionResolver  - Exception occurred when processing request: [GET] /soapClient/client/index
Stacktrace follows:
java.lang.IndexOutOfBoundsException: Index: 3, Size: 3
        at java.util.ArrayList.RangeCheck(ArrayList.java:547)
        at java.util.ArrayList.get(ArrayList.java:322)
        at org.apache.cxf.message.MessageContentsList.get(MessageContentsList.java:79)
        at org.apache.cxf.jaxws.interceptors.HolderInInterceptor.handleMessage(HolderInInterceptor.java:65)
        at org.apache.cxf.phase.PhaseInterceptorChain.doIntercept(PhaseInterceptorChain.java:247)
        at org.apache.cxf.endpoint.ClientImpl.onMessage(ClientImpl.java:733)
        at org.apache.cxf.transport.http.HTTPConduit$WrappedOutputStream.handleResponseInternal(HTTPConduit.java:2201)
        at org.apache.cxf.transport.http.HTTPConduit$WrappedOutputStream.handleResponse(HTTPConduit.java:2071)
        at org.apache.cxf.transport.http.HTTPConduit$WrappedOutputStream.close(HTTPConduit.java:1925)
        at org.apache.cxf.transport.AbstractConduit.close(AbstractConduit.java:56)
        at org.apache.cxf.transport.http.HTTPConduit.close(HTTPConduit.java:662)
        at org.apache.cxf.interceptor.MessageSenderInterceptor$MessageSenderEndingInterceptor.handleMessage(MessageSenderInterceptor.java:62)
        at org.apache.cxf.phase.PhaseInterceptorChain.doIntercept(PhaseInterceptorChain.java:247)
        at org.apache.cxf.endpoint.ClientImpl.invoke(ClientImpl.java:516)
        at org.apache.cxf.endpoint.ClientImpl.invoke(ClientImpl.java:313)
        at org.apache.cxf.endpoint.ClientImpl.invoke(ClientImpl.java:265)
        at org.apache.cxf.frontend.ClientProxy.invokeSync(ClientProxy.java:73)
        at org.apache.cxf.jaxws.JaxWsClientProxy.invoke(JaxWsClientProxy.java:124)
        at $Proxy43.serviceMethod(Unknown Source)
        at java_lang_reflect_Method$invoke.call(Unknown Source)
        at com.grails.cxf.client.WebServiceClientFactoryImpl$WSClientInvocationHandler.invoke(WebServiceClientFactoryImpl.groovy:264)
        at $Proxy19.serviceMethod(Unknown Source)
        at soapserver.TestService$serviceMethod.call(Unknown Source)
        at soapclient.ClientController$_closure1.doCall(ClientController.groovy:15)
        at soapclient.ClientController$_closure1.doCall(ClientController.groovy)
        at java.lang.Thread.run(Thread.java:662)
