/**
 * Dictionary.java written by Mizuki Yuzuhara, 2012
 * 辞書クラス<br>
 * 逆引き対応（valueを与えて最初のkeyを返す）
 */
package com.eramaker.javaera.dictionary;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.TreeMap;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import com.eramaker.javaera.common.CSVDecomposer;

/**
 * @author Mizuki Yuzuhara
 * @version 0.2.20121001
 */
/*
 * 0.1.20120918 -> 0.1.20121001 辞書クラスを辞書ごとにばらす
 */
public class Dictionary extends TreeMap<Integer, String> {

	/**
	 * シリアルバージョン番号
	 */
	private static final long serialVersionUID = 1L;

	// constructor
	public Dictionary() throws FileNotFoundException{
		throw new FileNotFoundException();
	}
	
	// other methods

	/**
	 * 辞書を初期化する
	 * 
	 * @param fileName
	 *            辞書を格納するCSVファイル名
	 * @return 初期化した辞書そのもの
	 * @throws 指定した辞書ファイルがなかったとき
	 */
	public void createDictionary(String fileName) throws FileNotFoundException {
		ArrayList<ArrayList<String>> cells = CSVDecomposer.decompose(fileName);
		for (ArrayList<String> lines : cells) {
			put(NumberUtils.toInt(lines.get(0)), lines.get(1));
		}
	}

	/**
	 * keyに対応するvalueを返す
	 * 
	 * @param key
	 *            辞書のキー項目
	 * @return 辞書のキーに対応する値
	 * @throws ElementsNotFoundException
	 *             valueがnullか空文字の場合
	 */
	public String getValue(Integer key) throws ElementsNotFoundException {
		String value = get(key);
		if (StringUtils.isNotBlank(value)) {
			return value;
		} else {
			throw new ElementsNotFoundException();
		}
	}

	/**
	 * valueに対応するkeyの<b>最小値</b>を返す<br>
	 * なければnullを返す
	 * 
	 * @param value
	 *            辞書の値
	 * @return 辞書の値に対応するキーの最小値
	 * @throws ElementsNotFoundException
	 *             keyがnullの場合
	 */
	public Integer getKey(String value) throws ElementsNotFoundException {
		Integer key = null;
		Integer currentKey = firstKey();
		Integer lastKey = lastKey();
		while (key == null && currentKey <= lastKey) {
			String string = get(ceilingKey(currentKey));
			if (value.equals(string)) {
				key = currentKey;
			}
			currentKey = ceilingKey(currentKey) + 1;
		}
		if (key != null) {
			return key;
		} else {
			throw new ElementsNotFoundException();
		}
	}

}
