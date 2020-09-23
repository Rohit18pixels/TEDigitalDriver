package com.jobportalemployer.app.utils;

import android.app.Dialog;
import android.content.Context;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jobportalemployer.app.R;

public class AlertDialogs extends Dialog {



    public AlertDialogs(@NonNull Context context, RecyclerView.Adapter adapter) {
        super(context, R.style.Theme_CustomDialog);

        // This is the layout XML file that describes your Dialog layout
        this.setContentView(R.layout.dialog_layout);

        ImageView imgCancel = findViewById(R.id.imgCancel);
        RecyclerView rvCSCList = findViewById(R.id.rvCSCList);

        rvCSCList.setLayoutManager(new LinearLayoutManager(context,RecyclerView.VERTICAL,false));
        rvCSCList.setAdapter(adapter);

        imgCancel.setOnClickListener(v -> dismissDialog());


    }

    public void dismissDialog()
    {
        dismiss();
    }

}
