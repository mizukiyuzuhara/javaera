/**
 * Com999_ExitTraining.java written by Mizuki Yuzuhara, 2012
 * 調教を終了させる調教コマンド
 */
package com.eramaker.javaera.training;

import java.util.ArrayList;

import com.eramaker.javaera.common.Charactor;
import com.eramaker.javaera.common.GameData;

/**
 * @author Mizuki Yuzuhara
 * @version 
 */
public class Com999_ExitTraining extends AbstructTraining {

	public Com999_ExitTraining(){
		id = 999;
		name = "調教終了";
		selectable = true;
	}
	
	/* (非 Javadoc)
	 * @see com.eramaker.javaera.training.AbstructTraining#measureEffectOfTarget(com.eramaker.javaera.common.Charactor, java.util.ArrayList)
	 */
	@Override
	protected Charactor measureEffectOfTarget(Charactor target,
			ArrayList<Integer> pleyers) {
		return null;
	}

	/* (非 Javadoc)
	 * @see com.eramaker.javaera.training.AbstructTraining#measureEffectOfPleyer(com.eramaker.javaera.common.Charactor, int)
	 */
	@Override
	protected Charactor measureEffectOfPleyer(Charactor pleyer,
			int countOfTargets) {
		return null;
	}

	/* (非 Javadoc)
	 * @see com.eramaker.javaera.training.AbstructTraining#canSelect()
	 */
	@Override
	public boolean canSelect() {
		selectable = true;
		return true;
	}
	
	/* (非 Javadoc)
	 * @see com.eramaker.javaera.training.AbstructTraining#measureEffect(com.eramaker.javaera.common.GameData)
	 */
	@Override
	public void measureEffect(GameData gameData) throws EndTrainingException{
		throw new EndTrainingException();
	}

}
