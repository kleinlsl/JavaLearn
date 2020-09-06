package edu.xcu.designPattern.creation.abstractFactory.Amd;

import edu.xcu.designPattern.creation.abstractFactory.bean.MainBoard;

/**
 * @project: JavaThread
 * @description:
 * @author: dell
 * @date: 2020/7/31 - 10:35
 * @version: 1.0
 * @website:
 */
public class AmdMainBoard extends MainBoard {
    public AmdMainBoard(String name) {
        super.setName(name);
    }
}
