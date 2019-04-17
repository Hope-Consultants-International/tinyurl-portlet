/**
 * Copyright (C) 2016 Hope Consultants International. All rights reserved.
 */

package org.hopeconsultants.tinyurl.util;

import com.liferay.petra.string.StringPool;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.UUID;

public class Base58Util {

	/**
	 * Decodes a base58 encoded string.
	 * @param  encoded	the base58 encoded string
	 * @return          the integer value; the value will be truncated to the capacity of a long.
	 */
	public static long decodeAsLong(String encoded)
		throws NumberFormatException {

		byte[] decoded = decodeAsBytes(encoded);

		ByteBuffer bb =
			ByteBuffer.allocate(Math.max(_LONG_BYTES, decoded.length));

		// If the decoded value is shorter than a long, prepend with zeros.

		if (decoded.length < _LONG_BYTES) {
			bb.put(new byte[_LONG_BYTES - decoded.length]);
		}

		bb.put(decoded).flip();

		// If the decoded value is one byte longer than a long, assume it came
		// from encoding a negative integer: strip the byte that was prepended.

		if (decoded.length == (_LONG_BYTES + 1)) {
			bb.get();
		}

		return bb.getLong();
	}

	/**
	 * Decodes a base58 encoded string
	 * @param  encoded	the base58 encoded string
	 * @return          byte array containing the resulting integer value
	 * @throws NumberFormatException if the string is invalid.
	 */
	public static byte[] decodeAsBytes(String encoded)
		throws NumberFormatException {

		byte[] bytes = encoded.getBytes();

		BigInteger decoded = BigInteger.ZERO;

		for (int i = 0; i < bytes.length; i++) {
			int digit = _DECODE_TABLE[bytes[i]];

			if (digit < 0) {
				throw new NumberFormatException(
					"Invalid base58 value: " + encoded);
			}

			decoded = decoded.multiply(_BASE).add(BigInteger.valueOf(digit));
		}

		return decoded.toByteArray();
	}

	/**
	 * Encodes an integer as a base58 string.
	 * @param value  integer value to encode.
	 * @return       the base58 encoded string.
	 */
	public static String encode(long intValue) {
		ByteBuffer bb = ByteBuffer.allocate(_LONG_BYTES);

		bb.putLong(intValue);

		return encode(bb.array());
	}

	/**
	 * Encodes byte array as a base58 string.
	 * @param bytes  the value to encode.
	 * @return       the base58 encoded string.
	 */
	public static String encode(byte[] bytes) {
		if (bytes.length == 0) {
			return StringPool.BLANK;
		}

		// Prepend a zero so that the resulting BigInteger is non-negative.

		if (bytes[0] < 0) {
			byte[] padded = new byte[bytes.length + 1];
			System.arraycopy(bytes, 0, padded, 1, bytes.length);
			bytes = padded;
		}

		// Use BigInteger because JVM <=7 has no facility to handle long overflow!

		BigInteger remaining = new BigInteger(bytes);

		if (remaining.equals(BigInteger.ZERO)) {
			return String.valueOf(_ENCODE_TABLE[0]);
		}

		StringBuilder encoded = new StringBuilder();

		while (remaining.compareTo(BigInteger.ZERO) > 0) {
			BigInteger[] quotientRemainder = remaining.divideAndRemainder(_BASE);

			remaining = quotientRemainder[0];
			encoded.append(_ENCODE_TABLE[quotientRemainder[1].intValue()]);
		}

		return encoded.reverse().toString();
	}

	/**
	 * Encodes a UUID as a base58 string.
	 * @param  uuidValue the string value of the UUID
	 * @return           the base58 encoded string.
	 */
	public static String fromUuid(String uuidValue) {
		UUID uuid = UUID.fromString(uuidValue);

		String highEncoded = encode(uuid.getMostSignificantBits());
		String lowEncoded = encode(uuid.getLeastSignificantBits());

		return highEncoded + lowEncoded;
	}

	private static final BigInteger _BASE = BigInteger.valueOf(58);

	private static final int[] _DECODE_TABLE = new int[128];

	private static final char[] _ENCODE_TABLE = {
		'1', '2', '3', '4', '5', '6', '7', '8', '9',
		'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P',
		'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
		'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'm', 'n', 'o',
		'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
	};

	private static final int _LONG_BYTES = Long.SIZE / Byte.SIZE;

	static {
		Arrays.fill(_DECODE_TABLE, -1);

		for (int i = 0; i < _ENCODE_TABLE.length; i++) {
			_DECODE_TABLE[_ENCODE_TABLE[i]] = i;
		}
	}

}