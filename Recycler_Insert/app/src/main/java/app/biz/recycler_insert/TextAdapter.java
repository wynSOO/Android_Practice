package app.biz.recycler_insert;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TextAdapter extends RecyclerView.Adapter {

    List<TextVO> textList;

    public TextAdapter(List<TextVO> textList) {
        this.textList = textList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        // 1번방법 : 일반적인 Java Coding
        LayoutInflater lf = LayoutInflater.from(viewGroup.getContext());
        View view = lf.inflate(R.layout.item_view,viewGroup,false);

        // 2번 방식 : 안드로이드식 Colding
        // Chaining 기법 : 클래스.method().method().method()
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_view,viewGroup,false);

        //return new TextHolder(view);

        // 3번방식 : 내부에서 어떤 객체나, 변수를 생성해서
        //  메모리가 사용되는 것을 막는 방법
        return new TextHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_view,viewGroup,false));


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        TextHolder textHolder = (TextHolder)viewHolder;

        //textHolder.item_image.setImageDrawable();
        textHolder.item_image.setImageResource(textList.get(i).getItem_image());
        textHolder.item_text.setText(textList.get(i).getItem_text());


    }

    @Override
    public int getItemCount() { return textList.size(); }

    class TextHolder extends RecyclerView.ViewHolder{

        ImageView item_image;
        TextView item_text;

        public TextHolder(@NonNull View itemView) {
            super(itemView);

            item_image = itemView.findViewById(R.id.item_image);
            item_text = itemView.findViewById(R.id.item_text);

        }
    }
}
