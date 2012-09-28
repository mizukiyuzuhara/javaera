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

import com.eramaker.javaera.character.CharacterList;
import com.eramaker.javaera.shop.ItemList;
import com.eramaker.javaera.training.TrainingList;

/**
 * @author Mizuki Yuzuhara
 * @version 0.1.20120928
 */
public class EraMain {
	
	/**
	 * ゲーム上で使用する辞書一式。
	 */
	public static GameDictionaries dictionaries;
	/**
	 * 調教リスト。
	 */
	public static TrainingList trainingList;
	/**
	 * アイテムリスト。
	 */
	public static ItemList itemList;
	public static CharacterList characterList;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 辞書を初期化する
		dictionaries.initialize();
		trainingList = new TrainingList();
		itemList = new ItemList();
		characterList = new CharacterList();
		// TODO 自動生成されたメソッド・スタブ

	}

}
