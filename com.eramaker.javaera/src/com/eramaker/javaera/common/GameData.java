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
	private ArrayList<Integer> days;
	/**
	 * 時間を制御する<br>
	 * 意味があるかどうかはわからないが、一応コレクション化
	 */
	private ArrayList<Integer> times;
	/**
	 * 資金を制御する
	 */
	private ArrayList<Integer> moneys;
	/**
	 * 主人公のキャラの<b>登録番号</b>を制御する<br>
	 * 通常1人しかいないとは思うが、一応コレクション化
	 */
	private ArrayList<Integer> masters;
	/**
	 * 調教中のキャラの<b>登録番号</b>を制御する<br>
	 * 通常1人だろうが、3P、4P、…をやりたいときのことを考えて、コレクション化
	 */
	private ArrayList<Integer> targets;
	/**
	 * 助手のキャラの<b>登録番号</b>を制御する<br>
	 * 通常1人だろうが、（ｒｙコレクション化
	 */
	private ArrayList<Integer> assistants;
	/**
	 * 調教している人間のキャラの<b>登録番号</b>を制御する<br>
	 * 正直誰得なのだが、コレクション化しておく
	 */
	private ArrayList<Integer> pleyers;
	/**
	 * キャラの<b>登録番号そのものを</b>を制御する<br>
	 * このArrayListは<b>#get(0)を返す関数を持たない</b>ので注意
	 */
	private ArrayList<Integer> registeredCharactors;
	/**
	 * <b>キャラそのものを</b>制御する<br>
	 * Charactor型を持つので、<b>デフォルトを維持する必要はない</b>し、<b>想定もしていない</b><br>
	 * これも<b>#get(0)を返す関数を持たない</b>
	 */
	private TreeMap<Integer, Character> characters;
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
	public ArrayList<Integer> getDays() {
		return days;
	}

	/**
	 * daysを設定する
	 * 
	 * @param days
	 *            daysの設定値
	 */
	public void setDays(ArrayList<Integer> days) {
		this.days = days;
	}

	/**
	 * timesを取得する
	 * 
	 * @return times
	 */
	public ArrayList<Integer> getTimes() {
		return times;
	}

	/**
	 * timesを設定する
	 * 
	 * @param times
	 *            timesの設定値
	 */
	public void setTimes(ArrayList<Integer> times) {
		this.times = times;
	}

	/**
	 * moneysを取得する
	 * 
	 * @return moneys
	 */
	public ArrayList<Integer> getMoneys() {
		return moneys;
	}

	/**
	 * moneysを設定する
	 * 
	 * @param moneys
	 *            moneysの設定値
	 */
	public void setMoneys(ArrayList<Integer> moneys) {
		this.moneys = moneys;
	}

	/**
	 * mastersを取得する
	 * 
	 * @return masters
	 */
	public ArrayList<Integer> getMasters() {
		return masters;
	}

	/**
	 * mastersを設定する
	 * 
	 * @param masters
	 *            mastersの設定値
	 */
	public void setMasters(ArrayList<Integer> masters) {
		this.masters = masters;
	}

	/**
	 * targetsを取得する
	 * 
	 * @return targets
	 */
	public ArrayList<Integer> getTargets() {
		return targets;
	}

	/**
	 * targetsを設定する
	 * 
	 * @param targets
	 *            targetsの設定値
	 */
	public void setTargets(ArrayList<Integer> targets) {
		this.targets = targets;
	}

	/**
	 * assistantsを取得する
	 * 
	 * @return assistants
	 */
	public ArrayList<Integer> getAssistants() {
		return assistants;
	}

	/**
	 * assistantsを設定する
	 * 
	 * @param assistants
	 *            assistantsの設定値
	 */
	public void setAssistants(ArrayList<Integer> assistants) {
		this.assistants = assistants;
	}

	/**
	 * pleyersを取得する
	 * 
	 * @return pleyers
	 */
	public ArrayList<Integer> getPleyers() {
		return pleyers;
	}

	/**
	 * pleyersを設定する
	 * 
	 * @param pleyers
	 *            pleyersの設定値
	 */
	public void setPleyers(ArrayList<Integer> pleyers) {
		this.pleyers = pleyers;
	}

	/**
	 * registeredCharactorsを取得する
	 * 
	 * @return registeredCharactors
	 */
	public ArrayList<Integer> getRegisteredCharactors() {
		return registeredCharactors;
	}

	/**
	 * registeredCharactorsを設定する
	 * 
	 * @param registeredCharactors
	 *            registeredCharactorsの設定値
	 */
	public void setRegisteredCharactors(ArrayList<Integer> registeredCharactors) {
		this.registeredCharactors = registeredCharactors;
	}

	/**
	 * charactorsを取得する
	 * 
	 * @return characters
	 */
	public TreeMap<Integer, Character> getCharacters() {
		return characters;
	}

	/**
	 * charactorsを設定する
	 * 
	 * @param characters
	 *            charactersの設定値
	 */
	public void setCharacters(TreeMap<Integer, Character> characters) {
		this.characters = characters;
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
	 * 日付を配列として使用しない場合、日付を設定する
	 * 
	 * @param day
	 *            日付（days#get(0)）
	 */
	public void setDay(Integer day) {
		setDay(0, day);
	}

	/**
	 * 日付を設定する
	 * 
	 * @param index
	 *            項番
	 * @param day
	 *            日付
	 */
	public void setDay(int index, Integer day) {
		days.set(index, day);
	}

	/**
	 * 日付を配列として使用しない場合、日付を取得する
	 * 
	 * @return 日付（days#get(0)）
	 */
	public Integer getDay() {
		return getDay(0);
	}

	/**
	 * 日付を取得する
	 * 
	 * @param index
	 *            項番
	 * @return 日付
	 */
	public Integer getDay(Integer index) {
		return days.get(index);
	}

	/**
	 * 時間を配列として使用しない場合、時間を設定する
	 * 
	 * @param time
	 *            時間（times#get(0)）
	 */
	public void setTime(Integer time) {
		setTime(0, time);
	}

	/**
	 * 時間を設定する
	 * 
	 * @param index
	 *            項番
	 * @param time
	 *            時間
	 */
	public void setTime(int index, Integer time) {
		times.set(index, time);
	}

	/**
	 * 時間を配列として使用しない場合、時間を取得する
	 * 
	 * @return 時間（times#get(0)）
	 */
	public Integer getTime() {
		return getTime(0);
	}

	/**
	 * 時間を取得する
	 * 
	 * @param index
	 *            項番
	 * @return 時間
	 */
	public Integer getTime(int index) {
		return times.get(index);
	}

	/**
	 * 所持金を配列として使用しない場合、所持金を設定する
	 * 
	 * @param money
	 */
	public void setMoney(Integer money) {
		setMoney(0, money);
	}

	/**
	 * 所持金を設定する
	 * 
	 * @param index
	 *            項番
	 * @param money
	 *            所持金
	 */
	public void setMoney(int index, Integer money) {
		moneys.set(index, money);
	}

	/**
	 * 所持金を配列として使用しない場合、所持金を取得する
	 * 
	 * @return 所持金
	 */
	public Integer getMoney() {
		return getMoney(0);
	}

	/**
	 * 所持金を取得する
	 * 
	 * @param index
	 *            項番
	 * @return 所持金
	 */
	public Integer getMoney(int index) {
		return moneys.get(index);
	}

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
	 * 主人公を配列として使用しない場合、主人公を設定する
	 * 
	 * @param master
	 *            主人公（master#get(0)）
	 */
	public void setMaster(Integer master) {
		setMaster(0, master);
	}

	/**
	 * 主人公を設定する
	 * 
	 * @param index
	 *            項番
	 * @param master
	 *            主人公
	 */
	public void setMaster(int index, Integer master) {
		masters.set(index, master);
	}

	/**
	 * 主人公を配列として使用しない場合、主人公を取得する
	 * 
	 * @return 主人公
	 */
	public Integer getMaster() {
		return getMaster(0);
	}

	/**
	 * 主人公を取得する
	 * 
	 * @param index
	 *            項番
	 * @return 主人公
	 */
	public Integer getMaster(int index) {
		return masters.get(index);
	}

	/**
	 * 調教中のキャラを配列として使用しない場合、調教中のキャラを設定する
	 * 
	 * @param target
	 *            調教中のキャラ
	 */
	public void setTarget(Integer target) {
		setTarget(0, target);
	}

	/**
	 * 調教中のキャラを設定する
	 * 
	 * @param index
	 *            項番
	 * @param target
	 *            調教中のキャラ
	 */
	public void setTarget(int index, Integer target) {
		targets.set(index, target);
	}

	/**
	 * 調教中のキャラを配列として使用しない場合、調教中のキャラを取得する
	 * 
	 * @return 調教中のキャラ
	 */
	public Integer getTarget() {
		return getTarget(0);
	}

	/**
	 * 調教中のキャラを取得する
	 * 
	 * @param index
	 *            項番
	 * @return 調教中のキャラ
	 */
	public Integer getTarget(int index) {
		return targets.get(index);
	}

	/**
	 * 助手を配列として使用しない場合、助手を設定する
	 * 
	 * @param assistant
	 *            助手
	 */
	public void setAssistant(Integer assistant) {
		setAssistant(0, assistant);
	}

	/**
	 * 助手を設定する
	 * 
	 * @param index
	 *            項番
	 * @param assistant
	 *            助手
	 */
	public void setAssistant(int index, Integer assistant) {
		assistants.set(index, assistant);
	}

	/**
	 * 助手を配列として使用しない場合、助手を取得する
	 * 
	 * @return 助手
	 */
	public Integer getAssistant() {
		return getAssistant(0);
	}

	/**
	 * 助手を取得する
	 * 
	 * @param index
	 *            項番
	 * @return 助手
	 */
	public Integer getAssistant(int index) {
		return assistants.get(index);
	}

	/**
	 * 調教している人間を配列として使用しない場合、調教している人間を設定する
	 * 
	 * @param player
	 *            調教している人間
	 */
	public void setPleyer(Integer player) {
		setPleyer(0, player);
	}

	/**
	 * 調教している人間を設定する
	 * 
	 * @param index
	 *            項番
	 * @param player
	 *            調教している人間
	 */
	public void setPleyer(int index, Integer player) {
		pleyers.set(index, player);
	}

	/**
	 * 調教している人間を配列として使用しない場合、調教している人間を取得する
	 * 
	 * @return 調教している人間
	 */
	public Integer getPleyer() {
		return getPleyer(0);
	}

	/**
	 * 調教している人間を取得する
	 * 
	 * @param index
	 *            項番
	 * @return 調教している人間
	 */
	public Integer getPleyer(int index) {
		return pleyers.get(index);
	}

	/**
	 * 現在登録されているキャラの数を返す
	 * 
	 * @return 現在登録されているキャラの数
	 */
	public int getCharaNum() {
		return registeredCharactors.size();
	}

	public Character registeredIdToCharacter(Integer registeredId){
		return characters.get(registeredCharactors.get(registeredId));
	}
}
