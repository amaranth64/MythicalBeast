package ru.openbiz64.mythicalbeast.model

import android.content.Context
import android.widget.Toast
import org.json.JSONArray
import ru.openbiz64.mythicalbeast.dataclass.BeastDataClass
import java.io.IOException
import java.io.InputStream

object DataJsonLoader {

    fun getData(fileName:String, context: Context): ArrayList<BeastDataClass>{

        val list: ArrayList<BeastDataClass> = arrayListOf()

        if (fileName.isEmpty()) return list

        val jsonArray = JSONArray(getJsonText("$fileName.json", context))

        for (i in 0 until jsonArray.length()) {
            val obj = jsonArray.getJSONObject(i)

            val id = obj.getInt("Id")
            val picUrl = obj.getString("picUrl")
            val title = obj.getString("Title")
            val htmlUrl = obj.getString("htmlUrl")
            val mythology = obj.getString("mythology")

            val data = BeastDataClass(
                id,
                picUrl,
                title,
                htmlUrl,
                mythology
            )

            list.add(data)
        }

        return list
    }

    private fun getJsonText(file:String, context: Context):String{
        var jsonFileData = "[]"
        try {
            val inputStream: InputStream = context.assets.open(file)
            val size:Int = inputStream.available()
            val bytesArray = ByteArray(size)
            inputStream.read(bytesArray)
            jsonFileData = String(bytesArray)
        } catch (e: IOException){
            Toast.makeText(context,"Ошибка базы данных", Toast.LENGTH_LONG).show()
        }
        return jsonFileData
    }

}