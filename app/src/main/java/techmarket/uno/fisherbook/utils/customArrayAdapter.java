package techmarket.uno.fisherbook.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class customArrayAdapter extends ArrayAdapter {//созать конструктор
    private LayoutInflater inflater; //создатель
    // список может содержать объект класса
    private List<listItemClass> listItemNew = new ArrayList<>();///////////////////////////!!!!!!!!
    private Context context;

    public customArrayAdapter(@NonNull Context context, int resource, List<listItemClass> listItemNew, LayoutInflater inflater) {
        super(context, resource,listItemNew);
        this.inflater = inflater;
        this.listItemNew = listItemNew;
        this.context = context;
    }
    // функция рисования элементов по отдельности

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        return convertView;//почему удалили - непонятно
    }
}
