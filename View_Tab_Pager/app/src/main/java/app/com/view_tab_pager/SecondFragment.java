package app.com.view_tab_pager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class SecondFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;


    // 클래스 기본 생성자
    /*
        일반적인 Java 클래스는 클래스 선언만 하면
        내부적으로 보이지 않는 기본생성자를 만든다.

        하지만
        Fragment를 상속받아서 만드는 클래스는
        기본 생성자가 자동으로 만들어지지 않는다.

        그래서
        반드시 기본생성자 메서드를 선언해 주어야 한다.

     */
    public SecondFragment() {
        // Required empty public constructor
    }

    // static 키워드가 있으면 new 선언하지 않고도 호출할 수 있다.
    public static SecondFragment newInstance(String param1, String param2) {
        SecondFragment fragment = new SecondFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }



}
