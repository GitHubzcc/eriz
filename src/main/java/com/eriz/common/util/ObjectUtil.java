package com.eriz.common.util;

/**
 * 字符串工具类.
 *
 * 2018年12月11日 eriz
 */
public final class ObjectUtil {

    /**
     * 判断两个对象的值是否相等.<br/>
     * objc1=null 与 obj2=null 返回 true<br/>
     * objc1=null 与 obj2="" 返回 false<br/>
     * objc1=null 与 obj2="&nbsp;&nbsp;&nbsp;" 返回 false<br/>
     * objc1="" 与 obj2="&nbsp;&nbsp;&nbsp;" 返回 true<br/>
     *
     * @param obj1 第一个对比对象
     * @param obj2 第二个对比对象
     * @return
     */
    public static boolean isEquals(Object obj1, Object obj2) {
        if (!isNull(obj1) && !isNull(obj2)) {
            if (String.valueOf(obj1).trim().equals(String.valueOf(obj2).trim())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 去除object的前后空格.
     *
     * @param obj 被去除空格的对象
     * @return 如果 obj=null，则返回 ""
     */
    public static String trim(Object obj) {
        return isEmptyOrNull(obj) ? "" : String.valueOf(obj).trim();
    }

    /**
     * 判断是否为NULL.<br/>
     * str = null 返回 true, 否则 false<br/>
     *
     * @param str 被判断的字符串
     * @return
     */
    public static boolean isNull(Object str) {
        return str == null ? true : false;
    }

    /**
     * 判断是否空字符串.<br/>
     * str = "" 或者 str = "&nbsp;&nbsp;" 返回 true, 否则 false<br/>
     *
     * @param str 被判断的字符串
     * @return
     */
    public static boolean isEmpty(Object str) {
        return (!isNull(str) && str.toString().trim().length() == 0) ? true : false;
    }

    /**
     * 判断是否只包含空格或者Null值.<br/>
     * str = "" 或者 str = "&nbsp;&nbsp;" 或者 str = null 返回 true, 否则 false<br/>
     *
     * @param str 被判断的字符串
     * @return
     */
    public static boolean isEmptyOrNull(Object str) {
        return isNull(str) || isEmpty(str);
    }

}
