package de.davidriad.digibee.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat

import androidx.recyclerview.widget.RecyclerView
import de.davidriad.digibee.R
import de.davidriad.digibee.model.BeeHive


class BeeHiveAdapter(
    private val beehives: List<BeeHive>,
    private val context: Context
) : RecyclerView.Adapter<BeeHiveAdapter.BeehiveViewHolder>() {
    var activitiesCounter = 0

    inner class BeehiveViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val name = view.findViewById<TextView>(R.id.name)
        private val condition = view.findViewById<TextView>(R.id.condition)
        private val temperature = view.findViewById<TextView>(R.id.temprature)
        private val humidity = view.findViewById<TextView>(R.id.humidity)

        fun bind(beehive: BeeHive) {

            name.text = beehive.name
            condition.text = beehive.condition
            temperature.text = beehive.temperature.toString() + " °C"
            humidity.text = beehive.humidity.toString() + " %"

            var goodcolor = ContextCompat.getColor(context, R.color.goodColor)

            if (beehive.condition.equals("Good"))
                condition.setTextColor(goodcolor)

            if (beehive.temperature < 24)
                temperature.setTextColor(goodcolor)

            if (beehive.humidity < 50)
                humidity.setTextColor(goodcolor)


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeehiveViewHolder {
        val inflater = LayoutInflater.from(parent!!.getContext())
        val view = inflater.inflate(R.layout.item_beehive, parent, false)

        return BeehiveViewHolder(view).listen { pos, type ->
            var activity = beehives[pos]
//            activity.isFollow = !activity.isFollow
//            Toast.makeText(context, activity.name, Toast.LENGTH_SHORT).show()
//            var intent = Intent(parent.context, ActivityDetails::class.java)
//            intent.putExtra("activity", activity)
//            parent.context.startActivity(intent)
//            notifyDataSetChanged()
        }

    }

    override fun getItemCount(): Int {
        return beehives.size
    }

    override fun onBindViewHolder(holder: BeehiveViewHolder, position: Int) {
        holder.bind(beehives[position])

    }

    private fun <T : RecyclerView.ViewHolder> T.listen(event: (position: Int, type: Int) -> Unit): T {
        itemView.setOnClickListener {
            event.invoke(adapterPosition, itemViewType)
        }
        return this
    }

}