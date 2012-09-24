/**
 * CharacterOnCommand.java written by Mizuki Yuzuhara, 2012.
 * 調教コマンドにより変動する項目を管理するクラス。
 * コマンド実行後に都度リセットすること。
 */
package com.eramaker.javaera.common;

import java.util.TreeMap;

/**
 * @author Mizuki Yuzuhara
 * @version 0.1.20120923
 */
public class CharacterOnCommand {
	/**
	 * コマンドを実行することによって発生した調教ソース。
	 */
	private TreeMap<Integer, Integer> source;
	/**
	 * コマンドの間に何回絶頂に達したか。
	 */
	private TreeMap<Integer, Integer> ext;
	/**
	 * コマンドにより減少する基礎数値。
	 */
	private TreeMap<Integer, Integer> loseBase;
	/**
	 * コマンドにより上昇するパラメータ。
	 */
	private TreeMap<Integer, Integer> addParameter;
	/**
	 * コマンドにより減少するパラメータ。
	 */
	private TreeMap<Integer, Integer> deleteParameter;

	// getter and setter
	
	/**
	 * sourceを取得する
	 * 
	 * @return source
	 */
	public TreeMap<Integer, Integer> getSource() {
		return source;
	}

	/**
	 * sourceを設定する
	 * 
	 * @param source
	 *            sourceの設定値
	 */
	public void setSource(TreeMap<Integer, Integer> source) {
		this.source = source;
	}

	/**
	 * extを取得する
	 * 
	 * @return ext
	 */
	public TreeMap<Integer, Integer> getExt() {
		return ext;
	}

	/**
	 * extを設定する
	 * 
	 * @param ext
	 *            extの設定値
	 */
	public void setExt(TreeMap<Integer, Integer> ext) {
		this.ext = ext;
	}
	
	/**
	 * loseBaseを取得する
	 * @return loseBase
	 */
	public TreeMap<Integer, Integer> getLoseBase() {
		return loseBase;
	}

	/**
	 * loseBaseを設定する
	 * @param loseBase loseBaseの設定値
	 */
	public void setLoseBase(TreeMap<Integer, Integer> loseBase) {
		this.loseBase = loseBase;
	}

	/**
	 * addParameterを取得する
	 * @return addParameter
	 */
	public TreeMap<Integer, Integer> getAddParameter() {
		return addParameter;
	}

	/**
	 * addParameterを設定する
	 * @param addParameter addParameterの設定値
	 */
	public void setAddParameter(TreeMap<Integer, Integer> addParameter) {
		this.addParameter = addParameter;
	}

	/**
	 * deleteParameterを取得する
	 * @return deleteParameter
	 */
	public TreeMap<Integer, Integer> getDeleteParameter() {
		return deleteParameter;
	}

	/**
	 * deleteParameterを設定する
	 * @param deleteParameter deleteParameterの設定値
	 */
	public void setDeleteParameter(TreeMap<Integer, Integer> deleteParameter) {
		this.deleteParameter = deleteParameter;
	}

	// other functions

	/**
	 * すべての項目をリセットする。
	 * コマンド終了後、CharactorOnTrainに展開したら即実行すること。
	 * これを残すと、CharacterOnCommandがCharacterにフィールドを有しているため、セーブデータに余計なデータが残る。
	 */
	public void clear(){
		source.clear();
		ext.clear();
		loseBase.clear();
		addParameter.clear();
		deleteParameter.clear();
	}
	
}