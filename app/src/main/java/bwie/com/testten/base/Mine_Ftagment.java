package bwie.com.testten.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import bwie.com.testten.Login.Login_Activity;
import bwie.com.testten.R;

/**
 * Created by Maibenben on 2017/11/9.
 */

public class Mine_Ftagment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.mine_fragment, container, false);

        ImageView ima = v.findViewById(R.id.img);

        ima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Login_Activity.class));
            }
        });

        return v;
    }
}
