/**
 * Dictionary.java written by Mizuki Yuzuhara, 2012
 * 辞書を管理するクラス
 */
package com.eramaker.javaera.common;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 * @author Mizuki Yuzuhara
 * @version 0.1.20120917
 */
public class GameDictionaries {

	// Variables
	/**
	 * 調教中パラメータの辞書
	 */
	public static Dictionary parameters;
	/**
	 * 能力の辞書
	 */
	public static Dictionary abilities;
	/**
	 * 素質の辞書
	 */
	public static Dictionary talents;
	/**
	 * 刻印の辞書
	 */
	public static Dictionary marks;
	/**
	 * 経験の辞書
	 */
	public static Dictionary exps;
	/**
	 * 調教コマンドの辞書
	 */
	public static Dictionary trainings;
	/**
	 * アイテムの辞書.
	 */
	public static TreeMap<Integer, GameItem> items;
	/**
	 * ゲーム中で使う色々な文章の辞書<br>
	 * あまり使っていないような気もするが、そこはそれ
	 */
	public static Dictionary stringses;

	// Constants

	/**
	 * 調教中パラメータの辞書の中身
	 */
	static final String FILENAME_PARAM = "csv/Palam.csv";
	/**
	 * 能力の辞書の中身
	 */
	static final String FILENAME_ABL = "csv/Abl.csv";
	/**
	 * 素質の辞書の中身
	 */
	static final String FILENAME_TALENT = "csv/Talent.csv";
	/**
	 * 刻印の辞書の中身
	 */
	static final String FILENAME_MARK = "csv/Mark.csv";
	/**
	 * 経験の辞書の中身
	 */
	static final String FILENAME_EXP = "csv/Exp.csv";
	/**
	 * 調教コマンドの辞書の中身
	 */
	static final String FILENAME_TRAIN = "csv/Train.csv";
	/**
	 * アイテムの辞書＆価格表の中身
	 */
	static final String FILENAME_ITEM = "csv/Item.csv";
	/**
	 * 文章の辞書の中身
	 */
	static final String FILENAME_STR = "csv/Str.csv";

	// getter and setter

	/**
	 * parametersを取得する
	 * 
	 * @return parameters
	 */
	public static Dictionary getParameters() {
		return parameters;
	}

	/**
	 * parametersを設定する
	 * 
	 * @param parameters
	 *            parametersの設定値
	 */
	public static void setParameters(Dictionary parameters) {
		GameDictionaries.parameters = parameters;
	}

	/**
	 * abilitiesを取得する
	 * 
	 * @return abilities
	 */
	public static Dictionary getAbilities() {
		return abilities;
	}

	/**
	 * abilitiesを設定する
	 * 
	 * @param abilities
	 *            abilitiesの設定値
	 */
	public static void setAbilities(Dictionary abilities) {
		GameDictionaries.abilities = abilities;
	}

	/**
	 * talentsを取得する
	 * 
	 * @return talents
	 */
	public static Dictionary getTalents() {
		return talents;
	}

	/**
	 * talentsを設定する
	 * 
	 * @param talents
	 *            talentsの設定値
	 */
	public static void setTalents(Dictionary talents) {
		GameDictionaries.talents = talents;
	}

	/**
	 * marksを取得する
	 * 
	 * @return marks
	 */
	public static Dictionary getMarks() {
		return marks;
	}

	/**
	 * marksを設定する
	 * 
	 * @param marks
	 *            marksの設定値
	 */
	public static void setMarks(Dictionary marks) {
		GameDictionaries.marks = marks;
	}

	/**
	 * expsを取得する
	 * 
	 * @return exps
	 */
	public static Dictionary getExps() {
		return exps;
	}

	/**
	 * expsを設定する
	 * 
	 * @param exps
	 *            expsの設定値
	 */
	public static void setExps(Dictionary exps) {
		GameDictionaries.exps = exps;
	}

	/**
	 * trainingsを取得する
	 * 
	 * @return trainings
	 */
	public static Dictionary getTrainings() {
		return trainings;
	}

	/**
	 * trainingsを設定する
	 * 
	 * @param trainings
	 *            trainingsの設定値
	 */
	public static void setTrainings(Dictionary trainings) {
		GameDictionaries.trainings = trainings;
	}

	/**
	 * itemsを取得する
	 * @return items
	 */
	public static TreeMap<Integer, GameItem> getItems() {
		return items;
	}

	/**
	 * itemsを設定する
	 * @param items itemsの設定値
	 */
	public static void setItems(TreeMap<Integer, GameItem> items) {
		GameDictionaries.items = items;
	}

	/**
	 * stringsesを取得する
	 * 
	 * @return stringses
	 */
	public static Dictionary getStringses() {
		return stringses;
	}

	/**
	 * stringsesを設定する
	 * 
	 * @param stringses
	 *            stringsesの設定値
	 */
	public static void setStringses(Dictionary stringses) {
		GameDictionaries.stringses = stringses;
	}

	// other function

	/**
	 * 辞書を全部まとめて初期化する
	 */
	public static void initialize() {
		parameters.createDictionary(FILENAME_PARAM);
		abilities.createDictionary(FILENAME_ABL);
		talents.createDictionary(FILENAME_TALENT);
		marks.createDictionary(FILENAME_MARK);
		exps.createDictionary(FILENAME_EXP);
		trainings.createDictionary(FILENAME_TRAIN);
		stringses.createDictionary(FILENAME_STR);
		initializeItems();
	}

	/**
	 * アイテムを初期化する
	 */
	public static void initializeItems() {
		items.clear();
		try {
			ArrayList<ArrayList<String>> cells = CSVDecomposer
					.decompose(FILENAME_ITEM);
			for (ArrayList<String> lines : cells) {
				try {
					GameItem item = new GameItem(Integer.parseInt(lines.get(0)), lines.get(1), Integer.parseInt(lines.get(2)));
					items.put(item.getId(), item);
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
