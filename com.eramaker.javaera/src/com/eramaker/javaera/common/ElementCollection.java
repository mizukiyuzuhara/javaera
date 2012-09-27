/**
 * ElementCollection.java written by Mizuki Yuzuhara, 2012.
 * システム上要素数が1個かもしれないArrayList<Integer>のうち、本当に1個しか置かない項目のラッパー。
 * いちいち「#get(0)」とか「#set(0, i)」とかやらないことを目的とする。
 */
package com.eramaker.javaera.common;

import java.util.ArrayList;

/**
 * @author Mizuki Yuzuhara
 * @version 0.1.20120926
 */
public class ElementCollection extends ArrayList<Integer> {

	/**
	 * シリアル番号。いつものおまじない。
	 */
	private static final long serialVersionUID = 1L;

	// other function

	/**
	 * 最初かつ唯一の要素を返す。要素が1個しかない場合に有効。
	 * 
	 * @return 要素の値
	 */
	public Integer getElement() {
		return get(0);
	}

	/**
	 * (i+1)番目の要素を返す。
	 * 
	 * @param i
	 *            返す要素の位置（ゼロオリジン）
	 * @return 該当する要素の値
	 */
	public Integer getElement(int i) {
		return get(i);
	}

	/**
	 * 最初かつ唯一の要素を置換する。
	 * 
	 * @param integer
	 */
	public void setElement(Integer integer) {
		set(0, integer);
	}

	/**
	 * (i+1)番目の要素を置換する。
	 * 
	 * @param i
	 *            置換する要素の位置（ゼロオリジン）
	 * @param integer
	 *            置換される要素の値
	 */
	public void setElement(int i, Integer integer) {
		set(i, integer);
	}

}
