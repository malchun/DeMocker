package org.zmalchunz.configurer.backend.resources

import org.springframework.web.bind.annotation.*
import org.zmalchunz.configurer.backend.model.Template
import org.zmalchunz.configurer.backend.repositories.TemplateRepository

@RestController
@RequestMapping("/template")
class TemplateResource(val templateRepository: TemplateRepository) {

    @GetMapping
    fun get(): List<Template> = templateRepository.findTemplates()

    @PostMapping
    fun post(@RequestBody template: Template): String {
        return templateRepository.saveTemplate(template)
    }
}