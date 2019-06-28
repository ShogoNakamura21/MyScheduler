package jp.ac.ritsumei.ise.phy.exp2.is0421kx.myscheduler;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {
    private Realm mRealm;//realmクラスのメンバ変数
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ScheduleEditActivity.class));//画面の遷移
            }
        });


        mRealm = Realm.getDefaultInstance();//realmクラスのインスタンスを取得

        mListView = (ListView)findViewById(R.id.listView);
        RealmResults<Schedule>schedules = mRealm.where(Schedule.class).findAll();
        ScheduleAdapter adapter = new ScheduleAdapter(schedules);
        mListView.setAdapter(adapter);

        //Listviewをクリックしたときのイベントの処理↓
        mListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public  void onItemClick(AdapterView<?> parent, View view, int postion, long id){
                        Schedule schedule = (Schedule) parent.getItemAtPosition(postion);
                        startActivity(new Intent(MainActivity.this, ScheduleEditActivity.class)
                                .putExtra("schedule_id", schedule.getId()));
                    }
                });

    }

    @Override
    public void onDestroy(){//終了処理
        super.onDestroy();
        mRealm.close();
    }




}
