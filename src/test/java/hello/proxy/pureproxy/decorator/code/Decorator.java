package hello.proxy.pureproxy.decorator.code;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class Decorator {
    protected final Component target;
}
