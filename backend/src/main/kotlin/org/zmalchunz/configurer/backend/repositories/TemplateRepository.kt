package org.zmalchunz.configurer.backend.repositories

import org.springframework.stereotype.Service
import org.zmalchunz.configurer.backend.model.Template

@Service
class TemplateRepository {

    val repository: MutableList<Template> = ArrayList()

    fun findTemplates(): List<Template> = repository

    fun saveTemplate(template: Template): String {
        repository.add(template)
        return template.id
    }
}
