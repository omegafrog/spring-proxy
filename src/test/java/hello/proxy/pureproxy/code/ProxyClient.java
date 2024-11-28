package hello.proxy.pureproxy.code;

public class ProxyClient {

    private final Subject subject;

    public ProxyClient(Subject subject) {
        this.subject = subject;
    }

    public void execute(){
        subject.logic();
    }
}
