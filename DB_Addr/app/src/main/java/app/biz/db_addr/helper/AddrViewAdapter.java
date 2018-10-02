package app.biz.db_addr.helper;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import app.biz.db_addr.R;
import app.biz.db_addr.vo.AddrVO;

/*
    View Adapter는 RecyclerView에 item을 표시하기 위한 도우미
    1. RecyclerView.Adapter를 상속받아서
    2. onCreateHolder, onBindHolder를 생성
    3. RecyclerView.ViewHolder를 상속한 holder 클래스를 생성
 */

public class AddrViewAdapter extends RecyclerView.Adapter {

    List<AddrVO> addrs;

    /*
        Activity에서 List<AddrVO>를 보내는 창구역할
     */
    public AddrViewAdapter(List<AddrVO> addrs) {
        this.addrs = addrs;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_addr_view,parent,false);
        return new AddrViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        AddrViewHolder addrViewHolder = (AddrViewHolder)holder;
        addrViewHolder.txt_name.setText(addrs.get(position).name);
        addrViewHolder.txt_phone.setText(addrs.get(position).phone);
        addrViewHolder.txt_email.setText(addrs.get(position).email);


    }

    @Override
    public int getItemCount() { return addrs.size(); }


    /*
        item_view.xml에 정의된 각 view들을 사용할 수 있도록 선언, 연결하는 곳
     */
    class AddrViewHolder extends RecyclerView.ViewHolder{

        TextView txt_name;
        TextView txt_phone;
        TextView txt_email;

        public AddrViewHolder(View itemView) {
            super(itemView);
            txt_name = itemView.findViewById(R.id.item_txt_name);
            txt_phone = itemView.findViewById(R.id.item_txt_phone);
            txt_email = itemView.findViewById(R.id.item_txt_email);
        }
    }
}
