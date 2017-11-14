package bwie.com.testten.Zhuce;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import bwie.com.testten.Bean.Zhece_Bean;
import bwie.com.testten.R;
import bwie.com.testten.Zhuce.presenter.Presenter;
import bwie.com.testten.Zhuce.view.Iview;

public class Zhuce_Activity extends AppCompatActivity implements Iview {

    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.pwd)
    EditText pwd;
    @BindView(R.id.zhuce)
    Button zhuce;
    private Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuce_);
        ButterKnife.bind(this);
        presenter = new Presenter(this, Zhuce_Activity.this);


    }

    @Override
    public void getdata(Zhece_Bean bean) {
        Toast.makeText(Zhuce_Activity.this, bean.msg, Toast.LENGTH_SHORT).show();
        if (bean.code.equals("0")){
            finish();
        }

    }

    @OnClick(R.id.zhuce)
    public void onViewClicked() {
        Map<String, String> map = new HashMap<>();
        map.put("mobile", name.getText().toString());
        map.put("password", pwd.getText().toString());
        presenter.getdata(map);

    }
}
