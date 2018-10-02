package app.biz.recyclercardview;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter{

    List<CardVO> cards;
    Context context;

    public CardAdapter(List<CardVO> cards,Context context) {
        this.cards = cards;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card,parent,false);

        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        CardViewHolder cardViewHolder = (CardViewHolder)holder;
        CardVO vo = cards.get(position);

        cardViewHolder.imageView.setImageResource(vo.getImage());
        cardViewHolder.textView.setText(vo.getImageTitle());

        // 각 보여줄 항목을 만들때 애니메이션을 적용하자.
        setAnimation(cardViewHolder.imageView,position);

    }

    @Override
    public int getItemCount() { return cards.size(); }


    private int lastPosition = -1;
    private void setAnimation(View view, int position){
        //위로 스크롤링 했을때 맨마지막 항목이 화면으로 막 나타나면
        if(position>lastPosition){
            Animation ani = AnimationUtils
                                .loadAnimation(context,android.R.anim.slide_in_left);
                                // 미리 설정한 상수값
                                // Toast.SHOW_LONG
        }

    }



    class CardViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;

        public CardViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.item_image);
            textView = itemView.findViewById(R.id.item_text);
        }
    }
}
