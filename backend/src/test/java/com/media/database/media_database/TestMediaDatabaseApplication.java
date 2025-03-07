package com.media.database.media_database;

import org.springframework.boot.SpringApplication;

public class TestMediaDatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.from(MediaDatabaseApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
