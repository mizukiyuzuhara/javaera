/**
 * Training.java written by Mizuki Yuzuhara, 2012
 * 調教を管理するクラス
 */
package com.eramaker.javaera.training;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

import com.eramaker.javaera.common.GameData;

/**
 * @author Mizuki Yuzuhara
 * @version
 */
public class Training {

	/**
	 * 調教中パラメータのレベルわけの境界値。
	 * 配列定数。
	 */
	public static final List<Integer> PALAM_LEVEL = Collections
			.unmodifiableList(Arrays.asList(0, 100, 500, 3000, 10000, 30000,
					60000, 100000, 150000, 250000, 500000, 1000000));
	/**
	 * 経験のレベルわけの境界値。
	 * 配列定数。
	 */
	public static final List<Integer> EXP_LEVEL = Collections
			.unmodifiableList(Arrays.asList(0, 1, 4, 20, 50, 200, 1000));
	/**
	 * ・射精チェックのときに使う定数。
	 */
	public static final int EJACULATION = 10000;

	/**
	 * 調教コマンドのリスト。
	 * 実際には、入力された番号に相当する調教クラスが呼び出されて実行される。
	 */
	private static TreeMap<Integer, AbstractTraining> trainings;
	/**
	 * 選択されたコマンド。
	 */
	private int selectedCommand;
	/**
	 * 前回選択されたコマンド。
	 * コマンド連続実行ペナルティの判定用。
	 */
	private int previousCommand;
	/**
	 * <b>次回実行される</b>コマンド。
	 * 人工無能を搭載しないかぎり非推奨。
	 * @deprecated
	 */
	private int nextCommand;
	/**
	 * 調教内で用いられるフラグ。
	 */
	private static TreeMap<Integer, Integer> flag;
	
	// getter and setter
	
	/**
	 * trainingsを取得する
	 * @return trainings
	 */
	public static TreeMap<Integer, AbstractTraining> getTrainings() {
		return trainings;
	}
	/**
	 * trainingsを設定する
	 * @param trainings trainingsの設定値
	 */
	public static void setTrainings(TreeMap<Integer, AbstractTraining> trainings) {
		Training.trainings = trainings;
	}
	/**
	 * selectedCommandを取得する
	 * @return selectedCommand
	 */
	public int getSelectedCommand() {
		return selectedCommand;
	}
	/**
	 * selectedCommandを設定する
	 * @param selectedCommand selectedCommandの設定値
	 */
	public void setSelectedCommand(int selectedCommand) {
		this.selectedCommand = selectedCommand;
	}
	/**
	 * previousCommandを取得する
	 * @return previousCommand
	 */
	public int getPreviousCommand() {
		return previousCommand;
	}
	/**
	 * previousCommandを設定する
	 * @param previousCommand previousCommandの設定値
	 */
	public void setPreviousCommand(int previousCommand) {
		this.previousCommand = previousCommand;
	}
	/**
	 * nextCommandを取得する
	 * @return nextCommand
	 * @deprecated
	 */
	public int getNextCommand() {
		return nextCommand;
	}
	/**
	 * nextCommandを設定する
	 * @param nextCommand nextCommandの設定値
	 * @deprecated
	 */
	public void setNextCommand(int nextCommand) {
		this.nextCommand = nextCommand;
	}
	/**
	 * flagを取得する
	 * @return flag
	 */
	public static TreeMap<Integer, Integer> getFlag() {
		return flag;
	}
	/**
	 * flagを設定する
	 * @param flag flagの設定値
	 */
	public static void setFlag(TreeMap<Integer, Integer> flag) {
		Training.flag = flag;
	}

	// constructor
	
	/**
	 * コンストラクタ。
	 * 調教コマンドクラスをここですべて作成してリストに入れること。
	 */
	public  Training(){
		// ここに、コマンド番号、コマンドクラスの順に指定してコマンドリストに入れる。
		// 入れ方は下記を参照のこと。
		trainings.put(999, new Com999_ExitTraining());
	}
	
	// other functions
	
	public static GameData execute(GameData gameData){
		GameData data = gameData;
		boolean loop = true;
		while (loop) {
			
		}
		return data;
	}
	
}
