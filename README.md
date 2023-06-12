# Spring Kotlin Reactive Demo

SpringBoot 的一个小 demo

相关技术：

- Kotlin
- SpringBoot 3.0
- Spring Webflux
- Spring Data R2DBC

其他：使用 docker 快速启动一个运行完就销毁的 Postgresql 数据库

```shell
docker run --rm --name pgsql -e POSTGRES_PASSWORD=postgres -p 5432:5432 postgres
```
