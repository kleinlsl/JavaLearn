package edu.xcu.Enum;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @project: JavaThread
 * @description: 自定义枚举方法
 * @author: dell
 * @date: 2020/7/12 - 16:13
 * @version: 1.0
 * @website: https://snailclimb.gitee.io/javaguide/#/docs/java/basic/%E7%94%A8%E5%A5%BDJava%E4%B8%AD%E7%9A%84%E6%9E%9A%E4%B8%BE%E7%9C%9F%E7%9A%84%E6%B2%A1%E6%9C%89%E9%82%A3%E4%B9%88%E7%AE%80%E5%8D%95
 */

public class Pizza {
    private static EnumSet<PizzaStatus> undeliveredPizzaStatuses=
            EnumSet.of(PizzaStatus.ORDERED,PizzaStatus.READY);

    private PizzaStatus status;

    // TODO: 2020/7/12 定义内部枚举类
    public enum PizzaStatus{
        ORDERED (5){
            @Override
            public boolean isOrdered() {
                return true;
            }
        },
        READY(2){
            @Override
            public boolean isReady() {
                return true;
            }
        },
        DELIVERED(0){
            @Override
            public boolean isDelivered() {
                return true;
            }
        };

        private int timeToDelivery;

        public boolean isOrdered() {return false;}

        public boolean isReady() {return false;}

        public boolean isDelivered(){return false;}

        public int getTimeToDelivery() {
            return timeToDelivery;
        }

        PizzaStatus (int timeToDelivery) {
            this.timeToDelivery = timeToDelivery;
        }
    }

    public PizzaStatus getStatus() {
        return status;
    }

    public void setStatus(PizzaStatus status) {
        this.status = status;
    }

    // TODO: 2020/7/12 判断枚举类型是否相等的两种方法
    public boolean isDeliverable(){
        return this.status.isDelivered();
//        if (this.getStatus()==PizzaStatus.READY){
//            return true;
//        }
//        return false;
    }

    // TODO: 2020/7/12 枚举类型结合 switch 
    public int getDeliveryTimeInDays() {
        switch (this.status) {
            case ORDERED: return 5;
            case READY: return 2;
            case DELIVERED: return 0;
        }
        return 0;
    }

    // TODO: 2020/7/12 打印交货时间
    public void printTimeToDeliver() {
        System.out.println("Time to delivery is " +
                this.getStatus().getTimeToDelivery() + " days");
    }

    // TODO: 2020/7/12 获取所有的非 delivered 披萨
    public static List<Pizza> getAllUndeliveredPizzas(List<Pizza> pizzas){
        return pizzas.stream().filter(
                /**
                 * 自己写的第一个匿名函数
                 */
                (s)-> (
                    undeliveredPizzaStatuses.contains(s.getStatus())
                )
        ).collect(Collectors.toList());
    }

    // TODO: 2020/7/12 通过披萨状态分组
    public static EnumMap<PizzaStatus, List<Pizza>>
            groupPizzaByStatus(List<Pizza> pizzaList) {

//        EnumMap<PizzaStatus, List<Pizza>> pzByStatus =
//                new EnumMap<PizzaStatus, List<Pizza>>(PizzaStatus.class);
//
//        for (Pizza pz : pizzaList) {
//            PizzaStatus status = pz.getStatus();
//            if (pzByStatus.containsKey(status)) {
//                pzByStatus.get(status).add(pz);
//            } else {
//                List<Pizza> newPzList = new ArrayList<Pizza>();
//                newPzList.add(pz);
//                pzByStatus.put(status, newPzList);
//            }
//        }
//        return pzByStatus;
        EnumMap<PizzaStatus,List<Pizza>> map=pizzaList.stream().collect(
                Collectors.groupingBy(
                        Pizza::getStatus,
                        ()->(
                                new EnumMap<>(PizzaStatus.class)
                        ),
                        Collectors.toList()
                )
        );
        return map;
    }

    // TODO: 2020/7/12 披萨配送策略 
    public enum PizzaDeliveryStrategy {
        EXPRESS {
            @Override
            public void deliver(Pizza pz) {
                System.out.println("Pizza will be delivered in express mode");
            }
        },
        NORMAL {
            @Override
            public void deliver(Pizza pz) {
                System.out.println("Pizza will be delivered in normal mode");
            }
        };

        public abstract void deliver(Pizza pz);
    }

    // TODO: 2020/7/12 单例模式 
    public enum PizzaDeliverySystemConfiguration {
        INSTANCE;
        PizzaDeliverySystemConfiguration() {
            // Initialization configuration which involves
            // overriding defaults like delivery strategy
        }

        private PizzaDeliveryStrategy deliveryStrategy = PizzaDeliveryStrategy.NORMAL;

        public static PizzaDeliverySystemConfiguration getInstance() {
            return INSTANCE;
        }

        public PizzaDeliveryStrategy getDeliveryStrategy() {
            return deliveryStrategy;
        }
    }

    // TODO: 2020/7/12 更改披萨状态为已交付
    public void deliver() {
        if (!isDeliverable()) {
            PizzaDeliverySystemConfiguration.getInstance().getDeliveryStrategy()
                    .deliver(this);
            this.setStatus(PizzaStatus.DELIVERED);
        }
    }



}
