import org.osgi.service.component.annotations.Component

@Component(service = [KotlinResource::class],
        property = ["osgi.http.whiteboard.resource.pattern=/example/*",
            "osgi.http.whiteboard.resource.prefix=/resources"])
class KotlinResource