package com.reactor.signlethread;

import java.io.IOException;
import java.nio.channels.SelectionKey;

/**
 * @author sh
 */
public interface EventHandler {

    /**
     * 处理事件
     * @param key
     * @throws IOException
     */
    void handlerEvent(SelectionKey key) throws IOException;
}
