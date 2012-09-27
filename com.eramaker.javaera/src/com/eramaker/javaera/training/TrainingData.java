/**
 * TrainingData.java written by Mizuki Yuzuhara, 2012.
 * 調教の際に必要なデータを受け渡しするクラス。
 */
package com.eramaker.javaera.training;

import java.util.ArrayList;
import java.util.TreeMap;

import com.eramaker.javaera.character.Character;
import com.eramaker.javaera.common.ElementCollection;

/**
 * @author Mizuki Yuzuhara
 * @version 0.1.20120927
 */
public class TrainingData {

	/**
	 * 主人公のキャラの<b>登録番号</b>を制御する。<br>
	 * 通常1人しかいないとは思うが、一応コレクション化。
	 */
	private ElementCollection masters;
	/**
	 * 調教中のキャラの<b>登録番号</b>を制御する<br>
	 * 通常1人だろうが、3P、4P、…をやりたいときのことを考えて、コレクション化
	 */
	private ElementCollection targets;
	/**
	 * 助手のキャラの<b>登録番号</b>を制御する<br>
	 * 通常1人だろうが、（ｒｙコレクション化
	 */
	private ElementCollection assistants;
	/**
	 * 調教している人間のキャラの<b>登録番号</b>を制御する<br>
	 * 正直誰得なのだが、コレクション化しておく
	 */
	private ElementCollection pleyers;
	/**
	 * キャラと<b>登録番号そのものを</b>を制御する<br>
	 * このArrayListは<b>#get(0)を返す関数を持たない</b>ので注意
	 */
	private ArrayList<Character> registeredCharactors;
	/**
	 * 所持アイテムを制御する<br>
	 * 消耗アイテムもあるので、「あるなし」の制御をしないこと
	 */
	private TreeMap<Integer, Integer> items;
	/**
	 * 調教で変動するパラメータ一式。
	 * キーは<b>登録番号</b>なので処理に注意。
	 */
	private TreeMap<Integer, ParamsOnTrain> parameters;

	// getter and setter

	/**
	 * mastersを取得する
	 * 
	 * @return masters
	 */
	public ElementCollection getMasters() {
		return masters;
	}

	/**
	 * mastersを設定する
	 * 
	 * @param masters
	 *            mastersの設定値
	 */
	public void setMasters(ElementCollection masters) {
		this.masters = masters;
	}

	/**
	 * targetsを取得する
	 * 
	 * @return targets
	 */
	public ElementCollection getTargets() {
		return targets;
	}

	/**
	 * targetsを設定する
	 * 
	 * @param targets
	 *            targetsの設定値
	 */
	public void setTargets(ElementCollection targets) {
		this.targets = targets;
	}

	/**
	 * assistantsを取得する
	 * 
	 * @return assistants
	 */
	public ElementCollection getAssistants() {
		return assistants;
	}

	/**
	 * assistantsを設定する
	 * 
	 * @param assistants
	 *            assistantsの設定値
	 */
	public void setAssistants(ElementCollection assistants) {
		this.assistants = assistants;
	}

	/**
	 * pleyersを取得する
	 * 
	 * @return pleyers
	 */
	public ElementCollection getPleyers() {
		return pleyers;
	}

	/**
	 * pleyersを設定する
	 * 
	 * @param pleyers
	 *            pleyersの設定値
	 */
	public void setPleyers(ElementCollection pleyers) {
		this.pleyers = pleyers;
	}

	/**
	 * registeredCharactorsを取得する
	 * 
	 * @return registeredCharactors
	 */
	public ArrayList<Character> getRegisteredCharactors() {
		return registeredCharactors;
	}

	/**
	 * registeredCharactorsを設定する
	 * 
	 * @param registeredCharactors
	 *            registeredCharactorsの設定値
	 */
	public void setRegisteredCharactors(
			ArrayList<Character> registeredCharactors) {
		this.registeredCharactors = registeredCharactors;
	}

	/**
	 * itemsを取得する
	 * 
	 * @return items
	 */
	public TreeMap<Integer, Integer> getItems() {
		return items;
	}

	/**
	 * itemsを設定する
	 * 
	 * @param items
	 *            itemsの設定値
	 */
	public void setItems(TreeMap<Integer, Integer> items) {
		this.items = items;
	}

	/**
	 * parametersを取得する
	 * 
	 * @return parameters
	 */
	public TreeMap<Integer, ParamsOnTrain> getParameters() {
		return parameters;
	}

	/**
	 * parametersを設定する
	 * 
	 * @param parameters
	 *            parametersの設定値
	 */
	public void setParameters(TreeMap<Integer, ParamsOnTrain> parameters) {
		this.parameters = parameters;
	}

	// constructor

	/**
	 * コンストラクター。GameDataより必要なデータをコピーする。 最後にGameDataに戻すこと。
	 * 
	 * @param masters
	 * @param targets
	 * @param assistants
	 * @param pleyers
	 * @param registeredCharactors
	 * @param items
	 */
	public TrainingData(ElementCollection masters, ElementCollection targets,
			ElementCollection assistants, ElementCollection pleyers,
			ArrayList<Character> registeredCharactors,
			TreeMap<Integer, Integer> items) {
		this.masters = masters;
		this.targets = targets;
		this.assistants = assistants;
		this.pleyers = pleyers;
		this.registeredCharactors = registeredCharactors;
		this.items = items;
	}

	// other method
	
	/**
	 * 登録番号から、それに該当するキャラを返す。
	 * 
	 * @param registeredId
	 *            登録番号
	 * @return 該当するキャラ
	 */
	public Character registeredIdToCharacter(Integer registeredId) {
		return registeredCharactors.get(registeredId);
	}

}
