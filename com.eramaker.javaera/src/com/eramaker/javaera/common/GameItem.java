/**
 * GameItem.java written by Mizuki Yuzuhara, 2012
 * ゲーム上のアイテムをオブジェクト化したもの。
 * item.csvよりも情報量が多いので、CSVの書式を変更するか、プロパティか何かで読み込むことを推奨
 */
package com.eramaker.javaera.common;

/**
 * @author Mizuki Yuzuhara
 * @version 0.1.20120921
 */
public class GameItem {

	/**
	 * アイテム番号。
	 */
	private int id;
	/**
	 * アイテム名。
	 */
	private String name;
	/**
	 * アイテムの価格。
	 */
	private int price;
	/**
	 * 消耗品か否か。 消耗品ならtrue。
	 */
	private boolean Consumable;

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
	 * priceを取得する
	 * 
	 * @return price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * priceを設定する
	 * 
	 * @param price
	 *            priceの設定値
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * consumableを取得する
	 * 
	 * @return consumable
	 */
	public boolean isConsumable() {
		return Consumable;
	}

	/**
	 * consumableを設定する
	 * 
	 * @param consumable
	 *            consumableの設定値
	 */
	public void setConsumable(boolean consumable) {
		Consumable = consumable;
	}
	
	//constructor
	
	/**
	 * コンストラクタ（CSVから作成する場合）。
	 * CSVから生成する場合、消耗品かどうかをチェックする場所がないので、ソースで後から直すこと。
	 * @param id
	 * @param name
	 * @param price
	 */
	public GameItem(int id, String name, int price) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.Consumable = false;
	}

	/**
	 * 通常のコンストラクタ。
	 * @param id
	 * @param name
	 * @param price
	 * @param consumable
	 */
	public GameItem(int id, String name, int price, boolean consumable) {
		this.id = id;
		this.name = name;
		this.price = price;
		Consumable = consumable;
	}
	
}
