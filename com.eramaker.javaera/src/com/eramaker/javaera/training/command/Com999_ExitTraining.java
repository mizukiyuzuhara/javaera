/**
 * Com999_ExitTraining.java written by Mizuki Yuzuhara, 2012
 * 調教を終了させる調教コマンド
 */
package com.eramaker.javaera.training.command;

import java.util.ArrayList;

import com.eramaker.javaera.character.Character;
import com.eramaker.javaera.training.EndTrainingException;
import com.eramaker.javaera.training.ParamsOnCommand;
import com.eramaker.javaera.training.TrainingData;

/**
 * @author Mizuki Yuzuhara
 * @version
 */
public class Com999_ExitTraining extends AbstractTrainCommand {

	public Com999_ExitTraining() {
		id = 999;
		name = "調教終了";
		selectable = true;
		shownTailOfList = true;
	}

	/*
	 * (非 Javadoc)
	 * 
	 * @see
	 * com.eramaker.javaera.training.command.AbstractTraining#measureEffectOfTarget
	 * (com.eramaker.javaera.character.Character, java.util.ArrayList)
	 */
	@Override
	protected ParamsOnCommand measureEffectOfTarget(Character target,
			ArrayList<Integer> pleyers) {
		return null;
	}

	/*
	 * (非 Javadoc)
	 * 
	 * @see
	 * com.eramaker.javaera.training.command.AbstractTraining#measureEffectOfPleyer
	 * (com.eramaker.javaera.character.Character, int)
	 */
	@Override
	protected ParamsOnCommand measureEffectOfPleyer(Character pleyer,
			int countOfTargets) {
		return null;
	}

	/*
	 * (非 Javadoc)
	 * 
	 * @see
	 * com.eramaker.javaera.training.command.AbstractTraining#execute(com.eramaker
	 * .javaera.training.TrainingData)
	 */
	@Override
	public TrainingData execute(TrainingData gameData)
			throws EndTrainingException {
		throw new EndTrainingException();
	}

	/*
	 * (非 Javadoc)
	 * 
	 * @see com.eramaker.javaera.training.AbstructTraining#canSelect()
	 */
	@Override
	public boolean canSelect() {
		selectable = true;
		return true;
	}

}
