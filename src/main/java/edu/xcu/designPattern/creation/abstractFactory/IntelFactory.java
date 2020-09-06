package edu.xcu.designPattern.creation.abstractFactory;

import edu.xcu.designPattern.creation.abstractFactory.Intel.IntelCPU;
import edu.xcu.designPattern.creation.abstractFactory.Intel.IntelHardDisk;
import edu.xcu.designPattern.creation.abstractFactory.Intel.IntelMainBoard;
import edu.xcu.designPattern.creation.abstractFactory.bean.CPU;
import edu.xcu.designPattern.creation.abstractFactory.bean.HardDisk;
import edu.xcu.designPattern.creation.abstractFactory.bean.MainBoard;

/**
 * Intel 品牌电脑工厂
 * @author: dell
 * @date: 2020/7/31 - 10:30
 */
public class IntelFactory implements ComputerFactory {
    private final String name = "Intel";
    public CPU makeCPU() {
        return new IntelCPU(name);
    }

    public MainBoard makeMainBoard() {
        return new IntelMainBoard(name);
    }

    public HardDisk makeHardDisk() {
        return new IntelHardDisk(name);
    }
}
