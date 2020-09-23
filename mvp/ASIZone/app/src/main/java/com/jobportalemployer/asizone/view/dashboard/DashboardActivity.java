package com.jobportalemployer.asizone.view.dashboard;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.jobportalemployer.asizone.R;
import com.jobportalemployer.asizone.databinding.ActivityDashboardBinding;
import com.jobportalemployer.asizone.view.dashboard.fragment.HomeFrag;
import com.jobportalemployer.asizone.view.dashboard.fragment.JobPostFrag;
import com.jobportalemployer.asizone.view.dashboard.fragment.SearchFra;
import com.jobportalemployer.asizone.view.dashboard.fragment.UserFrag;
import com.jobportalemployer.asizone.view.dashboard.fragment.WalletFrag;

public class DashboardActivity extends AppCompatActivity {

    ActivityDashboardBinding binding;
    private String selected = "home";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);


        binding = DataBindingUtil.setContentView(this, R.layout.activity_dashboard);


        unselected(binding.txtHome, binding.txtSearch, binding.txtUser, binding.txtWallet, binding.txtJobPost);
        loadFragment(new HomeFrag());

        binding.txtHome.setOnClickListener(v -> {
            selected = "home";
            unselected(binding.txtHome, binding.txtSearch, binding.txtUser, binding.txtWallet, binding.txtJobPost);
            loadFragment(new HomeFrag());
        });
        binding.txtSearch.setOnClickListener(v -> {
            selected = "search";
            unselected(binding.txtHome, binding.txtSearch, binding.txtUser, binding.txtWallet, binding.txtJobPost);
            loadFragment(new SearchFra());
        });
        binding.txtUser.setOnClickListener(v -> {
            selected = "user";
            unselected(binding.txtHome, binding.txtSearch, binding.txtUser, binding.txtWallet, binding.txtJobPost);
            loadFragment(new UserFrag());
        });
        binding.txtWallet.setOnClickListener(v -> {
            selected = "wallet";
            unselected(binding.txtHome, binding.txtSearch, binding.txtUser, binding.txtWallet, binding.txtJobPost);
            loadFragment(new WalletFrag());
        });
        binding.txtJobPost.setOnClickListener(v -> {
            selected = "job";
            unselected(binding.txtHome, binding.txtSearch, binding.txtUser, binding.txtWallet, binding.txtJobPost);
            loadFragment(new JobPostFrag());
        });
    }

    public void loadFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.frame, fragment);
        transaction.commit();
    }

    public void unselected(TextView txtHome, TextView txtSearch, TextView txtUser, TextView txtWallet, TextView txtJob) {
        if (selected.equalsIgnoreCase("home")) {
            Drawable img2 = getResources().getDrawable(R.drawable.ic_home_selected);
            txtHome.setCompoundDrawablesWithIntrinsicBounds(null, img2, null, null);
            txtHome.setTextColor(Color.parseColor("#29A9E3"));
        } else {
            Drawable img2 = getResources().getDrawable(R.drawable.ic_home);
            txtHome.setCompoundDrawablesWithIntrinsicBounds(null, img2, null, null);
            txtHome.setTextColor(Color.parseColor("#9F000000"));
        }

        if (selected.equalsIgnoreCase("search")) {
            Drawable img3 = getResources().getDrawable(R.drawable.ic_search_selected);
            txtSearch.setCompoundDrawablesWithIntrinsicBounds(null, img3, null, null);
            txtSearch.setTextColor(Color.parseColor("#29A9E3"));
        } else {
            Drawable img3 = getResources().getDrawable(R.drawable.ic_search);
            txtSearch.setCompoundDrawablesWithIntrinsicBounds(null, img3, null, null);
            txtSearch.setTextColor(Color.parseColor("#9F000000"));
        }
        if (selected.equalsIgnoreCase("user")) {
            Drawable img4 = getResources().getDrawable(R.drawable.ic_user_selected);
            txtUser.setCompoundDrawablesWithIntrinsicBounds(null, img4, null, null);
            txtUser.setTextColor(Color.parseColor("#29A9E3"));
        } else {
            Drawable img4 = getResources().getDrawable(R.drawable.ic_user);
            txtUser.setCompoundDrawablesWithIntrinsicBounds(null, img4, null, null);
            txtUser.setTextColor(Color.parseColor("#9F000000"));
        }
        if (selected.equalsIgnoreCase("wallet")) {
            Drawable img5 = getResources().getDrawable(R.drawable.ic_wallet_selected);
            txtWallet.setCompoundDrawablesWithIntrinsicBounds(null, img5, null, null);
            txtWallet.setTextColor(Color.parseColor("#29A9E3"));
        } else {
            Drawable img5 = getResources().getDrawable(R.drawable.ic_wallet);
            txtWallet.setCompoundDrawablesWithIntrinsicBounds(null, img5, null, null);
            txtWallet.setTextColor(Color.parseColor("#9F000000"));
        }
        if (selected.equalsIgnoreCase("job")) {
            Drawable img = getResources().getDrawable(R.drawable.ic_mailbox_selected);
            txtJob.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
            txtJob.setTextColor(Color.parseColor("#29A9E3"));
        } else {
            Drawable img = getResources().getDrawable(R.drawable.ic_mailbox);
            txtJob.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
            txtJob.setTextColor(Color.parseColor("#9F000000"));
        }


    }
}