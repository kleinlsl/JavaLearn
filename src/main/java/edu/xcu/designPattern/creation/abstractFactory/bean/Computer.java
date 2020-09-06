package edu.xcu.designPattern.creation.abstractFactory.bean;

import lombok.Data;

/**
 * @project: JavaThread
 * @description:
 * @author: dell
 * @date: 2020/7/31 - 10:41
 * @version: 1.0
 * @website:
 */
@Data
public class Computer {
    private CPU cpu;
    private HardDisk hardDisk;
    private MainBoard mainBoard;

    public Computer(CPU cpu, MainBoard mainBoard, HardDisk hardDisk) {
        this.cpu=cpu;
        this.hardDisk=hardDisk;
        this.mainBoard=mainBoard;
    }
}
