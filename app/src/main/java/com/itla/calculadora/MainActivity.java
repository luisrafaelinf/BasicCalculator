package com.itla.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

	private TextView result;
	private TextInputEditText primerValor;
	private TextInputEditText segundoValor;
	private Button btnSum;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		result = findViewById(R.id.resultado);
		result.setText("");

		primerValor = findViewById(R.id.primerValor);
		primerValor.setText("0.0");

		segundoValor = findViewById(R.id.segundoValor);
		segundoValor.setText("0.0");

		btnSum = findViewById(R.id.btnSumar);

		addEvent();

	}

	private void addEvent() {

		btnSum.setOnClickListener(v -> {

			if (validValues()) {

				Double primero = Double.parseDouble(primerValor.getText().toString());
				Double segundo = Double.parseDouble(segundoValor.getText().toString());
				result.setText((primero + segundo) + "");
			}

		});

	}

	private boolean validValues() {

		if (primerValor.getText().toString().trim().isEmpty()
			|| segundoValor.getText().toString().trim().isEmpty()) {

			Toast toastValidation = Toast.makeText(getApplicationContext(), "Debe digitar ambos valores", Toast.LENGTH_SHORT);
			toastValidation.setGravity(Gravity.TOP, 0, 0);
			toastValidation.show();

			return false;

		}

		return true;

	}

}
