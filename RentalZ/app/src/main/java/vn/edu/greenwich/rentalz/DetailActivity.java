package vn.edu.greenwich.rentalz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView tvName_property = findViewById(R.id.tvName);
        TextView tvAddress_property = findViewById(R.id.tvAddress);
        TextView tvRoom_property = findViewById(R.id.tvRoom);
        TextView tvType_property = findViewById(R.id.tvType);
        TextView tvPrice_property = findViewById(R.id.tvPrice);
        TextView tvReport_property = findViewById(R.id.tvReport);
        TextView tvFurniture_property = findViewById(R.id.tvFurniture);
        TextView tvNote_property = findViewById(R.id.tvNote);

        Intent intent = getIntent();

        String name_property = "", address_property ="", number_of_room = "", type = "", price ="", reporter = "", furniture="", note="";

        name_property = intent.getStringExtra("propertyName");
        address_property = intent.getStringExtra("address");
        number_of_room = intent.getStringExtra("room");
        type = intent.getStringExtra("type");
        price = intent.getStringExtra("price");
        reporter = intent.getStringExtra("reporter");
        furniture = intent.getStringExtra("furniture");
        note = intent.getStringExtra("note");

        tvName_property.setText(name_property);
        tvAddress_property.setText(address_property);
        tvRoom_property.setText(number_of_room);
        tvType_property.setText(type);
        tvPrice_property.setText(price);
        tvReport_property.setText(reporter);
        tvFurniture_property.setText(furniture);
        tvNote_property.setText(note);

    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}