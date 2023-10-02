package com.tc.virginmoney.ui.profile

import android.graphics.Color
import android.os.Bundle
import android.text.util.Linkify
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.tc.virginmoney.R
import java.text.SimpleDateFormat
import java.util.Locale

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Retrieve data passed from the RecyclerView's item click
        val profileName = intent.getStringExtra("profileName")
        val profileImage = intent.getStringExtra("profileImage")
        val profileJob = intent.getStringExtra("profileJob")
        val profileEmail = intent.getStringExtra("profileEmail")
        val dateJoined = intent.getStringExtra("dateJoined")
        val favoriteColor = intent.getStringExtra("favoriteColor")

        // Display the data in the UI elements
        val nameTextView = findViewById<TextView>(R.id.profileName)
        val emailTextView = findViewById<TextView>(R.id.profileEmail)
        val jobTextView = findViewById<TextView>(R.id.profileJob)
        val dateTextView = findViewById<TextView>(R.id.dateJoined)
        val profileImageView = findViewById<ImageView>(R.id.profilePicture)
        val backgroundColor = findViewById<ConstraintLayout>(R.id.background)

        Glide.with(this)
            .load(profileImage)
            .error(R.drawable.ic_error)
            .placeholder(R.drawable.ic_error)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(profileImageView)

        nameTextView.text = profileName
        emailTextView.text = profileEmail
        jobTextView.text = profileJob
        dateTextView.text = dateJoined?.let { formatDate(it) }
        favoriteColor?.let { getFavoriteColor(it) }?.let { backgroundColor.setBackgroundColor(it) }

        // Allow emails to be interactable
        Linkify.addLinks(emailTextView, Linkify.EMAIL_ADDRESSES)

        // Adds functionality to button
        val backButton = findViewById<Button>(R.id.backButton)
        backButton.setOnClickListener {
            finish()
        }
    }

    private fun getFavoriteColor(stringColor: String) : Int {
        val intColor = when(stringColor) {
            "pink" -> Color.parseColor("#45FFC0CB")
            "sky blue" -> Color.parseColor("#4596FCFF")
            "cyan" -> Color.parseColor("#4500FFFF")
            "indigo" -> Color.parseColor("#454B0082")
            "orchid" -> Color.parseColor("#45DA70D6")
            "lavender" -> Color.parseColor("#45967BB6")
            "blue" -> Color.parseColor("#450000FF")
            "olive" -> Color.parseColor("#45808000")
            "red" -> Color.parseColor("#45FF0000")
            "plum" -> Color.parseColor("#45673147")
            "violet" -> Color.parseColor("#457F00FF")
            "fuchsia" -> Color.parseColor("#45FF00FF")
            "azure" -> Color.parseColor("#45007FFF")
            "teal" -> Color.parseColor("#45008080")
            "silver" -> Color.parseColor("#45C0C0C0")
            "black" -> Color.parseColor("#45000000")
            "magenta" -> Color.parseColor("#45FF1DCE")
            "tan" -> Color.parseColor("#45D2B48C")
            "salmon" -> Color.parseColor("#45FA8072")
            "grey" -> Color.parseColor("#45808080")
            "green" -> Color.parseColor("#45008000")
            "mint green" -> Color.parseColor("#4598FB98")
            "orange" -> Color.parseColor("#45FFA500")
            "white" -> Color.parseColor("#45FFFFFF")
            "lime" -> Color.parseColor("#4532CD32")
            "gold" -> Color.parseColor("#45FFD700")
            "ivory" -> Color.parseColor("#45FFFFF0")
            "turquoise" -> Color.parseColor("#4540E0D0")
            "purple" -> Color.parseColor("#45800080")
            "yellow" -> Color.parseColor("#45FFFF00")
            "maroon" -> Color.parseColor("#45800000")
            // Add more color cases as needed
            else -> Color.WHITE
        }
        return intColor
    }

    private fun formatDate(dateString: String): String {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US)
        val outputFormat = SimpleDateFormat("MM/dd/yyyy", Locale.US)

        val date = inputFormat.parse(dateString)
        return "Date Joined: ${outputFormat.format(date)}"
    }
}




