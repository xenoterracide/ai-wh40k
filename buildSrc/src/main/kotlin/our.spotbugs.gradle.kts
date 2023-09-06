import com.github.spotbugs.snom.Confidence
import com.github.spotbugs.snom.Effort
import com.github.spotbugs.snom.SpotBugsTask

plugins {
    `java-base`
    id("com.github.spotbugs")
}

spotbugs {
    excludeFilter.set(rootProject.file("spotbugs/exclude.xml"))
    effort.set(Effort.MAX)
    reportLevel.set(Confidence.LOW)
}

tasks.withType<SpotBugsTask>().configureEach {
    reports.register("html") {
        enabled = true
    }
}

dependencies {
    spotbugs("com.github.spotbugs:spotbugs:4.+")
}
