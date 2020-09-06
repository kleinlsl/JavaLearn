package edu.xcu.designPattern.Structural.Adapter.DefaultAdapter;

import java.io.File;

/**
 * @project: JavaThread
 * @description:
 * @author: dell
 * @date: 2020/8/1 - 10:32
 * @version: 1.0
 * @website:
 */
public class FileMonitor extends FileAlterationListenerAdapter {
    @Override
    public void onFileCreate(File file) {
        System.out.println(
                "doSomething()"
        );
    }

    @Override
    public void onFileDelete(File file) {
        System.out.println(
                "doSomething()"
        );
    }
}
