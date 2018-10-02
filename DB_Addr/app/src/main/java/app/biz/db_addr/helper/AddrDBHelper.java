package app.biz.db_addr.helper;

/*
    주소록을 DB에 저장할 때 도움을 줄 도우미 Class
    1. SQLOpenHelper를 상속받고
    2. onCreate method를 정의
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AddrDBHelper  extends SQLiteOpenHelper{

    public AddrDBHelper(Context context){
        super(context, AddrDBContract.DB_NAME, null, 1);
    }

    public AddrDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    // APP 실행해서 최초로 누군가가 DB에 접근하려고 할 때
    // DB에 접근 : CRUD 중에 한가지
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(AddrDBContract.CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //  CRUD 부분은 별도록 추가되는 부분


}
