package edu.xcu.designPattern.creation.abstractFactory;

import edu.xcu.designPattern.creation.abstractFactory.Amd.AmdCPU;
import edu.xcu.designPattern.creation.abstractFactory.Amd.AmdHardDisk;
import edu.xcu.designPattern.creation.abstractFactory.Amd.AmdMainBoard;
import edu.xcu.designPattern.creation.abstractFactory.bean.CPU;
import edu.xcu.designPattern.creation.abstractFactory.bean.HardDisk;
import edu.xcu.designPattern.creation.abstractFactory.bean.MainBoard;

/**
 * Amd 品牌电脑工厂
 * @author: dell
 * @date: 2020/7/31 - 10:36
 */
public class AmdFactory implements ComputerFactory {
    private final String name = "Intel";
    public CPU makeCPU() {
        return new AmdCPU(name);
    }

    public MainBoard makeMainBoard() {
        return new AmdMainBoard(name);
    }

    public HardDisk makeHardDisk() {
        return new AmdHardDisk(name);
    }
}
