/**
 * Training.java written by Mizuki Yuzuhara, 2012
 * 調教を管理するクラス
 */
package com.eramaker.javaera.training;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

import com.eramaker.javaera.common.EraMain;
import com.eramaker.javaera.common.IOControl;
import com.eramaker.javaera.common.IllegalInputException;
import com.eramaker.javaera.training.command.AbstractTraining;

/**
 * @author Mizuki Yuzuhara
 * @version
 */
public class Training {

	/**
	 * 調教中パラメータのレベルわけの境界値。 配列定数。
	 */
	public static final List<Integer> PALAM_LEVEL = Collections
			.unmodifiableList(Arrays.asList(0, 100, 500, 3000, 10000, 30000,
					60000, 100000, 150000, 250000, 500000, 1000000));
	/**
	 * 経験のレベルわけの境界値。 配列定数。
	 */
	public static final List<Integer> EXP_LEVEL = Collections
			.unmodifiableList(Arrays.asList(0, 1, 4, 20, 50, 200, 1000));
	/**
	 * ・射精チェックのときに使う定数。
	 */
	public static final int EJACULATION = 10000;

	/**
	 * 選択されたコマンド。
	 */
	private int selectedCommand;
	/**
	 * 前回選択されたコマンド。 コマンド連続実行ペナルティの判定用。
	 */
	private int previousCommand;
	/**
	 * <b>次回実行される</b>コマンド。 人工無能を搭載しないかぎり非推奨。
	 * 
	 * @deprecated
	 */
	private int nextCommand;
	/**
	 * 調教内で用いられるフラグ。
	 */
	private static TreeMap<Integer, Integer> flag;

	// getter and setter

	/**
	 * selectedCommandを取得する
	 * 
	 * @return selectedCommand
	 */
	public int getSelectedCommand() {
		return selectedCommand;
	}

	/**
	 * selectedCommandを設定する
	 * 
	 * @param selectedCommand
	 *            selectedCommandの設定値
	 */
	public void setSelectedCommand(int selectedCommand) {
		this.selectedCommand = selectedCommand;
	}

	/**
	 * previousCommandを取得する
	 * 
	 * @return previousCommand
	 */
	public int getPreviousCommand() {
		return previousCommand;
	}

	/**
	 * previousCommandを設定する
	 * 
	 * @param previousCommand
	 *            previousCommandの設定値
	 */
	public void setPreviousCommand(int previousCommand) {
		this.previousCommand = previousCommand;
	}

	/**
	 * nextCommandを取得する
	 * 
	 * @return nextCommand
	 * @deprecated
	 */
	public int getNextCommand() {
		return nextCommand;
	}

	/**
	 * nextCommandを設定する
	 * 
	 * @param nextCommand
	 *            nextCommandの設定値
	 * @deprecated
	 */
	public void setNextCommand(int nextCommand) {
		this.nextCommand = nextCommand;
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
		Training.flag = flag;
	}

	// other mothods

	public static TrainingData execute(TrainingData gameData) {
		TrainingData data = gameData;
		boolean loop = true;
		while (loop) {
			// 選択可能なコマンド番号とコマンド名のリストを出力する
			showCommandList();
			// コマンド番号の入力を受けてコマンドを実行する
			try {
				Integer i = IOControl.readInteger();
				AbstractTraining abstractTraining = EraMain.trainingList
						.getTraining(i);
				data = abstractTraining.execute(data);
				// ここで体力等の判定を行い、調教終了なら例外を返す
			} catch (IOException e) {
				IOControl.writeLine("入力が正常に行われていません。もう一度やり直してください。");
			} catch (IllegalInputException e) {
				IOControl.writeLine("コマンドが正しくありません。もう一度入力してください。");
			} catch (EndTrainingException e) {
				IOControl.writeLine("（調教を終了します。）");
				loop = false;
			}
		}
		// パラメータを珠に変換する
		return data;
	}

	/**
	 * コマンドリストを出力する。
	 */
	private static void showCommandList() {
		// setCommandList();
		List<String> list = new ArrayList<String>();
		list.addAll(setCommandList(false));
		list.addAll(setCommandList(true));
		IOControl.writeLines(list);
	}

	/**
	 * コマンドリストを出力するのにコマンドがシステムコマンドか否かで同じ処理を2度するので、その1回分を行う。
	 * 
	 * @param isSystem
	 *            システムコマンドか否かのフラグ
	 * @return 整形済みのリスト
	 */
	private static List<String> setCommandList(boolean isSystem) {
		StringBuffer string = new StringBuffer();
		List<String> list = new ArrayList<String>();
		int count = 0;
		for (Integer trainId : EraMain.trainingList.keySet()) {
			AbstractTraining abstractTraining;
			try {
				abstractTraining = EraMain.trainingList.getTraining(trainId);
				if (abstractTraining.isSelectable()
						&& abstractTraining.isShownTailOfList() == isSystem) {
					StringBuilder builder = new StringBuilder();
					// まず詰め物をする
					for (int i = 0; i < 18 - abstractTraining.getName()
							.length(); i++) {
						builder.append(" ");
					}
					builder.append(abstractTraining.getName());
					switch (Integer.toString(abstractTraining.getId()).length()) {
					case 1:
						builder.append("[  ");
						break;
					case 2:
						builder.append("[ ");
						break;
					default:
						builder.append("[");
						break;
					}
					builder.append(Integer.toString(abstractTraining.getId())
							+ "]");
					string.append(builder);
					count++;
					switch (count % 3) {
					case 0:
						list.add(new String(string));
						string = string.delete(0, string.length());
						break;
					default:
						string.append("  ");
						break;
					}
				}
			} catch (IllegalInputException e) {
				e.printStackTrace(); // 該当するコマンドが存在するはずなので、ここには飛んでこない
			}
		} // for loop
			// ループの最後に残り物をlistへ移す
		if (string.length() > 0) {
			list.add(new String(string));
		}
		return list;
	}

}
