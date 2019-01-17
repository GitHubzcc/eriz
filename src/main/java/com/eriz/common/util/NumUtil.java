package com.eriz.common.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.NumberFormat;

/**
 * number类型转换.
 * 
 * 2018年12月11日 eriz
 *
 */
public final class NumUtil {

	/**
	 * 将对象转换为byte类型.
	 * 
	 * @param text
	 *            待转换对象
	 * @return
	 */
	public static Byte parseByte(Object text) {
		return ObjectUtil.isEmptyOrNull(text) ? null : parseNumber(text, Byte.class);
	}

	/**
	 * 将对象转换为short类型.
	 * 
	 * @param text
	 *            待转换对象
	 * @return
	 */
	public static Short parseShort(Object text) {
		return ObjectUtil.isEmptyOrNull(text) ? null : parseNumber(text, Short.class);
	}

	/**
	 * 将对象转换为int类型.
	 * 
	 * @param text
	 *            待转换对象
	 * @return
	 */
	public static Integer parseInt(Object text) {
		return ObjectUtil.isEmptyOrNull(text) ? null : parseNumber(text, Integer.class);
	}

	/**
	 * 将对象转换为long类型.
	 * 
	 * @param text
	 *            待转换对象
	 * @return
	 */
	public static Long parseLong(Object text) {
		return ObjectUtil.isEmptyOrNull(text) ? null : parseNumber(text, Long.class);
	}

	/**
	 * 将对象转换为BigInteger类型.
	 * 
	 * @param text
	 *            待转换对象
	 * @return
	 */
	public static BigInteger parseBigInteger(Object text) {
		return ObjectUtil.isEmptyOrNull(text) ? null : parseNumber(text, BigInteger.class);
	}

	/**
	 * 将对象转换为float类型.
	 * 
	 * @param text
	 *            待转换对象
	 * @return
	 */
	public static Float parseFloat(Object text) {
		return ObjectUtil.isEmptyOrNull(text) ? null : parseNumber(text, Float.class);
	}

	/**
	 * 将对象转换为double类型.
	 * 
	 * @param text
	 *            待转换对象
	 * @return
	 */
	public static Double parseDouble(Object text) {
		return ObjectUtil.isEmptyOrNull(text) ? null : parseNumber(text, Double.class);
	}

	/**
	 * 将对象转换为BigDecimal类型.
	 * 
	 * @param text
	 *            待转换对象
	 * @return
	 */
	public static BigDecimal parseBigDecimal(Object text) {
		return ObjectUtil.isEmptyOrNull(text) ? null : parseNumber(text, BigDecimal.class);
	}

	@SuppressWarnings("unchecked")
	private static <T extends Number> T parseNumber(Object obj, Class<T> targetClass) {

		String text = String.valueOf(obj);

		if (targetClass.equals(Byte.class)) {
			return (T) (isHexNumber(text) ? Byte.decode(text) : Byte.valueOf(text));
		} else if (targetClass.equals(Short.class)) {
			return (T) (isHexNumber(text) ? Short.decode(text) : Short.valueOf(text));
		} else if (targetClass.equals(Integer.class)) {
			return (T) (isHexNumber(text) ? Integer.decode(text) : Integer.valueOf(text));
		} else if (targetClass.equals(Long.class)) {
			return (T) (isHexNumber(text) ? Long.decode(text) : Long.valueOf(text));
		} else if (targetClass.equals(BigInteger.class)) {
			return (T) (isHexNumber(text) ? decodeBigInteger(text) : new BigInteger(text));
		} else if (targetClass.equals(Float.class)) {
			return (T) Float.valueOf(text);
		} else if (targetClass.equals(Double.class)) {
			return (T) Double.valueOf(text);
		} else if (targetClass.equals(BigDecimal.class) || targetClass.equals(Number.class)) {
			return (T) new BigDecimal(text);
		} else {
			throw new IllegalArgumentException(
					"Cannot convert String [" + text + "] to target class [" + targetClass.getName() + "]");
		}
	}

	private static boolean isHexNumber(String value) {
		int index = (value.startsWith("-") ? 1 : 0);
		return (value.startsWith("0x", index) || value.startsWith("0X", index) || value.startsWith("#", index));
	}

	private static BigInteger decodeBigInteger(String value) {
		int radix = 10;
		int index = 0;
		boolean negative = false;

		// Handle minus sign, if present.
		if (value.startsWith("-")) {
			negative = true;
			index++;
		}

		// Handle radix specifier, if present.
		if (value.startsWith("0x", index) || value.startsWith("0X", index)) {
			index += 2;
			radix = 16;
		} else if (value.startsWith("#", index)) {
			index++;
			radix = 16;
		} else if (value.startsWith("0", index) && value.length() > 1 + index) {
			index++;
			radix = 8;
		}

		BigInteger result = new BigInteger(value.substring(index), radix);
		return (negative ? result.negate() : result);
	}

	/**
	 * @param top @param: @param
	 */
	public static String percentageCalculation(double top, double below) {
		if (top == 0 || below == 0) {
			return "--";
		} else if (top >= below) {
			return "100.00";
		}
		// 创建一个数值格式化对象
		NumberFormat numberFormat = NumberFormat.getInstance();
		// 设置精确到小数点后2位
		numberFormat.setMaximumFractionDigits(2);
		String result = numberFormat.format((float) top / (float) below * 100);
		return result;
	}

	/**
	 *
	 * top @param: below @param: floatNum
	 * 保留小数点位数 @param: @return @return: double @throws
	 */
	public static String percentageCalculation(double top, double below, int floatNum) {
		if (top == 0 || below == 0) {
			return "--";
		}
		// 创建一个数值格式化对象
		NumberFormat numberFormat = NumberFormat.getInstance();
		// 设置精确到小数点后2位
		numberFormat.setMaximumFractionDigits(floatNum);
		String result = numberFormat.format((float) top / (float) below * 100);
		// return Double.parseDouble(result);
		return result;
	}

	/**
	 * 返回百分比数，89.77%
	 * 
	 * @param top
	 *            分子
	 * @param below
	 *            分母
	 * @param floatNum
	 *            保留小数点位数
	 */
	public static String percentCalculation(double top, double below, int floatNum) {
		if ("".equals(top) || "".equals(below) || top == 0 || below == 0) {
			return "--";
		} else if (top >= below) {
			return "100.00%";
		}

		// 创建一个数值格式化对象
		NumberFormat numberFormat = NumberFormat.getInstance();
		// 设置精确到小数点后2位
		numberFormat.setMaximumFractionDigits(floatNum);

		return numberFormat.format((float) top / (float) below * 100) + "%";
	}
}