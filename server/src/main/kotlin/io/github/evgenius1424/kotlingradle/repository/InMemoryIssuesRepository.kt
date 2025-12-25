package io.github.evgenius1424.kotlingradle.repository

import io.github.evgenius1424.kotlingradle.Issue
import kotlinx.datetime.Clock
import java.util.UUID
import java.util.concurrent.ConcurrentHashMap

class InMemoryIssuesRepository : IssuesRepository {
    private val issues = ConcurrentHashMap<UUID, Issue>()

    override fun findAll(): List<Issue> {
        return issues.values.filter { it.deletedAt == null }
    }

    override fun findById(id: UUID): Issue? {
        return issues[id]?.takeIf { it.deletedAt == null }
    }

    override fun save(issue: Issue): Issue {
        issues[issue.id] = issue
        return issue
    }

    override fun deleteById(id: UUID): Boolean {
        val issue = issues[id] ?: return false
        val deletedIssue = issue.copy(deletedAt = Clock.System.now())
        issues[id] = deletedIssue
        return true
    }

    override fun update(issue: Issue): Issue? {
        val existingIssue = issues[issue.id]
        return if (existingIssue != null && existingIssue.deletedAt == null) {
            val updatedIssue = issue.copy(updatedAt = Clock.System.now())
            issues[issue.id] = updatedIssue
            updatedIssue
        } else {
            null
        }
    }
}
