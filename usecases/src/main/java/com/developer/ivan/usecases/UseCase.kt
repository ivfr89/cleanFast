package com.developer.ivan.usecases

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


abstract class UseCase<Param, Return>
{
    abstract suspend fun body(param: Param): Return

    suspend fun execute(param: Param): Return = withContext(Dispatchers.IO){body(param)}
}