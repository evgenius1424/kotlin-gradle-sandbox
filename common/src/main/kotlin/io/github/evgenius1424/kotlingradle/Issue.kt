package io.github.evgenius1424.kotlingradle

import kotlinx.datetime.Instant
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class Issue(
    @Contextual val id: UUID,
    val name: String,
    val description: String,
    val status: IssueStatus,
    val createdAt: Instant,
    val updatedAt: Instant,
    val deletedAt: Instant? = null,
    val createdBy: String,
)

@Serializable
enum class IssueStatus {
    OPEN,
    IN_PROGRESS,
    RESOLVED,
    CLOSED,
}
