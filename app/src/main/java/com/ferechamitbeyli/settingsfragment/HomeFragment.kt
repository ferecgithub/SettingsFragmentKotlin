package com.ferechamitbeyli.settingsfragment

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.findNavController
import androidx.preference.PreferenceManager
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        fab_settings.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_settingsFragment)
        }

        loadSettings()
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun loadSettings() {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

        val signature = sharedPreferences.getString("signature", "")
        val reply = sharedPreferences.getString("reply", "")
        val sync = sharedPreferences.getBoolean("sync", true)
        val notifications = sharedPreferences.getBoolean("notifications", false)
        val volume = sharedPreferences.getInt("volume_notifications", 50)

        signature_tv.text = "Signature: $signature"
        reply_tv.text = "Reply: $reply"
        sync_tv.text = "Sync: $sync"
        notifications_tv.text = "Notifications: $notifications"
        volume_pb.setProgress(volume, true)
    }
}