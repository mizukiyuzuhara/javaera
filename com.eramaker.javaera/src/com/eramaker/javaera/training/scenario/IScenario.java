/**
 * IScenario.java written by Mizuki Yuzuhara, 2012.
 * キャラ別口上のフレームワーク。
 * キャラ別口上が設定されていなければ例外を返す。
 * 例外が返ってきたら、汎用口上を呼び出す。
 */
package com.eramaker.javaera.training.scenario;

import java.util.List;

/**
 * @author Mizuki Yuzuhara
 * @version 
 */
public interface IScenario {

	/**
	 * キャラに設定された口上を呼び出す。
	 * 通常は、調教番号を渡す。調教番号以外を渡すなら、別のイベントを建てた方がわかりやすいと思う。
	 * @param scenarioID 口上の番号
	 * @return 対応する口上
	 * @throws NoScenarioException 口上を設定していない場合
	 */
	public List<String> getScenario(int scenarioID) throws NoScenarioException;
}
