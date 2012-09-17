/**
 * Charactor.java written by Mizuki Yuzuhara, 2012
 * キャラデータを扱うクラス
 */
package com.eramaker.javaera.common;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author Mizuki Yuzuhara
 * @version 0.1.20120916
 */
public class Charactor {
	/**
	 * キャラ番号<br>
	 * <b>キャラ登録番号ではない</b>
	 */
	private int id;
	/**
	 * 助手かどうか
	 */
	private boolean assistable;
	/**
	 * キャラの名前
	 */
	private String name;
	/**
	 * キャラの呼び名
	 */
	private String callName;
	/**
	 * キャラの二つ名（使うかどうかは別として）
	 */
	private String secondName;
	/**
	 * キャラの基礎パラメータ
	 */
	private TreeMap<Integer,Integer> base;
	/**
	 * キャラの基礎パラメータの最大値
	 */
	private TreeMap<Integer,Integer> maxBase;
	/**
	 * キャラの能力<br>
	 * 元は単配列だったのだが、配列の場合能力の最大値まで枠を作らなければならないので、Setにしている<br>
	 * そのため、<b>「0か1かしか受け付けない」＝あるかないか</b>に仕様変更しているので、それ以外のものを突っ込まないよう注意すること
	 */
	private TreeSet<Integer> ability;
	/**
	 * キャラの素質<br>
	 * 元は単配列だったのだが、配列の場合能力の最大値まで枠を作らなければならないので、Setにしている<br>
	 * そのため、<b>「0か1かしか受け付けない」＝あるかないか</b>に仕様変更しているので、それ以外のものを突っ込まないよう注意すること
	 */
	private TreeSet<Integer> talent;
	/**
	 * キャラの経験
	 */
	private TreeMap<Integer, Integer> exp;
	/**
	 * キャラの刻印
	 */
	private TreeMap<Integer, Integer> mark;
	/**
	 * キャラの相性
	 */
	private TreeMap<Integer, Integer> relation;
	/**
	 * キャラの持っている珠
	 */
	private TreeMap<Integer, Integer> jewel;
	/**
	 * キャラごとのフラグ<br>
	 * これまでのCFLAGなのだが、キャラに埋め込んだため、名称を変更
	 */
	private TreeMap<Integer, Integer> flag;
	/**
	 * キャラのつけているアイテムのうち永続性があるもの
	 */
	private TreeSet<Integer> equip;
	/**
	 * キャラのつけているアイテムのうち調教中に着脱するもの<br>
	 * 本来はここで管理すべきではないのだろうが、Trainingクラスで管理すると多人数プレイに対応できないのでここで扱う<br>
	 * ただ、Charactorクラス全体が<b>セーブの対象</b>なので、調教の最後に全部クリアすることが望ましい
	 */
	private TreeSet<Integer> equipOnTrain;
	/**
	 * キャラの調教中パラメータ<br>
	 * 当然、調教の最後に全部クリアすることが望ましい
	 */
	private TreeMap<Integer, Integer> paramOnTrain;
	/**
	 * 調教により発生した「汚れ」<br>
	 * <b>ビット演算</b>なので扱いには注意すること
	 */
	private TreeMap<Integer, Integer> stain;
	/**
	 * この調教の間に何回絶頂に達したか<br>
	 * しつこいようだが、調教の最後に全部クリアすることが望ましい
	 */
	private TreeMap<Integer, Integer> extOnTrain;
	/**
	 * コマンドを実行することによって発生した調教ソース<br>
	 * コマンド実行後に都度リセットすること
	 */
	private TreeMap<Integer, Integer> sourceOnCommand;
	/**
	 * コマンドの間に何回絶頂に達したか<br>
	 * 同じくコマンド実行後に都度リセットすること
	 */
	private TreeMap<Integer, Integer> extOnCommand;
	/**
	 * 調教を終えて獲得した珠<br>
	 * 調教後にリセットすることが望ましい
	 */
	private TreeMap<Integer, Integer> jewelOnTrain;
	/**
	 * 「key」が「value」をどう呼ぶか<br>
	 * 「key」はキャラ番号<br>
	 * たぶん口上システムを使わない限り使われない
	 */
	private TreeMap<Integer, String> secondPerson;

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
	 * assistableを取得する
	 * 
	 * @return assistable
	 */
	public boolean isAssistable() {
		return assistable;
	}

	/**
	 * assistableを設定する
	 * 
	 * @param assistable
	 *            assistableの設定値
	 */
	public void setAssistable(boolean assistable) {
		this.assistable = assistable;
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
	 * callNameを取得する
	 * 
	 * @return callName
	 */
	public String getCallName() {
		return callName;
	}

	/**
	 * callNameを設定する
	 * 
	 * @param callName
	 *            callNameの設定値
	 */
	public void setCallName(String callName) {
		this.callName = callName;
	}

	/**
	 * secondNameを取得する
	 * 
	 * @return secondName
	 */
	public String getSecondName() {
		return secondName;
	}

	/**
	 * secondNameを設定する
	 * 
	 * @param secondName
	 *            secondNameの設定値
	 */
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	/**
	 * baseを取得する
	 * 
	 * @return base
	 */
	public TreeMap<Integer, Integer> getBase() {
		return base;
	}

	/**
	 * baseを設定する
	 * 
	 * @param base
	 *            baseの設定値
	 */
	public void setBase(TreeMap<Integer,Integer> base) {
		this.base = base;
	}

	/**
	 * maxBaseを取得する
	 * 
	 * @return maxBase
	 */
	public TreeMap<Integer,Integer> getMaxBase() {
		return maxBase;
	}

	/**
	 * maxBaseを設定する
	 * 
	 * @param maxBase
	 *            maxBaseの設定値
	 */
	public void setMaxBase(TreeMap<Integer,Integer> maxBase) {
		this.maxBase = maxBase;
	}

	/**
	 * abilityを取得する
	 * 
	 * @return ability
	 */
	public TreeSet<Integer> getAbility() {
		return ability;
	}

	/**
	 * abilityを設定する
	 * 
	 * @param ability
	 *            abilityの設定値
	 */
	public void setAbility(TreeSet<Integer> ability) {
		this.ability = ability;
	}

	/**
	 * talentを取得する
	 * 
	 * @return talent
	 */
	public TreeSet<Integer> getTalent() {
		return talent;
	}

	/**
	 * talentを設定する
	 * 
	 * @param talent
	 *            talentの設定値
	 */
	public void setTalent(TreeSet<Integer> talent) {
		this.talent = talent;
	}

	/**
	 * expを取得する
	 * 
	 * @return exp
	 */
	public TreeMap<Integer, Integer> getExp() {
		return exp;
	}

	/**
	 * expを設定する
	 * 
	 * @param exp
	 *            expの設定値
	 */
	public void setExp(TreeMap<Integer, Integer> exp) {
		this.exp = exp;
	}

	/**
	 * markを取得する
	 * 
	 * @return mark
	 */
	public TreeMap<Integer, Integer> getMark() {
		return mark;
	}

	/**
	 * markを設定する
	 * 
	 * @param mark
	 *            markの設定値
	 */
	public void setMark(TreeMap<Integer, Integer> mark) {
		this.mark = mark;
	}

	/**
	 * relationを取得する
	 * 
	 * @return relation
	 */
	public TreeMap<Integer, Integer> getRelation() {
		return relation;
	}

	/**
	 * relationを設定する
	 * 
	 * @param relation
	 *            relationの設定値
	 */
	public void setRelation(TreeMap<Integer, Integer> relation) {
		this.relation = relation;
	}

	/**
	 * jewelを取得する
	 * 
	 * @return jewel
	 */
	public TreeMap<Integer, Integer> getJewel() {
		return jewel;
	}

	/**
	 * jewelを設定する
	 * 
	 * @param jewel
	 *            jewelの設定値
	 */
	public void setJewel(TreeMap<Integer, Integer> jewel) {
		this.jewel = jewel;
	}

	/**
	 * flagを取得する
	 * 
	 * @return flag
	 */
	public TreeMap<Integer, Integer> getFlag() {
		return flag;
	}

	/**
	 * flagを設定する
	 * 
	 * @param flag
	 *            flagの設定値
	 */
	public void setFlag(TreeMap<Integer, Integer> flag) {
		this.flag = flag;
	}

	/**
	 * equipを取得する
	 * 
	 * @return equip
	 */
	public TreeSet<Integer> getEquip() {
		return equip;
	}

	/**
	 * equipを設定する
	 * 
	 * @param equip
	 *            equipの設定値
	 */
	public void setEquip(TreeSet<Integer> equip) {
		this.equip = equip;
	}

	/**
	 * equipOnTrainを取得する
	 * 
	 * @return equipOnTrain
	 */
	public TreeSet<Integer> getEquipOnTrain() {
		return equipOnTrain;
	}

	/**
	 * equipOnTrainを設定する
	 * 
	 * @param equipOnTrain
	 *            equipOnTrainの設定値
	 */
	public void setEquipOnTrain(TreeSet<Integer> equipOnTrain) {
		this.equipOnTrain = equipOnTrain;
	}

	/**
	 * paramOnTrainを取得する
	 * 
	 * @return paramOnTrain
	 */
	public TreeMap<Integer, Integer> getParamOnTrain() {
		return paramOnTrain;
	}

	/**
	 * paramOnTrainを設定する
	 * 
	 * @param paramOnTrain
	 *            paramOnTrainの設定値
	 */
	public void setParamOnTrain(TreeMap<Integer, Integer> paramOnTrain) {
		this.paramOnTrain = paramOnTrain;
	}

	/**
	 * stainを取得する
	 * 
	 * @return stain
	 */
	public TreeMap<Integer, Integer> getStain() {
		return stain;
	}

	/**
	 * stainを設定する
	 * 
	 * @param stain
	 *            stainの設定値
	 */
	public void setStain(TreeMap<Integer, Integer> stain) {
		this.stain = stain;
	}

	/**
	 * extOnTrainを取得する
	 * 
	 * @return extOnTrain
	 */
	public TreeMap<Integer, Integer> getExtOnTrain() {
		return extOnTrain;
	}

	/**
	 * extOnTrainを設定する
	 * 
	 * @param extOnTrain
	 *            extOnTrainの設定値
	 */
	public void setExtOnTrain(TreeMap<Integer, Integer> extOnTrain) {
		this.extOnTrain = extOnTrain;
	}

	/**
	 * sourceOnCommandを取得する
	 * 
	 * @return sourceOnCommand
	 */
	public TreeMap<Integer, Integer> getSourceOnCommand() {
		return sourceOnCommand;
	}

	/**
	 * sourceOnCommandを設定する
	 * 
	 * @param sourceOnCommand
	 *            sourceOnCommandの設定値
	 */
	public void setSourceOnCommand(TreeMap<Integer, Integer> sourceOnCommand) {
		this.sourceOnCommand = sourceOnCommand;
	}

	/**
	 * extOnCommandを取得する
	 * 
	 * @return extOnCommand
	 */
	public TreeMap<Integer, Integer> getExtOnCommand() {
		return extOnCommand;
	}

	/**
	 * extOnCommandを設定する
	 * 
	 * @param extOnCommand
	 *            extOnCommandの設定値
	 */
	public void setExtOnCommand(TreeMap<Integer, Integer> extOnCommand) {
		this.extOnCommand = extOnCommand;
	}

	/**
	 * jewelOnTrainを取得する
	 * 
	 * @return jewelOnTrain
	 */
	public TreeMap<Integer, Integer> getJewelOnTrain() {
		return jewelOnTrain;
	}

	/**
	 * jewelOnTrainを設定する
	 * 
	 * @param jewelOnTrain
	 *            jewelOnTrainの設定値
	 */
	public void setJewelOnTrain(TreeMap<Integer, Integer> jewelOnTrain) {
		this.jewelOnTrain = jewelOnTrain;
	}

	/**
	 * secondPersonを取得する
	 * 
	 * @return secondPerson
	 */
	public TreeMap<Integer, String> getSecondPerson() {
		return secondPerson;
	}

	/**
	 * secondPersonを設定する
	 * 
	 * @param secondPerson
	 *            secondPersonの設定値
	 */
	public void setSecondPerson(TreeMap<Integer, String> secondPerson) {
		this.secondPerson = secondPerson;
	}

	// constructor

	/**
	 * コンストラクター<br>
	 * これはもしかしたらprivateにするかもしれない
	 */
	public Charactor() {
		super();
	}

	public Charactor(String fileName) {
		ArrayList<ArrayList<String>> cells = new ArrayList<ArrayList<String>>(0);
		try {
			cells = CSVDecomposer.decompose(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		for (ArrayList<String> lines : cells) {
			if (lines.get(0).equals("番号")) {
				setId(Integer.parseInt(lines.get(1)));
			} else if (lines.get(0).equals("名前")) {
				setName(lines.get(1));
			} else if (lines.get(0).equals("呼び名")) {
				setCallName(lines.get(1));
			} else if (lines.get(0).equals("基礎")) {
				base.put(Integer.parseInt(lines.get(1)), Integer.parseInt(lines.get(2)));
				maxBase.put(Integer.parseInt(lines.get(1)), Integer.parseInt(lines.get(2)));
			}
		}
	}
}
