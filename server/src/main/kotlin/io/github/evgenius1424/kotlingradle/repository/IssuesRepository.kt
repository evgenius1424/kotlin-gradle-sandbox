package io.github.evgenius1424.kotlingradle.repository

import io.github.evgenius1424.kotlingradle.Issue
import java.util.UUID

interface IssuesRepository {
    fun findAll(): List<Issue>

    fun findById(id: UUID): Issue?

    fun save(issue: Issue): Issue

    fun deleteById(id: UUID): Boolean

    fun update(issue: Issue): Issue?
}
