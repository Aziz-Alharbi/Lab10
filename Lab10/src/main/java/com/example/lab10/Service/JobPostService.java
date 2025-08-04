package com.example.lab10.Service;

import com.example.lab10.Model.JobPost;
import com.example.lab10.Model.User;
import com.example.lab10.Repository.JobPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobPostService {

    private final JobPostRepository jobPostRepository;

    //5. Get all JobPosts: Retrieves a list of all Job Posts.
    //6. Add a new JobPost: Adds a new job post to the system.
    //7. Update a JobPost: Updates an existing job post ’s information.
    //8. Delete a JobPost: Deletes a job post from the system. Note: Verify that the job
    //post exists.


    public List<JobPost> getPosts(){
        return jobPostRepository.findAll();
    }

    public void addPost(JobPost jobPost){
        jobPostRepository.save(jobPost);
    }

    public Boolean updatePost(Integer id, JobPost jobPost){

        JobPost oldJobPost = jobPostRepository.getById(id);
       // JobPost oldJobPost = jobPostRepository.findById(id).orElse(null);

        if(oldJobPost == null){
            return false;
        }

        oldJobPost.setTitle(jobPost.getTitle());
        oldJobPost.setDescription(jobPost.getDescription());
        oldJobPost.setSalary(jobPost.getSalary());
        oldJobPost.setPostingDate(jobPost.getPostingDate());


        jobPostRepository.save(oldJobPost);
        return true;
    }

    public Boolean deletePost(Integer id){

        JobPost jobPost = jobPostRepository.getById(id);
        if(!(jobPost == null)){
            jobPostRepository.delete(jobPost);
            return true;
        }
        return false;
    }
}
