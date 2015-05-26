package com.example.diego.control_488_16;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class MainActivity extends ActionBarActivity {




    EditText edit_IP,edit_Puerto;
    Button btn_Temp,btn_Reset;
    CheckBox CkB_Echo;
    Boolean EchoBool=false;
    TextView text_Temp,textTitServ;
    ToggleButton TB_1,TB_2,TB_3,TB_4,TB_5,TB_6,TB_7;
    Switch switch1;
      static String A1="A1 X", B1="B1 X", A2="A2 X", B2="B2 X", A3="A3 X", B3="B3 X", A4="A4 X", B4="B4 X", A5="A5 X",
            B5="B5 X", A6="A6 X", B6="B6 X", B7="B7 X", A7="A7 X";

    static String RX="*rx";
    Conexion ClienteTCP;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LevantarXML();
        Botones();
        CargarPreferencias();
        habilitar(false);
    }

    @Override
    protected void onPause() {
        super.onPause();
        GuardarPreferencias();
    }



    private void Botones() {
        CkB_Echo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                EchoBool=isChecked;
                if(isChecked){
                    Toast.makeText(getApplicationContext(),"Echo Habilitado",Toast.LENGTH_SHORT).show();
                    textTitServ.setEnabled(true);
                    text_Temp.setEnabled(true);
                }else{
                    Toast.makeText(getApplicationContext(),"Echo Deshabilido",Toast.LENGTH_SHORT).show();
                    textTitServ.setEnabled(false);
                    text_Temp.setEnabled(false);
                }

            }
        });

        btn_Temp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String IP=edit_IP.getText().toString();
                int Puerto=Integer.parseInt(edit_Puerto.getText().toString());
                ClienteTCP=new Conexion(IP,Puerto,"t1",getApplicationContext());
                ClienteTCP.execute();
                //  String pepe=ClienteTCP.mensajito();
                //    Toast.makeText(getApplicationContext(),pepe,Toast.LENGTH_SHORT).show();

            }
        });


        TB_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                String IP = edit_IP.getText().toString();
                int Puerto = Integer.parseInt(edit_Puerto.getText().toString());
                if (isChecked) {
                  ClienteTCP = new Conexion(IP, Puerto, A1, getApplicationContext());
              ClienteTCP.execute();

                } else {
                    ClienteTCP = new Conexion(IP, Puerto, B1, getApplicationContext());
                    ClienteTCP.execute();
       }

            }
        });
        TB_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                String IP=edit_IP.getText().toString();
                int Puerto=Integer.parseInt(edit_Puerto.getText().toString());
                if(isChecked){
                    ClienteTCP=new Conexion(IP,Puerto,A2,getApplicationContext());
                    ClienteTCP.execute();

                }else{
                    ClienteTCP=new Conexion(IP,Puerto,B2,getApplicationContext());
                    ClienteTCP.execute();
                }

            }
        });
        TB_3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                String IP=edit_IP.getText().toString();
                int Puerto=Integer.parseInt(edit_Puerto.getText().toString());
                if(isChecked){
                    ClienteTCP=new Conexion(IP,Puerto,A3,getApplicationContext());
                    ClienteTCP.execute();
                 }else{
                    ClienteTCP=new Conexion(IP,Puerto,B3,getApplicationContext());
                    ClienteTCP.execute();
                 }

            }
        });
        TB_4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                String IP=edit_IP.getText().toString();
                int Puerto=Integer.parseInt(edit_Puerto.getText().toString());
                if(isChecked){
                    ClienteTCP=new Conexion(IP,Puerto,A4,getApplicationContext());
                    ClienteTCP.execute();
                  }else{
                    ClienteTCP=new Conexion(IP,Puerto,B4,getApplicationContext());
                    ClienteTCP.execute();
                }

            }
        });
        TB_5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                String IP=edit_IP.getText().toString();
                int Puerto=Integer.parseInt(edit_Puerto.getText().toString());
                if(isChecked){
                    ClienteTCP=new Conexion(IP,Puerto,A5,getApplicationContext());
                    ClienteTCP.execute();
                }else{
                    ClienteTCP=new Conexion(IP,Puerto,B5,getApplicationContext());
                    ClienteTCP.execute();
               }

            }
        });
        TB_6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                String IP=edit_IP.getText().toString();
                int Puerto=Integer.parseInt(edit_Puerto.getText().toString());
                if(isChecked){
                    ClienteTCP=new Conexion(IP,Puerto,A6,getApplicationContext());
                    ClienteTCP.execute();
                }else{
                    ClienteTCP=new Conexion(IP,Puerto,B6,getApplicationContext());
                    ClienteTCP.execute();
            }

            }
        });
        TB_7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                String IP=edit_IP.getText().toString();
                int Puerto=Integer.parseInt(edit_Puerto.getText().toString());
                if(isChecked){
                    ClienteTCP=new Conexion(IP,Puerto,A7,getApplicationContext());
                    ClienteTCP.execute();
               }else{
                    ClienteTCP=new Conexion(IP,Puerto,B7,getApplicationContext());
                    ClienteTCP.execute();
              }

            }
        });

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                habilitar(isChecked);
            }
        });


        btn_Reset.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String IP=edit_IP.getText().toString();
                int Puerto=Integer.parseInt(edit_Puerto.getText().toString());
                ClienteTCP=new Conexion(IP,Puerto,RX,getApplicationContext());
                ClienteTCP.execute();
            }
        });
    }

    private void LevantarXML() {

        text_Temp=(TextView)findViewById(R.id.text_Temp);
        textTitServ=(TextView)findViewById(R.id.textTitServ);
        CkB_Echo=(CheckBox)findViewById(R.id.ckBox_Echo);
        edit_IP= (EditText) findViewById(R.id.edit_IP);
        edit_Puerto=(EditText) findViewById(R.id.edit_Puerto);
        btn_Temp=(Button)findViewById(R.id.btn_Temp);
        btn_Reset=(Button)findViewById(R.id.btn_Reset);
        TB_1=(ToggleButton)findViewById(R.id.TB_1);
        TB_2=(ToggleButton)findViewById(R.id.TB_2);
        TB_3=(ToggleButton)findViewById(R.id.TB_3);
        TB_4=(ToggleButton)findViewById(R.id.TB_4);
        TB_5=(ToggleButton)findViewById(R.id.TB_5);
        TB_6=(ToggleButton)findViewById(R.id.TB_6);
        TB_7=(ToggleButton)findViewById(R.id.TB_7);
        switch1= (Switch) findViewById(R.id.switch1);

    }

    ///////////////////// PREFERENCIAS DE USUARIO ////////////////
    public void CargarPreferencias(){

        SharedPreferences mispreferencias=getSharedPreferences("PreferenciasUsuario", Context.MODE_PRIVATE);
        edit_IP.setText(mispreferencias.getString("edit_IP", "200.51.82.70"));
        edit_Puerto.setText(mispreferencias.getString("edit_Port", "9001"));

        Log.d("TrackDroid", "Preferencias Cargadas");


    }

    public void GuardarPreferencias() {
        SharedPreferences mispreferencias = getSharedPreferences("PreferenciasUsuario", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mispreferencias.edit();
        editor.putString("edit_IP", edit_IP.getText().toString());
        editor.putString("edit_Port", edit_Puerto.getText().toString());
        editor.commit();
        Log.d("TrackDroid", "Preferencias Almacenadas");

    }
// //////////////////////////////////////////////////////////

    private void habilitar(boolean bol){
        edit_Puerto.setEnabled(!bol);
        edit_IP.setEnabled(!bol);
        TB_1.setEnabled(bol);
        TB_2.setEnabled(bol);
        TB_3.setEnabled(bol);
        TB_4.setEnabled(bol);
        TB_5.setEnabled(bol);
        TB_6.setEnabled(bol);
        TB_7.setEnabled(bol);


    }


    private class Conexion extends AsyncTask <Void,Void,String>{

        int Puerto ;
        String msg,Ip,RespServer;
        Context contexto;
        String TAG="ConexionIP";
        String salida;
        PrintWriter out;

        public  Conexion(String Ip,int Puerto,String msg,Context contexto) {

            this.Ip = Ip;
            this.msg = msg;
            this.Puerto = Puerto;
            this.contexto=contexto;

        }


        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected String doInBackground(Void... params) {


            try {
                Socket socket;
                //Create a client socket and define internet address and the port of the server
                socket = new Socket(Ip,Puerto);
                //Get the input stream of the client socket
                InputStream is = socket.getInputStream();
                //Get the output stream of the client socket
                out = new PrintWriter(socket.getOutputStream(),true);
                //Write data to the output stream of the client socket
                out.println(msg+"\n");// Id REadiobase + Id alarma
                final BufferedReader br = new BufferedReader(
                        new InputStreamReader(is));
                if(EchoBool){
                    //Buffer the data coming from the input stream

                    String msg=br.readLine();
                    Log.d(TAG, "REcibido mensjae ");
                    salida=msg;}else{msg="Hecho Deshabiliado";}
                salida=msg;
                Log.d(TAG, " " + msg);
                publishProgress();
                socket.close();

            } catch (NumberFormatException e) {
                e.printStackTrace();
                Log.d(TAG, "NumberFormatException " + e);


            } catch (UnknownHostException e) {

                e.printStackTrace();
                Log.d(TAG, "UnknownHostException " + e);
            } catch (IOException e) {

                e.printStackTrace();
                Log.d(TAG, " IOException " + e);
            }



            return RespServer=salida;
        }

        @Override
        protected void onProgressUpdate(Void... values) {

            super.onProgressUpdate(values);
            //      Toast.makeText(getApplicationContext(), salida, Toast.LENGTH_SHORT).show();
            //      text_Temp.setText(values);

        }


        @Override
        protected void onPostExecute(String aVoid) {
            //   Toast.makeText(getApplicationContext(),aVoid,Toast.LENGTH_SHORT).show();
            text_Temp.setText(aVoid);
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }





}
