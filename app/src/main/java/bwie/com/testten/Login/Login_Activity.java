package bwie.com.testten.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import bwie.com.testten.Bean.Login_Bean;
import bwie.com.testten.Login.presenter.Presenter;
import bwie.com.testten.Login.view.Iview;
import bwie.com.testten.R;
import bwie.com.testten.Zhuce.Zhuce_Activity;


public class Login_Activity extends AppCompatActivity implements Iview {

    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.pwd)
    EditText pwd;
    @BindView(R.id.login)
    Button login;
    @BindView(R.id.zhuce)
    Button zhuce;
    private Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);
        ButterKnife.bind(this);
        presenter = new Presenter(this, Login_Activity.this);

    }

    @OnClick({R.id.login, R.id.zhuce})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login:

                Map<String, String> map = new HashMap<>();
                map.put("mobile", name.getText().toString());
                map.put("password", pwd.getText().toString());
                presenter.getdata(map);
                presenter.getdata(map);

                break;
            case R.id.zhuce:
                startActivity(new Intent(Login_Activity.this, Zhuce_Activity.class));
                break;
        }
    }

    @Override
    public void getdata(Login_Bean bean) {
        Toast.makeText(Login_Activity.this, bean.msg, Toast.LENGTH_SHORT).show();
        if (bean.code.equals("0")){
            finish();
        }
    }
}
