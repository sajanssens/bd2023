package com.producer;

import com.inject.Trainer;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

public class TrainerServiceProducer {

//	@Inject // Produced by LogFactory-class producer methods
//	private Logger logger;

	@Inject // Produced by Data-class producer methods
	@Named("trainers")
//	@Named("trainersOther")
//	@TrainerData
	private List<Trainer> trainers;


	public List<Trainer> retrieveTrainers() {
		//logger.log(Level.INFO, "retrieveTrainers called");
		return trainers;
	}

}
