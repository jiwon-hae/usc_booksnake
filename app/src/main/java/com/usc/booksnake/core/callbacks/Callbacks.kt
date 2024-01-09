package com.usc.booksnake.core.callbacks


typealias VoidCallback = () -> Unit

typealias ValueCallback<I, O> = (input : I) -> O