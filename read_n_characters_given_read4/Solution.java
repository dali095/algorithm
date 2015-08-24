package kai.leetcode.algorithm.read_n_characters_given_read4;

//The API: int read4(char *buf) reads 4 characters at a time from a file.
//
//The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
//
//By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
//
//Note:
//The read function will only be called once for each test case.

class Reader4 {
}

public class Solution extends Reader4 {
	/**
	 * @param buf
	 *            Destination buffer
	 * @param n
	 *            Maximum number of characters to read
	 * @return The number of characters read
	 */

	// The read4 API is defined in the parent class Reader4.
	int read4(char[] buf) {
		return 0;
	}

	public int read(char[] buf, int n) {
		int read = 0;
		int times = n / 4;
		char[] buf4 = new char[4];

		for (int i = 0; i < times; i++) {
			int actual = read4(buf4);
			if (actual < 4) {
				for (int j = 0; j < actual; j++) {
					buf[read + j] = buf4[j];
				}
				read = read + actual;
				return read;
			}
			for (int j = 0; j < 4; j++) {
				buf[read + j] = buf4[j];
			}
			read = read + 4;
		}

		if (n % 4 != 0) {
			int actualRead = read4(buf4);
			for (int j = 0; j < actualRead && j < n % 4; j++) {
				buf[read + j] = buf4[j];
			}
			if (actualRead < n % 4)
				read = read + actualRead;
			else
				read = read + (n % 4);
		}
		return read;

	}
}