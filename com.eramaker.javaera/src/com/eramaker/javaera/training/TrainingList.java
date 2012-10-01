/**
 * TrainingList.java written by Mizuki Yuzuhara, 2012.
 * 調教リスト。表示するしないはともかく、ゲーム開始時に一覧は作成すること。
 */
package com.eramaker.javaera.training;

import java.util.TreeMap;

import com.eramaker.javaera.common.IllegalInputException;
import com.eramaker.javaera.training.command.AbstractTrainCommand;
import com.eramaker.javaera.training.command.Com999_ExitTraining;

/**
 * @author Mizuki Yuzuhara
 * @version 0.1.20120928
 */
public class TrainingList extends TreeMap<Integer, AbstractTrainCommand> {

	/**
	 * シリアルバージョン番号。
	 */
	private static final long serialVersionUID = 1L;

	// constructor

	public TrainingList() {
		// ここに、コマンド番号、調教クラスの順に指定してコマンドリストに入れる。
		// 入れ方は下記を参照のこと。
		put(999, new Com999_ExitTraining());
	}

	// other methods

	/**
	 * 入力したコマンド番号に対応する調教コマンドを返す。 該当するものがない場合、例外を返す。
	 * 
	 * @param integer
	 *            コマンド番号
	 * @return コマンド番号に対応する調教コマンド
	 * @throws IllegalInputException コマンド番号に該当する調教コマンドがない場合
	 */
	public AbstractTrainCommand getTraining(Integer integer)
			throws IllegalInputException {
		AbstractTrainCommand training = get(integer);
		if (training == null) {
			throw new IllegalInputException();
		} else {
			return training;
		}
	}

}
