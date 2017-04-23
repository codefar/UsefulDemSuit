package com.meituan.davy.myapplication.dagger.part4_scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

//@Scope 限定作用域 @Single 本生就是一个@Scope的注解

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface CarScope {
}