/**
 * AbstructTraining.java written by Mizuki Yuzuhara, 2012
 * 調教内容の仮想オブジェクト。
 * 調教内容により、overrideすること。
 */
package com.eramaker.javaera.training.command;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import com.eramaker.javaera.character.Character;
import com.eramaker.javaera.training.EndTrainingException;
import com.eramaker.javaera.training.ParamsOnCommand;
import com.eramaker.javaera.training.TrainingData;

/**
 * @author Mizuki Yuzuhara
 * @version
 */
public abstract class AbstractTrainCommand {

	/**
	 * 調教番号。
	 */
	protected int id;
	/**
	 * 調教の名称。 これが表示されるので、長さに注意。
	 */
	protected String name;
	/**
	 * この調教を選択できるか否か。 falseの場合表示から外される。
	 */
	protected boolean selectable;
	/**
	 * システムコマンドか否か。 trueの場合システムコマンドとしてコマンドリストの最後に表示。
	 */
	protected boolean shownTailOfList;

	// getter and setter

	/**
	 * idを取得する
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * idを設定する
	 * 
	 * @param id
	 *            idの設定値
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * nameを取得する
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * nameを設定する
	 * 
	 * @param name
	 *            nameの設定値
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * selectableを取得する
	 * 
	 * @return selectable
	 */
	public boolean isSelectable() {
		return selectable;
	}

	/**
	 * selectableを設定する
	 * 
	 * @param selectable
	 *            selectableの設定値
	 */
	public void setSelectable(boolean selectable) {
		this.selectable = selectable;
	}

	/**
	 * shownTailOfListを取得する
	 * 
	 * @return shownTailOfList
	 */
	public boolean isShownTailOfList() {
		return shownTailOfList;
	}

	/**
	 * shownTailOfListを設定する
	 * 
	 * @param shownTailOfList
	 *            shownTailOfListの設定値
	 */
	public void setShownTailOfList(boolean shownTailOfList) {
		this.shownTailOfList = shownTailOfList;
	}

	// other functions

	/**
	 * 調教コマンドにより調教されるキャラが調教するキャラから受ける影響を計算し、調教されるキャラを返す。
	 * 調教されるキャラはするキャラの影響を受けるので、調教されるキャラごとに逐一判定すること。
	 * 
	 * @param target
	 *            調教されるキャラ
	 * @param pleyers
	 *            調教するキャラ（いるだけ）
	 * @return 調教結果
	 */
	abstract protected ParamsOnCommand measureEffectOfTarget(
			Character target, ArrayList<Integer> pleyers);

	/**
	 * 調教コマンドにより調教するキャラが受ける影響を計算し、調教するキャラを返す。 調教するキャラはされるキャラの<b>人数に</b>影響を受ける。
	 * 従って、同じするキャラでも関与の度合いによりされるキャラの人数がかわることもあるので、うまく調整すること。
	 * 
	 * @param pleyer
	 *            調教するキャラ
	 * @param countOfTargets
	 *            調教されるキャラの人数（換算値）
	 * @return 調教結果
	 */
	abstract protected ParamsOnCommand measureEffectOfPleyer(Character pleyer,
			int countOfTargets);

	/**
	 * 調教コマンドが使用可能かチェックしなおし、その結果を返す。
	 * 直前のコマンドの絡みでsetSelectableが外部から呼ばれている可能性があるので、isSelectableの丸投げにしないこと。
	 * 
	 * @return コマンドが使用可能かチェックした結果
	 */
	abstract public boolean canSelect();

	/**
	 * 調教コマンドを実行する。
	 * 
	 * @param gameData
	 *            調教コマンドとして必要なデータ一式
	 * @throws EndTrainingException
	 *             調教を終了させるとき
	 */
	public TrainingData execute(TrainingData gameData)
			throws EndTrainingException {
		ArrayList<Integer> targetList = gameData.getTargets();
		ArrayList<Integer> pleyerList = gameData.getPleyers();
		TrainingData data = gameData;
		Map<Integer, ParamsOnCommand> commandMap = new TreeMap<Integer, ParamsOnCommand>();
		for (Integer integer : targetList) {
			Character target = data.registeredIdToCharacter(integer);
			ParamsOnCommand onCommand =measureEffectOfTarget(target, pleyerList);
			// ターゲットに同一キャラは重複しない
			commandMap.put(integer, onCommand);
		}
		for (Integer integer : pleyerList) {
			// Character pleyer = data.getCharacters().get(integer);
			Character pleyer = data.registeredIdToCharacter(integer);
			ParamsOnCommand onCommand = measureEffectOfPleyer(pleyer, targetList.size());
			// ターゲットとプレーヤーは重複するかもしれないが、とりあえず考えない
			commandMap.put(integer, onCommand);
		}
		// コマンドの結果を調教全体の結果に落とし込む
		// TODO under construction
		return data;
	}

}
