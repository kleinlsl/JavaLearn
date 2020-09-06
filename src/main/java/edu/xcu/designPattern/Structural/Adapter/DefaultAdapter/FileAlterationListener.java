package edu.xcu.designPattern.Structural.Adapter.DefaultAdapter;

import org.apache.commons.io.monitor.FileAlterationObserver;

import java.io.File;

/**
 * @author: dell
 * @date: 2020/8/1 - 10:26
 */
public interface FileAlterationListener {
    void onStart(final FileAlterationObserver observer);
    void onDirectoryCreate(final File directory);
    void onDirectoryChange(final File directory);
    void onDirectoryDelete(final File directory);
    void onFileCreate(final File file);
    void onFileChange(final File file);
    void onFileDelete(final File file);
    void onStop(final FileAlterationObserver observer);
}
