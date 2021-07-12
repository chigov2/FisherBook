package techmarket.uno.fisherbook.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import techmarket.uno.fisherbook.R;

public class customArrayAdapter extends ArrayAdapter<listItemClass> {//созать конструктор
    private LayoutInflater inflater; //создатель
    // список может содержать объект класса
    private List<listItemClass> listItemNew = new ArrayList<>();//////////////////// внешняя функция!!!!!
    private Context context;

    public customArrayAdapter(@NonNull Context context, int resource, List<listItemClass> listItemNew, LayoutInflater inflater) {
        super(context, resource,listItemNew);
        this.inflater = inflater;
        this.listItemNew = listItemNew;
        this.context = context;
    }
    // функция рисования отдельного элемента списка
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        listItemClass listItemMain = listItemNew.get(position);

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_view_item_1, null, false);
            viewHolder = new ViewHolder();

            //viewHolder.image = convertView.findViewById(R.id.ivItem);
            viewHolder.image = convertView.findViewById(R.id.ivItem);
            viewHolder.secName = convertView.findViewById(R.id.tvSecondName);
            viewHolder.name = convertView.findViewById(R.id.tvName);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();///////////////?????
        }
        viewHolder.name.setText(listItemMain.getNamef());
        viewHolder.secName.setText(listItemMain.getSecond_name());
        //viewHolder.image.setImageResource(listItemMain.getImage_id());//??????
        viewHolder.image.setImageResource(listItemMain.image_id);//??????

        return convertView;//почему удалили - непонятно
    }

    //чтобы напрямую не работать с TextView, ImageView
    private class ViewHolder{
        TextView name;
        TextView secName;
        ImageView image;
    }
}
