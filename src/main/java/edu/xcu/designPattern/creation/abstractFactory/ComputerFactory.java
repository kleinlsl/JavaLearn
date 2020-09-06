package edu.xcu.designPattern.creation.abstractFactory;

import edu.xcu.designPattern.creation.abstractFactory.bean.CPU;
import edu.xcu.designPattern.creation.abstractFactory.bean.HardDisk;
import edu.xcu.designPattern.creation.abstractFactory.bean.MainBoard;

/**
 * 电脑抽象工厂接口，不同品牌商可实现该接口
 * @author: dell
 * @date: 2020/7/31 - 10:17
 */
public interface ComputerFactory {
    CPU makeCPU();
    MainBoard makeMainBoard();
    HardDisk makeHardDisk();
}
