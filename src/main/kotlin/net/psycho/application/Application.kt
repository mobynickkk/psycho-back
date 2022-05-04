package net.psycho.application

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication(scanBasePackages = ["net.psycho.core"])
@EnableJpaRepositories("net.psycho.core.domain.repositories")
@EntityScan("net.psycho.core.domain.entities")
open class Application


fun main(args: Array<String>) {
    runApplication<Application>(*args)
}
