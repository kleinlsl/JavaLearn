package edu.xcu.designPattern.creation.abstractFactory.Amd;

import edu.xcu.designPattern.creation.abstractFactory.bean.CPU;

/**
 * @project: JavaThread
 * @description:
 * @author: dell
 * @date: 2020/7/31 - 10:32
 * @version: 1.0
 * @website:
 */

public class AmdCPU extends CPU {

    public AmdCPU(String name) {
        super.setName(name);
    }
}
