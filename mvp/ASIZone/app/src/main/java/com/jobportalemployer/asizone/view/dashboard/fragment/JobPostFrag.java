package com.jobportalemployer.asizone.view.dashboard.fragment;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jobportalemployer.asizone.R;
import com.jobportalemployer.asizone.databinding.FragmentJobPostBinding;
import com.jobportalemployer.asizone.model.jobpost.AreaSectorDataum;
import com.jobportalemployer.asizone.model.jobpost.AreaSectorResponce;
import com.jobportalemployer.asizone.model.jobpost.DesignationDataum;
import com.jobportalemployer.asizone.model.jobpost.DesignationResponce;
import com.jobportalemployer.asizone.model.jobpost.ExperienceDataum;
import com.jobportalemployer.asizone.model.jobpost.ExperienceResponce;
import com.jobportalemployer.asizone.model.jobpost.JobtypeResponse;
import com.jobportalemployer.asizone.model.jobpost.LocationDataum;
import com.jobportalemployer.asizone.model.jobpost.LocationResponse;
import com.jobportalemployer.asizone.model.jobpost.QualificationDataum;
import com.jobportalemployer.asizone.model.jobpost.QualificationResponce;
import com.jobportalemployer.asizone.presenter.api.ApiResponseHandler;
import com.jobportalemployer.asizone.presenter.repository.JobPostRepository;
import com.jobportalemployer.asizone.presenter.repository.Repository;
import com.jobportalemployer.asizone.view.adapter.AreaSectorsAdapter;
import com.jobportalemployer.asizone.view.adapter.DesignationAdapter;
import com.jobportalemployer.asizone.view.adapter.ExperienceAdapter;
import com.jobportalemployer.asizone.view.adapter.JobLocationAdapter;
import com.jobportalemployer.asizone.view.adapter.QualificationAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link JobPostFrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class JobPostFrag extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    JobPostRepository repository;
    FragmentJobPostBinding binding;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public JobPostFrag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment JobPostFrag.
     */
    // TODO: Rename and change types and number of parameters
    public static JobPostFrag newInstance(String param1, String param2) {
        JobPostFrag fragment = new JobPostFrag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_job_post,container,false );

        repository = new JobPostRepository();

        repository.postLocation("location", new ApiResponseHandler<LocationResponse>() {
            @Override
            public void onSuccessResponse(LocationResponse response) {

                if(response.getStatus())
                {
                    List<LocationDataum> list = response.getData();
                    JobLocationAdapter adapter =  new JobLocationAdapter(list);
                    binding.rvLocation.hasFixedSize();
                    binding.rvLocation.setAdapter(adapter);


//                    binding.rvLocation.setAdapter();
                }
            }

            @Override
            public void onErrorResponse(String errorMessage) {

            }
        });

        repository.qualification("qualification", new ApiResponseHandler<QualificationResponce>() {
            @Override
            public void onSuccessResponse(QualificationResponce response) {

                if(response.getStatus())
                {
                    List<QualificationDataum> list = response.getData();
                    QualificationAdapter adapter =  new QualificationAdapter(list);
                    binding.rvQualification.setLayoutManager(new GridLayoutManager(getActivity(), 3));
                    binding.rvQualification.hasFixedSize();
                    binding.rvQualification.setAdapter(adapter);


//                    binding.rvLocation.setAdapter();
                }
            }

            @Override
            public void onErrorResponse(String errorMessage) {

            }
        });

        repository.areaofsector("area_of_sectors", new ApiResponseHandler<AreaSectorResponce>() {
            @Override
            public void onSuccessResponse(AreaSectorResponce response) {

                if(response.getStatus())
                {
                    List<AreaSectorDataum> list = response.getData();
                    AreaSectorsAdapter adapter =  new AreaSectorsAdapter(list);
                    binding.rvArea.setLayoutManager(new GridLayoutManager(getActivity(), 3));
                    binding.rvArea.hasFixedSize();
                    binding.rvArea.setAdapter(adapter);


//                    binding.rvLocation.setAdapter();
                }
            }

            @Override
            public void onErrorResponse(String errorMessage) {

            }
        });

        repository.designation("designation", new ApiResponseHandler<DesignationResponce>() {
            @Override
            public void onSuccessResponse(DesignationResponce response) {

                if(response.getStatus())
                {
//                    ArrayList<Integer> selected = new ArrayList<>();
                    List<DesignationDataum> list = response.getData();
                    DesignationAdapter adapter =  new DesignationAdapter(getActivity(), list);
                    binding.rvDesignation.setLayoutManager(new GridLayoutManager(getActivity(), 3));
                    binding.rvDesignation.hasFixedSize();
                    binding.rvDesignation.setAdapter(adapter);
                    adapter.notifyDataSetChanged();


//                    binding.rvLocation.setAdapter();
                }
            }

            @Override
            public void onErrorResponse(String errorMessage) {

            }
        });

        repository.experience("designation", new ApiResponseHandler<ExperienceResponce>() {
            @Override
            public void onSuccessResponse(ExperienceResponce response) {

                if(response.getStatus())
                {
                    List<ExperienceDataum> list = response.getData();
                    ExperienceAdapter adapter =  new ExperienceAdapter(list);
                    binding.rvDesignation.setLayoutManager(new GridLayoutManager(getActivity(), 3));
                    binding.rvDesignation.hasFixedSize();
                    binding.rvDesignation.setAdapter(adapter);

//                    binding.rvLocation.setAdapter();
                }
            }

            @Override
            public void onErrorResponse(String errorMessage) {

            }
        });



        return binding.getRoot();

//        repository.jobtype("job_type ", new ApiResponseHandler<JobtypeResponse>() {
//            @Override
//            public void onSuccessResponse(JobtypeResponse response) {
//
//                if(response.getStatus())
//                {
//                    List<JobtypeResponse> list = response.getData();
//                    QualificationAdapter adapter =  new QualificationAdapter(list);
//                    binding.rvQualification.setLayoutManager(new GridLayoutManager(getActivity(), 3));
//                    binding.rvQualification.hasFixedSize();
//                    binding.rvQualification.setAdapter(adapter);
//
//
////                    binding.rvLocation.setAdapter();
//                }
//            }
//
//            @Override
//            public void onErrorResponse(String errorMessage) {
//
//            }
//        });
    }
}