package io.github.evgenius1424.kotlingradle.service

import io.github.evgenius1424.kotlingradle.Issue
import io.github.evgenius1424.kotlingradle.IssueStatus
import java.util.UUID

interface IssuesService {
    fun getAllIssues(): List<Issue>

    fun getIssueById(id: UUID): Issue?

    fun createIssue(
        name: String,
        description: String,
        createdBy: String,
    ): Issue

    fun updateIssue(
        id: UUID,
        name: String?,
        description: String?,
        status: IssueStatus?,
    ): Issue?

    fun deleteIssue(id: UUID): Boolean

    fun getIssueCount(): Int
}
