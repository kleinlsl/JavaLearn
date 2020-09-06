package edu.xcu.designPattern.creation.abstractFactory.Intel;

import edu.xcu.designPattern.creation.abstractFactory.bean.HardDisk;

/**
 * @project: JavaThread
 * @description:
 * @author: dell
 * @date: 2020/7/31 - 10:35
 * @version: 1.0
 * @website:
 */
public class IntelHardDisk extends HardDisk {
    public IntelHardDisk(String name) {
        super.setName(name);
    }
}
