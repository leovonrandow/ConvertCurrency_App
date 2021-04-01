package com.example.prova1_leonardo_von_randow

import android.os.Bundle
import android.widget.EditText
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.blackcat.currencyedittext.CurrencyEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var editextBRL = findViewById<CurrencyEditText>(R.id.input_brl)
        var buttonUSA = findViewById<RelativeLayout>(R.id.botao1);
        var buttonMEX = findViewById<RelativeLayout>(R.id.botao2);
        var buttonRUS = findViewById<RelativeLayout>(R.id.botao3);
        var buttonAR = findViewById<RelativeLayout>(R.id.botao4);
        var buttonJAP = findViewById<RelativeLayout>(R.id.botao5);
        var buttonIND = findViewById<RelativeLayout>(R.id.botao6);

        var outputCurrency = findViewById<TextView>(R.id.currency_value)
        var CurrencyName = findViewById<TextView>(R.id.currency_name)

        buttonUSA.setOnClickListener {
            outputCurrency.text = "US$ " + brltoUsd(editextBRL.rawValue.toDouble()).toString()
            CurrencyName.text = "Conversão em Dólar";
        }
        buttonMEX.setOnClickListener {
            outputCurrency.text = brltoEur(editextBRL.rawValue.toDouble()).toString() + "€"
            CurrencyName.text = "Conversão em Euro";
        }
        buttonRUS.setOnClickListener {
            outputCurrency.text = brltoRub(editextBRL.rawValue.toDouble()).toString() + "₱"
            CurrencyName.text = "Conversão em Rublo";
        }
        buttonAR.setOnClickListener {
            outputCurrency.text = brltoDir(editextBRL.rawValue.toDouble()).toString().toString()
            CurrencyName.text = "Conversão em Dirham";
        }
        buttonJAP.setOnClickListener {
            outputCurrency.text = "¥" + brltoIen(editextBRL.rawValue.toDouble()).toString().toString()
            CurrencyName.text = "Conversão em Iene";
        }
        buttonIND.setOnClickListener {
            outputCurrency.text = brltoRup(editextBRL.rawValue.toDouble()).toString().toString() + " INR"
            CurrencyName.text = "Conversão em Rupia";
        }
    }

    //como o rawValue pegava o valor bruto do input tive que dividir o o valor por 100 ao final para colocar as casa decimais
    fun brltoUsd(valor: Double): Double {
        return valor * 0.18 / 100;
    }
    fun brltoEur(valor: Double): Double {
        return (valor) * 0.15 /100;
    }
    fun brltoRub(valor: Double): Double {
        return valor * 13.53 /100;
    }
    fun brltoDir(valor: Double): Double {
        return valor * 1.49 /100;
    }
    fun brltoIen(valor: Double): Double {
        return valor * 20.30 /100;
    }
    fun brltoRup(valor: Double): Double {
        return valor * 13.18540 /100;
    }
}