package com.mirai.penny.crc


import net.mamoe.mirai.Bot
import net.mamoe.mirai.alsoLogin
import net.mamoe.mirai.event.subscribeMessages
import net.mamoe.mirai.join


suspend fun main() {
    try {
        println("请输入账号：")
        val qq = readLine()!!.toLong()
        println("请输入密码：")
        val passwd = readLine()!!.toString()
        val bot = Bot(
                qq = qq,
                password = passwd
        ) {
            fileBasedDeviceInfo("device.json")
        }.alsoLogin()

        bot.messageDSL()

        bot.join()
    } catch (e: Exception) {
        println("账号或密码错误")
    }
}

fun Bot.messageDSL() {

    this.subscribeMessages {
        Regex("BV.*") matchingReply {
            Bilibili().get_title(message.contentToString())   //获取哔哩哔哩视频标题
            //recallIn(6000)
        }
    }

}