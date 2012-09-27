/**
 * CharacterOnTrain.java written by Mizuki Yuzuhara, 2012
 * 調教中に変動する項目を管理するクラス。
 * Characterクラスから切り離されているので、データの受け渡しには注意すること。
 */
package com.eramaker.javaera.training;

import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author  Mizuki Yuzuhara
 * @version  0.1.20120923
 */
public class ParamsOnTrain {
	
	/**
	 * キャラのつけているアイテムのうち調教中に着脱するもの。
	 * 本来はここで管理すべきではないのだろうが、Trainingクラスで管理すると多人数プレイに対応できないのでここで扱う。
	 */
	private TreeSet<Integer> equip;
	/**
	 * キャラの調教中パラメータ。
	 */
	private TreeMap<Integer, Integer> param;
	/**
	 * この調教の間に何回絶頂に達したか。
	 */
	private TreeMap<Integer, Integer> ext;
	/**
	 * 調教を終えて獲得した珠。
	 */
	private TreeMap<Integer, Integer> jewel;
	
	// getter and setter
	
	/**
	 * equipを取得する
	 * @return equip
	 */
	public TreeSet<Integer> getEquip() {
		return equip;
	}
	/**
	 * equipを設定する
	 * @param equip equipの設定値
	 */
	public void setEquip(TreeSet<Integer> equip) {
		this.equip = equip;
	}
	/**
	 * paramを取得する
	 * @return param
	 */
	public TreeMap<Integer, Integer> getParam() {
		return param;
	}
	/**
	 * paramを設定する
	 * @param param paramの設定値
	 */
	public void setParam(TreeMap<Integer, Integer> param) {
		this.param = param;
	}
	/**
	 * extを取得する
	 * @return ext
	 */
	public TreeMap<Integer, Integer> getExt() {
		return ext;
	}
	/**
	 * extを設定する
	 * @param ext extの設定値
	 */
	public void setExt(TreeMap<Integer, Integer> ext) {
		this.ext = ext;
	}
	/**
	 * jewelを取得する
	 * @return jewel
	 */
	public TreeMap<Integer, Integer> getJewel() {
		return jewel;
	}
	/**
	 * jewelを設定する
	 * @param jewel jewelの設定値
	 */
	public void setJewel(TreeMap<Integer, Integer> jewel) {
		this.jewel = jewel;
	}
	
}