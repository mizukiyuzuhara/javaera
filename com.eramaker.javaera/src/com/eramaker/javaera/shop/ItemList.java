/**
 * ItemList.java written by Mizuki Yuzuhara, 2012.
 * 
 */
package com.eramaker.javaera.shop;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.TreeMap;

import org.apache.commons.lang.math.NumberUtils;

import com.eramaker.javaera.common.CSVDecomposer;
import com.eramaker.javaera.common.IllegalInputException;

/**
 * @author Mizuki Yuzuhara
 * @version
 */
public class ItemList extends TreeMap<Integer, Item> {

	/**
	 * シリアルバージョン番号。
	 */
	private static final long serialVersionUID = 1L;

	// constants

	/**
	 * アイテムの辞書＆価格表の中身
	 */
	final String FILENAME_ITEM = "csv/Item.csv";

	// constructor

	/**
	 * コンストラクタ。
	 */
	public ItemList() {
		try {
			ArrayList<ArrayList<String>> cells = CSVDecomposer
					.decompose(FILENAME_ITEM);
			for (ArrayList<String> lines : cells) {
				Item item = new Item(NumberUtils.toInt(lines.get(0)),
						lines.get(1), NumberUtils.toInt(lines.get(2)));
				put(item.getId(), item);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	// other methods

	/**
	 * 入力したアイテム番号に対応するアイテムを返す。 該当するものがない場合、例外を返す。
	 * 
	 * @param integer
	 *            アイテム番号
	 * @return アイテム番号に対応するアイテム
	 * @throws IllegalInputException
	 *             アイテム番号に対応するアイテムがなかった場合
	 */
	public Item getItem(Integer integer) throws IllegalInputException {
		Item item = get(integer);
		if (item == null) {
			throw new IllegalInputException();
		} else {
			return item;
		}
	}

}
