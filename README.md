# JGA (Java Greev API)

JGA provides a full Java Wrapper for the public [Greev API](https://api.greev.eu/v2/swagger-ui/index.html#/).
This project provides a central API with easy to use data objects.

## Summary

1. [Introduction](#introduction)
2. [How to use](#how-to-use)
3. [Getting help](#getting-help)
4. [Contributing](#contributing)

## Introduction
Creating an JGA instance is done, by initializing the API with `JGAInitializer.init();` and then getting it with `JGAInitializer.getJGA();`.
With that `JGA` object you now can access all possible calls on the Greev API.

**<u>Note:</u>** The Greev API consists as well of some deprecated possible statements, those are as of April 2024 not implemented.
If any endpoint contained in this API becomes deprecated in the future, I will update the project properly and mark the statement as `@Deprecated`. 

## How to use

Latest release: [GitHub Release](https://github.com/JJJannik/JGA/releases)

Be sure to replace the **VERSION** key below with the one of the GitHub release versions!

#### Maven
```xml
<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>

<dependency>
    <groupId>com.github.JJJannik</groupId>
    <artifactId>JGA</artifactId>
    <version>VERSION</version>
</dependency>
```

#### Gradle kts
```kotlin
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation("com.github.JJJannik:JGA:VERSION")
}
```

#### Manual installation

For projects not using any build tools, download a pre-compiled JAR-file `JGA-VERSION.jar` from the [releases page]().

If you want, you can also download the JavaDocs `JGA-VERSION-javadoc.jar` or the sources `JGA-VERSION-sources.jar`.

After downloading those JARs, just add the main JAR to your project's classpath and optionally attach sources or JavaDocs.

#### Building from source

To install the library from source first of all clone the repository:

`git clone https://github.com/JJJannik/JGA.git`

Finally, build the library with Gradle in the project terminal:

`./gradle shadowJar`

The built Jar will appear in `/build/libs/JGA-VERSION.jar`

Now you can continue with the [manual installation](#manual-installation)

## Getting help

Before trying to contact me, please overthink if the problem can be solved by reading the Docs written in this project.. they may help.

If you experience an issue, feel free to contact me via my Discord `jjjannik` or just write a detailed issue in this repository.

## Contributing

I never wrote such type of API, so feel free to give me some feedback, improvement possibilities or even contribute with a pull requests.

To contribute to the project, please fork this repository, commit your changes there and then create a pull request to be reviewed.