package me.guillaumecle.karaf.kotlin.sampleapp.core

import kotlinx.html.*
import kotlinx.html.stream.appendHTML
import org.osgi.service.component.annotations.Component
import java.io.IOException
import java.io.PrintWriter
import java.util.*
import javax.servlet.Servlet
import javax.servlet.ServletException
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@Component(
        name = "KotlinDynamicResource",
        property = [
            "alias=/example/dynamic",
            "servlet-name=KotlinDynamicResource"
        ]
)
class KotlinDynamicResource : HttpServlet(), Servlet {

    @Throws(ServletException::class, IOException::class)
    public override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        response.writer.use { writer: PrintWriter ->
            writer.appendHTML().html{
                head{
                    title("Kotlin Dynamic Resource Example")
                }
                body {
                    h2{
                        +"Kotlin Dynamic Resource Example"
                    }
                    script("application/javascript", "./kotlin.js"){}
                    script("application/javascript", "./karaf-kotlin-sampleapp-frontend.js"){}
                }
            }.flush()
        }
    }
}

@Component(
        name = "KotlinSystemServlet",
        property = [
            "alias=/example/system",
            "servlet-name=SystemServlet"
        ]
)
class KotlinSystemServlet : HttpServlet(), Servlet {

    @Throws(ServletException::class, IOException::class)
    public override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {

        if(request.getParameter("operation")!! == "getServerDate"){
            response.writer.use { writer: PrintWriter ->
                writer.print(Date().toString())
            }
        }
    }
}