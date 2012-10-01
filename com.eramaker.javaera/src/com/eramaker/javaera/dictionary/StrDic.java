/**
 * StrDic.java written by Mizuki Yuzuhara, 2012.
 * 文字列の辞書。たぶん使っているシステムはないと思うが、念のため。
 */
package com.eramaker.javaera.dictionary;

import java.io.FileNotFoundException;

/**
 * @author Mizuki Yuzuhara
 * @version 0.1.20121001
 */
public class StrDic extends Dictionary {

	/**
	 * シリアルバージョン番号。
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 文章の辞書の中身
	 */
	final String FILENAME_STR = "csv/Str.csv";

	/**
	 * コンストラクタ。
	 * 
	 * @throws FileNotFoundException
	 *             該当するファイルがないとき
	 */
	public StrDic() throws FileNotFoundException {
		createDictionary(FILENAME_STR);
	}

}
