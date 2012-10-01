/**
 * MarkDic.java written by Mizuki Yuzuhara, 2012.
 * 刻印の辞書。
 */
package com.eramaker.javaera.dictionary;

import java.io.FileNotFoundException;

/**
 * @author Mizuki Yuzuhara
 * @version 0.1.20121001
 */
public class MarkDic extends Dictionary {

	/**
	 * シリアルバージョン番号。
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 刻印の辞書の中身
	 */
	final String FILENAME_MARK = "csv/Mark.csv";

	/**
	 * コンストラクタ。
	 * 
	 * @throws FileNotFoundException
	 *             該当するファイルがないとき
	 */
	public MarkDic() throws FileNotFoundException {
		createDictionary(FILENAME_MARK);
	}

}
