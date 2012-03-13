<html>
  <header></header>
  <body>
    <h1>${params.type ?: 'No SOAP Request Made'}</h1>
  
    SOAP Result: ${soapResult?.myInt} - ${soapResult?.myBool}
    <br />
    Attachment: ${new String(attachment?:'')}
    <hr />
    <a href="${createLink(params:[type:'MIME'])}">Request using MIME attachment</a><br /><br />
    <a href="${createLink(params:[type:'noMIME'])}">Request using Non-MIME attachment</a><br /><br />
    <a href="${createLink(params:[type:'holdersNoAttachment'])}">Request using Holders but no attachment</a><br /><br />
    <a href="${createLink(params:[type:'noHolders'])}">Request using No Holders</a><br /><br />
  </body>
</html>