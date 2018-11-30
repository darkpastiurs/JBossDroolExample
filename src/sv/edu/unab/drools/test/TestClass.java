package sv.edu.unab.drools.test;

import org.drools.core.event.DebugAgendaEventListener;
import org.drools.core.event.DebugRuleRuntimeEventListener;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import sv.edu.unab.drools.message.Message;

import java.util.ArrayList;
import java.util.List;

public class TestClass {

    public static void main(String[] args) {
        try {
            KieServices ks = KieServices.Factory.get();
            KieContainer kc = ks.getKieClasspathContainer();
            execute(kc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void execute(KieContainer kc) throws Exception{
        KieSession kieSession = kc.newKieSession("TestKS");
        final List<Message> messages = new ArrayList<>();
        kieSession.setGlobal("messages", messages);
        kieSession.addEventListener(new DebugAgendaEventListener());
        kieSession.addEventListener(new DebugRuleRuntimeEventListener());
        final Message mensaje = new Message();
        mensaje.setType("Hello");
        kieSession.insert(mensaje);
        kieSession.fireAllRules();
        kieSession.dispose();
        messages.forEach(m -> System.out.println(m.getType()));
    }
}
