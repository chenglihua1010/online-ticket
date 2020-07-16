package com.ticket.utils;

import javax.annotation.PreDestroy;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by wwclr on 2019/3/7.
 */
public class ExecuterRegiste {
    private static AtomicInteger atomicInteger=new AtomicInteger(0);
    private static Map<Integer,ExecutorService> map=new ConcurrentHashMap<>(16);

    public ExecutorService getExecutor(ExecutorService executorService){
        map.put(atomicInteger.incrementAndGet(),executorService);
        return executorService;
    }
    @PreDestroy
    public void des(){
        Iterator<ExecutorService> iterable = map.values().iterator();
        while (iterable.hasNext()){
            iterable.next().shutdown();
        }
    }
}
