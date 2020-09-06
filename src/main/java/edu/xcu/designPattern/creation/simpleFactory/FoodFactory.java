package edu.xcu.designPattern.creation.simpleFactory;

import edu.xcu.designPattern.creation.Food;

/**
 * @author: dell
 * @date: 2020/7/31 - 9:46
 */
public class FoodFactory {

    /**
     * 根据食物名称，制作食物
     * @param name
     * @return
     */
    public static Food makeFood(String name){
        if("noodle".equals(name)){
            Food noodle=new LanZhouNoodle();
            noodle.setSpicy("more");
            return noodle;
        }
        else if ("chicken".equals(name)){
            Food chicken = new HuangMenChicken();
            chicken.setSpicy("potato");
            return chicken;
        }
        else {
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(
                FoodFactory.makeFood("noodle").toString()
        );
        System.out.println(
            FoodFactory.makeFood("chicken").toString()
        );
    }
}
