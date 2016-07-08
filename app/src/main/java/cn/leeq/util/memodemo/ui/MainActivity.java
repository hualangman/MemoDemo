package cn.leeq.util.memodemo.ui;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.leeq.util.memodemo.R;
import cn.leeq.util.memodemo.adapter.GeneralAdapter;
import cn.leeq.util.memodemo.adapter.ViewsHolder;

public class MainActivity extends BaseActivity implements AdapterView.OnItemClickListener {

    private GridView gridView;
    private List<String> data = new ArrayList<>();
    private long exitTime=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        loadData();

    }

    private void loadData() {
        String[] array = getResources().getStringArray(R.array.am_gv);
        for (int i = 0; i < array.length; i++) {
            data.add(array[i]);
        }
    }

    private void initView() {
        gridView = (GridView) findViewById(R.id.am_gridview);
        gridView.setSelector(new ColorDrawable(Color.TRANSPARENT));
        gridView.setAdapter(new GeneralAdapter<String>(this,data,R.layout.item_am_gv) {
            @Override
            public void convert(ViewsHolder holder, String item, int position) {
                holder.setText(R.id.item_tv, item);
            }
        });
        gridView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0:
                startActivity(new Intent(this,RefreshDemo.class));
                break;
            case 1:
                startActivity(new Intent(this,XUtilsDBDemo.class));
                break;
            case 2:
                startActivity(new Intent(this,MultiImageSelect.class));
                break;
            case 4:
                startActivity(new Intent(this,FlowWordWrapDemo.class));
                break;
            case 5:
                startActivity(new Intent(this,ChooseLocalFile.class));
                break;
            case 6:
                startActivity(new Intent(this,SecondList.class));
                break;
            case 7:
                startActivity(new Intent(this,StepViewDemo.class));
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode== KeyEvent.KEYCODE_BACK){
            if ((System.currentTimeMillis()-exitTime)>2000){
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime=System.currentTimeMillis();
            }else{
                System.exit(0);
            }
            return true;
        }
        return false;
    }
}
