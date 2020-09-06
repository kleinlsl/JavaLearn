package edu.xcu.Thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @project: JavaThread
 * @description:
 * @author: dell
 * @date: 2020/7/12 - 10:00
 * @version: 1.0
 * @website: https://snailclimb.gitee.io/javaguide-interview/#/./docs/b-3Java%E5%A4%9A%E7%BA%BF%E7%A8%8B?id=_231-%e4%bb%80%e4%b9%88%e6%98%af%e7%ba%bf%e7%a8%8b%e5%92%8c%e8%bf%9b%e7%a8%8b
 */
public class MultiThread {
    public static void main(String[] args) {
        ThreadMXBean threadMXBean= ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos=threadMXBean.dumpAllThreads(false,false);
        for (ThreadInfo threadInfo:threadInfos){
            System.out.println("["+threadInfo.getThreadId()+"] "+threadInfo.getThreadName());
        }
    }
}
