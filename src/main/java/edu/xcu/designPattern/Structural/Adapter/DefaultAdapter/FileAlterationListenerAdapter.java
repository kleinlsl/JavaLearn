package edu.xcu.designPattern.Structural.Adapter.DefaultAdapter;

import org.apache.commons.io.monitor.FileAlterationObserver;

import java.io.File;

/**
 * 适配器 ： 所有方法为空方法
 * @author: dell
 * @date: 2020/8/1 - 10:29
 */
public class FileAlterationListenerAdapter implements FileAlterationListener {
    @Override
    public void onStart(FileAlterationObserver observer) {

    }

    @Override
    public void onDirectoryCreate(File directory) {

    }

    @Override
    public void onDirectoryChange(File directory) {

    }

    @Override
    public void onDirectoryDelete(File directory) {

    }

    @Override
    public void onFileCreate(File file) {

    }

    @Override
    public void onFileChange(File file) {

    }

    @Override
    public void onFileDelete(File file) {

    }

    @Override
    public void onStop(FileAlterationObserver observer) {

    }
}
