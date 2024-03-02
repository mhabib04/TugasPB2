package com.example.meowpetshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvNota;

    private EditText etMeo, etWishkas, etRoyalCanin;

    private Button btnProses;

    private RadioButton yesMember, noMember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvNota = findViewById(R.id.tvNota);
        etMeo = findViewById(R.id.etMeo);
        etWishkas = findViewById(R.id.etWishkas);
        etRoyalCanin = findViewById(R.id.etRoyalCanin);
        btnProses = findViewById(R.id.btnProses);
        yesMember = findViewById(R.id.yesMember);
        noMember = findViewById(R.id.noMember);

        btnProses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder result = new StringBuilder();

                int hargaMeo = 26000;
                int adminMeo = 2000;
                int hargaWishkas = 40000;
                int adminWishkas = 2500;
                int hargaRoyalCanin = 50000;
                int adminRoyalCanin = 3000;

                String inputMeo = etMeo.getText() != null ? etMeo.getText().toString() : "0";
                String inputWishkas = etWishkas.getText() != null ? etWishkas.getText().toString() : "0";
                String inputRoyalCanin = etRoyalCanin.getText() != null ? etRoyalCanin.getText().toString() : "0";

                int totalMeo = 0;
                int totalWishkas = 0;
                int totalRoyalCanin = 0;

                int jumlahMeo = !inputMeo.isEmpty() ? Integer.parseInt(inputMeo) : 0;
                int jumlahWishkas = !inputWishkas.isEmpty() ? Integer.parseInt(inputWishkas) : 0;
                int jumlahRoyalCanin = !inputRoyalCanin.isEmpty() ? Integer.parseInt(inputRoyalCanin) : 0;


                if (jumlahMeo == 0 && jumlahWishkas == 0 && jumlahRoyalCanin == 0) {
                    result.append("Isi terlebih dahulu!");
                } else {
                    result.append("==== Rincian pesanan ====" );
                    if (jumlahMeo != 0){
                        totalMeo = (hargaMeo * jumlahMeo);
                        result.append("\nme-o (" + jumlahMeo + " pcs) : Rp" + totalMeo);
                        result.append("\nBiaya admin (me-o) : Rp" + adminMeo);
                        totalMeo += adminMeo;
                    } if (jumlahWishkas != 0){
                        totalWishkas = (hargaWishkas * jumlahWishkas);
                        result.append("\nWishkas (" + jumlahWishkas + " pcs) : Rp" + totalWishkas);
                        result.append("\nBiaya admin (Wishkas) : Rp" + adminWishkas);
                        totalWishkas += adminWishkas;
                    } if (jumlahRoyalCanin != 0){
                        totalRoyalCanin = (hargaRoyalCanin * jumlahRoyalCanin);
                        result.append("\nRoyal Canin (" + jumlahRoyalCanin + " pcs) : Rp" + totalRoyalCanin);
                        result.append("\nBiaya admin (Royal Canin) : Rp" + adminRoyalCanin);
                        totalRoyalCanin += adminRoyalCanin;
                    }

                    int total = totalMeo + totalWishkas + totalRoyalCanin;
                    result.append("\nTotal belanja : Rp" + total);

                    if (yesMember.isChecked()){
                        double member = 0.05 * total;
                        total -= member;
                        result.append("\nDiskon member(5%) : Rp" + member);
                        result.append("\nTotal akhir : Rp" + total);
                    } else {
                        total = totalMeo + totalWishkas + totalRoyalCanin;
                        result.append("\nTotal akhir : Rp" + total);
                    }
                }
                tvNota.setText(result.toString());
            }
        });
    }
}