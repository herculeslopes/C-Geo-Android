package com.example.cgeo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.cgeo.Functions;
import com.example.cgeo.sections.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout currentLayout;
    private TableLayout resultLayout;

    private ImageView btnTLayout, btnLLayout, btnULayout, btnCLayout, btnILayout, btnHLayout,
                        btnCalculate, btnDiscard;

    private EditText tLayoutEntryX, tLayoutEntryB, tLayoutEntryY, tLayoutEntryZ,
                        lLayoutEntryY, lLayoutEntryK, lLayoutEntryX, lLayoutEntryU,
                    uLayoutEntryX, uLayoutEntryY, uLayoutEntryA, uLayoutEntryH,
                        cLayoutEntryB, cLayoutEntryH, cLayoutEntryA, cLayoutEntryM,
                    iLayoutEntryW, iLayoutEntryH,
                        hLayoutEntryX, hLayoutEntryY, hLayoutEntryA, hLayoutEntryD, hLayoutEntryH, hLayoutEntryR;

    private TextView txtResultArea, txtResultPerimeter, txtResultCy, txtResultCx, txtResultIz, txtResultIy, txtResultScgz, txtResultScgy, txtResultKz, txtResultKy;

    private double area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setWidgets();
//        setSidebarFunctions();
        btnTLayout.setOnClickListener(this);
        btnLLayout.setOnClickListener(this);
        btnULayout.setOnClickListener(this);
        btnCLayout.setOnClickListener(this);
        btnILayout.setOnClickListener(this);
        btnHLayout.setOnClickListener(this);

        setLayoutMenuFunctions();
    }

    public void setWidgets() {
        currentLayout = findViewById(R.id.tLayout);
        resultLayout = findViewById(R.id.resultLayout);

        // Layout Buttons
        btnTLayout = findViewById(R.id.btnTLayout);
        btnLLayout = findViewById(R.id.btnLLayout);
        btnULayout = findViewById(R.id.btnULayout);
        btnCLayout = findViewById(R.id.btnCLayout);
        btnILayout = findViewById(R.id.btnILayout);
        btnHLayout = findViewById(R.id.btnHLayout);

        // T Layout Widgets
        tLayoutEntryX = findViewById(R.id.TLayoutEntryX);
        tLayoutEntryB = findViewById(R.id.TLayoutEntryB);
        tLayoutEntryY = findViewById(R.id.TLayoutEntryY);
        tLayoutEntryZ = findViewById(R.id.TLayoutEntryZ);

        // L Layout Widgets
        lLayoutEntryY = findViewById(R.id.LLayoutEntryY);
        lLayoutEntryK = findViewById(R.id.LLayoutEntryK);
        lLayoutEntryX = findViewById(R.id.LLayoutEntryX);
        lLayoutEntryU = findViewById(R.id.LLayoutEntryU);

        // U Layout Widgets
        uLayoutEntryX = findViewById(R.id.ULayoutEntryX);
        uLayoutEntryY = findViewById(R.id.ULayoutEntryY);
        uLayoutEntryA = findViewById(R.id.ULayoutEntryA);
        uLayoutEntryH = findViewById(R.id.ULayoutEntryH);

        // C Layout Widgets
        cLayoutEntryB = findViewById(R.id.CLayoutEntryB);
        cLayoutEntryH = findViewById(R.id.CLayoutEntryH);
        cLayoutEntryA = findViewById(R.id.CLayoutEntryA);
        cLayoutEntryM = findViewById(R.id.CLayoutEntryM);

        // I Layout
        iLayoutEntryW = findViewById(R.id.ILayoutEntryW);
        iLayoutEntryH = findViewById(R.id.ILayoutEntryH);

        // H Layout
        hLayoutEntryX = findViewById(R.id.HLayoutEntryX);
        hLayoutEntryY = findViewById(R.id.HLayoutEntryY);
        hLayoutEntryA = findViewById(R.id.HLayoutEntryA);
        hLayoutEntryD = findViewById(R.id.HLayoutEntryD);
        hLayoutEntryH = findViewById(R.id.HLayoutEntryH);
        hLayoutEntryR = findViewById(R.id.HLayoutEntryR);

        // Result Widgets
        txtResultArea = findViewById(R.id.txtResultArea);
        txtResultPerimeter = findViewById(R.id.txtResultPerimeter);
        txtResultCy = findViewById(R.id.txtResultCy);
        txtResultCx = findViewById(R.id.txtResultCx);
        txtResultIz = findViewById(R.id.txtResultIz);
        txtResultIy = findViewById(R.id.txtResultIy);
        txtResultScgz = findViewById(R.id.txtResultScgz);
        txtResultScgy = findViewById(R.id.txtResultScgy);
        txtResultKz = findViewById(R.id.txtResultKz);
        txtResultKy = findViewById(R.id.txtResultKy);

        // Menu Widgets
        btnCalculate = findViewById(R.id.btnCalculate);
        btnDiscard = findViewById(R.id.btnDiscard);
//        txtTest = findViewById(R.id.txtTest);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        Log.d("id: ", Integer.toString(id));
        if (id == R.id.btnTLayout || id == R.id.btnLLayout || id == R.id.btnULayout || id == R.id.btnCLayout ||
                id == R.id.btnILayout || id == R.id.btnHLayout) {
            currentLayout.setVisibility(View.GONE);
            resultLayout.setVisibility(View.VISIBLE);

            switch (id) {
                case R.id.btnTLayout:
                    currentLayout = findViewById(R.id.tLayout);
                    break;
                case R.id.btnLLayout:
                    currentLayout = findViewById(R.id.lLayout);
                    break;
                case R.id.btnULayout:
                    currentLayout = findViewById(R.id.uLayout);
                    break;
                case R.id.btnCLayout:
                    currentLayout = findViewById(R.id.cLayout);
                    break;
                case R.id.btnILayout:
                    currentLayout = findViewById(R.id.iLayout);
                    break;
                case R.id.btnHLayout:
                    currentLayout = findViewById(R.id.hLayout);
                    break;
            }
            currentLayout.setVisibility(View.VISIBLE);
        } else {
            resultLayout.setVisibility(View.GONE);
        }
    }

    /*
    public void setSidebarFunctions() {
        btnTLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentLayout.setVisibility(View.GONE);
                currentLayout = findViewById(R.id.tLayout);
                currentLayout.setVisibility(View.VISIBLE);

                clearResults();
            }
        });

        btnLLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentLayout.setVisibility(View.GONE);
                currentLayout = findViewById(R.id.lLayout);
                currentLayout.setVisibility(View.VISIBLE);

                clearResults();
            }
        });

        btnULayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentLayout.setVisibility(View.GONE);
                currentLayout = findViewById(R.id.uLayout);
                currentLayout.setVisibility(View.VISIBLE);

                clearResults();
            }
        });

        btnCLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentLayout.setVisibility(View.GONE);
                currentLayout = findViewById(R.id.cLayout);
                currentLayout.setVisibility(View.VISIBLE);

                clearResults();
            }
        });

        btnILayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentLayout.setVisibility(View.GONE);
                currentLayout = findViewById(R.id.iLayout);
                currentLayout.setVisibility(View.VISIBLE);

                clearResults();
            }
        });

        btnHLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentLayout.setVisibility(View.GONE);
                currentLayout = findViewById(R.id.hLayout);
                currentLayout.setVisibility(View.VISIBLE);

                clearResults();
            }
        });
    }
    */

    public void setLayoutMenuFunctions() {
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentLayout.equals(findViewById(R.id.tLayout))) {
                    double x = Functions.textToDouble(tLayoutEntryX.getText());
                    double b = Functions.textToDouble(tLayoutEntryB.getText());
                    double y = Functions.textToDouble(tLayoutEntryY.getText());
                    double z = Functions.textToDouble(tLayoutEntryZ.getText());

                    TSection tsection = new TSection(x, b, y, z);

                    showSectionResults(tsection);
                } else if (currentLayout.equals(findViewById(R.id.lLayout))) {
                    double y = Functions.textToDouble(lLayoutEntryY.getText());
                    double k = Functions.textToDouble(lLayoutEntryK.getText());
                    double x = Functions.textToDouble(lLayoutEntryX.getText());
                    double u = Functions.textToDouble(lLayoutEntryU.getText());

                    LSection lsection = new LSection(y, k, x, u);

                    showSectionResults(lsection);

                } else if (currentLayout.equals(findViewById(R.id.uLayout))) {
                    double x = Functions.textToDouble(uLayoutEntryX.getText());
                    double y = Functions.textToDouble(uLayoutEntryY.getText());
                    double a = Functions.textToDouble(uLayoutEntryA.getText());
                    double h = Functions.textToDouble(uLayoutEntryH.getText());

                    USection usection = new USection(x, y, a, h);

                    showSectionResults(usection);

                } else if (currentLayout.equals(findViewById(R.id.cLayout))) {
                    double b = Functions.textToDouble(cLayoutEntryB.getText());
                    double h = Functions.textToDouble(cLayoutEntryH.getText());
                    double a = Functions.textToDouble(cLayoutEntryA.getText());
                    double m = Functions.textToDouble(cLayoutEntryM.getText());

                    CSection csection = new CSection(b, h, a, m);

                    showSectionResults(csection);
                } else if (currentLayout.equals(findViewById(R.id.iLayout))) {
                    double w = Functions.textToDouble(iLayoutEntryW.getText());
                    double h = Functions.textToDouble(iLayoutEntryH.getText());

                    ISection isection = new ISection(w, h);

                    showSectionResults(isection);
                } else if (currentLayout.equals(findViewById(R.id.hLayout))) {
                    double x = Functions.textToDouble(hLayoutEntryX.getText());
                    double y = Functions.textToDouble(hLayoutEntryY.getText());
                    double a = Functions.textToDouble(hLayoutEntryA.getText());
                    double d = Functions.textToDouble(hLayoutEntryD.getText());
                    double h = Functions.textToDouble(hLayoutEntryH.getText());
                    double r = Functions.textToDouble(hLayoutEntryR.getText());

                    HSection hsection = new HSection(x, y, a, d, h, r);

                    showSectionResults(hsection);
                }
            }
        });

        btnDiscard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentLayout.equals(findViewById(R.id.tLayout))) {
                    tLayoutEntryX.setText("");
                    tLayoutEntryB.setText("");
                    tLayoutEntryY.setText("");
                    tLayoutEntryZ.setText("");

                    clearResults();
                } else if (currentLayout.equals(findViewById(R.id.lLayout))) {
                    lLayoutEntryY.setText("");
                    lLayoutEntryK.setText("");
                    lLayoutEntryX.setText("");
                    lLayoutEntryU.setText("");

                    clearResults();
                } else if (currentLayout.equals(findViewById(R.id.uLayout))) {
                    uLayoutEntryX.setText("");
                    uLayoutEntryY.setText("");
                    uLayoutEntryA.setText("");
                    uLayoutEntryH.setText("");

                    clearResults();
                } else if (currentLayout.equals(findViewById(R.id.cLayout))) {
                    cLayoutEntryB.setText("");
                    cLayoutEntryH.setText("");
                    cLayoutEntryA.setText("");
                    cLayoutEntryM.setText("");

                    clearResults();
                } else if (currentLayout.equals(findViewById(R.id.iLayout))) {
                    iLayoutEntryW.setText("");
                    iLayoutEntryH.setText("");

                    clearResults();
                } else if (currentLayout.equals(findViewById(R.id.hLayout))) {
                    hLayoutEntryX.setText("");
                    hLayoutEntryY.setText("");
                    hLayoutEntryA.setText("");
                    hLayoutEntryD.setText("");
                    hLayoutEntryH.setText("");
                    hLayoutEntryR.setText("");

                    clearResults();
                }
            }
        });
    }

    @SuppressLint("SetTextI18n")
    public <T extends  Section> void showSectionResults(T section) {
        txtResultArea.setText(Double.toString(section.getArea()));
        txtResultPerimeter.setText(Double.toString(section.getPerimeter()));
        txtResultCy.setText(Double.toString(section.getCy()));
        txtResultCx.setText(Double.toString(section.getCx()));
        txtResultIz.setText(Double.toString(section.getIz()));
        txtResultIy.setText(Double.toString(section.getIy()));
        txtResultScgz.setText(Double.toString(section.getScgz()));
        txtResultScgy.setText(Double.toString(section.getScgy()));
        txtResultKz.setText(Double.toString(section.getKz()));
        txtResultKy.setText(Double.toString(section.getKy()));
    }

    public void clearResults() {
        txtResultArea.setText("");
        txtResultPerimeter.setText("");
        txtResultCy.setText("");
        txtResultCx.setText("");
        txtResultIz.setText("");
        txtResultIy.setText("");
        txtResultScgz.setText("");
        txtResultScgy.setText("");
        txtResultKz.setText("");
        txtResultKy.setText("");
    }
}