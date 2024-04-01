package com.example.di_recyclerview.di.module

import com.example.di_recyclerview.data.repository.MainRepository
import org.koin.dsl.module

val repoModule = module {
    single {
        MainRepository(get())
    }
}