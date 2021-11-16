package vn.edu.greenwich.rentalz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String notification_welcome = getResources().getString(R.string.notification_welcome);

        Toast.makeText(this, notification_welcome , Toast.LENGTH_SHORT).show();

        Button btnCreate = findViewById(R.id.btnCreate);
        btnCreate.setOnClickListener(btnCreate_click);
    }

    private View.OnClickListener btnCreate_click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Boolean isValid = true;

            TextView notiName = findViewById(R.id.notiName);
            TextView notiAddress = findViewById(R.id.notiAddress);
            TextView notiRoom = findViewById(R.id.notiRoom);
            TextView notiType = findViewById(R.id.notiType);
            TextView notiReport = findViewById(R.id.notiReport);
            TextView notiPrice = findViewById(R.id.notiPrice);
            TextView notiFurniture = findViewById(R.id.notiFurniture);


            TextView txt_name = findViewById(R.id.txt_name);
            TextView txt_address = findViewById(R.id.txt_address);
            TextView txt_room = findViewById(R.id.txt_room);
            TextView txt_type = findViewById(R.id.txtType);
            TextView txt_reporter = findViewById(R.id.txt_reporter);
            TextView txt_price = findViewById(R.id.txtPrice);
            TextView txt_furniture = findViewById(R.id.txtFurniture);
            TextView txt_note = findViewById(R.id.txtNote);

            String error_empty_name="";
            String error_empty_address="";
            String error_empty_room="";
            String error_empty_type="";
            String error_empty_report="";
            String error_empty_price="";
            String error_empty_furniture="";


            String propertyName = txt_name.getText().toString();
            String address = txt_address.getText().toString();
            String room = txt_room.getText().toString();
            String type = txt_type.getText().toString();
            String price = txt_price.getText().toString();
            String reporter = txt_reporter.getText().toString();
            String furniture = txt_furniture.getText().toString();
            String note = txt_note.getText().toString();



            if (TextUtils.isEmpty(propertyName)){
                isValid = false;
                error_empty_name += "Please enter property name*";
            }


            if (TextUtils.isEmpty(address)){
                isValid = false;
                error_empty_address += "Please enter property address*";
            }


            if (TextUtils.isEmpty(room)){
                isValid = false;
                error_empty_room += "Please enter property number of rooms*";
            }


            if (TextUtils.isEmpty(type)){
                isValid = false;
                error_empty_type += "Please enter property type*";
            }

            if (TextUtils.isEmpty(price)){
                isValid = false;
                error_empty_price += "Please enter property price*";
            }


            if (TextUtils.isEmpty(reporter)){
                isValid = false;
                error_empty_report += "Please enter property reporter*";
            }
            if (TextUtils.isEmpty(furniture)){
                isValid = false;
                error_empty_furniture += "Please enter property furniture*";
            }

            if(isValid){
                Log.i("Main Activity", "Create property successfully." );
                String notification_create = getResources().getString(R.string.notification_create);

                Toast.makeText(view.getContext(), notification_create , Toast.LENGTH_SHORT).show();
                Intent detailActivity = new Intent(view.getContext(), DetailActivity.class);

                detailActivity.putExtra("propertyName", propertyName);
                detailActivity.putExtra("address", address);
                detailActivity.putExtra("room", room);
                detailActivity.putExtra("type", type);
                detailActivity.putExtra("price", price);
                detailActivity.putExtra("reporter", reporter);
                detailActivity.putExtra("furniture", furniture);
                detailActivity.putExtra("note", note);

                startActivity(detailActivity);
//                finish();
            }else{
                notiName.setText(error_empty_name);
                notiAddress.setText(error_empty_address);
                notiRoom.setText(error_empty_room);
                notiType.setText(error_empty_type);
                notiPrice.setText(error_empty_price);
                notiReport.setText(error_empty_report);
                notiFurniture.setText(error_empty_furniture);
                Log.e("Main Activity", "Please enter information.");
            }
        }
    };
}