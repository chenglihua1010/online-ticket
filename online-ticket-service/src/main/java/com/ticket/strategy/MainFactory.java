package com.ticket.strategy;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by wangwu on 2020/8/10.
 */
public class MainFactory{
        private static Map<Class,BuyTicketInterface> map= Maps.newHashMap();

        static {
                map.put(LitterBoy.class,new LitterBoy());
                map.put(MediumMain.class,new MediumMain());
                map.put(OldMan.class,new OldMan());
        }

        public static BuyTicketInterface getInstance(Class clazz){
                return map.get(clazz);
        }
}
