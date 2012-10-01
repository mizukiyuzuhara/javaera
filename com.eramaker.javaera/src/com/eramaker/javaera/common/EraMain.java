/**
 * EraMain.java written by Mizuki Yuzuhara, 2012.
 * ゲームのメインストリーム。
 * 個々の詳細な処理は専用クラスをこのクラス上から呼び出し、このクラスは全体を管理することに専念する。
 */
/*
 * <チラシの裏>
 * このクラスに連なるクラスはあくまでフレームワークなので、各ゲームに依存する項目はJARを分けてオーバーライド推奨。
 * ゲームごとにこのクラスを書き換えると、後で収拾がつかなくなるので、根幹に関わる部分のみの改造に心がけること。
 * </チラシの裏>
 */
package com.eramaker.javaera.common;


/**
 * @author Mizuki Yuzuhara
 * @version 0.1.20120928
 */
public class EraMain {
	
	/**
	 * 基礎データ。
	 */
	public static GameBase base;
	/**
	 * ゲーム内のデータ。
	 * 基本的には、必要な項目を転がしていくので、これを直接呼び出さないこと。
	 */
	public static GameData gameData;

	// other methods
	
	/**
	 * 辞書を初期化する
	 */
	public static void initialize() {
		base = new GameBase();
	}

}
