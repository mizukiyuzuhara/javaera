/**
 * Dictionary.java written by Mizuki Yuzuhara, 2012
 * 辞書を管理するクラス
 */
package com.eramaker.javaera.common;


/**
 * @author Mizuki Yuzuhara
 * @version 0.1.20120917
 */
public class GameDictionaries {

	// Variables
	/**
	 * 調教中パラメータの辞書
	 */
	public Dictionary parameters;
	/**
	 * 能力の辞書
	 */
	public Dictionary abilities;
	/**
	 * 素質の辞書
	 */
	public Dictionary talents;
	/**
	 * 刻印の辞書
	 */
	public Dictionary marks;
	/**
	 * 経験の辞書
	 */
	public Dictionary exps;
	/**
	 * ゲーム中で使う色々な文章の辞書<br>
	 * あまり使っていないような気もするが、そこはそれ
	 */
	public Dictionary stringses;

	// Constants

	/**
	 * 調教中パラメータの辞書の中身
	 */
	final String FILENAME_PARAM = "csv/Palam.csv";
	/**
	 * 能力の辞書の中身
	 */
	final String FILENAME_ABL = "csv/Abl.csv";
	/**
	 * 素質の辞書の中身
	 */
	final String FILENAME_TALENT = "csv/Talent.csv";
	/**
	 * 刻印の辞書の中身
	 */
	final String FILENAME_MARK = "csv/Mark.csv";
	/**
	 * 経験の辞書の中身
	 */
	final String FILENAME_EXP = "csv/Exp.csv";
	/**
	 * 文章の辞書の中身
	 */
	final String FILENAME_STR = "csv/Str.csv";

	// getter and setter

	/**
	 * parametersを取得する
	 * 
	 * @return parameters
	 */
	public Dictionary getParameters() {
		return parameters;
	}

	/**
	 * parametersを設定する
	 * 
	 * @param parameters
	 *            parametersの設定値
	 */
	public void setParameters(Dictionary parameters) {
		this.parameters = parameters;
	}

	/**
	 * abilitiesを取得する
	 * 
	 * @return abilities
	 */
	public Dictionary getAbilities() {
		return abilities;
	}

	/**
	 * abilitiesを設定する
	 * 
	 * @param abilities
	 *            abilitiesの設定値
	 */
	public void setAbilities(Dictionary abilities) {
		this.abilities = abilities;
	}

	/**
	 * talentsを取得する
	 * 
	 * @return talents
	 */
	public Dictionary getTalents() {
		return talents;
	}

	/**
	 * talentsを設定する
	 * 
	 * @param talents
	 *            talentsの設定値
	 */
	public void setTalents(Dictionary talents) {
		this.talents = talents;
	}

	/**
	 * marksを取得する
	 * 
	 * @return marks
	 */
	public Dictionary getMarks() {
		return marks;
	}

	/**
	 * marksを設定する
	 * 
	 * @param marks
	 *            marksの設定値
	 */
	public void setMarks(Dictionary marks) {
		this.marks = marks;
	}

	/**
	 * expsを取得する
	 * 
	 * @return exps
	 */
	public Dictionary getExps() {
		return exps;
	}

	/**
	 * expsを設定する
	 * 
	 * @param exps
	 *            expsの設定値
	 */
	public void setExps(Dictionary exps) {
		this.exps = exps;
	}

	/**
	 * stringsesを取得する
	 * 
	 * @return stringses
	 */
	public Dictionary getStringses() {
		return stringses;
	}

	/**
	 * stringsesを設定する
	 * 
	 * @param stringses
	 *            stringsesの設定値
	 */
	public void setStringses(Dictionary stringses) {
		this.stringses = stringses;
	}

	// other function

	/**
	 * 辞書を全部まとめて初期化する
	 */
	public void initialize() {
		parameters.createDictionary(FILENAME_PARAM);
		abilities.createDictionary(FILENAME_ABL);
		talents.createDictionary(FILENAME_TALENT);
		marks.createDictionary(FILENAME_MARK);
		exps.createDictionary(FILENAME_EXP);
		stringses.createDictionary(FILENAME_STR);
	}

}
