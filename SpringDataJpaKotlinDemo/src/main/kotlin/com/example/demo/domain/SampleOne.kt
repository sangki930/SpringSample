package com.example.demo.domain

import jakarta.persistence.*

@Entity
class SampleOne {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    var name: String? = null

}