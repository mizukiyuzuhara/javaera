/**
 * TalentDic.java written by Mizuki Yuzuhara, 2012.
 * 素質用事典。都度開くこと。
 */
package com.eramaker.javaera.dictionary;

import java.io.FileNotFoundException;

/**
 * @author Mizuki Yuzuhara
 * @version 0.1.20121001
 */
public class TalentDic extends Dictionary {

	/**
	 * シリアルバージョン番号。
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 素質の辞書の中身
	 */
	private final String FILENAME_TALENT = "csv/Talent.csv";


	/**
	 * コンストラクタ。
	 * 
	 * @throws FileNotFoundException
	 *             該当するファイルがないとき
	 */
	public TalentDic() throws FileNotFoundException {
		createDictionary(FILENAME_TALENT);
	}

}
