/**
 * ExpDic.java written by Mizuki Yuzuhara, 2012.
 * 経験の辞書。
 */
package com.eramaker.javaera.dictionary;

import java.io.FileNotFoundException;

/**
 * @author Mizuki Yuzuhara
 * @version 0.1.20121001
 */
public class ExpDic extends Dictionary {

	/**
	 * シリアルバージョン番号。
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 経験の辞書の中身
	 */
	final String FILENAME_EXP = "csv/Exp.csv";

	/**
	 * コンストラクタ。
	 * 
	 * @throws FileNotFoundException
	 *             該当するファイルがないとき
	 */
	public ExpDic() throws FileNotFoundException {
		createDictionary(FILENAME_EXP);
	}

}
