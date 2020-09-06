package edu.xcu.Enum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @project: JavaThread
 * @description:
 * @author: dell
 * @date: 2020/7/12 - 16:17
 * @version: 1.0
 * @website:
 */
public class PizzaTest {
    private Pizza pizza;
    @Before
    public void init(){
        System.out.println("单元测试开始");
        pizza=new Pizza();
        pizza.setStatus(Pizza.PizzaStatus.READY);
    }

    @After
    public void after(){
        System.out.println("单元测试结束！");
    }

    @Test
    public void isDeliverable() {
        boolean b=pizza.isDeliverable();
        System.out.println(b);
    }

    @Test
    public void getDeliveryTimeInDays() {
        int res=pizza.getDeliveryTimeInDays();
        System.out.println(res);
    }

    @Test
    public void givenPizaOrder_whenReady_thenDeliverable() {
        Pizza testPz = new Pizza();
        testPz.setStatus(Pizza.PizzaStatus.DELIVERED);
        assertTrue(testPz.isDeliverable());
    }

    @Test
    public void printTimeToDeliver() {
        pizza.printTimeToDeliver();
    }

    @Test
    public void getAllUndeliveredPizzas() {
        List<Pizza> pzList = new ArrayList<>();
        Pizza pz1 = new Pizza();
        pz1.setStatus(Pizza.PizzaStatus.DELIVERED);

        Pizza pz2 = new Pizza();
        pz2.setStatus(Pizza.PizzaStatus.ORDERED);

        Pizza pz3 = new Pizza();
        pz3.setStatus(Pizza.PizzaStatus.ORDERED);

        Pizza pz4 = new Pizza();
        pz4.setStatus(Pizza.PizzaStatus.READY);

        pzList.add(pz1);
        pzList.add(pz2);
        pzList.add(pz3);
        pzList.add(pz4);

        List<Pizza> resList=Pizza.getAllUndeliveredPizzas(pzList);
        assertEquals(3, resList.size());
    }

    @Test
    public void givenPizaOrders_whenGroupByStatusCalled_thenCorrectlyGrouped() {
        List<Pizza> pzList = new ArrayList<>();
        Pizza pz1 = new Pizza();
        pz1.setStatus(Pizza.PizzaStatus.DELIVERED);

        Pizza pz2 = new Pizza();
        pz2.setStatus(Pizza.PizzaStatus.ORDERED);

        Pizza pz3 = new Pizza();
        pz3.setStatus(Pizza.PizzaStatus.ORDERED);

        Pizza pz4 = new Pizza();
        pz4.setStatus(Pizza.PizzaStatus.READY);

        pzList.add(pz1);
        pzList.add(pz2);
        pzList.add(pz3);
        pzList.add(pz4);

        EnumMap<Pizza.PizzaStatus,List<Pizza>> map = Pizza.groupPizzaByStatus(pzList);
        assertTrue(map.get(Pizza.PizzaStatus.DELIVERED).size() == 1);
        assertTrue(map.get(Pizza.PizzaStatus.ORDERED).size() == 2);
        assertTrue(map.get(Pizza.PizzaStatus.READY).size() == 1);
    }

    @Test
    public void givenPizaOrder_whenDelivered_thenPizzaGetsDeliveredAndStatusChanges() {
        Pizza pz = new Pizza();
        pz.setStatus(Pizza.PizzaStatus.READY);
        pz.deliver();
        assertSame(pz.getStatus(), Pizza.PizzaStatus.DELIVERED);
    }


}