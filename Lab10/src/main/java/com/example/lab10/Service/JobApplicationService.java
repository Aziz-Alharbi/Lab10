package com.example.lab10.Service;

import com.example.lab10.Model.JobApplication;
import com.example.lab10.Repository.JobApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class JobApplicationService {

    //9. Get all Job Applications: Retrieves a list of all Job Application.
    //10. Apply For Job: Adds a new job application to the system.
    //11. Withdraw Job Application: Deletes a job application from the system.
    //Note: Verify that the job application exists.



    private final JobApplicationRepository jobApplicationRepository;


    public List<JobApplication> getJobApplication(){
        return jobApplicationRepository.findAll();
    }

    public void addJob(JobApplication jobApplication){
        jobApplicationRepository.save(jobApplication);
    }

    public Boolean updateJob(Integer id, JobApplication jobApplication){
        JobApplication oldjobApplication = jobApplicationRepository.getById(id);

        if (oldjobApplication == null){
            return false;
        }
        oldjobApplication.setUserId(jobApplication.getUserId());
        oldjobApplication.setJobPostingId(jobApplication.getJobPostingId());
        jobApplicationRepository.save(oldjobApplication);
        return true;
    }

    public Boolean deleteJob(Integer id){
        JobApplication jobApplication = jobApplicationRepository.getById(id);

        if (jobApplication == null){
            return false;
        }

        jobApplicationRepository.delete(jobApplication);
        return true;
    }



}
