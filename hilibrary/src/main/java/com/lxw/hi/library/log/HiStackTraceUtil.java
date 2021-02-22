package com.lxw.hi.library.log;

/**
 * @authour
 * @function 堆栈信息裁剪工具类
 * @date 2021/2/19
 */
public class HiStackTraceUtil {

    public static StackTraceElement[] getCroppedRealStackTrack(StackTraceElement[] stackTrace
            , String ignorePackage, int maxDepth) {
        return cropStackTrace(getRealStackTrack(stackTrace, ignorePackage), maxDepth);
    }

    //裁剪最大的堆栈信息深度 （按照深度进行裁剪
    private static StackTraceElement[] cropStackTrace(StackTraceElement[] callStack
            , int maxDepth) {
        int realDepth = callStack.length;
        if (maxDepth > 0) {
            realDepth = Math.min(maxDepth, realDepth);
        }
        StackTraceElement[] realStack = new StackTraceElement[realDepth];
        System.arraycopy(callStack, 0, realStack, 0, realDepth);
        return realStack;
    }

    /**
     * 获取除忽略包外的真实的堆栈信息
     *
     * @param stackTrace
     * @param ignorePackage 要忽略的包名
     * @return
     */
    private static StackTraceElement[] getRealStackTrack(StackTraceElement[] stackTrace
            , String ignorePackage) {
        int ignoreDepth = 0;
        int allDepth = stackTrace.length;
        String className;
        for (int i = allDepth - 1; i >= 0; i--) {
            className = stackTrace[i].getClassName();
            if (ignorePackage != null && className.startsWith(ignorePackage)) {
                ignoreDepth = i + 1;
                break;
            }
        }
        int realDepth = allDepth - ignoreDepth;
        StackTraceElement[] realStack = new StackTraceElement[realDepth];
        System.arraycopy(stackTrace, ignoreDepth, realStack, 0, realDepth);
        return realStack;
    }
} 
