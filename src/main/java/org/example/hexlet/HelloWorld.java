package org.example.hexlet;
import io.javalin.Javalin;

public class HelloWorld {
    public static void main(String[] args) {
        // Создаем приложение
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });
        // Описываем, что загрузится по адресу /
        app.get("/hello", ctx ->{
            String name = ctx.queryParam("name");
            if (null != name) {
                ctx.result("Hello " + name);
            } else {
                ctx.result("Hello World");
            }
//            ctx.result(ctx.fullUrl());
        });
        app.start(7070); // Стартуем веб-сервер
    }
}