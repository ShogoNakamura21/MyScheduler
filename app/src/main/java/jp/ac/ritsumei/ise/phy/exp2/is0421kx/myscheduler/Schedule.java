package jp.ac.ritsumei.ise.phy.exp2.is0421kx.myscheduler;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Schedule extends RealmObject {
    @PrimaryKey//idは一意であることを保証するため
    private long id;//データを扱いやすくするためにlong型のメンバ変数を用意
    private Date date;//日付
    private String title;//タイトル
    private String detail;//内容

    public long getId() {//ゲッターとセッター
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
