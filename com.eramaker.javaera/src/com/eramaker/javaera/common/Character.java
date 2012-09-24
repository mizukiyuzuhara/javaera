/**
 * Charactor.java written by Mizuki Yuzuhara, 2012
 * キャラデータを扱うクラス
 */
package com.eramaker.javaera.common;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

import org.apache.commons.lang.StringUtils;

/**
 * @author Mizuki Yuzuhara
 * @version 0.1.20120916
 */
public class Character {

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
	private TreeMap<Integer, Integer> base;
	/**
	 * キャラの基礎パラメータの最大値
	 */
	private TreeMap<Integer, Integer> maxBase;
	/**
	 * キャラの能力<br>
	 * 元は単配列だったのだが、配列の場合能力の最大値まで枠を作らなければならないので、Setにしている<br>
	 * そのため、<b>「0か1かしか受け付けない」＝あるかないか</b>に仕様変更しているので、それ以外のものを突っ込まないよう注意すること
	 */
	private TreeMap<Integer, Integer> ability;
	/**
	 * キャラの素質
	 */
	private TreeSet<Integer> talent;
	/**
	 * キャラの経験<br>
	 * 元は単配列だったのだが、配列の場合能力の最大値まで枠を作らなければならないので、Setにしている<br>
	 * そのため、<b>「0か1かしか受け付けない」＝あるかないか</b>に仕様変更しているので、それ以外のものを突っ込まないよう注意すること
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
	 * 調教により発生した「汚れ」<br>
	 * <b>ビット演算</b>なので扱いには注意すること
	 */
	private TreeMap<Integer, Integer> stain;
	/**
	 * 調教により変動する項目。
	 * 調教の開始時にリセットすること。
	 */
	private CharacterOnTrain charactorOnTrain = new CharacterOnTrain();
	/**
	 * 調教コマンドにより変動する項目。
	 * 調教コマンドの実行終了後にリセットすること。
	 */
	private CharacterOnCommand charactorOnCommand = new CharacterOnCommand();
	/**
	 * 「key」が「このキャラ」をどう呼ぶか<br>
	 * 「key」はキャラ番号<br>
	 * たぶん口上システムを使わない限り使われない
	 */
	private TreeMap<Integer, String> appellation;

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
	public void setBase(TreeMap<Integer, Integer> base) {
		this.base = base;
	}

	/**
	 * maxBaseを取得する
	 * 
	 * @return maxBase
	 */
	public TreeMap<Integer, Integer> getMaxBase() {
		return maxBase;
	}

	/**
	 * maxBaseを設定する
	 * 
	 * @param maxBase
	 *            maxBaseの設定値
	 */
	public void setMaxBase(TreeMap<Integer, Integer> maxBase) {
		this.maxBase = maxBase;
	}

	/**
	 * abilityを取得する
	 * 
	 * @return ability
	 */
	public TreeMap<Integer, Integer> getAbility() {
		return ability;
	}

	/**
	 * abilityを設定する
	 * 
	 * @param ability
	 *            abilityの設定値
	 */
	public void setAbility(TreeMap<Integer, Integer> ability) {
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
	 * appellationを取得する
	 * 
	 * @return appellation
	 */
	public TreeMap<Integer, String> getappellation() {
		return appellation;
	}

	/**
	 * appellationを設定する
	 * 
	 * @param appellation
	 *            appellationの設定値
	 */
	public void setappellation(TreeMap<Integer, String> appellation) {
		this.appellation = appellation;
	}

	// constructor

	/**
	 * charactorOnTrainを取得する
	 * @return charactorOnTrain
	 */
	public CharacterOnTrain getCharactorOnTrain() {
		return charactorOnTrain;
	}

	/**
	 * charactorOnTrainを設定する
	 * @param charactorOnTrain charactorOnTrainの設定値
	 */
	public void setCharactorOnTrain(CharacterOnTrain charactorOnTrain) {
		this.charactorOnTrain = charactorOnTrain;
	}

	/**
	 * charactorOnCommandを取得する
	 * @return charactorOnCommand
	 */
	public CharacterOnCommand getCharactorOnCommand() {
		return charactorOnCommand;
	}

	/**
	 * charactorOnCommandを設定する
	 * @param charactorOnCommand charactorOnCommandの設定値
	 */
	public void setCharactorOnCommand(CharacterOnCommand charactorOnCommand) {
		this.charactorOnCommand = charactorOnCommand;
	}

	/**
	 * コンストラクター<br>
	 * これはもしかしたらprivateにするかもしれない
	 */
	public Character() {
		super();
	}

	private Character(String fileName) {
		try {
			ArrayList<ArrayList<String>> cells = CSVDecomposer
					.decompose(fileName);
			try {
				for (ArrayList<String> lines : cells) {
					if (lines.get(0).equals("番号")) {
						setId(Integer.parseInt(lines.get(1)));
					} else if (lines.get(0).equals("名前")) {
						setName(lines.get(1));
					} else if (lines.get(0).equals("呼び名")) {
						setCallName(lines.get(1));
					} else if (lines.get(0).equals("基礎")) {
						base.put(Integer.parseInt(lines.get(1)),
								Integer.parseInt(lines.get(2)));
						maxBase.put(Integer.parseInt(lines.get(1)),
								Integer.parseInt(lines.get(2)));
					} else if (lines.get(0).equals("能力")) {
						if (StringUtils.isNumeric(lines.get(1))) {
							ability.put(Integer.parseInt(lines.get(1)),
									Integer.parseInt(lines.get(2)));
						} else {
							try {
								ability.put(GameDictionaries.abilities
										.getKey(lines.get(1)), Integer
										.parseInt(lines.get(2)));
							} catch (ElementsNotFoundException e) {
								e.printStackTrace();
							}
						}
					} else if (lines.get(0).equals("素質")) {
						if (StringUtils.isNumeric(lines.get(1))) {
							talent.add(Integer.parseInt(lines.get(1)));
						} else {
							try {
								talent.add(GameDictionaries.talents
										.getKey(lines.get(1)));
							} catch (ElementsNotFoundException e) {
								e.printStackTrace();
							}
						}
					} else if (lines.get(0).equals("経験")) {
						if (StringUtils.isNumeric(lines.get(1))) {
							exp.put(Integer.parseInt(lines.get(1)),
									Integer.parseInt(lines.get(2)));
						} else {
							try {
								exp.put(GameDictionaries.exps.getKey(lines
										.get(1)),
										Integer.parseInt(lines.get(2)));
							} catch (ElementsNotFoundException e) {
								e.printStackTrace();
							}
						}
					} else if (lines.get(0).equals("相性")) {
						relation.put(Integer.parseInt(lines.get(1)),
								Integer.parseInt(lines.get(2)));
					} else if (lines.get(0).equals("助手")) {
						switch (Integer.parseInt(lines.get(1))) {
						case 1:
							setAssistable(true);
							break;

						default:
							setAssistable(false);
							break;
						}
					} else if (lines.get(0).equals("フラグ")) {
						flag.put(Integer.parseInt(lines.get(1)),
								Integer.parseInt(lines.get(2)));
					} else if (lines.get(0).equals("呼称")) {
						appellation.put(Integer.parseInt(lines.get(1)),
								lines.get(2));
					}
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	// other functions

	/**
	 * キャラデータを作成して返す
	 * 
	 * @param fileName
	 *            キャラデータの元となるCSVのファイル名
	 * @return 展開したキャラデータ
	 */
	public static Character createCharactor(String fileName) {
		return new Character(fileName);
	}

}
