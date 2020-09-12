package com.mirai.penny.crc


import org.jsoup.Jsoup


class Bilibili {
    /**
     * 获取哔哩哔哩视频标题
     * @param: BV
     * @return: Title
     */
    fun get_title(bv: String): String {
        try {
            val url: String = "https://www.bilibili.com/video/$bv"
            var resp = Jsoup.connect(url).ignoreContentType(true).execute().body().toString()
            var title = Jsoup.parse(resp).select("h1").text().toString()
            return title
        } catch (e: Exception) {
            return "视频地址错误"
        }
    }
}