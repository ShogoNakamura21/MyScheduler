package jp.ac.ritsumei.ise.phy.exp2.is0421kx.myscheduler;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;

import io.realm.OrderedRealmCollection;
import io.realm.RealmBaseAdapter;

public class ScheduleAdapter extends RealmBaseAdapter<Schedule> {

    private static class ViewHolder{
        TextView date;
        TextView title;
    }

    public ScheduleAdapter(@Nullable OrderedRealmCollection<Schedule> data) {
        super(data);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {//リストビューのセルのデータが必要な時に呼び出され、表示するビューを返す
        ViewHolder viewHolder;

        if(convertView == null) {//画面がいに出たビューを再利用する処理
            convertView = LayoutInflater.from(parent.getContext()).inflate(//from インスタンスを生成、inflate xmlファイルからビューを生成
                    android.R.layout.simple_list_item_2, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.date = (TextView) convertView.findViewById(android.R.id.text1);//ビューを取得
            viewHolder.title = (TextView) convertView.findViewById(android.R.id.text2);
            convertView.setTag(viewHolder);//セル用ビューのタグの中に保持
        }else{
            viewHolder = (ViewHolder)convertView.getTag();
        }

        Schedule schedule = adapterData.get(position);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String formatDate = sdf.format(schedule.getDate());
        viewHolder.date.setText(formatDate);
        viewHolder.title.setText(schedule.getTitle());
        return convertView;
    }
}
