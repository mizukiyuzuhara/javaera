/**
 * CSVDecomposer.java written by Mizuki Yuzuhara, 2012
 * CSVファイルをArrayList<String>又はArrayList<ArrayList<String>>に分解するクラス<br>
 * 以下の用件を満たすCSVを扱う<br>
 * <ul>
 * <li>区切り文字は「,」</li>
 * <li>「;」より右に記載された事項は無視する</li>
 * <li>空行は消す</li>
 * <li>結果として各行の要素数がすべて同じになるとは想定しない</li>
 * </ul>
 */
package com.eramaker.javaera.common;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;

/**
 * @author Mizuki Yuzuhara
 * @version 0.1.20120915
 */
public class CSVDecomposer {

	/**
	 * CSVから空行・コメント行を除去して行に分解する
	 * 
	 * @param fileName
	 *            分解するCSVのファイル名
	 * @return 分解後のCSVリスト（行単位）
	 */
	public static ArrayList<String> slice(String fileName) {
		// 初期化する
		ArrayList<String> lines = new ArrayList<String>();
		FileReader reader = null;
		try {
			// まずCSVファイルを呼び出す
			reader = new FileReader(fileName);
			// 行ごとにばらす
			List<String> list = IOUtils.readLines(reader);
			for (String string : list) {
				// アンエスケープする
				String string2 = StringEscapeUtils.unescapeCsv(string);
				// コメント行を消す
				String[] strings = string2.split(";");
				String string3 = strings[0];
				// 空行でなければlinesに足す
				if (StringUtils.isNotBlank(string3)) {
					lines.add(string3);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(reader);
		}
		lines.trimToSize();
		return lines;
	}

	/**
	 * CSVから空行・コメント行を除去して行及び列に分解する
	 * 
	 * @param fileName
	 *            分解するCSVのファイル名
	 * @return 分解後のCSVリスト（行及び列）
	 */
	public static ArrayList<ArrayList<String>> decompose(String fileName) {
		// 行にばらしたものを持ってくる
		ArrayList<String> lines = slice(fileName);
		// 初期化する
		ArrayList<ArrayList<String>> cells = new ArrayList<ArrayList<String>>();
		for (String string : lines) {
			// 列ごとにばらす
			String[] strings = string.split(",");
			// ばらしたものを配列からリストにキャスト
			ArrayList<String> rows = new ArrayList<String>();
			for (int i = 0; i < strings.length; i++) {
				rows.add(strings[i]);
			}
			// リストにキャストしたものをcellsに足す
			rows.trimToSize();
			cells.add(rows);
		}
		cells.trimToSize();
		return cells;
	}
}
