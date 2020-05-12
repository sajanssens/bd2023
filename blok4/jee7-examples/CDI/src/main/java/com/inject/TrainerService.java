package com.inject;

import javax.ejb.Stateless;

@Stateless
public class TrainerService {

	public Trainer retrieveTrainerDetails(long trainerId) {	
		Trainer trainer = new Trainer(trainerId, "Ann");
		// Implement some logic to retrieve the trainer
		return trainer;
	}

}
