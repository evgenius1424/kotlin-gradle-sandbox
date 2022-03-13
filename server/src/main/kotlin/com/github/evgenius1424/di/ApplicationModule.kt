package com.github.evgenius1424.di

import com.github.evgenius1424.Company
import com.github.evgenius1424.SmartCompany
import org.koin.dsl.module

val applicationModule = module {
    single<Company> { SmartCompany() }
}