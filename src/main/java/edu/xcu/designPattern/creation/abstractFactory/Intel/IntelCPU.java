package edu.xcu.designPattern.creation.abstractFactory.Intel;

import edu.xcu.designPattern.creation.abstractFactory.bean.CPU;

/**
 * @project: JavaThread
 * @description:
 * @author: dell
 * @date: 2020/7/31 - 10:32
 * @version: 1.0
 * @website:
 */

public class IntelCPU extends CPU {

    public IntelCPU(String name) {
        super.setName(name);
    }
}
