package com.ramm.pruebacuscatlan.framework.common

interface DomainMapper<T : Any> {
    fun mapToDomainModel(): T
}