package com.gs.eventsdemo.utils

import android.util.Log
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

const val TAG ="DateAndTimeHelper"

fun String.formatDate():String{
    var replace = this.replace("T", " ")
    replace = replace.replace("Z","")

    val isSameDayFormat = SimpleDateFormat("dd-MM-yyyy")
    val formatFromObject = SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS")
        try {
            val d: Date = formatFromObject.parse(replace)
            val eventTimeAsMillis: Long = d.getTime()

            val currentDate = System.currentTimeMillis()
            val formatCurrentTime = isSameDayFormat.format(currentDate)

            val formatEventTime =isSameDayFormat.format(eventTimeAsMillis)
            if (formatCurrentTime == formatEventTime){
                //The same day
                val simpleDateFormatForCurrentDay = SimpleDateFormat("hh:mm")
                val format = simpleDateFormatForCurrentDay.format(eventTimeAsMillis)
                return "Today, $format"
            }else if (formatCurrentTime.substring(2,9) == formatEventTime.substring(2,9)){
                //Can be Yesterday
                val currentDay = formatCurrentTime.substring(0, 2).toInt()
                val eventDay = formatEventTime.substring(0, 2).toInt()
                if (currentDay - eventDay == 1){
                    //Yesterday
                    val simpleDateFormatForYesterday = SimpleDateFormat("hh:mm")
                    val format = simpleDateFormatForYesterday.format(eventTimeAsMillis)
                    return "Yesterday, $format "
                }else {
                    return formatEventTime
                }
            }else {
                return formatEventTime
            }

        } catch (e: ParseException) {
            Log.e(TAG, "formatDate: Exception ${e.message}, ${e.stackTraceToString()}", )
            return ""
        }
    }