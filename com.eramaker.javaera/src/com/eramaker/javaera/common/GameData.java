/**
 * GameData.java written by Mizuki Yuzuhara, 2012
 * eramakerのゲームデータを管理するクラス<br />
 * すべてセーブされるので扱いには注意すること<br />
 * 特に、無駄な配列は作らないこと<br>
 * なお、必要そうなものは可能な限りコレクション化している
 */
package com.eramaker.javaera.common;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * @author Mizuki Yuzuhara
 * @version 0.1.20120914
 */
public class GameData {
	/**
	 * ゲームコード<br>
	 * 別のゲームのセーブデータを誤ってロードしないための識別番号として使用<br>
	 * 32bit整数の範囲内で任意の数を指定してよいが、重複しないよう注意すること
	 */
	private static int gameCode;
	/**
	 * ゲームのバージョン<br>
	 * このバージョンがセーブデータに記録され、バージョン違いでのデータ読み込みを制御する<br>
	 * なお、表示上は「このバージョンを1000で割った数」
	 */
	private static int gameVersion;
	/**
	 * ゲームのバージョンのうち、パッチ当てによるバージョン違いを識別するもの<br>
	 * すなわち、「ver0.01a」の「a」の部分<br>
	 * セーブデータに影響が出るような変更でない限り、この番号を上げること
	 */
	/**
	 * 日付を制御する<br>
	 * 曜日を求める必要があるときは、これの#get(0)を7で割って余りを曜日に当てはめると早いかも<br>
	 * コレクション化しているので、カレンダー制御することも可能、だと思う
	 */
	private static ArrayList<Integer> days;
	/**
	 * 時間を制御する<br>
	 * 意味があるかどうかはわからないが、一応コレクション化
	 */
	private static ArrayList<Integer> times;
	/**
	 * 資金を制御する
	 */
	private static ArrayList<Integer> moneys;
	/**
	 * 主人公のキャラの<b>登録番号</b>を制御する<br>
	 * 通常1人しかいないとは思うが、一応コレクション化
	 */
	private static ArrayList<Integer> masters;
	/**
	 * 調教中のキャラの<b>登録番号</b>を制御する<br>
	 * 通常1人だろうが、3P、4P、…をやりたいときのことを考えて、コレクション化
	 */
	private static ArrayList<Integer> targets;
	/**
	 * 助手のキャラの<b>登録番号</b>を制御する<br>
	 * 通常1人だろうが、（ｒｙコレクション化
	 */
	private static ArrayList<Integer> assistants;
	/**
	 * 調教している人間のキャラの<b>登録番号</b>を制御する<br>
	 * 正直誰得なのだが、コレクション化しておく
	 */
	private static ArrayList<Integer> pleyers;
	/**
	 * キャラの<b>登録番号そのものを</b>を制御する<br>
	 * このArrayListは<b>#get(0)を返す関数を持たない</b>ので注意
	 */
	private static ArrayList<Integer> registeredCharactors;
	/**
	 * <b>キャラそのものを</b>制御する<br>
	 * Charactor型を持つので、<b>デフォルトを維持する必要はない</b>し、<b>想定もしていない</b><br>
	 * これも<b>#get(0)を返す関数を持たない</b>
	 */
	private static TreeMap<Integer, Charactor> charactors;
	/**
	 * 購入可能なキャラを制御する<br>
	 * eramakerではアイテムの売買で制御しているっぽいが、敢えて分けている
	 */
	private static ArrayList<Integer> charactorInShop;
	/**
	 * 所持アイテムを制御する<br>
	 * 消耗アイテムもあるので、「あるなし」の制御をしないこと
	 */
	private static TreeMap<Integer, Integer> items;
	/**
	 * 購入可能なアイテムを制御する
	 */
	private static ArrayList<Integer> itemInShop;
	/**
	 * フラグを制御する
	 */
	private static TreeMap<Integer, Integer> flag;

	// getter and setter

	/**
	 * gameCodeを取得する
	 * 
	 * @return gameCode
	 */
	public static int getGameCode() {
		return gameCode;
	}

	/**
	 * gameVersionを取得する
	 * 
	 * @return gameVersion
	 */
	public static int getGameVersion() {
		return gameVersion;
	}

	/**
	 * gameVersionを設定する
	 * 
	 * @param gameVersion
	 *            gameVersionの設定値
	 */
	public static void setGameVersion(int gameVersion) {
		GameData.gameVersion = gameVersion;
	}

	/**
	 * gameCodeを設定する
	 * 
	 * @param gameCode
	 *            gameCodeの設定値
	 */
	public static void setGameCode(int gameCode) {
		GameData.gameCode = gameCode;
	}

	/**
	 * daysを取得する
	 * 
	 * @return days
	 */
	public static ArrayList<Integer> getDays() {
		return days;
	}

	/**
	 * daysを設定する
	 * 
	 * @param days
	 *            daysの設定値
	 */
	public static void setDays(ArrayList<Integer> days) {
		GameData.days = days;
	}

	/**
	 * timesを取得する
	 * 
	 * @return times
	 */
	public static ArrayList<Integer> getTimes() {
		return times;
	}

	/**
	 * timesを設定する
	 * 
	 * @param times
	 *            timesの設定値
	 */
	public static void setTimes(ArrayList<Integer> times) {
		GameData.times = times;
	}

	/**
	 * moneysを取得する
	 * 
	 * @return moneys
	 */
	public static ArrayList<Integer> getMoneys() {
		return moneys;
	}

	/**
	 * moneysを設定する
	 * 
	 * @param moneys
	 *            moneysの設定値
	 */
	public static void setMoneys(ArrayList<Integer> moneys) {
		GameData.moneys = moneys;
	}

	/**
	 * mastersを取得する
	 * 
	 * @return masters
	 */
	public static ArrayList<Integer> getMasters() {
		return masters;
	}

	/**
	 * mastersを設定する
	 * 
	 * @param masters
	 *            mastersの設定値
	 */
	public static void setMasters(ArrayList<Integer> masters) {
		GameData.masters = masters;
	}

	/**
	 * targetsを取得する
	 * 
	 * @return targets
	 */
	public static ArrayList<Integer> getTargets() {
		return targets;
	}

	/**
	 * targetsを設定する
	 * 
	 * @param targets
	 *            targetsの設定値
	 */
	public static void setTargets(ArrayList<Integer> targets) {
		GameData.targets = targets;
	}

	/**
	 * assistantsを取得する
	 * 
	 * @return assistants
	 */
	public static ArrayList<Integer> getAssistants() {
		return assistants;
	}

	/**
	 * assistantsを設定する
	 * 
	 * @param assistants
	 *            assistantsの設定値
	 */
	public static void setAssistants(ArrayList<Integer> assistants) {
		GameData.assistants = assistants;
	}

	/**
	 * pleyersを取得する
	 * 
	 * @return pleyers
	 */
	public static ArrayList<Integer> getPleyers() {
		return pleyers;
	}

	/**
	 * pleyersを設定する
	 * 
	 * @param pleyers
	 *            pleyersの設定値
	 */
	public static void setPleyers(ArrayList<Integer> pleyers) {
		GameData.pleyers = pleyers;
	}

	/**
	 * registeredCharactorsを取得する
	 * 
	 * @return registeredCharactors
	 */
	public static ArrayList<Integer> getRegisteredCharactors() {
		return registeredCharactors;
	}

	/**
	 * registeredCharactorsを設定する
	 * 
	 * @param registeredCharactors
	 *            registeredCharactorsの設定値
	 */
	public static void setRegisteredCharactors(
			ArrayList<Integer> registeredCharactors) {
		GameData.registeredCharactors = registeredCharactors;
	}

	/**
	 * charactorsを取得する
	 * 
	 * @return charactors
	 */
	public static TreeMap<Integer, Charactor> getCharactors() {
		return charactors;
	}

	/**
	 * charactorsを設定する
	 * 
	 * @param charactors
	 *            charactorsの設定値
	 */
	public static void setCharactors(TreeMap<Integer, Charactor> charactors) {
		GameData.charactors = charactors;
	}

	/**
	 * charactorInShopを取得する
	 * 
	 * @return charactorInShop
	 */
	public static ArrayList<Integer> getCharactorInShop() {
		return charactorInShop;
	}

	/**
	 * charactorInShopを設定する
	 * 
	 * @param charactorInShop
	 *            charactorInShopの設定値
	 */
	public static void setCharactorInShop(ArrayList<Integer> charactorInShop) {
		GameData.charactorInShop = charactorInShop;
	}

	/**
	 * itemsを取得する
	 * 
	 * @return items
	 */
	public static TreeMap<Integer, Integer> getItems() {
		return items;
	}

	/**
	 * itemsを設定する
	 * 
	 * @param items
	 *            itemsの設定値
	 */
	public static void setItems(TreeMap<Integer, Integer> items) {
		GameData.items = items;
	}

	/**
	 * itemInShopを取得する
	 * 
	 * @return itemInShop
	 */
	public static ArrayList<Integer> getItemInShop() {
		return itemInShop;
	}

	/**
	 * itemInShopを設定する
	 * 
	 * @param itemInShop
	 *            itemInShopの設定値
	 */
	public static void setItemInShop(ArrayList<Integer> itemInShop) {
		GameData.itemInShop = itemInShop;
	}

	/**
	 * flagを取得する
	 * 
	 * @return flag
	 */
	public static TreeMap<Integer, Integer> getFlag() {
		return flag;
	}

	/**
	 * flagを設定する
	 * 
	 * @param flag
	 *            flagの設定値
	 */
	public static void setFlag(TreeMap<Integer, Integer> flag) {
		GameData.flag = flag;
	}

	// other functions
	/**
	 * 日付を配列として使用しない場合、日付を設定する
	 * 
	 * @param day
	 *            日付（days#get(0)）
	 */
	public static void setDay(Integer day) {
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
	public static void setDay(int index, Integer day) {
		days.set(index, day);
	}

	/**
	 * 日付を配列として使用しない場合、日付を取得する
	 * 
	 * @return 日付（days#get(0)）
	 */
	public static Integer getDay() {
		return getDay(0);
	}

	/**
	 * 日付を取得する
	 * 
	 * @param index
	 *            項番
	 * @return 日付
	 */
	public static Integer getDay(Integer index) {
		return days.get(index);
	}

	/**
	 * 時間を配列として使用しない場合、時間を設定する
	 * 
	 * @param time
	 *            時間（times#get(0)）
	 */
	public static void setTime(Integer time) {
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
	public static void setTime(int index, Integer time) {
		times.set(index, time);
	}

	/**
	 * 時間を配列として使用しない場合、時間を取得する
	 * 
	 * @return 時間（times#get(0)）
	 */
	public static Integer getTime() {
		return getTime(0);
	}

	/**
	 * 時間を取得する
	 * 
	 * @param index
	 *            項番
	 * @return 時間
	 */
	public static Integer getTime(int index) {
		return times.get(index);
	}

	/**
	 * 所持金を配列として使用しない場合、所持金を設定する
	 * 
	 * @param money
	 */
	public static void setMoney(Integer money) {
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
	public static void setMoney(int index, Integer money) {
		moneys.set(index, money);
	}

	/**
	 * 所持金を配列として使用しない場合、所持金を取得する
	 * 
	 * @return 所持金
	 */
	public static Integer getMoney() {
		return getMoney(0);
	}

	/**
	 * 所持金を取得する
	 * 
	 * @param index
	 *            項番
	 * @return 所持金
	 */
	public static Integer getMoney(int index) {
		return moneys.get(index);
	}

	/**
	 * 所持金のスタックが複数あるとき、その総合計を取得する
	 * 
	 * @return 所持金の総合計
	 */
	public static Integer getTotalMoney() {
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
	public static void setMaster(Integer master) {
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
	public static void setMaster(int index, Integer master) {
		masters.set(index, master);
	}

	/**
	 * 主人公を配列として使用しない場合、主人公を取得する
	 * 
	 * @return 主人公
	 */
	public static Integer getMaster() {
		return getMaster(0);
	}

	/**
	 * 主人公を取得する
	 * 
	 * @param index
	 *            項番
	 * @return 主人公
	 */
	public static Integer getMaster(int index) {
		return masters.get(index);
	}

	/**
	 * 調教中のキャラを配列として使用しない場合、調教中のキャラを設定する
	 * 
	 * @param target
	 *            調教中のキャラ
	 */
	public static void setTarget(Integer target) {
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
	public static void setTarget(int index, Integer target) {
		targets.set(index, target);
	}

	/**
	 * 調教中のキャラを配列として使用しない場合、調教中のキャラを取得する
	 * 
	 * @return 調教中のキャラ
	 */
	public static Integer getTarget() {
		return getTarget(0);
	}

	/**
	 * 調教中のキャラを取得する
	 * 
	 * @param index
	 *            項番
	 * @return 調教中のキャラ
	 */
	public static Integer getTarget(int index) {
		return targets.get(index);
	}

	/**
	 * 助手を配列として使用しない場合、助手を設定する
	 * 
	 * @param assistant
	 *            助手
	 */
	public static void setAssistant(Integer assistant) {
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
	public static void setAssistant(int index, Integer assistant) {
		assistants.set(index, assistant);
	}

	/**
	 * 助手を配列として使用しない場合、助手を取得する
	 * 
	 * @return 助手
	 */
	public static Integer getAssistant() {
		return getAssistant(0);
	}

	/**
	 * 助手を取得する
	 * 
	 * @param index
	 *            項番
	 * @return 助手
	 */
	public static Integer getAssistant(int index) {
		return assistants.get(index);
	}

	/**
	 * 調教している人間を配列として使用しない場合、調教している人間を設定する
	 * 
	 * @param player
	 *            調教している人間
	 */
	public static void setPleyer(Integer player) {
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
	public static void setPleyer(int index, Integer player) {
		pleyers.set(index, player);
	}

	/**
	 * 調教している人間を配列として使用しない場合、調教している人間を取得する
	 * 
	 * @return 調教している人間
	 */
	public static Integer getPleyer() {
		return getPleyer(0);
	}

	/**
	 * 調教している人間を取得する
	 * 
	 * @param index
	 *            項番
	 * @return 調教している人間
	 */
	public static Integer getPleyer(int index) {
		return pleyers.get(index);
	}

	/**
	 * 現在登録されているキャラの数を返す
	 * 
	 * @return 現在登録されているキャラの数
	 */
	public static int getCharaNum() {
		return registeredCharactors.size();
	}

}
