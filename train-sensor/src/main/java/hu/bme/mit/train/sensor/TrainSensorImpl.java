package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;

public class TrainSensorImpl implements TrainSensor {

	private TrainController controller;
	private TrainUser user;
	private int speedLimit = 5;

	public TrainSensorImpl(TrainController controller, TrainUser user) {
		this.controller = controller;
		this.user = user;
	}

	@Override
	public int getSpeedLimit() {
		return speedLimit;
	}

	@Override
	public void overrideSpeedLimit(int speedLimit) {
		//absolute margin
		if (user.setAlarmState(speedLimit < 0 || speedLimit > 500)) return;
		//relative margin
		if(user.setAlarmState(speedLimit < controller.getReferenceSpeed()*0.5)) return;

		this.speedLimit = speedLimit;
		controller.setSpeedLimit(speedLimit);

	}

}
