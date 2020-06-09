package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

public class DisplayMessageActivity extends AppCompatActivity {

    //目标域名空间(即提供Web Service服务的域名空间)
    public static final String TARGETNAMESPACE = "http://webService.demo.example.com/";
    //需要调用的方法名(获得本天气预报Web Services支持的洲、国内外省份和城市信息)
    private static final String GETSUPPORTPROVINCE = "sayHello";
    //WSDL文档中给定的URL
    private static final String WSDL = "http://webService.demo.example.com/webservice/aaa";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.textView3);
        textView.setText(message);
    }

    public String getHii(View view) throws IOException, XmlPullParserException {
        System.out.println(111111);
        //实例化SOAP对象，指定命名空间和调用的方法
        SoapObject soapObject = new SoapObject(TARGETNAMESPACE,GETSUPPORTPROVINCE);
        soapObject.addProperty("name","mkl");
        //使用SOAP1.1协议创建Envelop对象
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        //设置与.Dot提供的Web Service服务保持良好的兼容性
        envelope.dotNet = true;
        //将初始化的soapObject放入（序列化）使用SOAP1.1协议创建Envelop对象中
        envelope.setOutputSoapObject(soapObject);

        System.out.println(2222);
        //构建传输对象，指定URL
        HttpTransportSE httpTransportSE = new HttpTransportSE(WSDL);
        httpTransportSE.call(TARGETNAMESPACE+GETSUPPORTPROVINCE,envelope);
        SoapObject result = (SoapObject) envelope.getResponse();
        System.out.println(result);
        return "";
    }

    public void getHi(View view) throws IOException, XmlPullParserException {
        System.out.println(111111);
        //实例化SOAP对象，指定命名空间和调用的方法
        SoapObject soapObject = new SoapObject(TARGETNAMESPACE,GETSUPPORTPROVINCE);
        soapObject.addProperty("name","mkl");
        //使用SOAP1.1协议创建Envelop对象
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        //设置与.Dot提供的Web Service服务保持良好的兼容性
        envelope.dotNet = true;
        //将初始化的soapObject放入（序列化）使用SOAP1.1协议创建Envelop对象中
        envelope.setOutputSoapObject(soapObject);

        System.out.println(2222);
        //构建传输对象，指定URL
        HttpTransportSE httpTransportSE = new HttpTransportSE(WSDL);
        httpTransportSE.call(TARGETNAMESPACE+GETSUPPORTPROVINCE,envelope);
        SoapObject result = (SoapObject) envelope.getResponse();
        System.out.println(result);

        String message = result.toString();
        TextView textView = findViewById(R.id.textView4);
        textView.setText(message);
    }
}