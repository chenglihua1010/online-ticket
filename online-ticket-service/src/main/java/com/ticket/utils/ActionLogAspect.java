package com.ticket.utils;

import com.alibaba.fastjson.JSONObject;
import com.ticket.entity.DaoExecuteLog;
import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by wangwu on 2020/8/5.
 */
public class ActionLogAspect extends ContextUtils{
        private final static Logger log = LoggerFactory.getLogger(ActionLogAspect.class);


        public void before(JoinPoint joinPoint)throws IOException {
                System.out.println("=================开始捕捉日志=========================");
                WriteToLog(joinPoint);
        }


        /**
         * 后置通知（无论方法是否发生异常都会执行,所以访问不到方法的返回值）
         */
        public void after(JoinPoint joinPoint)throws IOException {
                //WriteToLog(joinPoint);
        }
        //把信息写进日志里面
        public void WriteToLog(JoinPoint joinPoint)throws IOException {
                HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.
                                getRequestAttributes()).getRequest();
                //获取方法名
                String cla=joinPoint.getTarget().getClass().getName();//action
                String method=joinPoint.getSignature().getName();//method
                //获取操作人
                //HttpSession session = request.getSession();
                //Manager manager = (Manager) session.getAttribute("SESSION_MANAGER");
                //Integer userid=null;
                //String username="";
                //if(manager!=null){
                //        userid = manager.getId();
                //        username =manager.getUsername();
                //}
                StringBuffer json=new StringBuffer();//获取请求参数
                Enumeration<String> names = request.getParameterNames();
                while(names.hasMoreElements()){
                        //获取每一个文本域的name
                        String name = names.nextElement();
                        String [] values = request.getParameterValues(name);
                        if(values!=null && values.length>0){
                                //输出参数名和参数值
                                json.append(name+":{");
                                for(String val:values){
                                        json.append(val+",");
                                }
                                if (','==json.charAt(json.length()-1)) json.deleteCharAt(json.length()-1);
                                json.append("},");
                        }
                }
                if (json!=null && json.length()>0 && ','==json.charAt(json.length()-1)) json.deleteCharAt(json.length()-1);
                //log.debug("{method:{"+cla+"."+method+"}, params:{"+json.toString()+"},user:{id:"+userid+",username:"+username+"}}");
                log.info("{method:{"+cla+"."+method+"}, params:{"+json.toString()+"},user:{id:"+null+",username:"+null+"}}");
                DaoExecuteLog daoExecuteLog=new DaoExecuteLog();
                daoExecuteLog.setMethodId(method);
                daoExecuteLog.setServiceId(cla);
                map.put("daoExecuteLog",daoExecuteLog);
                context.set(map);
                log.info("context value=[{}]", JSONObject.toJSONString(context.get()));

        }
}
