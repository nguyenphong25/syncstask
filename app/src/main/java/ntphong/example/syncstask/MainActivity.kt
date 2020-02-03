package ntphong.example.syncstask

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnxuli.setOnClickListener {
            xulicv().execute()
        }
    }
   inner class xulicv : AsyncTask<Void,String,String>(){
        override fun onPreExecute() {
            super.onPreExecute()
            txtnodung.text="bat dau thuc hien \n"
        }
        override fun doInBackground(vararg params: Void?): String {
            for (cv in 1..5){
                publishProgress("xong viec 1$cv")
            }
            return "ket thuc cong viec"
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            txtnodung.append(result)
        }

       override fun onProgressUpdate(vararg values: String?) {
           super.onProgressUpdate(*values)
           txtnodung.append(values[0])
       }
    }


}
