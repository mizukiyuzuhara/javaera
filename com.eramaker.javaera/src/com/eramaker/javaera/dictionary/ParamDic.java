/**
 * ParamDic.java written by Mizuki Yuzuhara, 2012.
 * パラメータ用辞書。都度開くこと。
 */
package com.eramaker.javaera.dictionary;

import java.io.FileNotFoundException;

/**
 * @author Mizuki Yuzuhara
 * @version 0.1.20121001
 */
public class ParamDic extends Dictionary {

	// constants

	/**
	 * シリアルバージョン番号。
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 調教中パラメータの辞書の中身
	 */
	private final String FILENAME_PARAM = "csv/Palam.csv";

	// constructor

	/**
	 * コンストラクタ。
	 * 
	 * @throws FileNotFoundException
	 *             該当するファイルがないとき
	 */
	public ParamDic() throws FileNotFoundException {
		createDictionary(FILENAME_PARAM);
	}

}
