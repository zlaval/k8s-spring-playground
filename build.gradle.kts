import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

//buildscript {
//    dependencies {
//        classpath("com.google.cloud.tools:jib-layer-filter-extension-gradle:0.1.0")
//    }
//}

plugins {
    id("org.springframework.boot") version "2.6.0"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("com.google.cloud.tools.jib") version "3.1.4"
    kotlin("jvm") version "1.6.0"
    kotlin("plugin.spring") version "1.6.0"
    kotlin("plugin.jpa") version "1.6.0"
}

group = "com.zlrx"
version = "1.3.2"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.cloud:spring-cloud-starter-kubernetes-client:2.1.0")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    // implementation("org.liquibase:liquibase-core")
    runtimeOnly("org.postgresql:postgresql")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

jib {
    from {
        image = "openjdk:17.0.1-slim"
    }
    to {
        image = "zalerix/k8smscasestudy"
        tags = setOf("latest", "${project.version}")
        auth {
            username = System.getenv("DOCKER_USER")
            password = System.getenv("DOCKER_PASSWORD")
        }
    }
    container {
        mainClass = "com.zlrx.k8smscasestudy.K8sMsCaseStudyApplicationKt"
        ports = listOf("8080/tcp", "9000/tcp")
        appRoot = "/app"
        workingDirectory = "/app"
        creationTime = "USE_CURRENT_TIMESTAMP"
        environment = mapOf("JAVA_TOOL_OPTIONS" to "-agentlib:jdwp=transport=dt_socket,address=5005,server=y,suspend=n")
    }
//    pluginExtensions {
//        pluginExtension {
//            implementation = "com.google.cloud.tools.jib.gradle.extension.layerfilter.JibLayerFilterExtension"
//            configuration(Action<com.google.cloud.tools.jib.gradle.extension.layerfilter.Configuration> {
//                filters {
//                    filter {
//                        glob = "**/*.jar"
//                        toLayer = "libraries"
//                    }
//                }
//            })
//        }
//    }

}
