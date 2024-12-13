package rajviryadav.com.library;

import static android.app.Activity.RESULT_OK;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.gesture.GestureOverlayView;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.text.Editable;
import android.util.Base64;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class Sample_Code
{
    // sample code countdowntimer
    /*CountDownTimer CDT = new CountDownTimer(2500, 500)
    {
        public void onTick(long millisUntilFinished)
        {

        }
        public void onFinish()
        {

        }
    }.start();*/

    // Sample code of Animation
    /*public void StartAnimations()
    {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
        anim.reset();
        RelativeLayout l=(RelativeLayout) findViewById(R.id.relative);
        l.clearAnimation();
        l.startAnimation(anim);

        anim = AnimationUtils.loadAnimation(this, R.anim.anim_translate);
        anim.reset();
        ImageView iv = (ImageView) findViewById(R.id.imageView2);
        iv.clearAnimation();
        iv.startAnimation(anim);
    }

    <RelativeLayout
    android:layout_width="175dp"
    android:layout_height="175dp"
    android:layout_centerHorizontal="true"
    android:layout_centerVertical="true">
        <ImageView
    android:visibility="visible"
    android:id="@+id/imageView2"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    ads:srcCompat="@drawable/cs_logo"
    android:tint="@color/transparent"/>
    </RelativeLayout>*/

    // sample code of full screen
    /*getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);*/

    // sample code backpressed
    /*@Override
    public void onBackPressed()
    {
        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory(Intent.CATEGORY_HOME);
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(homeIntent);
        this.finishAffinity();
    }*/

    // sample code of strictpolicy splash or login
    /*StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);*/

    // sample code of spinner item selected Listener
    /*
    if(strtskcategoryList.contains(TypeOfCategory_c))
                        {
                            tskcategoryindex = strtskcategoryList.indexOf(TypeOfCategory_c);
                        }
                        else
                        {
                            tskcategoryindex=0;
                        }
                        ArrayAdapter<String> adaptermgt = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item, strtskcategoryList);
                        adaptermgt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spntskcategory.setAdapter(adaptermgt);
                        if(tskcategoryindex ==0)
                        {
                            spntskcategory.setSelection(0);
                        }
                        else
                        {
                            spntskcategory.setSelection(tskcategoryindex);
                        }
    logintype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
    {
        @Override
        public void onItemSelected(AdapterView<?> parent, View arg1, int position, long arg3)
        {
            if(parent.getItemAtPosition(position).equals("Select Login Type"))
            {
                edtuserid.setText("");
                edtpassword.setText("");
            }
            else if(parent.getItemAtPosition(position).equals("Staff"))
            {
                edtuserid.setText("sanjeev.kumar@corporateserve.com");
                edtpassword.setText("123");
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0)
        {

        }
    });*/

    /*private void SalesReps()
    {
        class GetJSON extends AsyncTask<Void, Void, Response>
        {
            @Override
            protected void onPreExecute()
            {
                super.onPreExecute();
                loading4 = ProgressDialog.show(getActivity(), "", "Please wait...", false, false);
            }

            @Override
            protected Response doInBackground(Void... params)
            {
                Log.d("TAG_SalesReps", "doInBackground: "+Config.URL_SalesReps);
                OkHttpClient client = new OkHttpClient.Builder()
                        .hostnameVerifier(new HostnameVerifier() {
                            @Override
                            public boolean verify(String hostname, SSLSession session) {
                                HostnameVerifier hv = HttpsURLConnection.getDefaultHostnameVerifier();
                                return true;
                            }
                        })
                        .connectTimeout(100, TimeUnit.SECONDS)
                        .readTimeout(100, TimeUnit.SECONDS).build();
                MediaType mediaType = MediaType.parse("text/plain");
                RequestBody body = RequestBody.create(mediaType, "");
                Request request = new Request.Builder()
                        .url(Config.URL_SalesReps)
                        .method("GET", null)
                        //.addHeader("Authorization", "Basic Y3M6dGVpbWFuYWdlcg==")
                        .addHeader("Authorization", AppStatus.getInstance(getActivity()).getB(strusername,strpassword))
                        .build();
                Response response = null;
                try
                {
                    response = client.newCall(request).execute();
                }
                catch (IOException e)
                {
                    throw new RuntimeException(e);
                }
                return response;
            }

            @Override
            protected void onPostExecute(Response s)
            {
                super.onPostExecute(s);
                loading4.dismiss();
                srtPrimarySalesPersonarrayList.clear();
                srtPrimarySalesPersonarrayListone.clear();
                PrimarySalesPersonarrayList_index=0;
                try {
                    Response response = s;
                    String r = response.body().string();
                    Log.d("TAG_r_SalesReps", "onPostExecute: "+r);
                    if (response.code() == 200)
                    {

                        JSONObject json = new JSONObject(r);
                        JSONArray contacts = json.getJSONArray("value");
                        PrimarySalesPersonarrayList = new ArrayList<Model_PrimarySalesPerson>();

                        // looping through All Contacts
                        for (int i = 0; i < contacts.length(); i++)
                        {
                            JSONObject c = contacts.getJSONObject(i);

                            String name = c.optString("Name");
                            String code = c.optString("SalesRepCode");
                            PrimarySalesPersonarrayList.add(new Model_PrimarySalesPerson(name, code));
                            srtPrimarySalesPersonarrayList.add(name);
                            srtPrimarySalesPersonarrayListone.add(code);
                        }

                        srtPrimarySalesPersonarrayList.add(0,"Select Primary Sales Person");

                        if(srtPrimarySalesPersonarrayListone.contains(SalesRepCodes))
                        {
                            PrimarySalesPersonarrayList_index = srtPrimarySalesPersonarrayListone.indexOf(SalesRepCodes);
                            //facilityTypes_simple.remove(ShortChar04);
                            //facilityTypes_simple.add(1,ShortChar04);
                            Log.d("facilityInformation2", "onSuccess: "+PrimarySalesPersonarrayList_index+"-"+SalesRepCodes);
                        }

                        ArrayAdapter<String> adapteraircraft = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item, srtPrimarySalesPersonarrayList);
                        adapteraircraft.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spnPrimarySalesPerson.setAdapter(adapteraircraft);
                        if(PrimarySalesPersonarrayList_index >=0)
                        {
                            spnPrimarySalesPerson.setSelection(PrimarySalesPersonarrayList_index+1);
                        }
                        else
                        {
                            spnPrimarySalesPerson.setSelection(0);
                        }
                        spnPrimarySalesPerson.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
                        {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View arg1, int position, long arg3)
                            {
                                if(parent.getItemAtPosition(position).equals("Select Primary Sales Person"))
                                {
                                    PrimarySalesPersonName="";
                                    PrimarySalesPersonCode="";
                                }
                                else
                                {
                                    PrimarySalesPersonCode = PrimarySalesPersonarrayList.get(position-1).getCode();
                                    PrimarySalesPersonName = PrimarySalesPersonarrayList.get(position-1).getName();
                                    Log.d("PrimarySalesPerson", "onItemSelected: "+PrimarySalesPersonName+"-"+PrimarySalesPersonCode);
                                    //QuFacName();
                                }
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> arg0)
                            {

                            }
                        });
                    }
                    else
                    {
                        Toast.makeText(getActivity(), "Response Code : " + s.code(), Toast.LENGTH_LONG).show();
                    }
                }
                catch (IOException | JSONException e)
                {
                    throw new RuntimeException(e);
                }
            }

        }
        GetJSON gj = new GetJSON();
        gj.execute();
    }*/

    // sample code of double back click exit
    /*    // dashboad
    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onResume()
    {
        super.onResume();

        getView().setFocusableInTouchMode(true);
        getView().requestFocus();
        getView().setOnKeyListener(new View.OnKeyListener()
        {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event)
            {
                if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK)
                {
                    if (doubleBackToExitPressedOnce)
                    {
                        getActivity().finishAffinity();
                    }

                    doubleBackToExitPressedOnce = true;
                    android.widget.Toast.makeText(getActivity(), "Press again to exit this application", Toast.LENGTH_SHORT).show();

                    new Handler().postDelayed(new Runnable()
                    {

                        @Override
                        public void run()
                        {
                            doubleBackToExitPressedOnce=false;
                        }
                    }, 2000);
                }
                return false;
            }
        });
    }

    // main activity
    @Override
    public void onBackPressed()
    {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        }
        else
        {
            //super.onBackPressed();
        }
    }*/

    // fragment call
    /*Fragment newFragment = new Faculty_StudentAttendance();
    Bundle args = new Bundle();
                    args.putString("backtype", "");
                    newFragment.setArguments(args);
    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.content, newFragment);
                    fragmentTransaction.commit();*/

    /*    FragmentManager mFragmentManager;
    mFragmentManager = getSupportFragmentManager();
    getSupportActionBar().setTitle("Assignment Details");
//            FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
//            xfragmentTransaction.replace(R.id.content,new Management_StudentAssignment()).commit();*/

    // activity call
    /*Intent ns=new Intent(Splash.this,MainActivity.class);
    startActivity(ns);*/

    /*Intent intent = new Intent(abc.this, next.class);
        intent.putExtra("val", val);
    startActivityForResult(intent, 80);

    Intent intent = new Intent();
            intent.putExtra("val", val);
    setResult(80, intent);
    finish();*/

    // access mainactivity code in other class
    /*Toolbar toolbar =(Toolbar) ((MainActivity) this.getActivity()).findViewById(R.id.toolbar);
        toolbar.setTitle("Welcome to CS Campus");*/

    // arrayList with hashmap
    /*ArrayList<HashMap<String, String>> contactList;
    contactList = new ArrayList<>();
    HashMap<String, String> contact = new HashMap<>();
                            contact.put("eventCode", c.optString("eventCode"));
                            contact.put("eventName", c.optString("eventName"));
                            contact.put("day", c.optString("day"));
                            contact.put("duration", c.optString("duration"));
                            contact.put("eventDate", c.optString("eventDate"));
                            contact.put("institute", c.optString("institute"));

                            contactList.add(contact);*/

    // arraylist with model
    /*private ArrayList<Model_Line_List> arrayList;
    arrayList = new ArrayList<Model_Line_List>();
    arrayList.add(new Model_Line_List("",""));*/

    // arraylist simple
    /*ArrayList<String> strtskcategoryList=null;
    strtskcategoryList=new ArrayList<>();
    strtskcategoryList.add(0,"Select TKS Category");
        strtskcategoryList.add(1,"A");
        strtskcategoryList.add(2,"B");
        strtskcategoryList.add(3,"C");
        strtskcategoryList.add(4,"D");
        strtskcategoryList.add(5,"D+");
        strtskcategoryList.add(6,"E");*/

    // listview
    // java code
    /*ArrayList<HashMap<String, String>> contactList;
    contactList = new ArrayList<>();
    private ListView lv;
    lv = (ListView) main.findViewById(R.id.list);
    JSONArray contacts = new JSONArray(r);
    for (int i = 0; i < contacts.length(); i++)
    {
        JSONObject c = contacts.getJSONObject(i);
        HashMap<String, String> contact = new HashMap<>();
        contact.put("eventCode", c.optString("eventCode"));
        contact.put("eventName", c.optString("eventName"));
        contact.put("day", c.optString("day"));
        contact.put("duration", c.optString("duration"));
        contact.put("eventDate", c.optString("eventDate"));
        contact.put("institute", c.optString("institute"));

        contactList.add(contact);

        ListAdapter adapter = new SimpleAdapter(
                getActivity(), contactList,
                R.layout.item_events_list, new String[]{"eventCode", "eventName",
                "day","duration","eventDate","institute"}, new int[]{R.id.column_header1,
                R.id.column_header2, R.id.column_header3,R.id.column_header4,R.id.column_header5,R.id.column_header6})
                {
                    @Override
                    public View getView(final int position, View convertView, ViewGroup parent)
                    {
                        View row = super.getView(position, convertView, parent);
                        EditText txt_remarks = (EditText) row.findViewById(R.id.txt_remarks);
                        txt_remarks.setOnKeyListener(new View.OnKeyListener() {

                            public boolean onKey(View v, int keyCode, KeyEvent event) {

                                if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK)
                                {
                                    back();
                                }
                                return false;
                            }
                        });

                        return row;
                    }

                };
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id)
            {
                Log.d("TAG_SrNo", "onItemClick: "+contactList.get(position).get("SrNo"));
                Fragment newFragment = new Faculty_StudentList();
                Bundle args = new Bundle();
                args.putString("SrNo",contactList.get(position).get("SrNo"));
                args.putString("date",contactList.get(position).get("event_id"));
                newFragment.setArguments(args);
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.content, newFragment);
                fragmentTransaction.commit();
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                                    Model_QuoteLine_List quote = (Model_QuoteLine_List) parent.getItemAtPosition(position);
                                    Fragment newFragment = new QuoteLineList_Details();
                                    Bundle args = new Bundle();
                                    args.putString("QuoteNum", quote.getQuoteDtl_QuoteNum());
                                    args.putString("QuoteLine", quote.getQuoteDtl_QuoteLine());
                                    args.putString("BackType", BackType);
                                    newFragment.setArguments(args);
                                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                                    fragmentTransaction.replace(R.id.content, newFragment);
                                    fragmentTransaction.commit();
                                }
                            });
    }*/

    //xml code
    /*<ListView
    android:visibility="visible"
    android:id="@+id/list"
    android:layout_marginTop="5dp"
    android:layout_width="fill_parent"
    android:divider="@color/transparent"
    android:layout_height="wrap_content" />

    <?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical" android:layout_width="match_parent"
    android:layout_height="match_parent">

    <androidx.cardview.widget.CardView
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:card_view="http://schemas.android.com/apk/res-auto"
    android:background="#fff"
    android:id="@+id/cardview5"
    android:layout_width="fill_parent"
    android:layout_height="wrap_content"
    android:layout_marginLeft="5dp"
    android:layout_marginRight="5dp"
    android:layout_marginBottom="5dp">
        <TableLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="fill_parent"
    android:layout_height="wrap_content"
    android:id="@+id/tbl2">
            <LinearLayout
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="vertical">
                <LinearLayout
    android:layout_width="fill_parent"
    android:layout_height="wrap_content"
    android:weightSum="1">
                    <TextView
    android:layout_width="0dp"
    android:layout_height="fill_parent"
    android:layout_weight=".28"
    android:text="Class Date"
    android:layout_margin="2dp"
    android:paddingLeft="2dp"
    android:paddingRight="2dp" />

                    <TextView
    android:layout_width="0dp"
    android:layout_height="fill_parent"
    android:layout_weight=".02"
    android:text=":"
    android:layout_margin="2dp"
    android:paddingLeft="2dp"
    android:paddingRight="2dp" />

                    <TextView
    android:id="@+id/column_header1"
    android:layout_width="0dp"
    android:layout_height="fill_parent"
    android:layout_weight=".70"
    android:layout_margin="2dp"
    android:paddingLeft="2dp"
    android:paddingRight="2dp" />
                </LinearLayout>
                <LinearLayout
    android:layout_width="fill_parent"
    android:layout_height="wrap_content"
    android:weightSum="1">
                    <TextView
    android:layout_width="0dp"
    android:layout_height="wrap_content"
    android:layout_weight=".28"
    android:text="Start Time"
    android:layout_margin="2dp"
    android:paddingLeft="2dp"
    android:paddingRight="2dp" />

                    <TextView
    android:layout_width="0dp"
    android:layout_height="fill_parent"
    android:layout_weight=".02"
    android:text=":"
    android:layout_margin="2dp"
    android:paddingLeft="2dp"
    android:paddingRight="2dp" />

                    <TextView
    android:id="@+id/column_header2"
    android:layout_width="0dp"
    android:layout_height="fill_parent"
    android:layout_weight=".70"
    android:layout_margin="2dp"
    android:paddingLeft="2dp"
    android:paddingRight="2dp" />
                </LinearLayout>
                <LinearLayout
    android:layout_width="fill_parent"
    android:layout_height="wrap_content"
    android:weightSum="1">
                    <TextView
    android:layout_width="0dp"
    android:layout_height="wrap_content"
    android:layout_weight=".28"
    android:text="End Time"
    android:layout_margin="2dp"
    android:paddingLeft="2dp"
    android:paddingRight="2dp" />

                    <TextView
    android:layout_width="0dp"
    android:layout_height="fill_parent"
    android:layout_weight=".02"
    android:text=":"
    android:layout_margin="2dp"
    android:paddingLeft="2dp"
    android:paddingRight="2dp" />

                    <TextView
    android:id="@+id/column_header3"
    android:layout_width="0dp"
    android:layout_height="fill_parent"
    android:layout_weight=".70"
    android:layout_margin="2dp"
    android:paddingLeft="2dp"
    android:paddingRight="2dp" />
                </LinearLayout>
                <LinearLayout
    android:layout_width="fill_parent"
    android:layout_height="wrap_content"
    android:weightSum="1">
                    <TextView
    android:layout_width="0dp"
    android:layout_height="wrap_content"
    android:layout_weight=".28"
    android:text="Faculty Name"
    android:layout_margin="2dp"
    android:paddingLeft="2dp"
    android:paddingRight="2dp" />

                    <TextView
    android:layout_width="0dp"
    android:layout_height="fill_parent"
    android:layout_weight=".02"
    android:text=":"
    android:layout_margin="2dp"
    android:paddingLeft="2dp"
    android:paddingRight="2dp" />

                    <TextView
    android:id="@+id/column_header4"
    android:layout_width="0dp"
    android:layout_height="fill_parent"
    android:layout_weight=".70"
    android:layout_margin="2dp"
    android:paddingLeft="2dp"
    android:paddingRight="2dp" />
                </LinearLayout>

                <LinearLayout
    android:layout_width="fill_parent"
    android:layout_height="wrap_content"
    android:weightSum="1">
                    <TextView
    android:layout_width="0dp"
    android:layout_height="fill_parent"
    android:layout_weight=".28"
    android:text="Details"
    android:layout_margin="2dp"
    android:paddingLeft="2dp"
    android:paddingRight="2dp" />

                    <TextView
    android:layout_width="0dp"
    android:layout_height="fill_parent"
    android:layout_weight=".02"
    android:text=":"
    android:layout_margin="2dp"
    android:paddingLeft="2dp"
    android:paddingRight="2dp" />

                    <TextView
    android:id="@+id/column_header5"
    android:layout_width="0dp"
    android:layout_height="fill_parent"
    android:layout_weight=".70"
    android:layout_margin="2dp"
    android:paddingLeft="2dp"
    android:paddingRight="2dp" />
                </LinearLayout>
            </LinearLayout>
        </TableLayout>
    </androidx.cardview.widget.CardView>
</LinearLayout>*/

    // GestureOverlayView
    /*    String base64="";
    GestureOverlayView gesture;
    gesture = (GestureOverlayView) findViewById(R.id.gestures_raf);
        gesture.setDrawingCacheEnabled(true);

    public void done(View view){
        if (gesture.getGesture()!=null && gesture.getGesture().getLength()>0) {
            try {
                Bitmap yourSelectedImage = Bitmap.createBitmap(gesture.getDrawingCache());
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                yourSelectedImage.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                base64 = Base64.encodeToString(byteArray, Base64.DEFAULT);
                System.out.println("yourSelectedImage " + base64);
                new SaveSignature().execute();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            Toast.makeText(Signature_RAF.this,"Please Sign",Toast.LENGTH_SHORT).show();
        }

    }

    <android.gesture.GestureOverlayView
    android:id="@+id/gestures_raf"
    android:layout_width="fill_parent"
    android:layout_height="match_parent"
    android:layout_above="@+id/clear_raf"
    android:fadeEnabled="true"
    android:background="#FFFFFF"

    android:gestureColor="#2091c5"
    android:gestureStrokeType="multiple"
    android:gestureStrokeWidth="15"/>*/

    // bundle
    /*Bundle args = new Bundle();
    args.putString("SrNo",contactList.get(position).get("SrNo"));
    args.putString("date",contactList.get(position).get("event_id"));
    newFragment.setArguments(args);

    Bundle args = new Bundle();
    args = getArguments();
    strgetSrNo = args.getString("event_id");*/

    // buildCollection
    /*private void buildCollection() throws JSONException
    {
        ArrayList<HashMap<String, String>> StudentStatusList;
        StringBuilder stringBuilder=new StringBuilder();
        //StudentStatusList.clear();
        StudentStatusList = controller.getAllStudent();
        stringBuilder.setLength(0);
        //int count=orderCount;
        for (int i=0;i<StudentStatusList.size();i++)
        {
            HashMap<String,String> map;
            map=StudentStatusList.get(i);
            if(map!=null)
            {
                if (i==0)
                {
                    stringBuilder
                            .append(map.get("classId")).append("$")
                            .append(map.get("studentId")).append("$")
                            .append(map.get("registrationNo")).append("$")
                            .append(map.get("name")).append("$")
                            .append(map.get("rollNo")).append("$")
                            .append(map.get("remarks")).append("$")
                            .append(map.get("reason")).append("$")
                            .append(map.get("createdBy")).append("$")
                            .append(map.get("modifiedBy")).append("$")
                            .append(map.get("facultyId"));
                    ORDER_COLLECTION=stringBuilder.toString();
                    Log.d("Collection",ORDER_COLLECTION);
                }
                else
                {
                    stringBuilder.append("#");
                    stringBuilder
                            .append(map.get("classId")).append("$")
                            .append(map.get("studentId")).append("$")
                            .append(map.get("registrationNo")).append("$")
                            .append(map.get("name")).append("$")
                            .append(map.get("rollNo")).append("$")
                            .append(map.get("remarks")).append("$")
                            .append(map.get("reason")).append("$")
                            .append(map.get("createdBy")).append("$")
                            .append(map.get("modifiedBy")).append("$")
                            .append(map.get("facultyId"));
                    ORDER_COLLECTION=stringBuilder.toString();
                    Log.d("Collection",ORDER_COLLECTION);

                }
            }
        }
    }*/

    // open database
    /*protected void openDatabase()
    {
        db = getActivity().openOrCreateDatabase("xyz.db", Context.MODE_PRIVATE ,null);
    }

    public void show()
    {
        openDatabase();
        c = db.rawQuery("SELECT * FROM xyz order by Id DESC", null);
        c.moveToFirst();

        HashMap<String, String> mapss;

        if (c.moveToFirst())
        {
            model_studentLists = new ArrayList<Model_StudentList>();
            do
            {
                model_studentLists.add(new Model_StudentList(c.getString(1),c.getString(2),c.getString(3),c.getString(4),c.getString(5),c.getString(6),c.getString(7),c.getString(8),c.getString(9),c.getString(10),c.getString(11)));
                adapter = new Adapter_Faculty_Class_Attendance(getActivity(), model_studentLists,strissueListsName,strissueListsCode)
                {
                    @Override
                    public View getView(final int position, View convertView, ViewGroup parent)
                    {
                        View row = super.getView(position, convertView, parent);
                        EditText txt_remarks = (EditText) row.findViewById(R.id.txt_remarks);
                        txt_remarks.setOnKeyListener(new View.OnKeyListener() {

                            public boolean onKey(View v, int keyCode, KeyEvent event) {

                                if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK)
                                {
                                    back();
                                }
                                return false;
                            }
                        });

                        return row;
                    }

                };
                gridView.setAdapter(adapter);
            }
            while (c.moveToNext());

        }

        db.close();
    }*/

    // onkeylistener backbutton
    /*searchEditText.setOnKeyListener(new View.OnKeyListener()
    {
        public boolean onKey(View v, int keyCode, KeyEvent event)
        {
            if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK)
            {
                Intent ns=new Intent(getActivity(),MainActivity.class);
                startActivity(ns);
            }
            return false;
        }
    });*/

    // textchangelistener
    /*searchEditText.addTextChangedListener(new TextWatcher()
    {
    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2)
    {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2)
    {

        //On text changed in Edit text start filtering the list
        adapter.filter(filter_notification_list, charSequence.toString(), isSearchWithPrefix);
    }

    @Override
    public void afterTextChanged(Editable editable)
    {

    }
});*/

/*    txt_quantity.addTextChangedListener(new TextWatcher()
{
    @Override
    public void afterTextChanged(Editable s) {}
    @Override
    public void beforeTextChanged(CharSequence s, int start,
    int count, int after) {
}
    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count)
    {
        if(s.length() != 0)
        {
            int a = Integer.parseInt(txt_quantity.getText().toString().trim());
            int b = Integer.parseInt(txt_cost.getText().toString().trim());
            int c = a*b;
            txt_total_amount.setText(""+c);
        }
        else
        {

        }
    }
});*/

    // jsondata parse
    /*Response response = s;
    String r = response.body().string();
    JSONObject jsonObject = new JSONObject(r);
    String PartNums = jsonObject.optString("PartNum");
    JSONArray jsonArray = new JSONArray(r);
    JSONArray contacts = jsonObject.getJSONArray("value");
    for (int i = 0; i < contacts.length(); i++)
    {
        JSONObject c = contacts.getJSONObject(i);
        String QuoteDtl_QuoteNum = c.optString("QuoteDtl_QuoteNum");
    }*/

    // jsondata post body
    /*JSONObject jsonParams = new JSONObject();
    jsonParams.put("Company", "TEI");
    jsonParams.put("QuoteNum", Integer.parseInt(QuoteNum));

    RequestBody body = RequestBody.create(mediaType, jsonParams.toString()); //with RequestBody
    StringEntity entity = new StringEntity(jsonParams.toString());*/ // with StringEntity

    //okhttpclient service
    /*private void SaveRecord()
    {
        class GetJSON extends AsyncTask<Void, Void, Response>
        {
            @Override
            protected void onPreExecute()
            {
                super.onPreExecute();
                loading1 = ProgressDialog.show(getActivity(), "", "Please wait...", false, false);
            }

            @Override
            protected Response doInBackground(Void... params)
            {
                Log.d("TAG_URL", "doInBackground: "+Config.URL_Quotesupdate);
                OkHttpClient client = new OkHttpClient.Builder().hostnameVerifier(new HostnameVerifier() {
                            @Override
                            public boolean verify(String hostname, SSLSession session) {
                                HostnameVerifier hv = HttpsURLConnection.getDefaultHostnameVerifier();
                                return true;
                            }
                        })
                        .connectTimeout(100, TimeUnit.SECONDS)
                        .readTimeout(100, TimeUnit.SECONDS).build();
                MediaType mediaType = MediaType.parse("application/json");

                try {
                    JSONObject jsonParams = new JSONObject();
                    jsonParams.put("QuoteNum", quotenum.getText().toString().trim());
                    jsonParams.put("PONum", ponum.getText().toString().trim());

                    //StringEntity entity = new StringEntity(jsonParams.toString());
                    RequestBody body = RequestBody.create(mediaType, jsonParams.toString());

                    Request request = new Request.Builder().url(Config.URL_Quotesupdate).method("POST", body)
                            .addHeader("Authorization", AppStatus.getInstance(getActivity()).getB(strusername,strpassword))
                            .addHeader("Content-Type", "application/json").build();
                    Response response = null;
                    response = client.newCall(request).execute();

                    return response;
                } catch (JSONException | IOException e) {
                    throw new RuntimeException(e);
                }
            }

            @Override
            protected void onPostExecute(Response s)
            {
                super.onPostExecute(s);
                loading1.dismiss();
                try {
                    Response response = s;
                    String r = response.body().string();
                    Log.d("TAG_r_Competitor", "onPostExecute: "+r);
                    if (response.code() == 200)
                    {
                        Toast.makeText(getActivity(),"Successfully Save....",Toast.LENGTH_LONG).show();
                        Fragment newFragment = new Quotes_Details();
                        Bundle args = new Bundle();
                        args.putString("QuoteNum",QuoteNum);
                        newFragment.setArguments(args);
                        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.content, newFragment);
                        fragmentTransaction.commit();
                    }
                    else
                    {
                        Toast.makeText(getActivity(), "Response Code : " + s.code(), Toast.LENGTH_LONG).show();
                    }
                }
                catch (IOException e)
                {
                    throw new RuntimeException(e);
                }
            }

        }
        GetJSON gj = new GetJSON();
        gj.execute();
    }*/

    //Handler
    /*    new Handler().postDelayed(new Runnable()
{
    @Override
    public void run()
    {

    }
},5000);*/

    // Get Image
    /*    // for camera
    //Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

    // for gallery
    //Intent intent = new Intent(MediaStore.ACTION_PICK_IMAGES);

    //startActivityForResult(intent,100);
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
//    {
//        super.onActivityResult(requestCode, resultCode, data);
//        if(resultCode==RESULT_OK)
//        {
//            if(requestCode==100)
//            {
//                // for camera
//                //Bitmap bitmap = (Bitmap) data.getExtras().get("data");
//                //imageView.setImageBitmap(bitmap);
//
//                //for gallery
//                //imageView.setImageURI(data.getData());
//            }
//        }
//    }*/

}
