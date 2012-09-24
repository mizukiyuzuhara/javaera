/**
 * IOControl.java written by Mizuki Yuzuhara, 2012.
 * 画面出力と入力に関する処理を司るクラス。
 * このクラスは<b>コマンドプロンプト（ターミナル）での入出力を前提としている</b>ため、GUIを用いる場合はオーバーライドすること。
 */
package com.eramaker.javaera.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.commons.lang.math.NumberUtils;

/**
 * @author Mizuki Yuzuhara
 * @version 0.1.20120924
 */
public class IOControl {

	// other function

	/**
	 * 文字列をコンソール入力する。 通常数字入力なので、名前を入力する以外直接の使い道はないと思われる。
	 * 
	 * @return コンソール入力された文字列
	 * @throws IOException
	 *             入出力エラーが発生したとき
	 */
	public static String readString() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		String string = reader.readLine();
		return string;
	}

	/**
	 * 数字をコンソール入力する。 数字でないものを入力されるとintの最小値(0x80000000)を返す。
	 * 整数入力を前提としているので、小数を入力したら何が返るか不明。
	 * 
	 * @return コンソール入力された数値（数値以外が入力された場合はintの最小値）
	 * @throws IOException
	 *             入出力エラーが発生したとき
	 */
	public static int readInteger() throws IOException {
		String string = readString();
		int value = NumberUtils.toInt(string, Integer.MIN_VALUE);
		return value;
	}

	/**
	 * 複数行の文字列リストを出力する。
	 * 
	 * @param list
	 *            出力する文字列のリスト
	 */
	public static void writeLines(List<String> list) {
		for (String string : list) {
			System.out.println(string);
		}
	}

	/**
	 * 1行の文字列を出力する。
	 * 
	 * @param string
	 *            出力する文字列
	 */
	/*
	 * <チラシの裏> 要は、System#out#printlnをやってるだけ。
	 * なぜわざわざこんなことをしているかというと、GUIになったときに、System#out#printlnを全部書き直す必要があるから。
	 * 現状、出力がすべてSystem#out#printlnに依存しているため、影響が多岐にわたりすぎる。
	 * ここに1個関数をかましておくと、関数の中身を書き直すだけで済む。 </チラシの裏>
	 */
	public static void writeLine(String string) {
		System.out.println(string);
	}

	/**
	 * パラグラフの終了等、エンターキーで次に進めるときにエンターキーの入力を待つ。
	 */
	public static void getEnterKey() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		try {
			reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
