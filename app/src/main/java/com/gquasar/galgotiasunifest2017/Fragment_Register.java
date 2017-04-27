package com.gquasar.galgotiasunifest2017;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class Fragment_Register extends Fragment {

    View mainView;
    public static final MediaType FORM_DATA_TYPE = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");
    public static final String URL_FORM = "https://docs.google.com/forms/d/e/1FAIpQLSdbSWPRO37uGptkW7SZojUXfvdAILJ-SQymJjteXDusqxWn2g/formResponse";

    public static final String NAME_KEY = "entry.754383306";
    public static final String EMAIL_KEY = "entry.265754212";
    public static final String NUMBER_KEY = "entry.127970014";
    public static final String COLLEGE_KEY="entry.472138373";
    public static final String EVENTS_KEY="entry.1389637671";
    public static final String NUM_MEMBERS_KEY="entry.739221560";
    public static final String AMOUNT_KEY="entry.310933943";
    public static final String DATEYEAR_KEY="entry.1962743694_year";
    public static final String DATEMON_KEY="entry.1962743694_month";
    public static final String DATEDAY_KEY="entry.1962743694_day";


    public String Categories[]={"","Dramatics","Cam Circle","Literary","Music","Frag","Dance","Quiz","Fine Arts","Creative Team","Scintillations"},category;
    public String Events0[]={"","Street Play","Stage Play+ Mime Act","Mono Act+ Stand up Comedy","Script Writing","Theme Party"};
    public String Events1[]={"","Photo Booth","Story Teller","Aperture","Selfie Fiesta","Video Day","Photo of The Day","Sticky Note Wall","Photo Exhibition","Weirdofie","Click It Up","Sumitup"};
    public String Events2[]={"","Magic Gol Gappa","Face Off","Quote Writing","Enchanted Stories","Are You A Muggle","What Happens Next","Battle of Wits","Chai Pe Charcha","VJ Hunt","Poetry Darpan","Snake & Ladder-ature","Lets's Race","Naughty Notes"};
    public String Events3[]={"","Mesmeriser","Instrumento","The Duos","Battle Of Bands"};
    public String Events4[]={"","Mini Militia","FIFA(PS4)","Call Of Duty","Counter Strike","UFC(PS4)","Mortal Kombat X(PS4)","Need For Speed"};
    public String Events5[]={"","Illusion(Group Dance)","Mystic(Solo Dance)"};
    public String Events6[]={"","Sports Quiz","MELA","The Magical Quiz","Do You Know Your Country","The Quizitia Maven Quiz","10 Ka Dum","Do You Know Your Fav Personality"};
    public String Events7[]={"","Love Letter","Suicide Letter","Poster Making","Abstract Painting","Tattoo Making","Beg Borrow Steal","Treasure Hunt","Magical Stories","Doodle Your T-shirt","Wand Off","Monochromatic Painting","Shade Blade","Spell O Craft","Paint Ball","Roadies","Date Trap","Mad Add","Sketching Master","Cartoon Making"};
    public String Events8[]={"","My College My Way","Movie Trailer Shoot","Recreate The Magic"};
    public String Events9[]={"","Mr & Ms Scintillation"};
    public String date,month,year,amount="0";


    private Context context;
    private EditText editName;
    private EditText editEmail;
    private EditText editPhoneNumber;
    private EditText editCollege;
    private EditText editMembers;
    private TextView selectcategory,selectevents;
    private CheckBox checkBox1,checkBox2;
    private Spinner spinner;
    private Spinner spinner2;
    private RelativeLayout layout;
    ArrayAdapter<String> adapterCategoryCategory;
    ArrayAdapter<String> adapterEventCategory;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mainView=inflater.inflate(R.layout.fragment_fragment__register,container,false);
        context = mainView.getContext();

        Button SubmitButton = (Button)mainView. findViewById(R.id.button_register);
        editName = (EditText)mainView. findViewById(R.id.editText_register_name);
        editEmail = (EditText)mainView. findViewById(R.id.editText_register_email);
        editPhoneNumber = (EditText)mainView. findViewById(R.id.editText_register_phone);
        editCollege = (EditText)mainView. findViewById(R.id.editText_register_college);
        editMembers=(EditText)mainView.findViewById(R.id.editText_register_members);
        spinner=(Spinner)mainView.findViewById(R.id.spinner);
        spinner2=(Spinner)mainView.findViewById(R.id.multiSpinner);
        selectcategory=(TextView)mainView.findViewById(R.id.textViewSelect);
        selectevents=(TextView)mainView.findViewById(R.id.textViewSelect2);
        adapterCategoryCategory =new ArrayAdapter<String>(context,android.R.layout.simple_spinner_item, Categories);
        adapterCategoryCategory.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterCategoryCategory);

        adapterEventCategory =new ArrayAdapter<String>(context,android.R.layout.simple_spinner_item, Events0);
        adapterEventCategory.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterCategoryCategory =new ArrayAdapter<String>(context,android.R.layout.simple_spinner_item, Events0);
        adapterCategoryCategory.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapterCategoryCategory);
        year = new SimpleDateFormat("yyyy").format(new Date());
        month = new SimpleDateFormat("MM").format(new Date());
        date = new SimpleDateFormat("dd").format(new Date());

        SubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validData()) {

                    PostDataTask postDataTask = new PostDataTask();
                    postDataTask.execute(URL_FORM,
                            editName.getText().toString(),
                            editEmail.getText().toString(),
                            editPhoneNumber.getText().toString(),
                            editCollege.getText().toString(),
                            editMembers.getText().toString(),
                            selectevents.getText().toString(),
                            month,date,year,amount);
                }

            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(!selectevents.getText().toString().contains(parent.getItemAtPosition(position).toString())) {
                    selectevents.append(parent.getItemAtPosition(position).toString()+", ");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                category=adapterView.getItemAtPosition(i).toString();
                if(i==1)
                {
                    adapterCategoryCategory =new ArrayAdapter<String>(context,android.R.layout.simple_spinner_item, Events0);
                    adapterCategoryCategory.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapterCategoryCategory);

                } else if (i==2) {
                    adapterCategoryCategory =new ArrayAdapter<String>(context,android.R.layout.simple_spinner_item, Events1);
                    adapterCategoryCategory.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapterCategoryCategory);
                } else if (i==3)
                {
                    adapterCategoryCategory =new ArrayAdapter<String>(context,android.R.layout.simple_spinner_item, Events2);
                    adapterCategoryCategory.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapterCategoryCategory);
                } else if (i==4)
                {
                    adapterCategoryCategory =new ArrayAdapter<String>(context,android.R.layout.simple_spinner_item, Events3);
                    adapterCategoryCategory.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapterCategoryCategory);
                } else if (i==5)
                {
                    adapterCategoryCategory =new ArrayAdapter<String>(context,android.R.layout.simple_spinner_item, Events4);
                    adapterCategoryCategory.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapterCategoryCategory);
                } else if (i==6)
                {
                    adapterCategoryCategory =new ArrayAdapter<String>(context,android.R.layout.simple_spinner_item, Events5);
                    adapterCategoryCategory.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapterCategoryCategory);
                } else if (i==7)
                {
                    adapterCategoryCategory =new ArrayAdapter<String>(context,android.R.layout.simple_spinner_item, Events6);
                    adapterCategoryCategory.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapterCategoryCategory);
                } else if (i==8)
                {
                    adapterCategoryCategory =new ArrayAdapter<String>(context,android.R.layout.simple_spinner_item, Events7);
                    adapterCategoryCategory.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapterCategoryCategory);
                } else if (i==9)
                {
                    adapterCategoryCategory =new ArrayAdapter<String>(context,android.R.layout.simple_spinner_item, Events8);
                    adapterCategoryCategory.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapterCategoryCategory);
                }
                else if (i==10)
                {
                    adapterCategoryCategory =new ArrayAdapter<String>(context,android.R.layout.simple_spinner_item, Events9);
                    adapterCategoryCategory.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapterCategoryCategory);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        return mainView;
    }

    class PostDataTask extends AsyncTask<String, Void, Boolean> {
        ProgressDialog progress;
        @Override
        protected void onPreExecute() {
            progress = new ProgressDialog(context);
            progress.setMessage("Please Wait..");
            progress.show();
        }

        @Override
        protected Boolean doInBackground(String... contactData) {
            Boolean result = true;
            String url = contactData[0];
            String name = contactData[1];
            String email = contactData[2];
            String number = contactData[3];
            String college = contactData[4];
            String members = contactData[5];
            String events = contactData[6];
            String month = contactData[7];
            String date = contactData[8];
            String year = contactData[9];
            String amount = contactData[10];


            String postBody = "";

            try {

                postBody = NAME_KEY + "=" + URLEncoder.encode(name, "UTF-8") +
                        "&" + EMAIL_KEY + "=" + URLEncoder.encode(email, "UTF-8") +
                        "&" + NUMBER_KEY + "=" + URLEncoder.encode(number, "UTF-8")+
                        "&" + COLLEGE_KEY + "=" + URLEncoder.encode(college, "UTF-8")+
                        "&" + NUM_MEMBERS_KEY + "=" + URLEncoder.encode(members, "UTF-8")+
                        "&" + EVENTS_KEY + "=" + URLEncoder.encode(events, "UTF-8")+
                        "&" + DATEMON_KEY + "=" + URLEncoder.encode(month, "UTF-8")+
                        "&" + DATEDAY_KEY + "=" + URLEncoder.encode(date, "UTF-8")+
                        "&" + DATEYEAR_KEY + "=" + URLEncoder.encode(year, "UTF-8")+
                        "&" + AMOUNT_KEY + "=" + URLEncoder.encode(amount, "UTF-8");

            } catch (UnsupportedEncodingException ex) {
                result = false;
            }
            try {
                OkHttpClient client = new OkHttpClient();
                RequestBody body = RequestBody.create(FORM_DATA_TYPE, postBody);
                Request request = new Request.Builder()
                        .url(url)
                        .post(body)
                        .build();
                Response response = client.newCall(request).execute();
            } catch (IOException exception) {
                result = false;
            }
            return result;
        }

        @Override
        protected void onPostExecute(Boolean result) {
            progress.cancel();
            final AlertDialog.Builder alert=new AlertDialog.Builder(context);
            alert.setMessage(result ? "Successfully Registered! The fee can be deposited at any registration counter in the campus." : "There was some error in sending message. Please try again after some time.").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    editName.setText("");
                    editCollege.setText("");
                    editEmail.setText("");
                    editPhoneNumber.setText("");


                }
            });
            AlertDialog alertDialog=alert.create();
            alertDialog.show();
        }
    }

    boolean validData()
    {   String userName=editName.getText().toString();
        String userNumber = editPhoneNumber.getText().toString();
        String userEmail = editEmail.getText().toString();
        String userCollege=editCollege.getText().toString();
        String userMembers=editMembers.getText().toString();
        String userEvents=selectevents.getText().toString();

        if (userName.length()<3)
        {
            Toast.makeText(context, "Enter a Valid Name", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (userNumber.length()!=10||userNumber.startsWith("0")||userNumber.startsWith("1")||userNumber.startsWith("2")||userNumber.startsWith("3")||userNumber.startsWith("4")||userNumber.startsWith("5")||userNumber.startsWith("6"))
        {
            Toast.makeText(context, "Enter a Valid Mobile Number", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (userEmail.length()<3||!userEmail.contains("@"))
        {
            Toast.makeText(context, "Enter a Valid Email Address", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (userCollege.length()<3)
        {
            Toast.makeText(context, "Enter a Valid College Name", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(userEvents.length()<18)
        {
            Toast.makeText(context, "No Event Selected", Toast.LENGTH_SHORT).show();
            return false;
        }


        return true;
    }
}
