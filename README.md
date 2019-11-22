# Kotlin-Based Apache Karaf HTTP Resource Example
A simple web application built using Kotlin, running on Apache Karaf

## Abstract

Apache Karaf supports HTTP resources artifact. It's very simple bundle that just register an empty resource service.

The actual resources (images, static HTML pages, ...) are in a folder in the bundle.
The resource service properties configures the location of the resource and the HTTP context (pattern or HTTP location) where to expose these resources.

## Artifacts

* **karaf-kotlin-sampleapp-core** is a HTTP resource bundle that use an empty resource service (using SCR) to be taken by the Karaf HTTP service whiteboard.
* **karaf-kotlin-sampleapp-features** is a features repository used for the deployment.

## Build

The build uses Apache Maven. Simply use:

```
mvn clean install
```

## Features and Deployment

On a running Karaf instance, register the features repository:

```
karaf@root()> feature:repo-add mvn:me.guillaumecle.karaf/karaf-kotlin-sampleapp-features/LATEST/xml
```

Then, you can install the `karaf-kotlin-sampleapp-core` feature:

```
karaf@root()> feature:install karaf-kotlin-sampleapp-core
```

## Usage

The `karaf-kotlin-sampleapp-core` registers HTTP resource pattern.

You can see it using `http:list` command:

```
karaf@root()> http:list
ID │ Servlet         │ Servlet-Name          │ State       │ Alias      │ Url
───┼─────────────────┼───────────────────────┼─────────────┼────────────┼─────────────
54 │ ResourceServlet │ /example/*:/resources │ Deployed    │ /example/* │ [/example/*]
```

You can access the resources using your browser on http://localhost:8181/example/index.html URL.
