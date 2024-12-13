package rajviryadav.com.library;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

public class DBController extends SQLiteOpenHelper
{
	public DBController(Context applicationcontext)
	{
        super(applicationcontext, "Config.DatabaseName", null, 5);
    }

	//Creates Table
	@Override
	public void onCreate(SQLiteDatabase database)
	{

		String appsetting="";
		appsetting = "create table IF NOT EXISTS appsettings (Id INTEGER  primary key AUTOINCREMENT,apptype TEXT)";
		database.execSQL(appsetting);
		//Log.d("log query 123","table basecreate");
	}
	@Override
	public void onUpgrade(SQLiteDatabase database, int version_old, int current_version)
	{
		if (version_old<=4)
		{
			try
			{
				//database.execSQL("create table IF NOT EXISTS notification1 (Id INTEGER  primary key AUTOINCREMENT,Status TEXT)");
				/*database.execSQL("ALTER TABLE quote ADD COLUMN quoted TEXT default null");*/
			}
			catch (SQLiteException ex)
			{
				Log.w("Tag", "Altering " + ex.getMessage());
			}
		}
	}
	
	
	/**
	 * Inserts User into SQLite DB
	 * @param queryValues
	 */
	public void insertappsetting(HashMap<String, String> queryValues)
	{
		SQLiteDatabase database = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("name", queryValues.get("name"));
		values.put("version", queryValues.get("version"));
		values.put("url", queryValues.get("url"));
		values.put("title", queryValues.get("title"));
		values.put("description", queryValues.get("description"));
		values.put("banner", queryValues.get("banner"));
		values.put("inter", queryValues.get("inter"));
		values.put("package", queryValues.get("package"));
		values.put("lastrecord", queryValues.get("lastrecord"));
		database.insert("appsettings", null, values);
		database.close();

		//Log.d("log appsetting",values.toString());
	}

	public void insertuseranswerrecord(String mainid,String question,String realanswer, String useranswer,String uservalue,String date,String time)
	{
		SQLiteDatabase database = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("mainid", mainid);
		values.put("question", question);
		values.put("realanswer", realanswer);
		values.put("useranswer", useranswer);
		values.put("uservalue", uservalue);
		values.put("date", date);
		values.put("time", time);
		database.insert("scorerecord", null, values);
		database.close();
	}


	public void update_notification1(String log)
	{
		SQLiteDatabase database = this.getWritableDatabase();
		database.execSQL("UPDATE notification1 SET status='"+0+"' WHERE Log='"+log+"' ");
		database.close();
		Log.d("notification1_update",log);
	}

	public void updateAppType(String apptype)
	{
		SQLiteDatabase database = this.getWritableDatabase();
		database.execSQL("UPDATE appsettings SET apptype='"+apptype+"' WHERE Id=1 ");
		database.close();
	}


	public void delete_notification1_default()
	{
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete("notification1","Status=?",new String[]{"1"});
		Log.d("notification1_delete_de","1");
	}

	public void delete_notification1_defaultbyid(String Id)
	{
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete("packageboxlist","Id=?",new String[]{Id});
	}


	public boolean RecordExistsnotification1()
	{
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery("select Id from notification1",null);
		boolean exists = (cursor.getCount() > 0);
		cursor.close();
		db.close();
		return exists;
	}

	public boolean RecordExistsquotenumberWin(String QuoteHed_QuoteNum)
	{
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery("SELECT DISTINCT * FROM quotenumber where QuoteHed_ReasonType='W' and QuoteHed_QuoteNum='"+QuoteHed_QuoteNum+"'",null);
		boolean exists = (cursor.getCount() > 0);
		cursor.close();
		db.close();
		return exists;
	}

	public boolean rowIdExists(String PO_Num)
	{
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery("select PO_Num from packinglist where PO_Num=?", new String[]{PO_Num});
		boolean exists = (cursor.getCount() > 0);
		cursor.close();
		db.close();
		return exists;
	}


	public String Total_Count_Notification1()
	{
		String total;
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery("SELECT COUNT(Id) as Total FROM notification1 where Status='0'", null);
		if (cursor.moveToFirst())
		{
			total = cursor.getString(cursor.getColumnIndex("Total"));
		}
		else
		{
			total="0";
		}
		return total;
	}

	public double Total_Sum_CtcMonthly()
	{
		double Monthly =0.0;
		SQLiteDatabase db = getReadableDatabase();
		Cursor cursor = db.rawQuery("SELECT SUM(Monthly) FROM ctcdetails", null);
		if(cursor.moveToFirst())
		{
			Monthly = cursor.getDouble(0);
		}
		cursor.close();
		db.close();
		return Monthly;
	}


	public String getappsettingrecord()
	{
		String appname,applink,title,banner,inter,all,version,lastrecord,description,packages;
		SQLiteDatabase db=this.getReadableDatabase();
		Cursor cursor=db.rawQuery("select * from appsettings",null);
		if (cursor.moveToFirst())
		{
			appname = cursor.getString(cursor.getColumnIndex("name"));
			version = cursor.getString(cursor.getColumnIndex("version"));
			applink = cursor.getString(cursor.getColumnIndex("url"));
			title = cursor.getString(cursor.getColumnIndex("title"));
			description = cursor.getString(cursor.getColumnIndex("description"));
			banner = cursor.getString(cursor.getColumnIndex("banner"));
			inter = cursor.getString(cursor.getColumnIndex("inter"));
			packages = cursor.getString(cursor.getColumnIndex("package"));
			lastrecord = cursor.getString(cursor.getColumnIndex("lastrecord"));

			all=appname+"|"+version+"|"+applink+"|"+title+"|"+description+"|"+banner+"|"+inter+"|"+packages+"|"+lastrecord;
		}
		else
		{
			all="";
		}
		cursor.close();
		db.close();
		return all;
	}

	public String getlocallastrecord()
	{
		String lastrecord;
		SQLiteDatabase db=this.getReadableDatabase();
		Cursor cursor=db.rawQuery("select * from appsettings",null);
		if (cursor.moveToFirst())
		{
			lastrecord = cursor.getString(cursor.getColumnIndex("lastrecord"));
		}
		else
		{
			lastrecord="";
		}
		cursor.close();
		db.close();
		return lastrecord;
	}

	public String getsharerecord(int limit,int offset)
	{
		String appname,applink,title,banner,inter,all,version,lastrecord,description,packages;
		SQLiteDatabase db=this.getReadableDatabase();
		//Cursor cursor=db.rawQuery("select * from tutorials where category='"+category+"' and subcategory='"+subcategory+"' order by id asc limit '"+limit+"' OFFSET '"+offset+"'",null);
		Cursor cursor=db.rawQuery("select * from tutorials order by id asc limit '"+limit+"' OFFSET '"+offset+"'",null);
		if (cursor.moveToFirst())
		{
			appname = cursor.getString(cursor.getColumnIndex("question"));
			version = cursor.getString(cursor.getColumnIndex("answer"));

			all=appname+"\n\n"+version;
		}
		else
		{
			all="";
		}
		cursor.close();
		db.close();
		return all;
	}


	public ArrayList<HashMap<String, String>> getAllquotelistdata()
	{
		ArrayList<HashMap<String, String>> usersList;
		usersList = new ArrayList<HashMap<String, String>>();
		String selectQuery = "SELECT  * FROM quotelist ORDER BY Id DESC";
		SQLiteDatabase database = this.getWritableDatabase();
		Cursor cursor = database.rawQuery(selectQuery, null);
		if (cursor.moveToFirst())
		{
			do
			{
				HashMap<String, String> map = new HashMap<String, String>();
				map.put("Customer_CustID", cursor.getString(1));
				map.put("Customer_Name", cursor.getString(2));
				map.put("QuoteHed_QuoteNum", cursor.getString(3));
				map.put("QuoteHed_PONum", cursor.getString(4));
				map.put("Calculated_QuoteStatus", cursor.getString(5));
				map.put("QuoteHed_QuoteNum_c", cursor.getString(6));
				map.put("QuoteHed_ProjectName_c", cursor.getString(7));
				usersList.add(map);
			}
			while (cursor.moveToNext());
		}
		database.close();
		return usersList;
	}

}
