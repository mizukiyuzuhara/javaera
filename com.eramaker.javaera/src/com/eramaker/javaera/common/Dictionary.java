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
public class Dictionary {
	
	// Variables
	/**
	 * 調教中パラメータの辞書
	 */
	public static TreeMap<Integer, String> parameters;
	/**
	 * 能力の辞書
	 */
	public static TreeMap<Integer, String> abilities;
	/**
	 * 素質の辞書
	 */
	public static TreeMap<Integer, String> talents;
	/**
	 * 刻印の辞書
	 */
	public static TreeMap<Integer, String> marks;
	/**
	 * 経験の辞書
	 */
	public static TreeMap<Integer, String> exps;
	/**
	 * 調教コマンドの辞書
	 */
	public static TreeMap<Integer, String> trainings;
	/**
	 * アイテムの辞書<br>
	 * 価格表は別に持つ
	 */
	public static TreeMap<Integer, String> items;
	/**
	 * アイテムの価格表
	 */
	public static TreeMap<Integer, Integer> prices;
	/**
	 * ゲーム中で使う色々な文章の辞書<br>
	 * あまり使っていないような気もするが、そこはそれ
	 */
	public static TreeMap<Integer, String> stringses;
	
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
	public static TreeMap<Integer, String> getParameters() {
		return parameters;
	}

	/**
	 * parametersを設定する
	 * 
	 * @param parameters
	 *            parametersの設定値
	 */
	public static void setParameters(TreeMap<Integer, String> parameters) {
		Dictionary.parameters = parameters;
	}

	/**
	 * abilitiesを取得する
	 * 
	 * @return abilities
	 */
	public static TreeMap<Integer, String> getAbilities() {
		return abilities;
	}

	/**
	 * abilitiesを設定する
	 * 
	 * @param abilities
	 *            abilitiesの設定値
	 */
	public static void setAbilities(TreeMap<Integer, String> abilities) {
		Dictionary.abilities = abilities;
	}

	/**
	 * talentsを取得する
	 * 
	 * @return talents
	 */
	public static TreeMap<Integer, String> getTalents() {
		return talents;
	}

	/**
	 * talentsを設定する
	 * 
	 * @param talents
	 *            talentsの設定値
	 */
	public static void setTalents(TreeMap<Integer, String> talents) {
		Dictionary.talents = talents;
	}

	/**
	 * marksを取得する
	 * 
	 * @return marks
	 */
	public static TreeMap<Integer, String> getMarks() {
		return marks;
	}

	/**
	 * marksを設定する
	 * 
	 * @param marks
	 *            marksの設定値
	 */
	public static void setMarks(TreeMap<Integer, String> marks) {
		Dictionary.marks = marks;
	}

	/**
	 * expsを取得する
	 * 
	 * @return exps
	 */
	public static TreeMap<Integer, String> getExps() {
		return exps;
	}

	/**
	 * expsを設定する
	 * 
	 * @param exps
	 *            expsの設定値
	 */
	public static void setExps(TreeMap<Integer, String> exps) {
		Dictionary.exps = exps;
	}

	/**
	 * trainingsを取得する
	 * 
	 * @return trainings
	 */
	public static TreeMap<Integer, String> getTrainings() {
		return trainings;
	}

	/**
	 * trainingsを設定する
	 * 
	 * @param trainings
	 *            trainingsの設定値
	 */
	public static void setTrainings(TreeMap<Integer, String> trainings) {
		Dictionary.trainings = trainings;
	}

	/**
	 * itemsを取得する
	 * 
	 * @return items
	 */
	public static TreeMap<Integer, String> getItems() {
		return items;
	}

	/**
	 * itemsを設定する
	 * 
	 * @param items
	 *            itemsの設定値
	 */
	public static void setItems(TreeMap<Integer, String> items) {
		Dictionary.items = items;
	}

	/**
	 * pricesを取得する
	 * 
	 * @return prices
	 */
	public static TreeMap<Integer, Integer> getPrices() {
		return prices;
	}

	/**
	 * pricesを設定する
	 * 
	 * @param prices
	 *            pricesの設定値
	 */
	public static void setPrices(TreeMap<Integer, Integer> prices) {
		Dictionary.prices = prices;
	}

	/**
	 * stringsesを取得する
	 * 
	 * @return stringses
	 */
	public static TreeMap<Integer, String> getStringses() {
		return stringses;
	}

	/**
	 * stringsesを設定する
	 * 
	 * @param stringses
	 *            stringsesの設定値
	 */
	public static void setStringses(TreeMap<Integer, String> stringses) {
		Dictionary.stringses = stringses;
	}
	
	// other function
	
	/**
	 * 辞書を全部まとめて初期化する
	 */
	public static void initialize() {
		
	}
	
	/**
	 * 調教中パラメータの辞書を初期化する
	 */
	public static void initializeParameters() {
		// まず空にする
		parameters.clear();
		// 初期化
		ArrayList<ArrayList<String>> cells = new ArrayList<ArrayList<String>>(0);
		try {
			cells = CSVDecomposer.decompose(FILENAME_PARAM);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
		for (ArrayList<String> lines : cells) {
			parameters.put(Integer.parseInt(lines.get(0)), lines.get(1));
		}
	}
	
	/**
	 * 能力の辞書を初期化する
	 */
	public static void initializeAbilities(){
		abilities.clear();
		ArrayList<ArrayList<String>> cells = new ArrayList<ArrayList<String>>(0);
		try {
			cells = CSVDecomposer.decompose(FILENAME_ABL);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		for (ArrayList<String> lines : cells) {
			abilities.put(Integer.parseInt(lines.get(0)), lines.get(1));
		}
	}
	
	/**
	 * 能力の辞書を初期化する
	 */
	public static void initializeTalent(){
		talents.clear();
		ArrayList<ArrayList<String>> cells = new ArrayList<ArrayList<String>>(0);
		try {
			cells = CSVDecomposer.decompose(FILENAME_TALENT);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		for (ArrayList<String> lines : cells) {
			talents.put(Integer.parseInt(lines.get(0)), lines.get(1));
		}
	}
	
	/**
	 * 刻印の辞書を初期化する
	 */
	public static void initializeMark(){
		marks.clear();
		ArrayList<ArrayList<String>> cells = new ArrayList<ArrayList<String>>(0);
		try {
			cells = CSVDecomposer.decompose(FILENAME_MARK);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		for (ArrayList<String> lines : cells) {
			marks.put(Integer.parseInt(lines.get(0)), lines.get(1));
		}
	}
	
}
