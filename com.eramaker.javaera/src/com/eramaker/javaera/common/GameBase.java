/**
 * GameBase.java written by Mizuki Yuzuhara, 2012
 * GameBase.csvのラッパー<br>
 * staticではないので、使い道に注意
 */
package com.eramaker.javaera.common;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Mizuki Yuzuhara
 * @version 0.0.2.20120915
 */
public final class GameBase {
	/**
	 * ゲームコード<br>
	 * 別のゲームのセーブデータを誤ってロードしないための識別番号として使用<br>
	 * 32bit整数の範囲内で任意の数を指定してよいが、重複しないよう注意すること
	 */
	private int gameCode;
	/**
	 * ゲームのバージョン<br>
	 * このバージョンがセーブデータに記録され、バージョン違いでのデータ読み込みを制御する<br>
	 * なお、表示上は「このバージョンを1000で割った数」
	 */
	private int gameVersion;
	/**
	 * ゲームのバージョンのうち、パッチ当てによるバージョン違いを識別するもの<br>
	 * すなわち、「ver0.01a」の「a」の部分<br>
	 * セーブデータに影響が出るような変更でない限り、この番号を上げること
	 */
	private String gameSubVersion;
	/**
	 * ゲームのタイトル
	 */
	private String gameTitle;
	/**
	 * ゲームの作者
	 */
	private String gameAuther;
	/**
	 * ゲームの制作年<br>
	 * 「2010-2012」のような表記も可
	 */
	private String gameYear;
	/**
	 * 起動時に表示されるゲームの追加情報<br>
	 * とりあえず何行でも表示できるが、「基本的にシーケンシャル」なので、csvの登録順に注意すること
	 */
	private List<String> gameComment;
	/**
	 * 主人公以外で、ゲーム開始時からいるキャラクターのキャラクター番号
	 */
	private List<Integer> charaInDefault;
	/**
	 * アイテムなしでも調教ができるようにするフラグ<br>
	 * 0=false:調教不可<br>
	 * 1=true:調教可<br>
	 * それ以外は「0」と看做される
	 */
	private boolean noItem;
	/**
	 * バージョン違いによるセーブデータ読み込みの抑止コード<br>
	 * 「この値＞セーブデータのバージョン番号」かつ「gameVersion＞セーブデータのバージョン番号」のとき、セーブデータは読み込まれない<br>
	 * なお、デフォルト値はInteger.MAX
	 */
	private int allowDifferentVersion;
	
	//getter and setter

	/**
	 * gameCodeを取得する
	 * 
	 * @return gameCode
	 */
	int getGameCode() {
		return gameCode;
	}

	/**
	 * gameCodeを設定する
	 * 
	 * @param gameCode
	 *            gameCodeの設定値
	 */
	void setGameCode(int gameCode) {
		this.gameCode = gameCode;
	}

	/**
	 * gameVersionを取得する
	 * 
	 * @return gameVersion
	 */
	int getGameVersion() {
		return gameVersion;
	}

	/**
	 * gameVersionを設定する
	 * 
	 * @param gameVersion
	 *            gameVersionの設定値
	 */
	void setGameVersion(int gameVersion) {
		this.gameVersion = gameVersion;
	}

	/**
	 * gameSubVersionを取得する
	 * 
	 * @return gameSubVersion
	 */
	String getGameSubVersion() {
		return gameSubVersion;
	}

	/**
	 * gameSubVersionを設定する
	 * 
	 * @param gameSubVersion
	 *            gameSubVersionの設定値
	 */
	void setGameSubVersion(String gameSubVersion) {
		this.gameSubVersion = gameSubVersion;
	}

	/**
	 * gameTitleを取得する
	 * 
	 * @return gameTitle
	 */
	String getGameTitle() {
		return gameTitle;
	}

	/**
	 * gameTitleを設定する
	 * 
	 * @param gameTitle
	 *            gameTitleの設定値
	 */
	void setGameTitle(String gameTitle) {
		this.gameTitle = gameTitle;
	}

	/**
	 * gameAutherを取得する
	 * 
	 * @return gameAuther
	 */
	String getGameAuther() {
		return gameAuther;
	}

	/**
	 * gameAutherを設定する
	 * 
	 * @param gameAuther
	 *            gameAutherの設定値
	 */
	void setGameAuther(String gameAuther) {
		this.gameAuther = gameAuther;
	}

	/**
	 * gameYearを取得する
	 * 
	 * @return gameYear
	 */
	String getGameYear() {
		return gameYear;
	}

	/**
	 * gameYearを設定する
	 * 
	 * @param gameYear
	 *            gameYearの設定値
	 */
	void setGameYear(String gameYear) {
		this.gameYear = gameYear;
	}

	/**
	 * gameCommentを取得する
	 * 
	 * @return gameComment
	 */
	List<String> getGameComment() {
		return gameComment;
	}

	/**
	 * gameCommentを設定する
	 * 
	 * @param gameComment
	 *            gameCommentの設定値
	 */
	void setGameComment(List<String> gameComment) {
		this.gameComment = gameComment;
	}

	/**
	 * charaInDefaultを取得する
	 * 
	 * @return charaInDefault
	 */
	List<Integer> getCharaInDefault() {
		return charaInDefault;
	}

	/**
	 * charaInDefaultを設定する
	 * 
	 * @param charaInDefault
	 *            charaInDefaultの設定値
	 */
	void setCharaInDefault(List<Integer> charaInDefault) {
		this.charaInDefault = charaInDefault;
	}

	/**
	 * noItemを取得する
	 * 
	 * @return noItem
	 */
	boolean isNoItem() {
		return noItem;
	}

	/**
	 * noItemを設定する
	 * 
	 * @param noItem
	 *            noItemの設定値
	 */
	void setNoItem(boolean noItem) {
		this.noItem = noItem;
	}

	/**
	 * allowDifferentVersionを取得する
	 * 
	 * @return allowDifferentVersion
	 */
	int getAllowDifferentVersion() {
		return allowDifferentVersion;
	}

	/**
	 * allowDifferentVersionを設定する
	 * 
	 * @param allowDifferentVersion
	 *            allowDifferentVersionの設定値
	 */
	void setAllowDifferentVersion(int allowDifferentVersion) {
		this.allowDifferentVersion = allowDifferentVersion;
	}
	
	// constructor
	/**
	 * コンストラクタ
	 */
	public GameBase(){
		// 枠の確保
		ArrayList<ArrayList<String>> cells = new ArrayList<ArrayList<String>>();
		// CSVをばらす
		try {
			cells = CSVDecomposer.decompose("csv/gamebase.csv");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		// ばらしたものを振り分ける
		for (ArrayList<String> columns : cells) {
			if (columns.get(0).equals("コード")) {
				setGameCode(Integer.parseInt(columns.get(1)));
			} else if(columns.get(0).equals("バージョン")) {
				setGameVersion(Integer.parseInt(columns.get(1)));
				//todo 続く
			}
		}
	}
}
