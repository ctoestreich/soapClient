package mime.soapserver


import java.util.List;

import javax.xml.ws.Holder;

import org.apache.cxf.helpers.CastUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Exchange;
import org.apache.cxf.message.Message;
import org.apache.cxf.message.MessageContentsList;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.service.model.BindingOperationInfo;
import org.apache.cxf.service.model.MessagePartInfo;
import org.apache.cxf.service.model.OperationInfo;
import org.apache.cxf.jaxws.interceptors.HolderInInterceptor;

public class CustomInInterceptor extends AbstractPhaseInterceptor<Message> {

    public static final String CLIENT_HOLDERS = "client.holders";

    public CustomInInterceptor() {
        super(Phase.PRE_INVOKE);
        getBefore().add(HolderInInterceptor.class.getName());
    }

    public void handleMessage(Message message) throws Fault {
        MessageContentsList inObjects = MessageContentsList.getContentsList(message);

        Exchange exchange = message.getExchange();
        BindingOperationInfo bop = exchange.getBindingOperationInfo();
        if (bop == null) {
            return;
        }
        OperationInfo op = bop.getOperationInfo();
        if (op == null || !op.hasOutput() || op.getOutput().size() == 0) {
            return;
        }

        List<MessagePartInfo> parts = op.getOutput().getMessageParts();

        boolean client = Boolean.TRUE.equals(message.get(Message.REQUESTOR_ROLE));
        if (client) {
            List<Holder> outHolders = CastUtils.cast((List)message.getExchange()
                    .getOutMessage().get(CLIENT_HOLDERS));
            for (MessagePartInfo part : parts) {
                if (part.getIndex() != 0 && part.getTypeClass() != null) {
                    @SuppressWarnings("unchecked")
                    Holder<Object> holder = (Holder<Object>)outHolders.get(part.getIndex() - 1);
                    if (holder != null && part.getIndex() < inObjects.size()) {
                        holder.value = inObjects.get(part);
                        inObjects.put(part, holder);
                    }
                }
            }
        } else {
            for (MessagePartInfo part : parts) {
                int idx = part.getIndex() - 1;
                if (idx >= 0 && part.getTypeClass() != null) {
                    if (inObjects == null) {
                        //if soap:body is empty, the contents may not exist
                        //so we need to create a contents list to store
                        //the holders for the outgoing parts (CXF-4031)
                        inObjects = new MessageContentsList();
                        message.setContent(List.class, inObjects);
                    }
                    if (idx >= inObjects.size()) {
                        inObjects.set(idx, new Holder<Object>());
                    } else {
                        Object o = inObjects.get(idx);
                        inObjects.set(idx, new Holder<Object>(o));
                    }
                }
            }
        }
    }
}
