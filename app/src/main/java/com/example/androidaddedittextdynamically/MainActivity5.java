package com.example.androidaddedittextdynamically;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity5 extends AppCompatActivity {


    final int LIST_RESULT = 100;

    ArrayList<ListDataModel> list=new ArrayList<>();
    RecyclerView recyclerView;
    ListAdapter listAdapter;
    LinearLayoutManager llm;
    Button submitButton;
    ImageView add;
    String name1,name2,name3,name4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        recyclerView=findViewById(R.id.rv12);
        submitButton = (Button) findViewById(R.id.submit_button);
        add=findViewById(R.id.add);

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false));
       /* list = new ArrayList<>();
        list.add("","","");*/

        ListDataModel model=new ListDataModel("","","");
        list.add(model);

        listAdapter = new ListAdapter();
        llm = new LinearLayoutManager(this);

        //Setting the adapter
        recyclerView.setAdapter(listAdapter);
        recyclerView.setLayoutManager(llm);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {







                for (int i=0;i<list.size();i++){

                    name4=list.get(i).getName1();
                    String name2=list.get(i).getName2();
                    String name3=list.get(i).getName3();

                    Log.e("aaa",name4);
                }

                Log.e("aaa",String.valueOf(list.size()));


              /*  Intent intent=new Intent(getApplicationContext(),MainActivity3.class);
                intent.putExtra("aaaa",array);
                startActivity(intent);
*/
            }
        });

    }
    public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>{


        public class ViewHolder extends RecyclerView.ViewHolder {
            ImageButton  minus;
            EditText step,step1,step2;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);


                minus = (ImageButton) itemView.findViewById(R.id.minus);
                step = (EditText) itemView.findViewById(R.id.step);
                step1 = (EditText) itemView.findViewById(R.id.step1);
                step2 = (EditText) itemView.findViewById(R.id.step2);

                minus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int position = getAdapterPosition();
                        try {
                            list.remove(position);
                            notifyItemRemoved(position);
                        }catch (ArrayIndexOutOfBoundsException e){e.printStackTrace();}
                    }
                });

                add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int position = getAdapterPosition();
                        try {
                            ListDataModel model=new ListDataModel("","","");
                            list.add(model);

                            // list.add(position + 1,);
                            notifyItemInserted(position + 1);
                        }catch (ArrayIndexOutOfBoundsException e){e.printStackTrace();}
                    }
                });



            }


        }





        @NonNull
        @Override
        public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(getApplicationContext()).inflate(R.layout.list_item, parent, false);
            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull ListAdapter.ViewHolder holder, final int position) {





            holder.step.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                    name1=s.toString();
                    list.get(position).setName1(name1);

                }

                @Override
                public void afterTextChanged(Editable s) {
                }
            });
            holder.step1.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                    name2=s.toString();
                    list.get(position).setName2(name2);
                }

                @Override
                public void afterTextChanged(Editable s) {
                }
            });
            holder.step2.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                    name3=s.toString();
                    list.get(position).setName3(name3);
                }

                @Override
                public void afterTextChanged(Editable s) {
                }
            });






            int x = holder.getLayoutPosition();

            if(list.size()> 0) {
                holder.step.setText(list.get(x).Name1);
                holder.step1.setText(list.get(x).Name2);
                holder.step2.setText(list.get(x).Name3);
            }
            else{
                holder.step.setText(null);
                holder.step.setHint("Next Step");
                holder.step.requestFocus();
                holder.step1.setText(null);
                holder.step1.setHint("Next Step");
                holder.step1.requestFocus();
                holder.step2.setText(null);
                holder.step2.setHint("Next Step");
                holder.step2.requestFocus();
            }

        }

        @Override
        public int getItemCount() {
            return list.size();
        }


    }

}