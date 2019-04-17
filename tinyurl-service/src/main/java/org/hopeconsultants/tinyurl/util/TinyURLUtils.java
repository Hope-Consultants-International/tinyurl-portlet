package org.hopeconsultants.tinyurl.util;

public class TinyURLUtils {

	public static String generateCode(long tinyURLId) {
		return Base58Util.encode(tinyURLId);
	}

	public static long getTinyURLId(String code)
		throws NumberFormatException {

		return Base58Util.decodeAsLong(code);
	}

}
