package com.ticket.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ticket.api.service.OrderListInerface;
import com.ticket.api.vo.OrderListVo;
import com.ticket.entity.OrderList;
import com.ticket.mapper.OrderListMapper;
import com.ticket.utils.BaseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import java.util.List;


@Service
public class OrderListImpl extends BaseService  implements OrderListInerface {
        @Autowired
        OrderListMapper orderListMapper;
        @Autowired
        RedisUtils redisUtils;

        /**
         * 添加订单
         * @param orderListVo
         */
        @Override
        public void addOrder(OrderListVo orderListVo) {
                OrderList orderList=transferObjectIgnoreCase(orderListVo,OrderList.class);
                orderListMapper.addOrder(orderList);
        }

        /**
         * 根据用户账号查询订单
         * @param user_phone_num 用户账号
         * @return 订单信息表
         */
        @Override
        public List<OrderListVo> selectOrderByUser_phone_num(String user_phone_num) {
                List<OrderList> orderLists=orderListMapper.selectOrderByUser_phone_num(user_phone_num);
                List<OrderListVo> orderListVos=getList(orderLists,OrderListVo.class);
                return orderListVos;
        }

        /**
         * 查询用户部分订单
         * @param user_phone_num 用户账号
         * @param order_status 订单状态
         * @return 订单信息表
         */
        @Override
        public List<OrderListVo> selectPartOrderByUser_phone_num(String user_phone_num, Integer order_status) {
                List<OrderList> orderLists;
//                orderLists=orderListMapper.selectPartOrderByUser_phone_num(user_phone_num,order_status);
                String order_statusString=order_status.toString();
                //建一个新的key（统一命名方式），通过和redis的已存的key比较，来判断orderList从那里获取值（redis\sql(mapper)）
//                String newkey=redisUtils.keyBuilder(user_phone_num,order_statusString);
//                String key=redisUtils.findName(newkey.toString());
                String userString=redisUtils.findName(user_phone_num.toString());
                if(StringUtils.isNotEmpty(userString)){
                        //redis得到的为Object,注意需要强转
                        orderLists=(List<OrderList>) redisUtils.get(userString);
                }else {
                        orderLists = orderListMapper.selectPartOrderByUser_phone_num(user_phone_num, order_status);
                        if (!ObjectUtils.isEmpty(orderLists)) {
                                redisUtils.set(user_phone_num.toString(), orderLists);
                        }
                }
                //当Vo类存在serialVersionUID时，需用下面方法进行类型转换 newInstace()--弱引用，仅调用无参构造函数，故目标类种需无参构造函数
//                List<OrderListVo> listVos=getList(orderLists,OrderListVo.class);
                List<OrderListVo> listVos=transferObjectIgnoreCaseList(orderLists,OrderListVo.class);

                return listVos;
        }
}