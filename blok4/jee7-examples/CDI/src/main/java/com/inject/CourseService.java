package com.inject;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class CourseService {

    private TrainerService trainerService;

    @Inject
    public void setTrainerService(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    public Trainer retrieveTrainerForCourse(long courseId) {
        return trainerService.retrieveTrainerDetails(getTrainerId(courseId));
    }

    private long getTrainerId(long courseId) {
        // Implement some logic to retrieve the trainer id
        return courseId * 100;
    }

}
