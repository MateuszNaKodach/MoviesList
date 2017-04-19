package pl.edu.pwr.mateusznowak.lab1.swim_lab2.helpers

import android.app.Activity
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AlertDialog

/**
 * Created by Mateusz on 17.04.2017.
 */
object PermissionsHelper {

    fun requestPermission(activity: Activity, titleId: Int, messageId: Int, permissions: Array<String>, permissionCode: Int) {
        val alertDialogBuilder = AlertDialog.Builder(activity)
        alertDialogBuilder.setTitle(titleId)
        alertDialogBuilder.setMessage(messageId)
        alertDialogBuilder.setOnDismissListener {
            ActivityCompat.requestPermissions(
                    activity,
                    permissions,
                    permissionCode)
        }
        alertDialogBuilder.show()
    }
}