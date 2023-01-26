package com.example.filehandling
import android.app.ActionBar.LayoutParams
import android.os.Bundle
import android.os.Environment
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.filehandling.databinding.ActivityMainBinding
import java.io.File

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    var sorsolas_lista : ArrayList<Sorsolasok> = ArrayList<Sorsolasok>()
    lateinit var txtView: TextView
    lateinit var txtView2: TextView
    lateinit var txtView3: TextView
    lateinit var txtView4: TextView
    lateinit var txtView5: TextView
    lateinit var txtView6: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.table.setColumnStretchable(0, true)
        binding.table.setColumnStretchable(1, true)
        binding.table.setColumnStretchable(2, true)
        binding.table.setColumnStretchable(3, true)
        binding.table.setColumnStretchable(4, true)
        binding.table.setColumnStretchable(5, true)

        binding.button.setOnClickListener {
            if(Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED)
            {
                val kulsofajl = File(this.getExternalFilesDir(null), "lotto.txt")
                val lista=binding.editTextTextMultiLine.text.toString().split('\n')
                var txt =""
                for (item in lista){
                   // println(item)
                    txt+=item + "\n"
                }
                kulsofajl.writeText(txt)
                binding.editTextTextMultiLine.text.clear()
            }
        }

        binding.button2.setOnClickListener {
            if(Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED)
            {
                val kulsofajl = File(this.getExternalFilesDir(null), "lotto.txt")
                var lines = kulsofajl.readLines()
                for (item in lines) {
                    var parameterek = item.split(';')
                    for (item in parameterek){
                        print(item)
                    }
                    print("\n")
                    var sorsolas = Sorsolasok(parameterek[0], parameterek[1], parameterek[2], parameterek[3], parameterek[4], parameterek[5])
                    sorsolas_lista.add(sorsolas)
                }
                binding.table.setColumnStretchable(0, true)
                binding.table.setColumnStretchable(1, true)
                binding.table.setColumnStretchable(2, true)
                binding.table.setColumnStretchable(3, true)
                binding.table.setColumnStretchable(4, true)
                binding.table.setColumnStretchable(5, true)
                for (item in sorsolas_lista){
                    var tr = TableRow(this)
                    tr.layoutParams = LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT)
                    tr.weightSum = 6f
                    txtView = TextView(this)
                    txtView.layoutParams = TableRow.LayoutParams(0,TableRow.LayoutParams.WRAP_CONTENT, 1f)
                    txtView2 = TextView(this)
                    txtView2.layoutParams = TableRow.LayoutParams(0,TableRow.LayoutParams.WRAP_CONTENT, 1f)
                    txtView3 = TextView(this)
                    txtView3.layoutParams = TableRow.LayoutParams(0,TableRow.LayoutParams.WRAP_CONTENT, 1f)
                    txtView4 = TextView(this)
                    txtView4.layoutParams = TableRow.LayoutParams(0,TableRow.LayoutParams.WRAP_CONTENT, 1f)
                    txtView5 = TextView(this)
                    txtView5.layoutParams = TableRow.LayoutParams(0,TableRow.LayoutParams.WRAP_CONTENT, 1f)
                    txtView6 = TextView(this)
                    txtView6.layoutParams = TableRow.LayoutParams(0,TableRow.LayoutParams.WRAP_CONTENT, 1f)

                    txtView.text =" "+ item.week.toString()
                    println("Hét: "+item.week.toString())
                    tr.addView(txtView)
                    txtView2.text = item.num1.toString()
                    tr.addView(txtView2)
                    txtView3.text = item.num2.toString()
                    tr.addView(txtView3)
                    txtView4.text = item.num3.toString()
                    tr.addView(txtView4)
                    txtView5.text = item.num4.toString()
                    tr.addView(txtView5)
                    txtView6.text = item.num5.toString()
                    tr.addView(txtView6)

                    binding.table.addView(tr)
                    binding.table.setColumnStretchable(0, true)
                    binding.table.setColumnStretchable(1, true)
                    binding.table.setColumnStretchable(2, true)
                    binding.table.setColumnStretchable(3, true)
                    binding.table.setColumnStretchable(4, true)
                    binding.table.setColumnStretchable(5, true)
                }

            }
        }

    }
}