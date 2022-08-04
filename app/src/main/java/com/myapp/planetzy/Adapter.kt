package com.myapp.planetzy

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view_item.view.*
import java.util.*

class Adapter(var planet: List<PlanetData>) : RecyclerView.Adapter<Adapter.MyViewHolder>()
{
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var title= itemView.title_view
        var planetimg= itemView.planet_img
        var galaxy= itemView.galaxy_view
        var distance = itemView.distance_view
        var gravity= itemView.gravity_view


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder
    {
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int)
    {
        var dummyImg:Int? = null
        holder.itemView.setOnClickListener{
            val intent= Intent(holder.itemView.context,PlanetDetail::class.java)
            intent.putExtra("planet",planet[position])
            intent.putExtra("planetImage",dummyImg)
            holder.itemView.context.startActivity(intent)

        }
        holder.title.text = planet[position].title
        holder.galaxy.text = planet[position].galaxy
        holder.gravity.text = planet[position].gravity+" m/s^2"
        holder.distance.text = planet[position].distance+" mill. Km"

        when(planet[position].title!!.toLowerCase(Locale.ROOT))
        {
            "sun"->{
                dummyImg = R.drawable.ic_sun
            }
            "mercury"->{
                dummyImg = R.drawable.ic_mercury
            }
            "venus"->{
                dummyImg = R.drawable.ic_venus
            }
            "earth"->{
                dummyImg = R.drawable.ic_earth
            }
            "moon"->{
                dummyImg = R.drawable.ic_moon
            }
            "mars"->{
                dummyImg = R.drawable.ic_mars
            }
            "jupiter"->{
                dummyImg = R.drawable.ic_jupiter
            }

            "uranus"->{
                dummyImg = R.drawable.ic_uranus
            }
            "saturn"->{
                dummyImg = R.drawable.ic_saturn
            }
            "neptune"->{
                dummyImg = R.drawable.ic_neptune
            }


        }

        if (dummyImg != null) {
            holder.planetimg.setImageResource(dummyImg)
        }



    }

    override fun getItemCount(): Int
    {
        return planet.size
    }
}
