package io.github.evgenius1424.kotlingradle.service

import io.github.evgenius1424.kotlingradle.Issue
import io.github.evgenius1424.kotlingradle.IssueStatus
import io.github.evgenius1424.kotlingradle.repository.IssuesRepository
import kotlinx.datetime.Clock
import java.util.UUID

class InMemoryIssuesService(private val issuesRepository: IssuesRepository) : IssuesService {
    init {
        // Add some initial issues for demonstration
        val now = Clock.System.now()
        createIssue("Setup project", "Initial project setup and configuration", "system")
        createIssue("Add authentication", "Implement user authentication system", "admin")
        createIssue("Database integration", "Add database connectivity and migrations", "developer")
    }

    override fun getAllIssues(): List<Issue> {
        return issuesRepository.findAll()
    }

    override fun getIssueById(id: UUID): Issue? {
        return issuesRepository.findById(id)
    }

    override fun createIssue(
        name: String,
        description: String,
        createdBy: String,
    ): Issue {
        val now = Clock.System.now()
        val issue =
            Issue(
                id = UUID.randomUUID(),
                name = name,
                description = description,
                status = IssueStatus.OPEN,
                createdAt = now,
                updatedAt = now,
                deletedAt = null,
                createdBy = createdBy,
            )
        return issuesRepository.save(issue)
    }

    override fun updateIssue(
        id: UUID,
        name: String?,
        description: String?,
        status: IssueStatus?,
    ): Issue? {
        val existingIssue = issuesRepository.findById(id) ?: return null

        val updatedIssue =
            existingIssue.copy(
                name = name ?: existingIssue.name,
                description = description ?: existingIssue.description,
                status = status ?: existingIssue.status,
                updatedAt = Clock.System.now(),
            )

        return issuesRepository.update(updatedIssue)
    }

    override fun deleteIssue(id: UUID): Boolean {
        return issuesRepository.deleteById(id)
    }

    override fun getIssueCount(): Int {
        return issuesRepository.findAll().size
    }
}
