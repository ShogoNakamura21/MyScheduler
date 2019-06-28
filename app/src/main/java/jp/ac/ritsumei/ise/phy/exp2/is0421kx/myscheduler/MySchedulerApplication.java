package jp.ac.ritsumei.ise.phy.exp2.is0421kx.myscheduler;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;


public class MySchedulerApplication extends Application {
    @Override
    public void onCreate(){
        Realm.init(this);//Realmを初期化
        RealmConfiguration realmConfig = new RealmConfiguration.Builder().build();//データベースの設定を行うRealm~~tionクラスのインスタンスを取得
        Realm.setDefaultConfiguration(realmConfig);//コンフィグの値を変更せずsetDefaultに譲渡
    }

}
