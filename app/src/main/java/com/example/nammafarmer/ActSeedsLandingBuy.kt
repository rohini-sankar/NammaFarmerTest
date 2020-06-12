package com.example.nammafarmer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_act_seeds_landing_buy.*

class ActSeedsLandingBuy : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act_seeds_landing_buy)

        //var seedsBuyList = readSeedsDB()
        //val seedsBuyList = generateDummyList(500)

        recycler_view.adapter = BuySeedsAdapter(readSeedsDB())
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)
    }

    override fun onStart() {
        super.onStart()
        recycler_view.layoutManager = LinearLayoutManager(this)
    }

    private fun readSeedsDB() : List<BuySeeds> {

        val list = ArrayList<BuySeeds>()

        var database = FirebaseDatabase.getInstance().getReference("Seeds")

        var getdata = object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                //None
            }

            override fun onDataChange(p0: DataSnapshot) {
                for (i in p0.children) {
                    val tmpBuySeeds = BuySeeds(
                        i.child("name").getValue().toString(),
                        i.child("phone").getValue().toString(),
                        i.child("email").getValue().toString()
/*                        i.child("Rice").getValue() as Boolean,
                        i.child("Onion").getValue() as Boolean,
                        i.child("Tomato").getValue() as Boolean,
                        i.child("Bendi").getValue() as Boolean,
                        i.child("Brinjal").getValue() as Boolean,
                        i.child("Pumpkin").getValue() as Boolean,
                        i.child("Wheat").getValue() as Boolean,
                        i.child("Karela").getValue() as Boolean,
                        i.child("Beans").getValue() as Boolean,
                        i.child("Carrot").getValue() as Boolean,
                        i.child("Squash").getValue() as Boolean,
                        i.child("Radish").getValue() as Boolean,
                        i.child("Millets").getValue() as Boolean,
                        i.child("Chilli").getValue() as Boolean,
                        i.child("Ginger").getValue() as Boolean,
                        i.child("Garlic").getValue() as Boolean,
                        i.child("Spices").getValue() as Boolean,
                        i.child("Others").getValue() as Boolean*/
                        )
                    //val item = ExampleItem("Name", "Phone", "eMail")

                    list.plusAssign(tmpBuySeeds)
                }
            }
        }

        database.addValueEventListener(getdata)
        //database.addListenerForSingleValueEvent(getdata)

        return list
    }


/*    private fun generateDummyList(size: Int): List<BuySeeds> {
        val list = ArrayList<BuySeeds>()
        for (i in 0 until size) {
            val item = BuySeeds("Name $i", "Phone $i", "eMail $i")
            list += item
        }
        return list
    }
*/

}


 /*
    lateinit var adapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>
    lateinit var layoutManager : RecyclerView.LayoutManager

    val arrayBuySeedsName : Array<String> = arrayOf()
    val arrayBuySeedsPhone : Array<String> = arrayOf()
    val arrayBuySeedsEMail : Array<String> = arrayOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act_seeds_landing_buy)

        var database = FirebaseDatabase.getInstance().getReference("Seeds")

        var getdata = object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                //None
            }

            override fun onDataChange(p0: DataSnapshot) {
                var j = 0
                for (i in p0.children) {
                    arrayBuySeedsName[j] = i.child("name").getValue().toString()
                    arrayBuySeedsPhone[j] = i.child("name").getValue().toString()
                    arrayBuySeedsEMail[j] = i.child("name").getValue().toString()
                    j += 1
                }
            }
        }

        database.addValueEventListener(getdata)
        database.addListenerForSingleValueEvent(getdata)

        layoutManager = LinearLayoutManager(this)
        list_view.layoutManager = layoutManager

        adapter = RecyclerAdapter()
        list_view.adapter = adapter

/*        val farmDB = getSharedPreferences("farmDB", Context.MODE_PRIVATE)

//        textView.text = farmDB.getString("dbName", "None")
//        textView2.text = farmDB.getString("dbPhone", "None")
//        textView3.text = farmDB.getString("dbEMail", "None")

  //      checkBox.isChecked = farmDB.getBoolean("dbRice", false)
    //    checkBox2.isChecked = farmDB.getBoolean("dbOnion", false)
*/
    }
}
*/