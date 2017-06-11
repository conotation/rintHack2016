package kr.edcan.rinsunhackathon;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by bene on 2016. 7. 22..
 */
public class ListPager extends Fragment implements AdapterView.OnItemClickListener {

    PackageManager mPackageManager;
    List<ResolveInfo> intentList;
    GridView mGridView;
    ImageView mBackground;
    SharedPreferences s;
    SharedPreferences.Editor editor;
    final int REQ_CODE_SELECT_IMAGE = 100;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPackageManager = getActivity().getPackageManager();
        Intent intent = new Intent(Intent.ACTION_MAIN, null);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        intentList = getActivity().getPackageManager().queryIntentActivities(intent, 0);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_list, container, false);
        mBackground = (ImageView) view.findViewById(R.id.mBackground);
        mGridView = (GridView)view.findViewById(R.id.mGridView);

        mGridView.setAdapter(new MyBaseAdapter(getContext(), intentList, mPackageManager));

        mGridView.setOnItemClickListener(this);
        return view;
    }



    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        ResolveInfo clickedResolveInfo = (ResolveInfo)adapterView.getItemAtPosition(i);
        ActivityInfo clickedActivityInfo = clickedResolveInfo.activityInfo;

        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(intent.CATEGORY_LAUNCHER);
        intent.setClassName(clickedActivityInfo.applicationInfo.packageName, clickedActivityInfo.name);

        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
        startActivity(intent);
    }
}
