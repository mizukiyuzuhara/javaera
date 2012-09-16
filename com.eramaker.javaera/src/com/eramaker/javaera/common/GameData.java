/**
 * GameData.java written by Mizuki Yuzuhara, 2012
 * eramakerのゲームデータを管理するクラス<br />
 * すべてセーブされるので扱いには注意すること<br />
 * 特に、無駄な配列は作らないこと<br>
 * なお、必要そうなものは可能な限りコレクション化している
 */
package com.eramaker.javaera.common;

import java.util.ArrayList;

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
	
	// getter and setter
	
	/**
	 * gameCodeを取得する
	 * @return gameCode
	 */
	public static int getGameCode() {
		return gameCode;
	}
	/**
	 * gameVersionを取得する
	 * @return gameVersion
	 */
	public static int getGameVersion() {
		return gameVersion;
	}
	/**
	 * gameVersionを設定する
	 * @param gameVersion gameVersionの設定値
	 */
	public static void setGameVersion(int gameVersion) {
		GameData.gameVersion = gameVersion;
	}
	/**
	 * gameCodeを設定する
	 * @param gameCode gameCodeの設定値
	 */
	public static void setGameCode(int gameCode) {
		GameData.gameCode = gameCode;
	}
	/**
	 * daysを取得する
	 * @return days
	 */
	public static ArrayList<Integer> getDays() {
		return days;
	}
	/**
	 * daysを設定する
	 * @param days daysの設定値
	 */
	public static void setDays(ArrayList<Integer> days) {
		GameData.days = days;
	}
	/**
	 * timesを取得する
	 * @return times
	 */
	public static ArrayList<Integer> getTimes() {
		return times;
	}
	/**
	 * timesを設定する
	 * @param times timesの設定値
	 */
	public static void setTimes(ArrayList<Integer> times) {
		GameData.times = times;
	}
	/**
	 * moneysを取得する
	 * @return moneys
	 */
	public static ArrayList<Integer> getMoneys() {
		return moneys;
	}
	/**
	 * moneysを設定する
	 * @param moneys moneysの設定値
	 */
	public static void setMoneys(ArrayList<Integer> moneys) {
		GameData.moneys = moneys;
	}
	/**
	 * mastersを取得する
	 * @return masters
	 */
	public static ArrayList<Integer> getMasters() {
		return masters;
	}
	/**
	 * mastersを設定する
	 * @param masters mastersの設定値
	 */
	public static void setMasters(ArrayList<Integer> masters) {
		GameData.masters = masters;
	}
	/**
	 * targetsを取得する
	 * @return targets
	 */
	public static ArrayList<Integer> getTargets() {
		return targets;
	}
	/**
	 * targetsを設定する
	 * @param targets targetsの設定値
	 */
	public static void setTargets(ArrayList<Integer> targets) {
		GameData.targets = targets;
	}
	/**
	 * assistantsを取得する
	 * @return assistants
	 */
	public static ArrayList<Integer> getAssistants() {
		return assistants;
	}
	/**
	 * assistantsを設定する
	 * @param assistants assistantsの設定値
	 */
	public static void setAssistants(ArrayList<Integer> assistants) {
		GameData.assistants = assistants;
	}
	/**
	 * pleyersを取得する
	 * @return pleyers
	 */
	public static ArrayList<Integer> getPleyers() {
		return pleyers;
	}
	/**
	 * pleyersを設定する
	 * @param pleyers pleyersの設定値
	 */
	public static void setPleyers(ArrayList<Integer> pleyers) {
		GameData.pleyers = pleyers;
	}
	/**
	 * registeredCharactorsを取得する
	 * @return registeredCharactors
	 */
	public static ArrayList<Integer> getRegisteredCharactors() {
		return registeredCharactors;
	}
	/**
	 * registeredCharactorsを設定する
	 * @param registeredCharactors registeredCharactorsの設定値
	 */
	public static void setRegisteredCharactors(ArrayList<Integer> registeredCharactors) {
		GameData.registeredCharactors = registeredCharactors;
	}
	
}
