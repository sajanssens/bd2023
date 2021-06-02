package com.producer;

import com.inject.Trainer;

import javax.enterprise.inject.Produces;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

public class Data {

	@Produces
	@Named("trainers")
	public List<Trainer> createSomeTrainers() {
		List<Trainer> trainers = new ArrayList<>();
		trainers.add(new Trainer(1, "Janssen"));
		trainers.add(new Trainer(2, "Pieters"));
		trainers.add(new Trainer(3, "Klaassen"));
		return trainers;
	}

//	@Produces
//	@Named("trainersOther")
//	public List<Trainer> createSomeOtherTrainers() {
//		List<Trainer> trainers = new ArrayList<>();
//		trainers.add(new Trainer(1, "Smit"));
//		trainers.add(new Trainer(2, "Janssen"));
//		trainers.add(new Trainer(3, "de Vries"));
//		trainers.add(new Trainer(4, "Besselink"));
//		return trainers;
//	}
//
//	@Produces
//	@TrainerData
//	public List<Trainer> createTrainerData() {
//		return Arrays.asList(
//				new Trainer(2, "Janssen"),
//				new Trainer(3, "de Vries"));
//	}
}
