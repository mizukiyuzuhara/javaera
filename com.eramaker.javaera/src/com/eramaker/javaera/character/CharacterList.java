/**
 * CharacterList.java written by Mizuki Yuzuhara, 2012.
 * キャラの一覧を扱うリスト。
 * <b>ゲーム起動時のデフォルト値を取る</b>ので、
 */
package com.eramaker.javaera.character;

import java.io.File;
import java.io.FilenameFilter;
import java.util.TreeMap;

import org.apache.commons.io.filefilter.WildcardFileFilter;

/**
 * @author Mizuki Yuzuhara
 * @version 
 */
public class CharacterList extends TreeMap<Integer, Character> {

	/**
	 * シリアルバージョン番号
	 */
	private static final long serialVersionUID = 1L;

	// constructor
	/**
	 * コンストラクタ。
	 */
	/*
	 * <チラシの裏>
	 * <b>キャラ数だけファイルをなめるので</b>この処理は時間を食う。
	 * スレッドを使えるなら、この処理だけスレッドに投げるのも手。
	 * また、クラスを作る手間を惜しまないならば、継承したクラスをキャラごとに作るのも手ではある。
	 * </チラシの裏>
	 */
	public CharacterList(){
		File dir = new File("csv");
		String[] fileList = dir.list((FilenameFilter) new WildcardFileFilter("Chara*.csv"));
		for (int i = 0; i < fileList.length; i++) {
			Character character = new Character(fileList[i]);
			put(character.getId(), character);
		}
	}
	
}
