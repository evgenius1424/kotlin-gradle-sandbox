package com.github.evgenius1424

import org.koin.dsl.module

val applicationModule = module {
    single<Company> { SmartCompany() }
}
