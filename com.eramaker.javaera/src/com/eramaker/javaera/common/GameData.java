/**
 * this.java written by Mizuki Yuzuhara, 2012
 * eramakerのゲームデータを管理するクラス<br />
 * すべてセーブされるので扱いには注意すること<br />
 * 特に、無駄な配列は作らないこと<br>
 * なお、必要そうなものは可能な限りコレクション化している
 */
package com.eramaker.javaera.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeMap;

import com.eramaker.javaera.character.Character;

/**
 * @author Mizuki Yuzuhara
 * @version 0.1.20120914
 */
public class GameData implements Serializable {

	/**
	 * シリアライズバージョン
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * ゲームコード<br>
	 * 別のゲームのセーブデータを誤ってロードしないための識別番号として使用<br>
	 * 32bit整数の範囲内で任意の数を指定してよいが、重複しないよう注意すること
	 */
	private int gameCode;
	/**
	 * ゲームのバージョン<br>
	 * このバージョンがセーブデータに記録され、バージョン違いでのデータ読み込みを制御する<br>
	 * なお、表示上は「このバージョンを100で割った数」
	 */
	private int gameVersion;
	/**
	 * ゲームのバージョンのうち、パッチ当てによるバージョン違いを識別するもの<br>
	 * すなわち、「ver0.01a」の「a」の部分<br>
	 * セーブデータに影響が出るような変更でない限り、この番号を上げること
	 */
	private String gameSubVersion;
	/**
	 * 日付を制御する<br>
	 * 曜日を求める必要があるときは、これの#get(0)を7で割って余りを曜日に当てはめると早いかも<br>
	 * コレクション化しているので、カレンダー制御することも可能、だと思う
	 */
	private ElementCollection days;
	/**
	 * 時間を制御する<br>
	 * 意味があるかどうかはわからないが、一応コレクション化
	 */
	private ElementCollection times;
	/**
	 * 資金を制御する
	 */
	private ElementCollection moneys;
	/**
	 * 主人公のキャラの<b>登録番号</b>を制御する<br>
	 * 通常1人しかいないとは思うが、一応コレクション化
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
	 * 購入可能なキャラを制御する<br>
	 * eramakerではアイテムの売買で制御しているっぽいが、敢えて分けている
	 */
	private ArrayList<Integer> charactorInShop;
	/**
	 * 所持アイテムを制御する<br>
	 * 消耗アイテムもあるので、「あるなし」の制御をしないこと
	 */
	private TreeMap<Integer, Integer> items;
	/**
	 * 購入可能なアイテムを制御する
	 */
	private ArrayList<Integer> itemInShop;
	/**
	 * フラグを制御する
	 */
	private TreeMap<Integer, Integer> flag;

	// getter and setter

	/**
	 * gameCodeを取得する
	 * 
	 * @return gameCode
	 */
	public int getGameCode() {
		return gameCode;
	}

	/**
	 * gameVersionを設定する
	 * 
	 * @param gameVersion
	 *            gameVersionの設定値
	 */
	public void setGameVersion(int gameVersion) {
		this.gameVersion = gameVersion;
	}

	/**
	 * gameVersionを取得する
	 * 
	 * @return gameVersion
	 */
	public int getGameVersion() {
		return gameVersion;
	}

	/**
	 * gameCodeを設定する
	 * 
	 * @param gameCode
	 *            gameCodeの設定値
	 */
	public void setGameCode(int gameCode) {
		this.gameCode = gameCode;
	}

	/**
	 * gameSubVersionを取得する
	 * 
	 * @return gameSubVersion
	 */
	public String getGameSubVersion() {
		return gameSubVersion;
	}

	/**
	 * gameSubVersionを設定する
	 * 
	 * @param gameSubVersion
	 *            gameSubVersionの設定値
	 */
	public void setGameSubVersion(String gameSubVersion) {
		this.gameSubVersion = gameSubVersion;
	}

	/**
	 * daysを取得する
	 * 
	 * @return days
	 */
	public ElementCollection getDays() {
		return days;
	}

	/**
	 * daysを設定する
	 * 
	 * @param days
	 *            daysの設定値
	 */
	public void setDays(ElementCollection days) {
		this.days = days;
	}

	/**
	 * timesを取得する
	 * 
	 * @return times
	 */
	public ElementCollection getTimes() {
		return times;
	}

	/**
	 * timesを設定する
	 * 
	 * @param times
	 *            timesの設定値
	 */
	public void setTimes(ElementCollection times) {
		this.times = times;
	}

	/**
	 * moneysを取得する
	 * 
	 * @return moneys
	 */
	public ElementCollection getMoneys() {
		return moneys;
	}

	/**
	 * moneysを設定する
	 * 
	 * @param moneys
	 *            moneysの設定値
	 */
	public void setMoneys(ElementCollection moneys) {
		this.moneys = moneys;
	}

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
	 * charactorInShopを取得する
	 * 
	 * @return charactorInShop
	 */
	public ArrayList<Integer> getCharactorInShop() {
		return charactorInShop;
	}

	/**
	 * charactorInShopを設定する
	 * 
	 * @param charactorInShop
	 *            charactorInShopの設定値
	 */
	public void setCharactorInShop(ArrayList<Integer> charactorInShop) {
		this.charactorInShop = charactorInShop;
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
	 * itemInShopを取得する
	 * 
	 * @return itemInShop
	 */
	public ArrayList<Integer> getItemInShop() {
		return itemInShop;
	}

	/**
	 * itemInShopを設定する
	 * 
	 * @param itemInShop
	 *            itemInShopの設定値
	 */
	public void setItemInShop(ArrayList<Integer> itemInShop) {
		this.itemInShop = itemInShop;
	}

	/**
	 * flagを取得する
	 * 
	 * @return flag
	 */
	public TreeMap<Integer, Integer> getFlag() {
		return flag;
	}

	/**
	 * flagを設定する
	 * 
	 * @param flag
	 *            flagの設定値
	 */
	public void setFlag(TreeMap<Integer, Integer> flag) {
		this.flag = flag;
	}

	// other functions

	/**
	 * 所持金のスタックが複数あるとき、その総合計を取得する
	 * 
	 * @return 所持金の総合計
	 */
	public Integer getTotalMoney() {
		int total = 0;
		for (Integer money : moneys) {
			total = total + money;
		}
		return total;
	}

	/**
	 * 現在登録されているキャラの数を返す
	 * 
	 * @return 現在登録されているキャラの数
	 */
	public int getCharaNum() {
		return registeredCharactors.size();
	}

}
