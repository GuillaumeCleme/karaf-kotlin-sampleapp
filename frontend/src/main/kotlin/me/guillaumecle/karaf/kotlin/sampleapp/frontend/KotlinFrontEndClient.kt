package me.guillaumecle.karaf.kotlin.sampleapp.frontend

import org.w3c.dom.events.Event
import org.w3c.xhr.XMLHttpRequest

fun main(args:Array<String>) {
    console.info("Hello from Kotlin JS")
}

fun getServerDate(){
    var xmlHttpRequest = XMLHttpRequest()

    xmlHttpRequest.open("GET", "/system?operation=getServerDate")
    xmlHttpRequest.onreadystatechange = fun (_: Event){
        console.info(xmlHttpRequest.responseText)
    }
}