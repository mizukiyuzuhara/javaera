/**
 * AbilityDic.java written by Mizuki Yuzuhara, 2012.
 * 能力用辞書。都度開くこと。
 */
package com.eramaker.javaera.dictionary;

import java.io.FileNotFoundException;

/**
 * @author Mizuki Yuzuhara
 * @version 0.1.20121001
 */
public class AbilityDic extends Dictionary {

	/**
	 * シリアルバージョン番号。
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 能力の辞書の中身
	 */
	private final String FILENAME_ABL = "csv/Abl.csv";

	// constructor

	/**
	 * コンストラクタ。
	 * 
	 * @throws FileNotFoundException
	 *             該当するファイルがないとき
	 */
	public AbilityDic() throws FileNotFoundException {
		createDictionary(FILENAME_ABL);
	}

}
