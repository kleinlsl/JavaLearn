package edu.xcu.designPattern.creation.abstractFactory;

import edu.xcu.designPattern.creation.abstractFactory.bean.CPU;
import edu.xcu.designPattern.creation.abstractFactory.bean.Computer;
import edu.xcu.designPattern.creation.abstractFactory.bean.HardDisk;
import edu.xcu.designPattern.creation.abstractFactory.bean.MainBoard;

/**
 * @author: dell
 * @date: 2020/7/31 - 10:39
 */
public class App {
    public static void main(String[] args) {
        ComputerFactory cf=new IntelFactory();

        CPU cpu=cf.makeCPU();
        MainBoard mainBoard=cf.makeMainBoard();
        HardDisk hardDisk=cf.makeHardDisk();

        Computer computer=new Computer(cpu,mainBoard,hardDisk);
        System.out.println(computer);
    }
}

