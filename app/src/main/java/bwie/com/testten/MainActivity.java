package bwie.com.testten;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.hjm.bottomtabbar.BottomTabBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import bwie.com.testten.base.Cart_Fragment;
import bwie.com.testten.base.Home_Fragment;
import bwie.com.testten.base.Mine_Ftagment;
import bwie.com.testten.base.Sotr_Fragment;

public class MainActivity extends AppCompatActivity {

    //    @BindView(R.id.tablayout)
//    TabLayout tablayout;
//    @BindView(R.id.viewPager)
//    ViewPager viewPager;
    @BindView(R.id.bottomtabbar)
    BottomTabBar bottomtabbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        //  getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();//代码中  隐藏掉标题栏
        ButterKnife.bind(this);
        bottomtabbar = (BottomTabBar) findViewById(R.id.bottomtabbar);
        //底部导航栏
        bottomtabbar.init(getSupportFragmentManager())
//                .setImgSize(80, 80)
//                .setFontSize(24)
                .setChangeColor(Color.RED, Color.GRAY)
                .addTabItem("首页", R.mipmap.ic_nav_home_press, R.mipmap.ic_nav_home, Home_Fragment.class)
                .addTabItem("分类", R.mipmap.ic_nav_class_press, R.mipmap.ic_nav_class, Sotr_Fragment.class)
                .addTabItem("购物车", R.mipmap.ic_nav_cart_press, R.mipmap.ic_nav_cart, Cart_Fragment.class)
                .addTabItem("个人", R.mipmap.ic_nav_user_press, R.mipmap.ic_nav_user, Mine_Ftagment.class)
                .isShowDivider(false);

    }
}
