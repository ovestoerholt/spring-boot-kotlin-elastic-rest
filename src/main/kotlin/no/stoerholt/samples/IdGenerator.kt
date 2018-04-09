package no.stoerholt.samples

import java.util.UUID

/**
 * Generate a random id for use with entities. It has to be uppercase, as that is what is returned from SQL server.
 */
fun generateId() = UUID.randomUUID().toString().toUpperCase()