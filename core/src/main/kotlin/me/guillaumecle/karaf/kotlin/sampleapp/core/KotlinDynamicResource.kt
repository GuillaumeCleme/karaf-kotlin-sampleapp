package me.guillaumecle.karaf.kotlin.sampleapp.core

import org.osgi.service.component.annotations.Component
import java.io.IOException
import java.io.PrintWriter
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
            writer.println("<html>")
            writer.println("<head>")
            writer.println("<title>Kotlin Dynamic Resource Example</title>")
            writer.println("</head>")
            writer.println("<body>")
            writer.println("<h2>Kotlin Dynamic Resource Example</h2>")
            writer.println("</body>")
            writer.println("</html>")
        }
    }
}