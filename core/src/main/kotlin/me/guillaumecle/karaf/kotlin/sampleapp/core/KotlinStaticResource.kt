package me.guillaumecle.karaf.kotlin.sampleapp.core

import org.osgi.service.component.annotations.Component

@Component(
        service = [KotlinStaticResource::class],
        name = "KotlinStaticResource",
        property = [
            "osgi.http.whiteboard.resource.pattern=/example/*",
            "osgi.http.whiteboard.resource.prefix=/resources"
        ]
)
class KotlinStaticResource