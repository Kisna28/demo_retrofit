## 🔁 Switching Retrofit to OkHttp (Manual API Call)

### ✅ Add OkHttp dependency
```gradle
implementation ("com.squareup.okhttp3:okhttp:5.1.0")

val client = OkHttpClient()
val request = Request.Builder()
    .url("https://dummyjson.com/users")
    .build()

client.newCall(request).enqueue(object : Callback {
    override fun onFailure(call: Call, e: IOException) {
        e.printStackTrace()
    }

    override fun onResponse(call: Call, response: Response) {
        val json = response.body?.string()
        val gson = Gson()
        val userResponse = gson.fromJson(json, UserResponse::class.java)

        runOnUiThread {
            recyclerView.adapter = UserAdapter(userResponse.users)
        }
    }
})

## 🔁 Switching Picasso to Glide for Image Loading

### ✅ Add Glide dependency
```gradle
implementation ("com.github.bumptech.glide:glide:4.16.0")
kapt ("com.github.bumptech.glide:compiler:4.16.0")

Adapter -> Glide.with(holder.binding.userImage.context)
    .load(user.image)
    .into(holder.binding.userImage)


