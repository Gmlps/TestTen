package bwie.com.testten.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import bwie.com.testten.Adapter.Shouye_Adapter;
import bwie.com.testten.Bean.Shouye_Bean;
import bwie.com.testten.R;
import bwie.com.testten.home.presenter.Presenter;
import bwie.com.testten.home.view.Iview;

/**
 * Created by Maibenben on 2017/11/9.
 */

public class Home_Fragment extends Fragment implements Iview {

    @BindView(R.id.zxing)
    ImageView zxing;
    @BindView(R.id.edittext)
    EditText edittext;
    @BindView(R.id.duanxin)
    ImageView duanxin;
    @BindView(R.id.recyc)
    XRecyclerView recyc;
    Unbinder unbinder;
    private Shouye_Bean bean;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.home_fragment, container, false);
        Presenter presenter = new Presenter(this, getActivity());
        presenter.getdata();
        unbinder = ButterKnife.bind(this, v);
        return v;

    }

    @Override
    public void getdata(Shouye_Bean bean) {
        //   data = bean.data;

//        List<String> list = new ArrayList<>();
//        for (int i = 0; i < data.size(); i++) {
//            list.add(data.get(i).icon);
//        }
//        banner.setImageLoader(new Glideimage());
//        banner.setImages(list);
//        banner.start();
        //如果布局大小一致有利于优化
        recyc.setHasFixedSize(true);

        //使用线性布局管理器
        RecyclerView.LayoutManager layout = new LinearLayoutManager(getActivity());
        recyc.setLayoutManager(layout);


        recyc.setAdapter(new Shouye_Adapter(getActivity(), bean));
        recyc.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                recyc.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                recyc.refreshComplete();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
